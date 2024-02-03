package project;

import java.awt.*;
import javax.swing.*;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class PageSetup extends JFrame {
  JLabel jLabel1 = new JLabel();

  public PageSetup() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    jLabel1.setFont(new java.awt.Font("Dialog", 1, 16));
    jLabel1.setText("Page Setup");
    jLabel1.setBounds(new Rectangle(170, 18, 129, 20));
    this.getContentPane().setLayout(null);
    this.getContentPane().add(jLabel1, null);
  }
}