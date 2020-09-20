import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class MetaDataResultSetDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, SQLException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Connection connection = ConnectionDemo.getConnection();
        Statement selectAll = connection.createStatement();
        ResultSet records = selectAll.executeQuery("select * from demo");
        ResultSetMetaData metaData = records.getMetaData();
    }
}
