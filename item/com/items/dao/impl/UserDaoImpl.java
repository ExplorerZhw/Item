package com.items.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.items.dao.UserDao;
import com.items.entity.User;
import com.items.util.ConnectDB;

public class UserDaoImpl implements UserDao{
	User user = new User();

	@Override
	public User findByName(String loginName) {
		String sql = "select * from user where loginName='"+ loginName +"'"; 
		String name = "";
		String pswd = "";
		try {
			Statement stmt = ConnectDB.conDatabase();
			ResultSet rset = stmt.executeQuery(sql);
			if(!rset.next()){
				return null;
			}
			while (rset.next()) {
				name = rset.getString("name");
				pswd = rset.getString("password");
			}
			user.setName(name);
			user.setPassword(pswd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
