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

public class CashRegisterFrame extends JFrame implements ActionListener,ListSelectionListener{
  private JLabel headingLabel = new JLabel();
  private JLabel headingLabel1 = new JLabel();
  private JLabel yearLabel = new JLabel();
  private JLabel cashRegIDLabel = new JLabel();
  private JLabel descriptionLabel = new JLabel();
  private JLabel currentBalanceLabel = new JLabel();
  private JLabel yearsLabel = new JLabel();
  private JLabel RsLabel = new JLabel();

  private JTextField cashRegIDTextField = new JTextField();
  private JTextField currentBalanceTextField = new JTextField();
  private JTextField yearTextField = new JTextField();
  private JTextField dateOfOpeningTextField = new JTextField();


  private JScrollPane descriptionScrollPane = new JScrollPane();
  private JScrollPane yearScrollPane = new JScrollPane();
  private JTextArea descriptionTextArea = new JTextArea();
  private JList yearList = new JList();

  private JButton addButton = new JButton(new ImageIcon("add.gif"));
  private JButton deleteButton = new JButton(new ImageIcon("delete.jpg"));
  private JButton updateButton = new JButton(new ImageIcon("update.jpg"));
  private JButton clearButton = new JButton(new ImageIcon("CLEAR.JPG"));
  private JButton backButton = new JButton(new ImageIcon("back.jpg"));
  private JLabel dateOfOpeningLabel = new JLabel();
  private JLabel jLabel4 = new JLabel(new ImageIcon("4.jpg"));

  public CashRegisterFrame() {
  super("CASH REGISTER");
    try {
      jbInit();
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

    titledBorder3 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"PRODUCT STOCK");
    headingLabel.setFont(new java.awt.Font("Dialog", 1, 30));
    headingLabel.setText("CASH REGISTER");
    headingLabel.setBounds(new Rectangle(450, 53, 278, 33));
    this.getContentPane().setLayout(null);
    yearLabel.setBounds(new Rectangle(425, 276, 43, 30));
    yearLabel.setText("YEAR");
    yearLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    yearLabel.setToolTipText("");
    yearLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    yearLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    cashRegIDTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    cashRegIDTextField.setEditable(false);
    cashRegIDTextField.setBounds(new Rectangle(309, 243, 71, 30));
    cashRegIDLabel.setBounds(new Rectangle(183, 243, 123, 30));
    cashRegIDLabel.setText("CASH REG. ID");
       this.setResizable(false);

    cashRegIDLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    cashRegIDLabel.setToolTipText("");
    cashRegIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    cashRegIDLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    currentBalanceTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    currentBalanceTextField.setBounds(new Rectangle(309, 276, 71, 30));
    currentBalanceLabel.setBounds(new Rectangle(183, 276, 123, 30));
    currentBalanceLabel.setText("CURRENT BALANCE");
    currentBalanceLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    currentBalanceLabel.setToolTipText("");
    currentBalanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    currentBalanceLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    yearTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    yearTextField.setBounds(new Rectangle(472, 276, 97, 30));
    descriptionLabel.setBounds(new Rectangle(309, 360, 90, 30));
    descriptionLabel.setText("DESCRIPTION");
    descriptionLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionLabel.setToolTipText("");
    descriptionScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionScrollPane.setBounds(new Rectangle(309, 382, 465, 66));
    yearScrollPane.setFont(new java.awt.Font("Dialog", 1, 12));
    yearScrollPane.setBounds(new Rectangle(778, 243, 107, 205));
    yearsLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    yearsLabel.setToolTipText("");
    yearsLabel.setText("YEARS");
    yearsLabel.setBounds(new Rectangle(813, 222, 48, 29));
    addButton.setBackground(Color.white);
    addButton.setFont(new java.awt.Font("Dialog", 1, 12));
    addButton.setHorizontalAlignment(SwingConstants.RIGHT);
    addButton.setText("ADD");
    addButton.setBounds(new Rectangle(309, 453, 88, 55));
    deleteButton.setBounds(new Rectangle(401, 453, 118, 55));
    deleteButton.setBackground(Color.white);
    deleteButton.setFont(new java.awt.Font("Dialog", 1, 12));
    deleteButton.setHorizontalAlignment(SwingConstants.RIGHT);
    deleteButton.setText("DELETE");
    updateButton.setBounds(new Rectangle(524, 453, 120, 55));
    updateButton.setBackground(Color.white);
    updateButton.setFont(new java.awt.Font("Dialog", 1, 12));
    updateButton.setHorizontalAlignment(SwingConstants.RIGHT);
    updateButton.setText("UPDATE");
    clearButton.setBounds(new Rectangle(648, 453, 105, 55));
    clearButton.setBackground(Color.white);
    clearButton.setFont(new java.awt.Font("Dialog", 1, 12));
    clearButton.setHorizontalAlignment(SwingConstants.RIGHT);
    clearButton.setText("CLEAR");
    backButton.setBounds(new Rectangle(757, 453, 128, 55));
    backButton.setBackground(Color.white);
    backButton.setFont(new java.awt.Font("Dialog", 1, 12));
    backButton.setHorizontalAlignment(SwingConstants.RIGHT);
    backButton.setText("BACK");
    headingLabel1.setForeground(Color.lightGray);
    headingLabel1.setBounds(new Rectangle(452, 57, 287, 33));
    headingLabel1.setText("CASH REGISTER");
    headingLabel1.setFont(new java.awt.Font("Dialog", 1, 30));
    dateOfOpeningLabel.setForeground(Color.black);
    dateOfOpeningLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    dateOfOpeningLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    dateOfOpeningLabel.setToolTipText("");
    dateOfOpeningLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    dateOfOpeningLabel.setText("DATE OF OPENING");
    dateOfOpeningLabel.setBounds(new Rectangle(193, 309, 113, 30));
    dateOfOpeningTextField.setBounds(new Rectangle(309, 309, 127, 30));
    dateOfOpeningTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    RsLabel.setForeground(Color.black);
    RsLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    RsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    RsLabel.setToolTipText("");
    RsLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    RsLabel.setText("Rs");
    RsLabel.setBounds(new Rectangle(378, 276, 20, 30));
    yearList.setFont(new java.awt.Font("Dialog", 1, 12));
    descriptionTextArea.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabel4.setText("");
    jLabel4.setBounds(new Rectangle(745, 19, 197, 173));
    this.getContentPane().add(descriptionLabel, null);
    this.getContentPane().add(descriptionScrollPane, null);
    this.getContentPane().add(backButton, null);
    this.getContentPane().add(dateOfOpeningLabel, null);
    this.getContentPane().add(cashRegIDTextField, null);
    this.getContentPane().add(cashRegIDLabel, null);
    this.getContentPane().add(currentBalanceTextField, null);
    this.getContentPane().add(currentBalanceLabel, null);
    this.getContentPane().add(yearLabel, null);
    this.getContentPane().add(yearTextField, null);
    this.getContentPane().add(RsLabel, null);
    this.getContentPane().add(dateOfOpeningTextField, null);
    this.getContentPane().add(yearScrollPane, null);
    this.getContentPane().add(yearsLabel, null);
    this.getContentPane().add(clearButton, null);
    this.getContentPane().add(addButton, null);
    this.getContentPane().add(updateButton, null);
    this.getContentPane().add(deleteButton, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(headingLabel1, null);
    this.getContentPane().add(headingLabel, null);
    yearScrollPane.getViewport().add(yearList, null);
    descriptionScrollPane.getViewport().add(descriptionTextArea, null);
  this.getContentPane().setBackground(Color.white);

  headingLabel.setForeground(Color.black);
  yearLabel.setForeground(Color.black);
  cashRegIDLabel.setForeground(Color.black);
  descriptionLabel.setForeground(Color.black);
  currentBalanceLabel.setForeground(Color.black);
  yearsLabel.setForeground(Color.black);

  Border border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.gray,Color.darkGray,new Color(58, 110, 165)),BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,Color.darkGray,new Color(58, 110, 165)));


  dateOfOpeningTextField.setBorder(border);
  cashRegIDTextField.setBorder(border);
  currentBalanceTextField.setBorder(border);
  yearTextField.setBorder(border);
  descriptionScrollPane.setBorder(border);
  yearScrollPane.setBorder(border);
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
  yearList.addListSelectionListener(this);



  Toolkit kit=this.getToolkit();
  Dimension d=kit.getScreenSize();
  this.setBounds(0,0,d.width,d.height);
//  getCashRegister();
 }//end constructor

 public void actionPerformed(ActionEvent e){
  if(addButton==e.getSource()) addRecord();
  if(deleteButton==e.getSource()) deleteRecord();
  if(updateButton==e.getSource()) updateRecord();
  if(clearButton==e.getSource()) clearRecord();
  if(backButton==e.getSource()) hide();
 }//end method

   public void valueChanged(ListSelectionEvent e){
    CashRegisterRecord rec=(CashRegisterRecord)yearList.getSelectedValue();
    if(rec==null)return;

    cashRegIDTextField.setText(rec.cash_reg_id );
    currentBalanceTextField.setText(rec.current_balance );
    yearTextField.setText(rec.year );
    dateOfOpeningTextField.setText(rec.date_of_opening);
    descriptionTextArea.setText(rec.remarks);
  }//end mthod


 private void clearRecord(){
  cashRegIDTextField.setText("");
  currentBalanceTextField.setText("");
  yearTextField.setText("");
  dateOfOpeningTextField.setText("");
  descriptionTextArea.setText("");
 }//end method

 private void getCashRegister(){
 try{
   java.util.Vector v=DatabaseManager.getCashRegisters();
   this.yearList.setListData(v);
 }catch(Exception e){
  JOptionPane.showMessageDialog(this,"Database Driver check ODBC ["+e.getMessage()+"]");
  e.printStackTrace();
 }
 }//end method

 private void addRecord(){
  String current_balance=currentBalanceTextField.getText();
  String date_of_opening=dateOfOpeningTextField.getText();
  String year=yearTextField.getText();
  String remarks=descriptionTextArea.getText();

  if(!Decode.isDate(date_of_opening)){
    JOptionPane.showMessageDialog(this,"Enter Date of Opening [INVALID DATE FORMAT] EXAMPLE [05-JAN-2007].....");
    return;
  }
  if(year.trim().equals("")){
    JOptionPane.showMessageDialog(this,"Enter Year.....");
    return;
  }

    if(current_balance.trim().equals(""))current_balance="0";
    if(remarks.trim().equals(""))remarks="....";

    if(! Decode.isNumeric(current_balance)){
       JOptionPane.showMessageDialog(this,"Balance must enter in NUMERIC form.....");
       return;
    }
  try{
      int rows=DatabaseManager.addCashRegister(current_balance, date_of_opening, year, remarks);
      if(rows>=1){
         JOptionPane.showMessageDialog(this,"Record Successfully SAVED.....");
         getCashRegister();
         clearRecord();
      }
  }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
  }
 }//end method


 private void deleteRecord(){
    CashRegisterRecord rec=(CashRegisterRecord)yearList.getSelectedValue();
    if(rec==null){
     JOptionPane.showMessageDialog(this,"Please Select Year.....");
     return;
    }

   try{
      int confirm=JOptionPane.showConfirmDialog(this,"Are you sure to remove selected record?","Confirmation...",JOptionPane.YES_NO_OPTION);
      if(confirm==JOptionPane.YES_OPTION){
          int rows=DatabaseManager.deleteCashRegister(rec.cash_reg_id);
          if(rows>=1){
             JOptionPane.showMessageDialog(this,"Record Successfully Removed.....");
             getCashRegister();
             clearRecord();
          }
      }//end if

   }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
   }
 }//end method

 private void updateRecord(){
    CashRegisterRecord rec=(CashRegisterRecord)yearList.getSelectedValue();
    if(rec==null){
     JOptionPane.showMessageDialog(this,"Please Select Year.....");
     return;
    }

  String cash_reg_id=rec.cash_reg_id;
  String current_balance=currentBalanceTextField.getText();
  String date_of_opening=dateOfOpeningTextField.getText();
  String year=yearTextField.getText();
  String remarks=descriptionTextArea.getText();

  if(!Decode.isDate(date_of_opening)){
    JOptionPane.showMessageDialog(this,"Enter Date of Opening [INVALID DATE FORMAT] EXAMPLE [05-JAN-2007].....");
    return;
  }
  if(year.trim().equals("")){
    JOptionPane.showMessageDialog(this,"Enter Year.....");
    return;
  }

    if(current_balance.trim().equals(""))current_balance="0";
    if(remarks.trim().equals(""))remarks="....";

    if(! Decode.isNumeric(current_balance)){
       JOptionPane.showMessageDialog(this,"Balance must enter in NUMERIC form.....");
       return;
    }
  try{
      int rows=DatabaseManager.updateCashRegister(cash_reg_id, current_balance, date_of_opening,  year,  remarks);
      if(rows>=1){
         JOptionPane.showMessageDialog(this,"Record Successfully MODIFIED.....");
         getCashRegister();
         clearRecord();
      }
  }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
  }
 }////end method

// private void clearRecord(){
//  cashRegIDTextField.setText("");
//  currentBalanceTextField.setText("");
//  yearTextField.setText("");
//  descriptionTextArea.setText("");
// }//end method

 public void show(){
   getCashRegister();
   this.dateOfOpeningTextField.setText(DateFormat.getCurrentDate());
   super.show();
 }/////////end method
}//end class