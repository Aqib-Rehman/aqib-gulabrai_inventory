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
import java.util.*;
import java.text.*;

public class ReportReceipt implements Printable{

    String heading = "RECIEPT";
    Date d = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy(hh:mm a)");
    String date = format.format(d);
    int startY = 50;
    String customerName = "----";
    String bearer = "---";
    String transactionType = "---";
    int transactionNo;
    String termsCondition = "---";
    int total;

  public ReportReceipt(int trNo, String customer,String bearer, String transType, String termCond, int tot) {
       this.customerName = customer;
       this.bearer = bearer;
       this.transactionType = transType;
       this.termsCondition = termCond;
       this.total = tot;
       this.transactionNo = trNo;
  }

  public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if(pageIndex > 0){
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D)graphics;
        //g2d.setFont(new Font("Arial", Font.BOLD,20));

        double headingLen = g2d.getFontMetrics().getStringBounds(heading, g2d).getWidth();
        float headingHeight = (float)g2d.getFontMetrics().getStringBounds(heading, g2d).getHeight();
        double start = (pageFormat.getWidth()/2) - (headingLen/2);
        g2d.drawString(heading, (float)start, startY);

        g2d.drawString("Date:"+date, (float)start+150, startY);
        g2d.drawLine(0, (int)startY+(int)headingHeight , (int)pageFormat.getWidth(), (int)startY+(int)headingHeight );

        g2d.drawString("Customer: "+customerName, 50 , (int)startY+(int)headingHeight+15);
        g2d.drawString("Bearer: "+bearer, (int)((int)pageFormat.getWidth() - (g2d.getFontMetrics().getStringBounds("Bearer:         "+bearer, g2d).getWidth())), (int)startY+(int)headingHeight+15);
        g2d.drawString("Transaction Type: "+transactionType, 50, (int)startY+(int)headingHeight+30);
        g2d.drawString("Terms Comndition: "+termsCondition, (int)((int)pageFormat.getWidth() - (g2d.getFontMetrics().getStringBounds("Terms Comndition:         "+termsCondition, g2d).getWidth())), (int)startY+(int)headingHeight+30);
        g2d.drawString("Transaction No."+transactionNo,50,(int)startY+(int)headingHeight+50);
        g2d.drawLine(0,(int)startY+(int)headingHeight+55 , (int)pageFormat.getWidth(),(int)startY+(int)headingHeight+55 );

        int transactionY = (int)startY+(int)headingHeight+60;
        g2d.drawRect(20,transactionY,(int)pageFormat.getWidth()-20,30);

        g2d.drawLine((int)pageFormat.getWidth()/2,transactionY,(int)pageFormat.getWidth()/2,transactionY+30);
        transactionY+=20;
        g2d.drawString("Amount in words:"+NumberToWord.numberToWords(total).trim(), 30, transactionY);
        g2d.drawString("Total: "+total,(int)pageFormat.getWidth()/2 +20 , transactionY);

        transactionY+=60;
        String sign = "Signature Of Issuer";
        float signX = (float) (pageFormat.getWidth() - g2d.getFontMetrics().getStringBounds(sign, g2d).getWidth())-20;
        g2d.drawString(sign, signX , transactionY);

        return PAGE_EXISTS;
    }


    public static void printReceipt(int trNo,String customer,String bearer, String transType, String termCond, int tot) throws PrinterException{
        PrinterJob job = PrinterJob.getPrinterJob();

        Book book = new Book();
        Paper paper = new Paper();
        PageFormat format = ReportFrame.getPageFormate(paper);
        book.append(new ReportReceipt(trNo , customer,bearer, transType,termCond, tot), format);

        job.setPageable(book);
        if(job.printDialog())job.print();
    }


}