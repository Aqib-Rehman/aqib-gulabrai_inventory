package project;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class TransactionRecord {
 public String sno;
 public String customer_id;
 public String cash_reg_id;
 public String purchase_sale_id;
 public String customer_trans_id;
 public String amount;
 public String debit_credit;
 public String date_of_trans;
 public String bearer;
 public String remarks;


 // FOR DAILY TRANSACTION REPORT
 public String debit_amount = "";
 public String credit_amount = "";
 public String toString() {
    return date_of_trans;
  }
}//end class
