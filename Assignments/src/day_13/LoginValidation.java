package day_13;

import java.sql.*;
import java.util.Scanner;
public class LoginValidation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/practice",
					"root",
					"root@123");
			System.out.println("Enter Username:");
			String username = sc.nextLine();
			System.out.println("Enter Password:");
			String password = sc.nextLine();
			String query = "select * from credentials where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Login Successful");
			} else {
				System.out.println("Invalid Username or Password");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
