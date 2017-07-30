package com.items.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDB {
	private static Connection con = null;
	private static String url = "";
	private static String driver = "";
	private static String user = "";
	private static String password = "";
	
	private static Properties props = new Properties();
	
	private static String tempPath = "/com/items/util/";
	private static String tempFileName = "database.properties";
	static{
		try {
			readDBInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection conDatabase() throws SQLException {
		try {
			// 链接数据库
			Class.forName(driver);// 指定连接类型
			con = DriverManager.getConnection(url, user, password);// 获取连接
			System.out.println("conDB ok");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected static void readDBInfo() throws Exception{
		try {
			String p1 = ConnectDB.class.getResource(tempPath).getPath();
			String path = p1 + tempFileName;
			FileInputStream in = new FileInputStream(path);
			props.load(in);
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("pwd");
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
