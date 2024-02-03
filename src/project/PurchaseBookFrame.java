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

public class PurchaseBookFrame extends JFrame implements ActionListener,ListSelectionListener{

  private JLabel headingLabel = new JLabel();
  private JLabel headingLabel1 = new JLabel();
  private JLabel customerLabel = new JLabel();
  private JLabel currentBalanceLabel = new JLabel();
  private JLabel RsLabel2 = new JLabel();
  private JLabel kgBagsLabel = new JLabel();
  private JLabel yearLabel = new JLabel();
  private JLabel purchaseIDLabel = new JLabel();
  private JLabel descriptionLabel = new JLabel();
  private JLabel purchaseQuantityLabel = new JLabel();
  private JLabel dateLabel = new JLabel();
  private JLabel bearerLabel = new JLabel();
  private JLabel payableDateLabel = new JLabel();
  private JLabel termsConditionsLabel = new JLabel();
  private JLabel quantityLabel = new JLabel();
  private JLabel qKGBagsLabel = new JLabel();
  private JLabel productLabel = new JLabel();
  private JLabel rateLabel = new JLabel();
  private JLabel ratePerKgBagLabel = new JLabel();
  private JLabel totalAmountLabel = new JLabel();
  private JLabel RsLabel3 = new JLabel();

  private JTextField currentBalanceTextField = new JTextField();
  private JTextField purchaseIDTextField = new JTextField();
  private JTextField purchaseQuantityTextField = new JTextField();
  private JTextField dateTextField = new JTextField();
  private JTextField bearerTextField = new JTextField();
  private JTextField quantityTextField = new JTextField();
  private JTextField rateTextField = new JTextField();
  private JTextField totalAmountTextField = new JTextField();

  private JComboBox customerComboBox = new JComboBox();
  private JComboBox yearComboBox = new JComboBox();
  private JComboBox termsConditionsComboBox = new JComboBox();
  private JComboBox productComboBox = new JComboBox();

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
  private JPanel purchaseBookPanel = new JPanel();
  private JPanel productPanel = new JPanel();
  private JLabel RsLabel = new JLabel();
  private JTextField valueTextField = new JTextField();
  private JLabel valueLabel = new JLabel();

  public PurchaseBookFrame() {
  super("PURCHASE BOOK");
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {

   customerComboBox.setKeySelectionManager(new MyKeySelectionManager());
   yearComboBox.setKeySelectionManager(new MyKeySelectionManager());
   termsConditionsComboBox.setKeySelectionManager(new MyKeySelectionManager());
   productComboBox.setKeySelectionManager(new MyKeySelectionManager());

  termsConditionsComboBox.addItem("CASH");
  termsConditionsComboBox.addItem("CREDIT");

    Border border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151));

    TitledBorder productTitledBorder = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"PRODUCT");
    TitledBorder customerTitledBorder = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"CUSTOMER");
    TitledBorder cashRegisterTitledBorder = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"CASH REGISTER");
    TitledBorder purchaseBookTitledBorder = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"PURCHASE BOOK");

    headingLabel.setFont(new java.awt.Font("Dialog", 1, 30));
    headingLabel.setText("PURCHASE BOOK");
    headingLabel.setBounds(new Rectangle(382, 37, 290, 33));
    this.getContentPane().setLayout(null);
    customerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    customerLabel.setToolTipText("");
    customerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    customerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    customerLabel.setText("CUSTOMER");
    customerLabel.setBounds(new Rectangle(218, 132, 74, 30));
    customerComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    customerComboBox.setBounds(new Rectangle(295, 132, 470, 30));
    currentBalanceLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    currentBalanceLabel.setToolTipText("");
    currentBalanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    this.setResizable(false);


    currentBalanceLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    currentBalanceLabel.setText("CURRENT BALANCE");
    currentBalanceLabel.setBounds(new Rectangle(403, 271, 116, 30));
    RsLabel2.setBounds(new Rectangle(597, 271, 23, 30));
    RsLabel2.setText("Rs");
    RsLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    RsLabel2.setToolTipText("");
    currentBalanceTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    currentBalanceTextField.setEditable(false);
    currentBalanceTextField.setBounds(new Rectangle(523, 271, 71, 30));
    yearComboBox.setEnabled(false);
    yearComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    yearComboBox.setBounds(new Rectangle(295, 271, 97, 30));
    yearLabel.setBounds(new Rectangle(249, 271, 43, 30));
    yearLabel.setText("YEAR");
    yearLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    yearLabel.setToolTipText("");
    yearLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    yearLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    purchaseIDTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    purchaseIDTextField.setEditable(false);
    purchaseIDTextField.setBounds(new Rectangle(295, 348, 71, 30));
    purchaseIDLabel.setBounds(new Rectangle(209, 348, 83, 30));
    purchaseIDLabel.setText("PURCHASE ID");
    purchaseIDLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    purchaseIDLabel.setToolTipText("");
    purchaseIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    purchaseIDLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    kgBagsLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    kgBagsLabel.setToolTipText("");
    kgBagsLabel.setText("KG/ Bags");
    kgBagsLabel.setBounds(new Rectangle(731, 348, 58, 30));
    purchaseQuantityTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    purchaseQuantityTextField.setBounds(new Rectangle(657, 348, 71, 30));
    purchaseQuantityLabel.setBounds(new Rectangle(593, 348, 61, 30));
    purchaseQuantityLabel.setText("QUANTITY");
    purchaseQuantityLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    purchaseQuantityLabel.setToolTipText("");
    purchaseQuantityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    purchaseQuantityLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    dateLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    dateLabel.setToolTipText("");
    dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    dateLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    dateLabel.setText("DATE");
    dateLabel.setBounds(new Rectangle(416, 380, 38, 30));
    dateTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    dateTextField.setBounds(new Rectangle(455, 380, 98, 30));
    bearerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    bearerLabel.setToolTipText("");
    bearerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    bearerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    bearerLabel.setText("BEARER");
    bearerLabel.setBounds(new Rectangle(223, 413, 69, 30));
    bearerTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    bearerTextField.setBounds(new Rectangle(295, 413, 470, 30));
    descriptionLabel.setBounds(new Rectangle(295, 444, 90, 30));
    descriptionLabel.setText("DESCRIPTION");
    descriptionLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionLabel.setToolTipText("");
    descriptionScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionScrollPane.setBounds(new Rectangle(295, 466, 470, 66));
    dateScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    dateScrollPane.setBounds(new Rectangle(783, 117, 107, 484));
    payableDateLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    payableDateLabel.setToolTipText("");
    payableDateLabel.setText("DATES");
    payableDateLabel.setBounds(new Rectangle(817, 98, 47, 25));
    addButton.setBackground(Color.white);
    addButton.setFont(new java.awt.Font("Dialog", 1, 12));
    addButton.setHorizontalAlignment(SwingConstants.RIGHT);
    addButton.setText("ADD");
    addButton.setBounds(new Rectangle(206, 545, 216, 55));
    deleteButton.setBounds(new Rectangle(426, 545, 118, 55));
    deleteButton.setBackground(Color.white);
    deleteButton.setFont(new java.awt.Font("Dialog", 1, 12));
    deleteButton.setHorizontalAlignment(SwingConstants.RIGHT);
    deleteButton.setText("DELETE");
    clearButton.setBounds(new Rectangle(548, 545, 105, 55));
    clearButton.setBackground(Color.white);
    clearButton.setFont(new java.awt.Font("Dialog", 1, 12));
    clearButton.setHorizontalAlignment(SwingConstants.RIGHT);
    clearButton.setText("CLEAR");
    backButton.setBounds(new Rectangle(657, 545, 120, 55));
    backButton.setBackground(Color.white);
    backButton.setFont(new java.awt.Font("Dialog", 1, 12));
    backButton.setHorizontalAlignment(SwingConstants.RIGHT);
    backButton.setText("BACK");
    customerPanel.setBackground(Color.white);
    customerPanel.setBorder(customerTitledBorder);
    customerPanel.setBounds(new Rectangle(205, 118, 572, 53));
    cashRegisterPanel.setBounds(new Rectangle(205, 254, 572, 57));
    cashRegisterPanel.setBackground(Color.white);
    cashRegisterPanel.setBorder(cashRegisterTitledBorder);
    purchaseBookPanel.setBackground(Color.white);
    purchaseBookPanel.setBorder(purchaseBookTitledBorder);
    purchaseBookPanel.setBounds(new Rectangle(205, 325, 572, 216));
    headingLabel1.setForeground(Color.lightGray);
    headingLabel1.setBounds(new Rectangle(384, 41, 276, 33));
    headingLabel1.setText("PURCHASE BOOK");
    headingLabel1.setFont(new java.awt.Font("Dialog", 1, 30));
    termsConditionsLabel.setForeground(Color.black);
    termsConditionsLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    termsConditionsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    termsConditionsLabel.setToolTipText("");
    termsConditionsLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    termsConditionsLabel.setText("TERMS/ CONDITIONS");
    termsConditionsLabel.setBounds(new Rectangle(555, 380, 121, 30));
    termsConditionsComboBox.addActionListener(this);
    termsConditionsComboBox.setBounds(new Rectangle(678, 380, 87, 30));
    termsConditionsComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    productComboBox.setBounds(new Rectangle(295, 184, 470, 30));
    productComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    productPanel.setBounds(new Rectangle(205, 171, 572, 82));
    productPanel.setBorder(productTitledBorder);
    productPanel.setBackground(Color.white);
    quantityLabel.setForeground(Color.black);
    quantityLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    quantityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    quantityLabel.setToolTipText("");
    quantityLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    quantityLabel.setText("QUANTITY");
    quantityLabel.setBounds(new Rectangle(224, 217, 68, 30));
    qKGBagsLabel.setForeground(Color.black);
    qKGBagsLabel.setBounds(new Rectangle(410, 217, 65, 30));
    qKGBagsLabel.setText("KG/ Bags");
    qKGBagsLabel.setToolTipText("");
    qKGBagsLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    quantityTextField.setBounds(new Rectangle(295, 217, 110, 30));
//    quantityTextField.setBounds(new Rectangle(143, 148, 71, 30));
    quantityTextField.setEditable(false);
    quantityTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    productLabel.setForeground(Color.black);
    productLabel.setBounds(new Rectangle(218, 184, 74, 30));
    productLabel.setText("PRODUCT");
    productLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    productLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    productLabel.setToolTipText("");
    productLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    rateLabel.setForeground(Color.black);
    rateLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    rateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    rateLabel.setToolTipText("");
    rateLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    rateLabel.setText("RATE");
    rateLabel.setBounds(new Rectangle(256, 380, 37, 30));
    ratePerKgBagLabel.setForeground(Color.black);
    ratePerKgBagLabel.setBounds(new Rectangle(369, 380, 67, 30));
    ratePerKgBagLabel.setText("Per KG/ Bag");
    ratePerKgBagLabel.setToolTipText("");
    ratePerKgBagLabel.setFont(new java.awt.Font("Dialog", 1, 12));

    rateTextField.setBounds(new Rectangle(295, 380, 71, 30));
    rateTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    totalAmountLabel.setForeground(Color.black);
    totalAmountLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    totalAmountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    totalAmountLabel.setToolTipText("");
    totalAmountLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    totalAmountLabel.setText("TOTAL AMOUNT");
    totalAmountLabel.setBounds(new Rectangle(371, 348, 94, 30));
    RsLabel3.setForeground(Color.black);
    RsLabel3.setBounds(new Rectangle(555, 348, 23, 30));
    RsLabel3.setText("Rs");
    RsLabel3.setToolTipText("");
    RsLabel3.setFont(new java.awt.Font("Dialog", 1, 12));

    totalAmountTextField.setBounds(new Rectangle(470, 348, 83, 30));
    totalAmountTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    dateList.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionTextArea.setFont(new java.awt.Font("Dialog", 1, 12));
    RsLabel.setBounds(new Rectangle(628, 217, 22, 30));
    RsLabel.setText("Rs");
    RsLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    RsLabel.setToolTipText("");
    RsLabel.setHorizontalAlignment(SwingConstants.LEFT);
    RsLabel.setHorizontalTextPosition(SwingConstants.LEFT);
    RsLabel.setForeground(Color.black);
    valueTextField.setBounds(new Rectangle(522, 217, 104, 30));
    valueTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    valueTextField.setEditable(false);
    valueLabel.setForeground(Color.black);
    valueLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    valueLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    valueLabel.setToolTipText("");
    valueLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    valueLabel.setText("VALUE");
    valueLabel.setBounds(new Rectangle(475, 217, 43, 30));
    this.getContentPane().add(dateScrollPane, null);
    this.getContentPane().add(bearerTextField, null);
    this.getContentPane().add(purchaseIDTextField, null);
    this.getContentPane().add(purchaseIDLabel, null);
    this.getContentPane().add(bearerLabel, null);
    this.getContentPane().add(descriptionLabel, null);
    this.getContentPane().add(descriptionScrollPane, null);
    this.getContentPane().add(termsConditionsComboBox, null);
    this.getContentPane().add(clearButton, null);
    this.getContentPane().add(addButton, null);
    this.getContentPane().add(backButton, null);
    this.getContentPane().add(payableDateLabel, null);
    this.getContentPane().add(deleteButton, null);
    this.getContentPane().add(dateTextField, null);
    this.getContentPane().add(rateLabel, null);
    this.getContentPane().add(rateTextField, null);
    this.getContentPane().add(ratePerKgBagLabel, null);
    this.getContentPane().add(purchaseQuantityTextField, null);
    this.getContentPane().add(kgBagsLabel, null);
    this.getContentPane().add(purchaseQuantityLabel, null);
    this.getContentPane().add(RsLabel3, null);
    this.getContentPane().add(totalAmountTextField, null);
    this.getContentPane().add(dateLabel, null);
    this.getContentPane().add(termsConditionsLabel, null);
    this.getContentPane().add(productLabel, null);
    this.getContentPane().add(productComboBox, null);
    this.getContentPane().add(quantityLabel, null);
    this.getContentPane().add(qKGBagsLabel, null);
    this.getContentPane().add(quantityTextField, null);
    this.getContentPane().add(valueTextField, null);
    this.getContentPane().add(valueLabel, null);
    this.getContentPane().add(currentBalanceTextField, null);
    this.getContentPane().add(RsLabel2, null);
    this.getContentPane().add(yearComboBox, null);
    this.getContentPane().add(currentBalanceLabel, null);
    this.getContentPane().add(yearLabel, null);
    this.getContentPane().add(cashRegisterPanel, null);
    this.getContentPane().add(customerComboBox, null);
    this.getContentPane().add(customerLabel, null);
    this.getContentPane().add(customerPanel, null);
    this.getContentPane().add(headingLabel1, null);
    this.getContentPane().add(headingLabel, null);
    this.getContentPane().add(RsLabel, null);
    this.getContentPane().add(productPanel, null);
    this.getContentPane().add(totalAmountLabel, null);
    this.getContentPane().add(purchaseBookPanel, null);
    descriptionScrollPane.getViewport().add(descriptionTextArea, null);
    dateScrollPane.getViewport().add(dateList, null);
  this.getContentPane().setBackground(Color.white);

  headingLabel.setForeground(Color.black);
  customerLabel.setForeground(Color.black);
  currentBalanceLabel.setForeground(Color.black);
  RsLabel2.setForeground(Color.black);
  kgBagsLabel.setForeground(Color.black);
  yearLabel.setForeground(Color.black);
  purchaseIDLabel.setForeground(Color.black);
  descriptionLabel.setForeground(Color.black);
  purchaseQuantityLabel.setForeground(Color.black);
  dateLabel.setForeground(Color.black);
  bearerLabel.setForeground(Color.black);
  payableDateLabel.setForeground(Color.black);

  Border border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.gray,Color.darkGray,new Color(58, 110, 165)),BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,Color.darkGray,new Color(58, 110, 165)));

    valueTextField.setBorder(border);
  productComboBox.setBorder(border);
  totalAmountTextField.setBorder(border);
  rateTextField.setBorder(border);
  quantityTextField.setBorder(border);

  termsConditionsComboBox.setBorder(border);
  currentBalanceTextField.setBorder(border);
  purchaseIDTextField.setBorder(border);
  purchaseQuantityTextField.setBorder(border);
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
  productComboBox.addActionListener(this);
  purchaseQuantityTextField.addActionListener(this);

  dateList.addListSelectionListener(this);


  Toolkit kit=this.getToolkit();
  Dimension d=kit.getScreenSize();
  this.setBounds(0,0,d.width,d.height);
//  getProduct();
//  getCustomers();
//  getCashRegister();
 }//end constructor

 public void valueChanged(ListSelectionEvent e){
  PurchaseSaleBookRecord rec=(PurchaseSaleBookRecord)dateList.getSelectedValue();
  if(rec==null)return;

  purchaseIDTextField.setText(rec.product_id );
  rateTextField.setText(rec.rate_mund_bag);
  totalAmountTextField.setText(rec.total_amount);
  purchaseQuantityTextField.setText(rec.quantity_kg_bag );
  dateTextField.setText(rec.trans_date);
  termsConditionsComboBox.setSelectedItem(rec.terms_and_conditions);
  descriptionTextArea.setText(rec.remarks);
  bearerTextField.setText(rec.bearer);
 }//end method
 public void actionPerformed(ActionEvent e){
  if(addButton==e.getSource()) addRecord();
  if(deleteButton==e.getSource()) deleteRecord();
  if(clearButton==e.getSource()) clearRecord();
  if(backButton==e.getSource()) hide();
  if(productComboBox==e.getSource())  getPurchaseBook();
  if(customerComboBox==e.getSource()) getPurchaseBook();
  if(yearComboBox==e.getSource())     getPurchaseBook();
  if(purchaseQuantityTextField==e.getSource())     setRate();

 }//end method

 private void setRate(){
   String totalAmountStr=totalAmountTextField.getText();
   String quantityStr   =purchaseQuantityTextField.getText().trim();
   if(!Decode.isNumeric(totalAmountStr)){
     JOptionPane.showMessageDialog(this,"Enter Total Amount.....");
     return;
   }
   if(!Decode.isNumeric(quantityStr)){
     JOptionPane.showMessageDialog(this,"Enter Quantity.....");
     return;
   }


   double totalAmount=Double.parseDouble(totalAmountStr);
   double quantity   =Double.parseDouble(quantityStr);
   rateTextField.setText(""+(totalAmount/quantity));
 }//end method

 private void getPurchaseBook(){
    CustomerRecord customerRec=(CustomerRecord)customerComboBox.getSelectedItem();
    if(customerRec==null) return;

    ProductRecord productRec=(ProductRecord)productComboBox.getSelectedItem();
    if(productRec==null) return;
    quantityTextField.setText(productRec.quantity_available);
    valueTextField.setText(productRec.product_value);

    String measurementUnit=Decode.measurementUnitDecode(productRec.measurement_unit);

    qKGBagsLabel.setText(measurementUnit);
//    ratePerKgBagLabel.setText("Per "+measurementUnit);
    ratePerKgBagLabel.setText(""+measurementUnit);
    kgBagsLabel.setText(measurementUnit);

/*
    qKGBagsLabel.setText(productRec.measurement_unit.equals("K")?"KG":"BAGS");
    ratePerKgBagLabel.setText(productRec.measurement_unit.equals("K")?"Per KG":"Per BAG");
    kgBagsLabel.setText(productRec.measurement_unit.equals("K")?"KG":"BAGS");
*/
    CashRegisterRecord cashRegisterRec=(CashRegisterRecord)yearComboBox.getSelectedItem();
    if(cashRegisterRec==null) return;
    currentBalanceTextField.setText(cashRegisterRec.current_balance);

    try{
       java.util.Vector v=DatabaseManager.getPurchaseSaleBook(productRec.product_id, customerRec.customer_id, cashRegisterRec.cash_reg_id, "P");
       dateList.setListData(v);
    }catch(Exception e){
      e.printStackTrace();
    }

 }//end method

  private void getProduct(){
  try{
   java.util.Vector v=DatabaseManager.getProduct();
   productComboBox.removeAllItems();

   for(int index=0; index<v.size(); index++)
     productComboBox.addItem(v.elementAt(index));
 }catch(Exception e){
  JOptionPane.showMessageDialog(this,"Database Driver check ODBC ["+e.getMessage()+"]");
  e.printStackTrace();
 }
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


 private void addRecord(){

    int customerRecIndex=customerComboBox.getSelectedIndex();
    CustomerRecord customerRec=(CustomerRecord)customerComboBox.getItemAt(customerRecIndex);
    if(customerRec==null){
      JOptionPane.showMessageDialog(this,"Select Customer....");
      return;
    }

    int productRecIndex=productComboBox.getSelectedIndex();
    ProductRecord productRec=(ProductRecord)productComboBox.getItemAt(productRecIndex);
    if(productRec==null){
      JOptionPane.showMessageDialog(this,"Select Product....");
      return;
    }

    int cashRegisterRecIndex=yearComboBox.getSelectedIndex();
    CashRegisterRecord cashRegisterRec=(CashRegisterRecord)yearComboBox.getItemAt(cashRegisterRecIndex);
    if(cashRegisterRec==null){
      JOptionPane.showMessageDialog(this,"Select Year....");
      return;
    }

    String termsConditions=(String)termsConditionsComboBox.getSelectedItem();
    if(termsConditions==null){
      JOptionPane.showMessageDialog(this,"Select Terms and Conditions....");
      return;
    }
    String product_name=productRec.name;
    String customer_name=customerRec.name;

    String product_id=productRec.product_id;
    String customer_id=customerRec.customer_id;
    String cash_reg_id=cashRegisterRec.cash_reg_id;

    String quantity_kg_bag=purchaseQuantityTextField.getText().trim();
    String rate_mund_bag=rateTextField.getText().trim();
    String total_amount=totalAmountTextField.getText().trim();

    String trans_date=dateTextField.getText().trim();
    String bearer=bearerTextField.getText().trim();
    String terms_and_conditions=termsConditions.trim();
    String remarks=descriptionTextArea.getText().trim();
    String trans_type="P";


    if(!Decode.isDate(trans_date)){
       JOptionPane.showMessageDialog(this,"Enter Date [INVALID DATE FORMATE].....");
       return;
    }

    if(! Decode.isNumeric(quantity_kg_bag)){
       JOptionPane.showMessageDialog(this,"Quantity must enter in NUMERIC form.....");
       return;
    }

    if(! Decode.isNumeric(rate_mund_bag)){
       JOptionPane.showMessageDialog(this,"Rate must enter in NUMERIC form.....");
       return;
    }

    if(! Decode.isNumeric(total_amount)){
       JOptionPane.showMessageDialog(this,"Total Amount must enter in NUMERIC form.....");
       return;
    }

    if(bearer.equals(""))bearer="....";
    if(remarks.equals(""))remarks="P/ "+product_name+"/ "+quantity_kg_bag;


  try{
    int rows=DatabaseManager.addPurchaseSaleBook(product_id,
                        			 customer_id,
			                         cash_reg_id,
			                         quantity_kg_bag,
			                         rate_mund_bag,
			                         total_amount,
			                         trans_date,
			                         trans_type,
			                         bearer,
			                         terms_and_conditions,
			                         remarks);

   if(rows>=1){
         rows=DatabaseManager.productIteration(product_id,quantity_kg_bag,total_amount,"D");
         if(terms_and_conditions.equals("CASH")){
             if(rows>=1)
                  rows=DatabaseManager.cashRegisterIteration(cash_reg_id,total_amount,"C");
         }else{
             if(rows>=1){
                int purchase_sale_id=DatabaseManager.getLastPurchaseSaleID();
                rows=DatabaseManager.addTransactionPurchaseSale(""+purchase_sale_id,customer_id,cash_reg_id,total_amount,"D",trans_date,bearer,"P/ "+product_name+"/ "+quantity_kg_bag);

             }//end if
         }

        if(rows>=1){
          JOptionPane.showMessageDialog(this,"Record Successfully SAVED.....");
          refresh();

          customerComboBox.setSelectedIndex(customerRecIndex);
          productComboBox.setSelectedIndex(productRecIndex);
          yearComboBox.setSelectedIndex(cashRegisterRecIndex);

          getPurchaseBook();
          clearRecord();
       }//end if
   }//END OUTER IF

  }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
  }
}//end method

 private void deleteRecord(){
    int customerRecIndex=customerComboBox.getSelectedIndex();
    int productRecIndex=productComboBox.getSelectedIndex();
    int cashRegisterRecIndex=yearComboBox.getSelectedIndex();

    PurchaseSaleBookRecord rec=(PurchaseSaleBookRecord)dateList.getSelectedValue();
    if(rec==null){
     JOptionPane.showMessageDialog(this,"Please Select Date.....");
     return;
    }

  int confirm=JOptionPane.showConfirmDialog(this,"Are you sure to remove selected record?","Confirmation...",JOptionPane.YES_NO_OPTION);
  if(confirm==JOptionPane.NO_OPTION)return;

 try{
   int rows=DatabaseManager.productIteration(rec.product_id,rec.quantity_kg_bag,rec.total_amount,"C");

   if(rec.terms_and_conditions.equals("CASH"))
        if(rows>=1)rows=DatabaseManager.cashRegisterIteration(rec.cash_reg_id,rec.total_amount,"D");
   if(rec.terms_and_conditions.equals("CREDIT"))
        if(rows>=1)rows=DatabaseManager.deleteTransaction(rec.purchase_sale_id,rec.customer_id,rec.cash_reg_id);

   rows=DatabaseManager.deletePurchaseSaleBook(rec.purchase_sale_id);
   if(rows>=1){
     JOptionPane.showMessageDialog(this,"Record Successfully REMOVED.....");
     refresh();

     customerComboBox.setSelectedIndex(customerRecIndex);
     productComboBox.setSelectedIndex(productRecIndex);
     yearComboBox.setSelectedIndex(cashRegisterRecIndex);

     getPurchaseBook();
     clearRecord();
  }//end if

 }catch(Exception e){
  JOptionPane.showMessageDialog(this,e.getMessage());
  e.printStackTrace();
 }
}//END method

 private void clearRecord(){
  purchaseIDTextField.setText("");
  rateTextField.setText("");
  totalAmountTextField.setText("");
  purchaseQuantityTextField.setText("");
//  dateTextField.setText("");
//  bearerTextField.setText("");
  descriptionTextArea.setText("");
 }///end method

 public void show(){
  refresh();
   super.show();
 }///end method

  private void refresh(){
   this.getCustomers();
   this.getProduct();
   this.getCashRegister();
   this.dateTextField.setText(DateFormat.getCurrentDate());
  }///////////////////end method


}//end class

