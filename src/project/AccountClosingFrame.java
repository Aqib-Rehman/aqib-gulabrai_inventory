package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class AccountClosingFrame extends JFrame implements ActionListener{

  private JLabel headingLabel = new JLabel();
  private JLabel headingLabel1 = new JLabel();
  private JLabel customerLabel = new JLabel();
  private JLabel currentBalanceLabel = new JLabel();
  private JLabel RsLabel2 = new JLabel();
  private JLabel yearLabel = new JLabel();

  private JTextField currentBalanceTextField = new JTextField();

  private JComboBox customerComboBox = new JComboBox();
  private JComboBox yearComboBox = new JComboBox();

  private JButton closingAllAccountButton = new JButton(new ImageIcon("add.gif"));
  private JButton closingIndvAccountButton = new JButton(new ImageIcon("add.gif"));
  private JButton backButton = new JButton(new ImageIcon("back.jpg"));

  private JPanel customerPanel = new JPanel();
  private JPanel cashRegisterPanel = new JPanel();

  private WaitDialog waitDialog;
  private JLabel jLabel4 = new JLabel(new ImageIcon("4.jpg"));
  private JLabel jLabel5 = new JLabel(new ImageIcon("4.jpg"));
  private JLabel jLabel6 = new JLabel(new ImageIcon("4.jpg"));

  public AccountClosingFrame() {
  super("ACCOUNT CLOSING/ DUMPING SYSTEM");
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    waitDialog=new WaitDialog(this);

    customerComboBox.setKeySelectionManager(new MyKeySelectionManager());
    yearComboBox.setKeySelectionManager(new MyKeySelectionManager());

    Border border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151));
    TitledBorder titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"CUSTOMER");
    TitledBorder titledBorder2 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"CASH REGISTER");
    TitledBorder titledBorder3 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"ACCOUNT PAYABLE");
    this.setResizable(false);
    titledBorder3 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"ACCOUNT CLOSING/ DUMPING SYSTEM");
    headingLabel.setFont(new java.awt.Font("Dialog", 1, 30));
    headingLabel.setText("ACCOUNT CLOSING/ DUMPING SYSTEM");
    headingLabel.setBounds(new Rectangle(226, 46, 622, 33));
    this.getContentPane().setLayout(null);
    customerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    customerLabel.setToolTipText("");
    customerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    customerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    customerLabel.setText("CUSTOMER");
    customerLabel.setBounds(new Rectangle(208, 243, 123, 30));
    customerComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    customerComboBox.setBounds(new Rectangle(334, 243, 470, 30));
    currentBalanceLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    currentBalanceLabel.setToolTipText("");
    currentBalanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    currentBalanceLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    currentBalanceLabel.setText("CURRENT BALANCE");
    currentBalanceLabel.setBounds(new Rectangle(440, 303, 116, 30));
    RsLabel2.setBounds(new Rectangle(634, 303, 23, 30));
    RsLabel2.setText("Rs");
    RsLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    RsLabel2.setToolTipText("");
    currentBalanceTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    currentBalanceTextField.setEditable(false);
    currentBalanceTextField.setBounds(new Rectangle(560, 303, 71, 30));
    yearComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    yearComboBox.setBounds(new Rectangle(334, 303, 97, 30));
    yearLabel.setBounds(new Rectangle(208, 303, 123, 30));
    yearLabel.setText("YEAR");
    yearLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    yearLabel.setToolTipText("");
    yearLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    yearLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    closingAllAccountButton.setBackground(Color.white);
    closingAllAccountButton.setFont(new java.awt.Font("Dialog", 1, 12));
    closingAllAccountButton.setHorizontalAlignment(SwingConstants.RIGHT);
    closingAllAccountButton.setText("CLOSING ALL ACCOUNTS");
    closingAllAccountButton.setBounds(new Rectangle(308, 346, 209, 55));
    closingIndvAccountButton.setBounds(new Rectangle(520, 346, 173, 55));
    closingIndvAccountButton.setBackground(Color.white);
    closingIndvAccountButton.setFont(new java.awt.Font("Dialog", 1, 12));
    closingIndvAccountButton.setHorizontalAlignment(SwingConstants.RIGHT);
    closingIndvAccountButton.setText("INDV. CLOSING ACC.");
    backButton.setBounds(new Rectangle(696, 346, 120, 55));
    backButton.setBackground(Color.white);
    backButton.setFont(new java.awt.Font("Dialog", 1, 12));
    backButton.setHorizontalAlignment(SwingConstants.RIGHT);
    backButton.setText("BACK");
    customerPanel.setBackground(Color.white);
    customerPanel.setBorder(titledBorder1);
    customerPanel.setBounds(new Rectangle(244, 224, 572, 60));
    cashRegisterPanel.setBounds(new Rectangle(244, 283, 572, 59));
    cashRegisterPanel.setBackground(Color.white);
    cashRegisterPanel.setBorder(titledBorder2);
    headingLabel1.setForeground(Color.lightGray);
    headingLabel1.setBounds(new Rectangle(229, 50, 622, 33));
    headingLabel1.setText("ACCOUNT CLOSING/ DUMPING SYSTEM");
    headingLabel1.setFont(new java.awt.Font("Dialog", 1, 30));
    jLabel4.setText("");
    jLabel4.setBounds(new Rectangle(319, 83, 198, 172));
    jLabel4.setBounds(new Rectangle(159, 419, 198, 172));
    jLabel5.setBounds(new Rectangle(319, 83, 198, 172));
    jLabel5.setText("");
    jLabel5.setBounds(new Rectangle(449, 418, 198, 172));
    jLabel6.setBounds(new Rectangle(319, 83, 198, 172));
    jLabel6.setText("");
    jLabel6.setBounds(new Rectangle(712, 415, 198, 172));
    this.getContentPane().add(closingAllAccountButton, null);
    this.getContentPane().add(closingIndvAccountButton, null);
    this.getContentPane().add(customerComboBox, null);
    this.getContentPane().add(customerLabel, null);
    this.getContentPane().add(customerPanel, null);
    this.getContentPane().add(yearComboBox, null);
    this.getContentPane().add(currentBalanceTextField, null);
    this.getContentPane().add(yearLabel, null);
    this.getContentPane().add(currentBalanceLabel, null);
    this.getContentPane().add(RsLabel2, null);
    this.getContentPane().add(cashRegisterPanel, null);
    this.getContentPane().add(backButton, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(jLabel5, null);
    this.getContentPane().add(jLabel6, null);
    this.getContentPane().add(headingLabel1, null);
    this.getContentPane().add(headingLabel, null);
  this.getContentPane().setBackground(Color.white);

  headingLabel.setForeground(Color.black);
  customerLabel.setForeground(Color.black);
  currentBalanceLabel.setForeground(Color.black);
  RsLabel2.setForeground(Color.black);
  yearLabel.setForeground(Color.black);

  Border border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.gray,Color.darkGray,new Color(58, 110, 165)),BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,Color.darkGray,new Color(58, 110, 165)));


  currentBalanceTextField.setBorder(border);
  customerComboBox.setBorder(border);
  yearComboBox.setBorder(border);
//  descriptionTextArea.setBorder(border);
//  dateList.setBorder(border);
  closingAllAccountButton.setBorder(border);
  closingIndvAccountButton.setBorder(border);
  backButton.setBorder(border);

  closingAllAccountButton.addActionListener(this);
  closingIndvAccountButton.addActionListener(this);
  backButton.addActionListener(this);
  customerComboBox.addActionListener(this);
  yearComboBox.addActionListener(this);

  Toolkit kit=this.getToolkit();
  Dimension d=kit.getScreenSize();
  this.setBounds(0,0,d.width,d.height);
//  getCustomers();
//  getCashRegister();
 }//end constructor

 public void actionPerformed(ActionEvent e){
  if(closingAllAccountButton==e.getSource()) closingAllAccount();
  if(closingIndvAccountButton==e.getSource()) closingIndvAccount();
  if(backButton==e.getSource()) hide();
//  if(customerComboBox==e.getSource()) getCustomerTransactions();
  if(yearComboBox==e.getSource())     getBalance();
 }//end method


  private void getBalance(){
    CashRegisterRecord cashRegisterRec=(CashRegisterRecord)yearComboBox.getSelectedItem();
    if(cashRegisterRec==null) return;
    currentBalanceTextField.setText(cashRegisterRec.current_balance);
 }//end method


  private void getCustomers(){
 try{
   java.util.Vector v=DatabaseManager.getCustomers();
   customerComboBox.removeAllItems();

   for(int index=0; index<v.size(); index++)
     customerComboBox.addItem(v.elementAt(index));

 }catch(Exception e){
  JOptionPane.showMessageDialog(this,"Database Driver check ODBC ["+e.getMessage()+"]");
  e.printStackTrace();
 }
 }//end method

 private void getCashRegister(){
 try{
   java.util.Vector v=DatabaseManager.getCashRegisters();
   yearComboBox.removeAllItems();

   for(int index=0; index<v.size(); index++)
     yearComboBox.addItem(v.elementAt(index));
 }catch(Exception e){
  JOptionPane.showMessageDialog(this,"Database Driver check ODBC ["+e.getMessage()+"]");
  e.printStackTrace();
 }
}//end method


 private void closingAllAccount(){
   new ProgressThread().start();
 }//end method

 private class ProgressThread extends Thread{
  public void run(){
    CashRegisterRecord cashRegisterRec=(CashRegisterRecord)yearComboBox.getSelectedItem();
    if(cashRegisterRec==null){
     JOptionPane.showMessageDialog(AccountClosingFrame.this,"Please Select Year.....");
     return;
    }

 try{
    java.util.Vector v=DatabaseManager.getCustomers();

    waitDialog.setMaximunProcessValue(v.size());
    waitDialog.setMinimumProcessValue(1);
    waitDialog.show();
    int rows=0;
    for(int index=0; index<v.size(); index++){
      CustomerRecord customerRec=(CustomerRecord)v.elementAt(index);
      rows+=closeAccount(customerRec.customer_id,cashRegisterRec.cash_reg_id,cashRegisterRec.year);
      waitDialog.setProcessValue(index+1);
    }//end for loop

    waitDialog.hide();
    if(rows>=1)
      JOptionPane.showMessageDialog(AccountClosingFrame.this,rows+" Account Successfully CLOSED.....");

  }catch(Exception e){
     JOptionPane.showMessageDialog(AccountClosingFrame.this,e.getMessage());
     e.printStackTrace();
  }
 }//end run method()
}//end inner class



 private void closingIndvAccount(){
    CustomerRecord customerRec=(CustomerRecord)customerComboBox.getSelectedItem();
    if(customerRec==null){
     JOptionPane.showMessageDialog(this,"Please Select Customer.....");
     return;
    }

    CashRegisterRecord cashRegisterRec=(CashRegisterRecord)yearComboBox.getSelectedItem();
    if(cashRegisterRec==null){
     JOptionPane.showMessageDialog(this,"Please Select Year.....");
     return;
    }

   int rows=closeAccount(customerRec.customer_id,cashRegisterRec.cash_reg_id,cashRegisterRec.year);
   if(rows>=1)
      JOptionPane.showMessageDialog(this,"Account Successfully CLOSED.....");
 }//end method


  private int closeAccount(String customer_id, String cash_reg_id, String year){
   try{
    double creditAmount=DatabaseManager.getDebitCreditTransactions(customer_id,cash_reg_id,"C");
    double debitAmount=DatabaseManager.getDebitCreditTransactions(customer_id,cash_reg_id,"D");
    SummaryDetailRecord rec=DatabaseManager.getPreviousBalance(customer_id,year);

    double balance=0;
    String credit_debit="C";
    String remarks="....";

    if(creditAmount>=debitAmount){
        balance=creditAmount-debitAmount;
        credit_debit="C";

        if(rec!=null && rec.credit_debit.startsWith("D")){
           double pre_balance=Double.parseDouble(rec.balance);
           balance=pre_balance-balance;
           credit_debit=balance>0? "D":"C";
        }//end if

        if(rec!=null && rec.credit_debit.startsWith("C")){
           double pre_balance=Double.parseDouble(rec.balance);
           balance=pre_balance+balance;
           credit_debit="C";
        }//end if
     }//end outer if

    if(debitAmount>creditAmount){
      balance=debitAmount-creditAmount;
      credit_debit="D";

        if(rec!=null && rec.credit_debit.startsWith("C")){
           double pre_balance=Double.parseDouble(rec.balance);
           balance=balance-pre_balance;
           credit_debit=balance>0? "D":"C";
        }//end if

        if(rec!=null && rec.credit_debit.startsWith("D")){
           double pre_balance=Double.parseDouble(rec.balance);
           balance=pre_balance+balance;
           credit_debit="D";
        }//end if
     }//end outer if

     balance=balance<0? -(balance):balance;

     int rows=DatabaseManager.addSummaryDetial(customer_id,cash_reg_id,balance,credit_debit,remarks);
     return rows;
   }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
   }
 return 0;
 }//end method

 public void show(){
  this.getCustomers();
  this.getCashRegister();
  super.show();
 }///////////end method
}//end class










