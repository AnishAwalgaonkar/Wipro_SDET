package sdet_selenium_Day_17;

import java.sql.*;

public class Jdbc_CountEmployees {
    public static void main(String[] args) {
    	String url = "jdbc:mysql://127.0.0.1:3306/employees_db";
        String user = "root";
        String password = "root@123";

        String query = "SELECT COUNT(*) FROM employees";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            if (rs.next()) {
                System.out.println("Total Employees: " + rs.getInt(1));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
