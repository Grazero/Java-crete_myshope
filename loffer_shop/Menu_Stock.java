/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loffer_shop;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Master
 */
public class Menu_Stock extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    int mouseX;
    int mouseY;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String iid;
    String name1;
    String category;
    String serialno;
    String bPrice;
    String sPrice;
    String noofitem;
    Connection con;
    
    private ImageIcon format=null;
    String fname=null;
    int s=0;
    byte[] pimage=null;
    
    public Menu_Stock() {
        initComponents();
        con=DBConnection.connect();
        this.setBackground(new Color(0,0,0,0));
        ClickMenu.setVisible(false);
        ClickStock.setVisible(true);
        ClickAddItem.setVisible(false);
        ClickSell.setVisible(false);
        ClickReport.setVisible(false);
        tableLoad();
    }
    public ImageIcon resizeImage(String imagePatch,byte[] pic){
         ImageIcon myImage=null;
         if(imagePatch !=null)
         {
             myImage= new ImageIcon(imagePatch);
         }else{
             myImage=new ImageIcon(pic);
         }
         Image img=myImage.getImage();
         Image img2=img.getScaledInstance(lblimage.getHeight(),lblimage.getWidth(),Image.SCALE_SMOOTH);
         ImageIcon image=new ImageIcon(img2);
         return image;
     }
     private void tableLoad(){
        try{
            String sql ="SELECT `item_id`, `item_name`, `category`, `serial_no`, `buy_price`, `sale_price`, `no_of_items`, `image` FROM `stock`";
            pst = (PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery();
            tblstock.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void itemload (){
     try{
            String sql="SELECT `item_id`, `item_name`, `category`, `serial_no`, `sale_price`, `no_of_items`, `image` FROM `stock` WHERE item_id='"+txtid.getText()+"'";
            pst=(PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                txtid.setText(rs.getString("item_id"));
                txtname.setText(rs.getString("item_name"));
                txtserialno.setText(rs.getString("serial_no"));
                txtprice.setText(rs.getString("sale_price"));
                txtcategory.setText(rs.getString("category"));
                byte[] imagedata=rs.getBytes("image");
                format=new ImageIcon(imagedata);
                Image mm=format.getImage();
                Image img2=mm.getScaledInstance(lblimage.getWidth(),lblimage.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon image=new ImageIcon(img2);
                lblimage.setIcon(image);
            }
        }
        catch(SQLException e){
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
        jPanel2 = new javax.swing.JPanel();
        NameProduct = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtserialno = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txtcategory = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblimage = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblstock = new javax.swing.JTable();
        Movement = new javax.swing.JLabel();
        ClickMenu = new javax.swing.JLabel();
        MainReportList = new javax.swing.JLabel();
        ClickSell = new javax.swing.JLabel();
        MainAddItem = new javax.swing.JLabel();
        ClickAddItem = new javax.swing.JLabel();
        MainMenu = new javax.swing.JLabel();
        MainSell = new javax.swing.JLabel();
        ClickReport = new javax.swing.JLabel();
        ClickStock = new javax.swing.JLabel();
        MainStock = new javax.swing.JLabel();
        Menu = new javax.swing.JLabel();
        CloseP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(222, 241, 252));
        jPanel1.setPreferredSize(new java.awt.Dimension(920, 610));

        jPanel2.setBackground(new java.awt.Color(235, 248, 255));

        NameProduct.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameProduct.setForeground(new java.awt.Color(255, 153, 102));
        NameProduct.setText("Daeng Gi Meori DLAESOO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(NameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NameProduct)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(235, 248, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("Item Id");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 64, 33));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Item Name");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, -1, 33));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("Serial No");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 108, -1, 33));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setText("Price");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 159, 64, 33));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setText("Category");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 33));

        txtid.setEditable(false);
        txtid.setBackground(new java.awt.Color(235, 248, 255));
        txtid.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtid.setForeground(new java.awt.Color(255, 153, 153));
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidKeyReleased(evt);
            }
        });
        jPanel3.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 12, 330, -1));

        txtname.setEditable(false);
        txtname.setBackground(new java.awt.Color(235, 248, 255));
        txtname.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtname.setForeground(new java.awt.Color(255, 153, 153));
        jPanel3.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 59, 330, -1));

        txtserialno.setEditable(false);
        txtserialno.setBackground(new java.awt.Color(235, 248, 255));
        txtserialno.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtserialno.setForeground(new java.awt.Color(255, 153, 153));
        jPanel3.add(txtserialno, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 109, 330, -1));

        txtprice.setEditable(false);
        txtprice.setBackground(new java.awt.Color(235, 248, 255));
        txtprice.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtprice.setForeground(new java.awt.Color(255, 153, 153));
        jPanel3.add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 160, 330, -1));

        txtcategory.setEditable(false);
        txtcategory.setBackground(new java.awt.Color(235, 248, 255));
        txtcategory.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtcategory.setForeground(new java.awt.Color(255, 153, 153));
        jPanel3.add(txtcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 211, 330, -1));

        jPanel4.setBackground(new java.awt.Color(235, 248, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblimage.setToolTipText("");
        lblimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(lblimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 190, 168));

        jPanel9.setBackground(new java.awt.Color(222, 241, 252));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 102));
        jLabel13.setText("Clear");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 110, -1));

        txtsearch.setBackground(new java.awt.Color(235, 248, 255));
        txtsearch.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtsearch.setForeground(new java.awt.Color(255, 153, 153));
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        jPanel4.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 200, 230, 40));

        tblstock.setBackground(new java.awt.Color(235, 248, 255));
        tblstock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblstock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblstockMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblstock);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        name.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        name.setForeground(new java.awt.Color(255, 102, 102));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 160, 60));

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

        ClickMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loffer/MainMenu.jpg"))); // NOI18N
        getContentPane().add(ClickMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, 60));

        MainReportList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainReportListMouseClicked(evt);
            }
        });
        getContentPane().add(MainReportList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 290, 80));

        ClickSell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loffer/MainSell.jpg"))); // NOI18N
        getContentPane().add(ClickSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 280, 60));

        MainAddItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainAddItemMouseClicked(evt);
            }
        });
        getContentPane().add(MainAddItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 290, 70));

        ClickAddItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loffer/MainAddItem.jpg"))); // NOI18N
        getContentPane().add(ClickAddItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 290, 60));

        MainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainMenuMouseClicked(evt);
            }
        });
        getContentPane().add(MainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 290, 70));

        MainSell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainSellMouseClicked(evt);
            }
        });
        getContentPane().add(MainSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 290, 70));

        ClickReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loffer/MainReportList.jpg"))); // NOI18N
        getContentPane().add(ClickReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 280, 60));

        ClickStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loffer/MainStock.jpg"))); // NOI18N
        getContentPane().add(ClickStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 280, 60));

        MainStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainStockMouseClicked(evt);
            }
        });
        getContentPane().add(MainStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 290, 70));

        Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Loffer/Menu.jpg"))); // NOI18N
        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));

        CloseP.setMinimumSize(new java.awt.Dimension(30, 14));
        CloseP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClosePMouseClicked(evt);
            }
        });
        getContentPane().add(CloseP, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 0, 40, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyReleased
        // TODO add your handling code here:
        itemload();
    }//GEN-LAST:event_txtidKeyReleased

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
        txtid.setText("");
        txtname.setText("");
        txtserialno.setText("");
        txtprice.setText("");
        txtcategory.setText("");
        txtsearch.setText("");
        ImageIcon I = new ImageIcon(getClass().getResource("/Loffer/DefaultImage.jpg"));
        lblimage.setIcon(I);
        tableLoad();
    }//GEN-LAST:event_jPanel9MouseClicked

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        if(txtsearch.getText().length()>0)
        {
            try{
                String sql ="SELECT `item_id`, `item_name`, `category`, `serial_no`, `buy_price`, `sale_price`, `no_of_items`, `image` FROM `stock` where category LIKE '%"+txtsearch.getText()+"%'";
                pst = (PreparedStatement) con.prepareStatement(sql);
                rs=pst.executeQuery();
                if(rs.next()){
                txtid.setText(rs.getString("item_id"));
                txtname.setText(rs.getString("item_name"));
                txtcategory.setText(rs.getString("category"));
                txtserialno.setText(rs.getString("serial_no"));
                txtprice.setText(rs.getString("sale_price"));

                byte[] imagedata=rs.getBytes("image");
                format=new ImageIcon(imagedata);
                Image mm=format.getImage();
                Image img2=mm.getScaledInstance(lblimage.getWidth(),lblimage.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon image=new ImageIcon(img2);
                lblimage.setIcon(image);
            }
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);}
        }
        else{
            tableLoad();
        }
    }//GEN-LAST:event_txtsearchKeyReleased

    private void tblstockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblstockMouseClicked
        // TODO add your handling code here:
        String id;
        DefaultTableModel tmodel=(DefaultTableModel)tblstock.getModel();
        int selectrowindex=tblstock.getSelectedRow();
        id = (tmodel.getValueAt (selectrowindex,0).toString());
        try{
            String sql="SELECT `item_id`, `item_name`, `category`, `serial_no`, `sale_price`, `no_of_items`, `image` FROM `stock` WHERE item_id='"+id+"'";
            pst=(PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                txtid.setText(rs.getString("item_id"));
                txtname.setText(rs.getString("item_name"));
                txtcategory.setText(rs.getString("category"));
                txtsearch.setText(rs.getString("category"));
                txtserialno.setText(rs.getString("serial_no"));
                txtprice.setText(rs.getString("sale_price"));

                byte[] imagedata=rs.getBytes("image");
                format=new ImageIcon(imagedata);
                Image mm=format.getImage();
                Image img2=mm.getScaledInstance(lblimage.getWidth(),lblimage.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon image=new ImageIcon(img2);
                lblimage.setIcon(image);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblstockMouseClicked

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

    private void MainReportListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainReportListMouseClicked
        // TODO add your handling code here:
        Menu_ReportList Main=new Menu_ReportList();
        Main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MainReportListMouseClicked

    private void MainAddItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainAddItemMouseClicked
        // TODO add your handling code here:
        Menu_AddItem Main=new Menu_AddItem();
        Main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MainAddItemMouseClicked

    private void MainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainMenuMouseClicked
        // TODO add your handling code here:
        Menu Main=new Menu();
        Main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MainMenuMouseClicked

    private void MainSellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainSellMouseClicked
        // TODO add your handling code here:
        Menu_MSell Main=new Menu_MSell();
        Main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MainSellMouseClicked

    private void MainStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainStockMouseClicked
        // TODO add your handling code here:
        this.setVisible(true);
    }//GEN-LAST:event_MainStockMouseClicked

    private void ClosePMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClosePMouseClicked
        // TODO add your handling code here:
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Press Yes to Close Program Or Press No to Cancle", "Are you Sure?",dialogButton);
        if(dialogResult == 0) {
            LogIn Main=new LogIn();
            Main.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_ClosePMouseClicked

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
            java.util.logging.Logger.getLogger(Menu_Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Stock().setVisible(true);
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
    private javax.swing.JLabel MainAddItem;
    private javax.swing.JLabel MainMenu;
    private javax.swing.JLabel MainReportList;
    private javax.swing.JLabel MainSell;
    private javax.swing.JLabel MainStock;
    private javax.swing.JLabel Menu;
    private javax.swing.JLabel Movement;
    private javax.swing.JLabel NameProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblimage;
    public static final javax.swing.JLabel name = new javax.swing.JLabel();
    private javax.swing.JTable tblstock;
    private javax.swing.JTextField txtcategory;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtserialno;
    // End of variables declaration//GEN-END:variables
}