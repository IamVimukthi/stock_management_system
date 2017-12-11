
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;



public class Stock_menu extends javax.swing.JFrame {
    private String cid;
    Connection con = null;
    PreparedStatement pstproducts = null;
    ResultSet rsproducts = null;
    PreparedStatement pststocks = null;
    ResultSet rsstocks = null;
    PreparedStatement sup = null;
    ResultSet ressup = null;
    PreparedStatement cus = null;
    ResultSet rescus = null;
    PreparedStatement pur = null;
    ResultSet repur = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    
    public Stock_menu() throws SQLException {
        initComponents();
        
        con = DbConnection.getConnection();
        loadcombo();
        products();
        stocks();
        suppliers();
        customers();
        purchased();
        
   
        
    }
    
    private void loadcombo() {
    try
    {
    
     String sql =" select s_id from suppliers "; 
     st = con.prepareStatement(sql);
     rs = st.executeQuery();
    while(rs.next()){                            
        pro_suppliers.addItem(rs.getString("s_id"));
    }
    }
    catch(Exception e){
    }    
}
    

     public void setCid(String id){
		this.cid=id;
     }
    //products
         private void products(){
    try{
       String sql =" select * from products "; 
       pstproducts = con.prepareStatement(sql);
       rsproducts = pstproducts.executeQuery();
       products.setModel(DbUtils.resultSetToTableModel(rsproducts));
       
    }catch(Exception e){
         
    }  
   }
         
    //stocks
        public  void stocks(){
    try{
       String sql =" select stocks.id ,stocks.product_id, products.Name, stocks.quantity, stocks.purchase_type  from stocks, products where stocks.product_id = products.Product_id "; 
       pststocks = con.prepareStatement(sql);
       rsstocks = pststocks.executeQuery();
       stocks.setModel(DbUtils.resultSetToTableModel(rsstocks));
       
    }catch(Exception e){
         
    }  
   }
    
   //Suppliers
        private  void suppliers(){
    try{
       String sql =" select * from suppliers "; 
       sup = con.prepareStatement(sql);
       ressup = sup.executeQuery();
       suppliers.setModel(DbUtils.resultSetToTableModel(ressup));
       
    }catch(Exception e){
         System.out.println(e);
    }  
   } 
    
    //Customers
        private  void customers(){
    try{
       String sql =" select * from customers "; 
       cus = con.prepareStatement(sql);
       rescus = cus.executeQuery();
       customers.setModel(DbUtils.resultSetToTableModel(rescus));
       
    }catch(Exception e){
         
    }  
   }
    //Customers
        private  void customers(String id){
    try{
       String sql =" select * from customers where c_id ="+cid; 
       cus = con.prepareStatement(sql);
       rescus = cus.executeQuery();
       customers.setModel(DbUtils.resultSetToTableModel(rescus));
       
    }catch(Exception e){
         
    }  
   }
    
    //Purchase
        private  void purchased(){
    try{
       String sql =" select * from purchased "; 
       pur = con.prepareStatement(sql);
       repur = pur.executeQuery();
       purchasetbl.setModel(DbUtils.resultSetToTableModel(repur));
       
    }catch(Exception e){
         
    }  
   }     
        
     
   //Invoices
        private  void purchased(int id){
    try{
       String sql =" select * from purchased where id = ? "; 
       pur = con.prepareStatement(sql);
       pur.setInt (1, id);
       repur = pur.executeQuery();
       purchasetbl.setModel(DbUtils.resultSetToTableModel(repur));
       
    }catch(Exception e){
         
    }  
   }         
        
        
        
        
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pro_id = new javax.swing.JTextField();
        pro_name = new javax.swing.JTextField();
        pro_brand = new javax.swing.JTextField();
        pro_purchased = new javax.swing.JTextField();
        pro_selling = new javax.swing.JTextField();
        prosave = new javax.swing.JButton();
        prodelete = new javax.swing.JButton();
        pro_suppliers = new javax.swing.JComboBox<>();
        proreset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        products = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        p_id = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        returnstock = new javax.swing.JButton();
        update_stock = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        stocks = new javax.swing.JTable();
        record_id = new javax.swing.JTextField();
        del = new javax.swing.JButton();
        pid = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        quantity1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        type1 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        suppliers = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        s_id = new javax.swing.JTextField();
        s_name = new javax.swing.JTextField();
        s_address = new javax.swing.JTextField();
        s_contact = new javax.swing.JTextField();
        s_email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        S_id = new javax.swing.JTextField();
        s_save = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        customers = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        c_id = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        c_name = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        c_address = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        c_contact = new javax.swing.JTextField();
        c_email = new javax.swing.JTextField();
        c_type = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        c_reset = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        Cid = new javax.swing.JTextField();
        c_save = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        purchasetbl = new javax.swing.JTable();
        pidtxt = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        summery = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        add_order = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        payment_log = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        admin = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        adminlbl = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1400, 850));
        setResizable(false);

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Product ID");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 40, 110, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Brand");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 140, 110, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product Name");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 90, 110, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Selling Price");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(460, 90, 110, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Purchased Price");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(460, 40, 110, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Supplier");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(460, 140, 110, 25);
        jPanel2.add(pro_id);
        pro_id.setBounds(150, 40, 233, 34);
        jPanel2.add(pro_name);
        pro_name.setBounds(150, 90, 233, 36);
        jPanel2.add(pro_brand);
        pro_brand.setBounds(150, 140, 233, 40);
        jPanel2.add(pro_purchased);
        pro_purchased.setBounds(620, 40, 233, 34);
        jPanel2.add(pro_selling);
        pro_selling.setBounds(620, 90, 233, 36);

        prosave.setText("Save");
        prosave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosaveActionPerformed(evt);
            }
        });
        jPanel2.add(prosave);
        prosave.setBounds(520, 200, 149, 50);

        prodelete.setText("Delete");
        prodelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodeleteActionPerformed(evt);
            }
        });
        jPanel2.add(prodelete);
        prodelete.setBounds(1220, 220, 149, 40);
        jPanel2.add(pro_suppliers);
        pro_suppliers.setBounds(620, 140, 233, 40);

        proreset.setText("Reset");
        proreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proresetActionPerformed(evt);
            }
        });
        jPanel2.add(proreset);
        proreset.setBounds(690, 200, 160, 50);

        products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Brand", "Supplier", "Purchased Price", "Selling Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(products);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 270, 1400, 380);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/item.png"))); // NOI18N
        jPanel2.add(jLabel10);
        jLabel10.setBounds(-100, 90, 1010, 430);
        jPanel2.add(p_id);
        p_id.setBounds(1130, 170, 240, 40);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Product ID:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(1130, 150, 80, 16);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1.jpg"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, -4, 1420, 650);

        jTabbedPane1.addTab("Products", jPanel2);

        jPanel1.setLayout(null);

        jButton1.setText("New Stock");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(520, 50, 157, 50);

        returnstock.setText("Return Stock");
        returnstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnstockActionPerformed(evt);
            }
        });
        jPanel1.add(returnstock);
        returnstock.setBounds(520, 170, 160, 48);

        update_stock.setText("Add Stocks");
        update_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_stockActionPerformed(evt);
            }
        });
        jPanel1.add(update_stock);
        update_stock.setBounds(520, 110, 157, 48);

        stocks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        stocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stocksMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(stocks);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(2, 252, 1400, 420);
        jPanel1.add(record_id);
        record_id.setBounds(1150, 140, 220, 40);

        del.setText("Delete");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });
        jPanel1.add(del);
        del.setBounds(1220, 190, 150, 40);
        jPanel1.add(pid);
        pid.setBounds(240, 50, 220, 40);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Product ID:");
        jPanel1.add(jLabel41);
        jLabel41.setBounds(80, 60, 120, 17);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Quantity:");
        jPanel1.add(jLabel42);
        jLabel42.setBounds(80, 120, 100, 17);
        jPanel1.add(quantity1);
        quantity1.setBounds(240, 110, 220, 40);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Purchased Type:");
        jPanel1.add(jLabel43);
        jLabel43.setBounds(80, 180, 130, 17);

        type1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Debit" }));
        jPanel1.add(type1);
        type1.setBounds(240, 170, 220, 40);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Delete Record by ID");
        jPanel1.add(jLabel31);
        jLabel31.setBounds(1150, 120, 130, 16);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1.jpg"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(-10, -20, 1590, 670);

        jTabbedPane1.addTab("Stocks", jPanel1);

        jPanel3.setLayout(null);

        suppliers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(suppliers);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(0, 278, 1400, 390);

        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(610, 200, 150, 46);

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6);
        jButton6.setBounds(1220, 190, 157, 46);
        jPanel3.add(s_id);
        s_id.setBounds(160, 40, 206, 37);
        jPanel3.add(s_name);
        s_name.setBounds(160, 100, 206, 34);
        jPanel3.add(s_address);
        s_address.setBounds(160, 160, 206, 39);
        jPanel3.add(s_contact);
        s_contact.setBounds(540, 40, 219, 37);
        jPanel3.add(s_email);
        s_email.setBounds(540, 100, 219, 34);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Supplier ID");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(60, 50, 80, 16);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Name");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(60, 110, 70, 16);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Address");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(60, 170, 80, 16);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Suupier ID");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(1130, 110, 77, 16);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Email");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(430, 110, 50, 16);
        jPanel3.add(S_id);
        S_id.setBounds(1130, 140, 252, 37);

        s_save.setText("Save");
        s_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_saveActionPerformed(evt);
            }
        });
        jPanel3.add(s_save);
        s_save.setBounds(430, 200, 157, 46);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/supplier.png"))); // NOI18N
        jPanel3.add(jLabel17);
        jLabel17.setBounds(910, 0, 240, 300);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Contact No");
        jPanel3.add(jLabel39);
        jLabel39.setBounds(430, 50, 77, 16);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1.jpg"))); // NOI18N
        jPanel3.add(jLabel18);
        jLabel18.setBounds(-20, -80, 1510, 760);

        jTabbedPane1.addTab("Suppliers", jPanel3);

        jPanel4.setLayout(null);

        customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(customers);

        jPanel4.add(jScrollPane4);
        jScrollPane4.setBounds(0, 265, 1400, 396);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Customer ID");
        jPanel4.add(jLabel19);
        jLabel19.setBounds(68, 36, 80, 16);
        jPanel4.add(c_id);
        c_id.setBounds(192, 25, 204, 38);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Name");
        jPanel4.add(jLabel20);
        jLabel20.setBounds(68, 96, 90, 16);
        jPanel4.add(c_name);
        c_name.setBounds(192, 86, 204, 37);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Address");
        jPanel4.add(jLabel21);
        jLabel21.setBounds(68, 159, 70, 16);
        jPanel4.add(c_address);
        c_address.setBounds(192, 149, 204, 36);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Contact");
        jPanel4.add(jLabel22);
        jLabel22.setBounds(490, 38, 60, 16);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Email");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(490, 96, 60, 16);
        jPanel4.add(c_contact);
        c_contact.setBounds(592, 30, 204, 33);
        jPanel4.add(c_email);
        c_email.setBounds(592, 89, 204, 31);

        c_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Credit", "Cash" }));
        jPanel4.add(c_type);
        c_type.setBounds(592, 149, 204, 36);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Type");
        jPanel4.add(jLabel24);
        jLabel24.setBounds(490, 159, 50, 16);

        c_reset.setText("Reset");
        c_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_resetActionPerformed(evt);
            }
        });
        jPanel4.add(c_reset);
        c_reset.setBounds(680, 210, 120, 40);

        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7);
        jButton7.setBounds(1220, 200, 110, 44);
        jPanel4.add(Cid);
        Cid.setBounds(1100, 150, 230, 40);

        c_save.setText("Save");
        c_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_saveActionPerformed(evt);
            }
        });
        jPanel4.add(c_save);
        c_save.setBounds(520, 208, 140, 44);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Customer ID");
        jPanel4.add(jLabel27);
        jLabel27.setBounds(1010, 156, 90, 30);

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1.jpg"))); // NOI18N
        jPanel4.add(jLabel25);
        jLabel25.setBounds(-40, -50, 1470, 740);

        jTabbedPane1.addTab("Customers", jPanel4);

        jPanel6.setLayout(null);

        purchasetbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(purchasetbl);

        jPanel6.add(jScrollPane6);
        jScrollPane6.setBounds(-2, 128, 1400, 533);
        jPanel6.add(pidtxt);
        pidtxt.setBounds(1104, 24, 224, 39);

        jButton12.setText("Search");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton12);
        jButton12.setBounds(1229, 70, 100, 38);

        jButton13.setText("R");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton13);
        jButton13.setBounds(1340, 24, 56, 39);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Purchase ID");
        jPanel6.add(jLabel34);
        jLabel34.setBounds(1020, 30, 80, 16);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1.jpg"))); // NOI18N
        jPanel6.add(jLabel33);
        jLabel33.setBounds(-30, -60, 1450, 710);

        jTabbedPane1.addTab("Purchased", jPanel6);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adduser.jpg"))); // NOI18N

        jPanel7.setLayout(null);

        summery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/3.png"))); // NOI18N
        summery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                summeryMouseClicked(evt);
            }
        });
        jPanel7.add(summery);
        summery.setBounds(270, 60, 130, 80);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1.png"))); // NOI18N
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel28);
        jLabel28.setBounds(150, 60, 140, 80);

        add_order.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2.png"))); // NOI18N
        add_order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_orderMouseClicked(evt);
            }
        });
        jPanel7.add(add_order);
        add_order.setBounds(20, 50, 118, 100);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Stock Management System");
        jPanel7.add(jLabel8);
        jLabel8.setBounds(530, 0, 360, 39);

        payment_log.setIcon(new javax.swing.ImageIcon(getClass().getResource("/4.png"))); // NOI18N
        payment_log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payment_logMouseClicked(evt);
            }
        });
        jPanel7.add(payment_log);
        payment_log.setBounds(380, 50, 150, 100);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel35.setText("New Order");
        jPanel7.add(jLabel35);
        jLabel35.setBounds(60, 40, 80, 20);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel36.setText("Recieve Payment");
        jPanel7.add(jLabel36);
        jLabel36.setBounds(180, 40, 100, 20);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel37.setText("Sales Summery");
        jPanel7.add(jLabel37);
        jLabel37.setBounds(300, 40, 70, 20);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel38.setText("Payment Log");
        jPanel7.add(jLabel38);
        jLabel38.setBounds(420, 40, 90, 20);

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adduser.jpg"))); // NOI18N
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
        });
        jPanel7.add(user);
        user.setBounds(1200, 50, 120, 90);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel40.setText("Add User");
        jPanel7.add(jLabel40);
        jLabel40.setBounds(1230, 40, 42, 13);
        jPanel7.add(admin);
        admin.setBounds(1288, 10, 60, 0);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel32);
        jLabel32.setBounds(1290, 50, 110, 80);
        jPanel7.add(adminlbl);
        adminlbl.setBounds(1290, 10, 60, 20);

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rop.png"))); // NOI18N
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel44);
        jLabel44.setBounds(500, 60, 120, 80);

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel45.setText("ROP");
        jPanel7.add(jLabel45);
        jLabel45.setBounds(548, 40, 40, 20);

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Untitled.jpg"))); // NOI18N
        jPanel7.add(jLabel30);
        jLabel30.setBounds(0, 0, 1420, 170);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(761, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(512, 512, 512))
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void add_orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_orderMouseClicked
       new_order no = new new_order();
       no.setVisible(true);
    }//GEN-LAST:event_add_orderMouseClicked

    private void summeryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_summeryMouseClicked
     sales_summery ss = null;
        try {
            ss = new sales_summery();
        } catch (SQLException ex) {
            Logger.getLogger(Stock_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
     ss.setVisible(true);
    }//GEN-LAST:event_summeryMouseClicked

    private void payment_logMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payment_logMouseClicked
       payment_log pl = null;
        try {
            pl = new payment_log();
        } catch (SQLException ex) {
            Logger.getLogger(Stock_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
       pl.setVisible(true);
    }//GEN-LAST:event_payment_logMouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        customer_payment cp = new customer_payment();
        cp.setVisible(true);
    }//GEN-LAST:event_jLabel28MouseClicked

    private void c_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_saveActionPerformed

        String id = c_id.getText();
        String address = c_address.getText();
        String contact = c_contact.getText();
        String name = c_name.getText();
        String email = c_email.getText();
        Object type   =  c_type.getSelectedItem();

        Customers cu = new Customers();

        cu.setCid(id);
        cu.setCname(name);
        cu.setCaddress(address);
        cu.setCcontact(contact);
        cu.setCemail(email);
        cu.setType((String) type);

        cu.add();
        this.customers();

        c_id.setText("");
        c_address.setText("");
        c_contact.setText("");
        c_name.setText("");
        c_email.setText("");

    }//GEN-LAST:event_c_saveActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String cid = Cid.getText();
        Customers cu = new Customers();

        cu.setCid(cid);
        cu.deleterecords();
        this.customers();
        Cid.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void c_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_resetActionPerformed

        c_id.setText("");
        c_address.setText("");
        c_contact.setText("");
        c_name.setText("");
        c_email.setText("");

    }//GEN-LAST:event_c_resetActionPerformed

    private void s_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_saveActionPerformed
        String id = s_id.getText();
        String address = s_address.getText();
        String contact = s_contact.getText();
        String name = s_name.getText();
        String email = s_email.getText();

        Suppliers spls = new Suppliers();

        spls.setSid(id);
        spls.setSname(name);
        spls.setSaddress(address);
        spls.setScontact(contact);
        spls.setSemail(email);

        spls.add();
        this.suppliers();
        this.loadcombo();

        s_id.setText("");
        s_address.setText("");
        s_contact.setText("");
        s_name.setText("");
        s_email.setText("");
    }//GEN-LAST:event_s_saveActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String id = S_id.getText();
        Suppliers spls = new Suppliers();
        spls.setSid(id);

        spls.deleterecords();
        this.suppliers();
        S_id.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        s_id.setText("");
        s_address.setText("");
        s_contact.setText("");
        s_name.setText("");
        s_email.setText("");

    }//GEN-LAST:event_jButton4ActionPerformed

    private void update_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_stockActionPerformed
       String id =   pid.getText();
        int quantity;
        quantity = Integer.valueOf(quantity1.getText());
        Object type;
        type = type1.getSelectedItem();

        Stocks stn = new Stocks();
        stn.setPid(id);
        stn.setType(type);
        stn.setQuantity(quantity);

        stn.update();
        this.stocks();
        this.purchased();
        pid.setText("");
        quantity1.setText("");
    }//GEN-LAST:event_update_stockActionPerformed

    private void returnstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnstockActionPerformed
         String id =   pid.getText();
        int quantity;
        quantity = Integer.valueOf(quantity1.getText());
        Object type;
        type = type1.getSelectedItem();

        Stocks stn = new Stocks();
        stn.setPid(id);
        stn.setType(type);
        stn.setQuantity(quantity);

        stn.returnstock();
        this.stocks();
        
        pid.setText("");
        quantity1.setText("");
    }//GEN-LAST:event_returnstockActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String id =   pid.getText();  
       int quantity;
        quantity = Integer.valueOf(quantity1.getText());
       Object type;
       type = type1.getSelectedItem();
       
       
        Stocks stn = new Stocks();
        stn.setPid(id);
        stn.setType(type);
        stn.setQuantity(quantity);
        
        stn.add();
       this.stocks();
       this.purchased();
       pid.setText("");
        quantity1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void proresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proresetActionPerformed
        pro_id.setText("");
        pro_name.setText("");
        pro_brand.setText("");
        pro_selling.setText("");
        pro_purchased.setText("");
    }//GEN-LAST:event_proresetActionPerformed

    private void prodeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodeleteActionPerformed
        String id =   p_id.getText();

        Products product = new Products();

        product.setId(id);
      product.deleterecords();
        this.products();
        p_id.setText("");
       
    }//GEN-LAST:event_prodeleteActionPerformed

    private void prosaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosaveActionPerformed
        float purchase = Float.parseFloat(pro_purchased.getText());
        float selling = Float.parseFloat(pro_selling.getText());
        Object supplier   =  pro_suppliers.getSelectedItem();
        String brand = pro_brand.getText();
        String name =  pro_name.getText();
        String id =   pro_id.getText();

        Products product = new Products();

        product.setId(id);
        product.setName(name);
        product.setBrand(brand);
        product.setSupplier((String) supplier);
        product.setPurchased(purchase);
        product.setSelling(selling);

        product.add();
        this.products();

        pro_id.setText("");
        pro_name.setText("");
        pro_brand.setText("");
        pro_selling.setText("");
        pro_purchased.setText("");
    }//GEN-LAST:event_prosaveActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
       int id =   Integer.parseInt(record_id.getText());
       
       Stocks st = new Stocks();
       st.setRecord(id);
       st.deleterecords();
       this.stocks();
    }//GEN-LAST:event_delActionPerformed

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
       user_management um = new user_management();
       um.setVisible(true);
    }//GEN-LAST:event_userMouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
       StockManagementSystem sms = new StockManagementSystem();
       sms.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
       roplevel rop = null;
        try {
            rop = new roplevel();
        } catch (SQLException ex) {
            Logger.getLogger(Stock_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
       rop.setVisible(true);
    }//GEN-LAST:event_jLabel44MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       int id = Integer.parseInt(pidtxt.getText());
       this.purchased(id);
       
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
      this.purchased();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void stocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksMouseClicked
       this.stocks();
    }//GEN-LAST:event_stocksMouseClicked

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
            java.util.logging.Logger.getLogger(Stock_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Stock_menu().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Stock_menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cid;
    private javax.swing.JTextField S_id;
    private javax.swing.JLabel add_order;
    private javax.swing.JLabel admin;
    private javax.swing.JLabel adminlbl;
    private javax.swing.JTextField c_address;
    private javax.swing.JTextField c_contact;
    private javax.swing.JTextField c_email;
    private javax.swing.JTextField c_id;
    private javax.swing.JTextField c_name;
    private javax.swing.JButton c_reset;
    private javax.swing.JButton c_save;
    private javax.swing.JComboBox<String> c_type;
    private javax.swing.JTable customers;
    private javax.swing.JButton del;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField p_id;
    private javax.swing.JLabel payment_log;
    private javax.swing.JTextField pid;
    private javax.swing.JTextField pidtxt;
    private javax.swing.JTextField pro_brand;
    private javax.swing.JTextField pro_id;
    private javax.swing.JTextField pro_name;
    private javax.swing.JTextField pro_purchased;
    private javax.swing.JTextField pro_selling;
    private javax.swing.JComboBox<String> pro_suppliers;
    private javax.swing.JButton prodelete;
    private javax.swing.JTable products;
    private javax.swing.JButton proreset;
    private javax.swing.JButton prosave;
    private javax.swing.JTable purchasetbl;
    private javax.swing.JTextField quantity1;
    private javax.swing.JTextField record_id;
    private javax.swing.JButton returnstock;
    private javax.swing.JTextField s_address;
    private javax.swing.JTextField s_contact;
    private javax.swing.JTextField s_email;
    private javax.swing.JTextField s_id;
    private javax.swing.JTextField s_name;
    private javax.swing.JButton s_save;
    private javax.swing.JTable stocks;
    private javax.swing.JLabel summery;
    private javax.swing.JTable suppliers;
    private javax.swing.JComboBox<String> type1;
    private javax.swing.JButton update_stock;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
