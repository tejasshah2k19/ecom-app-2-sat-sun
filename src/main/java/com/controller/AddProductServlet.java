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

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productName = request.getParameter("productName");
		String category = request.getParameter("category");
		String productImagePath = request.getParameter("productImagePath");
		Integer qty = Integer.parseInt(request.getParameter("qty"));
		Integer price = Integer.parseInt(request.getParameter("price"));

		try {

			String driverName = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/ecomapp_2";
			String userName = "root";
			String password = "root";

			Class.forName(driverName);

			Connection connection = DriverManager.getConnection(url, userName, password);

			PreparedStatement pstmt = connection.prepareStatement("insert into products (productName,category,price,qty,productImagePath) values (?,?,?,?,?)");

			pstmt.setString(1, productName);
			pstmt.setString(2, category);
			pstmt.setInt(3, price);
			pstmt.setInt(4, qty);
			pstmt.setString(5, productImagePath);
			pstmt.executeUpdate();  
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
