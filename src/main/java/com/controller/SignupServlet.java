package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			// connection con
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomapp_2", "root", "root");

			PreparedStatement pstmt = con
					.prepareStatement("insert into users (firstName,gender,email,password,role) values (?,?,?,?,?)");

			pstmt.setString(1, firstName);
			pstmt.setString(2, gender);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setString(5, "CUSTOMER");

			int record = pstmt.executeUpdate();// insert

			System.out.println(record + " Inserted....");
			
			
			response.sendRedirect("Login.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
