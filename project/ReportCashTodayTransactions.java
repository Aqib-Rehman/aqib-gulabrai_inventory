package project;

import java.awt.*;
import java.awt.print.*;
import java.util.ArrayList;

public class ReportCashTodayTransactions implements Printable {

    private int pageNo;
    boolean IS_LAST_PAGE;
    private int TOTAL_PAGE;
    String date;
    // ArrayList<TransactionRecord> transactionList;
    ArrayList transactionList;
    int startIndex;
    int endIndex;
    String HEADING = "CASH BOOK";
    String totalCredit = "";
    String totalDebit = "";
    String current = "";
    public ReportCashTodayTransactions(String heading,String totalDebit,String totalCredit, String current, String date, int pageNo, boolean IS_LAST_PAGE, int TOTAL_PAGE, ArrayList transactionList, int startIndex, int endIndex) {
        HEADING = heading;
        this.pageNo = pageNo;
        this.IS_LAST_PAGE = IS_LAST_PAGE;
        this.TOTAL_PAGE = TOTAL_PAGE;
        this.date = date;
        this.transactionList = transactionList;
        this.endIndex = endIndex;
        this.startIndex = startIndex;
        this.totalCredit = totalCredit;
        this.totalDebit = totalDebit;
        this.current = current;
    }

    public int print(Graphics g, PageFormat pageFormat, int pageIndex) {

        Graphics2D g2d = (Graphics2D) g;
        int startY = 25;
            String DATE_LABEL = "DATE: " + date;

            String S_NO_LABEL = "S.NO.";
            String TR_NO_LABEL = "TR.NO.";
            String DEBIT_AMOUNT_LABEL = "DEBIT ";
            String CREDIT_AMOUNT_LABEL = "CREDIT ";
            String CUSTOMER_NAME_LABEL = "CUSTOMER ";
            String DESC_LABEL = "DESCRIPTION";
            String BEARER_LABEL = "BEARER";

            int S_NO_X = 20;
            int TR_NO_X = 70;
            int DEBIT_AMOUNT_X = 150;
            int CREDIT_AMOUNT_X = 220;
            int CUSTOMER_NAME_X = 295;
            int DESC_X = 505;
            int BEARER_X = 700;

            g2d.setFont(new Font("Courier New", Font.BOLD, 12));
            double hSize = g2d.getFontMetrics().getStringBounds(HEADING, g2d).getWidth();
            double hSize2 = hSize / 3;
            double centerLandscapeX = pageFormat.getHeight() / 2;

            g2d.drawString(HEADING, (int) (centerLandscapeX - hSize2), startY);
            g2d.drawString(DATE_LABEL, (int) (centerLandscapeX + hSize2 + hSize) + 40, startY);
      if (startIndex >= 0) {
            startY += 20;
            g2d.drawString(S_NO_LABEL, S_NO_X, startY);
            g2d.drawString(TR_NO_LABEL, TR_NO_X, startY);
            g2d.drawString(DEBIT_AMOUNT_LABEL, DEBIT_AMOUNT_X, startY);
            g2d.drawString(CREDIT_AMOUNT_LABEL, CREDIT_AMOUNT_X, startY);
            g2d.drawString(CUSTOMER_NAME_LABEL, CUSTOMER_NAME_X, startY);
            g2d.drawString(DESC_LABEL, DESC_X, startY);
            g2d.drawString(BEARER_LABEL, BEARER_X, startY);

            g2d.setFont(new Font("Courier New", Font.PLAIN, 10));

            for (int i = startIndex; i <= endIndex; i++) {
                startY += 15;
                TransactionRecord rec = (TransactionRecord) transactionList.get(i);
                g2d.drawString("" + (i + 1), S_NO_X, startY);
                g2d.drawString(rec.customer_trans_id, TR_NO_X, startY);
                g2d.drawString(rec.debit_amount, DEBIT_AMOUNT_X, startY);
                g2d.drawString(rec.credit_amount, CREDIT_AMOUNT_X, startY);
                g2d.drawString(rec.customer_id, CUSTOMER_NAME_X, startY);
                g2d.drawString(rec.remarks, DESC_X, startY);
                g2d.drawString(rec.bearer, BEARER_X, startY);
            }
        }

        g2d.setFont(new Font("Courier New", Font.BOLD, 12));
        if (IS_LAST_PAGE) {
            startY += 20;
            g2d.drawString("SUMMARY", 30, startY);
            startY += 15;
            g2d.drawString("DEBIT AMOUNT: Rs. "+totalDebit, 30, startY);
            startY += 15;
            g2d.drawString("CREDIT AMOUNT: Rs. "+totalCredit, 30, startY);

            if(HEADING.toLowerCase().indexOf("cash")>-1){
              double totalDebitAmount = Double.parseDouble(totalDebit.trim());
              double totalCreditAmount = Double.parseDouble(totalCredit.trim());
              double currentAmount = Double.parseDouble(current.trim());
              double ob = ( currentAmount - totalDebitAmount + totalCreditAmount);
              System.out.println("current:"+current+" - Debit: "+totalDebit+" -  Credit:"+totalCredit+"  - Opening:"+ob );
              double baln = Double.parseDouble(totalDebit.trim()) - Double.parseDouble(totalCredit.trim());
              String bal = "";
              if(baln>0){
                bal = " /Debit";
              }else{
                bal = " /Credit";
              }
              startY += 15;
              g2d.drawString("BALANCE: Rs. "+(baln)+bal, 30, startY);
              startY += 15;
              g2d.drawString("OPENING BALANCE: Rs. "+ob, 30, startY);
              startY += 15;
              g2d.drawString("CASH IN HAND: Rs. "+current, 30, startY);
            }
        }

        return PAGE_EXISTS;
    }//end method

    public static void printTransactionReport(String heading,String totalDebit,String totalCredit, String current,ArrayList list, String date, String currentBalance) throws Exception {
        PrinterJob job = PrinterJob.getPrinterJob();

        Book book = new Book();
        PageFormat pageFormat = new PageFormat();
        pageFormat.setOrientation(PageFormat.LANDSCAPE);
        Paper paper = new Paper();
        paper.setSize(PageSetupInterface.PAPER_WIDTH, PageSetupInterface.PAPER_HEIGHT);
        paper.setImageableArea(0, 0, paper.getWidth(), paper.getHeight());
        pageFormat.setPaper(paper);

        int TRANSACTION_PER_PAGE = 35;
        int totalPages = list.size() / TRANSACTION_PER_PAGE;
        int remaining = list.size() % TRANSACTION_PER_PAGE;
        for (int i = 1; i <= totalPages; i++) {
            book.append(new ReportCashTodayTransactions(heading,totalDebit,totalCredit,current,date, 1, false, 1, list, ((i * TRANSACTION_PER_PAGE) - TRANSACTION_PER_PAGE), (i * TRANSACTION_PER_PAGE) - 1), pageFormat);
        }
        if (remaining > 0 && remaining<30) {
            book.append(new ReportCashTodayTransactions(heading,totalDebit,totalCredit,current,date, 1, true, 1, list, (((totalPages + 1) * TRANSACTION_PER_PAGE) - TRANSACTION_PER_PAGE), list.size() - 1), pageFormat);
        }else if(remaining == 0 ){
            book.append(new ReportCashTodayTransactions(heading,totalDebit,totalCredit,current,date, 1, true, 1, list, -1, -1), pageFormat);
        }else{
            book.append(new ReportCashTodayTransactions(heading,totalDebit,totalCredit,current,date, 1, false, 1, list, (((totalPages + 1) * TRANSACTION_PER_PAGE) - TRANSACTION_PER_PAGE), list.size() - 1), pageFormat);
            book.append(new ReportCashTodayTransactions(heading,totalDebit,totalCredit,current,date, 1, true, 1, list, -1, -1), pageFormat);
        }

        job.setPageable(book);

        if(job.printDialog())job.print();
    }
}//end class
