
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Suppliers extends DbConnection implements functions {

   private String sid; 
   private String sname; 
   private String saddress;  
   private String contact;  
   private String semail; 
   
   
   public void setSid(String id){
		this.sid=id;	
	}
    public void setSname(String name){
		this.sname=name;	
	}
    public void setSaddress(String address){
		this.saddress=address;	
	}
    public void setScontact(String contact){
		this.contact=contact;	
	}
    public void setSemail(String email){
		this.semail=email;	
	}
    
    
    
    
    @Override
    public void add() {
       
        try{
         Connection con = getConnection();
         
         // PreparedStatement preparedStmt = null;
          PreparedStatement preparedStmt = con.prepareStatement("insert into suppliers (s_id, name, address, contact, email ) values (?, ?, ?, ?, ? )" );
          
          
          preparedStmt.setString (1, sid);
          preparedStmt.setString (2, sname);
          preparedStmt.setString (3, saddress);
          preparedStmt.setString(4, contact);
          preparedStmt.setString(5, semail);
         
          
         
             
             preparedStmt.execute();
             JOptionPane.showMessageDialog(null, "Successfully Added New Product");
              
              
          }catch(SQLException | HeadlessException e){
              System.out.println(e);
          }
        
        
    }

  

    @Override
    public void deleterecords() {
        try{   
        Connection con = getConnection();
         //System.out.println(product_id+"hello");
     PreparedStatement preparedStmt = con.prepareStatement("delete from suppliers where s_id = ? " );
      preparedStmt.setString (1, sid);
      
      preparedStmt.execute();
     JOptionPane.showMessageDialog(null, " Deleted ");
     
     con.close();
     }catch(SQLException | HeadlessException e){
         System.out.println(e);
     }
        
        
    }
    
}
