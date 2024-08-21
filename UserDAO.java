import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class UserDAO{
    private static final String URL="jdbc:mysql://localhost:3306/HotelManage";
    private static final String User="root";
    private static final String Password="sanketjain";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, User, Password);
    }
}
