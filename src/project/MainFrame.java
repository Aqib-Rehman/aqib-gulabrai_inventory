package project;

import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class MainFrame extends JFrame implements ActionListener{

  private JMenuBar menuBar=new JMenuBar();

  private JMenu customerMenu=new JMenu("CUSTOMER");
  private JMenu productMenu=new JMenu("PRODUCT");
  private JMenu cashRegClosingAccMenu=new JMenu("CASH REGISTER/ CLOSING ACCOUNT");
  private JMenu reportMenu=new JMenu("REPORTS");


  private JMenuItem  customerItem=new JMenuItem("CUSTOMER");
  private JMenuItem  cashTransactionItem=new JMenuItem("CASH TRANSACTION");
  private JMenuItem  exitItem=new JMenuItem("EXIT");

  private JMenuItem  productItem=new JMenuItem("PRODUCT");
  private JMenuItem  purchaseBookItem=new JMenuItem("PURCHASE BOOK");
  private JMenuItem  saleBookItem=new JMenuItem("SALE BOOK");
  //MODIFIED
  private JMenuItem  voucharItem = new JMenuItem("VOUCHAR");

  private JMenuItem  cashBookItem=new JMenuItem("CASH BOOK");
  private JMenuItem  accountPayableReceivableItem=new JMenuItem("ACCOUNT PAYABLE/ RECEIVABLE");
  private JMenuItem  creditDebitBookItem=new JMenuItem("CREDIT/ DEBIT BOOK");
  private JMenuItem  cashRegisterItem=new JMenuItem("CASH REGISTER");
  private JMenuItem  accountClosingItem=new JMenuItem("ACCOUNT CLOSING/ DUMPING");

  private JMenuItem  reportItem=new JMenuItem("PRINTING REPORT");

  private ProductFrame productFrame=new ProductFrame();
  private SaleBookFrame saleBookFrame=new SaleBookFrame();
  private CashRegisterFrame cashRegisterFrame=new CashRegisterFrame();
  private CashBookFrame cashBookFrame=new CashBookFrame();
  private CreditDebitBookFrame creditDebitBookFrame=new CreditDebitBookFrame();
  private CustomerFrame customerFrame=new CustomerFrame();
  private TransactionFrame transactionFrame=new TransactionFrame();
  private PurchaseBookFrame purchaseBookFrame=new PurchaseBookFrame();
  private AccountClosingFrame accountClosingFrame=new AccountClosingFrame();
  private ReportFrame reportFrame=new ReportFrame();
  private AccountPayableReceivableFrame accountPayableReceivableFrame=new AccountPayableReceivableFrame();
  //MODIFIED
  private VoucharFrame voucharFrame = new VoucharFrame();

  private JLabel heading1Label = new JLabel();
  private JLabel heading2Label = new JLabel();
  private JLabel heading3Label = new JLabel();
  private JLabel heading1Label1 = new JLabel();
  private JLabel heading3Label1 = new JLabel();
  private JLabel jLabel1 = new JLabel(new ImageIcon("8.jpg"));
  private JLabel jLabel2 = new JLabel(new ImageIcon("2.jpg"));
  private JLabel jLabel3 = new JLabel(new ImageIcon("6.jpg"));
  private JLabel jLabel4 = new JLabel(new ImageIcon("4.jpg"));
  private JLabel jLabel5 = new JLabel(new ImageIcon("5.jpg"));
  private JLabel jLabel6 = new JLabel(new ImageIcon("7.jpg"));

  public MainFrame(Vector v) {
   super("Gulab-Rai Mukhi Mengho Mal Commission Agent-Sinjhoro");
   try {
      jbInit(v);
   }catch (Exception exception) {
      exception.printStackTrace();
   }
  }

  private void jbInit(Vector v) throws Exception {
    getContentPane().setLayout(null);

    this.setJMenuBar(menuBar);
    heading1Label.setFont(new java.awt.Font("Dialog", 1, 45));
    heading1Label.setText("Gulab-Rai Mukhi Mengho Mal");
    heading1Label.setBounds(new Rectangle(329, 43, 638, 52));
    heading2Label.setFont(new java.awt.Font("Dialog", 1, 30));
    heading2Label.setText("Commission Agent-Sinjhoro");
    heading2Label.setBounds(new Rectangle(552, 79, 407, 53));
    heading3Label.setFont(new java.awt.Font("Serif", 1, 60));
    heading3Label.setText("Inventory Automation");
    heading3Label.setBounds(new Rectangle(351, 472, 632, 77));

    this.setResizable(false);

    heading1Label1.setBounds(new Rectangle(332, 46, 638, 52));
    heading1Label1.setText("Gulab-Rai Mukhi Mengho Mal");
    heading1Label1.setFont(new java.awt.Font("Dialog", 1, 45));
    heading1Label1.setForeground(Color.gray);
    heading3Label1.setBounds(new Rectangle(355, 470, 632, 80));
    heading3Label1.setText("Inventory Automation");
    heading3Label1.setBackground(Color.lightGray);
    heading3Label1.setFont(new java.awt.Font("Serif", 1, 60));
    heading3Label1.setForeground(Color.lightGray);

    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(3);

    jLabel1.setText("");
    jLabel1.setBounds(new Rectangle(237, 99, 185, 188));
    jLabel2.setText("");
    jLabel2.setBounds(new Rectangle(402, 128, 189, 99));
    jLabel3.setText("");
    jLabel3.setBounds(new Rectangle(760, 125, 307, 207));
    jLabel4.setText("");
    jLabel4.setBounds(new Rectangle(571, 126, 198, 172));
    jLabel5.setToolTipText("");
    jLabel5.setText("");
    jLabel5.setBounds(new Rectangle(770, 327, 230, 163));
    jLabel6.setText("");
    jLabel6.setBounds(new Rectangle(368, 279, 270, 200));
    
    
    
 int productMenuCount,cashRegClosingAccMenuCount,reportMenuCount;
 productMenuCount=cashRegClosingAccMenuCount=reportMenuCount=0;
     
    
String framesList  = v.get(0).toString();
//framesList.ind
StringTokenizer strTokens =
                new StringTokenizer(framesList, ",");

 while(strTokens.hasMoreTokens()) {
 
            // print token one-by-one iteratively
     
     String myToken = strTokens.nextToken();
            System.out.println(myToken);
            
            if(myToken.equals("ALL")){
                
                
    customerMenu.add(customerItem);
    customerMenu.add(cashTransactionItem);
    customerMenu.add(exitItem);

    productMenu.add(productItem);
    productMenu.add(purchaseBookItem);
    productMenu.add(saleBookItem);
    productMenu.add(voucharItem);

    cashRegClosingAccMenu.add(cashBookItem);
    cashRegClosingAccMenu.add(creditDebitBookItem);
    cashRegClosingAccMenu.add(accountPayableReceivableItem);
    cashRegClosingAccMenu.add(cashRegisterItem);
    cashRegClosingAccMenu.add(accountClosingItem);
    
    reportMenu.add(reportItem);
                
                
    
        
    menuBar.add(customerMenu); 
    menuBar.add(productMenu); 
    menuBar.add(cashRegClosingAccMenu); 
    menuBar.add(reportMenu);
            }
            
            else{
            if(myToken.equals("CUSTOMER")){
                customerMenu.add(customerItem);
            }
            else if(myToken.equals("CASH TRANSACTION")){
                customerMenu.add(cashTransactionItem);
            }
             else if(myToken.equals("PRODUCT")){
                productMenu.add(productItem);
                productMenuCount++;
            }
             else if(myToken.equals("PURCHASE BOOK")){
                productMenu.add(purchaseBookItem);
                productMenuCount++;
            }
             else if(myToken.equals("SALE BOOK")){
                productMenu.add(saleBookItem);
                productMenuCount++;
            }
             else if(myToken.equals("VOUCHER")){
                productMenu.add(voucharItem);
                productMenuCount++;
            }
             else if(myToken.equals("CASH BOOK")){
                cashRegClosingAccMenu.add(cashBookItem);
                cashRegClosingAccMenuCount++;
            }
             else if(myToken.equals("CR/DT BOOK")){
                cashRegClosingAccMenu.add(creditDebitBookItem);
                 cashRegClosingAccMenuCount++;
            }
             else if(myToken.equals("A/C PAY/REC")){
                cashRegClosingAccMenu.add(accountPayableReceivableItem);
                 cashRegClosingAccMenuCount++;
            }
             else if(myToken.equals("CASH REGISTER")){
                cashRegClosingAccMenu.add(cashRegisterItem);
                 cashRegClosingAccMenuCount++;
            }
             else if(myToken.equals("AC CLOSING")){
                cashRegClosingAccMenu.add(accountClosingItem);
                 cashRegClosingAccMenuCount++;
            }
             else if(myToken.equals("PRINTING REPORTS")){
                reportMenu.add(reportItem);
                reportMenuCount++;
            }
        }

//    customerMenu.add(customerItem);
//    customerMenu.add(cashTransactionItem);
    customerMenu.add(exitItem);

//    productMenu.add(productItem);
//    productMenu.add(purchaseBookItem);
//    productMenu.add(saleBookItem);
//    productMenu.add(voucharItem);

//    cashRegClosingAccMenu.add(cashBookItem);
//    cashRegClosingAccMenu.add(creditDebitBookItem);
//    cashRegClosingAccMenu.add(accountPayableReceivableItem);
//    cashRegClosingAccMenu.add(cashRegisterItem);
//    cashRegClosingAccMenu.add(accountClosingItem);
    
//    reportMenu.add(reportItem);
    
    
    
    menuBar.add(customerMenu);
    if(productMenuCount!=0)
    menuBar.add(productMenu);
    if(cashRegClosingAccMenuCount!=0)
    menuBar.add(cashRegClosingAccMenu);
    if(reportMenuCount!=0)
    menuBar.add(reportMenu);
    
  }
    

    this.getContentPane().add(heading1Label1, null);
    this.getContentPane().add(heading3Label1, null);
    this.getContentPane().add(heading1Label);
    this.getContentPane().add(heading2Label);
    this.getContentPane().add(jLabel5, null);
    this.getContentPane().add(jLabel6, null);
    this.getContentPane().add(jLabel1, null);
    this.getContentPane().add(jLabel2, null);
    this.getContentPane().add(jLabel4, null);
    this.getContentPane().add(jLabel3, null);
    this.getContentPane().add(heading3Label);

    Border border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.gray,Color.darkGray,new Color(58, 110, 165)),BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,Color.darkGray,new Color(58, 110, 165)));

    menuBar.setBorder(border);
    reportMenu.setBorder(border);
    customerMenu.setBorder(border);
    cashRegClosingAccMenu.setBorder(border);
    productMenu.setBorder(border);

    accountPayableReceivableItem.setBorder(border);
    customerItem.setBorder(border);
    cashTransactionItem.setBorder(border);
    cashBookItem.setBorder(border);
    creditDebitBookItem.setBorder(border);
    cashRegisterItem.setBorder(border);
    productItem.setBorder(border);
    purchaseBookItem.setBorder(border);
    saleBookItem.setBorder(border);
    reportItem.setBorder(border);
    //MODIFIED
    voucharItem.setBorder(border);

    exitItem.setBorder(border);
    accountClosingItem.setBorder(border);

    accountClosingItem.addActionListener(this);
    creditDebitBookItem.addActionListener(this);
    exitItem.addActionListener(this);
    customerItem.addActionListener(this);
    cashTransactionItem.addActionListener(this);
    cashRegisterItem.addActionListener(this);
    cashBookItem.addActionListener(this);
    productItem.addActionListener(this);
    purchaseBookItem.addActionListener(this);
    saleBookItem.addActionListener(this);
    reportItem.addActionListener(this);
    accountPayableReceivableItem.addActionListener(this);
    voucharItem.addActionListener(this);

    Toolkit kit=this.getToolkit();
    Dimension d=kit.getScreenSize();

    heading1Label.setForeground(Color.black);
    heading2Label.setForeground(Color.black);
    heading3Label.setForeground(Color.black);

    this.setBounds(0,0,d.width,d.height);
    this.show();
  }//end method

  
  
public void actionPerformed(ActionEvent e){
  if(customerItem==e.getSource())  customerFrame.show();
  if(cashTransactionItem==e.getSource())transactionFrame.show();
  if(cashRegisterItem==e.getSource())cashRegisterFrame.show();
  if(cashBookItem==e.getSource())cashBookFrame.show();
  if(creditDebitBookItem==e.getSource())creditDebitBookFrame.show();

  if(productItem==e.getSource())productFrame.show();
  if(purchaseBookItem==e.getSource())purchaseBookFrame.show();
  if(saleBookItem==e.getSource())saleBookFrame.show();
//  if(accountClosingItem==e.getSource())accountClosingFrame.show();
  if(reportItem==e.getSource())reportFrame.show();
  if(accountPayableReceivableItem==e.getSource())accountPayableReceivableFrame.show();
  if(voucharItem==e.getSource())voucharFrame.setVisible(true);

  if(exitItem==e.getSource())System.exit(0);
 } //end method

public void actionPerformed1(Vector v){
  
//  if(e.equals("vf"))voucharFrame.setVisible(true);

 
 } //end method

}//end class
