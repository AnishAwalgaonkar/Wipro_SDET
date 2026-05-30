package day_13;

import java.sql.*;
public class DisplayStudents {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/practice",
					"root",
					"root@123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from students");
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + " "
						+ rs.getString(2) + " "
						+ rs.getString(3));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
