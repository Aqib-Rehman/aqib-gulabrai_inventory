package project;

import java.sql.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Title: Database for Industrial Management Description: The designed system
 * solve all major problems of existing system. Copyright: Copyright (c) 2014
 *
 * @author Jay Kumar
 * @version 2.0
 */
public class DatabaseManager {

    private static Connection con;
    private static String dbpath;

    static {
        init();
    }

    public static String get_dbpath() throws Exception {
        String dbconfig = "dbconfig.conf";
        String databasepath = "Databasev1.mdb";
        try {
            File myObj = new File(dbconfig);
            FileInputStream fileInputStream = new FileInputStream(dbconfig);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            System.out.println(myObj.getAbsolutePath());
            String data = dataInputStream.readLine();
            System.out.println(data);
            StringTokenizer tokenizer = new StringTokenizer(data, "=");
            tokenizer.nextToken();
            databasepath = tokenizer.nextToken();
            dataInputStream.close();
        } catch (Exception e) {
            System.out.println("An error occurred reading dbconfig.conf file .");
            e.printStackTrace();

            FileOutputStream fos = new FileOutputStream(dbconfig);
            PrintWriter writer = new PrintWriter(fos);

//          writer.println("DBPATH=D:\\Complete[2016-02-10]-Gulab Rai\\JBuilder-Project\\Project\\src\\Database.mdb");
            writer.println("DBPATH=Project\\src\\Database.mdb");
            writer.close();
            fos.close();

        }
        return databasepath;

    }

    public static String[] ui_frames = {"AccountClosingFrame", "AccountPayableReceivableFrame", "CashBookFrame", "CashRegisterFrame", "CreditDebitBookFrame", "CustomerFrame", "ProductFrame", "PurchaseBookFrame", "ReportFrame", "SaleBookFrame", "TransactionFrame", "VoucharFrame"};

    public static String getHash(String input) {
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(input.getBytes());

            byte[] digestBytes = md.digest();

            // Convert the byte array to a hexadecimal string
            hexString = new StringBuffer();
            for (int i = 0; i < digestBytes.length; i++) {
                hexString.append(Integer.toHexString(0xFF & digestBytes[i]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hexString.toString();

    }

    public static void init() {
        try {
            String dbpath = get_dbpath();

//        String dbpath = "D:\\Complete[2016-02-10]-Gulab Rai\\JBuilder-Project\\Project\\src\\Database.mdb" ;
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=" + dbpath + ";DriverID=22;READONLY=true";

            con = DriverManager.getConnection(url);

         //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //con=DriverManager.getConnection("jdbc:odbc:abc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end methd

    public static Vector getCustomers(UserAccountRecord uar) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            
                         boolean filter = true;
                         Set resultSet1 = new HashSet();
                         
String framesList  = uar.frames.toString();
framesList = framesList.replace('[', ' ');
framesList = framesList.replace(']', ' ');
//framesList.ind
StringTokenizer strTokens =
                new StringTokenizer(framesList, ",");

 while(strTokens.hasMoreTokens()) {
 
            // print token one-by-one iteratively
     
     String myToken = strTokens.nextToken().trim();
            System.out.println(myToken);
            
            if(myToken.equals("ALL")){
                filter = false;
            }
            
          String allowedIds =  getCustomerPermissionbyuserId(uar.id);
          if(allowedIds.trim().equals(""))
               filter = false;
          else{
               
        StringTokenizer tokenizer = new StringTokenizer(allowedIds.trim(), ",");

        while (tokenizer.hasMoreTokens()) {
            resultSet1.add(tokenizer.nextToken());
        }
          }
 }
 
            String query = "SELECT customer_id, name, contact,customer_type, address, remarks FROM customer order by name";
            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);

            Vector v = new Vector();
            while (result.next()) {
                String customer_id = result.getString("customer_id");
                if(!filter || (filter && resultSet1.contains(customer_id))){
                
                CustomerRecord rec = new CustomerRecord();

                rec.customer_id = customer_id;
                rec.name = result.getString("name");
                rec.contact = result.getString("contact");
                rec.customer_type = result.getString("customer_type");
                rec.address = result.getString("address");
                rec.remarks = result.getString("remarks");

                v.addElement(rec);
                }
                
                
                
            }

            return v;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static Vector getCustomers(String customer_type, int test) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "SELECT customer_id, name, contact,customer_type, address, remarks FROM customer where customer_type='" + customer_type + "' order by name";
            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);

            Vector v = new Vector();
            while (result.next()) {

                CustomerRecord rec = new CustomerRecord();

                rec.customer_id = result.getString("customer_id");
                rec.name = result.getString("name");
                rec.contact = result.getString("contact");
                rec.customer_type = result.getString("customer_type");
                rec.address = result.getString("address");
                rec.remarks = result.getString("remarks");

                v.addElement(rec);
            }

            return v;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static String getCustomerbyId(int customer_id) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "SELECT name FROM customer where customer_id=" + customer_id;
            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);
            String customer_name = "";
            while (result.next()) {

                customer_name = result.getString("name");

            }

            return customer_name;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    
    
           
    public static String getCustomerPermissionbyuserId(int user_id) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "SELECT customer_id FROM usercustomerpermission where useraccount_id=" + user_id;
            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);
            String customer_id = "";
            while (result.next()) {

                customer_id = result.getString("customer_id");

            }

            return customer_id;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd 
            
    
    public static String getProductPermissionbyuserId(int user_id) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "SELECT product_id FROM userproductpermission where useraccount_id=" + user_id;
            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);
            String product_id = "";
            while (result.next()) {

                product_id = result.getString("product_id");

            }

            return product_id;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd 
    
    
    public static String getProductbyId(int product_id) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "SELECT name FROM product where product_id=" + product_id;
            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);
            String product_name = "";
            while (result.next()) {

                product_name = result.getString("name");

            }

            return product_name;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    
    public static int addCustomers(String name, String contact, String customer_type, String address, String remarks) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "insert into customer(name, contact,customer_type, address, remarks)values ('" + name + "','" + contact + "','" + customer_type + "','" + address + "','" + remarks + "')";
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int deleteCustomers(String customer_id) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "delete from customer where customer_id=" + customer_id;
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int updateCustomers(String customer_id, String name, String contact, String customer_type, String address, String remarks) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "update customer set name='" + name + "', contact='" + contact + "',customer_type='" + customer_type + "', address='" + address + "', remarks='" + remarks + "' where customer_id=" + customer_id;
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    /**
     * *******************************************
     */
    public static Vector getCashRegisters() throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "SELECT cash_reg_id, current_balance, date_of_opening, year, remarks FROM cash_register order by year desc";
            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);

            Vector v = new Vector();
            while (result.next()) {
                CashRegisterRecord rec = new CashRegisterRecord();

                rec.cash_reg_id = result.getString("cash_reg_id");
                rec.current_balance = result.getString("current_balance");
                rec.date_of_opening = DateFormat.getDateInUSAFormat(result.getDate("date_of_opening"));
                rec.year = result.getString("year");
                rec.remarks = result.getString("remarks");

                v.addElement(rec);
            }

            return v;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int addCashRegister(String current_balance, String date_of_opening, String year, String remarks) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "insert into cash_register(current_balance, date_of_opening, year, remarks)values (" + current_balance + ",#" + date_of_opening + "#," + year + ",'" + remarks + "')";
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int deleteCashRegister(String cash_reg_id) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "delete from cash_register where cash_reg_id=" + cash_reg_id;
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int updateCashRegister(String cash_reg_id, String current_balance, String date_of_opening, String year, String remarks) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "update cash_register set current_balance=" + current_balance + ", date_of_opening=#" + date_of_opening + "#, year=" + year + ", remarks='" + remarks + "' where cash_reg_id=" + cash_reg_id;
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    /**
     * *******************************************
     */
    public static Vector getProduct(UserAccountRecord uar) throws Exception {
        System.out.println("test1*************");
        Statement st = null;
        ResultSet result = null;
        try {

                             boolean filter = true;
                         Set resultSet1 = new HashSet();
                         
String framesList  = uar.frames.toString();
framesList = framesList.replace('[', ' ');
framesList = framesList.replace(']', ' ');
//framesList.ind
StringTokenizer strTokens =
                new StringTokenizer(framesList, ",");

 while(strTokens.hasMoreTokens()) {
 
            // print token one-by-one iteratively
     
     String myToken = strTokens.nextToken().trim();
            System.out.println(myToken);
            
            if(myToken.equals("ALL")){
                filter = false;
            }
            
          String allowedIds =  getProductPermissionbyuserId(uar.id);
          if(allowedIds.trim().equals(""))
               filter = false;
          else{
               
        StringTokenizer tokenizer = new StringTokenizer(allowedIds.trim(), ",");

        while (tokenizer.hasMoreTokens()) {
            resultSet1.add(tokenizer.nextToken());
        }
          }
 }
 
 
//to_char(round(quantity_available,2),'0.99')
// String query="SELECT product_id, name, measurement_unit, quantity_available, company,product_value, remarks FROM product ORDER BY name";
            String query = "SELECT product_id, name, measurement_unit, round(quantity_available,2) as q_available, company,product_value, remarks FROM product ORDER BY name";

            System.out.println(query);
            st = con.createStatement();
            result = st.executeQuery(query);

            Vector v = new Vector();
            while (result.next()) {
                
                  String product_id = result.getString("product_id");
                if(!filter || (filter && resultSet1.contains(product_id))){
                
                ProductRecord rec = new ProductRecord();
 
                rec.product_id = product_id;
                rec.name = result.getString("name");
                rec.measurement_unit = result.getString("measurement_unit");
//        rec.quantity_available=result.getString("quantity_available");
                rec.quantity_available = result.getString("q_available");

                rec.company = result.getString("company");
                rec.product_value = result.getString("product_value");
                rec.remarks = result.getString("remarks");

                v.addElement(rec);
                }
            }

            return v;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int addProduct(String name, String measurement_unit, String quantity_available, String company, String product_value, String remarks) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "insert into product(name, measurement_unit, quantity_available, company,product_value, remarks)values ('" + name + "','" + measurement_unit + "'," + quantity_available + ",'" + company + "'," + product_value + ",'" + remarks + "')";
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int deleteProduct(String product_id) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "delete from product where product_id=" + product_id;
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int updateProduct(String product_id, String name, String measurement_unit, String quantity_available, String company, String product_value, String remarks) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "update product set name='" + name + "', measurement_unit='" + measurement_unit + "', quantity_available=" + quantity_available + ", company='" + company + "', remarks='" + remarks + "',product_value=" + product_value + " where product_id=" + product_id;
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    /**
     * ******************************************************
     */
    public static ProductTransactionRecord getProductTransactions(String cash_reg_id, ProductRecord productRec, CustomerRecord customerRec, String transactionType, String dateFrom, String dateTo, String termsConditions, boolean IS_PRODUCT_WISE, boolean isBoth) throws Exception {
        ProductTransactionRecord rec = new ProductTransactionRecord();

        java.util.Vector transVector = null;
        if (isBoth) {
            transVector = getPurchaseSaleBook(cash_reg_id, productRec.product_id, customerRec.customer_id, transactionType, dateFrom, dateTo, termsConditions, IS_PRODUCT_WISE, isBoth);
        } else if (IS_PRODUCT_WISE) {
            transVector = getPurchaseSaleBook(cash_reg_id, productRec.product_id, null, transactionType, dateFrom, dateTo, termsConditions, IS_PRODUCT_WISE, isBoth);
        } else {
            transVector = getPurchaseSaleBook(cash_reg_id, null, customerRec.customer_id, transactionType, dateFrom, dateTo, termsConditions, IS_PRODUCT_WISE, isBoth);
        }

        if (transVector == null || transVector.size() == 0) {
            return null;
        }
        rec.setProductTransactions(transVector);
        return rec;
    }//end methd

    public static int setProduct(Vector v, String trans_type) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {

            String query = "SELECT name, product_value FROM product where product_value" + trans_type + " order by name";
            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);
            int amount = 0;
            while (result.next()) {
                CustomerTransactionRecord rec = new CustomerTransactionRecord();

                rec.customer_name = result.getString("name");
                int value = result.getInt("product_value");
                rec.amount = "" + value;
                amount += value;

                rec.isProduct = true;
                v.addElement(rec);
            }
            return amount;

        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static CustomerTransactionRecord getCustomerTransactions(String customer_id, String cash_reg_id, String dateFromCustomer, String dateToCustomer, String debit_credit, String year, String order) throws Exception {
        CustomerTransactionRecord rec = new CustomerTransactionRecord();

        java.util.Vector transVector = getTransactions(customer_id, cash_reg_id, dateFromCustomer, dateToCustomer, debit_credit, order);

        SummaryDetailRecord summaryDetailRec = getPreviousBalance(customer_id, year);

        if ((transVector == null || transVector.size() == 0) && summaryDetailRec == null) {
            return null;
        }
        rec.setTransactions(transVector);

        if (!dateFromCustomer.equals("") && !dateToCustomer.equals("")) {
            java.util.Vector transVector1 = getPreviousBalance(customer_id, cash_reg_id, dateFromCustomer, debit_credit, order);

            int creditAmount = getAmount("C", transVector1);
            int debitAmount = getAmount("D", transVector1);

            double balance = 0;
            String credit_debit = "C";
            if (creditAmount >= debitAmount) {
                balance = creditAmount - debitAmount;
                credit_debit = "C";
            }
            if (debitAmount > creditAmount) {
                balance = debitAmount - creditAmount;
                credit_debit = "D";
            }
            balance = balance < 0 ? -(balance) : balance;
            rec.previous_balance = "" + balance; //"Rs. "+balance+"/ "+Decode.debitCreditDecode(credit_debit);
            rec.previous_credit_debit = Decode.debitCreditDecode(credit_debit);
        } else {
            rec.setSummaryDetail(summaryDetailRec);
        }

        rec.credit_amount = getAmount("C", transVector);
        rec.debit_amount = getAmount("D", transVector);

        return rec;
    }//end methd

    public static Vector getTransactions(String customer_id, String cash_reg_id, String dateFromCustomer, String dateToCustomer, String debit_credit, String order) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query;
            if (!dateFromCustomer.equals("") && dateToCustomer.equals("")) {
                query = "SELECT customer_id, cash_reg_id,purchase_sale_id, customer_trans_id, amount, debit_credit, date_of_trans, bearer, remarks FROM transaction WHERE customer_id=" + customer_id + " AND cash_reg_id=" + cash_reg_id + " AND date_of_trans>=#" + dateFromCustomer + "#  ";
            } else if (dateFromCustomer.equals("") && !dateToCustomer.equals("")) {
                query = "SELECT customer_id, cash_reg_id,purchase_sale_id, customer_trans_id, amount, debit_credit, date_of_trans, bearer, remarks FROM transaction WHERE customer_id=" + customer_id + " AND cash_reg_id=" + cash_reg_id + " AND date_of_trans<=#" + dateToCustomer + "# ";
            } else if (!dateFromCustomer.equals("") && !dateToCustomer.equals("")) {
                query = "SELECT customer_id, cash_reg_id,purchase_sale_id, customer_trans_id, amount, debit_credit, date_of_trans, bearer, remarks FROM transaction WHERE customer_id=" + customer_id + " AND cash_reg_id=" + cash_reg_id + " AND date_of_trans>=#" + dateFromCustomer + "# AND date_of_trans<=#" + dateToCustomer + "# ";
            } else //defaul if(dateFromCustomer.equals("") && dateToCustomer.equals(""))
            {
                query = "SELECT customer_id, cash_reg_id,purchase_sale_id, customer_trans_id, amount, debit_credit, date_of_trans, bearer, remarks FROM transaction WHERE customer_id=" + customer_id + " AND cash_reg_id=" + cash_reg_id + " ";
            }

            if (!debit_credit.equals("B")) {
                query += " AND debit_credit='" + debit_credit + "' ";
            }

            if (order.equals("")) {
                query += " order by date_of_trans";
            } else {
                query += " order by date_of_trans desc";
            }

            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);

            Vector v = new Vector();
            while (result.next()) {
                TransactionRecord rec = new TransactionRecord();

                rec.customer_id = result.getString("customer_id");
                rec.cash_reg_id = result.getString("cash_reg_id");
                rec.purchase_sale_id = result.getString("purchase_sale_id");
                rec.customer_trans_id = result.getString("customer_trans_id");
                rec.amount = result.getString("amount");
                rec.debit_credit = result.getString("debit_credit");
                rec.date_of_trans = DateFormat.getDateInUSAFormat(result.getDate("date_of_trans"));
                rec.bearer = result.getString("bearer");
                rec.remarks = result.getString("remarks");

                v.addElement(rec);
                System.out.println("purchase_sale_id: " + rec.purchase_sale_id);
            }

            return v;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static Vector getPreviousBalance(String customer_id, String cash_reg_id, String dateFromCustomer, String debit_credit, String order) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "SELECT customer_id, cash_reg_id,purchase_sale_id, customer_trans_id, amount, debit_credit, date_of_trans, bearer, remarks FROM transaction WHERE customer_id=" + customer_id + " AND cash_reg_id=" + cash_reg_id + " AND date_of_trans<#" + dateFromCustomer + "#  ";

            if (!debit_credit.equals("B")) {
                query += " AND debit_credit='" + debit_credit + "' ";
            }

            if (order.equals("")) {
                query += " order by date_of_trans";
            } else {
                query += " order by date_of_trans desc";
            }

            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);

            Vector v = new Vector();
            while (result.next()) {

                TransactionRecord rec = new TransactionRecord();

                rec.customer_id = result.getString("customer_id");
                rec.cash_reg_id = result.getString("cash_reg_id");
                rec.purchase_sale_id = result.getString("purchase_sale_id");
                rec.customer_trans_id = result.getString("customer_trans_id");
                rec.amount = result.getString("amount");
                rec.debit_credit = result.getString("debit_credit");
                rec.date_of_trans = DateFormat.getDateInUSAFormat(result.getDate("date_of_trans"));
                rec.bearer = result.getString("bearer");
                rec.remarks = result.getString("remarks");

                v.addElement(rec);
                System.out.println("purchase_sale_id: " + rec.purchase_sale_id);
            }

            return v;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

// public static Vector getTransactions(String cash_reg_id,String dateFrom,String dateTo)throws Exception{
//        Statement st=null;
//        ResultSet result=null;
//   try{
//        String query="SELECT customer_id, cash_reg_id,purchase_sale_id, customer_trans_id, amount, debit_credit, date_of_trans, bearer, remarks FROM transaction WHERE cash_reg_id="+cash_reg_id;
//
//        if(!dateFrom.equals(""))query=" AND date_of_trans>=#"+dateFrom+"# ";
//        if(!dateTo.equals(""))  query=" AND date_of_trans<=#"+dateTo+"# ";
//
//        query+=" and purchase_sale_id Is Null order by date_of_trans";
//        System.out.println(query);
//
//        st=con.createStatement();
//        result=st.executeQuery(query);
//
//        Vector v=new Vector();
//        while(result.next()){
//          TransactionRecord rec=new TransactionRecord();
//
//          rec.customer_id=result.getString("customer_id");
//          rec.cash_reg_id=result.getString("cash_reg_id");
//          rec.purchase_sale_id=result.getString("purchase_sale_id");
//          rec.customer_trans_id=result.getString("customer_trans_id");
//          rec.amount=result.getString("amount");
//          rec.debit_credit=result.getString("debit_credit");
//          rec.date_of_trans=DateFormat.getDateInUSAFormat(result.getDate("date_of_trans"));
//          rec.bearer=result.getString("bearer");
//          rec.remarks=result.getString("remarks");
//
//          v.addElement(rec);
//        }
//
//      return v;
//   }finally{
//     if(result!=null)result.close();
//     if(st!=null)st.close();
//   }
// }//end methd
    public static int addTransactionPurchaseSale(String purchase_sale_id, String customer_id, String cash_reg_id, String amount, String debit_credit, String date_of_trans, String bearer, String remarks) throws Exception {
        Statement st = null;
        ResultSet result = null;

        try {
            String query = "insert into transaction(purchase_sale_id,customer_id,cash_reg_id,amount,debit_credit,date_of_trans,bearer,remarks)values (" + purchase_sale_id + "," + customer_id + "," + cash_reg_id + "," + amount + ",'" + debit_credit + "',#" + date_of_trans + "#,'" + bearer + "','" + remarks + "')";
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            //MODIFIED
            query = "select MAX(customer_trans_id) from transaction";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                rows = rs.getInt(1);
            }

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int addTransaction(String customer_id, String cash_reg_id, String amount, String debit_credit, String date_of_trans, String bearer, String remarks, String payment_mode) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "insert into transaction(purchase_sale_id,customer_id,cash_reg_id,amount,debit_credit,date_of_trans,bearer,remarks,payment_mode)values (null," + customer_id + "," + cash_reg_id + "," + amount + ",'" + debit_credit + "',#" + date_of_trans + "#,'" + bearer + "','" + remarks + "','" + payment_mode + "')";

            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            //MODIFIED
            query = "select MAX(customer_trans_id) from transaction";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                rows = rs.getInt(1);
            }

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int deleteTransaction(String purchase_sale_id, String customer_id, String cash_reg_id) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "delete from transaction where purchase_sale_id=" + purchase_sale_id + " and customer_id=" + customer_id + " and cash_reg_id=" + cash_reg_id;
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int deleteTransaction(String customer_trans_id) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "delete from transaction where customer_trans_id=" + customer_trans_id;
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    /**
     * ******************************************************
     */
    public static Vector getPurchaseSaleBook(String product_id, String customer_id, String cash_reg_id, String trans_type) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = " SELECT "
                    + " product_id,  "
                    + " customer_id,  "
                    + " cash_reg_id, "
                    + " purchase_sale_id, "
                    + " quantity_kg_bag,  "
                    + " rate_mund_bag,  "
                    + " total_amount,  "
                    + " trans_date,  "
                    + " trans_type,  "
                    + " bearer,  "
                    + " terms_and_conditions,  "
                    + " remarks "
                    + " FROM purchase_sale_book "
                    + " WHERE product_id=" + product_id + " AND customer_id=" + customer_id + " AND cash_reg_id=" + cash_reg_id + " AND trans_type='" + trans_type + "' order by trans_date DESC";

            System.out.println(query);
            st = con.createStatement();
            result = st.executeQuery(query);

            Vector v = new Vector();
            while (result.next()) {

                PurchaseSaleBookRecord rec = new PurchaseSaleBookRecord();

                rec.product_id = result.getString("product_id");
                rec.cash_reg_id = result.getString("cash_reg_id");
                rec.customer_id = result.getString("customer_id");
                rec.purchase_sale_id = result.getString("purchase_sale_id");
                rec.quantity_kg_bag = result.getString("quantity_kg_bag");
                rec.rate_mund_bag = result.getString("rate_mund_bag");
                rec.total_amount = result.getString("total_amount");
                rec.trans_date = DateFormat.getDateInUSAFormat(result.getDate("trans_date"));
                rec.trans_type = result.getString("trans_type");
                rec.bearer = result.getString("bearer");
                rec.terms_and_conditions = result.getString("terms_and_conditions");
                rec.remarks = result.getString("remarks");

                v.addElement(rec);
            }

            return v;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static Vector getPurchaseSaleBook(String cash_reg_id, String product_id, String customer_id, String trans_type, String dateFrom, String dateTo, String terms_and_conditions, boolean IS_PRODUCT_WISE, boolean isBoth) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = " SELECT "
                    + " customer.name AS customer_name,  "
                    + " product.name AS product_name,  "
                    + " purchase_sale_book.product_id,  "
                    + " purchase_sale_book.customer_id,  "
                    + " cash_register.year,  "
                    + " cash_register.current_balance,  "
                    + " purchase_sale_book.cash_reg_id,  "
                    + " purchase_sale_book.purchase_sale_id,  "
                    + " purchase_sale_book.quantity_kg_bag,  "
                    + " purchase_sale_book.rate_mund_bag,  "
                    + " purchase_sale_book.total_amount,  "
                    + " purchase_sale_book.trans_date,  "
                    + " purchase_sale_book.trans_type,  "
                    + " purchase_sale_book.bearer,  "
                    + " purchase_sale_book.terms_and_conditions,  "
                    + " purchase_sale_book.remarks "
                    + " FROM cash_register, product,customer,purchase_sale_book "
                    + " where "
                    + " customer.customer_id = purchase_sale_book.customer_id and "
                    + " product.product_id = purchase_sale_book.product_id and  "
                    + " cash_register.cash_reg_id = purchase_sale_book.cash_reg_id "
                    + " AND purchase_sale_book.cash_reg_id=" + cash_reg_id;

            if (isBoth) {
                query += " and purchase_sale_book.product_id=" + product_id;
                query += " and purchase_sale_book.customer_id=" + customer_id;
            } else if (IS_PRODUCT_WISE) {
                query += " and purchase_sale_book.product_id=" + product_id;
            } else {
                query += " and purchase_sale_book.customer_id=" + customer_id;
            }

            if (!trans_type.equals("B")) {
                query += " AND trans_type='" + trans_type + "' ";
            }
            if (!terms_and_conditions.equals("BOTH")) {
                query += " AND terms_and_conditions='" + terms_and_conditions + "' ";
            }
            if (!dateFrom.equals("")) {
                query += " AND trans_date>=#" + dateFrom + "# ";
            }
            if (!dateTo.equals("")) {
                query += " AND trans_date<=#" + dateTo + "# ";
            }

            query += " order by trans_date DESC";
//System.exit(1);
            System.out.println(query);
            st = con.createStatement();
            result = st.executeQuery(query);

            Vector v = new Vector();
            while (result.next()) {

                PurchaseSaleBookRecord rec = new PurchaseSaleBookRecord();

                rec.customer_name = result.getString("customer_name");
                rec.product_name = result.getString("product_name");
                rec.year = result.getString("year");
                rec.current_balance = result.getString("current_balance");
                rec.product_id = result.getString("product_id");
                rec.cash_reg_id = result.getString("cash_reg_id");
                rec.customer_id = result.getString("customer_id");
                rec.purchase_sale_id = result.getString("purchase_sale_id");
                rec.quantity_kg_bag = result.getString("quantity_kg_bag");
                rec.rate_mund_bag = result.getString("rate_mund_bag");
                rec.total_amount = result.getString("total_amount");
                rec.trans_date = DateFormat.getDateInUSAFormat(result.getDate("trans_date"));
                rec.trans_type = result.getString("trans_type");
                rec.bearer = result.getString("bearer");
                rec.terms_and_conditions = result.getString("terms_and_conditions");
                rec.remarks = result.getString("remarks");

                v.addElement(rec);
            }

            return v;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static Vector getPurchaseSaleBook(String cash_reg_id, String dateFrom, String dateTo) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = " SELECT "
                    + " customer.name AS customer_name,  "
                    + " product.name AS product_name,  "
                    + " purchase_sale_book.product_id,  "
                    + " purchase_sale_book.customer_id,  "
                    + " cash_register.year,  "
                    + " cash_register.current_balance,  "
                    + " purchase_sale_book.cash_reg_id,  "
                    + " purchase_sale_book.purchase_sale_id,  "
                    + " purchase_sale_book.quantity_kg_bag,  "
                    + " purchase_sale_book.rate_mund_bag,  "
                    + " purchase_sale_book.total_amount,  "
                    + " purchase_sale_book.trans_date,  "
                    + " purchase_sale_book.trans_type,  "
                    + " purchase_sale_book.bearer,  "
                    + " purchase_sale_book.terms_and_conditions,  "
                    + " purchase_sale_book.remarks "
                    + " FROM cash_register, product,customer,purchase_sale_book "
                    + " where "
                    + " customer.customer_id = purchase_sale_book.customer_id and "
                    + " product.product_id = purchase_sale_book.product_id and  "
                    + " cash_register.cash_reg_id = purchase_sale_book.cash_reg_id "
                    + " AND purchase_sale_book.cash_reg_id=" + cash_reg_id
                    + " AND terms_and_conditions='CASH' ";

            if (!dateFrom.equals("")) {
                query += " AND trans_date>=#" + dateFrom + "# ";
            }
            if (!dateTo.equals("")) {
                query += " AND trans_date<=#" + dateTo + "# ";
            }

            query += " order by trans_date DESC";
//System.exit(1);
            System.out.println(query);
            st = con.createStatement();
            result = st.executeQuery(query);

            Vector v = new Vector();
            while (result.next()) {

                PurchaseSaleBookRecord rec = new PurchaseSaleBookRecord();

                rec.customer_name = result.getString("customer_name");
                rec.product_name = result.getString("product_name");
                rec.year = result.getString("year");
                rec.current_balance = result.getString("current_balance");
                rec.product_id = result.getString("product_id");
                rec.cash_reg_id = result.getString("cash_reg_id");
                rec.customer_id = result.getString("customer_id");
                rec.purchase_sale_id = result.getString("purchase_sale_id");
                rec.quantity_kg_bag = result.getString("quantity_kg_bag");
                rec.rate_mund_bag = result.getString("rate_mund_bag");
                rec.total_amount = result.getString("total_amount");
                rec.trans_date = DateFormat.getDateInUSAFormat(result.getDate("trans_date"));
                rec.trans_type = result.getString("trans_type");
                rec.bearer = result.getString("bearer");
                rec.terms_and_conditions = result.getString("terms_and_conditions");
                rec.remarks = result.getString("remarks");

                v.addElement(rec);
            }

            return v;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static Vector getPurchaseSaleBook(String dateFrom, String dateTo, char trans_type, String terms_and_conditions, UserAccountRecord uar) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            
                 boolean filter = true;
                         Set resultSet1 = new HashSet();
                         
String framesList  = uar.frames.toString();
framesList = framesList.replace('[', ' ');
framesList = framesList.replace(']', ' ');
//framesList.ind
StringTokenizer strTokens =
                new StringTokenizer(framesList, ",");

 while(strTokens.hasMoreTokens()) {
 
            // print token one-by-one iteratively
     
     String myToken = strTokens.nextToken().trim();
            System.out.println(myToken);
            
            if(myToken.equals("ALL")){
                filter = false;
            }
            
          String allowedIds =  getCustomerPermissionbyuserId(uar.id);
          if(allowedIds.trim().equals(""))
               filter = false;
          else{
               
        StringTokenizer tokenizer = new StringTokenizer(allowedIds.trim(), ",");

        while (tokenizer.hasMoreTokens()) {
            resultSet1.add(tokenizer.nextToken());
        }
          }
 }
 
 
 
            String query = " SELECT "
                    + " customer.customer_id,  "
                    + " customer.name as customer_name,  "
                    + " product.name as product_name,  "
                    + " purchase_sale_book.total_amount,  "
                    + " purchase_sale_book.trans_type,  "
                    + " purchase_sale_book.terms_and_conditions "
                    + " FROM customer,  purchase_sale_book,product "
                    + " where  "
                    + " customer.customer_id = purchase_sale_book.customer_id and "
                    + " product.product_id = purchase_sale_book.product_id and "
                    + " purchase_sale_book.trans_type='" + trans_type + "' and  "
                    + " purchase_sale_book.terms_and_conditions='" + terms_and_conditions + "' ";

            if (!dateFrom.equals("")) {
                query += " AND trans_date>=#" + dateFrom + "# ";
            }
            if (!dateTo.equals("")) {
                query += " AND trans_date<=#" + dateTo + "# ";
            }

            query += " order by trans_date ";
//System.exit(1);
            System.out.println(query);
            st = con.createStatement();
            result = st.executeQuery(query);

            Vector v = new Vector();
            while (result.next()) {

                  String customer_id = result.getString("customer_id");
                if(!filter || (filter && resultSet1.contains(customer_id))){
                
                    
                ListItem rec = new ListItem();

                rec.CUSTOMER_NAME = result.getString("customer_name") + "/ " + result.getString("product_name");
                rec.AMOUNT = result.getString("total_amount");

                v.addElement(rec);
                
                }
            }

            return v;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int addPurchaseSaleBook(String product_id,
            String customer_id,
            String cash_reg_id,
            String quantity_kg_bag,
            String rate_mund_bag,
            String total_amount,
            String trans_date,
            String trans_type,
            String bearer,
            String terms_and_conditions,
            String remarks) throws Exception {

        Statement st = null;
        ResultSet result = null;

        try {
            String query = "insert into purchase_sale_book(product_id,customer_id,cash_reg_id,quantity_kg_bag, rate_mund_bag,total_amount,trans_date,trans_type,bearer,terms_and_conditions,remarks) values (" + product_id + "," + customer_id + "," + cash_reg_id + "," + quantity_kg_bag + "," + rate_mund_bag + "," + total_amount + ",#" + trans_date + "#,'" + trans_type + "','" + bearer + "','" + terms_and_conditions + "','" + remarks + "')";
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int deletePurchaseSaleBook(String purchase_sale_id) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "delete from purchase_sale_book WHERE purchase_sale_id=" + purchase_sale_id;
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int cashRegisterIteration(String cash_reg_id, String amount, String debit_credit) throws Exception {
        Statement st = null;
        ResultSet result = null;

        try {
            String query;
            if (debit_credit.trim().toUpperCase().startsWith("C")) {
                query = "update cash_register set current_balance=current_balance-" + amount + " where cash_reg_id=" + cash_reg_id;
            } else {
                query = "update cash_register set current_balance=current_balance+" + amount + " where cash_reg_id=" + cash_reg_id;
            }

            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }//end method

    public static int getLastPurchaseSaleID() throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "SELECT max(purchase_sale_id) as ID  FROM purchase_sale_book";

            System.out.println(query);
            st = con.createStatement();
            result = st.executeQuery(query);

            int ID = -1;
            if (result.next()) {
                ID = result.getInt("ID");
            }

            return ID;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int productIteration(String product_id, String quantity_kg_bag, String total_amount, String credit_debit) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query;

            if (credit_debit.equals("C")) {
                query = "update product set quantity_available=quantity_available-" + quantity_kg_bag + ", product_value=product_value-" + total_amount + " where product_id=" + product_id;
            } else {
                query = "update product set quantity_available=quantity_available+" + quantity_kg_bag + ", product_value=product_value+" + total_amount + " where product_id=" + product_id;
            }

            System.out.println(query);
            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static double getDebitCreditTransactions(String customer_id, String cash_reg_id, String credit_debit) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "SELECT amount FROM transaction WHERE customer_id=" + customer_id + " and cash_reg_id=" + cash_reg_id + " and debit_credit='" + credit_debit + "'";

            System.out.println(query);
            st = con.createStatement();
            result = st.executeQuery(query);

            double amount = 0;
            if (result.next()) {
                amount = result.getDouble("amount");
            }

            return amount;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int addSummaryDetial(String customer_id, String cash_reg_id, double balance, String credit_debit, String remarks) throws Exception {
        boolean exists = isExistsSummaryDetail(customer_id, cash_reg_id);

        Statement st = null;
        ResultSet result = null;
        try {
            String query;
            if (exists) {
                query = "update summary_detail set balance=" + balance + ",credit_debit='" + credit_debit + "',remarks='" + remarks + "' where customer_id=" + customer_id + " and cash_reg_id=" + cash_reg_id;
            } else {
                query = "insert into summary_detail(customer_id,cash_reg_id,balance,credit_debit,remarks) values(" + customer_id + "," + cash_reg_id + "," + balance + ",'" + credit_debit + "','" + remarks + "')";
            }

            System.out.println(query);
            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static boolean isExistsSummaryDetail(String customer_id, String cash_reg_id) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "SELECT * FROM summary_detail WHERE customer_id=" + customer_id + " and cash_reg_id=" + cash_reg_id;
            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);

            boolean exists = result.next();
            return exists;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static SummaryDetailRecord getPreviousBalance(String customer_id, String current_year) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = " SELECT "
                    + " customer_id, "
                    + " summary_detail.cash_reg_id, "
                    + " summary_detail_id, "
                    + " balance, "
                    + " credit_debit, "
                    + " year, "
                    + " summary_detail.remarks  "
                    + " from  "
                    + " summary_detail,cash_register "
                    + " where  "
                    + " summary_detail.cash_reg_id=cash_register.cash_reg_id and year<" + current_year + " and "
                    + " customer_id=" + customer_id + " order by year desc ";

            System.out.println(query);
//        System.exit(1);

            st = con.createStatement();
            result = st.executeQuery(query);

            if (result.next()) {
                SummaryDetailRecord rec = new SummaryDetailRecord();

                rec.customer_id = result.getString("customer_id");
                rec.cash_reg_id = result.getString("cash_reg_id");
                rec.summary_detail_id = result.getString("summary_detail_id");
                rec.balance = result.getString("balance");
                rec.credit_debit = result.getString("credit_debit");
                rec.remarks = result.getString("remarks");

                return rec;
            }//end if

            return null;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static Object[] getCashBook(String credit_debit, String from_date, String to_date, UserAccountRecord uar) throws Exception {
        Vector v = getCashTrans(from_date, to_date, credit_debit);

        setPurchaseSaleCashTrans(v, from_date, to_date, (credit_debit.equals("C") ? "P" : "S"),uar);

        Object obj[] = v.toArray();
        return obj;
    }//end method

    private static Vector getCashTrans(String from_date, String to_date, String debit_credit) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "SELECT amount,name FROM transaction,customer WHERE date_of_trans>=#" + from_date + "# and date_of_trans<=#" + to_date + "# and debit_credit='" + debit_credit + "' and purchase_sale_id Is Null and transaction.customer_id=customer.customer_id";

            if (from_date == null) {
                int cash_reg_id = getLastCashRegID();
//           query="SELECT amount,name FROM transaction,customer WHERE date_of_trans<=#"+to_date+"# and debit_credit='"+debit_credit+"' and purchase_sale_id Is Null and transaction.customer_id=customer.customer_id";
                query = "SELECT amount,name FROM transaction,customer WHERE debit_credit='" + debit_credit + "' and purchase_sale_id Is Null and transaction.customer_id=customer.customer_id";
            }

            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);

            Vector v = new Vector();
            while (result.next()) {

                ListItem rec = new ListItem();

                rec.CUSTOMER_NAME = result.getString("name");
                rec.AMOUNT = result.getString("amount");

                v.addElement(rec);
            }

            return v;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static Vector getCashTrans(String dateFromCustomer, String dateToCustomer, String debit_credit, String customer_id, String cash_reg_id) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            //     String query="SELECT customer_id, cash_reg_id, purchase_sale_id, customer_trans_id,amount,debit_credit, date_of_trans, payment_mode, bearer, remarks FROM transaction WHERE date_of_trans>=#"+from_date+"# and date_of_trans<=#"+to_date+"# and debit_credit='"+debit_credit+"' and purchase_sale_id Is Null and transaction.customer_id="+customer_id;

            String query;
            if (!dateFromCustomer.equals("") && dateToCustomer.equals("")) {
                query = "SELECT customer_id, cash_reg_id, purchase_sale_id, customer_trans_id,amount,debit_credit, date_of_trans, payment_mode, bearer, remarks FROM transaction WHERE customer_id=" + customer_id + " AND cash_reg_id=" + cash_reg_id + " AND date_of_trans>=#" + dateFromCustomer + "# and purchase_sale_id Is Null ";
            } else if (dateFromCustomer.equals("") && !dateToCustomer.equals("")) {
                query = "SELECT customer_id, cash_reg_id, purchase_sale_id, customer_trans_id,amount,debit_credit, date_of_trans, payment_mode, bearer, remarks FROM transaction WHERE customer_id=" + customer_id + " AND cash_reg_id=" + cash_reg_id + " AND date_of_trans<=#" + dateToCustomer + "# and purchase_sale_id Is Null ";
            } else if (!dateFromCustomer.equals("") && !dateToCustomer.equals("")) {
                query = "SELECT customer_id, cash_reg_id, purchase_sale_id, customer_trans_id,amount,debit_credit, date_of_trans, payment_mode, bearer, remarks FROM transaction WHERE customer_id=" + customer_id + " AND cash_reg_id=" + cash_reg_id + " AND date_of_trans>=#" + dateFromCustomer + "# AND date_of_trans<=#" + dateToCustomer + "# and purchase_sale_id Is Null ";
            } else //defaul if(dateFromCustomer.equals("") && dateToCustomer.equals(""))
            {
                query = "SELECT customer_id, cash_reg_id, purchase_sale_id, customer_trans_id,amount,debit_credit, date_of_trans, payment_mode, bearer, remarks FROM transaction WHERE customer_id=" + customer_id + " AND cash_reg_id=" + cash_reg_id + " and purchase_sale_id Is Null ";
            }

            if (!debit_credit.equals("B")) {
                query += " AND debit_credit='" + debit_credit + "' ";
            }

            query += " order by date_of_trans";

            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);

            Vector v = new Vector();
            while (result.next()) {
                TransactionRecord rec = new TransactionRecord();

                rec.customer_id = result.getString("customer_id");
                rec.cash_reg_id = result.getString("cash_reg_id");
                rec.purchase_sale_id = result.getString("purchase_sale_id");
                rec.customer_trans_id = result.getString("customer_trans_id");
                rec.amount = result.getString("amount");
                rec.debit_credit = result.getString("debit_credit");
                rec.date_of_trans = DateFormat.getDateInUSAFormat(result.getDate("date_of_trans"));

                rec.bearer = result.getString("bearer");
                rec.remarks = result.getString("remarks");

                v.addElement(rec);
            }

            return v;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    private static void setPurchaseSaleCashTrans(Vector v, String from_date, String to_date, String trans_type, UserAccountRecord uar) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            
            
                             boolean filter = true;
                         Set resultSet1 = new HashSet();
                         
String framesList  = uar.frames.toString();
framesList = framesList.replace('[', ' ');
framesList = framesList.replace(']', ' ');
//framesList.ind
StringTokenizer strTokens =
                new StringTokenizer(framesList, ",");

 while(strTokens.hasMoreTokens()) {
 
            // print token one-by-one iteratively
     
     String myToken = strTokens.nextToken().trim();
            System.out.println(myToken);
            
            if(myToken.equals("ALL")){
                filter = false;
            }
            
          String allowedIds =  getProductPermissionbyuserId(uar.id);
          if(allowedIds.trim().equals(""))
               filter = false;
          else{
               
        StringTokenizer tokenizer = new StringTokenizer(allowedIds.trim(), ",");

        while (tokenizer.hasMoreTokens()) {
            resultSet1.add(tokenizer.nextToken());
        }
          }
 }
 
 
 
            String query = "SELECT purchase_sale_book.total_amount,product.name AS P_NAME,product.product_id, customer.name AS C_NAME FROM product,purchase_sale_book,customer WHERE trans_type='" + trans_type + "' and trans_date>=#" + from_date + "# and trans_date<=#" + to_date + "# and terms_and_conditions='CASH' and purchase_sale_book.customer_id=customer.customer_id and purchase_sale_book.product_id=product.product_id";
            if (from_date == null) {
                int cash_reg_id = getLastCashRegID();
//           query= "SELECT purchase_sale_book.total_amount,product.name AS P_NAME, customer.name AS C_NAME FROM product,purchase_sale_book,customer WHERE trans_type='"+trans_type+"' and trans_date<=#"+to_date+"# and terms_and_conditions='CASH' and purchase_sale_book.customer_id=customer.customer_id and purchase_sale_book.product_id=product.product_id";
                query = "SELECT purchase_sale_book.total_amount,product.name AS P_NAME,product.product_id, customer.name AS C_NAME FROM product,purchase_sale_book,customer WHERE trans_type='" + trans_type + "' and terms_and_conditions='CASH' and purchase_sale_book.customer_id=customer.customer_id and purchase_sale_book.product_id=product.product_id";
            }

            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);

            while (result.next()) {

                   String product_id = result.getString("product_id");
                if(!filter || (filter && resultSet1.contains(product_id))){
                
                ListItem rec = new ListItem();

                rec.CUSTOMER_NAME = result.getString("P_NAME") + "/ " + result.getString("C_NAME");
                rec.AMOUNT = result.getString("total_amount");

                v.addElement(rec);
                }
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int getCurrentBalanceFromCashRegister() throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "SELECT current_balance,year FROM cash_register order by year desc";
            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);

            int current_balance = 0;
            if (result.next()) {
                current_balance = result.getInt("current_balance");
            }

            return current_balance;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int getLastCashRegID() throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = "SELECT cash_register.cash_reg_id, cash_register.year FROM cash_register order by year desc";
            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);

            int cash_reg_id = 0;
            if (result.next()) {
                cash_reg_id = result.getInt("cash_reg_id");
            }

            return cash_reg_id;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end method

    private static int getAmount(String debit_credit, Vector v) {
        int amount = 0;
        for (int i = 0; i < v.size(); i++) {
            TransactionRecord rec = (TransactionRecord) v.elementAt(i);
            if (rec.debit_credit.startsWith(debit_credit)) {
                amount += Integer.parseInt(rec.amount);
            }

        }//end for loop
        return amount;
    }//end method

    //NEW MODIFIED METHOD FOR GETTING ALL DATE TRANSACTION
    public static Vector getTransactions(String date) throws Exception {
        Statement st = null;
        ResultSet result = null;
        Vector v = new Vector();
        try {
            //String query="SELECT * from transaction t, customer c WHERE t.customer_id=c.customer_id AND t.trans_date=#"+date+"#";
            String query = "SELECT * from transaction t, customer c WHERE t.customer_id=c.customer_id AND t.date_of_trans=#" + date + "#";
            System.out.println(query);

            st = con.createStatement();
            result = st.executeQuery(query);

            while (result.next()) {
                TransactionDetailsRecord tr = new TransactionDetailsRecord();
                tr.customer_trans_id = "" + result.getInt("customer_trans_id");
                tr.bearer = result.getString("bearer");
                tr.customerName = result.getString("name");
                tr.remarks = result.getString("remarks");

                tr.debit_credit = result.getString("payment_mode");

                tr.amount = "" + result.getInt("amount") + " / " + result.getString("debit_credit");
          //String dc = ;
                //if(dc != null || (!dc.trim().equals("null")))

                v.add(tr);
            }

        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
        return v;
    }//End Method

    public static int getLastTransactionID() throws Exception {
        Statement st = null;
        ResultSet result = null;

        try {
            String query = "SELECT max(customer_trans_id) as ID  FROM transaction";

            System.out.println(query);
            st = con.createStatement();
            result = st.executeQuery(query);

            int ID = -1;
            if (result.next()) {
                ID = result.getInt("ID");
            }

            return ID;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static void createUserAccountTable() {
        String query = "CREATE TABLE useraccount ( id INT PRIMARY KEY,  username TEXT CONSTRAINT Uniqueusername UNIQUE, password TEXT, accounttype TEXT, ACTIVE BIT );";
        System.out.println(query);
        ResultSet result = null;
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate(query);

            query = "INSERT INTO useraccount (id, username, password , accounttype, ACTIVE) values  (1, 'naresh', '" + getHash("12243001") + "', '" + Encode.userTypeEncode("ADMIN") + "' ,0 ) ; ";
            System.out.println(query);
            st.executeUpdate(query);

            query = "INSERT INTO useraccount (id, username, password , accounttype, ACTIVE) values (2, 'naresh1', '" + getHash("FlOwEr1") + "',  '" + Encode.userTypeEncode("ADMIN") + "' , 0) ; ";
            System.out.println(query);
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println("Table useraccount already exist ...! ");
//         ex.printStackTrace();
        }

        try {
            query = "CREATE TABLE userframepermission ( useraccount_id INT,  frame TEXT ) ; ";
            System.out.println(query);
            st.executeUpdate(query);

            query = "CREATE TABLE userproductpermission ( useraccount_id INT,  product_id INT , PRIMARY KEY (useraccount_id,  product_id) ); ";
            System.out.println(query);
            st.executeUpdate(query);

            query = "CREATE TABLE usercustomerpermission ( useraccount_id INT,  customer_id INT , PRIMARY KEY (useraccount_id,  customer_id ) ); ";
            System.out.println(query);
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println("Table useraccount already exist ...! ");
//         ex.printStackTrace();
        }

        try {
            query = "CREATE TABLE logging_activities ( id AUTOINCREMENT PRIMARY KEY,  user_id INT , frame_id INT , task text, _time DATETIME, query text  ); ";
            System.out.println(query);
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println("Table logging_activities already exist ...! ");
//         ex.printStackTrace();
        }

    }

    public static Vector getCashTransactionsFromSalePurchase(String date) {
        String query = "SELECT * from purchase_sale_book psb , customer c WHERE psb.customer_id=c.customer_id AND psb.trans_date = #" + date + "# AND psb.terms_and_conditions = 'CASH'";
        System.out.println(query);
        Statement st = null;
        ResultSet result = null;
        Vector v = new Vector();
        try {
            st = con.createStatement();
            result = st.executeQuery(query);

            while (result.next()) {
                TransactionDetailsRecord tr = new TransactionDetailsRecord();
                tr.customer_trans_id = "" + result.getInt("purchase_sale_id");
                tr.bearer = result.getString("bearer");
                tr.customerName = result.getString("name");
                tr.remarks = result.getString("remarks");

                tr.debit_credit = result.getString("terms_and_conditions");

                tr.amount = "" + result.getInt("total_amount");

                v.add(tr);
            }

            if (st != null) {
                st.close();
            }
            return v;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //if(con!=null)con.close();
        }

        return v;
    }// end of method

    public static int getLastUserId() {
        String query = "SELECT MAX(id) from useraccount";
        System.out.println(query);
        Statement st = null;
        ResultSet rs = null;
        int idIs = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);

            if (rs.next()) {
                idIs = rs.getInt(1);
            }

            return idIs;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //if(con!=null)con.close();
        }

        return idIs;
    }// end of method

    public static int addUserFramePermission(int idIs, String userName, String pass, String uType, String framesSelect, int added_by, int frame_id) throws Exception {
        String query = "";
        String queries = "";
        ResultSet result = null;
        Statement st = null;
        try {
            st = con.createStatement();

            query = "INSERT INTO useraccount (id, username, password , accounttype, ACTIVE) values  (" + idIs + ", '" + userName + "', '" + getHash(pass) + "', '" + Encode.userTypeEncode(uType) + "' , 0) ; ";
            System.out.println(query);
            st.executeUpdate(query);
            queries += query;

            query = "INSERT INTO userframepermission (useraccount_id, frame) values  (" + idIs + ", '" + framesSelect + "' ) ; ";
            System.out.println(query);
            st.executeUpdate(query);
            queries += query;

        } catch (Exception ex) {

//         ex.printStackTrace();
            return 0;
        }

        addLog(added_by, frame_id, "Added the user by admin", queries);

        return 1;
    }

    public static int addUserProductPermission(int idIs, String productIds, int added_by, int frame_id) throws Exception {
        String query = "";

        ResultSet result = null;
        Statement st = null;

        query = " SELECT "
                + " username  "
                + " FROM useraccount "
                + " WHERE id=" + idIs;

        System.out.println(query);
        st = con.createStatement();
        result = st.executeQuery(query);
        if (result.next()) {

            try {
                st = con.createStatement();

                query = "INSERT INTO userproductpermission (useraccount_id, product_id) values  (" + idIs + ", '" + productIds + "' ) ; ";
                System.out.println(query);
                st.executeUpdate(query);

            } catch (Exception ex) {

//         ex.printStackTrace();
                query = "update userproductpermission set product_id='" + productIds + "' where useraccount_id=" + idIs;

                System.out.println(query);
                st.executeUpdate(query);

//        queries+=query;
            } finally {
                addLog(added_by, frame_id, "Added the user product permission by admin", query);
                return 1;
            }

        } else {
            return 0;
        }

    }

    public static int addUserCustomerPermission(int idIs, String customerIds, int added_by, int frame_id) throws Exception {
        String query = "";

        ResultSet result = null;
        Statement st = null;

        query = " SELECT "
                + " username  "
                + " FROM useraccount "
                + " WHERE id=" + idIs;

        System.out.println(query);
        st = con.createStatement();
        result = st.executeQuery(query);
        if (result.next()) {

            try {
                st = con.createStatement();

                query = "INSERT INTO usercustomerpermission (useraccount_id, customer_id) values  (" + idIs + ", '" + customerIds + "' ) ; ";
                System.out.println(query);
                st.executeUpdate(query);

            } catch (Exception ex) {

//         ex.printStackTrace();
                query = "update usercustomerpermission set customer_id='" + customerIds + "' where useraccount_id=" + idIs;

                System.out.println(query);
                st.executeUpdate(query);

//        queries+=query;
            } finally {
                addLog(added_by, frame_id, "Added the user customer permission by admin", query);
                return 1;
            }

        } else {
            return 0;
        }

    }
    
    
    public static int deleteUserCustomerPermission(int idIs, int deleted_by, int frame_id) throws Exception {
        String query = "";

        ResultSet result = null;
        Statement st = null;

        query = " SELECT "
                + " username  "
                + " FROM useraccount "
                + " WHERE id=" + idIs;

        System.out.println(query);
        st = con.createStatement();
        result = st.executeQuery(query);
        if (result.next()) {

            try {
                st = con.createStatement();

                query = "delete from usercustomerpermission where useraccount_id=" + idIs;
          
                  System.out.println(query);
                st.executeUpdate(query);

            } catch (Exception ex) {

         ex.printStackTrace();
                

//        queries+=query;
            } finally {
                addLog(deleted_by, frame_id, "Deleted the user customer permission by admin", query);
                return 1;
            }

        } else {
            return 0;
        }

    }


     
    public static int deleteUserProductPermission(int idIs, int deleted_by, int frame_id) throws Exception {
        String query = "";

        ResultSet result = null;
        Statement st = null;

        query = " SELECT "
                + " username  "
                + " FROM useraccount "
                + " WHERE id=" + idIs;

        System.out.println(query);
        st = con.createStatement();
        result = st.executeQuery(query);
        if (result.next()) {

            try {
                st = con.createStatement();

 
                query = "delete from userproductpermission where useraccount_id=" + idIs;
          
                  System.out.println(query);
                st.executeUpdate(query);

            } catch (Exception ex) {

         ex.printStackTrace();
                

//        queries+=query;
            } finally {
                addLog(deleted_by, frame_id, "Deleted the user product permission by admin", query);
                return 1;
            }

        } else {
            return 0;
        }

    }

    
    
    public static int updateUserFramePermission(int idIs, String pass, String framesSelect, int updated_by, int frame_id) throws Exception {
        String query = "";
        String queries = "";
        ResultSet result = null;
        Statement st = null;
        int ret = 0;
        try {
            st = con.createStatement();
            query = "update useraccount set password='" + getHash(pass) + "' where id=" + idIs;
            System.out.println(query);
            ret = st.executeUpdate(query);
            queries += query;
            if (ret == 0) {
                return -1;
            }
            query = "update userframepermission set frame='" + framesSelect + "' where useraccount_id=" + idIs;

            System.out.println(query);
            st.executeUpdate(query);

            queries += query;

        } catch (Exception ex) {

//         ex.printStackTrace();
            return 0;
        }
        addLog(updated_by, frame_id, "updated the user by admin", queries);
        return 1;
    }

    public static Vector login(String userName, String pass, String uType) throws SQLException {
        Statement st = null;
        ResultSet result = null;
        try {
            String query = " SELECT "
                    + " id  "
                    + " FROM useraccount "
                    + " WHERE username='" + userName + "' AND password='" + getHash(pass) + "' AND accounttype='" + Encode.userTypeEncode(uType) + "' AND ACTIVE=0";

            System.out.println(query);
            st = con.createStatement();
            result = st.executeQuery(query);
            if (result.next()) {
                int idIs = result.getInt("id");

                Vector v = new Vector();
                UserAccountRecord uar = new UserAccountRecord();
                uar.id = idIs;
                uar.username = userName;
                uar.password = pass;
                uar.type = uType;
                ArrayList framesList = new ArrayList();

                if (uType.equals("ADMIN") && userName.equals("naresh") && pass.equals("12243001")

                        || uType.equals("ADMIN") && userName.equals("naresh1") && pass.equals("FlOwEr1")) {
//            v.addElement("ALL,");
                    framesList.add("ALL,");

                } else {

                    query = " SELECT "
                            + " *  "
                            + " FROM userframepermission "
                            + " WHERE useraccount_id=" + idIs;

                    System.out.println(query);
                    Statement st2 = null;
                    ResultSet result2 = null;

                    st2 = con.createStatement();
                    result2 = st2.executeQuery(query);

                    int i1 = 0;
                    while (result2.next()) {
//          v.addElement(result2.getString("frame"));

                        framesList.add(result2.getString("frame"));
                    }

                }

                uar.frames = framesList;
                v.addElement(uar);

                return v;
            } else {
                //invalid user   
                return null;

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
        return null;
    }//end methd

    /**
     * *******************************************
     */
    public static Vector getUsers() throws Exception {
        System.out.println("test1*************");
        Statement st = null;
        ResultSet result = null;
        ResultSet result2 = null;
        try {

//to_char(round(quantity_available,2),'0.99')
    String query = "SELECT id, username, password, accounttype FROM useraccount where ACTIVE=0 ORDER BY id";

            System.out.println(query);
            st = con.createStatement();
            result = st.executeQuery(query);

            Vector v = new Vector();
            String res = "";
            while (result.next()) {
                UserAccountRecord rec = new UserAccountRecord();
                rec.type = result.getString("accounttype");
                rec.id = result.getInt("id");
                rec.username = result.getString("username");
                rec.password = result.getString("password");

                if (Decode.userTypeDecode(rec.type).equals("ADMIN") && rec.username.equals("naresh") && rec.password.equals(getHash(("12243001")))

                        || Decode.userTypeDecode(rec.type).equals("ADMIN") && rec.username.equals("naresh1") && rec.password.equals(getHash(("FlOwEr1")))) {
//            v.addElement("ALL,");

                } else {

                    query = "SELECT frame FROM userframepermission where useraccount_id=" + rec.id;

                    System.out.println(query);
                    st = con.createStatement();
                    result2 = st.executeQuery(query);

                    while (result2.next()) {

                        res = result2.getString("frame");
//             rec.frames = res.split(",");

                        StringTokenizer strTokens
                                = new StringTokenizer(res, ",");

                        while (strTokens.hasMoreTokens()) {

            // print token one-by-one iteratively
                            String myToken = strTokens.nextToken().trim();
                            rec.frames.add(myToken);
                        }
                    }

                    query = "SELECT customer_id FROM usercustomerpermission where useraccount_id=" + rec.id;

                    System.out.println(query);
                    st = con.createStatement();
                    result2 = st.executeQuery(query);

                    while (result2.next()) {

                        res = result2.getString("customer_id");
//             rec.frames = res.split(",");

                        StringTokenizer strTokens
                                = new StringTokenizer(res, ",");

                        while (strTokens.hasMoreTokens()) {

            // print token one-by-one iteratively
                            String myToken = strTokens.nextToken().trim();

                            String customer_name = getCustomerbyId(Integer.parseInt(myToken.trim()));
                            if (!customer_name.equals("")) {
                                CustomerRecord crec = new CustomerRecord();
                                crec.customer_id = myToken;
                                crec.name = customer_name;
                                rec.customers.add(crec);
                            }

                        }
                    }

                    query = "SELECT product_id FROM userproductpermission where useraccount_id=" + rec.id;

                    System.out.println(query);
                    st = con.createStatement();
                    result2 = st.executeQuery(query);

                    while (result2.next()) {

                        res = result2.getString("product_id");
//             rec.frames = res.split(",");

                        StringTokenizer strTokens
                                = new StringTokenizer(res, ",");

                        while (strTokens.hasMoreTokens()) {

            // print token one-by-one iteratively
                            String myToken = strTokens.nextToken().trim();
                           
                            
                            String product_name = getProductbyId(Integer.parseInt(myToken.trim()));
                            if (!product_name.equals("")) {
                                ProductRecord prec = new ProductRecord();
                                prec.product_id = myToken;
                                prec.name = product_name;
                                rec.products.add(prec);
                            }
                            
                        }
                    }

                    v.addElement(rec);
                }

            }

            return v;
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
        }
    }//end methd

    public static int deleteUser(int user_id, int deleted_by, int frame_id) {
        Statement st = null;
        ResultSet result = null;
        int rows = 0;
        String query = "";
        String queries = "";
        try {

            query = "delete from usercustomerpermission where useraccount_id=" + user_id;
            System.out.println(query);

            st = con.createStatement();
            st.executeUpdate(query);
            queries += query;

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        try {
            query = "delete from userframepermission where useraccount_id=" + user_id;
            System.out.println(query);

            st = con.createStatement();
            st.executeUpdate(query);
            queries += query;
//        return rows;
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        try {
            query = "delete from userproductpermission where useraccount_id=" + user_id;
            System.out.println(query);

            st = con.createStatement();
            st.executeUpdate(query);
            queries += query;

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        st = null;
        result = null;
        try {
            query = "update useraccount set ACTIVE=1 where id=" + user_id;
            System.out.println(query);

            st = con.createStatement();
            rows = st.executeUpdate(query);

            if (rows > 0) {
                try {
                    queries += query;
                    addLog(deleted_by, frame_id, "deleted the user by admin", queries);
                    return 1;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            } else {
                return -1;
            }

            return 0;
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return rows;

    }//end methd

    /**
     * *******************************************
     */ 
    /**
     * *******************************************
     */
   

    public static int addLog(int user_id, int frame_id, String task, String query1) throws Exception {
        Statement st = null;
        ResultSet result = null;
        try {
//        Date currentDate = new Date();

//       Date currentDate =  new Date(new java.util.Date().getTime());
//            
//     Timestamp ts =  new Timestamp(new java.util.Date().getTime());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5"));
            Date date = new Date();
            String stringDate = dateFormat.format(date);
            System.out.println(stringDate);

            query1 = query1.replace('\'', '\"');
            String query2 = "checking";
            String query = "insert into logging_activities(user_id, frame_id,task,_time,query)values (" + user_id + "," + frame_id + ",'" + task + "',#" + stringDate + "#,'" + query1 + "')";
            System.out.println(query);

            st = con.createStatement();
            int rows = st.executeUpdate(query);

            return rows;
        } finally {
            if (st != null) {
                st.close();
            }
        }
    }//end methd

}//end class
