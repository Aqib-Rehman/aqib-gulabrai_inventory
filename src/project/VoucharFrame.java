package project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.awt.print.PageFormat;
import java.awt.print.Paper;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class VoucharFrame extends JFrame implements ActionListener,KeyListener{
  private int previousKey;
  private int transactionCount=0;
  boolean dialogShowed = false;

  JPanel customerPanel = new JPanel();
  JLabel customerLabel = new JLabel();
  JLabel bearerLabel = new JLabel();
  JPanel accountPayablePanel = new JPanel();
  JLabel transactionIDLabel = new JLabel();
  JLabel amountLabel = new JLabel();
  JTextField amountTextField = new JTextField();
  JComboBox customerComboBox = new JComboBox();
  JComboBox customerBankComboBox = new JComboBox();
  JComboBox creditDebitComboBox = new JComboBox();
  JComboBox paymentModeComboBox = new JComboBox();
  JComboBox transactionTypeComboBox = new JComboBox();
  JComboBox termsConditionsComboBox = new JComboBox();
  JTextField transactionIDTextField = new JTextField();
  JLabel customerBankLabel = new JLabel();
  JPanel cashRegisterPanel = new JPanel();
  JComboBox yearComboBox = new JComboBox();
  JLabel yearLabel = new JLabel();
  JLabel currentBalanceLabel = new JLabel();
  JLabel RsLabel2 = new JLabel();
  JTextField currentBalanceTextField = new JTextField();
  TitledBorder titledBorder1;
  Border border1;
  TitledBorder titledBorder2;
  TitledBorder titledBorder3;
  TitledBorder titledBorder4;
  JPanel productPanel = new JPanel();
  JLabel quantityLabel = new JLabel();
  JTextField quantityTextField = new JTextField();
  JLabel valueLabel = new JLabel();
  JTextField valueTextField = new JTextField();
  TitledBorder titledBorder5;
  JScrollPane productsTableScrollPane = new JScrollPane();
  JTable productsTable = new JTable();
  JButton addButton = new JButton(new ImageIcon("add.gif"));
  JButton clearButton = new JButton(new ImageIcon("CLEAR.JPG"));
  JButton printSalePurchaseButton = new JButton(new ImageIcon("printer.jpg"));
  JPanel transactionPanel = new JPanel();
  JScrollPane transactionTableScrollPane = new JScrollPane();
  JTable transactionTable = new JTable();
  private javax.swing.table.DefaultTableModel productTableModel;
  private javax.swing.table.DefaultTableModel transactionTableModel;
  TitledBorder titledBorder6;
  JLabel dateLabel = new JLabel();
  JTextField dateTextField = new JTextField();
  JLabel totalLabel = new JLabel();
  JTextField totalAmountTextField = new JTextField();
  ButtonGroup buttonGroup1 = new ButtonGroup();
  JRadioButton voucharRadioButton = new JRadioButton();
  JRadioButton dispatchRadioButton = new JRadioButton();
  JRadioButton billRadioButton = new JRadioButton();
  JComboBox productComboBox = new JComboBox();
  JLabel productLabel = new JLabel();
  JLabel saleQuantityLabel = new JLabel();
  JTextField saleQuantityTextField = new JTextField();
  JTextField rateTextField = new JTextField();
  JLabel rateLabel = new JLabel();
  JLabel rsLabel = new JLabel();
  JTextField rsTextField = new JTextField();
  JLabel qKGBagsLabel = new JLabel();
  JButton backButton = new JButton(new ImageIcon("back.jpg"));
  JRadioButton recieptRadioButton = new JRadioButton();
  JButton buttonPrint = new JButton(new ImageIcon("printer.jpg"));
  JLabel totalProductLabel = new JLabel();
  JTextField productAmountTextField = new JTextField();
  JLabel totalTermsConditionLabel = new JLabel();
  JButton transactionReportButton = new JButton();
  JTextField bearerTextField = new JTextField();
  public VoucharFrame() {
    try {
      jbInit();
      this.recieptRadioButton.setVisible(false);
      this.printSalePurchaseButton.setVisible(false);

      java.util.Vector v = new java.util.Vector();
      v.add(this.customerComboBox);
      v.add(this.dateTextField);
      v.add(this.bearerTextField);
      v.add(this.amountTextField);
      v.add(this.paymentModeComboBox);
      v.add(this.creditDebitComboBox);
      v.add(this.customerBankComboBox);
      v.add(this.transactionTypeComboBox);
      v.add(this.termsConditionsComboBox);
      v.add(this.productComboBox);
      v.add(this.saleQuantityTextField);
      v.add(this.rateTextField);
      v.add(this.rsTextField);
      v.add(this.addButton);
      v.add(this.clearButton);
      v.add(this.buttonPrint);
      v.add(this.voucharRadioButton);
      v.add(this.billRadioButton);
      v.add(this.dispatchRadioButton);
      v.add(this.transactionTable);
      v.add(this.productsTable);

      removeDefaultFocusOfTab();

      for(int i=0;i<v.size();i++){
        addKeyStrokes((JComponent) v.get(i));
      }

    }
    catch(Exception e) {
      e.printStackTrace();
    }

  }


  private void jbInit() throws Exception {
    productsTable.setFont(new java.awt.Font("Dialog", 1, 20));
    titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(178, 178, 178)),"CUSTOMER");
    border1 = BorderFactory.createEmptyBorder();
    titledBorder2 = new TitledBorder(border1,"CUSTOMER CASH TRANSACTION");
    titledBorder3 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(178, 178, 178)),"CUSTOMER CASH TRANSACTION");
    titledBorder4 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(178, 178, 178)),"CASH REGISTER");
    titledBorder5 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(178, 178, 178)),"PRODUCT");
    titledBorder6 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(168, 168, 168)),"TRANSACTIONS");
    this.getContentPane().setLayout(null);
    customerPanel.setBackground(Color.white);
    customerPanel.setBorder(titledBorder1);
    customerPanel.setBounds(new Rectangle(16, 56, 574, 127));
    customerPanel.setLayout(null);
    customerComboBox.setKeySelectionManager(new MyKeySelectionManager());
    customerComboBox.setFont(new java.awt.Font("Dialog", 1, 30));
    customerComboBox.setBounds(new Rectangle(87, 18, 473, 40));

    customerComboBox.addActionListener(this);
    customerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    customerLabel.setToolTipText("");
    customerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    customerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    customerLabel.setText("CUSTOMER");
    customerLabel.setBounds(new Rectangle(-54, 20, 134, 30));
    customerLabel.setForeground(Color.black);
    bearerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    bearerLabel.setToolTipText("");
    bearerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    bearerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    bearerLabel.setText("BEARER");
    bearerLabel.setBounds(new Rectangle(9, 86, 69, 30));
    bearerLabel.setForeground(Color.black);
    bearerTextField.setFont(new java.awt.Font("Dialog", 1, 20));
    bearerTextField.setBounds(new Rectangle(86, 86, 471, 30));
    bearerTextField.addActionListener(this);

    accountPayablePanel.setBackground(Color.white);
    accountPayablePanel.setBorder(titledBorder3);
    accountPayablePanel.setBounds(new Rectangle(18, 201, 572, 154));
    accountPayablePanel.setLayout(null);
    customerBankComboBox.addActionListener(this);
    customerBankComboBox.setBounds(new Rectangle(78, 111, 486, 30));
    customerBankComboBox.setFont(new java.awt.Font("Dialog", 1, 30));
    customerBankComboBox.setKeySelectionManager(new MyKeySelectionManager());
    transactionIDLabel.setBounds(new Rectangle(480, 783, 71, 30));
    transactionIDLabel.setText("TRANS. ID");
    transactionIDLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    transactionIDLabel.setToolTipText("");
    transactionIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    transactionIDLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    transactionIDLabel.setForeground(Color.black);
    amountLabel.setBounds(new Rectangle(5, 23, 61, 30));
    amountLabel.setText("AMOUNT");
    amountLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    amountLabel.setToolTipText("");
    amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    amountLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    amountLabel.setForeground(Color.black);
    creditDebitComboBox.setKeySelectionManager(new MyKeySelectionManager());
    creditDebitComboBox.addActionListener(this);
    creditDebitComboBox.setBounds(new Rectangle(400, 29, 156, 30));

    creditDebitComboBox.setFont(new java.awt.Font("Dialog", 1, 30));
    creditDebitComboBox.setActionCommand("null");
    amountTextField.setFont(new java.awt.Font("Dialog", 1, 40));
    amountTextField.setBounds(new Rectangle(70, 26, 297, 51));
    amountTextField.addActionListener(this);

    paymentModeComboBox.setFont(new java.awt.Font("Dialog", 1, 30));
    paymentModeComboBox.setBounds(new Rectangle(401, 67, 154, 30));

    paymentModeComboBox.addActionListener(this);
    paymentModeComboBox.setKeySelectionManager(new MyKeySelectionManager());
    transactionIDTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    transactionIDTextField.setEditable(false);
    transactionIDTextField.setBounds(new Rectangle(560, 783, 66, 30));
    customerBankLabel.setForeground(Color.black);
    customerBankLabel.setBounds(new Rectangle(7, 110, 67, 30));
    customerBankLabel.setText("TRANSFER");
    customerBankLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    customerBankLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    customerBankLabel.setToolTipText("");
    customerBankLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    cashRegisterPanel.setBounds(new Rectangle(327, 784, 241, 51));
    cashRegisterPanel.setLayout(null);
    cashRegisterPanel.setBackground(Color.white);
    cashRegisterPanel.setBorder(titledBorder4);
    yearComboBox.setKeySelectionManager(new MyKeySelectionManager());
    yearComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    yearComboBox.setBounds(new Rectangle(75, 19, 125, 21));
    yearComboBox.addActionListener(this);
    yearLabel.setBounds(new Rectangle(-43, 10, 123, 30));
    yearLabel.setText("YEAR");
    yearLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    yearLabel.setToolTipText("");
    yearLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    yearLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    yearLabel.setForeground(Color.black);
    currentBalanceLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    currentBalanceLabel.setToolTipText("");
    currentBalanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    currentBalanceLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    currentBalanceLabel.setText("CURRENT BALANCE");
    currentBalanceLabel.setBounds(new Rectangle(276, 7, 116, 30));
    currentBalanceLabel.setForeground(Color.black);
    RsLabel2.setBounds(new Rectangle(219, 13, 23, 30));
    RsLabel2.setText("Rs");
    RsLabel2.setFont(new java.awt.Font("Dialog", 1, 12));
    RsLabel2.setToolTipText("");
    RsLabel2.setForeground(Color.black);
    currentBalanceTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    currentBalanceTextField.setEditable(false);
    currentBalanceTextField.setBounds(new Rectangle(400, 9, 111, 30));
    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.setTitle("VOUCHAR");
    productPanel.setBounds(new Rectangle(19, 369, 566, 209));
    productPanel.setLayout(null);
    productPanel.setBackground(Color.white);
    productPanel.setBorder(titledBorder5);
    quantityLabel.setForeground(Color.black);
    quantityLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    quantityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    quantityLabel.setToolTipText("");
    quantityLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    quantityLabel.setText("STOCK");
    quantityLabel.setBounds(new Rectangle(17, 82, 48, 30));
    quantityTextField.setBounds(new Rectangle(78, 82, 157, 30));
    quantityTextField.setEditable(false);
    quantityTextField.setFont(new java.awt.Font("Dialog", 1, 30));
    valueLabel.setBounds(new Rectangle(343, 451, 48, 30));
    valueLabel.setText("VALUE");
    valueLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    valueLabel.setToolTipText("");
    valueLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    valueLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    valueLabel.setForeground(Color.black);
    valueTextField.setFont(new java.awt.Font("Dialog", 1, 30));
    valueTextField.setEditable(false);
    valueTextField.setBounds(new Rectangle(378, 79, 166, 30));
    transactionTypeComboBox.setFont(new java.awt.Font("Dialog", 1, 30));
    transactionTypeComboBox.setBounds(new Rectangle(77, 25, 157, 32));
    transactionTypeComboBox.addActionListener(this);

    termsConditionsComboBox.setKeySelectionManager(new MyKeySelectionManager());
    termsConditionsComboBox.addActionListener(this);
    termsConditionsComboBox.setBounds(new Rectangle(379, 22, 162, 30));

    termsConditionsComboBox.setFont(new java.awt.Font("Dialog", 1, 30));
    productsTableScrollPane.getViewport().setBackground(Color.white);
    productsTableScrollPane.setBounds(new Rectangle(635, 84, 634, 287));
    addButton.setBackground(Color.white);
    addButton.setFont(new java.awt.Font("Dialog", 1, 30));
    addButton.setText("ADD");
    addButton.setBounds(new Rectangle(19, 629, 266, 54));
    addButton.addActionListener(this);
    clearButton.setBounds(new Rectangle(21, 692, 263, 52));
    clearButton.setBackground(Color.white);
    clearButton.setFont(new java.awt.Font("Dialog", 1, 30));
    clearButton.setText("CLEAR");
    clearButton.addActionListener(this);
    printSalePurchaseButton.addActionListener(this);
    printSalePurchaseButton.setText("ADD & PRINT");
    printSalePurchaseButton.setHorizontalAlignment(SwingConstants.RIGHT);
    printSalePurchaseButton.setFont(new java.awt.Font("Dialog", 1, 12));
    printSalePurchaseButton.setBackground(Color.white);
    printSalePurchaseButton.setBounds(new Rectangle(733, 768, 161, 55));
    //printButton.addActionListener(new ProductFrame_printButton_actionAdapter(this));
    transactionPanel.setBackground(Color.white);
    transactionPanel.setBorder(titledBorder6);
    transactionPanel.setBounds(new Rectangle(632, 385, 637, 300));
    transactionPanel.setLayout(null);
    transactionTableScrollPane.getViewport().setBackground(Color.white);
    transactionTableScrollPane.setBounds(new Rectangle(6, 12, 610, 276));
    dateLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    dateLabel.setToolTipText("");
    dateLabel.setText("DATE");
    dateLabel.setBounds(new Rectangle(20, 10, 47, 25));
    dateLabel.setForeground(Color.black);
    dateTextField.setBounds(new Rectangle(59, 11, 136, 24));
    dateTextField.addActionListener(this);

    totalLabel.setForeground(Color.black);
    totalLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    totalLabel.setToolTipText("");
    totalLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    totalLabel.setText("TOTAL AMOUNT");
    totalLabel.setBounds(new Rectangle(959, 13, 100, 30));
    totalAmountTextField.setFont(new java.awt.Font("Dialog", 1, 40));
    totalAmountTextField.setForeground(new Color(0, 0, 200));
    totalAmountTextField.setBounds(new Rectangle(1067, 7, 198, 43));
    voucharRadioButton.setBackground(Color.white);
    voucharRadioButton.setFont(new java.awt.Font("Dialog", 1, 15));
    voucharRadioButton.setText("Vouchar");
    voucharRadioButton.setBounds(new Rectangle(91, 595, 111, 29));
    dispatchRadioButton.setBackground(Color.white);
    dispatchRadioButton.setFont(new java.awt.Font("Dialog", 1, 15));
    dispatchRadioButton.setText("Dispatch Order");
    dispatchRadioButton.setBounds(new Rectangle(301, 595, 178, 28));
    dispatchRadioButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispatchRadioButton_actionPerformed(e);
      }
    });
    billRadioButton.setText("Bill");
    billRadioButton.setActionCommand("");
    billRadioButton.setBackground(Color.white);
    billRadioButton.setFont(new java.awt.Font("Dialog", 1, 15));
    billRadioButton.setBounds(new Rectangle(201, 595, 90, 29));
    productComboBox.setKeySelectionManager(new MyKeySelectionManager());
    productComboBox.setBounds(new Rectangle(79, 120, 471, 30));

    productComboBox.setFont(new java.awt.Font("Dialog", 1, 30));
    productComboBox.addActionListener(this);
    productLabel.setForeground(Color.black);
    productLabel.setBounds(new Rectangle(11, 121, 65, 30));
    productLabel.setText("PRODUCT");
    productLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    productLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    productLabel.setToolTipText("");
    productLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    saleQuantityLabel.setBounds(new Rectangle(7, 166, 61, 30));
    saleQuantityLabel.setText("QUANTITY");
    saleQuantityLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    saleQuantityLabel.setToolTipText("");
    saleQuantityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    saleQuantityLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    saleQuantityLabel.setForeground(Color.black);
    saleQuantityTextField.setFont(new java.awt.Font("Dialog", 1, 20));
    saleQuantityTextField.setBounds(new Rectangle(71, 165, 114, 30));
    saleQuantityTextField.addActionListener(this);
    rateTextField.setBounds(new Rectangle(228, 166, 109, 30));

    rateTextField.setFont(new java.awt.Font("Dialog", 1, 20));
    rateLabel.setForeground(Color.black);
    rateLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    rateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    rateLabel.setToolTipText("");
    rateLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    rateLabel.setText("RATE");
    rateLabel.setBounds(new Rectangle(188, 166, 37, 30));
    rsLabel.setBounds(new Rectangle(337, 164, 37, 30));
    rsLabel.setText("RS");
    rsLabel.setFont(new java.awt.Font("Dialog", 1, 14));
    rsLabel.setToolTipText("");
    rsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    rsLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    rsLabel.setForeground(Color.black);
    rsTextField.setFont(new java.awt.Font("Dialog", 1, 20));
    rsTextField.setBounds(new Rectangle(387, 163, 164, 34));
    rsTextField.addKeyListener(this);
    qKGBagsLabel.setText("kgbags");
    qKGBagsLabel.setBounds(new Rectangle(239, 79, 40, 35));
    backButton.setBounds(new Rectangle(302, 690, 281, 56));
    backButton.setBackground(Color.white);
    backButton.setFont(new java.awt.Font("Dialog", 1, 30));
    backButton.setText("BACK");
    backButton.addActionListener(this);
    recieptRadioButton.setBackground(Color.white);
    recieptRadioButton.setText("reciept");
    recieptRadioButton.setToolTipText("");
    recieptRadioButton.setBounds(new Rectangle(492, 595, 65, 18));
    buttonPrint.setBackground(Color.white);
    buttonPrint.setFont(new java.awt.Font("Dialog", 1, 30));
    buttonPrint.setText("Print");
    buttonPrint.addActionListener(this);
    printSalePurchaseButton.setFont(new java.awt.Font("Dialog", 1, 12));
    printSalePurchaseButton.setBackground(Color.white);
    buttonPrint.setBounds(new Rectangle(301, 628, 283, 54));
    totalProductLabel.setForeground(Color.black);
    totalProductLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    totalProductLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    totalProductLabel.setToolTipText("");
    totalProductLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    totalProductLabel.setText("PRODUCT AMOUNT");
    totalProductLabel.setBounds(new Rectangle(625, 10, 115, 30));
    productAmountTextField.setFont(new java.awt.Font("Dialog", 1, 40));
    productAmountTextField.setForeground(new Color(10, 50, 200));
    productAmountTextField.setBounds(new Rectangle(743, 8, 196, 42));
    totalTermsConditionLabel.setBounds(new Rectangle(1143, 55, 123, 26));
    transactionReportButton.setBackground(Color.white);
    transactionReportButton.setFont(new java.awt.Font("Dialog", 1, 30));
    transactionReportButton.setText("TRANSACTION REPORT");
    transactionReportButton.setBounds(new Rectangle(634, 697, 631, 60));
    transactionReportButton.addActionListener(this);
    this.getContentPane().add(currentBalanceTextField, null);
    this.getContentPane().add(dateLabel, null);
    this.getContentPane().add(dateTextField, null);
    this.getContentPane().add(currentBalanceLabel, null);
    this.getContentPane().add(totalProductLabel, null);
    this.getContentPane().add(productAmountTextField, null);
    this.getContentPane().add(totalLabel, null);
    this.getContentPane().add(totalAmountTextField, null);
    this.getContentPane().add(cashRegisterPanel, null);
    cashRegisterPanel.add(RsLabel2, null);
    cashRegisterPanel.add(yearComboBox, null);
    cashRegisterPanel.add(yearLabel, null);
    this.getContentPane().add(transactionIDTextField, null);
    this.getContentPane().add(transactionIDLabel, null);
    this.getContentPane().add(accountPayablePanel, null);
    accountPayablePanel.add(amountLabel, null);
    accountPayablePanel.add(customerBankLabel, null);
    accountPayablePanel.add(customerBankComboBox, null);
    accountPayablePanel.add(amountTextField, null);
    accountPayablePanel.add(creditDebitComboBox, null);
    accountPayablePanel.add(paymentModeComboBox, null);
    this.getContentPane().add(customerPanel, null);
    customerPanel.add(customerLabel, null);
    customerPanel.add(bearerLabel, null);
    customerPanel.add(bearerTextField, null);
    customerPanel.add(customerComboBox, null);
    this.getContentPane().add(productPanel, null);
    productPanel.add(saleQuantityLabel, null);
    productPanel.add(saleQuantityTextField, null);
    productPanel.add(rateLabel, null);
    productPanel.add(rateTextField, null);
    productPanel.add(rsLabel, null);
    productPanel.add(productComboBox, null);
    productPanel.add(productLabel, null);
    productPanel.add(quantityLabel, null);
    productPanel.add(quantityTextField, null);
    productPanel.add(qKGBagsLabel, null);
    productPanel.add(valueTextField, null);
    productPanel.add(transactionTypeComboBox, null);
    productPanel.add(termsConditionsComboBox, null);
    productPanel.add(rsTextField, null);
    this.getContentPane().add(valueLabel, null);
    this.getContentPane().add(addButton, null);
    this.getContentPane().add(buttonPrint, null);
    this.getContentPane().add(clearButton, null);
    this.getContentPane().add(backButton, null);
    this.getContentPane().add(recieptRadioButton, null);
    this.getContentPane().add(billRadioButton, null);
    this.getContentPane().add(voucharRadioButton, null);
    this.getContentPane().add(dispatchRadioButton, null);
    this.getContentPane().add(productsTableScrollPane, null);
    this.getContentPane().add(totalTermsConditionLabel, null);
    this.getContentPane().add(transactionPanel, null);
    transactionPanel.add(transactionTableScrollPane, null);
    this.getContentPane().add(printSalePurchaseButton, null);
    this.getContentPane().add(transactionReportButton, null);
    transactionTableScrollPane.getViewport().add(transactionTable, null);
    productsTableScrollPane.getViewport().add(productsTable, null);
    creditDebitComboBox.addItem("CREDIT");
    creditDebitComboBox.addItem("DEBIT");
    paymentModeComboBox.addItem("CASH");
    paymentModeComboBox.addItem("CHEQUE");
    termsConditionsComboBox.addItem("CASH");
    termsConditionsComboBox.addItem("CREDIT");
    transactionTypeComboBox.addItem("SALE");
    transactionTypeComboBox.addItem("PURCHASE");

     productsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productsTableKeyReleased(evt);
            }
        });

      amountTextField.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyReleased(java.awt.event.KeyEvent evt){
                amountTextFieldKeyReleased(evt);
            }
      });

      rateTextField.addActionListener(this);

      productPanel.setBackground(  new java.awt.Color(206, 128, 249,100));
      accountPayablePanel.setBackground(  new java.awt.Color(242, 242,0,100));
      customerPanel.setBackground(  new java.awt.Color(122, 219, 226,100));
      customerBankComboBox.setVisible(false);
      customerBankLabel.setVisible(false);
      this.cashRegisterPanel.setVisible(false);
      transactionIDLabel.setVisible(false);
      transactionIDTextField.setVisible(false);
      this.productsTable.setRowHeight(30);
      this.productsTable.setRowMargin(10);

      paymentModeComboBox.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent evt){

          billTotalCalculation();
        }
      });
    buttonGroup1.add(recieptRadioButton);

    myinit();

  }//End Costructor


  private void setProductPanelEnable(boolean b){
    productComboBox.setEnabled(b);
    saleQuantityTextField.setEnabled(b);
    rateTextField.setEnabled(b);
    productPanel.setEnabled(b);
  }

  private void setCustomerCashTransactionPanelEnabled(boolean b){
    amountTextField.setEnabled(b);
    paymentModeComboBox.setEnabled(b);
    creditDebitComboBox.setEnabled(b);
  }

  public void myinit(){
    productTableModel = new javax.swing.table.DefaultTableModel(new Object[][]{},new String[]{"PRODUCT","RATE","QUANTITY","AMOUNT"}){
      boolean canEdit[] = new boolean[]{false,true,true,false};
      public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
      }
    };

    transactionTableModel = new javax.swing.table.DefaultTableModel(new Object[][]{},new String[]{"TRANS.ID","PRODUCT/QTY","AMOUNT/TYPE","CUSTOMER","BEARER"});
    productsTable.setModel(productTableModel);
    transactionTable.setFont(new java.awt.Font("Dialog", 0, 15));
    transactionTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    transactionTable.setModel(transactionTableModel);
    productsTable.getColumn("PRODUCT").setPreferredWidth(250);
    transactionTable.getColumn("CUSTOMER").setPreferredWidth(170);
    transactionTable.getColumn("TRANS.ID").setPreferredWidth(50);
    transactionTable.getColumn("PRODUCT/QTY").setPreferredWidth(200);
    transactionTable.getColumn("TRANS.ID").setPreferredWidth(100);
    transactionTable.getColumn("AMOUNT/TYPE").setPreferredWidth(130);
  }//End Method


    public void actionPerformed(ActionEvent evt){
      if(addButton==evt.getSource()){
        System.out.println("addButtonActionPerformed");
        addTransactions();
        //getTodaysTransactions();
      }
      else if(printSalePurchaseButton==evt.getSource()){
        printSalePurchaseButtonPressed();
      }
      else if(buttonPrint == evt.getSource()){
        this.printing();
      }
      else if(clearButton==evt.getSource()){
        setVisible(true);
      }

      else if(transactionTypeComboBox == evt.getSource()){ billTotalCalculation(); }

      else if(termsConditionsComboBox == evt.getSource()){ billTotalCalculation(); }

      else if(productComboBox == evt.getSource()){ productComboBoxActionPerformed(); }

      else if(rateTextField == evt.getSource()){ enterPressedOnRate(); }

      else if(backButton == evt.getSource()){setVisible(false); }

      else if(this.creditDebitComboBox == evt.getSource()){billTotalCalculation(); }

      else if(transactionReportButton == evt.getSource()){ transactionReportButtonActionPerformed(); }
//      else if(paymentModeComboBox  == evt.getSource()){ billTotalCalculation();  }
    }//End Method

    private void productsTableMouseClicked(java.awt.event.MouseEvent evt){
      try{
        int selectedRow = productsTable.getSelectedRow();
        ProductRecord record = (ProductRecord)productsTable.getValueAt(selectedRow,0);
        quantityTextField.setText(record.quantity_available);
        valueTextField.setText(record.product_value);
      }catch(Exception ex){
        JOptionPane.showMessageDialog(this,"Error Ocurred..!\n"+ex);
      }
    }//End Method

    private void productsTableKeyReleased(java.awt.event.KeyEvent evt){
      if(evt.getKeyChar() == KeyEvent.VK_DELETE){
         productTableModel.removeRow( productsTable.getSelectedRow());
        billTotalCalculation();
      }
      if(evt.getKeyChar()==KeyEvent.VK_ENTER){
        productsTableMouseClicked(null);
       try{
        billTotalCalculation();
        }catch(Exception ex){
          ex.printStackTrace();
        }
      }
      else if( evt.getKeyCode()==KeyEvent.VK_UP || evt.getKeyCode()==KeyEvent.VK_DOWN){
        productsTableMouseClicked(null);
      }
      else if(evt.getKeyChar()>=KeyEvent.VK_A && evt.getKeyChar()<=122 ){
        int rows = productsTable.getRowCount();
        for(int i=0;i<rows;i++){
          ProductRecord record = (ProductRecord)productsTable.getValueAt(i,0);
          if(record.name.toLowerCase().startsWith(""+evt.getKeyChar()) || record.name.toUpperCase().startsWith(""+evt.getKeyChar())){
            productsTable.setRowSelectionInterval(i,i);
            productsTable.scrollRectToVisible(productsTable.getCellRect(i, 0, true));
            break;
          }
        }
      }
    }//End Method

    private void amountTextFieldKeyReleased(java.awt.event.KeyEvent evt){
      if(amountTextField.getText().trim().equals("") || amountTextField.getText().trim().equals("0")){

      }else{
        termsConditionsComboBox.setSelectedItem("CREDIT");
      }
      billTotalCalculation();
    }



    public void setVisible(boolean b){
      super.setVisible(b);
      if(b){
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        dateTextField.setText(DateFormat.getCurrentDate());
        getCustomers();
        refresh();
        clearTransactionTable();
        getTodaysTransactions();
      }
    }//End Method

    private void getProduct(){
      try{
        //int rows = productTableModel.getRowCount();
        //for(int i=0;i<rows;i++)productTableModel.removeRow(0);

        //removing all products from combobox


        java.util.Vector v=DatabaseManager.getProduct();
        productComboBox.removeAllItems();
        //setting products in combobox
        for(int i=0;i<v.size();i++){
           productComboBox.addItem(v.elementAt(i));
        }

        //Setting products in table
//        for(int i=0;i<v.size();i++){
//          ProductRecord record = (ProductRecord)v.get(i);
//          productTableModel.insertRow(i, new Object[]{record, null, null, null});
//        }

      }catch(Exception e){
        JOptionPane.showMessageDialog(this,"Database Driver check ODBC ["+e.getMessage()+"]");
        e.printStackTrace();
      }
  }//end method

  private void getCustomers(){
    try{
      java.util.Vector v=DatabaseManager.getCustomers();
      customerComboBox.removeAllItems();

      for(int index=0; index<v.size(); index++){
        customerComboBox.addItem(v.elementAt(index));
        customerBankComboBox.addItem(v.elementAt(index));
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

  private void getCurrentBalance(){
    CashRegisterRecord cashRegisterRec=(CashRegisterRecord)yearComboBox.getSelectedItem();
    if(cashRegisterRec==null) return;
    currentBalanceTextField.setText(cashRegisterRec.current_balance);
  }//End Method

  private void refresh(){
    getProduct();
    //getCustomers();
    getCashRegister();
    getCurrentBalance();
    clearProductsTable();
    amountTextField.setText("");
    //remainingTextField.setText("");
    totalAmountTextField.setText("");
    rsTextField.setText("");
    saleQuantityTextField.setText("");
    this.rateTextField.setText("");
    try{
      transactionIDTextField.setText(""+(1+DatabaseManager.getLastTransactionID()));
    }catch(Exception ex){ex.printStackTrace();}
 }//End Method

  private void billTotalCalculation(){

    voucharRadioButton.setEnabled(true);
    dispatchRadioButton.setEnabled(true);
    setProductPanelEnable(true);
    setCustomerCashTransactionPanelEnabled(true);
    dispatchRadioButton.setEnabled(true);
    customerBankComboBox.setVisible(false);
    customerBankLabel.setVisible(false);
    System.out.println(">Total Bill Calculation");

    try{
      if(paymentModeComboBox.getSelectedItem().toString().toLowerCase().indexOf("cheque")> -1){
            customerBankComboBox.setVisible(true);
            customerBankLabel.setVisible(true);
            setProductPanelEnable(false);
      }
    }catch(Exception ex){}

    try{
       if(creditDebitComboBox.isEnabled() && creditDebitComboBox.getSelectedItem().toString().equalsIgnoreCase("debit")){
          voucharRadioButton.setEnabled(false);
          setProductPanelEnable(false);
          dispatchRadioButton.setEnabled(false);
       }
    }catch(Exception ex){}

    try{
      if(paymentModeComboBox.getSelectedItem().toString().toLowerCase().indexOf("cheque") > -1  && amountTextField.isEnabled()){
        voucharRadioButton.setEnabled(false);
      }
    }catch(Exception ex){}
    try{
      String item = (String)termsConditionsComboBox.getSelectedItem();
      if(item!=null && item.equalsIgnoreCase("cash")){
        setCustomerCashTransactionPanelEnabled(false);
        amountTextField.setText("0");
        voucharRadioButton.setEnabled(false);
        voucharRadioButton.setSelected(false);
      }
    }catch(Exception ex){
      ex.printStackTrace(System.err);
    }
    try{
      if(transactionTypeComboBox.getSelectedItem().toString().toLowerCase().indexOf("purchase") > -1){
        voucharRadioButton.setEnabled(false);
        dispatchRadioButton.setEnabled(false);
      }
    }catch(Exception ex){}
    try{
      if(paymentModeComboBox.getSelectedItem().toString().toLowerCase().indexOf("cheque") > -1 && amountTextField.isEnabled()){
        voucharRadioButton.setEnabled(false);
      }
    }catch(Exception ex){}

    try{
    totalTermsConditionLabel.setText("");

    int rows = productsTable.getRowCount();
    int total = 0;
    totalTermsConditionLabel.setText("");
    for(int i=0;i<rows;i++){
      if(productsTable.getValueAt(i,1) == null || productsTable.getValueAt(i,2) == null || productsTable.getValueAt(i,1).toString().trim().equals("")){
        continue;
      }
      ProductRecord record = (ProductRecord)productsTable.getValueAt(i,0);
      //NEW
      total += (int)Double.parseDouble((String)productsTable.getValueAt(i,3));
    }
    productAmountTextField.setText(""+total);
    String cash = amountTextField.getText();
    int cashAmount =0;

    try{
      if(!cash.equals("")){
        cashAmount = Integer.parseInt(cash);
      }//end if
    }catch(NumberFormatException ex){
      JOptionPane.showMessageDialog(this,"Invalid amount..!");
      ex.printStackTrace(System.err);
    }catch(Exception ex){
      JOptionPane.showMessageDialog(this,"Error Ocured..\n"+ex);
      ex.printStackTrace(System.err);
    }//end catch
    //totalTermsConditionLabel

    /* Only Cash Transaction */
    if(total == 0){
      totalAmountTextField.setText(""+cashAmount);
      totalAmountTextField.setForeground(Color.blue);
      totalTermsConditionLabel.setForeground(Color.black);
      String credeb = (String)creditDebitComboBox.getSelectedItem();
      if(credeb.indexOf("DEBIT")>-1){
       totalTermsConditionLabel.setText("FROM CUSTOMER");
       totalAmountTextField.setForeground(Color.red);
       totalTermsConditionLabel.setForeground(Color.red);
      }
      else{ totalTermsConditionLabel.setText("TO CUSTOMER"); }
    /*
      if(paymentModeComboBox.getSelectedItem().toString().equalsIgnoreCase("cheque") || paymentModeComboBox.getSelectedItem().toString().equalsIgnoreCase("transfer")){
        totalTermsConditionLabel.setText("transfer");
      }else{
        totalTermsConditionLabel.setText(""+creditDebitComboBox.getSelectedItem());
      }*/
    }   // END of if /* Only Cash Transaction */


    /* Only Sale / Purchase transaction */
    else if(cashAmount == 0){
      if(termsConditionsComboBox.getSelectedItem().toString().equalsIgnoreCase("cash") && transactionTypeComboBox.getSelectedItem().toString().equalsIgnoreCase("sale")){
        totalTermsConditionLabel.setText("FROM CUSTOMER");
        totalAmountTextField.setText(""+total);
      }else if(termsConditionsComboBox.getSelectedItem().toString().equalsIgnoreCase("cash") && transactionTypeComboBox.getSelectedItem().toString().equalsIgnoreCase("purchase")){
        totalTermsConditionLabel.setText("TO CUSTOMER");
        totalAmountTextField.setText(""+total);
        totalAmountTextField.setForeground(Color.red);
        totalTermsConditionLabel.setForeground(Color.red);
      }else{
        totalTermsConditionLabel.setText("");
        totalAmountTextField.setText("");
      }
      /*
      if(termsConditionsComboBox.getSelectedItem().toString().equalsIgnoreCase("cash")){
        totalTermsConditionLabel.setText("");
        totalAmountTextField.setText(""+total);
      }else{
        totalTermsConditionLabel.setText("credit");
        totalAmountTextField.setText(""+total);
      }*/
    }// end else..if /* Only  Sale/Purchase  transaction */


    /*Means Cash and Sale/Purchase Transaction */
    else{
      //cash(CREDIT)   product (SALE)(CREDIT)
      if(creditDebitComboBox.getSelectedItem().toString().equalsIgnoreCase("credit") && transactionTypeComboBox.getSelectedItem().toString().equalsIgnoreCase("sale") && termsConditionsComboBox.getSelectedItem().toString().equalsIgnoreCase("credit") ){
        totalTermsConditionLabel.setText("TO CUSTOMER");
        totalAmountTextField.setText(""+(cashAmount));
        /*totalTermsConditionLabel.setText("credit");
        totalAmountTextField.setText(""+(total+cashAmount));*/
      }
      //cash(DEBIT)   product (PURCHASE)(CREDIT)
      else if(creditDebitComboBox.getSelectedItem().toString().equalsIgnoreCase("debit") && transactionTypeComboBox.getSelectedItem().toString().equalsIgnoreCase("purchase") && termsConditionsComboBox.getSelectedItem().toString().equalsIgnoreCase("credit") ){
        totalTermsConditionLabel.setText("FROM CUSTOMER");
        totalAmountTextField.setText(""+(cashAmount));
        totalTermsConditionLabel.setForeground(Color.red);
        totalAmountTextField.setForeground(Color.red);
        /*totalTermsConditionLabel.setText("debit");
        if(cashAmount > total){
          totalAmountTextField.setText(""+(cashAmount-total));
        }else if(cashAmount < total){
          totalAmountTextField.setText(""+(total-cashAmount));
        }*/
      }

      /** cash(DEBIT)   product (SALE)(CREDIT) */
      else if(creditDebitComboBox.getSelectedItem().toString().equalsIgnoreCase("debit") && transactionTypeComboBox.getSelectedItem().toString().equalsIgnoreCase("sale") && termsConditionsComboBox.getSelectedItem().toString().equalsIgnoreCase("credit") ){
        totalTermsConditionLabel.setText("FROM CUSTOMER");
        totalAmountTextField.setText(""+(cashAmount));
        totalTermsConditionLabel.setForeground(Color.red);
        totalAmountTextField.setForeground(Color.red);
        /*if(cashAmount > total){
          totalAmountTextField.setText(""+(cashAmount-total));
          totalTermsConditionLabel.setText("debit");
        }else if(cashAmount < total){
          totalAmountTextField.setText(""+(total-cashAmount));
          totalTermsConditionLabel.setText("credit");
        }*/
      }/** END OF ELSE...IF cash(DEBIT)   product (SALE)(CREDIT) */


      /**cash(CREDIT)   product (PURCHASE)(CREDIT)**/
      else if(creditDebitComboBox.getSelectedItem().toString().equalsIgnoreCase("credit") && transactionTypeComboBox.getSelectedItem().toString().equalsIgnoreCase("purchase") && termsConditionsComboBox.getSelectedItem().toString().equalsIgnoreCase("credit") ){
        totalTermsConditionLabel.setText("TO CUSTOMER");
        totalAmountTextField.setText(""+(cashAmount));
        /*if(cashAmount > total){
          totalAmountTextField.setText(""+(cashAmount-total));
          totalTermsConditionLabel.setText("credit");
        }else if(cashAmount < total){
          totalAmountTextField.setText(""+(total-cashAmount));
          totalTermsConditionLabel.setText("debit");
        }*/
      }
    }/*END OF ELSE  Means Cash and Sale/Purchase Transaction */


//    String type = (String)this.creditDebitComboBox.getSelectedItem();
//    if(type.equalsIgnoreCase("DEBIT")){
//      this.remainingTextField.setText(""+(total-cashAmount));
//      this.totalAmountTextField.setText(""+total);
//    }else{
//      this.remainingTextField.setText(""+(total+cashAmount));
//      this.totalAmountTextField.setText(""+(total+cashAmount));
//    }
  }catch(Exception ex){
    ex.printStackTrace();
  }
  }//End Method

  private void addSaleRecord(){
    int customerRecIndex=customerComboBox.getSelectedIndex();
    CustomerRecord customerRec=(CustomerRecord)customerComboBox.getItemAt(customerRecIndex);
    if(customerRec==null){
      JOptionPane.showMessageDialog(this,"Select Customer....");
      return;
    }
    int tableRows = productsTable.getRowCount();
    for(int loop=0;loop<tableRows;loop++){
      if(productsTable.getValueAt(loop,1) == null || productsTable.getValueAt(loop,2) == null || productsTable.getValueAt(loop,1).toString().trim().equals("")){
        continue;
      }
      // Getting Product MODIFIED
      //    int productRecIndex=productComboBox.getSelectedIndex();
    ProductRecord productRec=(ProductRecord)productsTable.getValueAt(loop,0);
//    if(productRec==null){
//      JOptionPane.showMessageDialog(this,"Select Product....");
//      return;
//    }

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

    String quantity_kg_bag=productsTable.getValueAt(loop,2).toString().trim();
    String rate_mund_bag=productsTable.getValueAt(loop,1).toString().trim();
    String total_amount=productsTable.getValueAt(loop,3).toString().trim();

    String trans_date=dateTextField.getText().trim();
    String bearer=bearerTextField.getText().trim();
    String terms_and_conditions=termsConditions.trim();
    String remarks="";//descriptionTextArea.getText().trim();
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
             if(rows>=1){
                  rows=DatabaseManager.cashRegisterIteration(cash_reg_id,total_amount,"D");
                  int psId = DatabaseManager.getLastPurchaseSaleID();
                  insertIntoTransactionTable(psId, productRec.toString(),quantity_kg_bag+"/"+termsConditions,total_amount,"SALE",customerRec.toString(),bearer);
             }
         }else{
             if(rows>=1){
                int purchase_sale_id=DatabaseManager.getLastPurchaseSaleID();
                System.out.println(">> Purchase Sale ID: "+purchase_sale_id);
                rows=DatabaseManager.addTransactionPurchaseSale(""+purchase_sale_id,customer_id,cash_reg_id,total_amount,"C",trans_date,bearer,"S/ "+product_name+"/ "+quantity_kg_bag);

                int psId = DatabaseManager.getLastTransactionID();
                insertIntoTransactionTable(psId, productRec.toString(),quantity_kg_bag+"/"+termsConditions,total_amount,"SALE",customerRec.toString(),bearer);
             }//end if
         }

        if(rows>=1){
  //        JOptionPane.showMessageDialog(this,"Record Successfully SAVED.....");

//          customerComboBox.setSelectedIndex(customerRecIndex);
//          productComboBox.setSelectedIndex(productRecIndex);
//          yearComboBox.setSelectedIndex(cashRegisterRecIndex);

//          getSaleBook();
//          clearRecord();

       }//end if
       else{
          JOptionPane.showMessageDialog(this,"ERROR OCCURED IN SAVING SALE...");
       }

   }//END OUTER IF

  }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
  }

  }//end Of loop

//  refresh();

}//end method

private void addCashRecord(){
 try{
    //Modified
    if(amountTextField.getText().trim().equals("") || amountTextField.getText().trim().equals("0")){
      System.out.println("Amount text field is zero");
      return;
    }

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
    String remarks="";//descriptionTextArea.getText();

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

    //Modified
//    if ( Integer.parseInt(amount) == 0){
//      return;
//    }

    String payment_mode=(String)this.paymentModeComboBox.getSelectedItem();
    if(payment_mode==null){
      System.out.println("Patmment mode is null");
      return;
    }

    if(payment_mode.equalsIgnoreCase("CASH")){
        int r = addTransaction(customerRec.customer_id, cashRegisterRec.cash_reg_id, amount, debit_credit, date_of_trans, bearer, remarks,payment_mode);
        insertCashIntoTransactionTable(r,remarks,payment_mode,amount+" ",debit_credit.startsWith("C")?"CREDIT":"DEBIT",customerRec.toString(),bearerTextField.getText());
    }else{
        CustomerRecord bankCustomerRec=(CustomerRecord)this.customerBankComboBox.getSelectedItem();
        if(bankCustomerRec==null){
          System.out.println("Bank customer is not selected..");
          return;
        }

        int row1=DatabaseManager.addTransaction(customerRec.customer_id, cashRegisterRec.cash_reg_id, amount, debit_credit, date_of_trans, bearer, remarks,payment_mode);
        insertCashIntoTransactionTable(row1,remarks,payment_mode,amount+" ",debit_credit.startsWith("C")?"CREDIT":"DEBIT",customerRec.toString(),bearerTextField.getText());
        int row2=DatabaseManager.addTransaction(bankCustomerRec.customer_id, cashRegisterRec.cash_reg_id, amount, debit_credit.startsWith("C")?"D":"C", date_of_trans, bearer, remarks,payment_mode);
        insertCashIntoTransactionTable(row2,remarks,payment_mode,amount+" ",debit_credit.startsWith("C")?"DEBIT":"CREDIT",bankCustomerRec.toString(),bearerTextField.getText());
           if(row1>=1 && row2>=1){

               //getCashRegister();

               //Modified
               //getCustomerTransactions();
               //clearRecord();
           }
    }//end if

  }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
  }
 }//end method

 // MODIFIED
 private int addTransaction(String customer_id,String cash_reg_id, String amount, String debit_credit, String date_of_trans, String bearer, String remarks,String payment_mode){
   try{
      int rows=DatabaseManager.addTransaction(customer_id, cash_reg_id, amount, debit_credit, date_of_trans, bearer, remarks,payment_mode);

      if(rows>=1){
          int row=DatabaseManager.cashRegisterIteration(cash_reg_id,amount, debit_credit);
         if(row>=1){
             this.getCashRegister();
             //Modified
             //getCustomerTransactions();
             //clearRecord();
         }//end inner if
      }//outer if
      return rows;
  }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
  }
  return 0;
 }//end method

  private void addPurchase(){

    int customerRecIndex=customerComboBox.getSelectedIndex();
    CustomerRecord customerRec=(CustomerRecord)customerComboBox.getItemAt(customerRecIndex);
    if(customerRec==null){
      JOptionPane.showMessageDialog(this,"Select Customer....");
      return;
    }

     int tableRows = productsTable.getRowCount();

    for(int loop=0;loop<tableRows;loop++){
      if(productsTable.getValueAt(loop,1) == null || productsTable.getValueAt(loop,2) == null || productsTable.getValueAt(loop,1).toString().trim().equals("")){
        continue;
      }

    ProductRecord productRec=(ProductRecord)productsTable.getValueAt(loop,0);

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

    String quantity_kg_bag=productsTable.getValueAt(loop,2).toString().trim();
    String rate_mund_bag=productsTable.getValueAt(loop,1).toString().trim();
    String total_amount=productsTable.getValueAt(loop,3).toString().trim();

    String trans_date=dateTextField.getText().trim();
    String bearer=bearerTextField.getText().trim();
    String terms_and_conditions=termsConditions.trim();
    String remarks="";//descriptionTextArea.getText().trim();
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
    int rows=DatabaseManager.addPurchaseSaleBook(product_id, customer_id, cash_reg_id, quantity_kg_bag, rate_mund_bag, total_amount, trans_date, trans_type,
			                         bearer, terms_and_conditions, remarks);


   //insertIntoTransactionTable(rows+1, productRec.toString(),quantity_kg_bag+"/"+terms_and_conditions,total_amount,"PURCHASE", customerRec.toString(),bearer);
   if(rows>=1){
         rows=DatabaseManager.productIteration(product_id,quantity_kg_bag,total_amount,"D");
         if(terms_and_conditions.equals("CASH")){
             if(rows>=1)
                  rows=DatabaseManager.cashRegisterIteration(cash_reg_id,total_amount,"C");
                  int id = DatabaseManager.getLastPurchaseSaleID();
                  insertIntoTransactionTable(id, productRec.toString(),quantity_kg_bag+"/"+terms_and_conditions,total_amount,"PURCHASE", customerRec.toString(),bearer);

         }else{
             if(rows>=1){
                int purchase_sale_id=DatabaseManager.getLastPurchaseSaleID();
                rows=DatabaseManager.addTransactionPurchaseSale(""+purchase_sale_id,customer_id,cash_reg_id,total_amount,"D",trans_date,bearer,"P/ "+product_name+"/ "+quantity_kg_bag);
                int trId = DatabaseManager.getLastTransactionID();
                insertIntoTransactionTable(trId, productRec.toString(),quantity_kg_bag+"/"+terms_and_conditions,total_amount,"PURCHASE", customerRec.toString(),bearer);
            }//end if
         }

        if(rows>=1){
//          JOptionPane.showMessageDialog(this,"Record Successfully SAVED.....");
//          refresh();

//          customerComboBox.setSelectedIndex(customerRecIndex);
//          productComboBox.setSelectedIndex(productRecIndex);
//          yearComboBox.setSelectedIndex(cashRegisterRecIndex);

//          getPurchaseBook();
//          clearRecord();
       }//end if
   }//END OUTER IF

  }catch(Exception e){
    JOptionPane.showMessageDialog(this,e.getMessage());
    e.printStackTrace();
  }

  }// End of Loop
}//end method

  private void insertCashIntoTransactionTable(int transactionId, String product, String quantity, String amount,String type, String customer, String bearer)throws Exception{
    transactionCount++;
    transactionTableModel.insertRow(0,new Object[]{""+transactionId, product+" / "+quantity , amount+"/"+type, customer,bearer});
  }

 private void insertIntoTransactionTable(int transactionId, String product, String quantity, String amount,String type, String customer, String bearer)throws Exception{
    transactionCount++;
    transactionTableModel.insertRow(0,new Object[]{""+transactionId, type+"/"+product+" / "+quantity , amount, customer,bearer});
  }
  private void insertIntoTransactionTable(String transactionId, String product, String amount, String customer, String bearer)throws Exception{
    transactionCount++;
    transactionTableModel.insertRow(0,new Object[]{""+transactionId , product, amount, customer});
  }

  private void insertIntoTransactionTable(String transactionId, String remarks, String amount, String customer, String debitCredit, String bearer)throws Exception{
      transactionCount++;
      if(debitCredit != null)
        transactionTableModel.insertRow(0,new Object[]{""+transactionId , remarks+" / "+debitCredit, amount, customer,bearer});
      else
        transactionTableModel.insertRow(0,new Object[]{""+transactionId , remarks+" / ", amount, customer,bearer});
  }

  private void getTodaysTransactions(){
    try{
        clearProductsTable();

        java.util.Vector v = DatabaseManager.getTransactions(dateTextField.getText());
        for(int i=0;i<v.size();i++){
          TransactionDetailsRecord tr = (TransactionDetailsRecord)v.get(i);
          insertIntoTransactionTable(tr.customer_trans_id , tr.remarks, tr.amount, tr.customerName, tr.debit_credit,tr.bearer );
        }

        v = DatabaseManager.getCashTransactionsFromSalePurchase(dateTextField.getText());
        for(int i=0;i<v.size();i++){
          TransactionDetailsRecord tr = (TransactionDetailsRecord)v.get(i);
          insertIntoTransactionTable(tr.customer_trans_id , tr.remarks, tr.amount, tr.customerName, tr.debit_credit,tr.bearer);
        }
    }catch(Exception ex){
      JOptionPane.showMessageDialog(this, ex);
      ex.printStackTrace(System.err);
    }
  }



  private void productComboBoxActionPerformed(){
    ProductRecord productRec=(ProductRecord)productComboBox.getSelectedItem();
    if(productRec==null) return;

    quantityTextField.setText(productRec.quantity_available);
    valueTextField.setText(productRec.product_value);

    String measurementUnit=Decode.measurementUnitDecode(productRec.measurement_unit);

    qKGBagsLabel.setText(measurementUnit);
  }

  private void transactionReportButtonActionPerformed(){
      int rows = transactionTable.getRowCount();
      ArrayList cashList = new ArrayList();
      ArrayList dbCrList = new ArrayList();

      int cashCredit = 0;
      int cashDebit = 0;
      int dcCredit = 0;
      int dcDebit = 0;

      for(int i=0 ; i < rows; i++){
        TransactionRecord record = new TransactionRecord();
        record.customer_trans_id = (String) this.transactionTableModel.getValueAt(i,0);
        String productQuantity =(String) this.transactionTableModel.getValueAt(i,1);
        String amount = (String)this.transactionTableModel.getValueAt(i,2);
        record.customer_id =(String) this.transactionTableModel.getValueAt(i,3);
        record.bearer = (String) this.transactionTableModel.getValueAt(i,4);
        java.util.StringTokenizer tokenizer = new java.util.StringTokenizer( productQuantity,"/");
        int tokens = tokenizer.countTokens();


        // Transaction effects cash
        if(productQuantity.toLowerCase().indexOf("cash")> -1 || productQuantity.toLowerCase().indexOf("cheque") > -1){
          if(tokens == 4){
            String type = tokenizer.nextToken();
            record.remarks = tokenizer.nextToken()+"/"+tokenizer.nextToken();
            if(type.toLowerCase().trim().startsWith("p")){
              record.credit_amount = amount;
            }else{
              record.debit_amount = amount;
            }
          }else if(tokens == 2){
            tokenizer.nextToken();
            record.remarks = tokenizer.nextToken();
            java.util.StringTokenizer amountTokenizer = new java.util.StringTokenizer(amount,"/");
            String cash = amountTokenizer.nextToken();
            String typ = amountTokenizer.nextToken();
            if(typ.trim().toLowerCase().startsWith("c")){
              record.credit_amount = cash;
            }else{
              record.debit_amount = cash;
            }
          }
          cashList.add(record);
          try{
            cashCredit+= Double.parseDouble(record.credit_amount.trim());
          }catch(Exception ex){}
          try{
            cashDebit+=Double.parseDouble(record.debit_amount.trim());
          }catch(Exception ex){}
        }else{// Transaction On credit
          if(tokens == 4){
            java.util.StringTokenizer amountTokenizer = new java.util.StringTokenizer(amount,"/");
            amount = amountTokenizer.nextToken();
            String type = tokenizer.nextToken();
            String product = tokenizer.nextToken();
            String quantity = tokenizer.nextToken();
            String dc = tokenizer.nextToken();
            if(type.trim().toLowerCase().startsWith("s")){
              record.remarks = "S/"+product+"/"+quantity;
              record.credit_amount = amount;
            }else{
              record.remarks = "P/"+product+"/"+quantity;
              record.debit_amount = amount;
            }
          }
          dbCrList.add(record);
          try{
            dcCredit+=Double.parseDouble(record.credit_amount.trim());
          }catch(Exception ex){}
          try{
            dcDebit+=Double.parseDouble(record.debit_amount.trim());
            }catch(Exception ex){}
        }

      }//end of for

      try{
        ReportCashTodayTransactions.printTransactionReport("CASH BOOK",""+cashDebit,""+cashCredit,currentBalanceTextField.getText(),cashList, dateTextField.getText(), null);
        ReportCashTodayTransactions.printTransactionReport("DEBIT/ CREDIT BOOK",""+dcDebit,""+dcCredit,currentBalanceTextField.getText(),dbCrList, dateTextField.getText(), null);
      }catch(Exception ex){ex.printStackTrace();}
  }

  private void setProductAmountCalculation(){
    double rate = 0;
    double quantity = 0;
    try{
      quantity = Double.parseDouble( saleQuantityTextField.getText());
    }catch(Exception ex){}
    try{
      rate = Double.parseDouble(rateTextField.getText());
    }catch(Exception ex){}
    rsTextField.setText(""+rate*quantity);
  }

  private void setProductRateCalculation(){
    double quantity = 0;
    double rs = 0;
    try{
      quantity = Double.parseDouble( saleQuantityTextField.getText());
    }catch(Exception ex){}
    try{
      rs = Double.parseDouble(rsTextField.getText());
    }catch(Exception ex){}
      java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
      rateTextField.setText(""+df.format(rs/quantity) ) ;
  }

  public void enterPressedOnRate(){
    if(rsTextField.getText().equals("0"))return;
        productTableModel.insertRow(0, new Object[]{productComboBox.getSelectedItem(), rateTextField.getText(), saleQuantityTextField.getText(), rsTextField.getText()});
        billTotalCalculation();
        rsTextField.setText("");
        saleQuantityTextField.setText("");
        this.rateTextField.setText("");
  }

  public void clearProductsTable(){
      int rows = productTableModel.getRowCount();
      for(int i=0;i<rows;i++)productTableModel.removeRow(0);
  }

  public void clearTransactionTable(){
    int rows = transactionTable.getRowCount();
      for(int i=0;i<rows;i++) ((javax.swing.table.DefaultTableModel)transactionTable.getModel()).removeRow(0);
  }

  void dispatchRadioButton_actionPerformed(ActionEvent e) {}


  // New Coding For Printing
  private void printing(){
    int rows[] = transactionTable.getSelectedRows();
      String termsAndConditions = "CASH/CHEQUE";
      String transactionType = "CREDIT";
      if(paymentModeComboBox.getSelectedItem().toString().equalsIgnoreCase("cheque")){
        transactionType = creditDebitComboBox.getSelectedItem().toString();
      }
      String customer = "";
      String bearer = "";
      int trId = 0;
      ArrayList trList = new ArrayList();
      for(int i=0;i<rows.length;i++){
        String id =(String) this.transactionTableModel.getValueAt(rows[i],0);
        trId = Integer.parseInt(id);

        String productQuantity =(String) this.transactionTableModel.getValueAt(rows[i],1);
        String amount = (String)this.transactionTableModel.getValueAt(rows[i],2);
        customer =(String) this.transactionTableModel.getValueAt(rows[i],3);
        bearer = (String) this.transactionTableModel.getValueAt(rows[i],4);
        TransactionBillRecord record = new TransactionBillRecord();
        java.util.StringTokenizer tokenizer = new java.util.StringTokenizer( productQuantity,"/");
        int tokens = tokenizer.countTokens();

        System.out.println(id+" - "+productQuantity+" - "+amount);
        record.transactionId = ""+id;
        if(productQuantity.startsWith("P") || productQuantity.startsWith("S")){
          if(productQuantity.startsWith("P"))termsAndConditions = "PURCHASE";
          else termsAndConditions = "SALE";
        }

        //Means transaction is of sale or purchase
        if(tokens == 4){
          tokenizer.nextToken();
          record.productName = tokenizer.nextToken().trim();
          record.quantity = tokenizer.nextToken().trim();
          String type = tokenizer.nextToken().trim();

          if(type.equals("")){
            java.util.StringTokenizer amountToken = new java.util.StringTokenizer(amount);
            record.totalAmount = amountToken.nextToken().trim();
            record.rate = ""+ (Double.parseDouble(record.totalAmount)/Double.parseDouble(record.quantity) );
          }else{
            record.totalAmount = ""+Double.parseDouble(amount);
            record.rate = ""+ (Double.parseDouble(record.totalAmount)/Double.parseDouble(record.quantity));
          }

          if(type.equalsIgnoreCase("CASH")){
            transactionType = "CASH";
          }
        }
        //Transaction is of cash / cheque
        else if(tokens == 2){
          tokenizer.nextToken();
          record.productName = tokenizer.nextToken().trim();
          //if(record.productName.equalsIgnoreCase("CHEQUE")){}
          int index = amount.indexOf("/");
          record.totalAmount = amount.substring(0,index-1).trim();
          record.productName += ("("+amount.substring(index+1).trim()+")");
        }
        trList.add(record);
      }//end of for
    try{
      if(this.billRadioButton.isSelected() && billRadioButton.isEnabled()){
        ReportReceiptBill.printBill(customer,bearer,transactionType,termsAndConditions,trList);
      }
      if(this.voucharRadioButton.isSelected() && voucharRadioButton.isEnabled()){
        ReportVouchar.printVouchar(customer,bearer,transactionType,termsAndConditions,trList);
      }//end of if radio vouchar
      if(this.dispatchRadioButton.isSelected() && dispatchRadioButton.isEnabled()){
        ReportDispatchOrder.printDispatch(trId , customer,bearer, transactionType,termsAndConditions,trList,"DISPATCH ORDER");
        ReportDispatchOrder.printDispatch(trId , customer,bearer, transactionType,termsAndConditions,trList,"-------------   DUPLICATE -----------------");
      }
    }catch(Exception ex){javax.swing.JOptionPane.showMessageDialog(this,"Error Occured during printing");}
  }



  private void addTransactions(){
    System.out.println("--->> Add transactions()");
    transactionCount=0;
    this.dialogShowed = false;
    if( (amountTextField.getText().trim().equals("") || amountTextField.getText().trim().equals("0")) && (productAmountTextField.getText().trim().equals("") || productAmountTextField.getText().trim().equals("0"))  ){
      JOptionPane.showMessageDialog(null,"No transaction is processed..","Warning",JOptionPane.ERROR_MESSAGE);
      dialogShowed = true;
      return;
    }

    String type = transactionTypeComboBox.getSelectedItem().toString();
    int productSelectedIndex = productComboBox.getSelectedIndex();
        boolean cash = false;
        if( !(amountTextField.getText().trim().equals("") || amountTextField.getText().trim().equals("0") ) ){
             addCashRecord();
             cash = true;
             System.out.println("Affected transaction.. Cash"+cash);
        }
        if(type.equals("SALE")){
          if( !totalAmountTextField.getText().trim().equals("") || !totalAmountTextField.getText().trim().equals("0") ){
            addSaleRecord();
          }
        }else if(type.equals("PURCHASE")){
          if( !totalAmountTextField.getText().trim().equals("") || !totalAmountTextField.getText().trim().equals("0") ){
            addPurchase();
          }
        }

        if(voucharRadioButton.isSelected() || billRadioButton.isSelected() || dispatchRadioButton.isSelected()){
          System.out.println("><> printing Also");
          if(paymentModeComboBox.getSelectedItem().toString().equalsIgnoreCase("cheque")){
            transactionTable.setRowSelectionInterval(1,transactionCount-1);
          }else{
            transactionTable.setRowSelectionInterval(0,transactionCount-1);
          }
          buttonPrint.doClick();
        }
        refresh();
        productComboBox.setSelectedIndex(productSelectedIndex);
        productAmountTextField.setText("");
        JOptionPane.showMessageDialog(this,"Transaction Successfully SAVED.....");
  }



/**
 * OLD CODING FOR ADD AND PRINT BUTTON (ALL METHODS BELOW THIS)
 * */



  // OLD CODING FOR PRINTING AND ADDDING
  private void printSalePurchaseButtonPressed(){
    if(this.recieptRadioButton.isSelected()){
          //if(this.customerBankComboBox.isVisible() )

          if(!this.amountTextField.getText().trim().equals("")){
            printReciept();
          }
          //else JOptionPane.showMessageDialog(null, "Reciept Cant be generated..");
        }
        else {
          addAndPrint();
        }
  }

  private void printReciept(){
    try{
        addCashRecord();
          ReportReceipt.printReceipt(DatabaseManager.getLastTransactionID(),customerComboBox.getSelectedItem().toString(), bearerTextField.getText(),creditDebitComboBox.getSelectedItem().toString(),paymentModeComboBox.getSelectedItem().toString(),Integer.parseInt(amountTextField.getText()));
          amountTextField.setText("");
        }catch(Exception ex){
          JOptionPane.showMessageDialog(this,"Error Occured");
          ex.printStackTrace();
        }
  }


  private void addAndPrint(){
    String type = transactionTypeComboBox.getSelectedItem().toString();

        if( (totalAmountTextField.getText().trim().equals("") || totalAmountTextField.getText().trim().equals("0"))  && (!amountTextField.getText().trim().equals("") || !amountTextField.getText().trim().equals("0")) ){
             addCashRecord();
             System.out.println("Affected transaction..");
        }

        if(type.equals("SALE")){
          if( !totalAmountTextField.getText().trim().equals("") || !totalAmountTextField.getText().trim().equals("0") ){
            addSaleRecord();
            System.out.println("Affected sale purchase book..");
          }
          if( !totalAmountTextField.getText().trim().equals("") && (termsConditionsComboBox.getSelectedItem().toString().trim().equals("CREDIT")) &&  (!amountTextField.getText().trim().equals("") || !amountTextField.getText().trim().equals("0")) ){
             addCashRecord();
             System.out.println("Affected transaction..");
          }

        }else if(type.equals("PURCHASE")){
          if( !totalAmountTextField.getText().trim().equals("") || !totalAmountTextField.getText().trim().equals("0") ){
            addPurchase();
          }
          if( !totalAmountTextField.getText().trim().equals("") && (termsConditionsComboBox.getSelectedItem().toString().trim().equals("CREDIT")) &&  (!amountTextField.getText().trim().equals("") || !amountTextField.getText().trim().equals("0")) ){
             addCashRecord();
             System.out.println("Affected transaction..");
          }
        }

        // Collecting All Products
        String name = customerComboBox.getSelectedItem().toString();
        java.util.ArrayList transList = new java.util.ArrayList();
        int rows = productsTable.getRowCount();
        for(int loop=0;loop<rows;loop++){
          if(productsTable.getValueAt(loop,1) == null || productsTable.getValueAt(loop,2) == null || productsTable.getValueAt(loop,1).toString().trim().equals("")){
            continue;
          }
          ProductRecord productRec=(ProductRecord)productsTable.getValueAt(loop,0);
          TransactionBillRecord record = new TransactionBillRecord();
          record.productName = productRec.name;
          record.quantity =  productsTable.getValueAt(loop,2).toString().trim();
          record.rate =productsTable.getValueAt(loop,1).toString().trim();
          record.totalAmount=productsTable.getValueAt(loop,3).toString().trim();
          transList.add(record);
      }


      // Start Printing
      if(voucharRadioButton.isSelected()){

      String amount = amountTextField.getText().trim();
      if( (!amount.equals("")) && (!amount.equals("0"))){
        TransactionBillRecord record = new TransactionBillRecord();
        record.productName = creditDebitComboBox.getSelectedItem().toString();
        record.totalAmount = amount;
        transList.add(record);
      }

      try{
        ReportVouchar.printVouchar(name, bearerTextField.getText(), transactionTypeComboBox.getSelectedItem().toString() , termsConditionsComboBox.getSelectedItem().toString(), transList);
      }catch(Exception ex){
        javax.swing.JOptionPane.showMessageDialog(this,"Error Occured in Printing");
        ex.printStackTrace();
      }

      }else if(dispatchRadioButton.isSelected()){
        try{
          ReportDispatchOrder.printDispatch(DatabaseManager.getLastPurchaseSaleID(),name, bearerTextField.getText(), transactionTypeComboBox.getSelectedItem().toString() , termsConditionsComboBox.getSelectedItem().toString(), transList,"DISPTACH");
          ReportDispatchOrder.printDispatch(DatabaseManager.getLastPurchaseSaleID(),name, bearerTextField.getText(), transactionTypeComboBox.getSelectedItem().toString() , termsConditionsComboBox.getSelectedItem().toString(), transList,"------------ DUPLICATE ---------");

        }catch(Exception ex){
          javax.swing.JOptionPane.showMessageDialog(this,"Error Occured in Printing");
          ex.printStackTrace();
        }
      }else if(billRadioButton.isSelected()){
        try{
          ReportReceiptBill.printBill(name, bearerTextField.getText(), transactionTypeComboBox.getSelectedItem().toString() , termsConditionsComboBox.getSelectedItem().toString(), transList);
        }catch(Exception ex){
          javax.swing.JOptionPane.showMessageDialog(this,"Error Occured in Printing");
          ex.printStackTrace();
        }
      }
      refresh();
  }

  public void removeDefaultFocusOfTab(){
    // dateTextField.setFocusTraversalKeys(java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
    // customerComboBox.setFocusTraversalKeys(java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
    // bearerTextField.setFocusTraversalKeys(java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
    // amountTextField.setFocusTraversalKeys(java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
    // paymentModeComboBox.setFocusTraversalKeys(java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
    // creditDebitComboBox.setFocusTraversalKeys(java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
    // transactionTypeComboBox.setFocusTraversalKeys(java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
    // termsConditionsComboBox.setFocusTraversalKeys(java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
    // productComboBox.setFocusTraversalKeys(java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);
    // rateTextField.setFocusTraversalKeys(java.awt.KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, java.util.Collections.EMPTY_SET);

    bearerTextField.setNextFocusableComponent(transactionTypeComboBox);
    transactionTypeComboBox.setNextFocusableComponent(termsConditionsComboBox);
    termsConditionsComboBox.setNextFocusableComponent(productComboBox);
    productComboBox.setNextFocusableComponent(saleQuantityTextField);
    saleQuantityTextField.setNextFocusableComponent(rateTextField);
    rateTextField.setNextFocusableComponent(rsTextField);
    rsTextField.setNextFocusableComponent(billRadioButton);
    backButton.setNextFocusableComponent(dateTextField);
    dateTextField.setNextFocusableComponent(customerComboBox);
    amountTextField.setNextFocusableComponent(creditDebitComboBox);
    creditDebitComboBox.setNextFocusableComponent(paymentModeComboBox);
    paymentModeComboBox.setNextFocusableComponent(customerBankComboBox);
    customerBankComboBox.setNextFocusableComponent(transactionTypeComboBox);
//    dateTextField.addKeyListener(this);
//    customerComboBox.addKeyListener(this);
//    bearerTextField.addKeyListener(this);
    amountTextField.addKeyListener(this);
//    paymentModeComboBox.addKeyListener(this);
//    creditDebitComboBox.addKeyListener(this);
//    transactionTypeComboBox.addKeyListener(this);
//    termsConditionsComboBox.addKeyListener(this);
//    productComboBox.addKeyListener(this);
    saleQuantityTextField.addKeyListener(this);
    rateTextField.addKeyListener(this);
//    voucharRadioButton.addKeyListener(this);
//    productsTableScrollPane.addKeyListener(this);
//    productsTable.addKeyListener(this);
//    transactionTable.addKeyListener(this);
//    billRadioButton.addKeyListener(this);
//    dispatchRadioButton.addKeyListener(this);
//    recieptRadioButton.addKeyListener(this);
//    customerBankComboBox.addKeyListener(this);
  }

  public void keyPressed(KeyEvent evt){
    Object ob = evt.getSource();
    if(previousKey == evt.VK_CONTROL){
      keyStrokeMap(evt);
    }

    previousKey = evt.getKeyCode();

    if(evt.getKeyCode() == KeyEvent.VK_TAB){
      keyTabPressed(ob);
    }
  }

  public void keyStrokeMap(KeyEvent evt){
    if(evt.getKeyCode() == evt.VK_A){
        customerComboBox.grabFocus();
      }else if(evt.getKeyCode() == evt.VK_B){
        bearerTextField.grabFocus();
      }else if(evt.getKeyCode() == evt.VK_C){
        amountTextField.grabFocus();
      }else if(evt.getKeyCode() == evt.VK_P){
        productComboBox.grabFocus();
      }else if(evt.getKeyCode() == evt.VK_Q){
        saleQuantityTextField.grabFocus();
      }else if(evt.getKeyCode() == evt.VK_R){
        rateTextField.grabFocus();
      }else if(evt.getKeyCode() == evt.VK_Z){
        clearButton.doClick();
      }
  }

  public void addKeyStrokes(JComponent comp){
    String P_ACTION_KEY = "ProductAction";
    String A_ACTION_KEY = "CustomerAction";
    String B_ACTION_KEY = "BearerAction";
    String C_ACTION_KEY = "CashAmountAction";
    String Q_ACTION_KEY = "QuantityAction";
    String R_ACTION_KEY = "RateAction";
    String Z_ACTION_KEY = "ClearAction";
    String V_ACTION_KEY = "VoucharAction";
    String ENTER_ACTION_KEY = "ENTERAction";

    KeyStroke ctrlA = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK);
    KeyStroke ctrlB = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK);
    KeyStroke ctrlC = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK);
    KeyStroke ctrlP = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK);
    KeyStroke ctrlQ = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK);
    KeyStroke ctrlR = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK);
    KeyStroke ctrlZ = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK);
    KeyStroke ctrlV = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK);
    KeyStroke ctrlENTER = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.CTRL_MASK);


    if(comp instanceof javax.swing.JTextField){
      javax.swing.JTextField field = (JTextField)comp;
      field.registerKeyboardAction(new ActionListener(){
                                   public void actionPerformed(ActionEvent actionEvent){ customerComboBox.grabFocus(); }
                                   },
                                   ctrlA,
                                   JComponent.WHEN_FOCUSED
      );
      field.registerKeyboardAction(new ActionListener(){
                                   public void actionPerformed(ActionEvent actionEvent){ bearerTextField.grabFocus(); }
                                   },
                                   ctrlB,
                                   JComponent.WHEN_FOCUSED
      );
      field.registerKeyboardAction(new ActionListener(){
                                   public void actionPerformed(ActionEvent actionEvent){amountTextField.grabFocus(); }
                                   },
                                   ctrlC,
                                   JComponent.WHEN_FOCUSED
      );
      field.registerKeyboardAction(new ActionListener(){
                                   public void actionPerformed(ActionEvent actionEvent){productComboBox.grabFocus(); }
                                   },
                                   ctrlP,
                                   JComponent.WHEN_FOCUSED
      );
      field.registerKeyboardAction(new ActionListener(){
                                   public void actionPerformed(ActionEvent actionEvent){saleQuantityTextField.grabFocus(); }
                                   },
                                   ctrlQ,
                                   JComponent.WHEN_FOCUSED
      );
      field.registerKeyboardAction(new ActionListener(){
                                   public void actionPerformed(ActionEvent actionEvent){rateTextField.grabFocus(); }
                                   },
                                   ctrlR,
                                   JComponent.WHEN_FOCUSED
      );
      field.registerKeyboardAction(new ActionListener(){
                                   public void actionPerformed(ActionEvent actionEvent){clearButton.doClick(); }
                                   },
                                   ctrlZ,
                                   JComponent.WHEN_FOCUSED
      );
      field.registerKeyboardAction(new ActionListener(){
                                   public void actionPerformed(ActionEvent actionEvent){addTransactions(); }
                                   },
                                   ctrlENTER,
                                   JComponent.WHEN_FOCUSED
      );
      field.registerKeyboardAction(new ActionListener(){
                                   public void actionPerformed(ActionEvent actionEvent){if(voucharRadioButton.isEnabled())voucharRadioButton.grabFocus(); }
                                   },
                                   ctrlV,
                                   JComponent.WHEN_FOCUSED
      );
      return;
    }
    InputMap inputMap = comp.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    inputMap.put(ctrlA, A_ACTION_KEY);
    inputMap.put(ctrlB, B_ACTION_KEY);
    inputMap.put(ctrlC, C_ACTION_KEY);
    inputMap.put(ctrlP, P_ACTION_KEY);
    inputMap.put(ctrlQ, Q_ACTION_KEY);
    inputMap.put(ctrlR, R_ACTION_KEY);
    inputMap.put(ctrlZ, Z_ACTION_KEY);
    inputMap.put(ctrlV, V_ACTION_KEY);
    inputMap.put(ctrlENTER, ENTER_ACTION_KEY);

    ActionMap actionMap = comp.getActionMap();
    actionMap.put(A_ACTION_KEY, new AbstractAction(){
      public void actionPerformed(ActionEvent actionEvent){ customerComboBox.grabFocus(); }
    });
    actionMap.put(B_ACTION_KEY, new AbstractAction(){
      public void actionPerformed(ActionEvent actionEvent){ bearerTextField.grabFocus(); }
    });
    actionMap.put(C_ACTION_KEY, new AbstractAction(){
      public void actionPerformed(ActionEvent actionEvent){ amountTextField.grabFocus(); }
    });
    actionMap.put(P_ACTION_KEY, new AbstractAction(){
      public void actionPerformed(ActionEvent actionEvent){ productComboBox.grabFocus(); }
    });
    actionMap.put(Q_ACTION_KEY, new AbstractAction(){
      public void actionPerformed(ActionEvent actionEvent){ saleQuantityTextField.grabFocus(); }
    });
    actionMap.put(R_ACTION_KEY, new AbstractAction(){
      public void actionPerformed(ActionEvent actionEvent){ rateTextField.grabFocus(); }
    });
    actionMap.put(Z_ACTION_KEY, new AbstractAction(){
      public void actionPerformed(ActionEvent actionEvent){ clearButton.doClick(); }
    });
    actionMap.put(V_ACTION_KEY, new AbstractAction(){
      public void actionPerformed(ActionEvent actionEvent){ if(voucharRadioButton.isEnabled())voucharRadioButton.grabFocus(); }
    });
    actionMap.put(ENTER_ACTION_KEY, new AbstractAction(){
      public void actionPerformed(ActionEvent actionEvent){System.out.println("component.stroke"); addTransactions(); }
    });

  }



  public void keyTabPressed(Object ob){
//      if(ob == dateTextField){
//        customerComboBox.grabFocus();
//      }else if(ob == customerBankComboBox ){
//        billRadioButton.grabFocus();
//      }else if(ob == customerComboBox){
//        bearerTextField.grabFocus();
//      }else if(ob == bearerTextField && amountTextField.isEnabled() ){
//        amountTextField.grabFocus();
//      }else if(ob == bearerTextField && (!amountTextField.isEnabled()) ){
//        transactionTypeComboBox.grabFocus();
//      }else if(ob == amountTextField){
//        creditDebitComboBox.grabFocus();
//      }else if(ob == paymentModeComboBox && productComboBox.isEnabled()){
//        transactionTypeComboBox.grabFocus();
//      }else if(ob == paymentModeComboBox && (!productComboBox.isEnabled()) ){
//        customerBankComboBox.grabFocus();
//      }else if(ob == creditDebitComboBox){
//        paymentModeComboBox.grabFocus();
//      }else if(ob == transactionTypeComboBox && (!productComboBox.isEnabled())){
//        billRadioButton.grabFocus();
//      }else if(ob == transactionTypeComboBox){
//        termsConditionsComboBox.grabFocus();
//      }else if(ob == termsConditionsComboBox){
//        productComboBox.grabFocus();
//      }else if(ob == productComboBox){
//        saleQuantityTextField.grabFocus();
//      }else if(ob == rateTextField && voucharRadioButton.isEnabled()){
//        voucharRadioButton.grabFocus();
//      }else if(ob == rateTextField && (!voucharRadioButton.isEnabled()) ){
//        billRadioButton.grabFocus();
//      }else if(ob == billRadioButton && (!voucharRadioButton.isEnabled()) ){
//        customerComboBox.grabFocus();
//      }else if(ob == dispatchRadioButton ){
//        customerComboBox.grabFocus();
//      }
  }

  public void keyReleased(KeyEvent evt){
    Object ob = evt.getSource();
    if(evt.getKeyCode() != KeyEvent.VK_TAB){
      if(ob == rateTextField){
        setProductAmountCalculation();
      }else if(ob == saleQuantityTextField){
        setProductAmountCalculation();
      }else if(ob == rsTextField){
        setProductRateCalculation();
        if(evt.getKeyCode() == evt.VK_ENTER){
          enterPressedOnRate();
        }
      }
    }
  }

  public void keyTyped(KeyEvent evt){}

  }