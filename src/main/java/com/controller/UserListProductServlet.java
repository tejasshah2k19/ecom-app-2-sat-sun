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

@WebServlet("/UserListProductServlet")
public class UserListProductServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// db -> products -> jsp -> display

		// select * from products
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomapp_2", "root", "root");
			PreparedStatement pstmt = con.prepareStatement("select * from products");

			// executeUpdate -> insert update delete
			// executeQuery -> read : select
			ResultSet rs = pstmt.executeQuery(); // select run

			// rs -> extract -> 1 -> name price -> add to cart
			request.setAttribute("rs", rs);//2

			RequestDispatcher rd = request.getRequestDispatcher("ListProduct.jsp");
			rd.forward(request, response);
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
