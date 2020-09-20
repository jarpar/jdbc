import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableStatementDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, SQLException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Connection connection = ConnectionDemo.getConnection();
        Statement createTable = connection.createStatement();
        createTable.execute("drop table if exists demo");
        boolean execute = createTable.execute("create table if not exists demo(id integer primary key, name varchar(20), points integer)");
        int rows = createTable.executeUpdate("insert into demo values" +
                "(1,'ALA', 120)," +
                "(2,'ADAM', 90)," +
                "(3,'BARTOSZ', null)," +
                "(4,'BOGUMIŁ', 50)," +
                "(5, null, 50)"
        );
        System.out.println("Wartość zwrócona przez polecenie: " + execute);
        System.out.println("Dodano wierszy " + rows);
        connection.close();
    }
}
