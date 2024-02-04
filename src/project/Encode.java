package project;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class Encode {

  public static String measurementUnitEncode(String measurementUnit){
   if(measurementUnit.equals("KG's")) measurementUnit="K";
   if(measurementUnit.equals("BAG's")) measurementUnit="B";
   if(measurementUnit.equals("PACK's")) measurementUnit="P";
   return measurementUnit;
 }//end method

  public static String termsConditionsEncode(String termsConditions){
   if(termsConditions.equals("CREDIT")) termsConditions="C";
   if(termsConditions.equals("DEBIT")) termsConditions="D";
   if(termsConditions.equals("BOTH")) termsConditions="B";
   return termsConditions;
 }//end method

  public static String transactionTypeEncode(String transactionType){
   if(transactionType.equals("SALE")) transactionType="S";
   if(transactionType.equals("PURCHASE")) transactionType="P";
   if(transactionType.equals("BOTH")) transactionType="B";
   return transactionType;
 }//end method


 public static String userTypeEncode(String userType){
  if(userType.equals("ADMIN")) userType="A";
  if(userType.equals("OTHER")) userType="O";
  return userType;
 }//end method

}//end class