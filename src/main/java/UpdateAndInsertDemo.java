import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateAndInsertDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, SQLException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Connection connection = ConnectionDemo.getConnection();
        Statement selectAll = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE
        );

        ResultSet records = selectAll.executeQuery("select * from demo");

        SelectDemo.printDemoTable(records);
        records.beforeFirst();

        while ((records.next())) {
            int points = records.getInt("points");
            if (records.wasNull()) {
                records.updateInt("points", 0);
                records.updateRow();
            }
        }

        records = selectAll.executeQuery("select * from demo");
        System.out.println("Zaktualizowana baza:");
        SelectDemo.printDemoTable(records);
    }
}
