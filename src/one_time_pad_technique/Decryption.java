/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one_time_pad_technique;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Abuelhassan
 */
public class Decryption extends javax.swing.JFrame {

    /**
     * Creates new form ceaser_encryption
     */
    public Decryption() {
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

        jPanel1 = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        encrypt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        key = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        message = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Decrypt by One Time pad Technique");
        setResizable(false);

        jPanel1.setLayout(null);

        back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        back.setText("Back");
        back.setFocusPainted(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back);
        back.setBounds(380, 300, 120, 60);

        encrypt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        encrypt.setText("Decrypt");
        encrypt.setFocusPainted(false);
        encrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptActionPerformed(evt);
            }
        });
        jPanel1.add(encrypt);
        encrypt.setBounds(90, 300, 120, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Enter Your Key");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 130, 271, 40);

        key.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        key.setForeground(new java.awt.Color(51, 51, 255));
        key.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyActionPerformed(evt);
            }
        });
        key.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                keyKeyTyped(evt);
            }
        });
        jPanel1.add(key);
        key.setBounds(20, 180, 550, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/one_time_pad_technique/one_time_pad.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 240, 590, 220);

        message.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        message.setForeground(new java.awt.Color(51, 51, 255));
        message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageActionPerformed(evt);
            }
        });
        message.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                messageKeyTyped(evt);
            }
        });
        jPanel1.add(message);
        message.setBounds(20, 70, 550, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Enter Your Message to Decrypt ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 573, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        one_time_pad_encryption on = new one_time_pad_encryption();
        on.setSize(580, 463);
        on.setLocation(400, 150);
        on.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed
    private int generate() {
        Random r = new Random();
        int Low = 32;
        int High = 58;
        int Result = 0;
        Result = r.nextInt(High - Low) + Low;
        return Result;
    }
    private void encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptActionPerformed
        try {
            String msg = message.getText();
            String check = key.getText();

            if (!msg.isEmpty()) {
                if (!check.isEmpty()) {
                    if (check.length() == msg.length() * 2) {
                        if ((check.length() % 2) == 0) {
                            ArrayList<String> splits = new ArrayList();
                            ArrayList<Integer> orginal = new ArrayList();
                            ArrayList<String> orginal_inString = new ArrayList();
                            byte[] bytes = msg.getBytes("US-ASCII");
                            for (int i = 0; i < check.length(); i += 2) {
                                if (i != check.length()) {
                                    splits.add(check.substring(i, i + 2));
                                }
                            }
                            for (int h = 0; h < splits.size(); h++) {
                                orginal.add(Integer.parseInt(splits.get(h)) ^ bytes[h]);
                            }
                            for (int j = 0; j < orginal.size(); j++) {
                                String valueOf = String.valueOf(Character.toChars(orginal.get(j)));
                                orginal_inString.add(valueOf);
                            }
                            StringBuilder builder = new StringBuilder();
                            for (String value : orginal_inString) {
                                builder.append(value);
                            }
                            String cipher_text = builder.toString();
                            JOptionPane.showMessageDialog(null, "<html><body>Your Orginal message is : <p style='width: 200px;'>" + cipher_text + "</p></body></html>", "orginal message", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter valid key", "empty input", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter valid key", "empty input", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter your key", "empty input", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter your message to encrypt", "empty input", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid message", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Decryption.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_encryptActionPerformed

    private void keyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyKeyTyped
        int length = key.getText().length();
        if (length >= 2000) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "max message input is 2000 numbers", "Error", JOptionPane.ERROR_MESSAGE);

        }
        char c = evt.getKeyChar();
        try {
            if (c == KeyEvent.VK_SPACE) {
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(null, "Spaces are not allowed", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_ENTER)) {
                    getToolkit().beep();
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Please enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid message", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_keyKeyTyped

    private void keyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyActionPerformed
        key.setTransferHandler(null);
    }//GEN-LAST:event_keyActionPerformed

    private void messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageActionPerformed

    }//GEN-LAST:event_messageActionPerformed

    private void messageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageKeyTyped
        int length = message.getText().length();
        if (length >= 1000) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "max message input is 1000 letter", "Error", JOptionPane.ERROR_MESSAGE);

        }
        char c = evt.getKeyChar();
        try {
            if (c == KeyEvent.VK_SPACE) {
                getToolkit().beep();
                evt.consume();
                JOptionPane.showMessageDialog(null, "Spaces are not allowed", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_ENTER)) {
                    getToolkit().beep();
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Please enter only letters", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid message", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_messageKeyTyped

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
            java.util.logging.Logger.getLogger(Decryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Decryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Decryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Decryption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Decryption().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton encrypt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField key;
    private javax.swing.JTextField message;
    // End of variables declaration//GEN-END:variables
}
