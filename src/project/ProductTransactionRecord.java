package project;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class ProductTransactionRecord{
   private java.util.Vector transVector=new java.util.Vector();
   public String dateFrom;
   public String dateTo;
   public String product_name;
   public String customer_name;
//   public String quantity_available;
//   public String measurement_unit;

   public void setProductTransactions(java.util.Vector transVector){
     this.transVector=transVector;
   }//end method
   public java.util.Vector getProductTransactions(){
     return transVector;
   }//end method

   public int getCreditAmount(){
     int amount=0;
     for(int i=0; i<transVector.size(); i++){
        PurchaseSaleBookRecord rec=(PurchaseSaleBookRecord)transVector.elementAt(i);
        if(rec.terms_and_conditions.equals("CREDIT"))amount+=Integer.parseInt(rec.total_amount);
     }//end for
     return amount;
   }//end method

  public int getCashAmount(){
     int amount=0;
     for(int i=0; i<transVector.size(); i++){
        PurchaseSaleBookRecord rec=(PurchaseSaleBookRecord)transVector.elementAt(i);
        if(rec.terms_and_conditions.equals("CASH"))amount+=Integer.parseInt(rec.total_amount);
     }//end for
     return amount;
 }//end method
}//end class