package project;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class CashBookRecord {
  private ListItem creditItem;
  private ListItem debitItem;

  public String sno;

  public CashBookRecord(ListItem creditItem, ListItem debitItem){
    this.creditItem=creditItem;
    this.debitItem=debitItem;
  }

  public String getCrditCustomer(){
    if(creditItem==null)
       return "";
    else
       return creditItem.CUSTOMER_NAME;
  }//end method

  public String getCrditAmount(){
    if(creditItem==null)
       return "";
    else
       return creditItem.AMOUNT;
  }//end mthod

  public String getDebitCustomer(){
    if(debitItem==null)
       return "";
    else
       return debitItem.CUSTOMER_NAME;
  }//end method

  public String getDebitAmount(){
    if(debitItem==null)
       return "";
    else
       return debitItem.AMOUNT;
  }//end mthod



  public String toString(){
   return super.toString();
  }
}