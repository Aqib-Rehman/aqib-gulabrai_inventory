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

public class CashBookFrame extends JFrame implements ActionListener{
  private JLabel headingLabel = new JLabel();
  private JLabel headingLabel1 = new JLabel();
  private JLabel creditLabel = new JLabel();
  private JLabel debitLabel = new JLabel();

  private JScrollPane debitScrollPane = new JScrollPane();
  private JScrollPane creditScrollPane = new JScrollPane();

  private Object creditObj[];
  private Object debitObj[];

  private JButton backButton = new JButton(new ImageIcon("back.jpg"));

  private JTextField currentDateTextField = new JTextField();

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
  private JLabel currentDateLabel = new JLabel();

  private JLabel jLabel4 = new JLabel(new ImageIcon("4.jpg"));

  private   JButton cashReportButton = new JButton(new ImageIcon("printer.jpg"));
  JTextField toDateTextField = new JTextField();
  JLabel toDateLabel = new JLabel();
private UserAccountRecord uar;
int frame_id;
public void setUser(UserAccountRecord uar ){
    this.uar = uar;
}

  public CashBookFrame() {
  super("CASH BOOK");
    try {
      jbInit();
      frame_id=4;
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {

    Border border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151));

    headingLabel.setFont(new java.awt.Font("Dialog", 1, 30));
    headingLabel.setText("CASH BOOK");
    headingLabel.setBounds(new Rectangle(407, 41, 240, 33));
    this.getContentPane().setLayout(null);
    creditScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    creditScrollPane.setBounds(new Rectangle(524, 178, 320, 415));
    creditLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    creditLabel.setToolTipText("");
    creditLabel.setText("CREDIT");
    creditLabel.setBounds(new Rectangle(525, 158, 47, 29));
    backButton.setBounds(new Rectangle(847, 545, 134, 50));
    backButton.setBackground(Color.white);
    backButton.setFont(new java.awt.Font("Dialog", 1, 12));
    backButton.setHorizontalAlignment(SwingConstants.RIGHT);
    backButton.setText("BACK");
    headingLabel1.setForeground(Color.lightGray);
    headingLabel1.setBounds(new Rectangle(404, 38, 240, 33));
    headingLabel1.setText("CASH BOOK");
    headingLabel1.setFont(new java.awt.Font("Dialog", 1, 30));
    jLabel4.setText("");
    jLabel4.setBounds(new Rectangle(842, 57, 197, 178));
    debitScrollPane.setBounds(new Rectangle(196, 178, 320, 415));
    debitScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    debitLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    debitLabel.setToolTipText("");
    debitLabel.setText("DEBIT");
    debitLabel.setBounds(new Rectangle(197, 158, 42, 29));
    debitLabel.setForeground(Color.black);

        this.setResizable(false);

    currentDateTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    currentDateTextField.setBounds(new Rectangle(231, 120, 88, 28));
    currentDateLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    currentDateLabel.setText("DATE");
    currentDateLabel.setBounds(new Rectangle(199, 120, 38, 28));
    debitAmountTextField.setBounds(new Rectangle(847, 356, 134, 28));
    debitAmountTextField.setEditable(false);
    debitAmountTextField.setFont(new java.awt.Font("Dialog", 1, 12));

    creditAmountTextField.setBounds(new Rectangle(847, 310, 134, 28));
    creditAmountTextField.setEditable(false);
    creditAmountTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    creditAmountLabel.setBounds(new Rectangle(847, 294, 94, 21));
    creditAmountLabel.setText("CREDIT AMOUNT");
    creditAmountLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    debitAmountLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    debitAmountLabel.setText("DEBIT AMOUNT");
    debitAmountLabel.setBounds(new Rectangle(847, 340, 88, 21));
    balanceTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    balanceTextField.setEditable(false);
    balanceTextField.setBounds(new Rectangle(847, 402, 134, 28));
    balanceLabel.setBounds(new Rectangle(847, 386, 88, 21));
    balanceLabel.setText("BALANCE");
    balanceLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    cashInHandLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    cashInHandLabel.setText("CASH IN HAND");
    cashInHandLabel.setBounds(new Rectangle(847, 431, 88, 21));
    cashInHandTextField.setBounds(new Rectangle(847, 447, 134, 28));
    cashInHandTextField.setEditable(false);
    cashInHandTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    cashReportButton.addActionListener(this);
    toDateTextField.addActionListener(this);

    cashReportButton.setBounds(new Rectangle(846, 483, 134, 55));
    cashReportButton.setBackground(Color.white);
    cashReportButton.setFont(new java.awt.Font("Dialog", 1, 12));
    cashReportButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    cashReportButton.setHorizontalAlignment(SwingConstants.RIGHT);
    cashReportButton.setText("CASH REPORT");
    cashReportButton.setToolTipText("");
    toDateTextField.setBounds(new Rectangle(346, 120, 88, 28));
    toDateTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    toDateLabel.setBounds(new Rectangle(324, 120, 23, 28));
    toDateLabel.setText("TO");
    toDateLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    toDateLabel.setToolTipText("");
    this.getContentPane().add(headingLabel1, null);
    this.getContentPane().add(debitScrollPane, null);
    this.getContentPane().add(debitLabel, null);
    this.getContentPane().add(creditScrollPane, null);
    this.getContentPane().add(creditLabel, null);
    this.getContentPane().add(toDateTextField, null);
    this.getContentPane().add(currentDateLabel, null);
    this.getContentPane().add(toDateLabel, null);
    this.getContentPane().add(currentDateTextField, null);
    this.getContentPane().add(backButton, null);
    this.getContentPane().add(cashReportButton, null);
    this.getContentPane().add(creditAmountLabel, null);
    this.getContentPane().add(creditAmountTextField, null);
    this.getContentPane().add(debitAmountLabel, null);
    this.getContentPane().add(debitAmountTextField, null);
    this.getContentPane().add(balanceLabel, null);
    this.getContentPane().add(balanceTextField, null);
    this.getContentPane().add(cashInHandLabel, null);
    this.getContentPane().add(cashInHandTextField, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(headingLabel, null);
    creditScrollPane.getViewport().add(creditTable, null);
    debitScrollPane.getViewport().add(debitTable, null);
  this.getContentPane().setBackground(Color.white);

  headingLabel.setForeground(Color.black);
  creditLabel.setForeground(Color.black);

  Border border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.gray,Color.darkGray,new Color(58, 110, 165)),BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,Color.darkGray,new Color(58, 110, 165)));
  cashInHandTextField.setBorder(border);
  balanceTextField.setBorder(border);
  currentDateTextField.setBorder(border);
  debitScrollPane.setBorder(border);
  creditScrollPane.setBorder(border);
  backButton.setBorder(border);
    creditAmountTextField.setBorder(border);
debitAmountTextField.setBorder(border);
  backButton.addActionListener(this);
    cashReportButton.setBorder(border);
    toDateTextField.setBorder(border);

  debitTable.setFont(new Font("arial",Font.BOLD,12));
  creditTable.setFont(new Font("arial",Font.BOLD,12));

  Toolkit kit=this.getToolkit();
  Dimension d=kit.getScreenSize();
  this.setBounds(0,0,d.width,d.height);
 }//end constructor

 public void actionPerformed(ActionEvent e){
  if(backButton==e.getSource()) hide();
  if(cashReportButton==e.getSource()) printCashReport();
  if(toDateTextField==e.getSource())    getCashBook();

 }//end method

 private void printCashReport(){
   String current_date=this.currentDateTextField.getText().trim();
   String to_date=this.toDateTextField.getText().trim();

   String creditAmountStr=creditAmountTextField.getText();
   String debitAmountStr=debitAmountTextField.getText();
   String balanceStr=balanceTextField.getText();
   String cashInHandStr=cashInHandTextField.getText();

//   final Object creditObj[]=DatabaseManager.getCashBook("C",current_date,current_date);
//   final Object debitObj[]=DatabaseManager.getCashBook("D",current_date,current_date);
  try{
   ReportFrame.cashReportPrint(creditObj,debitObj,creditAmountStr,debitAmountStr,balanceStr,cashInHandStr, current_date,to_date,"CASH BOOK");
   }catch(Exception e){
     JOptionPane.showMessageDialog(this,""+e);
     e.printStackTrace();
   }
 }
 private void getCashBook(){
 try{
   String current_date=this.currentDateTextField.getText().trim();
   String to_date=this.toDateTextField.getText().trim();

   creditObj=DatabaseManager.getCashBook("C",current_date,to_date,uar);
   debitObj=DatabaseManager.getCashBook("D",current_date,to_date,uar);

   int creditAmount=getAmount(creditObj);
   int debitAmount=getAmount(debitObj);

//   Object creditObj1[]=DatabaseManager.getCashBook("C",null,to_date);
//   Object debitObj1[]=DatabaseManager.getCashBook("D",null,to_date);

//   int creditAmount=getAmount(creditObj1);
 //  int debitAmount=getAmount(debitObj1);


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


   int cashInHand=DatabaseManager.getCurrentBalanceFromCashRegister();
   this.cashInHandTextField.setText("Rs. "+(cashInHand<0?-(cashInHand):cashInHand)+"/ "+(cashInHand<=0?"CREDIT":"DEBIT") );


   final String[] creditColumnNames = {"CUSTOMER NAME","AMOUNT"};

   TableModel creditDataModel = new AbstractTableModel() {
      public int getColumnCount() { return creditColumnNames.length; }
      public int getRowCount() { return creditObj.length;}
      public Object getValueAt(int row, int col) {
         ListItem rec=(ListItem)creditObj[row];
         if(rec==null)return null;
         if(col==0) return rec.CUSTOMER_NAME;
         else
            return new Integer(rec.AMOUNT);
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
      public int getRowCount() { return debitObj.length;}
      public Object getValueAt(int row, int col) {
         ListItem rec=(ListItem)debitObj[row];
         if(rec==null)return null;
         if(col==0)
            return rec.CUSTOMER_NAME;
         else
            return new Integer(rec.AMOUNT);
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

  private int getAmount(Object obj[]){
    int amount=0;
    for(int i=0; i<obj.length; i++){
      ListItem rec=(ListItem)obj[i];
      amount+=Integer.parseInt(rec.AMOUNT);
    }//end for loop
    return amount;
  }//end method



 public void show(){
   this.currentDateTextField.setText(DateFormat.getCurrentDate());
   this.toDateTextField.setText(DateFormat.getCurrentDate());
   getCashBook();
   super.show();
 }///////////////////////////////////////////end method
}//end class