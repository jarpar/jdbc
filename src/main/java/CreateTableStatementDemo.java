import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableStatementDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, SQLException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Connection connection = ConnectionDemo.getConnection();
        Statement createTable = connection.createStatement();
        createTable.execute("drop table if exists demo");
        int rows = createTable.executeUpdate("insert into demo values" +
                "(1,'ALA')," +
                "(2,'BEATA')," +
                "(3,'CZESLAW')," +
                "(4,'DARIUSZ')," +
                "(5,'EUGENIUSZ')"
        );
        boolean execute = createTable.execute("create table if not exists demo(id integer primary key, name varchar(20))");
        System.out.println("Wartość zwrócona przez polecenie: " + execute);

    }
}
