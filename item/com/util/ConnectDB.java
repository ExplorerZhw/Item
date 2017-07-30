package com.items.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectDB {
	private static Properties prop = new Properties();
	private static Connection con = null;
	public static Statement conDatabase() throws SQLException {
		try {
			// 读取数据库配置文件
			String path = ConnectDB.class.getResource("com/items/util/").getFile();
			FileInputStream fis = new FileInputStream(path + "/database.properties");
			prop.load(fis);
			
			// 链接数据库
			Class.forName(prop.getProperty("driver"));
			System.out.println(prop.getProperty("url"));
			System.out.println(prop.getProperty("user"));
			System.out.println(prop.getProperty("pwd"));
			con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("pwd"));
			Statement stmt = con.createStatement();
			return stmt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
