package sdet_selenium_Day_17;

import java.sql.*;

public class Jdbc_deleteEmployee {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/employees_db";
        String user = "root";
        String password = "root@123";

        String query = "DELETE FROM employees WHERE emp_id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, 108);
            int rows = pstmt.executeUpdate();
            System.out.println("Rows deleted: " + rows);
        } catch (SQLException e) { e.printStackTrace(); }
    }
}

