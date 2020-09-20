import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, SQLException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Connection connection = ConnectionDemo.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj literę:");
        String letter = scanner.next();
        Statement find = connection.createStatement();
        ResultSet resultSet = find.executeQuery("select * from demo where name LIKE '" + letter + "%'");
        while (resultSet.next()) {
            System.out.print("id: " + resultSet.getInt("id"));
            System.out.println(", name: " + resultSet.getString("name"));
        }
        connection.close();
    }
}
