import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableStatementDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, SQLException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Connection connection = ConnectionDemo.getConnection();
        Statement createTable = connection.createStatement();
        createTable.execute("drop table if exists demo");
        boolean execute = createTable.execute("create table if not exists demo(id integer primary key, name varchar(20))");
        int rows = createTable.executeUpdate("insert into demo values" +
                "(1,'ALA')," +
                "(2,'ADAM')," +
                "(3,'BARTOSZ')," +
                "(4,'BOGUMIŁ')," +
                "(5,'CELINA')"
        );
        System.out.println("Wartość zwrócona przez polecenie: " + execute);
        System.out.println("Dodano wierszy " + rows);
        connection.close();
    }
}
