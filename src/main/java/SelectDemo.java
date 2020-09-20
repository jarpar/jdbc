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
        String letter = scanner.nextLine();
        Statement find = connection.createStatement();
        //ResultSet resultSet = find.executeQuery("select * from demo where name LIKE '" + letter + "%'");
        // % jako letter zwróci wszystkie pozycje
        ResultSet resultSet = find.executeQuery("select * from demo where id =" + letter);
        // 1 or 1=1 zwróci wszystkie id, tzw. SQL injection
        while (resultSet.next()) {
            System.out.print("id: " + resultSet.getInt("id"));
            System.out.println(", name: " + resultSet.getString("name"));
        }
        connection.close();
    }
}
