import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableStatementDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, SQLException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Connection connection = ConnectionDemo.getConnection();
        Statement createTable = connection.createStatement();
        boolean execute = createTable.execute("create table if not exists demo(id integer primary key, name varchar(20))");
        System.out.println("Wartość zwrócona przez polecenie: " + execute);

    }
}
