/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.UIManager;

/**
 *
 * @author Shady
 */
public class welcome extends javax.swing.JFrame {

    /**
     * Creates new form welcome
     */
    
    String name;
    
    static ArrayList<String> user = new ArrayList<>();
    static ArrayList<String> pass = new ArrayList<>();
    
    public welcome() {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {
            System.out.println("Look and feel");
        }
        this.getContentPane().setSize(800,400);
        this.setResizable(false);
        initComponents();
        jPanelPrompts.setOpaque(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrompts = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblTaken = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        lblBG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SR Poker");
        setMinimumSize(new java.awt.Dimension(622, 361));
        getContentPane().setLayout(null);

        txtUsername.setBackground(java.awt.Color.lightGray);
        txtUsername.setText("Username");

        txtPassword.setBackground(java.awt.Color.lightGray);
        txtPassword.setText("..........");

        javax.swing.GroupLayout jPanelPromptsLayout = new javax.swing.GroupLayout(jPanelPrompts);
        jPanelPrompts.setLayout(jPanelPromptsLayout);
        jPanelPromptsLayout.setHorizontalGroup(
            jPanelPromptsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPromptsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPromptsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsername)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanelPromptsLayout.setVerticalGroup(
            jPanelPromptsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPromptsLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanelPrompts);
        jPanelPrompts.setBounds(150, 220, 220, 120);

        lblTaken.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(lblTaken);
        lblTaken.setBounds(20, 310, 250, 20);

        btnPlay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPlay.setBorderPainted(false);
        btnPlay.setContentAreaFilled(false);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlay);
        btnPlay.setBounds(420, 230, 170, 50);

        btnSignUp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSignUp.setBorderPainted(false);
        btnSignUp.setContentAreaFilled(false);
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignUp);
        btnSignUp.setBounds(400, 280, 220, 50);

        lblBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/welcomeBG.png"))); // NOI18N
        getContentPane().add(lblBG);
        lblBG.setBounds(0, 0, 620, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        new SignUpForm().setVisible(true);
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        
        user.removeAll(user);
        pass.removeAll(pass);
        
        String username = txtUsername.getText(), password = txtPassword.getText();
        File usernames = new File ("usernames.dat"); File passwords = new File ("passwords.dat");     
        
        try
        {
            Scanner userCheck = new Scanner (usernames); Scanner passCheck = new Scanner (passwords);
            while(userCheck.hasNext())
            {
                String thisUser = userCheck.next(); String thisPass = passCheck.next();
                user.add(thisUser);
                pass.add(thisPass);
            }
            
            for(int i = 0; i < user.size(); i++)
            {
                if(username.equalsIgnoreCase(user.get(i)))
                {
                    if(password.equals(methods.decrypt(pass.get(i))))
                    {
                        System.out.println("Login successful.");
                        new board().setVisible(true); this.dispose();
                        break;
                    }                    
                    else
                    {                        
                        lblTaken.setForeground(Color.red); lblTaken.setText("Incorrect username or password."); 
                        break;
                    }
                }
                else if(i + 1 == user.size())
                {
                   lblTaken.setForeground(Color.red); lblTaken.setText("Incorrect username or password.");
                }
            }
            
        }catch(Exception e)
        {
            System.out.println("Error occured: ");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnPlayActionPerformed

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
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JPanel jPanelPrompts;
    private javax.swing.JLabel lblBG;
    private javax.swing.JLabel lblTaken;
    private javax.swing.JPasswordField txtPassword;
    private static javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    public static String getUser()
    {
        return txtUsername.getText();
    }
    
}
