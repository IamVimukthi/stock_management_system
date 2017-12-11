
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Payments extends DbConnection {
    
    private int sale_id;
    private String c_id;
    private float amount;
    private String method;
    private float total;
    int status;
    int newstatus = 1;
    
    public void setSaleID(int sale_id){
        this.sale_id=sale_id;
    }
    
    public void setCid(String C_id){
        this.c_id=C_id;
    }
    
    public void setamount(float amount){
        this.amount=amount;
    }
    
    public void setMethod(String method){
        this.method=method;
    }
    
    
    public void Pay(){
        try{
             Connection con = getConnection();
           PreparedStatement ps = con.prepareStatement(" SELECT * FROM sales where id= ? ");
            ps.setInt(1, sale_id);
            // ps.setString(2, password);
            ResultSet rs;
            ResultSet ResultSet = rs = ps.executeQuery();
            
             while (rs.next())
             {
                 this.c_id = rs.getString("c_id");
                 this.total = rs.getFloat("total");
                 this.status = rs.getInt("status");
            }  
         
    }catch(Exception e){
            System.out.println("sales " +e);
    }
        
        
        //insert into payments
        
        if(status == 0 ){
        try{
          
           Connection con = getConnection();
         
           
         // PreparedStatement preparedStmt = null;
          PreparedStatement preparedStmt = con.prepareStatement("insert into payments (sale_id, c_id, method, amount  ) values ( ?, ?, ?, ?)" );
          
          
          preparedStmt.setInt (1, sale_id);
          preparedStmt.setString (2, c_id);
          preparedStmt.setString (3, method);
          preparedStmt.setFloat(4, amount);
         // preparedStmt.setFloat(6, selling);
          
         
             // preparedStmt.execute();
              preparedStmt.execute();
                // JOptionPane.showMessageDialog(null, "Payment Successful");
              
              
          }catch(SQLException | HeadlessException e){
              System.out.println(e);
          }
        
        //update sales table
        
        try{
             Connection con = getConnection();
          PreparedStatement preparedStmt = con.prepareStatement("Update  sales set status = ? where id =? " );
          preparedStmt.setInt (1, newstatus);
          preparedStmt.setInt (2, sale_id);
          
              preparedStmt.execute();
               
          }catch(SQLException | HeadlessException e){
              System.out.println(e);
          }
          JOptionPane.showMessageDialog(null, "Payment Successful ");
        
        }else{
             JOptionPane.showMessageDialog(null, "Wrong Sales ID \n Already received Payments for this ID");
        }
        
        }
        
    } 
    
    
    

