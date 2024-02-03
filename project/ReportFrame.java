package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.print.*;
/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */


public class ReportFrame extends JFrame implements ActionListener{

  private JLabel headingLabel = new JLabel();
  private JLabel headingLabel1 = new JLabel();
  private JLabel customerLabel = new JLabel();
  private JLabel productLabel = new JLabel();
  private JLabel termsConditionsCustomerLabel = new JLabel();
  private JLabel termsConditionsProductLabel = new JLabel();
  private JLabel dateFromCustomerLabel = new JLabel();
  private JLabel dateToCustomerLabel = new JLabel();
  private JLabel dateToProductLabel = new JLabel();
  private JLabel dateFromProductLabel = new JLabel();
  private JLabel toCustomerLabel = new JLabel();
  private JLabel toProductLabel = new JLabel();
  private JLabel yearCustomerLabel = new JLabel();
  private JLabel yearProductLabel = new JLabel();
  private JLabel transactionTypeLabel = new JLabel();
  private JLabel customerProductLabel = new JLabel();

  private JTextField dateFromCustomerTextField = new JTextField();
  private JTextField dateToCustomerTextField = new JTextField();
  private JTextField dateToProductTextField = new JTextField();
  private JTextField dateFromProductTextField = new JTextField();

  private JComboBox customerComboBox = new JComboBox();
  private JComboBox termsConditionsCustomerComboBox = new JComboBox();
  private JComboBox yearCustomerComboBox = new JComboBox();
  private JComboBox termsConditionsProductComboBox = new JComboBox();
  private JComboBox yearProductComboBox = new JComboBox();
  private JComboBox productComboBox = new JComboBox();
  private JComboBox transactionTypeComboBox = new JComboBox();
  private JComboBox customerProductComboBox = new JComboBox();

  private JButton backButton = new JButton(new ImageIcon("back.jpg"));
  private JButton indvCustomerButton = new JButton(new ImageIcon("printer.jpg"));
  private JButton allCustomerButton = new JButton(new ImageIcon("printer.jpg"));
  private JButton allProductButton = new JButton(new ImageIcon("printer.jpg"));
  private JButton indvProductButton = new JButton(new ImageIcon("printer.jpg"));
  private JButton indvCustomerProductButton = new JButton(new ImageIcon("printer.jpg"));
  private JButton allCustomerProductButton = new JButton(new ImageIcon("printer.jpg"));
  private JButton cashReportButton = new JButton(new ImageIcon("printer.jpg"));

  private JPanel customerPanel = new JPanel();
  private JPanel productPanel = new JPanel();


  private int pageNo;
  JButton indvProductIndvCustomerButton = new JButton(new ImageIcon("printer.jpg"));
  public ReportFrame() {
  super("PRINTING REPORT..........");
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    Border border = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.gray,Color.darkGray,new Color(58, 110, 165)),BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,Color.darkGray,new Color(58, 110, 165)));

    Border border1 =new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)) ;
    TitledBorder titledBorder1 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"CUSTOMER/ CASH REPORT");
    TitledBorder titledBorder2 = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(165, 163, 151)),"PRODUCT REPORT");

    customerComboBox.setKeySelectionManager(new MyKeySelectionManager());
    termsConditionsCustomerComboBox.setKeySelectionManager(new MyKeySelectionManager());

    customerPanel.setBorder(titledBorder1);

    headingLabel.setFont(new java.awt.Font("Dialog", 1, 30));
    headingLabel.setText("PRINTING REPORT");
    headingLabel.setBounds(new Rectangle(415, 56, 290, 33));
    this.getContentPane().setLayout(null);
        this.setResizable(false);

    customerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    customerLabel.setToolTipText("");
    customerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    customerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    customerLabel.setText("CUSTOMER");
    customerLabel.setBounds(new Rectangle(303, 202, 74, 30));
    customerComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    customerComboBox.setBounds(new Rectangle(378, 202, 470, 30));
    dateFromCustomerTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    dateFromCustomerTextField.setBounds(new Rectangle(378, 254, 83, 30));
    backButton.setBounds(new Rectangle(747, 566, 112, 55));
    backButton.setBackground(Color.white);
    backButton.setFont(new java.awt.Font("Dialog", 1, 12));
    backButton.setHorizontalAlignment(SwingConstants.RIGHT);
    backButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    backButton.setText("BACK");
    headingLabel1.setForeground(Color.lightGray);
    headingLabel1.setBounds(new Rectangle(412, 53, 276, 33));
    headingLabel1.setText("PRINTING REPORT");
    headingLabel1.setFont(new java.awt.Font("Dialog", 1, 30));
    termsConditionsCustomerLabel.setForeground(Color.black);
    termsConditionsCustomerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    termsConditionsCustomerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    termsConditionsCustomerLabel.setToolTipText("");
    termsConditionsCustomerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    termsConditionsCustomerLabel.setText("TERMS/ CONDITIONS");
    termsConditionsCustomerLabel.setBounds(new Rectangle(638, 254, 121, 30));
    termsConditionsCustomerComboBox.setBounds(new Rectangle(761, 254, 87, 30));
    termsConditionsCustomerComboBox.setFont(new java.awt.Font("Dialog", 1, 12));

    dateFromCustomerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    dateFromCustomerLabel.setToolTipText("");
    dateFromCustomerLabel.setHorizontalAlignment(SwingConstants.LEFT);
    dateFromCustomerLabel.setHorizontalTextPosition(SwingConstants.LEFT);
    dateFromCustomerLabel.setText("DD-MMM-YYYY");
    dateFromCustomerLabel.setBounds(new Rectangle(379, 233, 87, 30));
    dateFromCustomerLabel.setForeground(Color.black);
    toCustomerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    toCustomerLabel.setToolTipText("");
    toCustomerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    toCustomerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    toCustomerLabel.setText("TO");
    toCustomerLabel.setBounds(new Rectangle(466, 254, 21, 30));
    toCustomerLabel.setForeground(Color.black);
    dateToCustomerLabel.setForeground(Color.black);
    dateToCustomerLabel.setBounds(new Rectangle(494, 233, 87, 30));
    dateToCustomerLabel.setText("DD-MMM-YYYY");
    dateToCustomerLabel.setHorizontalTextPosition(SwingConstants.LEFT);
    dateToCustomerLabel.setHorizontalAlignment(SwingConstants.LEFT);
    dateToCustomerLabel.setToolTipText("");
    dateToCustomerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    dateToCustomerTextField.setBorder(border);
    dateToCustomerTextField.setBounds(new Rectangle(493, 254, 83, 30));
    dateToCustomerTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    yearCustomerComboBox.setBorder(border);
    yearCustomerComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    yearCustomerComboBox.setBounds(new Rectangle(378, 167, 87, 30));
    yearCustomerComboBox.setKeySelectionManager(new MyKeySelectionManager());
    yearCustomerLabel.setBounds(new Rectangle(256, 167, 121, 30));
    yearCustomerLabel.setText("CASH REG. YEAR");
    yearCustomerLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    yearCustomerLabel.setToolTipText("");
    yearCustomerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    yearCustomerLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    yearCustomerLabel.setForeground(Color.black);
    customerPanel.setBackground(Color.white);
    customerPanel.setBounds(new Rectangle(240, 148, 619, 148));

    indvCustomerButton.setToolTipText("");
    indvCustomerButton.setText("INDV. CUSTOMER");
    indvCustomerButton.setHorizontalAlignment(SwingConstants.RIGHT);
    indvCustomerButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    indvCustomerButton.setFont(new java.awt.Font("Dialog", 1, 12));
    indvCustomerButton.setBackground(Color.white);
    indvCustomerButton.setBounds(new Rectangle(535, 297, 157, 57));
    allCustomerButton.setBounds(new Rectangle(699, 297, 149, 57));
    allCustomerButton.setBackground(Color.white);
    allCustomerButton.setFont(new java.awt.Font("Dialog", 1, 12));
    allCustomerButton.setHorizontalAlignment(SwingConstants.RIGHT);
    allCustomerButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    allCustomerButton.setText("ALL CUSTOMER");
    allCustomerButton.setBorder(border);
    productPanel.setBounds(new Rectangle(240, 361, 619, 204));
    productPanel.setBorder(titledBorder2);
    productPanel.setBackground(Color.white);
    allProductButton.setBorder(border);
    allProductButton.setText("ALL PRODUCT");
    allProductButton.setHorizontalAlignment(SwingConstants.RIGHT);
    allProductButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    allProductButton.setFont(new java.awt.Font("Dialog", 1, 12));
    allProductButton.setBackground(Color.white);
    allProductButton.setBounds(new Rectangle(708, 500, 141, 57));
    indvProductButton.setBounds(new Rectangle(401, 500, 148, 57));
    indvProductButton.setBackground(Color.white);
    indvProductButton.setFont(new java.awt.Font("Dialog", 1, 12));
    indvProductButton.setHorizontalAlignment(SwingConstants.RIGHT);
    indvProductButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    indvProductButton.setText("INDV. PRODUCT");
    indvProductButton.setToolTipText("");
    indvProductButton.setBorder(border);

    termsConditionsProductComboBox.setBorder(border);
    termsConditionsProductComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    termsConditionsProductComboBox.setBounds(new Rectangle(762, 379, 87, 30));

    termsConditionsProductComboBox.setKeySelectionManager(new MyKeySelectionManager());
    yearProductComboBox.setKeySelectionManager(new MyKeySelectionManager());

    yearProductComboBox.setBounds(new Rectangle(346, 379, 73, 30));
    yearProductComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    yearProductComboBox.setBorder(border);
    dateToProductTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    dateToProductTextField.setBounds(new Rectangle(447, 464, 83, 30));
    dateToProductTextField.setBorder(border);
    dateToProductLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    dateToProductLabel.setToolTipText("");
    dateToProductLabel.setHorizontalAlignment(SwingConstants.LEFT);
    dateToProductLabel.setHorizontalTextPosition(SwingConstants.LEFT);
    dateToProductLabel.setText("DD-MMM-YYYY");
    dateToProductLabel.setBounds(new Rectangle(448, 443, 87, 30));
    dateToProductLabel.setForeground(Color.black);
    toProductLabel.setForeground(Color.black);
    toProductLabel.setBounds(new Rectangle(425, 464, 21, 30));
    toProductLabel.setText("TO");
    toProductLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    toProductLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    toProductLabel.setToolTipText("");
    toProductLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    dateFromProductLabel.setForeground(Color.black);
    dateFromProductLabel.setBounds(new Rectangle(346, 443, 87, 30));
    dateFromProductLabel.setText("DD-MMM-YYYY");
    dateFromProductLabel.setHorizontalTextPosition(SwingConstants.LEFT);
    dateFromProductLabel.setHorizontalAlignment(SwingConstants.LEFT);
    dateFromProductLabel.setToolTipText("");
    dateFromProductLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    termsConditionsProductLabel.setBounds(new Rectangle(638, 379, 121, 30));
    termsConditionsProductLabel.setText("TERMS/ CONDITIONS");
    termsConditionsProductLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    termsConditionsProductLabel.setToolTipText("");
    termsConditionsProductLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    termsConditionsProductLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    termsConditionsProductLabel.setForeground(Color.black);
    productLabel.setForeground(Color.black);
    productLabel.setBounds(new Rectangle(271, 412, 74, 30));
    productLabel.setText("PRODUCT");
    productLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    productLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    productLabel.setToolTipText("");
    productLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    yearProductLabel.setForeground(Color.black);
    yearProductLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    yearProductLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    yearProductLabel.setToolTipText("");
    yearProductLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    yearProductLabel.setText("CASH REG. YEAR");
    yearProductLabel.setBounds(new Rectangle(248, 379, 97, 30));
    dateFromProductTextField.setBorder(border);
    dateFromProductTextField.setBounds(new Rectangle(346, 464, 83, 30));
    dateFromProductTextField.setFont(new java.awt.Font("Dialog", 1, 12));
    productComboBox.setBounds(new Rectangle(346, 412, 503, 30));
    transactionTypeComboBox.setBorder(border);
    transactionTypeComboBox.setFont(new java.awt.Font("Dialog", 1, 12));
    transactionTypeComboBox.setBounds(new Rectangle(511, 379, 113, 30));

    transactionTypeComboBox.setKeySelectionManager(new MyKeySelectionManager());
    transactionTypeLabel.setBounds(new Rectangle(426, 379, 82, 30));
    transactionTypeLabel.setText("TRANS. TYPE");
    transactionTypeLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    transactionTypeLabel.setToolTipText("");
    transactionTypeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    transactionTypeLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    transactionTypeLabel.setForeground(Color.black);
    indvCustomerProductButton.addActionListener(this);
    indvCustomerProductButton.setBorder(border);
    indvCustomerProductButton.setBounds(new Rectangle(247, 500, 152, 57));
    indvCustomerProductButton.setBackground(Color.white);
    indvCustomerProductButton.setFont(new java.awt.Font("Dialog", 1, 12));
    indvCustomerProductButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    indvCustomerProductButton.setHorizontalAlignment(SwingConstants.RIGHT);
    indvCustomerProductButton.setText("INDV. CUSTOMER");
    indvCustomerProductButton.setToolTipText("");
    allCustomerProductButton.addActionListener(this);
    allCustomerProductButton.setBorder(border);
    allCustomerProductButton.setText("ALL CUSTOMER");
    allCustomerProductButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    allCustomerProductButton.setHorizontalAlignment(SwingConstants.RIGHT);
    allCustomerProductButton.setFont(new java.awt.Font("Dialog", 1, 12));
    allCustomerProductButton.setBackground(Color.white);
    allCustomerProductButton.setBounds(new Rectangle(552, 500, 153, 57));
    customerProductLabel.setForeground(Color.black);
    customerProductLabel.setBounds(new Rectangle(529, 442, 74, 30));
    customerProductLabel.setText("CUSTOMER");
    customerProductLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
    customerProductLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    customerProductLabel.setToolTipText("");
    customerProductLabel.setFont(new java.awt.Font("Dialog", 1, 12));
    customerProductComboBox.setBounds(new Rectangle(537, 464, 312, 30));
    cashReportButton.addActionListener(this);
    cashReportButton.setBorder(border);
    cashReportButton.setBounds(new Rectangle(286, 297, 242, 57));
    cashReportButton.setBackground(Color.white);
    cashReportButton.setFont(new java.awt.Font("Dialog", 1, 12));
    cashReportButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    cashReportButton.setHorizontalAlignment(SwingConstants.RIGHT);
    cashReportButton.setText("INDV. CUSTOMER CASH REPORT");
    cashReportButton.setToolTipText("");


    this.getContentPane().setBackground(Color.white);

    headingLabel.setForeground(Color.black);
    customerLabel.setForeground(Color.black);

    indvCustomerButton.setBorder(border);
    termsConditionsCustomerComboBox.setBorder(border);
    dateFromCustomerTextField.setBorder(border);
    customerComboBox.setBorder(border);
    productComboBox.setBorder(border);
    backButton.setBorder(border);
    customerProductComboBox.setBorder(border);

    termsConditionsProductComboBox.addItem("BOTH");
    termsConditionsProductComboBox.addItem("CREDIT");
    termsConditionsProductComboBox.addItem("CASH");

    termsConditionsCustomerComboBox.addItem("BOTH");
    termsConditionsCustomerComboBox.addItem("CREDIT");
    termsConditionsCustomerComboBox.addItem("DEBIT");

    transactionTypeComboBox.addItem("BOTH");
    transactionTypeComboBox.addItem("PURCHASE");
    transactionTypeComboBox.addItem("SALE");

    indvCustomerButton.addActionListener(this);
    allCustomerButton.addActionListener(this);
    indvProductButton.addActionListener(this);
    allProductButton.addActionListener(this);
    backButton.addActionListener(this);

    indvProductIndvCustomerButton.addActionListener(this);
    indvProductIndvCustomerButton.setBorder(border);
    indvProductIndvCustomerButton.setToolTipText("");
    indvProductIndvCustomerButton.setText("INDV. PRODUCT & INDV. CUSTOMER");
    indvProductIndvCustomerButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    indvProductIndvCustomerButton.setHorizontalAlignment(SwingConstants.RIGHT);
    indvProductIndvCustomerButton.setFont(new java.awt.Font("Dialog", 1, 12));
    indvProductIndvCustomerButton.setBackground(Color.white);
    indvProductIndvCustomerButton.setBounds(new Rectangle(247, 570, 301, 57));
    this.getContentPane().add(termsConditionsProductComboBox, null);
    this.getContentPane().add(yearProductComboBox, null);
    this.getContentPane().add(dateToProductTextField, null);
    this.getContentPane().add(dateToProductLabel, null);
    this.getContentPane().add(toProductLabel, null);
    this.getContentPane().add(dateFromProductLabel, null);
    this.getContentPane().add(termsConditionsProductLabel, null);
    this.getContentPane().add(productLabel, null);
    this.getContentPane().add(yearProductLabel, null);
    this.getContentPane().add(dateFromProductTextField, null);
    this.getContentPane().add(productComboBox, null);
    this.getContentPane().add(transactionTypeLabel, null);
    this.getContentPane().add(transactionTypeComboBox, null);
    this.getContentPane().add(yearProductComboBox, null);
    this.getContentPane().add(yearProductLabel, null);
    this.getContentPane().add(productComboBox, null);
    this.getContentPane().add(dateFromProductTextField, null);
    this.getContentPane().add(dateFromProductLabel, null);
    this.getContentPane().add(productLabel, null);
    this.getContentPane().add(termsConditionsProductComboBox, null);
    this.getContentPane().add(termsConditionsProductLabel, null);
    this.getContentPane().add(transactionTypeComboBox, null);
    this.getContentPane().add(transactionTypeLabel, null);
    this.getContentPane().add(toProductLabel, null);
    this.getContentPane().add(dateToProductTextField, null);
    this.getContentPane().add(dateToProductLabel, null);
    this.getContentPane().add(yearCustomerComboBox, null);
    this.getContentPane().add(dateFromCustomerTextField, null);
    this.getContentPane().add(dateToCustomerTextField, null);
    this.getContentPane().add(toCustomerLabel, null);
    this.getContentPane().add(termsConditionsCustomerComboBox, null);
    this.getContentPane().add(yearCustomerLabel, null);
    this.getContentPane().add(customerComboBox, null);
    this.getContentPane().add(customerLabel, null);
    this.getContentPane().add(termsConditionsCustomerLabel, null);
    this.getContentPane().add(dateToCustomerLabel, null);
    this.getContentPane().add(dateFromCustomerLabel, null);
    this.getContentPane().add(allCustomerButton, null);
    this.getContentPane().add(allProductButton, null);
    this.getContentPane().add(backButton, null);
    this.getContentPane().add(indvCustomerButton, null);
    this.getContentPane().add(customerPanel, null);
    this.getContentPane().add(indvCustomerProductButton, null);
    this.getContentPane().add(customerProductComboBox, null);
    this.getContentPane().add(customerProductLabel, null);
    this.getContentPane().add(allCustomerProductButton, null);
    this.getContentPane().add(indvProductButton, null);
    this.getContentPane().add(productPanel, null);
    this.getContentPane().add(cashReportButton, null);
    this.getContentPane().add(headingLabel1, null);
    this.getContentPane().add(headingLabel, null);
    this.getContentPane().add(indvProductIndvCustomerButton, null);

    Toolkit kit=this.getToolkit();
    Dimension d=kit.getScreenSize();
    this.setBounds(0,0,d.width,d.height);
//    this.refresh();
 }//end constructor

 public void actionPerformed(ActionEvent e){
  if(e.getSource()== backButton)hide();
  if(e.getSource()== indvCustomerButton)indvCustomer();
  if(e.getSource()== allCustomerButton)allCustomer();
  if(e.getSource()== cashReportButton)cashReport();
  if(e.getSource()== indvProductButton)indvProduct(true,false);
  if(e.getSource()== indvProductIndvCustomerButton)indvProduct(true,true);
  if(e.getSource()== indvCustomerProductButton)indvProduct(false,false);
  if(e.getSource()== allProductButton)allProduct(true);
  if(e.getSource()== allCustomerProductButton)allProduct(false);
 }//end method

private void cashReport(){
 try{
   CustomerRecord customerRec=(CustomerRecord)customerComboBox.getSelectedItem();
   CashRegisterRecord cashRegisterRec=(CashRegisterRecord)yearCustomerComboBox.getSelectedItem();
   String debit_credit=(String)termsConditionsCustomerComboBox.getSelectedItem();

   String dateFrom=dateFromCustomerTextField.getText().trim();
   String dateTo=dateToCustomerTextField.getText().trim();

   String customerName=customerRec.name;

   debit_credit=Encode.termsConditionsEncode(debit_credit);

   java.util.Vector v=DatabaseManager.getCashTrans(dateFrom,dateTo,debit_credit,customerRec.customer_id,cashRegisterRec.cash_reg_id);

   PrinterJob printJob = PrinterJob.getPrinterJob ();
   Book book = new Book ();
   Paper paper=new Paper();
   PageFormat pageFormat = getPageFormate(paper);

    boolean IS_LAST_PAGE=false;

    int transactionPerReport=30;

    int totalPapers=v.size()/transactionPerReport;
    int lastPaper=v.size()%transactionPerReport;

    int TOTAL_PAGE=totalPapers;
    if(lastPaper!=0)TOTAL_PAGE++;

      int index=-1;
      int sno=0;

      int pageNo=1;

      int credit=0;
      int debit=0;

      if(totalPapers>0)
        for(int i=1; i<=totalPapers; i++,pageNo++){
          TransactionRecord transactions[]=new TransactionRecord[transactionPerReport];
          for(int j=0; j<transactionPerReport; j++){
              transactions[j]=(TransactionRecord)v.elementAt(++index);
              transactions[j].sno=""+(++sno);

              if(transactions[j].debit_credit.startsWith("C")) credit+=Integer.parseInt(transactions[j].amount);
              if(transactions[j].debit_credit.startsWith("D")) debit+=Integer.parseInt(transactions[j].amount);
          }

          if(i==totalPapers && lastPaper==0)IS_LAST_PAGE=true;

          book.append (new ReportCashTransactionDocument(transactions,pageNo,IS_LAST_PAGE, TOTAL_PAGE,credit,debit,dateFrom,dateTo,customerName), pageFormat);
       }//end for loop

    if(lastPaper>0){
         TransactionRecord transactions[]=new TransactionRecord[lastPaper];
         IS_LAST_PAGE=true;
         for(int j=0; j<lastPaper; j++){
              transactions[j]=(TransactionRecord)v.elementAt(++index);
              transactions[j].sno=""+(++sno);

              if(transactions[j].debit_credit.startsWith("C")) credit+=Integer.parseInt(transactions[j].amount);
              if(transactions[j].debit_credit.startsWith("D")) debit+=Integer.parseInt(transactions[j].amount);
         }//end for


         book.append (new ReportCashTransactionDocument(transactions,pageNo,IS_LAST_PAGE,TOTAL_PAGE,credit,debit,dateFrom,dateTo,customerName), pageFormat);
    }//end if

   printJob.setPageable (book);
   if (printJob.printDialog()) printJob.print();

  }catch(Exception e){
    e.printStackTrace();
  }

}//end method



 public static void cashReportPrint(Object creditObj[],Object debitObj[],String creditAmountStr,String debitAmountStr, String balanceStr, String cashInHandStr, String dateFrom, String dateTo,String HEADING2)throws Exception{
   CashBookRecord rec[]=merge(creditObj,debitObj);
   Book book = new Book();

   Paper paper=new Paper();
   PageFormat pageFormat = getPageFormate(paper);

   boolean IS_LAST_PAGE=false;
   int size=rec.length;

   int transactionPerReport=38;
   int totalPapers=size/transactionPerReport;
   int lastPaper=size%transactionPerReport;

   int TOTAL_PAGE=totalPapers;
   if(lastPaper!=0)TOTAL_PAGE++;

    int index=-1;
    int sno=0;
    int pageNo=0;
    pageNo++;

    if(totalPapers>0)
            for(int i=1; i<=totalPapers; i++,pageNo++){
               CashBookRecord transactions[]=new CashBookRecord[transactionPerReport];
               for(int j=0; j<transactionPerReport; j++){
                   transactions[j]=(CashBookRecord)rec[++index];
                   transactions[j].sno=""+(++sno);
               }//end for loop

               if(i==totalPapers && lastPaper==0)IS_LAST_PAGE=true;
               book.append (new ReportCashDocument(transactions,pageNo,IS_LAST_PAGE,creditAmountStr,debitAmountStr,balanceStr,cashInHandStr,dateFrom,dateTo,HEADING2,TOTAL_PAGE), pageFormat);
            }//end for loop

    if(lastPaper>0){
           CashBookRecord transactions[]=new CashBookRecord[lastPaper];
           IS_LAST_PAGE=true;
           for(int j=0; j<lastPaper; j++){
                transactions[j]=(CashBookRecord)rec[++index];
                transactions[j].sno=""+(++sno);
           }//end for

           book.append (new ReportCashDocument(transactions,pageNo,IS_LAST_PAGE,creditAmountStr,debitAmountStr,balanceStr,cashInHandStr,dateFrom,dateTo,HEADING2,TOTAL_PAGE), pageFormat);
    }//end if

   PrinterJob printJob = PrinterJob.getPrinterJob ();
   printJob.setPageable (book);
   if (printJob.printDialog()) printJob.print();
}//end mthod


  private void allCustomer(){
  try{
    PrinterJob printJob = PrinterJob.getPrinterJob ();
    Book book = new Book ();

    String dateFrom=dateFromCustomerTextField.getText().trim();
    String dateTo=dateToCustomerTextField.getText().trim();

    if( (!dateFrom.equals("") && !Decode.isDate(dateFrom)) ||  (!dateTo.equals("") && !Decode.isDate(dateTo))  ){
     JOptionPane.showMessageDialog(this,"Enter Correct Date Format [DD-MMM-YYYY]");
     return;
    }

    pageNo=0;
    boolean isPrint=false;

    java.util.Vector v=DatabaseManager.getCustomers();
    for(int i=0; i<v.size(); i++){
      CustomerRecord customerRec=(CustomerRecord)v.elementAt(i);
      boolean b=getCustomerTransactions(book, customerRec,dateFrom,dateTo);
      if(!isPrint)isPrint=b;
    }//end for loop

  if(isPrint){
   printJob.setPageable (book);
   if (printJob.printDialog()) printJob.print();
   }else
      JOptionPane.showMessageDialog(this,"Record does not found.....");
  }catch(Exception e){
    e.printStackTrace();
  }
 }//end method


 private void indvCustomer(){
 try{
   PrinterJob printJob = PrinterJob.getPrinterJob ();
   Book book = new Book ();

   String dateFrom=dateFromCustomerTextField.getText().trim();
   String dateTo=dateToCustomerTextField.getText().trim();

   if( (!dateFrom.equals("") && !Decode.isDate(dateFrom)) ||  (!dateTo.equals("") && !Decode.isDate(dateTo))  ){
     JOptionPane.showMessageDialog(this,"Enter Correct Date Format [DD-MMM-YYYY]");
     return;
   }

   pageNo=0;
   boolean isPrint;

   CustomerRecord customerRec=(CustomerRecord)customerComboBox.getSelectedItem();
//   CustomerRecord customerRec=(CustomerRecord)customerProductComboBox.getSelectedItem();

   isPrint=getCustomerTransactions(book, customerRec,dateFrom,dateTo);
   if(isPrint){
      printJob.setPageable (book);
      if (printJob.printDialog()) printJob.print();
   }else
      JOptionPane.showMessageDialog(this,"Customer: "+customerRec.name+"\n\nRecord does not found.....");
  }catch(Exception e){
    e.printStackTrace();
  }
 }//end method


 private boolean getCustomerTransactions(Book book, CustomerRecord customerRec,String dateFrom,String dateTo){
   CashRegisterRecord cashRegisterRec=(CashRegisterRecord)yearCustomerComboBox.getSelectedItem();
   String debit_credit=(String)termsConditionsCustomerComboBox.getSelectedItem();

   if(customerRec==null) return false;
   if(cashRegisterRec==null)return false;
   if(debit_credit==null)return false;

   debit_credit=Encode.termsConditionsEncode(debit_credit);
   try{
      CustomerTransactionRecord customerTransRec=DatabaseManager.getCustomerTransactions(customerRec.customer_id,cashRegisterRec.cash_reg_id,dateFrom,dateTo,debit_credit,cashRegisterRec.year,"");
      if(customerTransRec==null){
         System.out.println("Customer: "+customerRec.name+"\n\nRecord does not found.....");
         return false;
      }

      customerTransRec.customer_name=customerRec.name;
      customerTransRec.dateFrom=dateFrom;
      customerTransRec.dateTo=dateTo;

      return printCustomerTransactions(book,customerTransRec);
 }catch(Exception e){
   e.printStackTrace();
 }
 return false;
 }//end method

 private boolean printCustomerTransactions(Book book, CustomerTransactionRecord customerTransRec){
  boolean IS_LAST_PAGE=false;
  try{
      java.util.Vector v=customerTransRec.getTransactions();

      Paper paper=new Paper();
      PageFormat pageFormat = getPageFormate(paper);

      int transactionPerReport=30;

      int totalPapers=v.size()/transactionPerReport;
      int lastPaper=v.size()%transactionPerReport;

      int TOTAL_PAGE=totalPapers;
      if(lastPaper!=0)TOTAL_PAGE++;

      int index=-1;
      int sno=0;
      pageNo++;

      if(totalPapers>0)
        for(int i=1; i<=totalPapers; i++,pageNo++){
          TransactionRecord transactions[]=new TransactionRecord[transactionPerReport];
          for(int j=0; j<transactionPerReport; j++){
              transactions[j]=(TransactionRecord)v.elementAt(++index);
              transactions[j].sno=""+(++sno);
          }

          if(i==totalPapers && lastPaper==0)IS_LAST_PAGE=true;
          book.append (new ReportCustomerDocument(transactions,customerTransRec,pageNo,IS_LAST_PAGE, TOTAL_PAGE), pageFormat);
       }//end for loop

    if(lastPaper>0){
         TransactionRecord transactions[]=new TransactionRecord[lastPaper];
         IS_LAST_PAGE=true;
         for(int j=0; j<lastPaper; j++){
              transactions[j]=(TransactionRecord)v.elementAt(++index);
              transactions[j].sno=""+(++sno);
         }//end for

         book.append (new ReportCustomerDocument(transactions,customerTransRec,pageNo,IS_LAST_PAGE,TOTAL_PAGE), pageFormat);
    }//end if
  }catch(Exception e){
    e.printStackTrace();
  }
 return IS_LAST_PAGE;
 }//end method



 //**********************************************************

 private void allProduct(boolean IS_PRODUCT_WISE){
  try{
    PrinterJob printJob = PrinterJob.getPrinterJob ();
    Book book = new Book ();

   String dateFrom=dateFromProductTextField.getText().trim();
   String dateTo=dateToProductTextField.getText().trim();

   if( (!dateFrom.equals("") && !Decode.isDate(dateFrom)) ||  (!dateTo.equals("") && !Decode.isDate(dateTo))  ){
     JOptionPane.showMessageDialog(this,"Enter Correct Date Format [DD-MMM-YYYY]");
     return;
   }


    pageNo=0;
    java.util.Vector v=null;
    boolean isPrint=false;

    if(IS_PRODUCT_WISE){
       v=DatabaseManager.getProduct();

       for(int i=0; i<v.size(); i++){
         ProductRecord productRec=(ProductRecord)v.elementAt(i);
         boolean b=getProductTransactions(book, productRec,null,dateFrom,dateTo,IS_PRODUCT_WISE,false);
         if(!isPrint)isPrint=b;
       }//end for loop
     }else{
       v=DatabaseManager.getCustomers();

       for(int i=0; i<v.size(); i++){
         CustomerRecord customerRec=(CustomerRecord)v.elementAt(i);
         boolean b=getProductTransactions(book, null,customerRec,dateFrom,dateTo,IS_PRODUCT_WISE,false);
         if(!isPrint)isPrint=b;
       }//end for loop
     }//end if



   if(isPrint){
      printJob.setPageable (book);
      if (printJob.printDialog()) printJob.print();
   }else
      JOptionPane.showMessageDialog(this,"Record does not found.....");

  }catch(Exception e){
    e.printStackTrace();
  }
 }//end method

private void indvProduct(boolean IS_PRODUCT_WISE,boolean isBoth){
 try{
   PrinterJob printJob = PrinterJob.getPrinterJob ();
   Book book = new Book ();
   pageNo=0;

   String dateFrom=dateFromProductTextField.getText().trim();
   String dateTo=dateToProductTextField.getText().trim();

   if( (!dateFrom.equals("") && !Decode.isDate(dateFrom)) ||  (!dateTo.equals("") && !Decode.isDate(dateTo))  ){
     JOptionPane.showMessageDialog(this,"Enter Correct Date Format [DD-MMM-YYYY]");
     return;
   }

   boolean isPrint;

   if(isBoth){
        ProductRecord productRec=(ProductRecord)productComboBox.getSelectedItem();
        CustomerRecord customerRec=(CustomerRecord)customerProductComboBox.getSelectedItem();

        if(productRec==null)return;
        if(customerRec==null)return;

        isPrint=getProductTransactions(book,productRec,customerRec,dateFrom,dateTo, IS_PRODUCT_WISE,isBoth);
   }else
   if(IS_PRODUCT_WISE){
        ProductRecord productRec=(ProductRecord)productComboBox.getSelectedItem();
        if(productRec==null)return;
        isPrint=getProductTransactions(book, productRec,null,dateFrom,dateTo,IS_PRODUCT_WISE,isBoth);
    }else{
        CustomerRecord customerRec=(CustomerRecord)customerProductComboBox.getSelectedItem();
        if(customerRec==null)return;
        isPrint=getProductTransactions(book,null,customerRec,dateFrom,dateTo, IS_PRODUCT_WISE,isBoth);
    }

   if(isPrint){
      printJob.setPageable (book);
      if (printJob.printDialog()) printJob.print();
   }else
      JOptionPane.showMessageDialog(this,"Record does not found.....");
  }catch(Exception e){
    e.printStackTrace();
  }
 }//end method


 private boolean getProductTransactions(Book book, ProductRecord productRec,CustomerRecord customerRec,String dateFrom,String dateTo,boolean IS_PRODUCT_WISE,boolean isBoth){
   CashRegisterRecord cashRegisterRec=(CashRegisterRecord)yearProductComboBox.getSelectedItem();
   String transactionType=(String)transactionTypeComboBox.getSelectedItem();
   String termsConditions=(String)termsConditionsProductComboBox.getSelectedItem();

   if(cashRegisterRec==null)return false;
   if(transactionType==null)return false;
   if(termsConditions==null)return false;

   transactionType=Encode.transactionTypeEncode(transactionType);
   try{
      ProductTransactionRecord productTransRec=DatabaseManager.getProductTransactions(cashRegisterRec.cash_reg_id,productRec,customerRec,transactionType,dateFrom,dateTo,termsConditions,IS_PRODUCT_WISE,isBoth);
      if(productTransRec==null){
         if(IS_PRODUCT_WISE)
         System.out.println("Product: "+productRec.name +"\n\nRecord does not found.....");
         else
              System.out.println("Customer: "+customerRec.name +"\n\nRecord does not found.....");

         return false;
      }


     if(isBoth){
       productTransRec.product_name=productRec.name;
       productTransRec.customer_name=customerRec.name;
     }else
     if(IS_PRODUCT_WISE)
         productTransRec.product_name=productRec.name;
     else
         productTransRec.customer_name=customerRec.name;


      productTransRec.dateFrom=dateFrom;
      productTransRec.dateTo=dateTo;

      return printProductTransactions(book,productTransRec,IS_PRODUCT_WISE,isBoth,dateFrom,dateTo);
   }catch(Exception e){
     e.printStackTrace();
   }
   return false;
 }//end method

 private boolean printProductTransactions(Book book,ProductTransactionRecord productTransRec,boolean IS_PRODUCT_WISE,boolean isBoth,String dateFrom,String dateTo){
      boolean IS_LAST_PAGE=false;
 try{
      java.util.Vector v=productTransRec.getProductTransactions();

      Paper paper=new Paper();
      PageFormat pageFormat = getPageFormate(paper);

      int productPerReport=34;
      int totalPapers=v.size()/productPerReport;
      int lastPaper=v.size()%productPerReport;

      int TOTAL_PAGE=totalPapers;
      if(lastPaper!=0)TOTAL_PAGE++;

      int index=-1;
      int sno=0;
      pageNo++;

      int purchaseAmount=0;
      double purchaseQuantity=0;

      int saleAmount=0;
      double saleQuantity=0;

      int previousAmount=0;
      double previousQuantity=0;

      if(IS_PRODUCT_WISE && !dateFrom.trim().equals("")){
         Object obj[]= getPreAmountAndQuantity(IS_PRODUCT_WISE,isBoth,dateFrom);
         if(obj!=null){
            previousAmount=((Integer)obj[0]).intValue();
            previousQuantity=((Double)obj[1]).doubleValue();
         }
      }

      if(totalPapers>0)
        for(int i=1; i<=totalPapers;i++, pageNo++){

          PurchaseSaleBookRecord purchaseSaleBookRec[]=new PurchaseSaleBookRecord[productPerReport];
          for(int j=0; j<productPerReport; j++){
              purchaseSaleBookRec[j]=(PurchaseSaleBookRecord)v.elementAt(++index);
              purchaseSaleBookRec[j].sno=""+(++sno);

              if(purchaseSaleBookRec[j].trans_type.startsWith("S")){
                   saleAmount+=Integer.parseInt(purchaseSaleBookRec[j].total_amount);
                   saleQuantity+=Double.parseDouble(purchaseSaleBookRec[j].quantity_kg_bag);
              }else{
                   purchaseAmount+=Integer.parseInt(purchaseSaleBookRec[j].total_amount);
                   purchaseQuantity+=Double.parseDouble(purchaseSaleBookRec[j].quantity_kg_bag);
              }
          }

          if(i==totalPapers && lastPaper==0)IS_LAST_PAGE=true;
          book.append (new ReportProductDocument(purchaseSaleBookRec,productTransRec,pageNo,IS_LAST_PAGE,IS_PRODUCT_WISE,TOTAL_PAGE,purchaseAmount,purchaseQuantity,saleAmount,saleQuantity,isBoth,previousAmount,previousQuantity), pageFormat);
       }//end for loop


    if(lastPaper>0){
         PurchaseSaleBookRecord purchaseSaleBookRec[]=new PurchaseSaleBookRecord[lastPaper];
         IS_LAST_PAGE=true;
         for(int j=0; j<lastPaper; j++){
              purchaseSaleBookRec[j]=(PurchaseSaleBookRecord)v.elementAt(++index);
              purchaseSaleBookRec[j].sno=""+(++sno);

              if(purchaseSaleBookRec[j].trans_type.startsWith("S")){
                   saleAmount+=Integer.parseInt(purchaseSaleBookRec[j].total_amount);
                   saleQuantity+=Double.parseDouble(purchaseSaleBookRec[j].quantity_kg_bag);
              }else{
                   purchaseAmount+=Integer.parseInt(purchaseSaleBookRec[j].total_amount);
                   purchaseQuantity+=Double.parseDouble(purchaseSaleBookRec[j].quantity_kg_bag);
              }
         }//end for

         book.append (new ReportProductDocument(purchaseSaleBookRec,productTransRec,pageNo,IS_LAST_PAGE,IS_PRODUCT_WISE,TOTAL_PAGE,purchaseAmount,purchaseQuantity,saleAmount,saleQuantity,isBoth,previousAmount,previousQuantity), pageFormat);
    }//end if
  }catch(Exception e){
    e.printStackTrace();
  }
 return IS_LAST_PAGE;
 }//end method




  protected static PageFormat getPageFormate(Paper paper){

     PageFormat pageFormat = new PageFormat ();
     paper.setSize(PageSetupInterface.PAPER_WIDTH,
                   PageSetupInterface.PAPER_HEIGHT);

     paper.setImageableArea(PageSetupInterface.LEFT_MARGIN,
                            PageSetupInterface.TOP_MARGIN,
                            paper.getWidth() -(PageSetupInterface.LEFT_MARGIN + PageSetupInterface.RIGHT_MARGIN),
                            paper.getHeight()-(PageSetupInterface.TOP_MARGIN + PageSetupInterface.BOTTOM_MARGIN));

     pageFormat.setPaper(paper);
     pageFormat.setOrientation ( PageSetupInterface.LANDSCAPE ? PageFormat.LANDSCAPE : PageFormat.PORTRAIT);

  return pageFormat;
 }///////end getPageFormate()



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
   customerProductComboBox.removeAllItems();

   for(int index=0; index<v.size(); index++){
     customerComboBox.addItem(v.elementAt(index));
     customerProductComboBox.addItem(v.elementAt(index));
   }//end for loop

 }catch(Exception e){
  JOptionPane.showMessageDialog(this,"Database Driver check ODBC ["+e.getMessage()+"]");
  e.printStackTrace();
 }
}//end method

 private void getCashRegister(){
 try{
   java.util.Vector v=DatabaseManager.getCashRegisters();
   yearProductComboBox.removeAllItems();
   yearCustomerComboBox.removeAllItems();

   for(int index=0; index<v.size(); index++){
     yearProductComboBox.addItem(v.elementAt(index));
     yearCustomerComboBox.addItem(v.elementAt(index));
   }
 }catch(Exception e){
    JOptionPane.showMessageDialog(this,"Database Driver check ODBC ["+e.getMessage()+"]");
    e.printStackTrace();
 }
}//end method



 public void show(){
   refresh();
   super.show();
 }///end method

  private static int getAmount(Object obj[]){
    int amount=0;
    for(int i=0; i<obj.length; i++){
      ListItem rec=(ListItem)obj[i];
      amount+=Integer.parseInt(rec.AMOUNT);
    }//end for loop
    return amount;
  }//end method


    private static int getSize(Object creditObj[],Object debitObj[],String sign){

        if(sign.equals("G"))
           return  creditObj.length>=debitObj.length?creditObj.length:debitObj.length;
        else
           return  creditObj.length<=debitObj.length?creditObj.length:debitObj.length;
    }

  private static CashBookRecord[] merge(Object creditObj[], Object debitObj[]){
    int size= getSize(creditObj,debitObj,"G");
    CashBookRecord cashBookRec[]=new CashBookRecord[size];

    for(int i=0; i<size; i++){
        ListItem creditItem=null;
        ListItem debitItem=null;
        try{
         creditItem=(ListItem)creditObj[i];
        }catch(ClassCastException e){
         CustomerTransactionRecord rec=(CustomerTransactionRecord)creditObj[i];
         creditItem=new ListItem();
         creditItem. CUSTOMER_NAME=rec.customer_name;
         creditItem. AMOUNT= rec.isProduct? rec.amount: String.valueOf(rec.getBalance());
        }catch(Exception e){}

        try{
         debitItem=(ListItem)debitObj[i];
        }catch(ClassCastException e){
         CustomerTransactionRecord rec=(CustomerTransactionRecord)debitObj[i];
	 debitItem=new ListItem();
         debitItem. CUSTOMER_NAME=rec.customer_name;
         debitItem. AMOUNT= rec.isProduct? rec.amount: String.valueOf(rec.getBalance());
        }catch(Exception e){}

        cashBookRec[i]=new CashBookRecord(creditItem,debitItem);
    }//end for loop

  return cashBookRec;
 }//end method

  private void refresh(){
   getCustomers();
   getProduct();
   getCashRegister();
  }//////////// method



  public static void printProductStock(){
   try{
      java.util.Vector v=DatabaseManager.getProduct();

      Book book=new Book();

      Paper paper=new Paper();
      PageFormat pageFormat = getPageFormate(paper);

      int productPerReport=36;
      int totalPapers=v.size()/productPerReport;
      int lastPaper=v.size()%productPerReport;

      int TOTAL_PAGE=totalPapers;
      if(lastPaper!=0)TOTAL_PAGE++;

      int index=-1;
      int sno=0;
      int pageNo=0;
      boolean IS_LAST_PAGE=false;

      int amountPayable=0;      //negative
      int amountReceiable=0;      //Positive

      if(totalPapers>0)
        for(int i=1; i<=totalPapers;i++, pageNo++){

          ProductRecord rec[]=new ProductRecord[productPerReport];
          for(int j=0; j<productPerReport; j++){
              rec[j]=(ProductRecord)v.elementAt(++index);
              rec[j].sno=String.valueOf(++sno);

              int value=Integer.parseInt(rec[j].product_value);
              if(value<0)
                  amountPayable+=value;      //negative
               else
                  amountReceiable+=value;      //Positive

          }

          if(i==totalPapers && lastPaper==0)IS_LAST_PAGE=true;

          pageNo++;

          book.append (new ReportProductStockDocument(rec,pageNo,IS_LAST_PAGE,TOTAL_PAGE,amountPayable,amountReceiable), pageFormat);
       }//end for loop

    if(lastPaper>0){
         ProductRecord rec[]=new ProductRecord[lastPaper];
         IS_LAST_PAGE=true;
         for(int j=0; j<lastPaper; j++){
              rec[j]=(ProductRecord)v.elementAt(++index);
              rec[j].sno=String.valueOf(++sno);

              int value=Integer.parseInt(rec[j].product_value);
              if(value<0)
                  amountPayable+=value;      //negative
               else
                  amountReceiable+=value;      //Positive
         }//end for

         book.append (new ReportProductStockDocument(rec,pageNo,IS_LAST_PAGE,TOTAL_PAGE,amountPayable,amountReceiable), pageFormat);
    }//end if


   PrinterJob printJob = PrinterJob.getPrinterJob ();
   printJob.setPageable (book);
   if (printJob.printDialog()) printJob.print();

  }catch(Exception e){
    e.printStackTrace();
  }
 }///////end method

 private Object[] getPreAmountAndQuantity(boolean IS_PRODUCT_WISE,boolean isBoth,String dateFrom)throws Exception{

   String dateTo=dateFrom;
   dateFrom="";

   Object obj[];

   if(isBoth){
        ProductRecord productRec=(ProductRecord)productComboBox.getSelectedItem();
        CustomerRecord customerRec=(CustomerRecord)customerProductComboBox.getSelectedItem();

        if(productRec==null)return null;
        if(customerRec==null)return null;

        obj=getProductTransactions(productRec,customerRec,dateFrom,dateTo, IS_PRODUCT_WISE,isBoth);
   }else
   if(IS_PRODUCT_WISE){
        ProductRecord productRec=(ProductRecord)productComboBox.getSelectedItem();
        if(productRec==null)return null;
        obj=getProductTransactions(productRec,null,dateFrom,dateTo,IS_PRODUCT_WISE,isBoth);
    }else{
        CustomerRecord customerRec=(CustomerRecord)customerProductComboBox.getSelectedItem();
        if(customerRec==null)return null;
        obj=getProductTransactions(null,customerRec,dateFrom,dateTo, IS_PRODUCT_WISE,isBoth);
    }

    return obj;
 }//end method


 private Object[] getProductTransactions(ProductRecord productRec,CustomerRecord customerRec,String dateFrom,String dateTo,boolean IS_PRODUCT_WISE,boolean isBoth)throws Exception{
   CashRegisterRecord cashRegisterRec=(CashRegisterRecord)yearProductComboBox.getSelectedItem();

   String transactionType=(String)transactionTypeComboBox.getSelectedItem();
   String termsConditions=(String)termsConditionsProductComboBox.getSelectedItem();

   if(cashRegisterRec==null)return null;
   if(transactionType==null)return null;
   if(termsConditions==null)return null;

   transactionType=Encode.transactionTypeEncode(transactionType);

   ProductTransactionRecord productTransRec=DatabaseManager.getProductTransactions(cashRegisterRec.cash_reg_id,productRec,customerRec,transactionType,dateFrom,dateTo,termsConditions,IS_PRODUCT_WISE,isBoth);
   if(productTransRec==null)return null;

   int purchaseAmount=0;
   double purchaseQuantity=0;

   int saleAmount=0;
   double saleQuantity=0;

   java.util.Vector v=productTransRec.getProductTransactions();
   int size=v.size();

   for(int j=0; j<size; j++){
       PurchaseSaleBookRecord purchaseSaleBookRec=(PurchaseSaleBookRecord)v.elementAt(j);
       if(purchaseSaleBookRec.trans_type.startsWith("S")){
            saleAmount+=Integer.parseInt(purchaseSaleBookRec.total_amount);
            saleQuantity+=Double.parseDouble(purchaseSaleBookRec.quantity_kg_bag);
       }else{
             purchaseAmount+=Integer.parseInt(purchaseSaleBookRec.total_amount);
             purchaseQuantity+=Double.parseDouble(purchaseSaleBookRec.quantity_kg_bag);
       }
   }//end for

   int previousAmount=      purchaseAmount-saleAmount;
   double previousQuantity= purchaseQuantity-saleQuantity;

   Object obj[]={new Integer(previousAmount),new Double(previousQuantity)};
   return obj;
 }//end method

 }//end class
