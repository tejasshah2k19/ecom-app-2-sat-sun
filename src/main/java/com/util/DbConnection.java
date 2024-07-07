package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DbConnection {

	static void addUser() {
		try {
			// load driver
			Class.forName("com.mysql.jdbc.Driver");

			// establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomapp_2", "root", "root");

			PreparedStatement pstmt = con
					.prepareStatement("insert into users (firstName,email,password,gender,role) values (?,?,?,?,?)");
			Scanner scr = new Scanner(System.in);
			System.out.println("Enter name email password gender");
			String name = scr.next();
			String email = scr.next();
			String password = scr.next();
			String gender = scr.next();

			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, gender);
			pstmt.setString(5, "CUSTOMER");

			pstmt.executeUpdate();// insert delete update

			if (con != null) {
				System.out.println("DbConnected.....");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// read all users
	// select * from users

	static void getAllUsers() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomapp_2", "root", "root");
			PreparedStatement pstmt = con.prepareStatement("select * from users");

			ResultSet rs = pstmt.executeQuery(); // records 50

			while (rs.next()) {// false
				String firstName = rs.getString("firstName");
				String email = rs.getString("email");

				System.out.println(firstName + " " + email);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void deleteUser(int userId) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomapp_2", "root", "root");

			PreparedStatement pstmt = con.prepareStatement("delete from users where userId = ? ");
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		DbConnection.addUser();
		DbConnection.getAllUsers();

		// primary key
		// delete from users where userId = 12

		DbConnection.deleteUser(1);
		System.out.println("-----------");

		DbConnection.getAllUsers();
	}
}
