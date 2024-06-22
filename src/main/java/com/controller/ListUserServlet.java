package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListUserServlet")
public class ListUserServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// select * from users ;

		try {

			String driverName = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/ecomapp_2";
			String userName = "root";
			String password = "root";

			Class.forName(driverName);

			Connection connection = DriverManager.getConnection(url, userName, password);

			PreparedStatement pstmt = connection.prepareStatement("select * from users");

			ResultSet rs = pstmt.executeQuery();// select * from users;
			// tmp storage -> select -> output ->

			while (rs.next()) {// first record -> true
				// not present -> false

				Integer userId = rs.getInt("userId");
				String firstName = rs.getString("firstName");
				String email = rs.getString("email");

				System.out.println(userId + " " + firstName + " " + email);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

//ListUserServlet-> object 
//oop -> service -> ListUserServlet : object 
