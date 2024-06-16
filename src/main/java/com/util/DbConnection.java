package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static void main(String[] args) {

		try {
			// step1: load your driver in memory
			Class.forName("com.mysql.cj.jdbc.Driver"); // type 3

			// step2: establish the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomapp_2", "root", "root");

			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
