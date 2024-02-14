package project;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class CustomerTransactionRecord {
   private java.util.Vector transVector=new java.util.Vector();
   private SummaryDetailRecord summaryDetailRec;
   public String dateFrom;
   public String dateTo;
   public String customer_name;
   public String credit_debit;
   public int credit_amount;
   public int debit_amount;
   public String previous_balance;
   public String previous_credit_debit;

public String amount;
public boolean isProduct;

   public boolean isCredit(){
     if(credit_debit==null)throw new RuntimeException("1st call balance method then call isCredit() method..");
     return credit_debit.equals("C") ;
   }
   public void setTransactions(java.util.Vector transVector){
     this.transVector=transVector;
   }//end method
   public java.util.Vector getTransactions(){
     return transVector;
   }//end method

   public void setSummaryDetail(SummaryDetailRecord summaryDetailRec){
     this.summaryDetailRec=summaryDetailRec;
   }//end method

   public SummaryDetailRecord getSummaryDetail(){
     return summaryDetailRec;
   }//end method

   public int getCreditAmount(){
//     int amount=0;
//     for(int i=0; i<transVector.size(); i++){
//        TransactionRecord rec=(TransactionRecord)transVector.elementAt(i);
//        if(rec.debit_credit.startsWith("C"))amount+=Integer.parseInt(rec.amount);
//     }//end for
//     return amount;
   return credit_amount;
 }//end method

  public int getDebitAmount(){
//     int amount=0;
//     for(int i=0; i<transVector.size(); i++){
//        TransactionRecord rec=(TransactionRecord)transVector.elementAt(i);
//        if(rec.debit_credit.startsWith("D"))amount+=Integer.parseInt(rec.amount);
//     }//end for
//     return amount;
   return debit_amount;
 }//end method

  public double getBalance(){
   int debitAmount=getDebitAmount();
   int creditAmount=getCreditAmount();

   SummaryDetailRecord rec=this.getSummaryDetail();


   double balance=0;
   credit_debit="C";

  if(creditAmount>=debitAmount){
     balance=creditAmount-debitAmount;
     credit_debit="C";

     if(rec!=null && rec.credit_debit.startsWith("D")){
        double pre_balance=Double.parseDouble(rec.balance);
        balance=pre_balance-balance;
        credit_debit=balance>0? "D":"C";
     }else
     if(rec==null && previous_credit_debit!=null && previous_credit_debit.startsWith("D")){
          double pre_balance=Double.parseDouble(previous_balance);
          balance=pre_balance-balance;
          credit_debit=balance>0? "D":"C";
     }

     if(rec!=null && rec.credit_debit.startsWith("C")){
        double pre_balance=Double.parseDouble(rec.balance);
        balance=pre_balance+balance;
        credit_debit="C";
     }else
     if(rec==null && previous_credit_debit!=null && previous_credit_debit.startsWith("C")){
        double pre_balance=Double.parseDouble(previous_balance);
        balance=pre_balance+balance;
        credit_debit="C";
    }
  }//end outer if

  if(debitAmount>creditAmount){
      balance=debitAmount-creditAmount;
      credit_debit="D";

      if(rec!=null && rec.credit_debit.startsWith("C")){
           double pre_balance=Double.parseDouble(rec.balance);
           balance=balance-pre_balance;
           credit_debit=balance>0? "D":"C";
       }else
       if(rec==null && previous_credit_debit!=null && previous_credit_debit.startsWith("C")){
           double pre_balance=Double.parseDouble(previous_balance);
           balance=balance-pre_balance;
           credit_debit=balance>0? "D":"C";
       }

       if(rec!=null && rec.credit_debit.startsWith("D")){
           double pre_balance=Double.parseDouble(rec.balance);
           balance=pre_balance+balance;
           credit_debit="D";
       }else
       if(rec==null && previous_credit_debit!=null && previous_credit_debit.startsWith("D")){
           double pre_balance=Double.parseDouble(previous_balance);
           balance=pre_balance+balance;
           credit_debit="D";
       }
    }//end outer if

    balance=balance<0? -(balance):balance;
    return balance;
    //return "Rs. "+balance+"/ "+Decode.debitCreditDecode(credit_debit);
 }//end method


  public String getCurrentBalance(){
   int debitAmount=getDebitAmount();
   int creditAmount=getCreditAmount();

   double balance=0;
   String credit_debit="C";

   if(creditAmount>=debitAmount){
     balance=creditAmount-debitAmount;
     credit_debit="C";
   }//end if

   if(debitAmount>creditAmount){
     balance=debitAmount-creditAmount;
     credit_debit="D";
   }//end if

   balance=balance<0? -(balance):balance;
   return "Rs. "+balance+"/ "+Decode.debitCreditDecode(credit_debit);
 }//end method

   public String getPreviousBalance(){
//   return previous_balance;
    return "Rs. "+previous_balance+"/ "+previous_credit_debit;

//     SummaryDetailRecord rec=getSummaryDetail();
//     if(rec==null)return null;
//
//     return "Rs. "+rec.balance+"/ "+Decode.debitCreditDecode(rec.credit_debit);
   }//end method

}//end class