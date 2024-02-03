package project;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class Decode {
  public static boolean isNumeric(String balance){
     try{
         Double.parseDouble(balance);
         return true;
     }catch(Exception e){}
     return false;
  }//end method

  public static boolean isDate(String date){
     try{
         new java.util.Date(date);
         return true;
     }catch(Exception e){}
     return false;
  }//end method


  public static String measurementUnitDecode(String measurementUnit){
   if(measurementUnit.equals("K")) measurementUnit="KG's";
   if(measurementUnit.equals("B")) measurementUnit="BAG's";
   if(measurementUnit.equals("P")) measurementUnit="PACK's";
   return measurementUnit;
 }//end method

 public static String debitCreditDecode(String debit_credit){
   if(debit_credit.equals("C")) debit_credit="CREDIT";
   if(debit_credit.equals("D")) debit_credit="DEBIT";
   return debit_credit;
 }

 public static String transTypeDecode(String trans_type){
   if(trans_type.equals("P")) trans_type="PURCHASE";
   if(trans_type.equals("S")) trans_type="SALE";
   return trans_type;
 }
 public static String customerTypeDecode(String customer_type){
   if(customer_type.equals("G")) customer_type="GENERAL";
   if(customer_type.equals("B")) customer_type="BANK";
   return customer_type;
 }

 public static String userTypeDecode(String user_type){
        if(user_type.equals("A")) user_type="ADMIN";
        if(user_type.equals("O")) user_type="OTHER";
        return user_type;
  }

}//end class