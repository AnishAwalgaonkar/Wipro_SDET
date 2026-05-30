package day_13;

import java.sql.*;
import java.util.Scanner;

public class InsertStudent {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/practice",
					"root",
					"root@123");

			System.out.println("Enter Student ID:");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.println("Enter Student Name:");
			String name = sc.nextLine();

			System.out.println("Enter Course:");
			String course = sc.nextLine();

			String query = "insert into students values(?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, course);

			int rows = ps.executeUpdate();

			System.out.println(rows + " row inserted");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}