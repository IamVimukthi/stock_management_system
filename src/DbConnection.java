import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
    
    
    public  static Connection getConnection () throws SQLException{
      
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stock","root","");
           }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return con;
    }
}
