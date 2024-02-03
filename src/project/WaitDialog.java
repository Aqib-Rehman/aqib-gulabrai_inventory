package project;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */




public class WaitDialog extends JDialog {

  private JLabel headingLabel = new JLabel();
  private JLabel heading2Label = new JLabel();
  private JProgressBar progressBar = new JProgressBar();
  private JLabel processLabel = new JLabel();

  private AccountClosingFrame accountClosingFrame;

  public WaitDialog(AccountClosingFrame accountClosingFrame) {
  super(accountClosingFrame,"Please wiat....");
  try {
        jbInit();
  }catch(Exception e) {
      e.printStackTrace();
  }
}//end while.

  private void jbInit() throws Exception {
    headingLabel.setFont(new java.awt.Font("Serif", 1, 35));
    headingLabel.setText("PLEASE WAIT");
    headingLabel.setBounds(new Rectangle(56, 0, 255, 47));

    this.getContentPane().setLayout(null);
    this.getContentPane().setBackground(Color.white);
    heading2Label.setFont(new java.awt.Font("Dialog", 1, 20));
    heading2Label.setText("Preparation of Account Closing");
    heading2Label.setBounds(new Rectangle(30, 39, 308, 39));
    progressBar.setStringPainted(true);
    progressBar.setBounds(new Rectangle(23, 127, 318, 30));
    processLabel.setText("Process");
    processLabel.setBounds(new Rectangle(23, 107, 54, 21));
    this.getContentPane().add(processLabel, null);
    this.getContentPane().add(progressBar, null);
    this.getContentPane().add(headingLabel, null);
    this.getContentPane().add(heading2Label, null);
    this.setBounds(130,150,370,200);
    headingLabel.setForeground(Color.black);

    Border border3 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,Color.darkGray,new Color(58, 110, 165));
    Border border4 = BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.gray,Color.darkGray,new Color(58, 110, 165)),border3);
    progressBar.setBorder(border4);

  }//////end constructor().

  public void setMaximunProcessValue(int max){
    progressBar.setMaximum(max);
}
public void setMinimumProcessValue(int min){
    progressBar.setMinimum(min);
}
  public void setProcessValue(int num){
   progressBar.setValue(num);
 }///end setStatisticalReport() method

// private int getPercentage(int num){
//   int maximum=progressBar.getMaximum();
//   int percent=100*num/maximum;
//   return percent;
// }//////end  getPercentage() method.
}//end class
