/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel; 
import javax.swing.ViewportLayout;
/**
 *
 * @author Aqib Rehman
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form UsersManagement
     */
     DefaultTableModel model1;
      FramesEntity fe;
     
     
    public Login() {
        
        
        initComponents();
        
         fe = new FramesEntity();
         
         try {
//             java.util.Vector v=
                     DatabaseManager.createUserAccountTable();
             System.out.println("test2");
         } catch (Exception ex) {
             ex.printStackTrace();
         }
         
         
         
//        JCheckBox cb1 = new JCheckBox("CheckBox1 ");
//                                    
//                                    jpanel_checkboxes.add(cb1);
//                                    jpanel_checkboxes.revalidate();
//                        jpanel_checkboxes.repaint();
                        
//                        jlist_checkboxes.setCellRenderer(new CheckboxListCellRenderer());
//                        framesRender();
                       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */ 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_userName = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        combo_uType = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(3);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel3.setText("Username");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 98, -1, -1));

        jLabel4.setText("Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 137, -1, -1));

        jLabel5.setText("User Type");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 175, -1, -1));
        jPanel1.add(txt_userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 95, 132, -1));
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 134, 134, -1));

        combo_uType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ADMIN", "OTHER" }));
        jPanel1.add(combo_uType, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 172, 107, -1));

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jButton2.setText("Close");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 380, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
           String userName = txt_userName.getText();
        String password = new String(txt_password.getPassword());
		if(userName.equals("naresh") && ( password.equals("12243001") || password.equals("FlOwEr1") )  ){
		String[] frames={"all"};	
                    Main.main(frames);
			setVisible(false);
		}
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            throw ex;
//         } catch (InstantiationException ex) {
//        throw ex;
//         } catch (IllegalAccessException ex) {
//        throw ex;
//         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//        throw ex;
//         }
        //</editor-fold>
  
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               Login um = new Login();
               um.framesRender();
//               um.revalidate();
               um.setVisible(true);
            }
        });
    }
    
    public void framesRender(){
     
        
        
//         String[]labels={"a","b","c","d","e"};
//            JCheckBox[]ch=new JCheckBox[labels.length];
         
         List frames = fe.getAllFrames();

            
            
            
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combo_uType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_userName;
    // End of variables declaration//GEN-END:variables
}
