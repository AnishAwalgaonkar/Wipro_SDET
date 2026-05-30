package sdet_selenium_Day_17;

import java.sql.*;

public class Jdbc_fetchSalary {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/employees_db";
        String user = "root";
        String password = "root@123";

        String query = "SELECT * FROM employees WHERE salary > 20000";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            System.out.println("Employees with salary > 20000:");
            while (rs.next()) {
                System.out.println(rs.getInt("emp_id") + " | " + rs.getString("emp_name") + " | " + rs.getDouble("salary"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
