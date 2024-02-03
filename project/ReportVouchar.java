package project;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.Font;
import java.awt.BasicStroke;
import java.util.*;
import java.text.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JAY KUMAR
 */
public class ReportVouchar implements Printable{

    String heading = "VOUCHER";
    Date d = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy(hh:mm a)");
    String date = format.format(d);
    int startY = 50;
    String customerName = "----";
    String bearer = "---";
    String transactionType = "---";
    String termsCondition = "---";
    ArrayList transList;

    Graphics2D graphics2D;

    public ReportVouchar(String customer,String bearer, String transType, String termCond , ArrayList list){
        this.customerName = customer;
        this.bearer = bearer;
        System.out.println("Bearer: "+bearer);
        this.transactionType = transType;
        this.termsCondition = termCond;
        this.transList = list;
    }

    //@Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if(pageIndex > 0){
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D)graphics;
        graphics2D = g2d;
        Font font = new Font("helvetica",Font.TRUETYPE_FONT,14);
        g2d.setFont(font);

        double headingLen = g2d.getFontMetrics().getStringBounds(heading, g2d).getWidth();
        float headingHeight = (float)g2d.getFontMetrics().getStringBounds(heading, g2d).getHeight();
        double start = (pageFormat.getWidth()/2) - (headingLen/2);
        g2d.drawString(setSpacing(heading), (float)start-30, startY);

        //font = new Font ("Bitstream Vera Sans Mono", Font.PLAIN, 10);
        //g2d.setFont (font);

        g2d.drawString(setSpacing("Date:"+date), (float)start+60, startY);
        float dash1[] = {5.0f};
        BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
        g2d.setStroke(dashed);
        g2d.drawLine(0, (int)startY+(int)headingHeight , (int)pageFormat.getWidth(), (int)startY+(int)headingHeight );

        g2d.drawString(setSpacing("Customer: "+CamelCased.camelCase( customerName)), 20 , (int)startY+(int)headingHeight+15);
        g2d.drawString(setSpacing("Bearer: "+bearer), (int)((int)pageFormat.getWidth() - (g2d.getFontMetrics().getStringBounds(setSpacing("Bearer:         "+bearer), g2d).getWidth())), (int)startY+(int)headingHeight+15);
        g2d.drawString(setSpacing("Transaction Type: "+CamelCased.camelCase(transactionType) ), 20, (int)startY+(int)headingHeight+30);
        g2d.drawLine(0,(int)startY+(int)headingHeight+40 , (int)pageFormat.getWidth(),(int)startY+(int)headingHeight+40 );

        int transactionY = (int)startY+(int)headingHeight+60;
        int productX = 20;
        int rateX = (int)start+10;
        int quantityX = (int)start+90;
        int valueX = (int)start+200;


        g2d.drawString(setSpacing("Cash/Product Name"), productX, transactionY);
        g2d.drawString(setSpacing("Rate"), rateX, transactionY);
        g2d.drawString(setSpacing("Quantity"), quantityX, transactionY);
        g2d.drawString(setSpacing("Value"), valueX, transactionY);

        int totalBillAmount = 0;

        for(int i =0;i<transList.size();i++){
          transactionY+=15;
          TransactionBillRecord rec= (TransactionBillRecord)transList.get(i);
          System.out.println(">>>Transaction:"+rec.transactionId+" - "+rec.productName);
          if(rec.productName.indexOf("CHEQU") > -1){ termsCondition = "Cheque"; }
          else if(rec.productName.indexOf("CASH")> -1){ termsCondition = "Cash"; }
          g2d.drawString(setSpacing((i+1)+". "+CamelCased.camelCase(rec.productName)), productX, transactionY);
          g2d.drawString(setSpacing(rec.rate), rateX, transactionY);
          g2d.drawString(setSpacing(rec.quantity), quantityX, transactionY);
          try{
            double total = Double.parseDouble(rec.totalAmount);
            g2d.drawString(setSpacing(""+total), valueX, transactionY);
            totalBillAmount+=total;
          }catch(Exception ex){
            g2d.drawString(setSpacing(rec.totalAmount), valueX, transactionY);
            ex.printStackTrace();}
        }

        g2d.drawString(setSpacing("Terms Condition: "+CamelCased.camelCase(termsCondition) ), (int)((int)pageFormat.getWidth() - (g2d.getFontMetrics().getStringBounds(setSpacing("Terms Comndition:         "+termsCondition), g2d).getWidth())), (int)startY+(int)headingHeight+30);


        transactionY+=10;
        g2d.drawLine(0, transactionY , (int)pageFormat.getWidth(), transactionY );


        transactionY+=15;
        g2d.drawString(setSpacing("Total"), rateX, transactionY);
        g2d.drawString(setSpacing(""+totalBillAmount), valueX, transactionY);

        transactionY+=20;
        String amountInWords = setSpacing("Total Amount in words:"+NumberToWord.numberToWords(totalBillAmount).trim());
        double size = g2d.getFontMetrics().getStringBounds(amountInWords ,g2d).getWidth()  ;

        if(size > 540){
          int index = amountInWords.indexOf("  ",120);
          String startAmount = amountInWords.substring(0,index);
          String endAmount = amountInWords.substring(index);
          g2d.drawString( startAmount, 20, transactionY);
          transactionY+=15;
          g2d.drawString( endAmount, 20, transactionY);
        }else{
          g2d.drawString( amountInWords, 20, transactionY);
        }

        transactionY+=40;
        String sign = "Signature Of Receiver_____________________________________________";
        float signX = (float) (pageFormat.getWidth() - g2d.getFontMetrics().getStringBounds(sign, g2d).getWidth())-60;
        System.out.println(signX+":"+transactionY);
        g2d.drawString(setSpacing(sign),signX , transactionY);

        return PAGE_EXISTS;
    }


    public static void printVouchar(String customer,String bearer, String transType, String termCond , ArrayList list) throws PrinterException{
        ReportVouchar vouchar = new ReportVouchar(customer,bearer, transType,termCond ,list);

        PrinterJob job = PrinterJob.getPrinterJob();
        Book book = new Book();
        Paper paper = new Paper();
        PageFormat format = getPageFormate(paper);

        book.append(vouchar, format);

        job.setPageable(book);
        if(job.printDialog())job.print();
    }

     protected static PageFormat getPageFormate(Paper paper){

     int LEFT_MARGIN = 10;
     int TOP_MARGIN = 10;
     int RIGHT_MARGIN= 10;

     PageFormat pageFormat = new PageFormat ();
     paper.setSize(PageSetupInterface.PAPER_WIDTH_A5,
                   PageSetupInterface.PAPER_HEIGHT_A5);

     paper.setImageableArea(LEFT_MARGIN,
                            TOP_MARGIN,
                            paper.getWidth() -(PageSetupInterface.LEFT_MARGIN + PageSetupInterface.RIGHT_MARGIN),
                            paper.getHeight()-(PageSetupInterface.TOP_MARGIN + PageSetupInterface.BOTTOM_MARGIN));
     pageFormat.setPaper(paper);
     pageFormat.setOrientation ( PageSetupInterface.LANDSCAPE ? PageFormat.LANDSCAPE : PageFormat.PORTRAIT);
    return pageFormat;
  }

   private String setSpacing(String str){
    char[] chars = str.toCharArray();
    StringBuffer builder = new StringBuffer("");
    for(int i=0;i<chars.length;i++){
      char c = chars[i];
	  builder.append(c).append("");
    }
    return builder.toString();
  }

}
