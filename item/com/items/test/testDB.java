package com.items.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testDB {

	public static void main(String[] args) throws SQLException {
		try {
			String sql = "select * from User";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.1.8:3306/manageitems?user=root&password=123456");
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				System.out.println(rset.getString("name"));
				System.out.println(rset.getString("password"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
