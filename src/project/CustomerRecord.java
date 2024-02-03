package project;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class CustomerRecord {
  public String customer_id;
  public String name;
  public String contact;
  public String customer_type;
  public String address;
  public String remarks;

  public String toString(){
    return name;
  }
}