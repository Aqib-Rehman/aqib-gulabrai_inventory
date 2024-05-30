package project;

import java.awt.event.ActionEvent;
import java.util.Vector;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class Main {

 public static void main(String args[]){
   Vector v=new Vector();
   v.addElement("ALL,");
    MainFrame mf =  new MainFrame(v);    
        mf.show();
 }
 
 
 public static void main1(Vector v){
     
    MainFrame mf =  new MainFrame(v);    
        mf.show();
 }
 
 
}