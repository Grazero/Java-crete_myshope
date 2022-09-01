/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loffer_shop;
import java.awt.Color;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Master
 */
public class Menu_MSell extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    int mouseX;
    int mouseY;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    Connection con;
    private ImageIcon format=null;
    String fname=null;
    int s=0;
    byte[] pimage=null;
    String sid;
    String iid;
    String uprice;
    String noofitem;
    String totalprice;
    String discount;
    String payable;
    String cash;
    String balance;
    String date;
    public Menu_MSell() {
        initComponents();con=DBConnection.connect();
        autoId();
        this.setBackground(new Color(0,0,0,0));
        Clear.setBackground(new Color(176,234,255,150));
        addcart.setBackground(new Color(176,234,255,150));
        Pay.setBackground(new Color(176,234,255,150));
        ADCS.setBackground(new Color(176,234,255,150));
        ADCS1.setBackground(new Color(176,234,255,150));
        ClickMenu.setVisible(false);
        ClickStock.setVisible(false);
        ClickAddItem.setVisible(false);
        ClickSell.setVisible(true);
        ClickReport.setVisible(false);
        itemload();
    }
    private void itemload (){
     try{
            String sql="SELECT `item_id`, `item_name`, `category`, `serial_no`, `sale_price`, `image` FROM `stock` WHERE item_id='"+txtid.getText()+"'";
            pst=(PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                txtid.setText(rs.getString("item_id"));
                txtname.setText(rs.getString("item_name"));
                cmbcategory.setSelectedItem(rs.getString("category"));
                txtserial_no.setText(rs.getString("serial_no"));
                txtuprice.setText(rs.getString("sale_price"));
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
    private void autoId(){
        try{
            String sql="SELECT `INID` FROM `sales` ORDER BY INID DESC LIMIT 1";
            pst = (PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String rnno=rs.getString("INID");
                int co=rnno.length();
                String txt = rnno.substring(0,4);
                String num=rnno.substring(4, co);
                int n=Integer.parseInt(num);
                n++;
                String snum=Integer.toString(n);
                String ftext=txt+snum;
                lblsid.setText(ftext);
            }
            else{
                lblsid.setText("INID10000");
            }
        }catch(NumberFormatException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void cart_total(){
        int numofrow = jTable1.getRowCount();
        double total = 0.00;
        for (int i = 0; i < numofrow; i++) {
            double value = Double.valueOf(jTable1.getValueAt(i, 6).toString());
            total += value ;
        }
        txttotalamount.setText(Double.toString(total));
   /// total qty count 
        int numofrows = jTable1.getRowCount();
        int totals = 0;
        for (int i = 0; i < numofrows; i++) {
            double values = Double.valueOf(jTable1.getValueAt(i, 4).toString());
            totals += values ;
        }
         T_Quantity.setText(Integer.toString(totals));
    }
    public void Clear(){
        txtid.setText("");
        txtname.setText("");
        txtuprice.setText("");
        txtserial_no.setText("");
        txtQuantity.setText("");
        txttotalPrice.setText("");
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        dt.setRowCount(0);
        txtdiscount.setText("");
        textpayment.setText("");
        textcash.setText("");
        T_Quantity.setText("0");
        txttotalamount.setText("00.00");
        txtbalance.setText("00.00");
        Customer.setText("");
        Number1.setText("");
        C_Address.setText("");
        cmbcategory.setSelectedIndex(0);
        ImageIcon I = new ImageIcon(getClass().getResource("/Loffer/DefaultImage.jpg"));
        lblimage.setIcon(I);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addcart = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        textpayment = new javax.swing.JTextField();
        T_Quantity = new javax.swing.JLabel();
        txtdiscount = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtbalance = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txttotalamount = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        textcash = new javax.swing.JTextField();
        Pay = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblsid = new javax.swing.JLabel();
        lblimage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Customer = new javax.swing.JTextField();
        cmbcategory = new javax.swing.JComboBox<>();
        txttotalPrice = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        txtuprice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtserial_no = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Number1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ADCS1 = new javax.swing.JButton();
        C_Address = new javax.swing.JTextArea();
        ADCS = new javax.swing.JButton();
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
        setSize(new java.awt.Dimension(1350, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(222, 241, 252));
        jPanel1.setPreferredSize(new java.awt.Dimension(920, 610));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(235, 248, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NameProduct.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        NameProduct.setForeground(new java.awt.Color(255, 153, 102));
        NameProduct.setText("Daeng Gi Meori DLAESOO");
        jPanel2.add(NameProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 469, 55));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 880, 50));

        jPanel3.setBackground(new java.awt.Color(235, 248, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(223, 248, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INID", "Item name", "category", "Serial_no", "Quantity", " Unit Price ", "Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 290));

        addcart.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        addcart.setForeground(new java.awt.Color(153, 0, 255));
        addcart.setText("add to cart");
        addcart.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        addcart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcartActionPerformed(evt);
            }
        });
        jPanel3.add(addcart, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 140, 30));

        Clear.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        Clear.setForeground(new java.awt.Color(153, 0, 255));
        Clear.setText("Clear");
        Clear.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        jPanel3.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 90, 30));

        jLabel18.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 153, 153));
        jLabel18.setText("Payment");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        textpayment.setEditable(false);
        textpayment.setBackground(new java.awt.Color(235, 248, 255));
        textpayment.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        textpayment.setForeground(new java.awt.Color(255, 153, 153));
        textpayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textpaymentKeyReleased(evt);
            }
        });
        jPanel3.add(textpayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 120, -1));

        T_Quantity.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        T_Quantity.setForeground(new java.awt.Color(255, 153, 153));
        T_Quantity.setText("0");
        jPanel3.add(T_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 30, -1));

        txtdiscount.setBackground(new java.awt.Color(235, 248, 255));
        txtdiscount.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtdiscount.setForeground(new java.awt.Color(255, 153, 153));
        txtdiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdiscountKeyTyped(evt);
            }
        });
        jPanel3.add(txtdiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 120, -1));

        jPanel5.setBackground(new java.awt.Color(223, 248, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 153, 153));
        jLabel19.setText("Balance");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 81, -1, -1));

        txtbalance.setEditable(false);
        txtbalance.setBackground(new java.awt.Color(235, 248, 255));
        txtbalance.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtbalance.setForeground(new java.awt.Color(255, 153, 153));
        txtbalance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtbalance.setText("00.00");
        jPanel5.add(txtbalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 117, 168, -1));

        jLabel20.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 153, 153));
        jLabel20.setText("Total Amount");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 1, -1, -1));

        txttotalamount.setEditable(false);
        txttotalamount.setBackground(new java.awt.Color(235, 248, 255));
        txttotalamount.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txttotalamount.setForeground(new java.awt.Color(255, 153, 153));
        txttotalamount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttotalamount.setText("00.00");
        jPanel5.add(txttotalamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 37, 168, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 190, 160));

        jLabel15.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 153, 153));
        jLabel15.setText("Discount");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 153, 153));
        jLabel16.setText("Quantity :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 90, -1));

        jLabel21.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 153, 153));
        jLabel21.setText("cash");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        textcash.setBackground(new java.awt.Color(235, 248, 255));
        textcash.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        textcash.setForeground(new java.awt.Color(255, 153, 153));
        textcash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textcashKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textcashKeyTyped(evt);
            }
        });
        jPanel3.add(textcash, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 120, -1));

        Pay.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        Pay.setForeground(new java.awt.Color(153, 0, 255));
        Pay.setText("Pay&Print");
        Pay.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        Pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayActionPerformed(evt);
            }
        });
        jPanel3.add(Pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 110, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 450, 530));

        jPanel4.setBackground(new java.awt.Color(235, 248, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblsid.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblsid.setText("INID");
        jPanel4.add(lblsid, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 140, 57));

        lblimage.setToolTipText("");
        lblimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(lblimage, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 180, 180));

        jLabel8.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 153));
        jLabel8.setText("Category");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 33));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Item Name");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 33));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("Item Id");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 64, 33));

        Customer.setBackground(new java.awt.Color(235, 248, 255));
        Customer.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        Customer.setForeground(new java.awt.Color(255, 153, 153));
        Customer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CustomerKeyReleased(evt);
            }
        });
        jPanel4.add(Customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 150, 30));

        cmbcategory.setBackground(new java.awt.Color(219, 241, 252));
        cmbcategory.setFont(new java.awt.Font("Tempus Sans ITC", 1, 17)); // NOI18N
        cmbcategory.setForeground(new java.awt.Color(255, 153, 153));
        cmbcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "anti hair loss shampoo 400 ml.", "anti hair loss treatment 400 ml.", "Mist 100ml.", "Nutrient Pack 200ml.", "Set Shampoo 1 & treatment 1 400 ml.", "Set Shampoo 3 & treatment 1 400 ml." }));
        cmbcategory.setEditor(null);
        cmbcategory.setEnabled(false);
        jPanel4.add(cmbcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 150, -1));

        txttotalPrice.setEditable(false);
        txttotalPrice.setBackground(new java.awt.Color(235, 248, 255));
        txttotalPrice.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txttotalPrice.setForeground(new java.awt.Color(255, 153, 153));
        jPanel4.add(txttotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 150, 30));

        txtid.setBackground(new java.awt.Color(235, 248, 255));
        txtid.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtid.setForeground(new java.awt.Color(255, 153, 153));
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidKeyReleased(evt);
            }
        });
        jPanel4.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 150, 30));

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 153));
        jLabel11.setText("Address");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("Quantity");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        txtname.setEditable(false);
        txtname.setBackground(new java.awt.Color(235, 248, 255));
        txtname.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtname.setForeground(new java.awt.Color(255, 153, 153));
        jPanel4.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 150, 30));

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setText("Total Price");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        txtQuantity.setBackground(new java.awt.Color(235, 248, 255));
        txtQuantity.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(255, 153, 153));
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityKeyTyped(evt);
            }
        });
        jPanel4.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 150, 30));

        txtuprice.setEditable(false);
        txtuprice.setBackground(new java.awt.Color(235, 248, 255));
        txtuprice.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtuprice.setForeground(new java.awt.Color(255, 153, 153));
        jPanel4.add(txtuprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 150, 30));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setText("Unit Price");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 33));

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setText("Serial No");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 33));

        txtserial_no.setEditable(false);
        txtserial_no.setBackground(new java.awt.Color(235, 248, 255));
        txtserial_no.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        txtserial_no.setForeground(new java.awt.Color(255, 153, 153));
        jPanel4.add(txtserial_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 150, 30));

        jLabel10.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 153));
        jLabel10.setText("Telephone");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

        Number1.setEditable(false);
        Number1.setBackground(new java.awt.Color(235, 248, 255));
        Number1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        Number1.setForeground(new java.awt.Color(255, 153, 153));
        jPanel4.add(Number1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 150, 30));

        jLabel9.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 153));
        jLabel9.setText("Customer ");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        ADCS1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        ADCS1.setForeground(new java.awt.Color(153, 0, 255));
        ADCS1.setText("CANCLE INVOICE");
        ADCS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADCS1ActionPerformed(evt);
            }
        });
        jPanel4.add(ADCS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

        C_Address.setEditable(false);
        C_Address.setBackground(new java.awt.Color(225, 248, 255));
        C_Address.setColumns(20);
        C_Address.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        C_Address.setForeground(new java.awt.Color(255, 153, 153));
        C_Address.setRows(5);
        jPanel4.add(C_Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 330, 110));

        ADCS.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        ADCS.setForeground(new java.awt.Color(153, 0, 255));
        ADCS.setText("Add Customer");
        ADCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADCSActionPerformed(evt);
            }
        });
        jPanel4.add(ADCS, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 460, 520));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 940, 610));

        name.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        name.setForeground(new java.awt.Color(255, 102, 102));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 160, 60));

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
        this.setVisible(true);
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

    private void addcartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcartActionPerformed
        // TODO add your handling code here:
        if(txtid.getText().equals("")||txtQuantity.getText().equals("")||Customer.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Checked your requirement");
        }
        else{
            DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
            Vector v = new Vector();
            v.add(lblsid.getText()); // invoice id
            v.add(txtname.getText()); // product name
            v.add(cmbcategory.getSelectedItem().toString());
            v.add(txtserial_no.getText()); // barcode
            v.add(txtQuantity.getText()); // p qyt
            v.add(txtuprice.getText()); // unit price
            v.add(txttotalPrice.getText()); // get totle price
            dt.addRow(v);
            cart_total();
            txtid.setText("");
            txtname.setText("");
            txtuprice.setText("");
            txtserial_no.setText("");
            txtQuantity.setText("");
            txttotalPrice.setText("");
            cmbcategory.setSelectedIndex(0);
            ImageIcon I = new ImageIcon(getClass().getResource("/Loffer/DefaultImage.jpg"));
            lblimage.setIcon(I);
        }
    }//GEN-LAST:event_addcartActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        Clear();
        autoId();
    }//GEN-LAST:event_ClearActionPerformed

    private void textpaymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textpaymentKeyReleased

    }//GEN-LAST:event_textpaymentKeyReleased

    private void txtidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyReleased
        // TODO add your handling code here:
        if(txtid.getText().length()==7){
            itemload();
            txtQuantity.requestFocus();
        }
        if(txtid.getText().length()>7)
        {
            txtid.setText("ITD1000");
            JOptionPane.showMessageDialog(null,"Please Checked requirement of you,Start at ITD1000-ITD1XXX");
        }
    }//GEN-LAST:event_txtidKeyReleased

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased
        // TODO add your handling code here:
        int Quantity=Integer.parseInt(txtQuantity.getText());
        double Total= (double)Quantity*Double.parseDouble(txtuprice.getText());
        txttotalPrice.setText(Total+"");
    }//GEN-LAST:event_txtQuantityKeyReleased

    private void PayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayActionPerformed
        // TODO add your handling code here:
        if(txtdiscount.equals("")||textcash.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please Checked your Discount or Cash to your paid");
        }
        else{
            try {
              DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
              int rc = dt.getRowCount();
                for (int i = 0; i < rc; i++) { 
                    String inid = dt.getValueAt(i, 0).toString(); // get inid
                    String P_name = dt.getValueAt(i, 1).toString(); // get product name
                    String C_name =dt.getValueAt(i, 2).toString();// get customer name
                    String bar_code = dt.getValueAt(i, 3).toString(); // get Serial no
                    String qty = dt.getValueAt(i, 4).toString(); // get product qty
                    String un_price = dt.getValueAt(i, 5).toString(); // get product unit price
                    String tot_price = dt.getValueAt(i, 6).toString(); // get product total Price
                    LocalDate ndate =LocalDate.now();
                    date =ndate+""; 
                    // cart DB
                 Statement s = DBConnection.connect().createStatement();
                 s.executeUpdate(" INSERT INTO cart (INID, Product_Name, Category , serial_no , qty, Unit_Price, Total_Price,date) VALUES ('"+inid+"','"+P_name+"','"+C_name+"','"+bar_code+"','"+qty+"','"+un_price+"','"+tot_price+"','"+date+"') ");
                }
                    JOptionPane.showMessageDialog(null, "Data Seved");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
            try {
                String inv_id = lblsid.getText();
                String cname  = Customer.getText();
                String totqty = T_Quantity.getText();
                String tot_bil = txttotalamount.getText(); 
                String dis=txtdiscount.getText();
                String pay=textpayment.getText();
                String cash=textcash.getText();
                String blnc = txtbalance.getText();
                String cus_id1 = Number1.getText();
                String c_Ad= C_Address.getText();
                 // paid check
                 Double tot = Double.valueOf(txttotalamount.getText());
                 Double pid = Double.valueOf(textcash.getText());
                 String Status = null;
                 if (pid.equals(0.0)) {
                    Status = "UnPaid";
                }else if (tot>pid) {
                     Status = "Sale";
                }
                 else if (tot<=pid) {
                    Status = "Paid";
                }
                LocalDate ndate =LocalDate.now();
                date =ndate+""; 
                 Statement ss = DBConnection.connect().createStatement();
                 ss.executeUpdate("INSERT INTO sales(INID,Customer_Name,TP_number,address_customer,Total_Qty, Total_Bill, Status, discount, payment, cash ,Balance, date) VALUES('"+inv_id+"','"+cname+"','"+cus_id1+"','"+c_Ad+"','"+totqty+"','"+tot_bil+"','"+Status+"','"+dis+"','"+pay+"','"+cash+"','"+blnc+"','"+date+"')");
            } catch (NumberFormatException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }  
            // Print or view ireport bill
            try {
            HashMap para = new HashMap();
            para.put("inv_id", lblsid.getText());  // inv_id  is ireport parameter name
            ReportView r =new ReportView("src\\reports\\print.jasper", para);
            r.setVisible(true);
            autoId();
            Clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_PayActionPerformed

    private void txtdiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscountKeyReleased
        double discount = Double.parseDouble(txtdiscount.getText());
        double totalprice = Double.parseDouble(txttotalamount.getText());
        double pay=totalprice-discount;
        textpayment.setText(pay+"");
    }//GEN-LAST:event_txtdiscountKeyReleased

    private void textcashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textcashKeyReleased
        double cash =Double.parseDouble(textcash.getText());
        double pay = Double.parseDouble(textpayment.getText());
        double balacne = cash-pay;
        txtbalance.setText(balacne+"");
    }//GEN-LAST:event_textcashKeyReleased

    private void CustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustomerKeyReleased
        // TODO add your handling code here:
         try{
            String sql="SELECT `customer_name`, `Tp_Number` , `address_customer` FROM `customer` WHERE customer_name='"+Customer.getText()+"'";
            pst=(PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                Customer.setText(rs.getString("customer_name"));
                Number1.setText(rs.getString("Tp_Number"));
                C_Address.setText(rs.getString("address_customer"));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_CustomerKeyReleased

    private void ADCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADCSActionPerformed
        // TODO add your handling code here:
        Menu_customer Main=new Menu_customer();
        Main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADCSActionPerformed

    private void ADCS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADCS1ActionPerformed
        // TODO add your handling code here:
        Menu_Cancle Main=new Menu_Cancle();
        Main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ADCS1ActionPerformed

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE)||(vChar== KeyEvent.VK_ENTER))
        {
            txtQuantity.getText();
        }
        else {
            txtQuantity.setText("");
            JOptionPane.showMessageDialog(null, "Must be Number");
        }
    }//GEN-LAST:event_txtQuantityKeyTyped

    private void txtdiscountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscountKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE)||(vChar== KeyEvent.VK_ENTER))
        {
            txtdiscount.getText();
        }
        else {
            txtdiscount.setText("");
            JOptionPane.showMessageDialog(null, "Must be Number");
        }
    }//GEN-LAST:event_txtdiscountKeyTyped

    private void textcashKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textcashKeyTyped
        // TODO add your handling code here: 
        char vChar = evt.getKeyChar();
        if(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE)||(vChar== KeyEvent.VK_ENTER))
        {
            txtdiscount.getText();
        }
        else {
            txtdiscount.setText("");
            JOptionPane.showMessageDialog(null, "Must be Number");
        }
    }//GEN-LAST:event_textcashKeyTyped

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
            java.util.logging.Logger.getLogger(Menu_MSell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_MSell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_MSell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_MSell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Menu_MSell().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADCS;
    private javax.swing.JButton ADCS1;
    private javax.swing.JTextArea C_Address;
    private javax.swing.JButton Clear;
    private javax.swing.JLabel ClickAddItem;
    private javax.swing.JLabel ClickMenu;
    private javax.swing.JLabel ClickReport;
    private javax.swing.JLabel ClickSell;
    private javax.swing.JLabel ClickStock;
    private javax.swing.JLabel CloseP;
    private javax.swing.JTextField Customer;
    private javax.swing.JLabel MainAddItem;
    private javax.swing.JLabel MainMenu;
    private javax.swing.JLabel MainReportList;
    private javax.swing.JLabel MainSell;
    private javax.swing.JLabel MainStock;
    private javax.swing.JLabel Menu;
    private javax.swing.JLabel Movement;
    private javax.swing.JLabel NameProduct;
    private javax.swing.JTextField Number1;
    private javax.swing.JButton Pay;
    private javax.swing.JLabel T_Quantity;
    private javax.swing.JButton addcart;
    private javax.swing.JComboBox<String> cmbcategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblimage;
    private javax.swing.JLabel lblsid;
    public static final javax.swing.JLabel name = new javax.swing.JLabel();
    private javax.swing.JTextField textcash;
    private javax.swing.JTextField textpayment;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtbalance;
    private javax.swing.JTextField txtdiscount;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtserial_no;
    private javax.swing.JTextField txttotalPrice;
    private javax.swing.JTextField txttotalamount;
    private javax.swing.JTextField txtuprice;
    // End of variables declaration//GEN-END:variables
}
