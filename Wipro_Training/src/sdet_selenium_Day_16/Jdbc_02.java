package sdet_selenium_Day_16;

import java.sql.*;

public class Jdbc_02 {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url="jdbc:mysql://127.0.0.1:3306/employees_db";
			String username="root";
			String password="root@123";
			
			Connection con=DriverManager.getConnection(url, username, password);
			
			System.out.println("Database Connected Successfully");
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
