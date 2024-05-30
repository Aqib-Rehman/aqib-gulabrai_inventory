package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class TransactionFrame extends JFrame implements ActionListener,ListSelectionListener{

  private JLabel headingLabel = new JLabel();
  private JLabel headingLabel1 = new JLabel();
  private JLabel customerLabel = new JLabel();
  private JLabel currentBalanceLabel = new JLabel();
  private JLabel RsLabel2 = new JLabel();
  private JLabel RsLabel3 = new JLabel();
  private JLabel yearLabel = new JLabel();
  private JLabel transactionIDLabel = new JLabel();
  private JLabel descriptionLabel = new JLabel();
  private JLabel amountLabel = new JLabel();
  private JLabel dateLabel = new JLabel();
  private JLabel bearerLabel = new JLabel();
  private JLabel payableDateLabel = new JLabel();
  private JLabel creditDebitLabel = new JLabel();

  private JTextField currentBalanceTextField = new JTextField();
  private JTextField transactionIDTextField = new JTextField();
  private JTextField amountTextField = new JTextField();
  private JTextField dateTextField = new JTextField();
  private JTextField bearerTextField = new JTextField();

  private JComboBox customerComboBox = new JComboBox();
  private JComboBox yearComboBox = new JComboBox();
  private JComboBox creditDebitComboBox = new JComboBox();

  private JScrollPane descriptionScrollPane = new JScrollPane();
  private JScrollPane dateScrollPane = new JScrollPane();
  private JTextArea descriptionTextArea = new JTextArea();
  private JList dateList = new JList();

  private JButton addButton = new JButton(new ImageIcon("add.gif"));
  private JButton deleteButton = new JButton(new ImageIcon("delete.jpg"));
  private JButton clearButton = new JButton(new ImageIcon("CLEAR.JPG"));
  private JButton backButton = new JButton(new ImageIcon("back.jpg"));

  private JPanel customerPanel = new JPanel();
  private JPanel cashRegisterPanel = new JPanel();
  private JPanel accountPayablePanel = new JPanel();
  private JLabel paymentModeLabel = new JLabel();
  private JComboBox paymentModeComboBox = new JComboBox();
  private JComboBox customerBankComboBox = new JComboBox();
  private JLabel customerBankLabel = new JLabel();
//  JLabel jLabel4 = new JLabel(new ImageIcon("ntimage.gif"));
  JLabel jLabel5 = new JLabel(new ImageIcon("ntimage.gif"));
private UserAccountRecord uar;
int frame_id;
public void setUser(UserAccountRecord uar ){
    this.uar = uar;
}

  public TransactionFrame() {
  super("CASH TRANSACTIONS");
    try {
      jbInit();
      frame_id=7;
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
  customerComboBox.setKeySelectionManager(new MyKeySelectionManager());
  yearComboBox.setKeySelectionManager(new MyKeySelectionManager());
  creditDebitComboBox.setKeySelectionManager(new MyKeySelectionManager());


    creditDebitComboBox.addItem("CREDIT");
    creditDebitComboBox.addItem("DEBIT");

    Border border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151));
    TitledBorder titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"CUSTOMER");
    TitledBorder titledBorder2 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"CASH REGISTER");
    TitledBorder titledBorder3 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"ACCOUNT PAYABLE");

    titledBorder3 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"CUSTOMER CASH TRANSACTIONS");
    headingLabel.setFont(new java.awt.Font("Dialog", 1, 30));
    headingLabel.setText("CUSTOMER CASH TRANSACTIONS");
    headingLabel.setBounds(new Rectangle(253, 31, 535, 33));
    this.getContentPane().setLayout(null);
    customerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    customerLabel.setToolTipText("");
    customerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    customerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    customerLabel.setText("CUSTOMER");
    customerLabel.setBounds(new Rectangle(146, 131, 123, 30));
    customerComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    customerComboBox.setBounds(new Rectangle(272, 131, 470, 30));
    currentBalanceLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    currentBalanceLabel.setToolTipText("");
    currentBalanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    currentBalanceLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    currentBalanceLabel.setText("CURRENT BALANCE");
    currentBalanceLabel.setBounds(new Rectangle(378, 191, 116, 30));
    RsLabel2.setBounds(new Rectangle(572, 191, 23, 30));
    RsLabel2.setText("Rs");
    RsLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    RsLabel2.setToolTipText("");
    currentBalanceTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    currentBalanceTextField.setEditable(false);
    currentBalanceTextField.setBounds(new Rectangle(498, 191, 71, 30));
    yearComboBox.setEnabled(false);
    yearComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    yearComboBox.setBounds(new Rectangle(272, 191, 97, 30));
    yearLabel.setBounds(new Rectangle(146, 191, 123, 30));
    yearLabel.setText("YEAR");
    yearLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    yearLabel.setToolTipText("");
    yearLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    yearLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    transactionIDTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    transactionIDTextField.setEditable(false);
    transactionIDTextField.setBounds(new Rectangle(277, 260, 59, 30));
    transactionIDLabel.setBounds(new Rectangle(203, 260, 71, 30));
    transactionIDLabel.setText("TRANS. ID");
    transactionIDLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    transactionIDLabel.setToolTipText("");
    transactionIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    transactionIDLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    this.setResizable(false);

    RsLabel3.setFont(new java.awt.Font("Dialog", 1, 12));
    RsLabel3.setToolTipText("");
    RsLabel3.setText("Rs");
    RsLabel3.setBounds(new Rectangle(346, 326, 23, 30));
    amountTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    amountTextField.setBounds(new Rectangle(272, 326, 71, 30));
    amountLabel.setBounds(new Rectangle(208, 326, 61, 30));
    amountLabel.setText("AMOUNT");
    amountLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    amountLabel.setToolTipText("");
    amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    amountLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    dateLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    dateLabel.setToolTipText("");
    dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    dateLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    dateLabel.setText("DATE");
    dateLabel.setBounds(new Rectangle(404, 326, 38, 30));
    dateTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    dateTextField.setBounds(new Rectangle(444, 326, 94, 30));
    bearerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    bearerLabel.setToolTipText("");
    bearerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    bearerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    bearerLabel.setText("BEARER");
    bearerLabel.setBounds(new Rectangle(200, 359, 69, 30));
    bearerTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    bearerTextField.setBounds(new Rectangle(272, 359, 470, 30));
    descriptionLabel.setBounds(new Rectangle(272, 390, 90, 30));
    descriptionLabel.setText("DESCRIPTION");
    descriptionLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionLabel.setToolTipText("");
    descriptionScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionScrollPane.setBounds(new Rectangle(272, 412, 470, 66));
    dateScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    dateScrollPane.setBounds(new Rectangle(759, 118, 107, 434));
    payableDateLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    payableDateLabel.setToolTipText("");
    payableDateLabel.setText("DATES");
    payableDateLabel.setBounds(new Rectangle(793, 97, 47, 25));
    addButton.setBackground(Color.white);
    addButton.setFont(new java.awt.Font("Dialog", 1, 12));
    addButton.setHorizontalAlignment(SwingConstants.RIGHT);
    addButton.setText("ADD");
    addButton.setBounds(new Rectangle(184, 496, 215, 55));
    deleteButton.setBounds(new Rectangle(402, 496, 118, 55));
    deleteButton.setBackground(Color.white);
    deleteButton.setFont(new java.awt.Font("Dialog", 1, 12));
    deleteButton.setHorizontalAlignment(SwingConstants.RIGHT);
    deleteButton.setText("DELETE");
    clearButton.setBounds(new Rectangle(523, 496, 105, 55));
    clearButton.setBackground(Color.white);
    clearButton.setFont(new java.awt.Font("Dialog", 1, 12));
    clearButton.setHorizontalAlignment(SwingConstants.RIGHT);
    clearButton.setText("CLEAR");
    backButton.setBounds(new Rectangle(632, 496, 120, 55));
    backButton.setBackground(Color.white);
    backButton.setFont(new java.awt.Font("Dialog", 1, 12));
    backButton.setHorizontalAlignment(SwingConstants.RIGHT);
    backButton.setText("BACK");
    customerPanel.setBackground(Color.white);
    customerPanel.setBorder(titledBorder1);
    customerPanel.setBounds(new Rectangle(182, 112, 572, 60));
    cashRegisterPanel.setBounds(new Rectangle(182, 171, 572, 59));
    cashRegisterPanel.setBackground(Color.white);
    cashRegisterPanel.setBorder(titledBorder2);
    accountPayablePanel.setBackground(Color.white);
    accountPayablePanel.setBorder(titledBorder3);
    accountPayablePanel.setBounds(new Rectangle(182, 238, 572, 249));
    headingLabel1.setForeground(Color.lightGray);
    headingLabel1.setBounds(new Rectangle(255, 35, 527, 33));
    headingLabel1.setText("CUSTOMER CASH TRANSACTIONS");
    headingLabel1.setFont(new java.awt.Font("Dialog", 1, 30));
    creditDebitLabel.setForeground(Color.black);
    creditDebitLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    creditDebitLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    creditDebitLabel.setToolTipText("");
    creditDebitLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    creditDebitLabel.setText("CREDIT/ DEBIT");
    creditDebitLabel.setBounds(new Rectangle(539, 326, 86, 30));
    creditDebitComboBox.addActionListener(this);
    creditDebitComboBox.setBounds(new Rectangle(627, 326, 115, 30));
    creditDebitComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    dateList.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionTextArea.setFont(new java.awt.Font("Dialog", 1, 12));
    paymentModeLabel.setBounds(new Rectangle(344, 260, 98, 30));
    paymentModeLabel.setText("PAYMENT MODE");
    paymentModeLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    paymentModeLabel.setToolTipText("");
    paymentModeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    paymentModeLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    paymentModeLabel.setForeground(Color.black);
    paymentModeComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    paymentModeComboBox.setBounds(new Rectangle(444, 260, 115, 30));
    paymentModeComboBox.addActionListener(this);
    paymentModeComboBox.setKeySelectionManager(new MyKeySelectionManager());
    customerBankComboBox.addActionListener(this);
    customerBankComboBox.setBounds(new Rectangle(444, 293, 286, 30));
    customerBankComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    customerBankComboBox.setKeySelectionManager(new MyKeySelectionManager());
    customerBankLabel.setForeground(Color.black);
    customerBankLabel.setBounds(new Rectangle(402, 293, 40, 30));
    customerBankLabel.setText("BANK");
    customerBankLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    customerBankLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    customerBankLabel.setToolTipText("");
    customerBankLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel5.setBounds(new Rectangle(530, 421, 436, 413));
    this.getContentPane().add(bearerTextField, null);
    this.getContentPane().add(addButton, null);
    this.getContentPane().add(bearerLabel, null);
    this.getContentPane().add(descriptionLabel, null);
    this.getContentPane().add(customerComboBox, null);
    this.getContentPane().add(descriptionScrollPane, null);
    this.getContentPane().add(customerLabel, null);
    this.getContentPane().add(customerPanel, null);
    this.getContentPane().add(backButton, null);
    this.getContentPane().add(clearButton, null);
    this.getContentPane().add(creditDebitComboBox, null);
    this.getContentPane().add(RsLabel3, null);
    this.getContentPane().add(amountLabel, null);
    this.getContentPane().add(amountTextField, null);
    this.getContentPane().add(creditDebitLabel, null);
    this.getContentPane().add(payableDateLabel, null);
    this.getContentPane().add(dateScrollPane, null);
    this.getContentPane().add(yearComboBox, null);
    this.getContentPane().add(currentBalanceTextField, null);
    this.getContentPane().add(yearLabel, null);
    this.getContentPane().add(currentBalanceLabel, null);
    this.getContentPane().add(RsLabel2, null);
    this.getContentPane().add(cashRegisterPanel, null);
    this.getContentPane().add(deleteButton, null);
    this.getContentPane().add(transactionIDTextField, null);
    this.getContentPane().add(transactionIDLabel, null);
    this.getContentPane().add(customerBankComboBox, null);
    this.getContentPane().add(dateTextField, null);
    this.getContentPane().add(paymentModeComboBox, null);
    this.getContentPane().add(customerBankLabel, null);
    this.getContentPane().add(dateLabel, null);
    this.getContentPane().add(paymentModeLabel, null);
    this.getContentPane().add(accountPayablePanel, null);
    this.getContentPane().add(jLabel5, null);
    this.getContentPane().add(headingLabel1, null);
    this.getContentPane().add(headingLabel, null);
    dateScrollPane.getViewport().add(dateList, null);
    descriptionScrollPane.getViewport().add(descriptionTextArea, null);
  this.getContentPane().setBackground(Color.white);

  headingLabel.setForeground(Color.black);
  customerLabel.setForeground(Color.black);
  currentBalanceLabel.setForeground(Color.black);
  RsLabel2.setForeground(Color.black);
  RsLabel3.setForeground(Color.black);
  yearLabel.setForeground(Color.black);
  transactionIDLabel.setForeground(Color.black);
  descriptionLabel.setForeground(Color.black);
  amountLabel.setForeground(Color.black);
  dateLabel.setForeground(Color.black);
  bearerLabel.setForeground(Color.black);
  payableDateLabel.setForeground(Color.black);

  Border border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.gray,Color.darkGray,new Color(58, 110, 165)),BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,Color.darkGray,new Color(58, 110, 165)));


  customerBankComboBox.setBorder(border);
  paymentModeComboBox.setBorder(border);
  creditDebitComboBox.setBorder(border);
  currentBalanceTextField.setBorder(border);
  transactionIDTextField.setBorder(border);
  amountTextField.setBorder(border);
  dateTextField.setBorder(border);
  bearerTextField.setBorder(border);
  customerComboBox.setBorder(border);
  yearComboBox.setBorder(border);
  descriptionScrollPane.setBorder(border);
  dateScrollPane.setBorder(border);
//  descriptionTextArea.setBorder(border);
//  dateList.setBorder(border);
  addButton.setBorder(border);
  deleteButton.setBorder(border);
  clearButton.setBorder(border);
  backButton.setBorder(border);

  addButton.addActionListener(this);
  deleteButton.addActionListener(this);
  clearButton.addActionListener(this);
  backButton.addActionListener(this);
  customerComboBox.addActionListener(this);
  yearComboBox.addActionListener(this);
  dateList.addListSelectionListener(this);

  Toolkit kit=this.getToolkit();
  Dimension d=kit.getScreenSize();
  this.setBounds(0,0,d.width,d.height);
//  getCustomers();
//  getCashRegister();
    paymentModeComboBox.addItem("CASH");
    paymentModeComboBox.addItem("CHEQUE");
 }//end constructor

 public void actionPerformed(ActionEvent e){
  if(addButton==e.getSource()) addRecord();
  if(deleteButton==e.getSource()) deleteRecord();
  if(clearButton==e.getSource()) clearRecord();
  if(backButton==e.getSource()) hide();
  if(customerComboBox==e.getSource()) getCustomerTransactions();
  if(yearComboBox==e.getSource())     getCustomerTransactions();
  if(paymentModeComboBox==e.getSource()) showBankCustomers();

 }//end method

   public void valueChanged(ListSelectionEvent e){
    TransactionRecord rec=(TransactionRecord)dateList.getSelectedValue();
    if(rec==null) return;

    transactionIDTextField.setText(rec.customer_trans_id );
    amountTextField.setText(rec.amount );
    dateTextField.setText(rec.date_of_trans );
    bearerTextField.setText(rec.bearer );
    descriptionTextArea.setText(rec.remarks);
    creditDebitComboBox.setSelectedItem(rec.debit_credit.trim().equals("C")? "CREDIT":"DEBIT");

    boolean b=false;
    if(rec.purchase_sale_id==null)b=true;

    deleteButton.setEnabled(b);
    clearButton.setEnabled(b);
    addButton.setEnabled(b);
    transactionIDTextField.setEnabled(b);
    amountTextField.setEnabled(b);
    dateTextField.setEnabled(b);
    bearerTextField.setEnabled(b);
    descriptionTextArea.setEnabled(b);
    creditDebitComboBox.setEnabled(b);
    customerBankComboBox.setEnabled(b);
    paymentModeComboBox.setEnabled(b);
  }//end mthod

  private void showBankCustomers(){
    String paymentMode=(String)  paymentModeComboBox.getSelectedItem();
    if(paymentMode==null)return;

    boolean b=false;
    if(paymentMode.equals("CASH"))   b=false;
    if(paymentMode.equals("CHEQUE")) b=true;


    customerBankComboBox.setVisible(b);
    customerBankLabel.setVisible(b);
  }//end method

 private void getCustomerTransactions(){
    CustomerRecord customerRec=(CustomerRecord)customerComboBox.getSelectedItem();
    if(customerRec==null) return;

    CashRegisterRecord cashRegisterRec=(CashRegisterRecord)yearComboBox.getSelectedItem();
    if(cashRegisterRec==null) return;
    currentBalanceTextField.setText(cashRegisterRec.current_balance);

    clearRecord();
    try{
       java.util.Vector v=DatabaseManager.getTransactions(customerRec.customer_id,cashRegisterRec.cash_reg_id,"","","B","DESC");
       dateList.setListData(v);
    }catch(Exception e){
      e.printStackTrace();
    }
 }//end method


  private void getCustomers(){
 try{
   java.util.Vector v=DatabaseManager.getCustomers(uar);
   customerComboBox.removeAllItems();
   customerBankComboBox.removeAllItems();

   for(int index=0; index<v.size(); index++){
     CustomerRecord rec=(CustomerRecord)v.elementAt(index);
     if(rec==null) continue;
     customerComboBox.addItem(rec);
     if(rec.customer_type.equals("B"))customerBankComboBox.addItem(rec);
   }

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

 private void clearRecord(){
  transactionIDTextField.setText("");
  amountTextField.setText("");
//  dateTextField.setText("");
  bearerTextField.setText("");
  descriptionTextArea.setText("");
 }//end method

 private void addRecord(){
 try{
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

    String debit_credit=""+((String)(creditDebitComboBox.getSelectedItem())).charAt(0);
    String amount=amountTextField.getText();
    String date_of_trans=dateTextField.getText();
    String bearer=bearerTextField.getText();
    String remarks=descriptionTextArea.getText();

    if(date_of_trans.trim().equals("")){
       JOptionPane.showMessageDialog(this,"Enter Date.....");
       return;
    }

    if(amount.trim().equals(""))amount="0";
    if(bearer.trim().equals(""))bearer="....";
    if(remarks.trim().equals(""))remarks="....";

    if(! Decode.isNumeric(amount)){
       JOptionPane.showMessageDialog(this,"Amount must enter in NUMERIC form.....");
       return;
    }

    String payment_mode=(String)this.paymentModeComboBox.getSelectedItem();
    if(payment_mode==null)return;


    if(payment_mode.equals("CASH")){
        addTransaction(customerRec.customer_id, cashRegisterRec.cash_reg_id, amount, debit_credit, date_of_trans, bearer, remarks,payment_mode);
    }else{
        CustomerRecord bankCustomerRec=(CustomerRecord)this.customerBankComboBox.getSelectedItem();
        if(bankCustomerRec==null)return;

        int row1=DatabaseManager.addTransaction(customerRec.customer_id, cashRegisterRec.cash_reg_id, amount, debit_credit, date_of_trans, bearer, remarks,payment_mode);
        int row2=DatabaseManager.addTransaction(bankCustomerRec.customer_id, cashRegisterRec.cash_reg_id, amount, debit_credit.startsWith("C")?"D":"C", date_of_trans, bearer, remarks,payment_mode);
           if(row1>=1 && row2>=1){
               JOptionPane.showMessageDialog(this,"Record Successfully SAVED.....");
               //getCashRegister();
               getCustomerTransactions();
               clearRecord();
           }
    }//end if

  }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
  }
 }//end method

 private void addTransaction(String customer_id,String cash_reg_id, String amount, String debit_credit, String date_of_trans, String bearer, String remarks,String payment_mode){
   try{
      int rows=DatabaseManager.addTransaction(customer_id, cash_reg_id, amount, debit_credit, date_of_trans, bearer, remarks,payment_mode);
      if(rows>=1){
          rows=DatabaseManager.cashRegisterIteration(cash_reg_id,amount, debit_credit);
         if(rows>=1){
             JOptionPane.showMessageDialog(this,"Record Successfully SAVED.....");
             this.getCashRegister();
             getCustomerTransactions();
             clearRecord();
         }//end inner if
      }//outer if
  }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
  }
 }//end method

 private void deleteRecord(){
    TransactionRecord rec=(TransactionRecord)dateList.getSelectedValue();
    if(rec==null){
     JOptionPane.showMessageDialog(this,"Please Select Date.....");
     return;
    }

  if(rec.purchase_sale_id!=null){
    JOptionPane.showMessageDialog(this,"This record will remove....\nThis record was auto inserted by SALE/ PURCHASE BOOK");
    return;
  }

 try{
  int confirm=JOptionPane.showConfirmDialog(this,"Are you sure to remove selected record?","Confirmation...",JOptionPane.YES_NO_OPTION);
  if(confirm==JOptionPane.YES_OPTION){
      int rows=DatabaseManager.deleteTransaction(rec.customer_trans_id);
      if(rows>=1){
                  rows=DatabaseManager.cashRegisterIteration(rec.cash_reg_id,rec.amount,rec.debit_credit.equals("D")?"C":"D");
                  if(rows>=1){
                     JOptionPane.showMessageDialog(this,"Record Successfully REMOVED.....");
                     getCashRegister();
                     getCustomerTransactions();
                     clearRecord();
                 }//end if
      }//end if
  }//end if

   }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
   }
 }//end method


 public void show(){
  this.getCustomers();
  this.getCashRegister();
  this.dateTextField.setText(DateFormat.getCurrentDate());
  super.show();
 }///////////////////////////////end method
}//end class