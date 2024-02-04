package project;
import java.text.SimpleDateFormat;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */


public class DateFormat {

  public static String getCurrentDate(){
	  SimpleDateFormat formatter = new SimpleDateFormat ("dd-MMM-yyyy");
	  java.util.Date currentDate = new java.util.Date();
	  String dateString = formatter.format(currentDate).toUpperCase();

	  return dateString;
  }//end method

  public static String getCurrentDateInUSAFormat(){
	  SimpleDateFormat formatter = new SimpleDateFormat ("MM/dd/yyyy");
	  java.util.Date currentDate = new java.util.Date();
	  String dateString = formatter.format(currentDate);

	  return dateString;
  }//end method

 public static String getCurrentTime(){
	SimpleDateFormat formatter= new SimpleDateFormat ("hh:mm:ss");
	java.util.Date time = new java.util.Date();
	String timeString = formatter.format(time);

	return timeString;
 }//end method

  public static String getDateInUSAFormat(java.sql.Date date){
	  SimpleDateFormat formatter = new SimpleDateFormat ("dd-MMM-yyyy");
	  String dateString = formatter.format(date).toUpperCase();

	  return dateString;
  }//end method


}//end class
