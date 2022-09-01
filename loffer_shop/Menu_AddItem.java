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
import java.time.LocalDate;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Master
 */
public class Menu_AddItem extends javax.swing.JFrame {

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
    String date;
    Connection con;
    private ImageIcon format=null;
    String fname=null;
    //int s=0;
    byte[] pimage=null;
    
    public Menu_AddItem() {
        initComponents();
        con=DBConnection.connect();
        autoId();
        autoSId();
        txtname.setText("Dengi Mori");
        txtbprice.requestFocus();
        tableLoad();
        this.setBackground(new Color(0,0,0,0));
        ClickMenu.setVisible(false);
        ClickStock.setVisible(false);
        ClickAddItem.setVisible(true);
        ClickSell.setVisible(false);
        ClickReport.setVisible(false);
    }
    public ImageIcon resizeImage(String imagePatch,byte[] pic){
         ImageIcon myImage;
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
     private void clearData(){
        autoId();
        autoSId();
        txtname.setText("Dengi Mori");
        cmdcategory.setSelectedIndex(0);
        txtbprice.setText("");
        txtsprice.setText("");
        txtnoofitem.setText("");
        ImageIcon I = new ImageIcon(getClass().getResource("/Loffer/DefaultImage.jpg"));
        lblimage.setIcon(I);
    }
    private void getdata(){
        iid=txtid.getText();
        name1=txtname.getText();
        category= cmdcategory.getSelectedItem().toString();
        serialno=txtserialno.getText();
        bPrice=txtbprice.getText();
        sPrice=txtsprice.getText();
        noofitem= txtnoofitem.getText();
        LocalDate ndate =LocalDate.now();
        date =ndate+"";
    }
    private void autoId(){
        try{
            String sql="SELECT `item_id` FROM `stock` ORDER BY item_id DESC LIMIT 1 ";
            pst = (PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String rnno=rs.getString("item_id");
                int co=rnno.length();
                String txt = rnno.substring(0, 3);
                String num= rnno.substring(3, co);
                int n=Integer.parseInt(num);
                n++;
                String snum=Integer.toString(n);
                String ftext=txt+snum;
                txtid.setText(ftext);
            }
            else{
                txtid.setText("ITD1000");
            }
        }catch(NumberFormatException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
        private void autoSId(){
        try{
            String sql="SELECT `serial_no` FROM `stock` ORDER BY serial_no DESC LIMIT 1 ";
            pst = (PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String rnno=rs.getString("serial_no");
                int co=rnno.length();
                String txt = rnno.substring(0, 7);
                String num=rnno.substring(7, co);
                int n=Integer.parseInt(num);
                n++;
                String snum=Integer.toString(n);
                String ftext=txt+snum;
                txtserialno.setText(ftext);
            }
            else{
                txtserialno.setText("DM1000010000");//DM100000100
            }
        }catch(NumberFormatException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void tableLoad(){
        try{
            String sql ="SELECT `item_id`, `item_name`, `category`, `serial_no`, `buy_price`, `sale_price`, `no_of_items`, `image`, `date` FROM `stock`";
            pst = (PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery();
            tbladditem.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void itemload (){
     try{
            String sql="SELECT `item_id`, `item_name`, `category`, `serial_no`, `buy_price`, `sale_price`, `no_of_items`, `image` FROM `stock` WHERE item_id='"+txtid.getText()+"'";
            pst=(PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                txtid.setText(rs.getString("item_id"));
                txtname.setText(rs.getString("item_name"));
                cmdcategory.setSelectedItem(rs.getString("category"));
                txtserialno.setText(rs.getString("serial_no"));
                txtbprice.setText(rs.getString("buy_price"));
                txtsprice.setText(rs.getString("sale_price"));
                txtnoofitem.setText(rs.getString("no_of_items"));
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmdcategory = new javax.swing.JComboBox<>();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtserialno = new javax.swing.JTextField();
        txtbprice = new javax.swing.JTextField();
        txtsprice = new javax.swing.JTextField();
        txtnoofitem = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblimage = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbladditem = new javax.swing.JTable();
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
        jPanel1.setMinimumSize(new java.awt.Dimension(920, 610));
        jPanel1.setPreferredSize(new java.awt.Dimension(920, 610));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(235, 248, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NameProduct.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameProduct.setForeground(new java.awt.Color(255, 153, 102));
        NameProduct.setText("Daeng Gi Meori DLAESOO");
        jPanel2.add(NameProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 450, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 890, -1));

        jPanel3.setBackground(new java.awt.Color(235, 248, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("Item Id");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 64, 33));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Item Name");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 33));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setText("Category");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 89, -1, 33));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("Serial No");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 128, -1, 33));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setText("B Price");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 167, 64, 33));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setText("S Price");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 206, 64, 33));

        jLabel7.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 153));
        jLabel7.setText("No of Item");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 245, -1, 33));

        cmdcategory.setBackground(new java.awt.Color(219, 241, 252));
        cmdcategory.setFont(new java.awt.Font("Tempus Sans ITC", 1, 17)); // NOI18N
        cmdcategory.setForeground(new java.awt.Color(255, 153, 153));
        cmdcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "anti hair loss shampoo 400 ml.", "anti hair loss treatment 400 ml.", "Mist 100ml.", "Nutrient Pack 200ml.", "Set Shampoo 1 & treatment 1 400 ml.", "Set Shampoo 3 & treatment 1 400 ml." }));
        jPanel3.add(cmdcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 91, 320, -1));

        txtid.setBackground(new java.awt.Color(235, 248, 255));
        txtid.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtid.setForeground(new java.awt.Color(255, 153, 153));
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidKeyReleased(evt);
            }
        });
        jPanel3.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 12, 320, -1));

        txtname.setBackground(new java.awt.Color(235, 248, 255));
        txtname.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtname.setForeground(new java.awt.Color(255, 153, 153));
        jPanel3.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 52, 320, -1));

        txtserialno.setBackground(new java.awt.Color(235, 248, 255));
        txtserialno.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtserialno.setForeground(new java.awt.Color(255, 153, 153));
        jPanel3.add(txtserialno, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 129, 320, -1));

        txtbprice.setBackground(new java.awt.Color(235, 248, 255));
        txtbprice.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtbprice.setForeground(new java.awt.Color(255, 153, 153));
        txtbprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbpriceKeyTyped(evt);
            }
        });
        jPanel3.add(txtbprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 168, 320, -1));

        txtsprice.setBackground(new java.awt.Color(235, 248, 255));
        txtsprice.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtsprice.setForeground(new java.awt.Color(255, 153, 153));
        txtsprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtspriceKeyTyped(evt);
            }
        });
        jPanel3.add(txtsprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 207, 320, -1));

        txtnoofitem.setBackground(new java.awt.Color(235, 248, 255));
        txtnoofitem.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtnoofitem.setForeground(new java.awt.Color(255, 153, 153));
        txtnoofitem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnoofitemKeyTyped(evt);
            }
        });
        jPanel3.add(txtnoofitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 246, 320, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, 470, 340));

        jPanel4.setBackground(new java.awt.Color(235, 248, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 296));
        jPanel4.setRequestFocusEnabled(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblimage.setToolTipText("");
        lblimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(lblimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 199, 199));

        jPanel5.setBackground(new java.awt.Color(222, 241, 252));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 102));
        jLabel9.setText("Add");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 11, -1, -1));

        jPanel6.setBackground(new java.awt.Color(222, 241, 252));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 102));
        jLabel10.setText("Update");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 69, -1, -1));

        jPanel7.setBackground(new java.awt.Color(222, 241, 252));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 102));
        jLabel11.setText("Delete");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 127, -1, -1));

        jPanel8.setBackground(new java.awt.Color(222, 241, 252));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 102));
        jLabel12.setText("Clear");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 185, -1, -1));

        jPanel9.setBackground(new java.awt.Color(222, 241, 252));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 102));
        jLabel13.setText("Brows");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
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

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 221, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 74, 390, 340));

        tbladditem.setBackground(new java.awt.Color(235, 248, 255));
        tbladditem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbladditem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbladditemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbladditem);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 900, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 910, 610));

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

        name.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        name.setForeground(new java.awt.Color(255, 102, 102));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 160, 60));

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

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        getdata();
        try{
            String q ="INSERT INTO `stock`(`item_id`, `item_name`, `category`, `serial_no`, `buy_price`, `sale_price`, `no_of_items`, `image`, `date`) VALUES (?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(q);
            pst.setString(1,iid);
            pst.setString(2,name1);
            pst.setString(3,category);
            pst.setString(4,serialno);
            pst.setString(5,bPrice);
            pst.setString(6,sPrice);
            pst.setString(7,noofitem);
            pst.setBytes(8,pimage); 
            pst.setString(9,date);
            pst.execute();tableLoad();
            JOptionPane.showMessageDialog(this, "success");
            clearData();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        try{
            getdata();
            String squpdate ="UPDATE `stock` SET `item_name`=?, `category`=?, `serial_no`=?, `buy_price`=?,`sale_price`=?, `no_of_items`=? ,`date`=? WHERE item_id='"+iid+"'";
            pst= (PreparedStatement) con.prepareStatement(squpdate);
            pst.setString(1,name1);
            pst.setString(2,category);
            pst.setString(3,serialno);
            pst.setString(4,bPrice);
            pst.setString(5,sPrice);
            pst.setString(6,noofitem);
            pst.setString(7,date);
            pst.execute();
            JOptionPane.showMessageDialog(this, "success");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Please Checked your information.");  
        }
        clearData();
        tableLoad();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        try{
            String sql="DELETE FROM `stock` WHERE item_id='"+txtid.getText()+"'";
            pst=(PreparedStatement) con.prepareStatement(sql);
            pst.execute();
            tableLoad();
            JOptionPane.showMessageDialog(this, "success");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        clearData();
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
        JFileChooser fchoser=new JFileChooser();
        fchoser.showOpenDialog(null);
        File f=fchoser.getSelectedFile();
       fname = f.getAbsolutePath();
        ImageIcon micon=new ImageIcon(fname);
        try{
            File image=new File(fname);
            FileInputStream fis=new FileInputStream(image);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] buf=new byte[1024];
            for(int readnum;(readnum=fis.read(buf)) !=-1;){
                baos.write(buf,0,readnum);
            }
            pimage=baos.toByteArray();
            lblimage.setIcon(resizeImage(fname,buf));
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jPanel9MouseClicked

    private void tbladditemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbladditemMouseClicked
        // TODO add your handling code here:
        String id;
        DefaultTableModel tmodel=(DefaultTableModel)tbladditem.getModel();
        int selectrowindex=tbladditem.getSelectedRow();
        id = (tmodel.getValueAt (selectrowindex,0).toString());
        try{
            String sql="SELECT `item_id`, `item_name`, `category`, `serial_no`, `buy_price`, `sale_price`, `no_of_items`, `image` , `date` FROM `stock` WHERE item_id='"+id+"'";
            pst=(PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                txtid.setText(rs.getString("item_id"));
                txtname.setText(rs.getString("item_name"));
                cmdcategory.setSelectedItem(rs.getString("category"));
                txtserialno.setText(rs.getString("serial_no"));
                txtbprice.setText(rs.getString("buy_price"));
                txtsprice.setText(rs.getString("sale_price"));
                txtnoofitem.setText(rs.getString("no_of_items"));

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
    }//GEN-LAST:event_tbladditemMouseClicked

    private void txtidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyReleased
        // TODO add your handling code here:
        if(txtid.getText().length()==7){
        itemload();
        }
    }//GEN-LAST:event_txtidKeyReleased

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
        // TODO add your handling code here:;
        this.setVisible(true);
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
        Menu_Stock Main=new Menu_Stock();
        Main.setVisible(true);
        this.dispose();
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

    private void txtbpriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbpriceKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE)||(vChar== KeyEvent.VK_ENTER))
        {
            txtbprice.getText();
        }
        else {
            txtbprice.setText("");
            JOptionPane.showMessageDialog(null, "Must be Number");
        }
    }//GEN-LAST:event_txtbpriceKeyTyped

    private void txtspriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtspriceKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE)||(vChar== KeyEvent.VK_ENTER))
        {
            txtsprice.getText();
        }
        else {
            txtsprice.setText("");
            JOptionPane.showMessageDialog(null, "Must be Number");
        }
    }//GEN-LAST:event_txtspriceKeyTyped

    private void txtnoofitemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnoofitemKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE))
        {
            txtnoofitem.getText();
        }
        else {
            txtnoofitem.setText("");
            JOptionPane.showMessageDialog(null, "Must be Number");
        }
    }//GEN-LAST:event_txtnoofitemKeyTyped
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
            java.util.logging.Logger.getLogger(Menu_AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_AddItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Menu_AddItem().setVisible(true);
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
    private javax.swing.JComboBox<String> cmdcategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblimage;
    public static final javax.swing.JLabel name = new javax.swing.JLabel();
    private javax.swing.JTable tbladditem;
    private javax.swing.JTextField txtbprice;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnoofitem;
    private javax.swing.JTextField txtserialno;
    private javax.swing.JTextField txtsprice;
    // End of variables declaration//GEN-END:variables
}
