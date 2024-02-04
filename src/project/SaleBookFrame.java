package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class SaleBookFrame extends JFrame implements ActionListener,ListSelectionListener{

  private JLabel headingLabel = new JLabel();
  private JLabel headingLabel1 = new JLabel();
  private JLabel customerLabel = new JLabel();
  private JLabel currentBalanceLabel = new JLabel();
  private JLabel RsLabel2 = new JLabel();
  private JLabel kgBagsLabel = new JLabel();
  private JLabel yearLabel = new JLabel();
  private JLabel saleIDLabel = new JLabel();
  private JLabel descriptionLabel = new JLabel();
  private JLabel saleQuantityLabel = new JLabel();
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
  private JTextField saleIDTextField = new JTextField();
  private JTextField saleQuantityTextField = new JTextField();
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
  private JPanel saleBookPanel = new JPanel();
  private JPanel productPanel = new JPanel();
  private JTextField valueTextField = new JTextField();
  private JLabel valueLabel = new JLabel();
  private JLabel RsLabel = new JLabel();

  public SaleBookFrame() {
  super("SALE BOOK");
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
    TitledBorder saleBookTitledBorder = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"SALE BOOK");

    headingLabel.setFont(new java.awt.Font("Dialog", 1, 30));
    headingLabel.setText("SALE BOOK");
    headingLabel.setBounds(new Rectangle(392, 56, 290, 33));
    this.getContentPane().setLayout(null);
    customerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    customerLabel.setToolTipText("");
    customerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    customerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    customerLabel.setText("CUSTOMER");
    this.setResizable(false);

    customerLabel.setBounds(new Rectangle(240, 163, 74, 30));
    customerComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    customerComboBox.setBounds(new Rectangle(317, 163, 470, 30));
    currentBalanceLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    currentBalanceLabel.setToolTipText("");
    currentBalanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    currentBalanceLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    currentBalanceLabel.setText("CURRENT BALANCE");
    currentBalanceLabel.setBounds(new Rectangle(422, 304, 116, 30));
    RsLabel2.setBounds(new Rectangle(641, 304, 23, 30));
    RsLabel2.setText("Rs");
    RsLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    RsLabel2.setToolTipText("");
    currentBalanceTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    currentBalanceTextField.setEditable(false);
    currentBalanceTextField.setBounds(new Rectangle(542, 304, 88, 30));
    yearComboBox.setEnabled(false);
    yearComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    yearComboBox.setBounds(new Rectangle(317, 304, 97, 30));
    yearLabel.setBounds(new Rectangle(271, 304, 43, 30));
    yearLabel.setText("YEAR");
    yearLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    yearLabel.setToolTipText("");
    yearLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    yearLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    saleIDTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    saleIDTextField.setEditable(false);
    saleIDTextField.setBounds(new Rectangle(317, 390, 71, 30));
    saleIDLabel.setBounds(new Rectangle(231, 390, 83, 30));
    saleIDLabel.setText("SALE ID");
    saleIDLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    saleIDLabel.setToolTipText("");
    saleIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    saleIDLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    kgBagsLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    kgBagsLabel.setToolTipText("");
    kgBagsLabel.setText("KG/ Bags");
    kgBagsLabel.setBounds(new Rectangle(753, 390, 58, 30));
    saleQuantityTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    saleQuantityTextField.setBounds(new Rectangle(679, 390, 71, 30));
    saleQuantityLabel.setBounds(new Rectangle(615, 390, 61, 30));
    saleQuantityLabel.setText("QUANTITY");
    saleQuantityLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    saleQuantityLabel.setToolTipText("");
    saleQuantityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    saleQuantityLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    dateLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    dateLabel.setToolTipText("");
    dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    dateLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    dateLabel.setText("DATE");
    dateLabel.setBounds(new Rectangle(438, 422, 38, 30));
    dateTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    dateTextField.setBounds(new Rectangle(477, 422, 98, 30));
    bearerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    bearerLabel.setToolTipText("");
    bearerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    bearerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    bearerLabel.setText("BEARER");
    bearerLabel.setBounds(new Rectangle(245, 455, 69, 30));
    bearerTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    bearerTextField.setBounds(new Rectangle(317, 455, 470, 30));
    descriptionLabel.setBounds(new Rectangle(317, 486, 90, 30));
    descriptionLabel.setText("DESCRIPTION");
    descriptionLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionLabel.setToolTipText("");
    descriptionScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionScrollPane.setBounds(new Rectangle(317, 508, 470, 66));
    dateScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    dateScrollPane.setBounds(new Rectangle(805, 159, 107, 484));
    payableDateLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    payableDateLabel.setToolTipText("");
    payableDateLabel.setText("DATES");
    payableDateLabel.setBounds(new Rectangle(839, 140, 47, 25));
    addButton.setBackground(Color.white);
    addButton.setFont(new java.awt.Font("Dialog", 1, 12));
    addButton.setHorizontalAlignment(SwingConstants.RIGHT);
    addButton.setText("ADD");
    addButton.setBounds(new Rectangle(228, 587, 216, 55));
    deleteButton.setBounds(new Rectangle(448, 587, 118, 55));
    deleteButton.setBackground(Color.white);
    deleteButton.setFont(new java.awt.Font("Dialog", 1, 12));
    deleteButton.setHorizontalAlignment(SwingConstants.RIGHT);
    deleteButton.setText("DELETE");
    clearButton.setBounds(new Rectangle(570, 587, 105, 55));
    clearButton.setBackground(Color.white);
    clearButton.setFont(new java.awt.Font("Dialog", 1, 12));
    clearButton.setHorizontalAlignment(SwingConstants.RIGHT);
    clearButton.setText("CLEAR");
    backButton.setBounds(new Rectangle(679, 587, 120, 55));
    backButton.setBackground(Color.white);
    backButton.setFont(new java.awt.Font("Dialog", 1, 12));
    backButton.setHorizontalAlignment(SwingConstants.RIGHT);
    backButton.setText("BACK");
    customerPanel.setBackground(Color.white);
    customerPanel.setBorder(customerTitledBorder);
    customerPanel.setBounds(new Rectangle(227, 149, 572, 53));
    cashRegisterPanel.setBounds(new Rectangle(227, 287, 572, 57));
    cashRegisterPanel.setBackground(Color.white);
    cashRegisterPanel.setBorder(cashRegisterTitledBorder);
    saleBookPanel.setBackground(Color.white);
    saleBookPanel.setBorder(saleBookTitledBorder);
    saleBookPanel.setBounds(new Rectangle(227, 367, 572, 216));
    headingLabel1.setForeground(Color.lightGray);
    headingLabel1.setBounds(new Rectangle(395, 58, 276, 33));
    headingLabel1.setText("SALE BOOK");
    headingLabel1.setFont(new java.awt.Font("Dialog", 1, 30));
    termsConditionsLabel.setForeground(Color.black);
    termsConditionsLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    termsConditionsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    termsConditionsLabel.setToolTipText("");
    termsConditionsLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    termsConditionsLabel.setText("TERMS/ CONDITIONS");
    termsConditionsLabel.setBounds(new Rectangle(577, 422, 121, 30));
    termsConditionsComboBox.addActionListener(this);
    termsConditionsComboBox.setBounds(new Rectangle(700, 422, 87, 30));
    termsConditionsComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    productComboBox.setBounds(new Rectangle(317, 218, 470, 30));
    productComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    productPanel.setBounds(new Rectangle(227, 205, 572, 82));
    productPanel.setBorder(productTitledBorder);
    productPanel.setBackground(Color.white);
    quantityLabel.setForeground(Color.black);
    quantityLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    quantityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    quantityLabel.setToolTipText("");
    quantityLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    quantityLabel.setText("QUANTITY");
    quantityLabel.setBounds(new Rectangle(246, 251, 68, 30));
    qKGBagsLabel.setForeground(Color.black);
    qKGBagsLabel.setBounds(new Rectangle(431, 251, 65, 30));
    qKGBagsLabel.setText("KG/ Bags");
    qKGBagsLabel.setToolTipText("");
    qKGBagsLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    quantityTextField.setBounds(new Rectangle(317, 251, 110, 30));
    quantityTextField.setEditable(false);
    quantityTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    productLabel.setForeground(Color.black);
    productLabel.setBounds(new Rectangle(240, 218, 74, 30));
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
    rateLabel.setBounds(new Rectangle(278, 422, 37, 30));
    ratePerKgBagLabel.setForeground(Color.black);
    ratePerKgBagLabel.setBounds(new Rectangle(391, 422, 67, 30));
    ratePerKgBagLabel.setText("Per KG/ Bag");
    ratePerKgBagLabel.setToolTipText("");
    ratePerKgBagLabel.setFont(new java.awt.Font("Dialog", 1, 12));

    rateTextField.setBounds(new Rectangle(317, 422, 71, 30));
    rateTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    totalAmountLabel.setForeground(Color.black);
    totalAmountLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    totalAmountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    totalAmountLabel.setToolTipText("");
    totalAmountLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    totalAmountLabel.setText("TOTAL AMOUNT");
    totalAmountLabel.setBounds(new Rectangle(393, 391, 94, 30));
    RsLabel3.setForeground(Color.black);
    RsLabel3.setBounds(new Rectangle(577, 390, 23, 30));
    RsLabel3.setText("Rs");
    RsLabel3.setToolTipText("");
    RsLabel3.setFont(new java.awt.Font("Dialog", 1, 12));

    totalAmountTextField.setBounds(new Rectangle(494, 390, 81, 30));
    totalAmountTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    dateList.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionTextArea.setFont(new java.awt.Font("Dialog", 1, 12));
    valueTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    valueTextField.setEditable(false);
    valueTextField.setBounds(new Rectangle(553, 251, 95, 30));
    valueLabel.setBounds(new Rectangle(482, 251, 68, 30));
    valueLabel.setText("VALUE");
    valueLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    valueLabel.setToolTipText("");
    valueLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    valueLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    valueLabel.setForeground(Color.black);
    RsLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    RsLabel.setToolTipText("");
    RsLabel.setText("Rs");
    RsLabel.setBounds(new Rectangle(651, 251, 22, 30));
    RsLabel.setForeground(Color.black);
    this.getContentPane().add(dateScrollPane, null);
    this.getContentPane().add(bearerTextField, null);
    this.getContentPane().add(saleIDTextField, null);
    this.getContentPane().add(saleIDLabel, null);
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
    this.getContentPane().add(saleQuantityTextField, null);
    this.getContentPane().add(kgBagsLabel, null);
    this.getContentPane().add(saleQuantityLabel, null);
    this.getContentPane().add(RsLabel3, null);
    this.getContentPane().add(totalAmountTextField, null);
    this.getContentPane().add(dateLabel, null);
    this.getContentPane().add(termsConditionsLabel, null);
    this.getContentPane().add(currentBalanceLabel, null);
    this.getContentPane().add(yearLabel, null);
    this.getContentPane().add(currentBalanceTextField, null);
    this.getContentPane().add(yearComboBox, null);
    this.getContentPane().add(productLabel, null);
    this.getContentPane().add(productComboBox, null);
    this.getContentPane().add(quantityLabel, null);
    this.getContentPane().add(qKGBagsLabel, null);
    this.getContentPane().add(quantityTextField, null);
    this.getContentPane().add(valueTextField, null);
    this.getContentPane().add(valueLabel, null);
    this.getContentPane().add(customerLabel, null);
    this.getContentPane().add(customerComboBox, null);
    this.getContentPane().add(customerPanel, null);
    this.getContentPane().add(headingLabel1, null);
    this.getContentPane().add(headingLabel, null);
    this.getContentPane().add(RsLabel, null);
    this.getContentPane().add(productPanel, null);
    this.getContentPane().add(RsLabel2, null);
    this.getContentPane().add(cashRegisterPanel, null);
    this.getContentPane().add(totalAmountLabel, null);
    this.getContentPane().add(saleBookPanel, null);
    descriptionScrollPane.getViewport().add(descriptionTextArea, null);
    dateScrollPane.getViewport().add(dateList, null);
  this.getContentPane().setBackground(Color.white);

  headingLabel.setForeground(Color.black);
  customerLabel.setForeground(Color.black);
  currentBalanceLabel.setForeground(Color.black);
  RsLabel2.setForeground(Color.black);
  kgBagsLabel.setForeground(Color.black);
  yearLabel.setForeground(Color.black);
  saleIDLabel.setForeground(Color.black);
  descriptionLabel.setForeground(Color.black);
  saleQuantityLabel.setForeground(Color.black);
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
  saleIDTextField.setBorder(border);
  saleQuantityTextField.setBorder(border);
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
  saleQuantityTextField.addActionListener(this);

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

  saleIDTextField.setText(rec.product_id );
  rateTextField.setText(rec.rate_mund_bag);
  totalAmountTextField.setText(rec.total_amount);
  saleQuantityTextField.setText(rec.quantity_kg_bag );
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
  if(productComboBox==e.getSource())  getSaleBook();
  if(customerComboBox==e.getSource()) getSaleBook();
  if(yearComboBox==e.getSource())     getSaleBook();
  if(saleQuantityTextField==e.getSource())     setRate();

 }//end method

 private void setRate(){
   String totalAmountStr=totalAmountTextField.getText();
   String quantityStr   =saleQuantityTextField.getText().trim();
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

 private void getSaleBook(){
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
       java.util.Vector v=DatabaseManager.getPurchaseSaleBook(productRec.product_id, customerRec.customer_id, cashRegisterRec.cash_reg_id, "S");
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

    String quantity_kg_bag=saleQuantityTextField.getText().trim();
    String rate_mund_bag=rateTextField.getText().trim();
    String total_amount=totalAmountTextField.getText().trim();

    String trans_date=dateTextField.getText().trim();
    String bearer=bearerTextField.getText().trim();
    String terms_and_conditions=termsConditions.trim();
    String remarks=descriptionTextArea.getText().trim();
    String trans_type="S";


    if(trans_date.equals("")){
       JOptionPane.showMessageDialog(this,"Enter Date.....");
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
    if(remarks.equals(""))remarks="S/ "+product_name+"/ "+quantity_kg_bag;

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
         rows=DatabaseManager.productIteration(product_id,quantity_kg_bag,total_amount,"C");
         if(terms_and_conditions.equals("CASH")){
             if(rows>=1)
                  rows=DatabaseManager.cashRegisterIteration(cash_reg_id,total_amount,"D");
         }else{
             if(rows>=1){
                int purchase_sale_id=DatabaseManager.getLastPurchaseSaleID();
                rows=DatabaseManager.addTransactionPurchaseSale(""+purchase_sale_id,customer_id,cash_reg_id,total_amount,"C",trans_date,bearer,"S/ "+product_name+"/ "+quantity_kg_bag);
             }//end if
         }

        if(rows>=1){
          JOptionPane.showMessageDialog(this,"Record Successfully SAVED.....");
          refresh();

          customerComboBox.setSelectedIndex(customerRecIndex);
          productComboBox.setSelectedIndex(productRecIndex);
          yearComboBox.setSelectedIndex(cashRegisterRecIndex);

          getSaleBook();
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
   int rows=DatabaseManager.productIteration(rec.product_id,rec.quantity_kg_bag,rec.total_amount, "D");

   if(rec.terms_and_conditions.equals("CASH"))
        if(rows>=1)rows=DatabaseManager.cashRegisterIteration(rec.cash_reg_id,rec.total_amount,"C");
   if(rec.terms_and_conditions.equals("CREDIT"))
        if(rows>=1)rows=DatabaseManager.deleteTransaction(rec.purchase_sale_id,rec.customer_id,rec.cash_reg_id);

   rows=DatabaseManager.deletePurchaseSaleBook(rec.purchase_sale_id);
   if(rows>=1){
       JOptionPane.showMessageDialog(this,"Record Successfully REMOVED.....");
       refresh();

       customerComboBox.setSelectedIndex(customerRecIndex);
       productComboBox.setSelectedIndex(productRecIndex);
       yearComboBox.setSelectedIndex(cashRegisterRecIndex);

       getSaleBook();
       clearRecord();
    }//end if
  }catch(Exception e){
   JOptionPane.showMessageDialog(this,e.getMessage());
   e.printStackTrace();
  }
 }//END method

 private void clearRecord(){
  saleIDTextField.setText("");
  rateTextField.setText("");
  totalAmountTextField.setText("");
  saleQuantityTextField.setText("");
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

  }///////////////////////end method
}//end class

