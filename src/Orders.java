
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Orders extends DbConnection implements functions{

    private String product_id;
    private int quantity;
    private String cid;
    private float Selling_price;
    int cur_quantity;
    float total;
    String cus_type;
    int paymet_status;
    
    public void setPid(String product_id){
		this.product_id=product_id;	
	}
    
    public void setQuantity(int quantity){
		this.quantity=quantity;	
	}
    
    public void setCid(String cid){
		this.cid=cid;	
	}
    
    
    
    @Override
    public void add() {
       
        try{
         Connection con = getConnection();
          
            PreparedStatement ps1 = con.prepareStatement(" SELECT * FROM products where Product_id= ? ");
            ps1.setString(1, product_id);
            // ps.setString(2, password);
            ResultSet rs1;
            ResultSet ResultSet = rs1 = ps1.executeQuery();
            
             while (rs1.next())
             {
                 this.product_id = rs1.getString("Product_id");
                 this.Selling_price = rs1.getFloat("Selling_price");
               //  this.supplier = rs1.getString("supplier");
                 System.out.println(product_id+"  "+Selling_price);
            }  
         
    }catch(Exception e){
            System.out.println(e);
    }
         
    //update stock


    //Select current quantity 
        try{
             Connection con = getConnection();
         PreparedStatement ps2 = con.prepareStatement(" SELECT sum(quantity)as total FROM stocks where Product_id= ? ");
            ps2.setString(1, product_id);
            // ps.setString(2, password);
            ResultSet rs2;
            ResultSet ResultSet = rs2 = ps2.executeQuery();
            
             while (rs2.next())
             {
                 cur_quantity = rs2.getInt("total");
                 
            }  
         
    }catch(Exception e){
            System.out.println(e);
    }
        
    //check quantity
    if(cur_quantity >= quantity){
    cur_quantity = cur_quantity - quantity  ;
        
        
    try{
         Connection con = getConnection();
          PreparedStatement preparedStmt = con.prepareStatement("Update  stocks set quantity = ? where Product_id =? " );
          preparedStmt.setInt (1, cur_quantity);
          preparedStmt.setString (2, product_id);
          
              preparedStmt.execute();
              JOptionPane.showMessageDialog(null, "Successfully");
    
          }catch(SQLException | HeadlessException e){
              System.out.println(e);
          }
   
    
    //calculate total price
    this.total = Selling_price*quantity;
          
          //get customer details
      try{
           Connection con = getConnection();
           PreparedStatement ps3 = con.prepareStatement(" SELECT * FROM customers where c_id= ? ");
            ps3.setString(1, cid);
            // ps.setString(2, password);
            ResultSet rs3;
            ResultSet ResultSet = rs3 = ps3.executeQuery();
            
             while (rs3.next())
             {
                 this.cus_type = rs3.getString("type");
               
            }  
         
    }catch(Exception e){
            System.out.println("customer " +e);
    }
           
           
           if("Credit".equals(cus_type)){
               this.paymet_status = 0;
           }else{
               this.paymet_status = 1;
           }
         
           

        System.out.println(cur_quantity);
        System.out.println(quantity);
     try{
          Connection con = getConnection();
          PreparedStatement preparedStmt1 = con.prepareStatement("insert into sales (c_id, product_id, quantity, payment_type,total, status ) values (?, ?,  ?, ?, ?, ?)" );
          
          
          preparedStmt1.setString (1, cid);
          preparedStmt1.setString (2, product_id);
          preparedStmt1.setInt (3, (int) quantity);
          preparedStmt1.setString (4, cus_type);
          preparedStmt1.setInt (5, (int) total);
          preparedStmt1.setInt (6, paymet_status);
          
         
             // preparedStmt.execute();
              if(preparedStmt1.execute()){
                 JOptionPane.showMessageDialog(null, "Successfully Added New Stock");
              }
    
          }catch(SQLException | HeadlessException e){
              System.out.println(e);
          }
    
    
    }
    else{
        JOptionPane.showMessageDialog(null," Insufficient Stock \n Enter less than "+ cur_quantity );
    }
    
 }

    
    
    
    
    
    
    
    
    
    


    @Override
    public void deleterecords() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
