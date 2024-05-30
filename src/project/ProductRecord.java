package project;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class ProductRecord {
  public String sno;

  public String product_id;
  public String name;
  public String measurement_unit;
  public String quantity_available;
  public String company;
  public String product_value;

  public String remarks;

  
  
  public String toString() {
    return name;
  }
}//end class