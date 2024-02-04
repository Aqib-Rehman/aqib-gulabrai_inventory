import java.sql.*;
import java.util.*;
import project.DatabaseManager;


/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */
 
 public class UserAccountManager {
	
	public static void main(String args[]){
		DatabaseManager.createUserAccountTable();
		System.out.println(DatabaseManager.getHash("Hello"));
		
	}
 
 }