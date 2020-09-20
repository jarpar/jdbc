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

        printDemoTable(resultSet);
        connection.close();
    }

    public static void printDemoTable(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.print("id: " + resultSet.getInt("id"));
            System.out.print(", name: " + resultSet.getString("name"));
            int points = resultSet.getInt("points");
            boolean isPointsWasNull = resultSet.wasNull();
            System.out.println(", points: " + (isPointsWasNull ? "null" : points));
        }
    }
}
