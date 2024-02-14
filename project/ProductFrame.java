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

public class ProductFrame extends JFrame  implements ActionListener,ListSelectionListener{
  private JLabel headingLabel = new JLabel();
  private JLabel headingLabel1 = new JLabel();
  private JLabel quantityLabel = new JLabel();
  private JLabel productIDLabel = new JLabel();
  private JLabel descriptionLabel = new JLabel();
  private JLabel productLabel = new JLabel();
  private JLabel measurementUnitLabel = new JLabel();
  private JLabel productsLabel = new JLabel();
  private JLabel companyLabel = new JLabel();

  private JTextField productIDTextField = new JTextField();
  private JTextField productTextField = new JTextField();
  private JTextField quantityTextField = new JTextField();
  private JTextField companyTextField = new JTextField();

  private JComboBox measurementUnitComboBox = new JComboBox();

  private JScrollPane descriptionScrollPane = new JScrollPane();
  private JScrollPane productScrollPane = new JScrollPane();
  private JTextArea descriptionTextArea = new JTextArea();
  private JList productList = new JList();

  private JButton addButton = new JButton(new ImageIcon("add.gif"));
  private JButton deleteButton = new JButton(new ImageIcon("delete.jpg"));
  private JButton updateButton = new JButton(new ImageIcon("update.jpg"));
  private JButton clearButton = new JButton(new ImageIcon("CLEAR.JPG"));
  private JButton backButton = new JButton(new ImageIcon("back.jpg"));
  private JLabel quantityTypeLabel = new JLabel();
  private JTextField valueTextField = new JTextField();
  private JLabel valueLabel = new JLabel();
  private JLabel RsLabel = new JLabel();
  JButton printButton = new JButton(new ImageIcon("printer.jpg"));

  public ProductFrame() {
  super("PRODUCT STOCK");
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    measurementUnitComboBox.setKeySelectionManager(new MyKeySelectionManager());

    measurementUnitComboBox.addItem("KG's");
    measurementUnitComboBox.addItem("BAG's");
    measurementUnitComboBox.addItem("PACK's");
    Border border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151));
    TitledBorder titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"CUSTOMER");
    TitledBorder titledBorder2 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"CASH REGISTER");
    TitledBorder titledBorder3 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"ACCOUNT PAYABLE");

    titledBorder3 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"PRODUCT STOCK");
    headingLabel.setFont(new java.awt.Font("Dialog", 1, 30));
    headingLabel.setText("PRODUCT STOCK");
    headingLabel.setBounds(new Rectangle(376, 114, 278, 33));
    this.getContentPane().setLayout(null);
    measurementUnitComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    measurementUnitComboBox.setBounds(new Rectangle(261, 295, 97, 30));
    quantityLabel.setBounds(new Rectangle(422, 273, 63, 25));
    quantityLabel.setText("QUANTITY");
    quantityLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    quantityLabel.setToolTipText("");
    quantityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    quantityLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    productIDTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    productIDTextField.setEditable(false);
    productIDTextField.setBounds(new Rectangle(259, 203, 71, 30));
    productIDLabel.setBounds(new Rectangle(133, 203, 123, 30));
    productIDLabel.setText("PRODUCT ID");
    productIDLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    productIDLabel.setToolTipText("");
    productIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    productIDLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    productTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    productTextField.setBounds(new Rectangle(259, 235, 445, 30));
    productLabel.setBounds(new Rectangle(133, 235, 123, 30));
    productLabel.setText("PRODUCT");

        this.setResizable(false);

    productLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    productLabel.setToolTipText("");
    productLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    productLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    measurementUnitLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    measurementUnitLabel.setToolTipText("");
    measurementUnitLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    measurementUnitLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    measurementUnitLabel.setText("MEASUREMENT UNIT");
    measurementUnitLabel.setBounds(new Rectangle(135, 295, 123, 30));
    quantityTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    quantityTextField.setBounds(new Rectangle(427, 295, 81, 30));
    descriptionLabel.setBounds(new Rectangle(261, 376, 90, 30));
    descriptionLabel.setText("DESCRIPTION");
    descriptionLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionLabel.setToolTipText("");
    descriptionScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionScrollPane.setBounds(new Rectangle(261, 398, 445, 66));
    productScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    productScrollPane.setBounds(new Rectangle(710, 236, 187, 229));
    productsLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    productsLabel.setToolTipText("");
    productsLabel.setText("PRODUCT");
    productsLabel.setBounds(new Rectangle(712, 217, 61, 25));
    addButton.setBackground(Color.white);
    addButton.setFont(new java.awt.Font("Dialog", 1, 12));
    addButton.setHorizontalAlignment(SwingConstants.RIGHT);
    addButton.setText("ADD");
    addButton.setBounds(new Rectangle(262, 471, 88, 55));
    deleteButton.setBounds(new Rectangle(354, 471, 118, 55));
    deleteButton.setBackground(Color.white);
    deleteButton.setFont(new java.awt.Font("Dialog", 1, 12));
    deleteButton.setHorizontalAlignment(SwingConstants.RIGHT);
    deleteButton.setText("DELETE");
    updateButton.setBounds(new Rectangle(476, 471, 120, 55));
    updateButton.setBackground(Color.white);
    updateButton.setFont(new java.awt.Font("Dialog", 1, 12));
    updateButton.setHorizontalAlignment(SwingConstants.RIGHT);
    updateButton.setText("UPDATE");
    clearButton.setBounds(new Rectangle(601, 471, 105, 55));
    clearButton.setBackground(Color.white);
    clearButton.setFont(new java.awt.Font("Dialog", 1, 12));
    clearButton.setHorizontalAlignment(SwingConstants.RIGHT);
    clearButton.setText("CLEAR");
    backButton.setBounds(new Rectangle(710, 471, 187, 55));
    backButton.setBackground(Color.white);
    backButton.setFont(new java.awt.Font("Dialog", 1, 12));
    backButton.setHorizontalAlignment(SwingConstants.RIGHT);
    backButton.setText("BACK");
    headingLabel1.setForeground(Color.lightGray);
    headingLabel1.setBounds(new Rectangle(378, 118, 287, 33));
    headingLabel1.setText("PRODUCT STOCK");
    headingLabel1.setFont(new java.awt.Font("Dialog", 1, 30));
    companyLabel.setForeground(Color.black);
    companyLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    companyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    companyLabel.setToolTipText("");
    companyLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    companyLabel.setText("COMPANY");
    companyLabel.setBounds(new Rectangle(171, 328, 88, 30));
    companyTextField.setBounds(new Rectangle(261, 328, 445, 30));
    companyTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    productList.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionTextArea.setFont(new java.awt.Font("Dialog", 1, 12));
    quantityTypeLabel.setForeground(Color.black);
    quantityTypeLabel.setHorizontalTextPosition(SwingConstants.LEFT);
    quantityTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
    quantityTypeLabel.setToolTipText("");
    quantityTypeLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    quantityTypeLabel.setText("KG");
    quantityTypeLabel.setBounds(new Rectangle(511, 295, 63, 30));
    valueTextField.setBounds(new Rectangle(602, 295, 82, 30));
    valueTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    valueLabel.setForeground(Color.black);
    valueLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    valueLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    valueLabel.setToolTipText("");
    valueLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    valueLabel.setText("VALUE");
    valueLabel.setBounds(new Rectangle(599, 273, 43, 22));
    RsLabel.setBounds(new Rectangle(686, 295, 22, 30));
    RsLabel.setText("Rs");
    RsLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    RsLabel.setToolTipText("");
    RsLabel.setHorizontalAlignment(SwingConstants.LEFT);
    RsLabel.setHorizontalTextPosition(SwingConstants.LEFT);
    RsLabel.setForeground(Color.black);
    printButton.addActionListener(this);
    printButton.setText("PRINT");
    printButton.setHorizontalAlignment(SwingConstants.RIGHT);
    printButton.setFont(new java.awt.Font("Dialog", 1, 12));
    printButton.setBackground(Color.white);
    printButton.setBounds(new Rectangle(712, 533, 187, 55));
    printButton.addActionListener(new ProductFrame_printButton_actionAdapter(this));
    this.getContentPane().add(headingLabel1, null);
    this.getContentPane().add(headingLabel, null);
    this.getContentPane().add(productScrollPane, null);
    this.getContentPane().add(descriptionLabel, null);
    this.getContentPane().add(descriptionScrollPane, null);
    this.getContentPane().add(measurementUnitLabel, null);
    this.getContentPane().add(companyLabel, null);
    this.getContentPane().add(companyTextField, null);
    this.getContentPane().add(measurementUnitComboBox, null);
    this.getContentPane().add(addButton, null);
    this.getContentPane().add(backButton, null);
    this.getContentPane().add(updateButton, null);
    this.getContentPane().add(deleteButton, null);
    this.getContentPane().add(clearButton, null);
    this.getContentPane().add(valueTextField, null);
    this.getContentPane().add(RsLabel, null);
    this.getContentPane().add(quantityTextField, null);
    this.getContentPane().add(quantityTypeLabel, null);
    this.getContentPane().add(productTextField, null);
    this.getContentPane().add(productIDTextField, null);
    this.getContentPane().add(productIDLabel, null);
    this.getContentPane().add(productLabel, null);
    this.getContentPane().add(valueLabel, null);
    this.getContentPane().add(quantityLabel, null);
    this.getContentPane().add(productsLabel, null);
    this.getContentPane().add(printButton, null);
    descriptionScrollPane.getViewport().add(descriptionTextArea, null);
    productScrollPane.getViewport().add(productList, null);
  this.getContentPane().setBackground(Color.white);

  headingLabel.setForeground(Color.black);
  quantityLabel.setForeground(Color.black);
  productIDLabel.setForeground(Color.black);
  descriptionLabel.setForeground(Color.black);
  productLabel.setForeground(Color.black);
  measurementUnitLabel.setForeground(Color.black);
  productsLabel.setForeground(Color.black);

  Border border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.gray,Color.darkGray,new Color(58, 110, 165)),BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,Color.darkGray,new Color(58, 110, 165)));


    printButton.setBorder(border);
  valueTextField.setBorder(border);
  productIDTextField.setBorder(border);
  productTextField.setBorder(border);
  quantityTextField.setBorder(border);
  measurementUnitComboBox.setBorder(border);
  descriptionScrollPane.setBorder(border);
    companyTextField.setBorder(border);
  productScrollPane.setBorder(border);
//  descriptionTextArea.setBorder(border);
//  dateList.setBorder(border);
  addButton.setBorder(border);
  deleteButton.setBorder(border);
  updateButton.setBorder(border);
  clearButton.setBorder(border);
  backButton.setBorder(border);

  addButton.addActionListener(this);
  deleteButton.addActionListener(this);
  updateButton.addActionListener(this);
  clearButton.addActionListener(this);
  backButton.addActionListener(this);
  measurementUnitComboBox.addActionListener(this);
  productList.addListSelectionListener(this);



  Toolkit kit=this.getToolkit();
  Dimension d=kit.getScreenSize();
  this.setBounds(0,0,d.width,d.height);
//  getProduct();
 }//end constructor

 public void actionPerformed(ActionEvent e){
  if(printButton==e.getSource()) ReportFrame.printProductStock();
  if(addButton==e.getSource()) addRecord();
  if(deleteButton==e.getSource()) deleteRecord();
  if(updateButton==e.getSource()) updateRecord();
  if(clearButton==e.getSource()) clearRecord();
  if(backButton==e.getSource()) hide();
  if(measurementUnitComboBox==e.getSource()) quantityTypeLabel.setText((String)measurementUnitComboBox.getSelectedItem());

 }//end method


   public void valueChanged(ListSelectionEvent e){
    ProductRecord rec=(ProductRecord)productList.getSelectedValue();
    if(rec==null)return;

    productIDTextField.setText(rec.product_id );
    productTextField.setText(rec.name );
    quantityTextField.setText(rec.quantity_available );
    measurementUnitComboBox.setSelectedItem(Decode.measurementUnitDecode(rec.measurement_unit));
    companyTextField.setText(rec.company );
    valueTextField.setText(rec.product_value );
    descriptionTextArea.setText(rec.remarks);
  }//end mthod


 private void clearRecord(){
  productIDTextField.setText("");
  productTextField.setText("");
  quantityTextField.setText("");
  companyTextField.setText("");
  descriptionTextArea.setText("");
valueTextField.setText("");
 }//end method


 private void getProduct(){
 try{
   java.util.Vector v=DatabaseManager.getProduct();
   productList.setListData(v);
 }catch(Exception e){
  JOptionPane.showMessageDialog(this,"Database Driver check ODBC ["+e.getMessage()+"]");
  e.printStackTrace();
 }
 }//end method

 private void addRecord(){
  String name=productTextField.getText();
  String measurement_unit=Encode.measurementUnitEncode((String)measurementUnitComboBox.getSelectedItem());
  String quantity_available=quantityTextField.getText();
  String product_value=valueTextField.getText();
  String company=companyTextField.getText();
  String remarks=descriptionTextArea.getText();

    if(name.trim().equals("")){
       JOptionPane.showMessageDialog(this,"Enter Customer.....");
       return;
    }

    if(quantity_available.trim().equals(""))quantity_available="0";
    if(product_value.trim().equals(""))product_value="0";
    if(company.trim().equals(""))company="....";
    if(remarks.trim().equals(""))remarks="....";

    if(! Decode.isNumeric(product_value)){
       JOptionPane.showMessageDialog(this,"Product Value must enter in NUMERIC form.....");
       return;
    }
    if(! Decode.isNumeric(quantity_available)){
       JOptionPane.showMessageDialog(this,"Quantity must enter in NUMERIC form.....");
       return;
    }
  try{
      int rows=DatabaseManager.addProduct(name, measurement_unit, quantity_available, company,product_value, remarks);
      if(rows>=1){
         JOptionPane.showMessageDialog(this,"Record Successfully SAVED.....");
         getProduct();
         clearRecord();
      }
  }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
  }
 }//end method


 private void deleteRecord(){
    ProductRecord rec=(ProductRecord)productList.getSelectedValue();
    if(rec==null){
     JOptionPane.showMessageDialog(this,"Please Select Product.....");
     return;
    }

   try{
      int confirm=JOptionPane.showConfirmDialog(this,"Are you sure to remove selected record?","Confirmation...",JOptionPane.YES_NO_OPTION);
      if(confirm==JOptionPane.YES_OPTION){
          int rows=DatabaseManager.deleteProduct(rec.product_id);
          if(rows>=1){
             JOptionPane.showMessageDialog(this,"Record Successfully Removed.....");
             getProduct();
             clearRecord();
          }
      }//end if

   }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
   }
 }//end method

 private void updateRecord(){
    ProductRecord rec=(ProductRecord)productList.getSelectedValue();
    if(rec==null){
     JOptionPane.showMessageDialog(this,"Please Select Product.....");
     return;
    }

    String product_id=rec.product_id;
    String name=productTextField.getText();
    String measurement_unit=Encode.measurementUnitEncode((String)measurementUnitComboBox.getSelectedItem());
    String quantity_available=quantityTextField.getText();
    String product_value=valueTextField.getText();
    String company=companyTextField.getText();
    String remarks=descriptionTextArea.getText();


    if(name.trim().equals("")){
       JOptionPane.showMessageDialog(this,"Enter Product.....");
       return;
    }

    if(quantity_available.trim().equals(""))quantity_available="0";
    if(product_value.trim().equals(""))product_value="0";
    if(company.trim().equals(""))company="....";
    if(remarks.trim().equals(""))remarks="....";

    if(! Decode.isNumeric(quantity_available)){
       JOptionPane.showMessageDialog(this,"Quantity must enter in NUMERIC form.....");
       return;
    }
    if(! Decode.isNumeric(product_value)){
       JOptionPane.showMessageDialog(this,"Product Value must enter in NUMERIC form.....");
       return;
    }
  try{
      int rows=DatabaseManager.updateProduct(product_id,name,measurement_unit,quantity_available,company,product_value,remarks);
      if(rows>=1){
         JOptionPane.showMessageDialog(this,"Record Successfully MODIFIED.....");
         getProduct();
         clearRecord();
      }
  }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
  }
 }///////////////end method

 public void show(){
   getProduct();
   super.show();
 }

  void printButton_actionPerformed(ActionEvent e) {

  }////////end method

 }//end class

class ProductFrame_printButton_actionAdapter implements java.awt.event.ActionListener {
  ProductFrame adaptee;

  ProductFrame_printButton_actionAdapter(ProductFrame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.printButton_actionPerformed(e);
  }
}