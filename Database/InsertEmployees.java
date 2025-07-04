package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertEmployees {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "";

        String sql = "INSERT INTO USERS (empcode, ename, empage, esalary) VALUES (?, ?, ?, ?)";

        Object[][] employees = {
            {101, "Jenny", 25, 10000},
            {102, "Jacky", 30, 20000},
            {103, "Joe", 20, 40000},
            {104, "John", 40, 80000},
            {105, "Shameer", 25, 90000}
        };

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            for (Object[] emp : employees) {
                stmt.setInt(1, (int) emp[0]);
                stmt.setString(2, (String) emp[1]);
                stmt.setInt(3, (int) emp[2]);
                stmt.setDouble(4, Double.parseDouble(emp[3].toString()));
                stmt.executeUpdate();
                System.out.println("Inserted: " + emp[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
