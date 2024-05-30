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

public class CustomerFrame extends JFrame implements ActionListener,ListSelectionListener{
  private JLabel headingLabel = new JLabel();
  private JLabel headingLabel1 = new JLabel();
  private JLabel customerIDLabel = new JLabel();
  private JLabel descriptionLabel = new JLabel();
  private JLabel customerLabel = new JLabel();
  private JLabel customersLabel = new JLabel();
  private JLabel contactLabel = new JLabel();
  private JLabel addressLabel = new JLabel();

  private JTextField customerIDTextField = new JTextField();
  private JTextField customerTextField = new JTextField();
  private JTextField contactTextField = new JTextField();

  private JScrollPane descriptionScrollPane = new JScrollPane();
  private JScrollPane customerScrollPane = new JScrollPane();
  private JScrollPane addressScrollPane = new JScrollPane();

  private JTextArea descriptionTextArea = new JTextArea();
  private JTextArea addressTextArea = new JTextArea();

  private JList customerList = new JList();

  private JButton addButton = new JButton(  new ImageIcon("add.gif") );
  private JButton deleteButton = new JButton(new ImageIcon("delete.jpg"));
  private JButton updateButton = new JButton(new ImageIcon("update.jpg"));
  private JButton clearButton = new JButton(new ImageIcon("CLEAR.JPG"));
  private JButton backButton = new JButton(new ImageIcon("back.jpg"));
  private JComboBox customerTypeComboBox = new JComboBox();
  private JLabel customerTypeLabel = new JLabel();

  private UserAccountRecord uar;
int frame_id;
public void setUser(UserAccountRecord uar ){
    this.uar = uar;
}

  public CustomerFrame() {
  super("CUSTOMER");
    try {
      jbInit();
      frame_id=6;
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {

    Border border1 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151));
    TitledBorder titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"CUSTOMER");
    TitledBorder titledBorder2 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"CASH REGISTER");
    TitledBorder titledBorder3 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"ACCOUNT PAYABLE");
    this.setResizable(false);

    titledBorder3 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"PRODUCT STOCK");
    headingLabel.setFont(new java.awt.Font("Dialog", 1, 30));
    headingLabel.setText("CUSTOMER");

    this.getContentPane().setLayout(null);
    customerIDTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    customerIDTextField.setEditable(false);
    customerIDTextField.setBounds(new Rectangle(295, 131, 71, 30));
    customerIDLabel.setBounds(new Rectangle(171, 131, 123, 30));
    customerIDLabel.setText("CUSTOMER ID");
    customerIDLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    customerIDLabel.setToolTipText("");
    customerIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    customerIDLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    customerTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    customerTextField.setBounds(new Rectangle(295, 164, 464, 30));
    customerLabel.setBounds(new Rectangle(171, 164, 123, 30));
    customerLabel.setText("CUSTOMER");
    customerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    customerLabel.setToolTipText("");
    customerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    customerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    descriptionLabel.setBounds(new Rectangle(295, 349, 90, 30));
    descriptionLabel.setText("DESCRIPTION");
    descriptionLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionLabel.setToolTipText("");
    descriptionScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionScrollPane.setBounds(new Rectangle(295, 371, 464, 66));
    customerScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    customerScrollPane.setBounds(new Rectangle(764, 130, 202, 308));
    customersLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    customersLabel.setToolTipText("");
    customersLabel.setText("CUSTOMERS");
    customersLabel.setBounds(new Rectangle(832, 108, 81, 29));
    addButton.setBackground(Color.white);
    addButton.setFont(new java.awt.Font("Dialog", 1, 12));
    addButton.setHorizontalAlignment(SwingConstants.RIGHT);
    addButton.setText("ADD");
    addButton.setBounds(new Rectangle(295, 442, 88, 55));
    deleteButton.setBounds(new Rectangle(387, 442, 118, 55));
    deleteButton.setBackground(Color.white);
    deleteButton.setFont(new java.awt.Font("Dialog", 1, 12));
    deleteButton.setHorizontalAlignment(SwingConstants.RIGHT);
    deleteButton.setText("DELETE");
    updateButton.setBounds(new Rectangle(510, 442, 120, 55));
    updateButton.setBackground(Color.white);
    updateButton.setFont(new java.awt.Font("Dialog", 1, 12));
    updateButton.setHorizontalAlignment(SwingConstants.RIGHT);
    updateButton.setText("UPDATE");
    clearButton.setBounds(new Rectangle(634, 442, 105, 55));
    clearButton.setBackground(Color.white);
    clearButton.setFont(new java.awt.Font("Dialog", 1, 12));
    clearButton.setHorizontalAlignment(SwingConstants.RIGHT);
    clearButton.setText("CLEAR");
    backButton.setBounds(new Rectangle(743, 442, 224, 55));
    backButton.setBackground(Color.white);
    backButton.setFont(new java.awt.Font("Dialog", 1, 12));
    backButton.setHorizontalAlignment(SwingConstants.RIGHT);
    backButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    backButton.setText("BACK");
    headingLabel1.setForeground(Color.lightGray);
    headingLabel1.setText("CUSTOMER");
    headingLabel1.setFont(new java.awt.Font("Dialog", 1, 30));
    contactLabel.setForeground(Color.black);
    contactLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    contactLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    contactLabel.setToolTipText("");
    contactLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    contactLabel.setText("CONTACT");
    contactLabel.setBounds(new Rectangle(237, 198, 57, 30));
    contactTextField.setBounds(new Rectangle(295, 198, 238, 30));
    contactTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    addressLabel.setForeground(Color.black);
    addressLabel.setToolTipText("");
    addressLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    addressLabel.setText("ADDRESS");
    addressLabel.setBounds(new Rectangle(295, 259, 90, 30));
    addressScrollPane.setBounds(new Rectangle(295, 281, 464, 39));
    addressScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionTextArea.setFont(new java.awt.Font("Dialog", 1, 12));
    addressTextArea.setFont(new java.awt.Font("Dialog", 1, 12));
    customerTypeComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    customerTypeComboBox.setBounds(new Rectangle(644, 198, 115, 30));
    customerTypeComboBox.setKeySelectionManager(new MyKeySelectionManager());
    customerTypeLabel.setForeground(Color.black);
    customerTypeLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    customerTypeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    customerTypeLabel.setToolTipText("");
    customerTypeLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    customerTypeLabel.setText("CUSTOMER TYPE");
    customerTypeLabel.setBounds(new Rectangle(536, 198, 106, 30));
    this.getContentPane().add(customerIDTextField, null);
    this.getContentPane().add(addButton, null);
    this.getContentPane().add(descriptionLabel, null);
    this.getContentPane().add(descriptionScrollPane, null);
    this.getContentPane().add(backButton, null);
    this.getContentPane().add(customerScrollPane, null);
    this.getContentPane().add(clearButton, null);
    this.getContentPane().add(updateButton, null);
    this.getContentPane().add(deleteButton, null);
    this.getContentPane().add(customersLabel, null);
    this.getContentPane().add(customerIDLabel, null);
    this.getContentPane().add(customerTextField, null);
    this.getContentPane().add(customerLabel, null);
    this.getContentPane().add(addressLabel, null);
    this.getContentPane().add(addressScrollPane, null);
    this.getContentPane().add(customerTypeComboBox, null);
    this.getContentPane().add(contactTextField, null);
    this.getContentPane().add(contactLabel, null);
    this.getContentPane().add(customerTypeLabel, null);
    this.getContentPane().add(headingLabel1, null);
    this.getContentPane().add(headingLabel, null);
    addressScrollPane.getViewport().add(addressTextArea, null);
    customerScrollPane.getViewport().add(customerList, null);
    descriptionScrollPane.getViewport().add(descriptionTextArea, null);
  this.getContentPane().setBackground(Color.white);

  headingLabel.setForeground(Color.black);
  customerIDLabel.setForeground(Color.black);
  descriptionLabel.setForeground(Color.black);
  customerLabel.setForeground(Color.black);
  customersLabel.setForeground(Color.black);

  Border border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.gray,Color.darkGray,new Color(58, 110, 165)),BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,Color.darkGray,new Color(58, 110, 165)));


  addressScrollPane.setBorder(border);
  contactTextField.setBorder(border);
  customerIDTextField.setBorder(border);
  customerTextField.setBorder(border);
  descriptionScrollPane.setBorder(border);
  customerScrollPane.setBorder(border);
  customerTypeComboBox.setBorder(border);
  addButton.setBorder(border);
  deleteButton.setBorder(border);
  updateButton.setBorder(border);
  clearButton.setBorder(border);
  backButton.setBorder(border);
  customerList.setFont(new java.awt.Font("Dialog", 1, 12));

  addButton.addActionListener(this);
  deleteButton.addActionListener(this);
  updateButton.addActionListener(this);
  clearButton.addActionListener(this);
  backButton.addActionListener(this);

  customerList.addListSelectionListener(this);




  Toolkit kit=this.getToolkit();
  Dimension d=kit.getScreenSize();
  this.setBounds(0,0,d.width,d.height);
//  getCustomers();
    customerTypeComboBox.addItem("GENERAL");
    customerTypeComboBox.addItem("BANK");
    headingLabel.setBounds(new Rectangle(506, 17, 186, 33));
    headingLabel1.setBounds(new Rectangle(509, 21, 192, 33));

 }//end constructor

 public void actionPerformed(ActionEvent e){
  if(addButton==e.getSource()) addRecord();
  if(deleteButton==e.getSource()) deleteRecord();
  if(updateButton==e.getSource()) updateRecord();
  if(clearButton==e.getSource()) clearRecord();
  if(backButton==e.getSource()) hide();
 }//end method

  public void valueChanged(ListSelectionEvent e){
    CustomerRecord rec=(CustomerRecord)customerList.getSelectedValue();
    if(rec==null) return;

   customerIDTextField.setText(rec.customer_id );
   customerTextField.setText(rec.name);
   contactTextField.setText(rec.contact );
   addressTextArea.setText(rec.address );
   descriptionTextArea.setText(rec.remarks);
   this.customerTypeComboBox.setSelectedItem(Decode.customerTypeDecode(rec.customer_type));
  }//end mthod
 private void getCustomers(){
 try{
   java.util.Vector v=DatabaseManager.getCustomers(uar);
   customerList.setListData(v);
 }catch(Exception e){
  JOptionPane.showMessageDialog(this,"Database Driver check ODBC ["+e.getMessage()+"]");
  e.printStackTrace();
 }
 }//end method

 private void addRecord(){
    String name=customerTextField.getText();
    String contact=contactTextField.getText();
    String customer_type=(String)customerTypeComboBox.getSelectedItem();
    String address=addressTextArea.getText();
    String remarks=descriptionTextArea.getText();

    if(name.trim().equals("")){
       JOptionPane.showMessageDialog(this,"Enter Customer.....");
       return;
    }

    if(customer_type==null)customer_type="G";
    if(contact.trim().equals(""))contact="....";
    if(address.trim().equals(""))address="....";
    if(remarks.trim().equals(""))remarks="....";

    try{
      int rows=DatabaseManager.addCustomers(name,contact,customer_type,address,remarks);
      if(rows>=1){
         JOptionPane.showMessageDialog(this,"Record Successfully SAVED.....");
         getCustomers();
         clearRecord();
      }
  }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
  }
 }//end method
 private void deleteRecord(){
    CustomerRecord rec=(CustomerRecord)customerList.getSelectedValue();
    if(rec==null){
     JOptionPane.showMessageDialog(this,"Please Select Customer.....");
     return;
    }

   try{
      int confirm=JOptionPane.showConfirmDialog(this,"Are you sure to remove selected record?","Confirmation...",JOptionPane.YES_NO_OPTION);
      if(confirm==JOptionPane.YES_OPTION){
          int rows=DatabaseManager.deleteCustomers(rec.customer_id);
          if(rows>=1){
             JOptionPane.showMessageDialog(this,"Record Successfully Removed.....");
             getCustomers();
             clearRecord();
          }
      }//end if

   }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
   }
 }//end method

 private void updateRecord(){
    CustomerRecord rec=(CustomerRecord)customerList.getSelectedValue();
    if(rec==null){
     JOptionPane.showMessageDialog(this,"Please Select Customer.....");
     return;
    }

    String customer_id=rec.customer_id;
    String name=customerTextField.getText();
    String contact=contactTextField.getText();
    String customer_type=(String)customerTypeComboBox.getSelectedItem();
    String address=addressTextArea.getText();
    String remarks=descriptionTextArea.getText();

    if(name.trim().equals("")){
       JOptionPane.showMessageDialog(this,"Enter Customer.....");
       return;
    }

    if(customer_type==null)customer_type="G";
    if(contact.trim().equals(""))contact="....";
    if(address.trim().equals(""))address="....";
    if(remarks.trim().equals(""))remarks="....";

  try{
      int rows=DatabaseManager.updateCustomers(customer_id,name,contact,customer_type,address,remarks);
      if(rows>=1){
         JOptionPane.showMessageDialog(this,"Record Successfully MODIFIED.....");
         clearRecord();
         getCustomers();
      }
  }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
  }
 }//end method

 private void clearRecord(){
  customerIDTextField.setText("");
  customerTextField.setText("");
  contactTextField.setText("");
  addressTextArea.setText("");
  descriptionTextArea.setText("");
 }/////end method

 public void show(){
   getCustomers();
   super.show();
 }
}//end class