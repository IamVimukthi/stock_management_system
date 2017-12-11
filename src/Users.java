
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Users extends DbConnection  {
    
    
    private String username;
    private String password;
    private String user;
    private String pass;
    private String contact;
    private String name;
    
    
          public void setUsername(String user){
		this.username=user;	
	}
	public void setPassword(String pass){
		this.password=pass;	
	}

	public String getUsername(){
		return this.username;
	}
	public String getPassword(){
		return password;
	}
    
        
        public void setPass(String pass){
		this.pass=pass;	
	}
        
        public void setUser(String user){
		this.user=user;	
	}
        
         void setName(String name){
		this.name=name;	
	}
        
         public void setContact(String contact){
		this.contact=contact;	
	}
        
        
       
    
    
    
    
    
    public boolean loginform() throws SQLException{
    
  boolean x;
    Connection con = getConnection();
    
    PreparedStatement ps = con.prepareStatement("select * from users where username= ? and password= ? ");
    ps.setString(1, username);
     ps.setString(2, password);
    ResultSet result;
     
    ResultSet ResultSet = result = ps.executeQuery();
    if(result.next()){
        JOptionPane.showMessageDialog(null,"Login Success");
        Stock_menu sm = new Stock_menu();
       sm.setVisible(true);
        x = true;
     // StockManagementSystem sms = new StockManagementSystem();
      // sms.setVisible(false);
    }else{
    JOptionPane.showMessageDialog(null,"Invalid Login Details ");
    x = false;
    }
    return x;
}
    
    
  
    public void add(){
      
         try{
               Connection con = getConnection();
          PreparedStatement preparedStmt = con.prepareStatement("insert into users "
                  + "(Name, Contact, Username, Password ) values (?, ?, ?, ?)" );
          preparedStmt.setString (1, name);
          preparedStmt.setString (2, contact);
          preparedStmt.setString (3, user);
          preparedStmt.setString (4, pass);
          
              if(preparedStmt.execute()){
                 JOptionPane.showMessageDialog(null, "Successfully Added New User");
              }
    
          }catch(SQLException | HeadlessException e){
              System.out.println(e);
          }
        
    }

   

    
    
}
