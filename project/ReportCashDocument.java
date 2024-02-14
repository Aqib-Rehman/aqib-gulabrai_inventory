package project;
import java.awt.*;
import java.awt.print.*;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */


public class ReportCashDocument implements Printable{
  private boolean b=false;
  private CashBookRecord cashBookRecords[];
  private int pageNo;
  private boolean IS_LAST_PAGE;

  private String TOTAL_CREDIT_AMOUNT;
  private String TOTAL_DEBIT_AMOUNT;
  private String BALANCE;
  private String CASH_IN_HAND;
  private String DATE_FROM;
  private String DATE_TO;

  private String HEADING2;


  private static int LEFT=1;
  private static int RIGHT=2;
  private static int CENTER=3;
  private static int CENTER_LEFT=4;
  private int TOTAL_PAGE;

  public ReportCashDocument(CashBookRecord cashBookRecords[], int pageNo,boolean IS_LAST_PAGE,String creditAmountStr, String debitAmountStr, String balanceStr, String cashInHandStr,String dateFrom,String dateTo,String HEADING2,int TOTAL_PAGE) {
     this.cashBookRecords=cashBookRecords;
     this.pageNo=pageNo;
     this.IS_LAST_PAGE=IS_LAST_PAGE;

     this.TOTAL_CREDIT_AMOUNT=creditAmountStr;
     this.TOTAL_DEBIT_AMOUNT=debitAmountStr;
     this.BALANCE=balanceStr;
     this.CASH_IN_HAND=cashInHandStr;
     this.DATE_FROM=dateFrom;
     this.DATE_TO=dateTo;
     this.HEADING2=HEADING2;
     this.TOTAL_PAGE=TOTAL_PAGE;
  }

  public int print (Graphics g, PageFormat pageFormat, int page) {
   if(!b){
     b=true;
     return this.PAGE_EXISTS;
   }

  Graphics2D g2d = (Graphics2D) g;
  g2d.translate (pageFormat.getImageableX (), pageFormat.getImageableY ());
  g2d.setPaint (Color.black);


  //String HEADING1="Gulab-Rai Mukhi Mengho Mal Commission Agent-Sinjhoro";
//  String HEADING2="CASH BOOK";

  String BOTTOM1="COMPUTER PROGRAMMER";
  String BOTTOM2="CONCERNED CLERK";
  String BOTTOM3="MANAGING DIRECTOR";

  String TOTAL_CREDIT_AMOUNT_LABEL="CREDIT AMOUNT: ";
  String TOTAL_DEBIT_AMOUNT_LABEL="DEBIT AMOUNT: ";
  String BALANCE_LABEL="BALANCE: ";
  String CASH_IN_HAND_LABEL="CASH IN HAND: ";
  String DATE_FROM_LABEL="DATE: ";
  String DATE_TO_LABEL="TO ";

  String PAGE_NO_LABEL="PAGE NO.";
  String S_NO_LABEL="S.NO.";

  String CREDIT_CUSTOMER_NAME_LABEL="CUSTOMER NAME";
  String CREDIT_AMOUNT_LABEL="CREDIT";

  String DEBIT_CUSTOMER_NAME_LABEL="CUSTOMER NAME";
  String DEBIT_AMOUNT_LABEL="DEBIT";

  String NOTE_LABEL="NOTE :-";
  String NOTE="It is a computer generated report which doesn't require any signature.";

  int y=(int)(pageFormat.getImageableY()+(72*0.5));

 /******************************************************/
//  Font font = new Font ("helvetica", Font.BOLD, 16);
//  g2d.setFont(font);
//  FontMetrics fontMetrics = g2d.getFontMetrics ();
//  double center_x=fontMetrics.stringWidth(HEADING1)/2;
//  center_x=pageFormat.getImageableWidth()/2-center_x;
//  g2d.drawString (HEADING1,(int)center_x,y);
 /******************************************************/
  Font font = new Font ("helvetica", Font.BOLD, 14);
  g2d.setFont(font);
  FontMetrics fontMetrics = g2d.getFontMetrics ();

  y+=fontMetrics.getHeight();
  double center_x=fontMetrics.stringWidth(HEADING2)/2;
  center_x=pageFormat.getImageableWidth()/2-center_x;
  g2d.drawString (HEADING2,(int)center_x,y);
 /******************************************************/
 /******************************************************/
  font = new Font ("helvetica", Font.PLAIN, 8);
  g2d.setFont (font);
  fontMetrics = g2d.getFontMetrics ();

  g2d.drawString (PAGE_NO_LABEL,(int)DataMarginInterface.PAGE_NO_LEFT_ALIGN,y);
  g2d.drawString (String.valueOf(pageNo),(int)DataMarginInterface.PAGE_NO_LEFT_ALIGN+fontMetrics.stringWidth(PAGE_NO_LABEL)+3,y);
 /******************************************************/

  y+=fontMetrics.getHeight();
 if(DATE_TO!=null && DATE_TO.trim().equals(""))DATE_TO=null;
 if(DATE_FROM!=null && DATE_FROM.trim().equals(""))DATE_FROM=null;


 int x=0;
if(DATE_FROM!=null){
  y+=fontMetrics.getHeight();
  /******************************************************/
  font = new Font ("helvetica", Font.BOLD, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();
  g2d.drawString (DATE_FROM_LABEL,0,y);
 /******************************************************/
 /******************************************************/
  font = new Font ("helvetica", Font.PLAIN, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();
  x=fontMetrics.stringWidth(DATE_FROM_LABEL)+5;
  g2d.drawString (DATE_FROM,x,y);
 /******************************************************/
  x+=fontMetrics.stringWidth(DATE_FROM)+5;
}//end if

if(DATE_TO!=null){
 /******************************************************/
  font = new Font ("helvetica", Font.BOLD, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();
  g2d.drawString (DATE_TO_LABEL,x,y);
 /******************************************************/
 /******************************************************/
  font = new Font ("helvetica", Font.PLAIN, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();
  x+=fontMetrics.stringWidth(DATE_TO_LABEL)+5;
  g2d.drawString (DATE_TO,x,y);
 /******************************************************/
}//end if

  y+=fontMetrics.getHeight();
  y+=fontMetrics.getHeight();

 /******************************************************/
  font = new Font ("helvetica", Font.BOLD, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();
 /******************************************************/
 if(cashBookRecords.length!=0){
  g2d.drawString (S_NO_LABEL,(int)DataMarginInterface.S_NO_LEFT_ALIGN,y);
  g2d.drawString (CREDIT_CUSTOMER_NAME_LABEL,(int)DataMarginInterface.CREDIT_CUSTOMER_NAME_LEFT_ALIGN,y);
  g2d.drawString (CREDIT_AMOUNT_LABEL,(int)DataMarginInterface.CREDIT_AMOUNT_LEFT_ALIGN,y);
  g2d.drawString (DEBIT_CUSTOMER_NAME_LABEL,(int)DataMarginInterface.DEBIT_CUSTOMER_NAME_LEFT_ALIGN,y);
  g2d.drawString (DEBIT_AMOUNT_LABEL,(int)DataMarginInterface.DEBIT_AMOUNT_LEFT_ALIGN ,y);
 }

 /******************************************************/
   y+=fontMetrics.getHeight();
 /******************************************************/

  font = new Font ("helvetica", Font.PLAIN, 9);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();

  for(int i=0; i<cashBookRecords.length; i++){

    String S_NO=cashBookRecords[i].sno;
    String CREDIT_CUSTOMER_NAME=cashBookRecords[i].getCrditCustomer();
    String CREDIT_AMOUNT=cashBookRecords[i].getCrditAmount();
    String DEBIT_CUSTOMER_NAME=cashBookRecords[i].getDebitCustomer();
    String DEBIT_AMOUNT=cashBookRecords[i].getDebitAmount();

    y+=fontMetrics.getHeight();
    int CREDIT_AMOUNT_LEFT_ALIGN =getAlignment(CREDIT_AMOUNT_LABEL,CREDIT_AMOUNT,(int)DataMarginInterface.CREDIT_AMOUNT_LEFT_ALIGN, RIGHT,fontMetrics);
    int DEBIT_AMOUNT_LEFT_ALIGN  =getAlignment(DEBIT_AMOUNT_LABEL,DEBIT_AMOUNT,(int)DataMarginInterface.DEBIT_AMOUNT_LEFT_ALIGN, RIGHT,fontMetrics);

    int S_NO_ALIGN      =getAlignment(S_NO_LABEL,S_NO,(int)DataMarginInterface.S_NO_LEFT_ALIGN, CENTER,fontMetrics);

    if(CREDIT_CUSTOMER_NAME.length()>35)CREDIT_CUSTOMER_NAME=CREDIT_CUSTOMER_NAME.substring(0,35);
    if(DEBIT_CUSTOMER_NAME.length()>35)DEBIT_CUSTOMER_NAME=DEBIT_CUSTOMER_NAME.substring(0,35);

    g2d.drawString (S_NO,S_NO_ALIGN,y);
    g2d.drawString (CREDIT_CUSTOMER_NAME,(int)DataMarginInterface.CREDIT_CUSTOMER_NAME_LEFT_ALIGN,y);
    g2d.drawString (CREDIT_AMOUNT,CREDIT_AMOUNT_LEFT_ALIGN,y);
    g2d.drawString (DEBIT_CUSTOMER_NAME,(int)DataMarginInterface.DEBIT_CUSTOMER_NAME_LEFT_ALIGN,y);
    g2d.drawString (DEBIT_AMOUNT,DEBIT_AMOUNT_LEFT_ALIGN,y);
  }//end for loop

  y+=fontMetrics.getHeight();
  y+=fontMetrics.getHeight();

  font = new Font ("helvetica", Font.BOLD, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();

  if(IS_LAST_PAGE){
    if(TOTAL_CREDIT_AMOUNT.equals("0"))TOTAL_CREDIT_AMOUNT="Nil";
    if(TOTAL_DEBIT_AMOUNT.equals("0"))TOTAL_DEBIT_AMOUNT="Nil";

    if(BALANCE==null)BALANCE="Nil";
    if(CASH_IN_HAND==null)CASH_IN_HAND="Nil";

    if(BALANCE.equals("")){BALANCE="";BALANCE_LABEL="";}
    if(CASH_IN_HAND.equals("")){CASH_IN_HAND="";CASH_IN_HAND_LABEL="";}

    y+=fontMetrics.getHeight();
    g2d.drawString (TOTAL_CREDIT_AMOUNT_LABEL,0,y);
    g2d.drawString (TOTAL_CREDIT_AMOUNT,fontMetrics.stringWidth(TOTAL_CREDIT_AMOUNT_LABEL)+3,y);

    y+=fontMetrics.getHeight();
    g2d.drawString (TOTAL_DEBIT_AMOUNT_LABEL,0,y);
    g2d.drawString (TOTAL_DEBIT_AMOUNT,fontMetrics.stringWidth(TOTAL_DEBIT_AMOUNT_LABEL)+3,y);

    y+=fontMetrics.getHeight();
    g2d.drawString (BALANCE_LABEL,0,y);
    g2d.drawString (BALANCE,fontMetrics.stringWidth(BALANCE_LABEL)+3,y);

    y+=fontMetrics.getHeight();
    g2d.drawString (CASH_IN_HAND_LABEL,0,y);
    g2d.drawString (CASH_IN_HAND,fontMetrics.stringWidth(CASH_IN_HAND_LABEL)+3,y);

    y+=fontMetrics.getHeight();
    y+=fontMetrics.getHeight();
    y+=fontMetrics.getHeight();
    g2d.drawString (NOTE_LABEL+NOTE,(int)DataMarginInterface.BOTTOM1_LEFT_ALIGN,y);
  }else{
  font = new Font ("helvetica", Font.BOLD+Font.ITALIC, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();

//  y+=fontMetrics.getHeight();
  y+=fontMetrics.getHeight();
  center_x=fontMetrics.stringWidth("Continue to next page...")/2;
  center_x=pageFormat.getImageableWidth()/2-center_x;
  g2d.drawString ("Continue to next page...",(int)center_x,y);

}//end if

if(TOTAL_PAGE>1){
  y+=fontMetrics.getHeight();
  String pageStr="Page "+pageNo+" of "+TOTAL_PAGE;

  center_x=fontMetrics.stringWidth(pageStr)/2;
  center_x=pageFormat.getImageableWidth()/2-center_x;
  g2d.drawString (pageStr,(int)center_x,y);
}


 /******************************************************/
//   g2d.drawString (BOTTOM1,(int)DataMarginInterface.BOTTOM1_LEFT_ALIGN,(int)DataMarginInterface.BOTTOM1_TOP_ALIGN);
//   g2d.drawString (BOTTOM2,(int)DataMarginInterface.BOTTOM2_LEFT_ALIGN,(int)DataMarginInterface.BOTTOM2_TOP_ALIGN);
//   g2d.drawString (BOTTOM3,(int)DataMarginInterface.BOTTOM3_LEFT_ALIGN,(int)DataMarginInterface.BOTTOM3_TOP_ALIGN);
 /******************************************************/

   b=false;
   return this.PAGE_EXISTS;
  }//end method

  private int getAlignment(String label,String data,int LEFT_ALIGN,int align,FontMetrics fontMetrics){

  if(align==RIGHT){
         int LABEL_WIDTH=fontMetrics.stringWidth(label);
         int DATA_WIDTH=fontMetrics.stringWidth(data);
         int X_ALIGN=(LEFT_ALIGN+LABEL_WIDTH)-DATA_WIDTH;
         return X_ALIGN;
  }
 else if(align==CENTER){
         int LABEL_WIDTH=fontMetrics.stringWidth(label)/2;
         int DATA_WIDTH=fontMetrics.stringWidth(data)/2;
         int X_ALIGN=(LEFT_ALIGN+LABEL_WIDTH)-DATA_WIDTH;
         return X_ALIGN;
  }
 else if(align==CENTER_LEFT){
         int LABEL_WIDTH=fontMetrics.stringWidth(label)/2;
         int X_ALIGN=(LEFT_ALIGN+LABEL_WIDTH);
         return X_ALIGN;
  }
  else
    return LEFT_ALIGN;
 }//END METHOD
}//end class
