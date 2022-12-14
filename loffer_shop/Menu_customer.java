
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loffer_shop;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JOptionPane;
import AppPackage.AnimationClass;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Master
 */
public class Menu_customer extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    int mouseX;
    int mouseY;
    Connection coon;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String id;
    String tp;
    String ad;
    String name;
    public Menu_customer() {
        initComponents();coon=DBConnection.connect();
        autoId();
        this.setBackground(new Color(0,0,0,0));
        jButton5.setBackground(new Color(176,234,255,150));
        jButton4.setBackground(new Color(176,234,255,150));
        jButton1.setBackground(new Color(176,234,255,150));
        jButton2.setBackground(new Color(176,234,255,150));
        jButton6.setBackground(new Color(176,234,255,150));
        ClickMenu.setVisible(false);
        ClickStock.setVisible(false);
        ClickAddItem.setVisible(false);
        ClickSell.setVisible(true);
        ClickReport.setVisible(false);
        tableLoad();
    }
    
       private void clearData(){
        autoId();
        txtsearch.setText("");
        txtname.setText("");
        txttel.setText("");
        txtad.setText(""); 
    }
    private void itemload (){
     try{
            String sql="SELECT `cid`, `customer_name`, `Tp_Number`, `address_customer` FROM `customer` WHERE cid='"+txtsearch.getText()+"'";
            pst=(PreparedStatement) coon.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                txtid.setText(rs.getString("cid"));
                txtname.setText(rs.getString("customer_name"));
                txttel.setText(rs.getString("Tp_Number"));
                txtad.setText(rs.getString("address_customer"));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }    
  private void autoId(){
        try{
            String sql="SELECT `cid` FROM `customer` ORDER BY cid DESC LIMIT 1 ";
            pst = (PreparedStatement) coon.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String rnno=rs.getString("cid");
                int co=rnno.length();
                String txt = rnno.substring(0, 3);
                String num=rnno.substring(3, co);
                int n=Integer.parseInt(num);
                n++;
                String snum=Integer.toString(n);
                String ftext=txt+snum;
                txtid.setText(ftext);
            }
            else{
                txtid.setText("CTD1000");
            }
        }catch(NumberFormatException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
  private void getdata(){
        name = txtname.getText();
        tp = txttel.getText();
        id = txtid.getText();
        ad= txtad.getText();
    }
  private void tableLoad(){
        try{
            String sql ="SELECT `cid`, `customer_name`, `Tp_Number`, `address_customer` FROM `customer`";
            pst = (PreparedStatement) coon.prepareStatement(sql);
            rs=pst.executeQuery();
            Customer.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
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
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txttel = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtad = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Customer = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        NameProduct = new javax.swing.JLabel();
        Movement = new javax.swing.JLabel();
        CloseP = new javax.swing.JLabel();
        ClickMenu = new javax.swing.JLabel();
        MainMenu = new javax.swing.JLabel();
        ClickStock = new javax.swing.JLabel();
        MainStock = new javax.swing.JLabel();
        ClickAddItem = new javax.swing.JLabel();
        MainAddItem = new javax.swing.JLabel();
        ClickSell = new javax.swing.JLabel();
        MainSell = new javax.swing.JLabel();
        ClickReport = new javax.swing.JLabel();
        MainReportList = new javax.swing.JLabel();
        Menu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        name1.setForeground(new java.awt.Color(255, 102, 102));
        getContentPane().add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 160, 60));

        jPanel1.setBackground(new java.awt.Color(235, 248, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jButton6.setForeground(new java.awt.Color(153, 0, 255));
        jButton6.setText("Go Back your Sell");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 530, -1, -1));

        jPanel2.setBackground(new java.awt.Color(223, 248, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("ID :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 40, -1));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("T.P Number :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        txtname.setBackground(new java.awt.Color(235, 248, 255));
        txtname.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtname.setForeground(new java.awt.Color(255, 153, 153));
        jPanel2.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 210, -1));

        txttel.setBackground(new java.awt.Color(235, 248, 255));
        txttel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txttel.setForeground(new java.awt.Color(255, 153, 153));
        txttel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelKeyTyped(evt);
            }
        });
        jPanel2.add(txttel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 210, -1));

        jButton5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(153, 0, 255));
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 255));
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, -1));

        jButton2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 0, 255));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        jButton4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(153, 0, 255));
        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        txtad.setBackground(new java.awt.Color(235, 248, 255));
        txtad.setColumns(20);
        txtad.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        txtad.setForeground(new java.awt.Color(255, 153, 153));
        txtad.setRows(5);
        jPanel2.add(txtad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 220, 110));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setText("Address : ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        txtid.setBackground(new java.awt.Color(235, 248, 255));
        txtid.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtid.setForeground(new java.awt.Color(255, 153, 153));
        jPanel2.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 210, 30));

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 153));
        jLabel7.setText("Name & Surname :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 390, 360));

        Customer.setBackground(new java.awt.Color(223, 248, 255));
        Customer.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        Customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Customer Name", "T.P Number", "Address"
            }
        ));
        Customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Customer);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 480, 420));

        jPanel3.setBackground(new java.awt.Color(223, 248, 255));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setText("Search ID :");

        txtsearch.setBackground(new java.awt.Color(235, 248, 255));
        txtsearch.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtsearch.setForeground(new java.awt.Color(255, 153, 153));
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("Customers Info :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 103, 390, 90));

        jPanel4.setBackground(new java.awt.Color(235, 248, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NameProduct.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameProduct.setForeground(new java.awt.Color(255, 153, 102));
        NameProduct.setText("Daeng Gi Meori DLAESOO");
        jPanel4.add(NameProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 469, 55));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 860, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 910, 610));

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
        getContentPane().add(Movement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 40));

        CloseP.setMinimumSize(new java.awt.Dimension(30, 14));
        CloseP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClosePMouseClicked(evt);
            }
        });
        getContentPane().add(CloseP, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 0, 40, 30));

        ClickMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loffer/MainMenu.jpg"))); // NOI18N
        getContentPane().add(ClickMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, 60));

        MainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainMenuMouseClicked(evt);
            }
        });
        getContentPane().add(MainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 290, 70));

        ClickStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loffer/MainStock.jpg"))); // NOI18N
        getContentPane().add(ClickStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 280, 60));

        MainStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainStockMouseClicked(evt);
            }
        });
        getContentPane().add(MainStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 290, 70));

        ClickAddItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loffer/MainAddItem.jpg"))); // NOI18N
        getContentPane().add(ClickAddItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 290, 60));

        MainAddItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainAddItemMouseClicked(evt);
            }
        });
        getContentPane().add(MainAddItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 290, 70));

        ClickSell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loffer/MainSell.jpg"))); // NOI18N
        getContentPane().add(ClickSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 280, 60));

        MainSell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainSellMouseClicked(evt);
            }
        });
        getContentPane().add(MainSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 290, 70));

        ClickReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loffer/MainReportList.jpg"))); // NOI18N
        getContentPane().add(ClickReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 280, 60));

        MainReportList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainReportListMouseClicked(evt);
            }
        });
        getContentPane().add(MainReportList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 290, 80));

        Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loffer/Menu.jpg"))); // NOI18N
        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MovementMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovementMouseDragged
        // TODO add your handling code here:
        int movementX = evt.getXOnScreen();
        int movementY = evt.getYOnScreen();
        this.setLocation(movementX-mouseX, movementY-mouseY);
    }//GEN-LAST:event_MovementMouseDragged

    private void MovementMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovementMousePressed
        // TODO add your handling code here:
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_MovementMousePressed

    private void ClosePMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClosePMouseClicked
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Press Yes to GoBack Program Or Press No to Cancle", "Are you Sure?",dialogButton);
        if(dialogResult == 0) {
            Menu_MSell Main=new Menu_MSell();
            Main.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_ClosePMouseClicked

    private void MainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainMenuMouseClicked
        // TODO add your handling code here:
        Menu Main=new Menu();
        Main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MainMenuMouseClicked

    private void MainAddItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainAddItemMouseClicked
        // TODO add your handling code here:
        Menu_AddItem Main=new Menu_AddItem();
        Main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MainAddItemMouseClicked

    private void MainSellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainSellMouseClicked
        // TODO add your handling code here:
        Menu_MSell Main=new Menu_MSell();
        Main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MainSellMouseClicked

    private void MainReportListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainReportListMouseClicked
        // TODO add your handling code here:
        Menu_ReportList Main=new Menu_ReportList();
        Main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MainReportListMouseClicked

    private void MainStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainStockMouseClicked
        // TODO add your handling code here:
        Menu_Stock Main=new Menu_Stock();
        Main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MainStockMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //delete btn code

        String id = txtsearch.getText();
        try {
            Statement s = DBConnection.connect().createStatement();
            s.executeUpdate("DELETE FROM customer WHERE cid = '"+id+"'");
            JOptionPane.showMessageDialog(null, "Dtata Deleted");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e);
        }
        tableLoad();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // update btn code
        getdata();
        try {
            Statement s = DBConnection.connect().createStatement();
            s.executeUpdate(" UPDATE customer SET customer_name ='"+name+"' ,Tp_Number ='"+tp+"',address_customer ='"+ad+"' WHERE cid = '"+id+"' ");
            JOptionPane.showMessageDialog(null, "Dtata Updated");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        tableLoad();
        clearData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        getdata();
        try {
            Statement s = DBConnection.connect().createStatement();
            s.executeUpdate(" INSERT INTO customer (cid,customer_name,Tp_Number,address_customer) VALUES ('"+id+"','"+name+"','"+tp+"','"+ad+"')");
            clearData();
            JOptionPane.showMessageDialog(null, "Dtata saved");
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e);
        }
        tableLoad();
        clearData();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerMouseClicked
        // mouse clk & get data to textfeld
        int r = Customer.getSelectedRow();
        String id = Customer.getValueAt(r, 0).toString();
        String name = Customer.getValueAt(r, 1).toString();
        String tp = Customer.getValueAt(r, 2).toString();
        String ad=Customer.getValueAt(r, 3).toString();
        txtid.setText(id);
        txtsearch.setText(id);
        txtname.setText(name);
        txttel.setText(tp);
        txtad.setText(ad);
    }//GEN-LAST:event_CustomerMouseClicked

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        if(txtsearch.getText().length()==7){
            itemload();
        } 
        else if(txtsearch.getText().length()>7){
            txtsearch.setText("CTD1000");
             JOptionPane.showMessageDialog(null,"Please Checked your requirement,Start at CTD1000-CTDXXXX");
        }
    }//GEN-LAST:event_txtsearchKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        clearData();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
            Menu_MSell Main=new Menu_MSell();
            Main.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txttelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE))
        {
            txttel.getText();
        }
        else {
            txttel.setText("");
            JOptionPane.showMessageDialog(null, "Must be Number");
        }
    }//GEN-LAST:event_txttelKeyTyped

    private void txttelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelKeyReleased
        // TODO add your handling code here:
        
        if(txttel.getText().length()>10){
            txttel.setText("0");
             JOptionPane.showMessageDialog(null,"Please Checked your requirement,At 0X-XXXX-XXX");
        }
    }//GEN-LAST:event_txttelKeyReleased

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
            java.util.logging.Logger.getLogger(Menu_customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Menu_customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ClickAddItem;
    private javax.swing.JLabel ClickMenu;
    private javax.swing.JLabel ClickReport;
    private javax.swing.JLabel ClickSell;
    private javax.swing.JLabel ClickStock;
    private javax.swing.JLabel CloseP;
    private javax.swing.JTable Customer;
    private javax.swing.JLabel MainAddItem;
    private javax.swing.JLabel MainMenu;
    private javax.swing.JLabel MainReportList;
    private javax.swing.JLabel MainSell;
    private javax.swing.JLabel MainStock;
    private javax.swing.JLabel Menu;
    private javax.swing.JLabel Movement;
    private javax.swing.JLabel NameProduct;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JLabel name1 = new javax.swing.JLabel();
    private javax.swing.JTextArea txtad;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
