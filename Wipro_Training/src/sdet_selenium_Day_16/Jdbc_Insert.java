package sdet_selenium_Day_16;

import java.sql.*;

public class Jdbc_Insert {
	public static void main(String[] args) {

		try {
			String url = "jdbc:mysql://localhost:3306/employees_db";
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employees_db", "root", "root@123");

			Statement st = con.createStatement();
			String query = "insert into employees values (109, 'rohan', 'HR', 30000, 'rohan@gmail.com', '2026-06-22', 'active')";

			int rows = st.executeUpdate(query);

			System.out.println(rows + " row inserted");

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
