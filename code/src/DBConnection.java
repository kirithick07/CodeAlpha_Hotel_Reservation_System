import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection{
    static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","your_username","your_password");
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    }
