package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// read email password

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// db connection

		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/ecomapp_2";
		String dbUserName = "root";
		String dbPassword = "root";

		boolean success = false;
		try {
			// load driver
			Class.forName(driverName);//
			// type3-> explicit
			// type4-> implicitly
			Connection con = DriverManager.getConnection(url, dbUserName, dbPassword);
			PreparedStatement pstmt = con.prepareStatement("select * from users where email = ? and password =  ?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();// db -> return -> 0 1 2 3 4....50
			// rs.next(); //boolean

			if (rs.next()) {
				// success
				success = true;// valid credentials
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// pstmt -> select query -> email and password
		// if record found -> home
		// else login ->error
		if (success) {
			// home
			response.sendRedirect("Home.jsp");// navigate
		} else {
			// login
			request.setAttribute("error", "Invalid Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);// navigate
		}

	}
}
