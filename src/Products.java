
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Products extends DbConnection implements functions {

  private String product_id;
  private String product_name;
  private String brand;
  private String supplier;
  private float purchased;
  private float selling;
  
        public void setId(String id){
		this.product_id=id;	
	}

	public void setName(String name){
		this.product_name=name;
	}
        
        public void setBrand(String brand){
		this.brand=brand;
	}
        
        public void setSupplier(String supplier){
		this.supplier=supplier;
	}
        
        public void setPurchased(float purchased){
		this.purchased=purchased;
	}
        
        public void setSelling(float selling){
		this.selling=selling;
	}
        
        
        
  
    
    
    //Add new Product to the System
    @Override
    public void add() {
       
        try{
          
            Connection con = getConnection();
          PreparedStatement preparedStmt = con.prepareStatement("insert into products"
                  + " (Product_id, Name, Brand, Supplier, Purchased_price, Selling_price ) "
                  + "values (?, ?, ?, ?, ?, ?)" );
          
          
          preparedStmt.setString (1, product_id);
          preparedStmt.setString (2, product_name);
          preparedStmt.setString (3, brand);
          preparedStmt.setString(4, supplier);
          preparedStmt.setFloat(5, purchased);
          preparedStmt.setFloat(6, selling);
          
         
              if(preparedStmt.execute()){
                 JOptionPane.showMessageDialog(null, "Successfully Added New Product");
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
     PreparedStatement preparedStmt = con.prepareStatement("delete from products where Product_id = ? " );
      preparedStmt.setString (1, product_id);
      
      preparedStmt.execute();
     JOptionPane.showMessageDialog(null, "Product Successfully Deleted ");
     
     con.close();
     }catch(SQLException | HeadlessException e){
         System.out.println(e);
     }
      
    }
    
}
