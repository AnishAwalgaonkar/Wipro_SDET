package day_13;

import java.sql.*;
public class MultipleInsert {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/practice",
					"root",
					"root@123");
			Statement st = con.createStatement();
			st.executeUpdate("insert into students values(101,'Rahul','Java')");
			st.executeUpdate("insert into students values(102,'Amit','Python')");
			st.executeUpdate("insert into students values(103,'Neha','Testing')");
			System.out.println("Multiple records inserted");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}