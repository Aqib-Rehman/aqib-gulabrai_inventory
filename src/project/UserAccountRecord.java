package project;

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
  public String[] frames;

  public String type;
  

  public String toString(){
    return username;
  }
}