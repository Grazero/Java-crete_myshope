/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loffer_shop;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Master
 */
public class Forget extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    int mouseX;
    int mouseY;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Connection con;
    
    public Forget() {
        initComponents();
        con=DBConnection.connect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtemail = new javax.swing.JTextField();
        txtuname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Movement = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 233, 230, 30));
        getContentPane().add(txtuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 230, 30));

        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 130, 50));

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 40, 40));

        Movement.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                MovementMouseDragged(evt);
            }
        });
        Movement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MovementMousePressed(evt);
            }
        });
        getContentPane().add(Movement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loffer/ForgetPassword.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 525));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        LogIn Main=new LogIn();
        Main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void MovementMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovementMousePressed
        // TODO add your handling code here:
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_MovementMousePressed

    private void MovementMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovementMouseDragged
        // TODO add your handling code here:
        int movementX = evt.getXOnScreen();
        int movementY = evt.getYOnScreen();
        this.setLocation(movementX-mouseX, movementY-mouseY);
    }//GEN-LAST:event_MovementMouseDragged

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        String uname=txtuname.getText();
        String email =txtemail.getText();
        String ps,ps1;
        try{
            String sql="SELECT `user_name`,`email`,`password` FROM `register` WHERE `user_name`='"+txtuname.getText()+"'";
            pst=(PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                ps=(rs.getString("user_name"));
                ps1=(rs.getString("email"));
                if(ps.equals(uname)&&ps1.equals(email)){
                    JOptionPane.showMessageDialog(this,"Your password is "+rs.getString("password"));
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"username or email incorrect");
                }
            }
            else
            {
                 JOptionPane.showMessageDialog(null,"Check Username and email");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(Forget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forget.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forget().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Movement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}