
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Stocks extends DbConnection implements functions{

    private String product_id;
    private int quantity;
    private String type;
    private int stock_id;
    private float Purchased_price;
    String supplier;
    float duetopay;
    int status;
    int cur_quantity;
    private int id;
    
    public Stocks(){
        
    }
    
    
    public void setPid(String pid){
		this.product_id=pid;	
	}
    
    public void setQuantity(int quantity){
		this.quantity=quantity;	
	}
    
    public void setType(Object type){
		this.type=(String) type;	
	}
    
    public void setSupplier(Object supplier){
		this.supplier=(String) supplier;	
	}
    
   public void setRecord(int id){
		this.id=id;
	}
    
    
    
    
    //Insert new stock into the stock table
    @Override
    public void add() {
        System.out.println(supplier);
     //select product details from product table   
       
         try{
          Connection con = getConnection();
          
            PreparedStatement ps1 = con.prepareStatement(" SELECT * FROM products where Product_id= ? ");
            ps1.setString(1, product_id);
            ResultSet rs1;
            ResultSet ResultSet = rs1 = ps1.executeQuery();
            
             while (rs1.next())
             {
                 this.product_id = rs1.getString("Product_id");
                 this.Purchased_price = rs1.getFloat("Purchased_price");
                 this.supplier = rs1.getString("supplier");
            }  
         
    }catch(Exception e){
            System.out.println(e);
    }
         
         
    //insert record into stocks table     
         
          try{
               Connection con = getConnection();
          PreparedStatement preparedStmt = con.prepareStatement("insert into stocks (Product_id, quantity, purchase_type ) values (?, ?, ?)" );
          preparedStmt.setString (1, product_id);
          preparedStmt.setInt (2, quantity);
          preparedStmt.setString (3, type);
          
              if(preparedStmt.execute()){
                 JOptionPane.showMessageDialog(null, "Successfully Added New Stock");
              }
    
          }catch(SQLException | HeadlessException e){
              System.out.println(e);
          }
    
          
      //calculate due to pay amount    
          
           this.duetopay = Purchased_price*quantity;
          
           //status 
           
           if("Cash".equals(type)){
               this.status = 1;
           }else{
               this.status = 0;
           }
          
           
     //genarate payments details in purchased table
     
     try{
          Connection con = getConnection();
          PreparedStatement preparedStmt1 = con.prepareStatement("insert into purchased (product_id, supplier, type, total, status ) values (?, ?,  ?, ?, ?)" );
          
          
          preparedStmt1.setString (1, product_id);
          preparedStmt1.setString (2, supplier);
          preparedStmt1.setString (3, type);
          preparedStmt1.setInt (4, (int) duetopay);
          preparedStmt1.setInt (5,(int) status);
          
         
             // preparedStmt.execute();
              if(preparedStmt1.execute()){
                 JOptionPane.showMessageDialog(null, "Successfully Added New Stock");
              }
    
          }catch(SQLException | HeadlessException e){
              System.out.println(e);
          }
       
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

    public void update() {
        
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
                 this.Purchased_price = rs1.getFloat("Purchased_price");
                 this.supplier = rs1.getString("supplier");
            }  
         
    }catch(Exception e){
            System.out.println(e);
    }
        
        //Select current quantity 
        try{
             Connection con = getConnection();
         PreparedStatement ps2 = con.prepareStatement(" SELECT sum(quantity)as total FROM stocks where Product_id= ? ");
            ps2.setString(1, product_id);
           
            ResultSet rs2;
            ResultSet ResultSet = rs2 = ps2.executeQuery();
            
             while (rs2.next())
             {
                 cur_quantity = rs2.getInt("total");
                 
            }  
         
    }catch(Exception e){
            System.out.println(e);
    }
        
    ///update stock
    
    cur_quantity = quantity+cur_quantity;
        
    try{
         Connection con = getConnection();
          PreparedStatement preparedStmt = con.prepareStatement("Update  stocks set quantity = ? where Product_id =? " );
          preparedStmt.setInt (1, cur_quantity);
          preparedStmt.setString (2, product_id);
          
              if(preparedStmt.execute()){
              }
    
          }catch(SQLException | HeadlessException e){
              System.out.println(e);
          }
    
    
        
       //calculate payments detaisls 
       this.duetopay = Purchased_price*quantity;
          
           //status 
           
           if("Cash".equals(type)){
               this.status = 1;
           }else{
               this.status = 0;
           }
          
           
     //genarate payments details in purchased table
     
     try{
          Connection con = getConnection();
          PreparedStatement preparedStmt1 = con.prepareStatement("insert into purchased (product_id, supplier, type, total, status ) values (?, ?,  ?, ?, ?)" );
          
          
          preparedStmt1.setString (1, product_id);
          preparedStmt1.setString (2, supplier);
          preparedStmt1.setString (3, type);
          preparedStmt1.setInt (4, (int) duetopay);
          preparedStmt1.setInt (5,(int) status);
          
         
              if(preparedStmt1.execute()){
                 JOptionPane.showMessageDialog(null, "Successfully Added New Stock");
              }
    
          }catch(SQLException | HeadlessException e){
              System.out.println(e);
          }  
            
    }

   
   


  public void returnstock(){
  
  
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
                 this.Purchased_price = rs1.getFloat("Purchased_price");
                 this.supplier = rs1.getString("supplier");
            }  
         
    }catch(Exception e){
            System.out.println(e);
    }
        
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
        
    ///update stock
    
    quantity = cur_quantity- quantity;
        
    try{
         Connection con = getConnection();
          PreparedStatement preparedStmt = con.prepareStatement("Update  stocks set quantity = ? where Product_id =? " );
          preparedStmt.setInt (1, quantity);
          preparedStmt.setString (2, product_id);
          
              if(preparedStmt.execute()){
                // JOptionPane.showMessageDialog(null, "Successfully Added New Stock");
              }
    
          }catch(SQLException | HeadlessException e){
              System.out.println(e);
          }
    
    
        
       //calculate payments detaisls 
       this.duetopay = Purchased_price*quantity;
          
           //status 
           
           if("Full Refunded".equals(type)){
               this.status = 1;
           }else{
               this.status = 0;
           }
          
           
     //genarate payments details in purchased table
     
     try{
          Connection con = getConnection();
          PreparedStatement preparedStmt1 = con.prepareStatement("insert into returnstock (product_id, quantity, value, status ) values (?, ?,  ?, ?)" );
          
          
          preparedStmt1.setString (1, product_id);
          preparedStmt1.setInt (2, quantity);
          preparedStmt1.setFloat (3, duetopay);
          preparedStmt1.setInt (4, (int) status);
          
              if(preparedStmt1.execute()){
                 JOptionPane.showMessageDialog(null, "Successfully Return Stock");
              }
    
          }catch(SQLException | HeadlessException e){
              System.out.println(e);
          } 
  
  }


 @Override
    public void deleterecords() {
        try{   
        Connection con;
         con = getConnection();
        
     PreparedStatement preparedStmt = con.prepareStatement("delete from stocks where id = ? " );
      preparedStmt.setInt (1, id);
      
      preparedStmt.execute();
     JOptionPane.showMessageDialog(null, "Record Successfully Deleted ");
     
     con.close();
     }catch(SQLException | HeadlessException e){
         System.out.println(e);
     }
    }

    
}
