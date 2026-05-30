package sdet_selenium_Day_17;

import java.sql.*;
import java.math.*;

public class Jdbc_04 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "your_username";
        String password = "your_password";

        String sql = "INSERT INTO employees (emp_id, emp_name, department, salary, email, joining_date) VALUES (?, ?, ?, ?, ?, ?)";

        Object[][] employeeData = {
            {101, "Alice Smith", "Engineering", 75000.00, "alice@example.com", "2023-01-15"},
            {102, "Bob Johnson", "Marketing", 60000.00, "bob@example.com", "2023-02-10"},
            {103, "Charlie Brown", "Sales", 55000.00, "charlie@example.com", "2023-03-05"},
            {104, "Diana Prince", "HR", 65000.00, "diana@example.com", "2023-04-20"},
            {105, "Ethan Hunt", "IT", 80000.00, "ethan@example.com", "2023-05-12"}
        };

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (Object[] emp : employeeData) {
                pstmt.setInt(1, (Integer) emp[0]);
                pstmt.setString(2, (String) emp[1]);
                pstmt.setString(3, (String) emp[2]);
                pstmt.setBigDecimal(4, (BigDecimal) emp[3]);
                pstmt.setString(5, (String) emp[4]);
                pstmt.setDate(6, Date.valueOf((String) emp[5]));

                pstmt.executeUpdate();
            }
            System.out.println("Successfully inserted 5 employees!");

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

