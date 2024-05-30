package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class AccountPayableReceivableFrame extends JFrame implements ActionListener{
  private JLabel headingLabel = new JLabel();
  private JLabel headingLabel1 = new JLabel();
  private JLabel creditLabel = new JLabel();
  private JLabel debitLabel = new JLabel();

  private JScrollPane debitScrollPane = new JScrollPane();
  private JScrollPane creditScrollPane = new JScrollPane();

  private Object creditObj[];
  private Object debitObj[];

  private JButton backButton = new JButton(new ImageIcon("back.jpg"));


  private JTable debitTable = new JTable();
  private JTable creditTable = new JTable();

  private JTextField debitAmountTextField = new JTextField();
  private JTextField creditAmountTextField = new JTextField();
  private JTextField balanceTextField = new JTextField();
  private JTextField cashInHandTextField = new JTextField();

  private JLabel creditAmountLabel = new JLabel();
  private JLabel debitAmountLabel = new JLabel();
  private JLabel balanceLabel = new JLabel();
  private JLabel cashInHandLabel = new JLabel();

  private JLabel jLabel4 = new JLabel(new ImageIcon("4.jpg"));

  private JComboBox yearComboBox = new JComboBox();
  private JLabel yearLabel = new JLabel();
  JButton printButton = new JButton(new ImageIcon("printer.jpg"));
private UserAccountRecord uar;
int frame_id;
public void setUser(UserAccountRecord uar ){
    this.uar = uar;
}

  public AccountPayableReceivableFrame() {
  super("ACCOUNT PAYABLE/ RECEIVABLE .......");
    try {
      jbInit();
      frame_id=11;
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    Border border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151));

    headingLabel.setFont(new java.awt.Font("Dialog", 1, 30));
    headingLabel.setText("ACCOUNT PAYABLE/ RECEIVABLE");
    headingLabel.setBounds(new Rectangle(256, 33, 529, 33));
    this.getContentPane().setLayout(null);
    creditScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    creditScrollPane.setBounds(new Rectangle(493, 179, 296, 415));
    creditLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    creditLabel.setToolTipText("");
    creditLabel.setText("CREDIT");
    creditLabel.setBounds(new Rectangle(494, 159, 47, 29));
    backButton.setBounds(new Rectangle(802, 536, 134, 60));
    backButton.setBackground(Color.white);
    backButton.setFont(new java.awt.Font("Dialog", 1, 12));
    backButton.setHorizontalAlignment(SwingConstants.RIGHT);
    backButton.setText("BACK");
    headingLabel1.setForeground(Color.lightGray);
    headingLabel1.setBounds(new Rectangle(253, 30, 529, 33));
    headingLabel1.setText("ACCOUNT PAYABLE/ RECEIVABLE");
    headingLabel1.setFont(new java.awt.Font("Dialog", 1, 30));
    jLabel4.setText("");
    jLabel4.setBounds(new Rectangle(811, 58, 197, 178));
    debitScrollPane.setBounds(new Rectangle(182, 179, 296, 415));
    debitScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    debitLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    debitLabel.setToolTipText("");
    debitLabel.setText("DEBIT");
    debitLabel.setBounds(new Rectangle(182, 159, 42, 29));
    debitLabel.setForeground(Color.black);

    this.setResizable(false);

    debitAmountTextField.setBounds(new Rectangle(802, 349, 134, 28));
    debitAmountTextField.setEditable(false);
    debitAmountTextField.setFont(new java.awt.Font("Dialog", 1, 12));

    creditAmountTextField.setBounds(new Rectangle(802, 303, 134, 28));
    creditAmountTextField.setEditable(false);
    creditAmountTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    creditAmountLabel.setBounds(new Rectangle(802, 287, 94, 21));
    creditAmountLabel.setText("CREDIT AMOUNT");
    creditAmountLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    debitAmountLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    debitAmountLabel.setText("DEBIT AMOUNT");
    debitAmountLabel.setBounds(new Rectangle(802, 333, 88, 21));
    balanceTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    balanceTextField.setEditable(false);
    balanceTextField.setBounds(new Rectangle(802, 395, 134, 28));
    balanceLabel.setBounds(new Rectangle(802, 379, 88, 21));
    balanceLabel.setText("BALANCE");
    balanceLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    cashInHandLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    cashInHandLabel.setText("CASH IN HAND");
    cashInHandLabel.setBounds(new Rectangle(802, 424, 88, 21));
    cashInHandTextField.setBounds(new Rectangle(802, 440, 134, 28));
    cashInHandTextField.setEditable(false);
    cashInHandTextField.setFont(new java.awt.Font("Dialog", 1, 12));

    yearComboBox.setKeySelectionManager(new MyKeySelectionManager());
    yearComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    yearComboBox.setBounds(new Rectangle(221, 124, 97, 30));
    yearComboBox.addActionListener(this);
    yearLabel.setBounds(new Rectangle(180, 124, 36, 30));
    yearLabel.setText("YEAR");
    yearLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    yearLabel.setToolTipText("");
    yearLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    yearLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    yearLabel.setForeground(Color.black);
    printButton.addActionListener(this);
    printButton.setBounds(new Rectangle(802, 478, 134, 55));
    printButton.setBackground(Color.white);
    printButton.setFont(new java.awt.Font("Dialog", 1, 12));
    printButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    printButton.setHorizontalAlignment(SwingConstants.RIGHT);
    printButton.setText("PRINT");
    printButton.setToolTipText("");
    this.getContentPane().add(creditScrollPane, null);
    this.getContentPane().add(creditLabel, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(debitScrollPane, null);
    this.getContentPane().add(debitLabel, null);
    this.getContentPane().add(yearComboBox, null);
    this.getContentPane().add(yearLabel, null);
    this.getContentPane().add(backButton, null);
    this.getContentPane().add(printButton, null);
    this.getContentPane().add(balanceLabel, null);
    this.getContentPane().add(balanceTextField, null);
    this.getContentPane().add(cashInHandLabel, null);
    this.getContentPane().add(cashInHandTextField, null);
    this.getContentPane().add(creditAmountLabel, null);
    this.getContentPane().add(creditAmountTextField, null);
    this.getContentPane().add(debitAmountLabel, null);
    this.getContentPane().add(debitAmountTextField, null);
    this.getContentPane().add(headingLabel1, null);
    this.getContentPane().add(headingLabel, null);
    debitScrollPane.getViewport().add(debitTable, null);
    creditScrollPane.getViewport().add(creditTable, null);
  this.getContentPane().setBackground(Color.white);

  headingLabel.setForeground(Color.black);
  creditLabel.setForeground(Color.black);

  Border border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.gray,Color.darkGray,new Color(58, 110, 165)),BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,Color.darkGray,new Color(58, 110, 165)));

  printButton.setBorder(border);
  cashInHandTextField.setBorder(border);
  balanceTextField.setBorder(border);
  debitScrollPane.setBorder(border);
  creditScrollPane.setBorder(border);
  backButton.setBorder(border);
    creditAmountTextField.setBorder(border);
debitAmountTextField.setBorder(border);
  backButton.addActionListener(this);
    yearComboBox.setBorder(border);

  debitTable.setFont(new Font("arial",Font.BOLD,12));
  creditTable.setFont(new Font("arial",Font.BOLD,12));

  Toolkit kit=this.getToolkit();
  Dimension d=kit.getScreenSize();
  this.setBounds(0,0,d.width,d.height);
  yearComboBox.addActionListener(this);
//  getCashRegister();
 }//end constructor

 public void actionPerformed(ActionEvent e){
  if(backButton==e.getSource())  hide();
  if(yearComboBox==e.getSource())allCustomer();
  if(printButton==e.getSource()) print();
 }//end method

  private void print(){
   CashRegisterRecord rec=(CashRegisterRecord)yearComboBox.getSelectedItem();
   if(rec==null)return;
   String year=rec.year ;

   String creditAmountStr=creditAmountTextField.getText();
   String debitAmountStr=debitAmountTextField.getText();
   String balanceStr=balanceTextField.getText();
   String cashInHandStr=cashInHandTextField.getText();


  try{
      ReportFrame.cashReportPrint(creditObj,debitObj,creditAmountStr,debitAmountStr,balanceStr,cashInHandStr,year,"","Account Payable/ Receivable");
   }catch(Exception e){
     JOptionPane.showMessageDialog(this,""+e);
     e.printStackTrace();
   }
  }//end mthod

 private void showAccount(final java.util.Vector debitVector, final java.util.Vector creditVector){
 try{
   final String[] creditColumnNames = {"CUSTOMER NAME","AMOUNT"};

   TableModel creditDataModel = new AbstractTableModel() {
      public int getColumnCount() { return creditColumnNames.length; }
      public int getRowCount() { return creditVector.size();}
      public Object getValueAt(int row, int col) {
         CustomerTransactionRecord rec=(CustomerTransactionRecord)creditVector.elementAt(row);
         if(rec==null)return null;
         if(col==0)
            return rec.customer_name;
         else{

            if(rec.isProduct)return rec.amount;
	    else
            return ""+rec.getBalance();
         }
      }//end method
            public String getColumnName(int column) {return creditColumnNames[column];}
            public Class getColumnClass(int col) {return getValueAt(0,col).getClass();}
            public boolean isCellEditable(int row, int col) {return false;}
            public void setValueAt(Object aValue, int row, int column) {
                //data[row][column] = aValue;
            }
         };


   final String[] debitColumnNames = {"CUSTOMER NAME","AMOUNT"};

   TableModel debitDataModel = new AbstractTableModel() {
      public int getColumnCount() { return debitColumnNames.length; }
      public int getRowCount() { return debitVector.size();}
      public Object getValueAt(int row, int col) {
         CustomerTransactionRecord rec=(CustomerTransactionRecord)debitVector.elementAt(row);
         if(rec==null)return null;
         if(col==0)
            return rec.customer_name;
         else{

            if(rec.isProduct)return rec.amount;
	    else
            return ""+rec.getBalance();
         }
      }//end method
            public String getColumnName(int column) {return debitColumnNames[column];}
            public Class getColumnClass(int col) {return getValueAt(0,col).getClass();}
            public boolean isCellEditable(int row, int col) {return false;}
            public void setValueAt(Object aValue, int row, int column) {
                //data[row][column] = aValue;
            }
         };

        TableSorter creditSorter = new TableSorter(creditDataModel);
        creditSorter.addMouseListenerToHeaderInTable(creditTable);
        creditTable.setModel(creditSorter);

        TableSorter  debitSorter = new TableSorter(debitDataModel);
        debitSorter.addMouseListenerToHeaderInTable(debitTable);
        debitTable.setModel(debitSorter);

 }catch(Exception e){
   e.printStackTrace();
 }
}//end method


 public void show(){
getCashRegister();
 //   this.allCustomer();/// getCashBook();
   super.show();
 }///////////////////////////////////////////end method


private void allCustomer(){
 try{
    CashRegisterRecord cashRegisterRec=(CashRegisterRecord)yearComboBox.getSelectedItem();
    if(cashRegisterRec==null){
//      JOptionPane.showMessageDialog(this,"Cash Register year does not selected....");
      return;
    }

   String debit_credit="B";
   String dateFrom="";
   String dateTo="";

   java.util.Vector v=DatabaseManager.getCustomers(uar);

   java.util.Vector debitVector=new java.util.Vector();
   java.util.Vector creditVector=new java.util.Vector();



   int creditAmount=0;
   int debitAmount=0;

   for(int i=0; i<v.size(); i++){
     CustomerRecord customerRec=(CustomerRecord)v.elementAt(i);
     if(customerRec==null) continue;

      CustomerTransactionRecord customerTransRec=DatabaseManager.getCustomerTransactions(customerRec.customer_id,cashRegisterRec.cash_reg_id,dateFrom,dateTo,debit_credit,cashRegisterRec.year,"DESC");
      if(customerTransRec==null)continue;

      customerTransRec.customer_name=customerRec.name;
      double b=customerTransRec.getBalance();
      boolean IS_CREDIT=customerTransRec.isCredit();

      if(IS_CREDIT){
            creditVector.addElement(customerTransRec);
            creditAmount+=b;
     }else{
            debitVector.addElement(customerTransRec);
            debitAmount+=b;
     }
   }//END LOOP


   int creditAmount1 =DatabaseManager.setProduct(creditVector,">0");
   int debitAmount1  =DatabaseManager.setProduct(debitVector,"<0");

   creditAmount+=creditAmount1;
   debitAmount-=debitAmount1;


   int cashInHand=Integer.parseInt(cashRegisterRec.current_balance);
//   int cashInHand=DatabaseManager.getCurrentBalanceFromCashRegister();
   String credit_credit_str="CREDIT";
   int balance=0;

   if (debitAmount>creditAmount){
      credit_credit_str="DEBIT";
      balance=debitAmount-creditAmount;
   }

   if (creditAmount>=debitAmount){
      credit_credit_str="CREDIT";
      balance=creditAmount-debitAmount;
   }

   this.creditAmountTextField.setText("Rs. "+creditAmount+"/=");
   this.debitAmountTextField.setText("Rs. "+debitAmount+"/=");
   this.balanceTextField.setText("Rs. "+balance+"/ "+credit_credit_str);
   this.cashInHandTextField.setText("Rs. "+(cashInHand<0?-(cashInHand):cashInHand)+"/ "+(cashInHand<=0?"CREDIT":"DEBIT") );

   creditObj= creditVector.toArray();
   debitObj=debitVector.toArray();

   showAccount(debitVector,creditVector);
 }catch(Exception e){
   e.printStackTrace();
 }
}////end method

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
}//////////end method

}//end class