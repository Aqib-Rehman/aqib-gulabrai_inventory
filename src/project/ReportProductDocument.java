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


public class ReportProductDocument implements Printable{
  private boolean b=false;

  private PurchaseSaleBookRecord purchaseSaleBookRec[];
  private ProductTransactionRecord productTransRec;
  private int pageNo;
  private boolean IS_LAST_PAGE;
  private boolean IS_PRODUCT_WISE;


  private static int LEFT=1;
  private static int RIGHT=2;
  private static int CENTER=3;
  private static int CENTER_LEFT=4;
  private  int TOTAL_PAGE;

  private int purchaseAmount;
  private double purchaseQuantity;

  private int saleAmount;
  private double saleQuantity;

  private int previousAmount;
  private double previousQuantity;




  private boolean isBoth;

  public ReportProductDocument(PurchaseSaleBookRecord purchaseSaleBookRec[],ProductTransactionRecord productTransRec,int pageNo,boolean IS_LAST_PAGE,boolean IS_PRODUCT_WISE, int TOTAL_PAGE,int purchaseAmount, double purchaseQuantity, int saleAmount, double saleQuantity,boolean isBoth,int previousAmount, double previousQuantity) {
     this.purchaseSaleBookRec=purchaseSaleBookRec;
     this.productTransRec=productTransRec;
     this.pageNo=pageNo;
     this.IS_LAST_PAGE=IS_LAST_PAGE;
     this.IS_PRODUCT_WISE=IS_PRODUCT_WISE;
     this.TOTAL_PAGE=TOTAL_PAGE;

     this.purchaseAmount=purchaseAmount;
     this.purchaseQuantity=purchaseQuantity;

     this.saleAmount=saleAmount;
     this.saleQuantity=saleQuantity;

     this.previousAmount=previousAmount;
     this.previousQuantity=previousQuantity;

     this.isBoth=isBoth;
  }//END METHOD

  public int print (Graphics g, PageFormat pageFormat, int page) {
   if(!b){
     b=true;
     return this.PAGE_EXISTS;
   }

  Graphics2D g2d = (Graphics2D) g;
  g2d.translate (pageFormat.getImageableX (), pageFormat.getImageableY ());
  g2d.setPaint (Color.black);


  //String HEADING1="Gulab-Rai Mukhi Mengho Mal Commission Agent-Sinjhoro";
  String HEADING2;//="Product/ Transactions";

  if(isBoth)
     HEADING2="INDIVIDUAL CUSTOMER INDIVIDUAL PRODUCT/ Transactions";
  else
  if(IS_PRODUCT_WISE)
     HEADING2="INDIVIDUAL PRODUCT FROM ALL CUSTOMERS/ Transactions";
  else
     HEADING2="INDIVIDUAL CUSTOMER FROM ALL PRODUCTS/ Transactions";


  String NOTE_LABEL="NOTE :-";
  String NOTE="It is a computer generated report which doesn't require any signature.";

  String PAGE_NO_LABEL="PAGE NO.";
  String S_NO_LABEL="S.NO.";

  String NAME_LABEL;
  if(isBoth)
     NAME_LABEL="";
  else
  if(IS_PRODUCT_WISE)
     NAME_LABEL="CUSTOMER";
  else
     NAME_LABEL="PRODUCT";

  String DATE_LABEL="DATE";
  String AMOUNT_LABEL="AMOUNT";
  String SALE_QUANTITY_LABEL="SALE QNTY";
  String PURCHASE_QUANTITY_LABEL="PURCH.QNTY";

  String DATE_FROM_LABEL="DATE";
  String DATE_TO_LABEL="TO";

  String DATE_FROM=productTransRec.dateFrom;
  String DATE_TO=  productTransRec.dateTo;

  int y=(int)pageFormat.getImageableY();

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

  double center_x=fontMetrics.stringWidth(HEADING2)/2;
  center_x=pageFormat.getImageableWidth()/2-center_x;
  g2d.drawString (HEADING2,(int)center_x,y);
 /******************************************************/
 /******************************************************/
  font = new Font ("helvetica", Font.PLAIN, 8);
  g2d.setFont (font);
  fontMetrics = g2d.getFontMetrics ();

  y+=fontMetrics.getHeight();
  g2d.drawString (PAGE_NO_LABEL,(int)DataMarginInterface.PAGE_NO_LEFT_ALIGN,y);
  g2d.drawString (String.valueOf(pageNo),(int)DataMarginInterface.PAGE_NO_LEFT_ALIGN+fontMetrics.stringWidth(PAGE_NO_LABEL)+3,y);
 /******************************************************/

  String PRODUCT_NAME_LABEL="";
  String CUSTOMER_NAME_LABEL="";

  if(isBoth){
     PRODUCT_NAME_LABEL="PRODUCT: "+productTransRec.product_name;
     CUSTOMER_NAME_LABEL="CUSTOMER: "+productTransRec.customer_name;
  }else
  if(IS_PRODUCT_WISE)
     PRODUCT_NAME_LABEL="PRODUCT: "+productTransRec.product_name;
  else
     CUSTOMER_NAME_LABEL="CUSTOMER: "+productTransRec.customer_name;

  y+=fontMetrics.getHeight();
  /******************************************************/
  font = new Font ("helvetica", Font.BOLD, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();
  if(isBoth){
     g2d.drawString (PRODUCT_NAME_LABEL,0,y);
     y+=fontMetrics.getHeight();
     g2d.drawString (CUSTOMER_NAME_LABEL,0,y);
  }else
  if(IS_PRODUCT_WISE)
  g2d.drawString (PRODUCT_NAME_LABEL,0,y);
  else
  g2d.drawString (CUSTOMER_NAME_LABEL,0,y);
 /******************************************************/
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
 if(purchaseSaleBookRec.length!=0){
  g2d.drawString (S_NO_LABEL,0,y);
  g2d.drawString (DATE_LABEL,(int)(0.5*72),y);
  g2d.drawString (SALE_QUANTITY_LABEL,(int)(1.5*72),y);
  g2d.drawString (PURCHASE_QUANTITY_LABEL,(int)(2.5*72),y);
  g2d.drawString (AMOUNT_LABEL,(int)(3.5*72),y);
  g2d.drawString (NAME_LABEL,(int)(4.5*72),y);
 }

 /******************************************************/
   y+=fontMetrics.getHeight();
 /******************************************************/

  font = new Font ("helvetica", Font.PLAIN, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();

  for(int i=0; i<purchaseSaleBookRec.length; i++){
    String S_NO=purchaseSaleBookRec[i].sno;
    String DATE=purchaseSaleBookRec[i].trans_date;

    String SALE_QUANTITY="";//=purchaseSaleBookRec[i].quantity_kg_bag;
    String PURCHASE_QUANTITY="";//=purchaseSaleBookRec[i].quantity_kg_bag;

    if(purchaseSaleBookRec[i].trans_type.startsWith("S"))SALE_QUANTITY=purchaseSaleBookRec[i].quantity_kg_bag;
    else PURCHASE_QUANTITY=purchaseSaleBookRec[i].quantity_kg_bag;

    String AMOUNT=purchaseSaleBookRec[i].total_amount;
    String NAME=purchaseSaleBookRec[i].product_name; if(IS_PRODUCT_WISE) NAME=purchaseSaleBookRec[i].customer_name;


  y+=fontMetrics.getHeight();
  int AMOUNT_ALIGN    =getAlignment(AMOUNT_LABEL,AMOUNT,(int)(3.5*72), RIGHT,fontMetrics);
  int SALE_QUANTITY_ALIGN  =getAlignment(SALE_QUANTITY_LABEL,SALE_QUANTITY,(int)(1.5*72), RIGHT,fontMetrics);
  int PURCHASE_QUANTITY_ALIGN  =getAlignment(PURCHASE_QUANTITY_LABEL,PURCHASE_QUANTITY,(int)(2.5*72), RIGHT,fontMetrics);
  int S_NO_ALIGN      =getAlignment(S_NO_LABEL,S_NO,0, CENTER,fontMetrics);

  g2d.drawString (S_NO,S_NO_ALIGN,y);
  g2d.drawString (DATE,(int)(0.5*72),y);
  g2d.drawString (SALE_QUANTITY,SALE_QUANTITY_ALIGN,y);
  g2d.drawString (PURCHASE_QUANTITY,PURCHASE_QUANTITY_ALIGN,y);
  g2d.drawString (AMOUNT,AMOUNT_ALIGN,y);
  if(!isBoth)g2d.drawString (NAME,(int)(4.5*72),y);
  }//end for loop

  y+=fontMetrics.getHeight();
  y+=fontMetrics.getHeight();

  font = new Font ("helvetica", Font.BOLD, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();

  if(IS_LAST_PAGE){

  String PURCHASE_AMOUNT="PURCHASE AMOUNT Rs. "+ (purchaseAmount==0?"NIL":""+purchaseAmount);
  String PURCHASE_QUANTITY="PURCHASE QUANTITY: "+ (purchaseQuantity==0?"NIL":""+purchaseQuantity);

  String SALE_AMOUNT="SALE AMOUNT Rs. "+ (saleAmount==0?"NIL":""+saleAmount);
  String SALE_QUANTITY="SALE QUANTITY: "+ (saleQuantity==0?"NIL":""+saleQuantity);

  int currentAmount=purchaseAmount-saleAmount;
  double currentQuantity=purchaseQuantity-saleQuantity;

  String CURRENT_AMOUNT="CURRENT AMOUNT Rs. "+ (currentAmount==0?"NIL":""+currentAmount);
  String CURRENT_QUANTITY="CURRENT QUANTITY: "+ (currentQuantity==0?"NIL":""+currentQuantity);

  String PREVIOUS_AMOUNT="PREVIOUS AMOUNT Rs. "+ (previousAmount==0?"NIL":""+previousAmount);
  String PREVIOUS_QUANTITY="PREVIOUS QUANTITY: "+ (previousQuantity==0?"NIL":""+previousQuantity);

  int balanceAmount=previousAmount+currentAmount;
  double balanceQuantity=previousQuantity+currentQuantity;

  String BALANCE_AMOUNT="BALANCE AMOUNT Rs. "+ (balanceAmount==0?"NIL":""+balanceAmount);
  String BALANCE_QUANTITY="BALANCE QUANTITY: "+ (balanceQuantity==0?"NIL":""+balanceQuantity);

  int y1=y;

  g2d.drawString(PURCHASE_AMOUNT,0,y);
  if(IS_PRODUCT_WISE){
     y+=fontMetrics.getHeight();
     g2d.drawString (PURCHASE_QUANTITY,0,y);
  }


  y=y1;
  g2d.drawString (SALE_AMOUNT,(int)(2.5*72),y);

  if(IS_PRODUCT_WISE){
       y+=fontMetrics.getHeight();
       g2d.drawString (SALE_QUANTITY,(int)(2.5*72),y);
       y=y1;
       g2d.drawString (CURRENT_AMOUNT,(int)(4.66*72),y);
       y+=fontMetrics.getHeight();
       g2d.drawString (CURRENT_QUANTITY,(int)(4.66*72),y);

       y+=fontMetrics.getHeight();
       y+=fontMetrics.getHeight();

       y1=y;
       g2d.drawString (PREVIOUS_AMOUNT,0,y);
       y+=fontMetrics.getHeight();
       g2d.drawString (PREVIOUS_QUANTITY,0,y);

       y=y1;
       g2d.drawString (BALANCE_AMOUNT,(int)(2.5*72),y);
       y+=fontMetrics.getHeight();
       g2d.drawString (BALANCE_QUANTITY,(int)(2.5*72),y);
 }//end if

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
