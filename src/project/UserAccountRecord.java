package project;

import java.util.ArrayList;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 3.0
 */

public class UserAccountRecord {
  public String username;

  public int id;
  public String password;
//  public String[] frames;
  public ArrayList frames;
  public ArrayList customers;
  public ArrayList products;
  public String type;
  
  public UserAccountRecord(){
      id=0;
      password=username=type="";
      frames=new ArrayList();
      customers=new ArrayList();
      products=new ArrayList();
  }

  public String toString(){
    return username;
  }
}