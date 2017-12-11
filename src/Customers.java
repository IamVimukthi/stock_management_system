import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Customers extends DbConnection implements functions{

   private String cid; 
   private String cname; 
   private String caddress;  
   private String contact;  
   private String cemail; 
   private String type; 
    
    public void setCid(String id){
		this.cid=id;	
	}
    public void setCname(String name){
		this.cname=name;	
	}
    public void setCaddress(String address){
		this.caddress=address;	
	}
    public void setCcontact(String contact){
		this.contact=contact;	
	}
    public void setCemail(String email){
		this.cemail=email;	
	}
    
    public void setType(String type){
		this.type=type;	
	}
    
    
    
    
    @Override
    public void add() {
        
        
        System.out.println(cid);
        
        
        try{
          Connection con = getConnection();
         
         // PreparedStatement preparedStmt = null;
          PreparedStatement preparedStmt = con.prepareStatement("insert into customers (c_id, name, address, contact, email, type ) values (?, ?, ?, ?, ?, ? )" );
          
          
          preparedStmt.setString (1, cid);
          preparedStmt.setString (2, cname);
          preparedStmt.setString (3, caddress);
          preparedStmt.setString(4, contact);
          preparedStmt.setString(5, cemail);
          preparedStmt.setString(6, type);
         
           preparedStmt.execute();
             JOptionPane.showMessageDialog(null, "Successfully Added New Product");
              
              
          }catch(SQLException | HeadlessException e){
              System.out.println(e);
          }
             
    }

    
    
    
  

    @Override
    public void deleterecords() {
        
        try{   
            
            try (Connection con = getConnection()) {
                
                PreparedStatement preparedStmt = con.prepareStatement("delete from customers where c_id = ? " );
                preparedStmt.setString (1, cid);
                
                preparedStmt.execute();
                JOptionPane.showMessageDialog(null, " Deleted ");
            }
     }catch(SQLException | HeadlessException e){
         System.out.println(e);
     }
        
        
    }
    
}
