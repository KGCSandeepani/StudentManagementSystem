/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.design;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import project.controller.LoginController;

/**
 *
 * @author 
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackGround = new javax.swing.JPanel();
        labelExit = new javax.swing.JLabel();
        labelMinimize = new javax.swing.JLabel();
        panelLogin = new javax.swing.JPanel();
        labelPassword = new javax.swing.JLabel();
        passwordFieldPassword = new javax.swing.JPasswordField();
        labelLogin = new javax.swing.JLabel();
        labelUserName = new javax.swing.JLabel();
        textUserName = new javax.swing.JTextField();
        labelBackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelExit.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelExit.setForeground(new java.awt.Color(255, 0, 0));
        labelExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelExit.setText("X");
        labelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelExitMouseClicked(evt);
            }
        });
        panelBackGround.add(labelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, 40, 40));

        labelMinimize.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        labelMinimize.setForeground(new java.awt.Color(255, 255, 255));
        labelMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMinimize.setText("-");
        labelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMinimizeMouseClicked(evt);
            }
        });
        panelBackGround.add(labelMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 40, 40));

        panelLogin.setBackground(new java.awt.Color(153, 153, 255));
        panelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102)));

        labelPassword.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        labelPassword.setText("Password   :");

        passwordFieldPassword.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        passwordFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldPasswordActionPerformed(evt);
            }
        });

        labelLogin.setBackground(new java.awt.Color(255, 255, 255));
        labelLogin.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        labelLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogin.setText("Login");
        labelLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelLogin.setOpaque(true);
        labelLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLoginMouseClicked(evt);
            }
        });

        labelUserName.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        labelUserName.setText("User Name :");

        textUserName.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        textUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUserNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordFieldPassword)
                            .addComponent(textUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUserName)
                    .addComponent(textUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPassword)
                    .addComponent(passwordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        panelBackGround.add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 510, 280));

        labelBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/blue-background-images-10.jpg"))); // NOI18N
        panelBackGround.add(labelBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_labelExitMouseClicked

    private void labelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMinimizeMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_labelMinimizeMouseClicked

    private void labelLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLoginMouseClicked
        loginToFirstPage();
    }//GEN-LAST:event_labelLoginMouseClicked

    private void textUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUserNameActionPerformed
        passwordFieldPassword.requestFocus();
    }//GEN-LAST:event_textUserNameActionPerformed

    private void passwordFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldPasswordActionPerformed
        loginToFirstPage();
    }//GEN-LAST:event_passwordFieldPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelBackGround;
    private javax.swing.JLabel labelExit;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelMinimize;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JPanel panelBackGround;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField passwordFieldPassword;
    private javax.swing.JTextField textUserName;
    // End of variables declaration//GEN-END:variables

    private void loginToFirstPage() {
        String userName=textUserName.getText();
        String password=passwordFieldPassword.getText();
        try {
            boolean loginSystem=LoginController.loginToSystem(userName, password);
            if(loginSystem){
                new FirstPage().setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Password and user name are wrong. Please enter correct passward and user name.");
                passwordFieldPassword.setText("");
                textUserName.setText("");
                textUserName.requestFocus();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
