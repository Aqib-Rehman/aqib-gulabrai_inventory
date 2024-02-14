package project;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author JAY KUMAR
 */
public class LoginFrame extends javax.swing.JFrame {

    public LoginFrame() {
        initComponents();
    }

    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
 
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

//        setSize(new java.awt.Dimension(662, 554));
         this.getContentPane().setLayout(null);
 this.setResizable(false);
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(46, 22, 48, 14);
        getContentPane().add(usernameTextField);
        usernameTextField.setBounds(104, 19, 186, 20);

        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(46, 67, 46, 14);

        loginButton.setText("LOG IN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton);
        loginButton.setBounds(46, 95, 244, 48);

        errorLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(errorLabel);
        errorLabel.setBounds(46, 11, 244, 0);

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(passwordField);
        passwordField.setBounds(102, 64, 188, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try{
            login();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error Occured..!\n"+ex);
            ex.printStackTrace(System.err);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        try{
            login();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error Occured..!\n"+ex);
            ex.printStackTrace(System.err);
        }
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void login()throws Exception{
        String userName = usernameTextField.getText();
        String password = passwordField.getText(); 
		if(userName.equals("naresh") && ( password.equals("12243001") || password.equals("FlOwEr1") )  ){
			Main.main(null);
			setVisible(false);
		}
		
    }

  //  @Override
    public void setVisible(boolean b) {
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
        if(b){
            usernameTextField.setText("");
            passwordField.setText("");
            errorLabel.setText("");
        }
    }
    
    
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
               LoginFrame lf = new LoginFrame();
              
               lf.setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
