import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Scanner;

public class SelectDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, SQLException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Connection connection = ConnectionDemo.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer id:");
        String letter = scanner.nextLine();
        //Statement find = connection.createStatement();
        //ResultSet resultSet = find.executeQuery("select * from demo where name LIKE '" + letter + "%'");
        // % jako letter zwróci wszystkie pozycje
        //ResultSet resultSet = find.executeQuery("select * from demo where id =" + letter);
        // 1 or 1=1 zwróci wszystkie id, tzw. SQL injection

        //zapytanie zabezpieczone przed SQL injection:
        PreparedStatement find = connection.prepareStatement("select * from demo where id = ?");
        // wstawianie wartości parametru w miejscu pierwszego pytajnika:
        find.setInt(1, Integer.parseInt(letter));
        ResultSet resultSet = find.executeQuery();

        while (resultSet.next()) {
            System.out.print("id: " + resultSet.getInt("id"));
            System.out.print(", name: " + resultSet.getString("name"));
            System.out.println(", points: " + resultSet.getInt("points"));
        }
        connection.close();
    }
}
