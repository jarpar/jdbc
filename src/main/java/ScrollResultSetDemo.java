import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollResultSetDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, SQLException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Connection connection = ConnectionDemo.getConnection();
        // ustawienie możliwości przewijania ResultSet w obu kierunkach:
        Statement selectAll = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        ResultSet records = selectAll.executeQuery("select * from demo");
        System.out.println("pierwsze czytanie:");
        SelectDemo.printDemoTable(records);
        System.out.println("drugie czytanie:");
        SelectDemo.printDemoTable(records);
        System.out.println("przewijanie do początku...");
        System.out.println("trzecie czytanie:");
        records.beforeFirst();
        SelectDemo.printDemoTable(records);

        /*while (records.next()) {
            System.out.print("id: " + records.getInt("id"));
            System.out.print(", name: " + records.getString("name"));
            int points = records.getInt("points");
            boolean isPointsWasNull = records.wasNull();
            System.out.println(", points: " + (isPointsWasNull ? "null" : points));
        }*/
    }
}
