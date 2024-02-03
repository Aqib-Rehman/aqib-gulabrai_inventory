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
import java.awt.Font;
import java.util.*;
import java.text.*;


public class ReportReceiptBill implements Printable{

   String heading = "";
    Date d = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy(hh:mm a)");
    String date = format.format(d);
    int startY = 50;
    String customerName = "----";
    String bearer = "---";
    String transactionType = "---";
    String termsCondition = "---";
    ArrayList transList;

  public ReportReceiptBill(String customer,String bearer, String transType, String termCond , ArrayList list) {
       this.customerName = customer;
       this.bearer = bearer;
       this.transactionType = transType;
       this.termsCondition = termCond;
       this.transList = list;
       this.heading = "RECEIPT"/*termCond+" BILL"*/;
  }

   public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if(pageIndex > 0){
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D)graphics;
        Font font = new Font("helvetica",Font.TRUETYPE_FONT,14);
        g2d.setFont(font);

        double headingLen = g2d.getFontMetrics().getStringBounds(heading, g2d).getWidth();
        float headingHeight = (float)g2d.getFontMetrics().getStringBounds(heading, g2d).getHeight();
        double start = (pageFormat.getWidth()/2) - (headingLen/2);
        g2d.drawString(setSpacing(heading), (float)start, startY);

        g2d.drawString(setSpacing("Date:"+date), (float)start+100, startY);
        g2d.drawLine(0, (int)startY+(int)headingHeight , (int)pageFormat.getWidth(), (int)startY+(int)headingHeight );

        g2d.drawString(setSpacing("Customer: "+CamelCased.camelCase(customerName) ), 50 , (int)startY+(int)headingHeight+15);
        g2d.drawString(setSpacing("Bearer: "+bearer), (int)((int)pageFormat.getWidth() - (g2d.getFontMetrics().getStringBounds(setSpacing("Bearer:         "+bearer), g2d).getWidth())), (int)startY+(int)headingHeight+15);
        g2d.drawLine(0,(int)startY+(int)headingHeight+40 , (int)pageFormat.getWidth(),(int)startY+(int)headingHeight+40 );

        int transactionY = (int)startY+(int)headingHeight+60;
        int productX = 50;
        int rateX = (int)start+10;
        int quantityX = (int)start+100;
        int valueX = (int)start+200;
        boolean isDebit = false;

        g2d.drawString(setSpacing("Cash/Product Name"), productX, transactionY);
        g2d.drawString(setSpacing("Rate"), rateX, transactionY);
        g2d.drawString(setSpacing("Quanity"), quantityX, transactionY);
        g2d.drawString(setSpacing("Value"), valueX, transactionY);

        int totalBillAmount = 0;

        for(int i =0;i<transList.size();i++){
          transactionY+=15;
          TransactionBillRecord rec= (TransactionBillRecord)transList.get(i);
          g2d.drawString(setSpacing(CamelCased.camelCase((i+1)+". "+rec.productName)), productX, transactionY);
          g2d.drawString(setSpacing(rec.rate), rateX, transactionY);
          g2d.drawString(setSpacing(rec.quantity), quantityX, transactionY);
          if(rec.productName.indexOf("CHEQU")>-1){ termsCondition = "Cheque"; }
          else if(rec.productName.indexOf("CASH")>-1){ termsCondition = "Cash"; }

          if(rec.productName.toLowerCase().indexOf("(d)")>-1 || rec.productName.toLowerCase().indexOf("debit")>-1){
            isDebit = true;
          }
          try{
            double total = Double.parseDouble(rec.totalAmount);
            g2d.drawString(setSpacing(""+total), valueX, transactionY);
            totalBillAmount+=total;
          }catch(Exception ex){
            g2d.drawString(setSpacing(rec.totalAmount), valueX, transactionY);
            ex.printStackTrace();}
        }


        System.out.println(transactionType);
        if(termsCondition.toLowerCase().indexOf("cash")>-1){
          System.out.println("Entered in first IF");
          if(isDebit){
            transactionType = "Debit";
            System.out.println("Entered in second IF");
          }
        }
        g2d.drawString(setSpacing("Transaction Type: "+CamelCased.camelCase(transactionType) ), 50, (int)startY+(int)headingHeight+30);
        g2d.drawString(setSpacing("Terms Comndition: "+CamelCased.camelCase(termsCondition) ), (int)((int)pageFormat.getWidth() - (g2d.getFontMetrics().getStringBounds(setSpacing("Terms Comndition:         "+termsCondition), g2d).getWidth())), (int)startY+(int)headingHeight+30);


        transactionY+=15;
        g2d.drawLine(0,transactionY,(int)pageFormat.getWidth(),transactionY);

        transactionY+=20;
        g2d.drawString(setSpacing("Total"), quantityX, transactionY);
        g2d.drawString(setSpacing(""+totalBillAmount) , valueX, transactionY);


        g2d.drawString(setSpacing("Amount in words:"), productX-10, transactionY);

        transactionY+=15;
        g2d.drawString(setSpacing(NumberToWord.numberToWords(totalBillAmount).trim()),productX-10, transactionY);

        transactionY+=15;
        g2d.drawString(setSpacing("This is a computer generated receipt and does not need any signature"), productX-10, transactionY);

        return PAGE_EXISTS;
    }


    public static void printBill(String customer,String bearer, String transType, String termCond , ArrayList list) throws PrinterException{
        PrinterJob job = PrinterJob.getPrinterJob();

        Book book = new Book();
        Paper paper = new Paper();
        PageFormat format =getPageFormate(paper);
        book.append(new ReportReceiptBill(customer,bearer, transType,termCond ,list), format);

        job.setPageable(book);
        if(job.printDialog())job.print();
    }


     protected static PageFormat getPageFormate(Paper paper){

     int LEFT_MARGIN = 10;
     int TOP_MARGIN = 10;

     PageFormat pageFormat = new PageFormat ();
     paper.setSize(PageSetupInterface.PAPER_WIDTH_A5,
                   PageSetupInterface.PAPER_HEIGHT_A5);

     System.out.println("PAPER_HEIGHT_A5: "+PageSetupInterface.PAPER_HEIGHT_A5+" - paper.getHeight():"+paper.getHeight());
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