package project;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class SummaryDetailRecord {

 public String customer_id;
 public String cash_reg_id;
 public String summary_detail_id;
 public String balance;
 public String credit_debit;
 public String remarks;

 public String toString(){
   return "Rs. "+balance+"/ "+ Decode.debitCreditDecode(credit_debit);
 }
}//end class