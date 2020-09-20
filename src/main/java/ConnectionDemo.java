import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
        Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost/baza", "user", "pass");
    }
}
