package sdet_selenium_Day_16;

import java.sql.*;

public class Jdbc_Update {

	public static void main(String[] args) {

		try {

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/employees_db",
					"root",
					"root@123");

			Statement st = con.createStatement();

			// Update Query
			String query = "update employees set salary=45000 where emp_id=109";

			int rows = st.executeUpdate(query);

			System.out.println(rows + " row updated");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
