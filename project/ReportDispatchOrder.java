package project;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.BasicStroke;
import java.util.ArrayList;
import java.awt.Font;
import java.util.*;
import java.text.*;

public class ReportDispatchOrder implements Printable{

    String heading = "-------------   DUPLICATE -----------------";
    String heading2 = "DISPATCH ORDER";
    Date d = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy(hh:mm a)");
    String date = format.format(d);
    int startY = 20;
    String customerName = "XXXX XXXXX XXXXX";
    String bearer = "XXXXXX";
    String transactionType = "XXXXXX";
    int transactionId;
    String termsCondition = "Cash";
    ArrayList transList = new ArrayList();
    boolean dispatch = true;

    public ReportDispatchOrder(int transactionId,String customer,String bearer, String transType, String termCond , ArrayList list,String head){
      this.transactionId = transactionId;
      this.customerName = customer;
      this.bearer = bearer;
      this.transactionType = transType;
      this.termsCondition = termCond;
      this.transList = list;
      this.heading = head;
    }

    //@Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if(pageIndex > 0){
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D)graphics;
        Font font = new Font("helvetica",Font.TRUETYPE_FONT,12);
        g2d.setFont(font);

        double centerX = pageFormat.getWidth()/2 + 10;
        double headingWidth = g2d.getFontMetrics().getStringBounds(heading, g2d).getWidth();
        double heading2Width = g2d.getFontMetrics().getStringBounds(heading2, g2d).getWidth();
        float headingHeight = (float)g2d.getFontMetrics().getStringBounds(heading, g2d).getHeight();
        double start = 15;

//        if(dispatch){
//          System.out.println("H2: "+heading2);
//          g2d.drawString(setSpacing(heading2), (float)start, startY);
//          dispatch = false;
//        }else{
          System.out.println("H: "+heading);
          g2d.drawString(setSpacing(heading),(int) ((float)centerX - (g2d.getFontMetrics().getStringBounds(heading,g2d).getWidth() / 2))-40 , startY);
//        }
//        g2d.drawString(setSpacing(heading2), (float)centerX, startY);
        //font = new Font ("helvetica", Font.PLAIN, 8);
        //g2d.setFont (font);
        float dash1[] = {5.0f};
        BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
        g2d.setStroke(dashed);

        //g2d.drawString(setSpacing("Transaction:"+this.transactionId), (int) (headingWidth+start+20), startY);
        //g2d.drawString(setSpacing("Transaction:"+this.transactionId), (int) (heading2Width+centerX+20), startY);

        g2d.drawLine(0, (int)startY+(int)headingHeight , (int)pageFormat.getWidth(), (int)startY+(int)headingHeight );

        int transactionY = (int)startY+(int)headingHeight+60;

        String customer = setSpacing("Customer: "+CamelCased.camelCase(customerName) );
        double sizeOfCustomer = g2d.getFontMetrics().getStringBounds(customer,g2d).getWidth();
        //System.out.println("<><>< Size Customer: "+sizeOfCustomer + " - centerX: "+centerX);
//        if(sizeOfCustomer>270){
//          int index = customer.indexOf("  ",40);
//          String startCustomer = customer.substring(0, index);
//          String endCustomer = customer.substring(index);
//          g2d.drawString(startCustomer, 20          , (int)startY+(int)headingHeight+15);
//          g2d.drawString(endCustomer, 20            , (int)startY+(int)headingHeight+30);
//
//          g2d.drawString(startCustomer, (int)centerX, (int)startY+(int)headingHeight+15);
//          g2d.drawString(endCustomer, (int)centerX, (int)startY+(int)headingHeight+30);
//
//          g2d.drawString(setSpacing("Date: "+date ), 20, (int)startY+(int)headingHeight+45);
//          g2d.drawString(setSpacing("Date: "+date ), (int)centerX, (int)startY+(int)headingHeight+45);
//          g2d.drawLine(0,(int)startY+(int)headingHeight+50 , (int)pageFormat.getWidth(),(int)startY+(int)headingHeight+50 );
//          transactionY+=15;
//        }else
//        {
          g2d.drawString(customer, 20 , (int)startY+(int)headingHeight+15);
          //g2d.drawString(customer, (int)centerX, (int)startY+(int)headingHeight+15);
          g2d.drawString(setSpacing("Date: "+date ), 20, (int)startY+(int)headingHeight+30);
          //g2d.drawString(setSpacing("Date: "+date ), (int)centerX, (int)startY+(int)headingHeight+30);
          g2d.drawLine(0,(int)startY+(int)headingHeight+40 , (int)pageFormat.getWidth(),(int)startY+(int)headingHeight+40 );
//        }

        //int transactionY = (int)startY+(int)headingHeight+60;
        int productX = 150;
        int transactionX = 20;
        double qtyWidth = g2d.getFontMetrics().getStringBounds("Qty        ", g2d).getWidth();
        int quantityX = (int)pageFormat.getWidth() - 150;

        font = new Font("helvetica",Font.TRUETYPE_FONT,14);
        g2d.setFont(font);


        g2d.drawString(setSpacing("Trasn.No"), transactionX, transactionY);
        g2d.drawString(setSpacing("Product Name"), productX, transactionY);
        g2d.drawString(setSpacing("Qty"), quantityX , transactionY);

//        g2d.drawString(setSpacing("Trasn.No"), (int)centerX, transactionY);
//        g2d.drawString(setSpacing("Product Name"), (int) centerX+70, transactionY);
//        g2d.drawString(setSpacing("Qty"), (int) (pageFormat.getWidth() - qtyWidth) -30, transactionY);

        int totalBillAmount = 0;

        for(int i =0;i<transList.size();i++){
          transactionY+=20;
          TransactionBillRecord rec= (TransactionBillRecord)transList.get(i);
          if(rec.productName.trim().toLowerCase().indexOf("cash") > -1 )continue;
          g2d.drawString(setSpacing(rec.transactionId), (int) transactionX, transactionY);
          g2d.drawString(setSpacing(CamelCased.camelCase(rec.productName) ), productX, transactionY);
          g2d.drawString(setSpacing(rec.quantity), quantityX, transactionY);

//          font = new Font("helvetica",Font.TRUETYPE_FONT,10);
//          g2d.setFont(font);
//          g2d.drawString(setSpacing(rec.transactionId), (int) centerX, transactionY);
//          font = new Font("helvetica",Font.TRUETYPE_FONT,12);
//          g2d.setFont(font);
//
//          g2d.drawString(setSpacing(CamelCased.camelCase(rec.productName)), (int) centerX+70, transactionY);
//          g2d.drawString(setSpacing(rec.quantity), (int) (pageFormat.getWidth() - qtyWidth) - 30, transactionY);

          try{
            double quantity = Double.parseDouble(rec.quantity);
            totalBillAmount+=quantity;
          }catch(Exception ex){
            ex.printStackTrace();
          }

        }
        font = new Font("Times New Roman",Font.TRUETYPE_FONT,12);
        g2d.setFont(font);

        transactionY+=15;
        g2d.drawRect(20, transactionY,(int) pageFormat.getWidth()-20,20);
        //g2d.drawLine((int) centerX-10, transactionY, (int) centerX-10, transactionY+20);

        transactionY+=15;
        String total = NumberToWord.numberToWords(totalBillAmount);
        g2d.drawString(setSpacing("Total Qty in words:"+total), transactionX, transactionY+2);
        //g2d.drawString(setSpacing("Total Qty in words:"+total), (int) centerX, transactionY+2);

        transactionY+=40;
        String sign = "Signature Of Issuer";
        float signX = (float) (pageFormat.getWidth() - g2d.getFontMetrics().getStringBounds(sign, g2d).getWidth())-40;
        if(heading.toLowerCase().indexOf("dispatch") > -1 )g2d.drawString(setSpacing(sign), (int)centerX+20 , transactionY);
        return PAGE_EXISTS;
    }

    public static void printDispatch(int transactionId,String customer,String bearer, String transType, String termCond , ArrayList list,String heading)throws Exception{
        PrinterJob job = PrinterJob.getPrinterJob();
        Book book = new Book();
        Paper paper = new Paper();
        PageFormat format = getPageFormate(paper);
        book.append(new ReportDispatchOrder(transactionId, customer, bearer,transType,termCond,list,heading), format);
        job.setPageable(book);
        if(job.printDialog()){
            job.print();
        }
    }

    protected static PageFormat getPageFormate(Paper paper){

     int LEFT_MARGIN = 10;
     int TOP_MARGIN = 10;

     PageFormat pageFormat = new PageFormat ();
     paper.setSize(PageSetupInterface.PAPER_WIDTH_A5,
                   PageSetupInterface.PAPER_HEIGHT_A5);

     //paper.setSize(72*8.5 , 72*5.3);
     paper.setImageableArea(LEFT_MARGIN,
                            TOP_MARGIN,
                            paper.getWidth() -(PageSetupInterface.LEFT_MARGIN + PageSetupInterface.RIGHT_MARGIN),
                            paper.getHeight()-(PageSetupInterface.TOP_MARGIN + PageSetupInterface.BOTTOM_MARGIN));

     pageFormat.setPaper(paper);
     pageFormat.setOrientation ( PageSetupInterface.LANDSCAPE ? PageFormat.LANDSCAPE : PageFormat.PORTRAIT);
     //pageFormat.setOrientation (PageFormat.LANDSCAPE);

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
