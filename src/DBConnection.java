import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String user = "root";
            String pass = "vaishnavi@123";

            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
        return con;
    }
}
