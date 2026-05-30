package sdet_selenium_Day_17;

import java.sql.*;

public class Jdbc_updateSalary {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/employees_db";
        String user = "root";
        String password = "root@123";

        String query = "UPDATE employees SET salary = ? WHERE emp_id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setDouble(1, 95000.00); 
            pstmt.setInt(2, 102);       
            int rows = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rows);
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
