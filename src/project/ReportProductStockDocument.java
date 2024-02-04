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


public class ReportProductStockDocument implements Printable{
  private boolean b=false;

  private ProductRecord rec[];
  private int pageNo;

  private boolean IS_LAST_PAGE;

  private static int LEFT=1;
  private static int RIGHT=2;
  private static int CENTER=3;
  private static int CENTER_LEFT=4;
  private  int TOTAL_PAGE;

  private int amountPayable,amountReceiable;

  public ReportProductStockDocument(ProductRecord rec[],int pageNo,boolean IS_LAST_PAGE, int TOTAL_PAGE,int amountPayable, int amountReceiable) {
     this.rec=rec;
     this.pageNo=pageNo;
     this.IS_LAST_PAGE=IS_LAST_PAGE;
     this.TOTAL_PAGE=TOTAL_PAGE;
     this.amountPayable=amountPayable;
     this.amountReceiable=amountReceiable;
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
  String HEADING2="Product Stock";

  String NOTE_LABEL="NOTE :-";
  String NOTE="It is a computer generated report which doesn't require any signature.";

  String PAGE_NO_LABEL="PAGE NO.";


  String S_NO_LABEL="S.NO.";
  String NAME_LABEL="PRODUCT";
  String AMOUNT_LABEL="VALUE";
  String QUANTITY_LABEL="QUANTITY";

 int y=(int)(pageFormat.getImageableY()+(72*0.5));

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

  g2d.drawString (PAGE_NO_LABEL+pageNo,(int)DataMarginInterface.PAGE_NO_LEFT_ALIGN-30,y);
  //g2d.drawString (String.valueOf(pageNo),(int)DataMarginInterface.PAGE_NO_LEFT_ALIGN+fontMetrics.stringWidth(PAGE_NO_LABEL)+3,y);
 /******************************************************/


  y+=fontMetrics.getHeight();
  y+=fontMetrics.getHeight();

 /******************************************************/
  font = new Font ("helvetica", Font.BOLD, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();
 /******************************************************/
 if(rec.length!=0){
  g2d.drawString (S_NO_LABEL,0,y);
  g2d.drawString (NAME_LABEL,(int)(0.48*72),y);
  g2d.drawString (QUANTITY_LABEL,(int)(4.5*72),y);
  g2d.drawString (AMOUNT_LABEL,(int)(6*72),y);
 }

 /******************************************************/
   y+=fontMetrics.getHeight();
 /******************************************************/

  font = new Font ("helvetica", Font.PLAIN, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();

  for(int i=0; i<rec.length; i++){

    String S_NO=rec[i].sno;
    String NAME=rec[i].name;
    String AMOUNT=rec[i].product_value;
    String QUANTITY=rec[i].quantity_available+" "+Decode.measurementUnitDecode(rec[i].measurement_unit);

    y+=fontMetrics.getHeight();
    int AMOUNT_ALIGN    =getAlignment(AMOUNT_LABEL,AMOUNT,(int)(6*72), RIGHT,fontMetrics);
    int QUANTITY_ALIGN  =getAlignment(QUANTITY_LABEL,QUANTITY,(int)(4.5*72), RIGHT,fontMetrics);
    int S_NO_ALIGN      =getAlignment(S_NO_LABEL,S_NO,0, CENTER,fontMetrics);

    g2d.drawString (S_NO,S_NO_ALIGN,y);
    g2d.drawString (NAME,(int)(0.48*72),y);
    g2d.drawString (QUANTITY,QUANTITY_ALIGN,y);
    g2d.drawString (AMOUNT,AMOUNT_ALIGN,y);
  }//end for loop

  y+=fontMetrics.getHeight();
  y+=fontMetrics.getHeight();

  font = new Font ("helvetica", Font.BOLD, 10);
  g2d.setFont(font);
  fontMetrics = g2d.getFontMetrics ();

  if(IS_LAST_PAGE){
    //y+=fontMetrics.getHeight();
    //y+=fontMetrics.getHeight();

    //y+=fontMetrics.getHeight();
    g2d.drawString ("Amount Payable: "+amountPayable,(int)DataMarginInterface.BOTTOM1_LEFT_ALIGN,y);
    y+=fontMetrics.getHeight();
    g2d.drawString ("Amount Receivable: "+amountReceiable,(int)DataMarginInterface.BOTTOM1_LEFT_ALIGN,y);

    y+=fontMetrics.getHeight();
    y+=fontMetrics.getHeight();
    g2d.drawString (NOTE_LABEL+NOTE,(int)DataMarginInterface.BOTTOM1_LEFT_ALIGN,y);
  }else{
        font = new Font ("helvetica", Font.BOLD+Font.ITALIC, 10);
        g2d.setFont(font);
        fontMetrics = g2d.getFontMetrics ();

    //    y+=fontMetrics.getHeight();
     //   y+=fontMetrics.getHeight();
        center_x=fontMetrics.stringWidth("Continue to next page...")/2;
        center_x=pageFormat.getImageableWidth()/2-center_x;
        g2d.drawString ("Continue to next page...",(int)center_x,y);
  }//end if

//if(TOTAL_PAGE>1){
  y+=fontMetrics.getHeight();
  String pageStr="Page "+pageNo+" of "+TOTAL_PAGE;

  center_x=fontMetrics.stringWidth(pageStr)/2;
  center_x=pageFormat.getImageableWidth()/2-center_x;
  g2d.drawString (pageStr,(int)center_x,y);
//}

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
