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

public class ReportCashTransactionDocument implements Printable{
  private boolean b=false;
  private TransactionRecord transactionRecords[];
  private int pageNo;
  boolean IS_LAST_PAGE;

  private static int LEFT=1;
  private static int RIGHT=2;
  private static int CENTER=3;
  private static int CENTER_LEFT=4;
  private int TOTAL_PAGE;
  private int credit,debit;

  private String DATE_FROM;
  private String DATE_TO;
  private String CUSTOMER_NAME;

  public ReportCashTransactionDocument(TransactionRecord transactionRecords[], int pageNo,boolean IS_LAST_PAGE,  int TOTAL_PAGE,int credit,int debit,String DATE_FROM,String DATE_TO,String CUSTOMER_NAME) {
     this.transactionRecords=transactionRecords;
     this.pageNo=pageNo;
     this.IS_LAST_PAGE=IS_LAST_PAGE;
      this.TOTAL_PAGE=TOTAL_PAGE;
     this.credit=credit;
     this.debit=debit;
     this.DATE_FROM=DATE_FROM;
     this.DATE_TO=DATE_TO;
     this.CUSTOMER_NAME=CUSTOMER_NAME;
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
  String HEADING2="Customer Cash Transactions";

  String BOTTOM1="COMPUTER PROGRAMMER";
  String BOTTOM2="CONCERNED CLERK";
  String BOTTOM3="MANAGING DIRECTOR";

  String CREDIT_AMOUNT_LABEL="CREDIT AMOUNT: ";
  String DEBIT_AMOUNT_LABEL="DEBIT AMOUNT: ";
  String CURRENT_BALANCE_LABEL="CURRENT BALANCE: ";

  String PAGE_NO_LABEL="PAGE NO.";
  String S_NO_LABEL="S.NO.";
  String DEBIT_LABEL="DEBIT";
  String DATE_LABEL="DATE";
  String CREDIT_LABEL="CREDIT";
  String DESC_LABEL="DESCRIPTION";
  String BEARER_LABEL="BEARER";
  String DATE_FROM_LABEL="DATE";
  String DATE_TO_LABEL="TO";
  String CUSTOMER_NAME_LABEL="CUSTOMER NAME: ";


  String NOTE_LABEL="NOTE :-";
  String NOTE="It is a computer generated report which doesn't require any signature.";

  int y=(int)(pageFormat.getImageableY()+(72*0.5));
//  int y=(int)pageFormat.getImageableY();

 /******************************************************/
  Font font = new Font ("helvetica", Font.BOLD, 16);
  g2d.setFont(font);
  FontMetrics fontMetrics = g2d.getFontMetrics ();
//  double center_x=fontMetrics.stringWidth(HEADING1)/2;
//  center_x=pageFormat.getImageableWidth()/2-center_x;
//  g2d.drawString (HEADING1,(int)center_x,y);
 /******************************************************/

 /******************************************************/
  font = new Font ("helvetica", Font.BOLD, 14);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();

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
  /******************************************************/
  font = new Font ("helvetica", Font.BOLD, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();
  g2d.drawString (CUSTOMER_NAME_LABEL,0,y);
 /******************************************************/
 /******************************************************/
  font = new Font ("helvetica", Font.PLAIN, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();
  g2d.drawString (CUSTOMER_NAME,fontMetrics.stringWidth(CUSTOMER_NAME_LABEL)+3,y);
 /******************************************************/
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
 if(transactionRecords.length!=0){
  g2d.drawString (S_NO_LABEL,(int)DataMarginInterface.S_NO_LEFT_ALIGN,y);
  g2d.drawString (DEBIT_LABEL,(int)DataMarginInterface.DEBIT_LEFT_ALIGN,y);
  g2d.drawString (DATE_LABEL,(int)DataMarginInterface.DATE_LEFT_ALIGN,y);
  g2d.drawString (CREDIT_LABEL,(int)DataMarginInterface.CREDIT_LEFT_ALIGN,y);
  g2d.drawString (DESC_LABEL,(int)DataMarginInterface.DESC_LEFT_ALIGN ,y);
  g2d.drawString (BEARER_LABEL,(int)DataMarginInterface.BEARER_LEFT_ALIGN ,y);
 }

 /******************************************************/
   y+=fontMetrics.getHeight();
 /******************************************************/

  font = new Font ("helvetica", Font.PLAIN, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();

  for(int i=0; i<transactionRecords.length; i++){

    String S_NO=transactionRecords[i].sno;
    String AMOUNT=transactionRecords[i].amount;
    String DATE=transactionRecords[i].date_of_trans;
    String DEBIT_CREDIT=Decode.debitCreditDecode(transactionRecords[i].debit_credit);
    String DESC=transactionRecords[i].remarks;
    String BEARER=transactionRecords[i].bearer;

    y+=fontMetrics.getHeight();
    int S_NO_ALIGN      =getAlignment(S_NO_LABEL,S_NO,(int)DataMarginInterface.S_NO_LEFT_ALIGN, CENTER,fontMetrics);

    g2d.drawString (S_NO,S_NO_ALIGN,y);

  if(DEBIT_CREDIT.equals("DEBIT")){
      int DEBIT_ALIGN    =getAlignment(DEBIT_LABEL,AMOUNT,(int)DataMarginInterface.DEBIT_LEFT_ALIGN, RIGHT,fontMetrics);
      g2d.drawString (AMOUNT,DEBIT_ALIGN,y);
  }else{
      int AMOUNT_ALIGN    =getAlignment(CREDIT_LABEL,AMOUNT,(int)DataMarginInterface.CREDIT_LEFT_ALIGN, RIGHT,fontMetrics);
      g2d.drawString (AMOUNT,AMOUNT_ALIGN,y);
  }

    g2d.drawString (DATE,(int)DataMarginInterface.DATE_LEFT_ALIGN,y);
    g2d.drawString (DESC,(int)DataMarginInterface.DESC_LEFT_ALIGN ,y);
    g2d.drawString (BEARER,(int)DataMarginInterface.BEARER_LEFT_ALIGN ,y);
  }//end for loop

  y+=fontMetrics.getHeight();
  y+=fontMetrics.getHeight();

  font = new Font ("helvetica", Font.BOLD, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();

  if(IS_LAST_PAGE){

  String CREDIT_AMOUNT="Rs. "+ (credit==0 ? "Nil":""+credit);
  String DEBIT_AMOUNT="Rs. "+  (debit==0 ? "Nil":""+debit);

  String balance="Nil";

  if(credit>debit)balance=(credit-debit)+"/ CREDIT";
  if(debit>credit)balance=(debit-credit)+"/ DEBIT";

  String CURRENT_BALANCE="Rs. "+balance;



//    if(CREDIT_AMOUNT.equals("0"))CREDIT_AMOUNT="Nil";
//    if(DEBIT_AMOUNT.equals("0"))DEBIT_AMOUNT="Nil";
//    if(CURRENT_BALANCE==null)CURRENT_BALANCE="Nil";

    y+=fontMetrics.getHeight();
    g2d.drawString (CREDIT_AMOUNT_LABEL,0,y);
    g2d.drawString (CREDIT_AMOUNT,fontMetrics.stringWidth(CREDIT_AMOUNT_LABEL)+3,y);

    y+=fontMetrics.getHeight();
    g2d.drawString (DEBIT_AMOUNT_LABEL,0,y);
    g2d.drawString (DEBIT_AMOUNT,fontMetrics.stringWidth(DEBIT_AMOUNT_LABEL)+3,y);

    y+=fontMetrics.getHeight();
    g2d.drawString (CURRENT_BALANCE_LABEL,0,y);
    g2d.drawString (CURRENT_BALANCE,fontMetrics.stringWidth(CURRENT_BALANCE_LABEL)+3,y);

//    y+=fontMetrics.getHeight();
//    g2d.drawString (BALANCE_LABEL,0,y);
//    g2d.drawString (BALANCE,fontMetrics.stringWidth(BALANCE_LABEL)+3,y);

//    y+=fontMetrics.getHeight();
    y+=fontMetrics.getHeight();
    y+=fontMetrics.getHeight();
    g2d.drawString (NOTE_LABEL+NOTE,(int)DataMarginInterface.BOTTOM1_LEFT_ALIGN,y);
  }else{
  font = new Font ("helvetica", Font.BOLD+Font.ITALIC, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();

  y+=fontMetrics.getHeight();
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
