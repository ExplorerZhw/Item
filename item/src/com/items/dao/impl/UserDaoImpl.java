package com.items.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.items.bean.User;
import com.items.dao.UserDao;
import com.items.util.ConnectDB;
import com.mysql.jdbc.PreparedStatement;

@Repository
public class UserDaoImpl implements UserDao {
	User user = new User();
	@Override
	public User findByName(String loginName) {
		String sql = "select * from User where loginName='" + loginName + "'";
		String name = "";
		String pswd = "";
		String iLevel = "";
		String lgName = "";
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				name = rset.getString("name");
				pswd = rset.getString("password");
				iLevel = rset.getString("iLevel");
				lgName = rset.getString("loginName");
			}
			user.setName(name);
			user.setPassword(pswd);
			user.setLoginName(lgName);
			user.setiLevel(iLevel);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String,String>> findAll() {
		List<Map<String,String>> list = new ArrayList<>();
		String sql = "select * from User where 1=1";
		String name = "";
		String pswd = "";
		String iLevel = "";
		String lgName = "";
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Map<String,String> map = new HashMap<>();
				name = rset.getString("name");
				pswd = rset.getString("password");
				iLevel = rset.getString("iLevel");
				lgName = rset.getString("loginName");
				map.put("name", name);
				map.put("password", pswd);
				map.put("loginName", lgName);
				map.put("iLevel", iLevel);
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addUser(String loginName, String name, String password, String iLevel) {
		int retInt = 0;
		String sql = "insert into user (loginName,password,name,iLevel) values('"+loginName+"','"+password+"','"+name+"','"+iLevel+"')";
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			int rset = stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			retInt = rset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retInt;
	}

	@Override
	public List<Map<String,String>> findUserByKey(String key) {
		List<Map<String,String>> list = new ArrayList<>();
		String sql = "select * from user where name like '%"+key+"%' or loginName like '%"+key+"%'";
		String id = "";
		String name = "";
		String pswd = "";
		String iLevel = "";
		String lgName = "";
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Map<String,String> map = new HashMap<>();
				id = rset.getString("id");
				name = rset.getString("name");
				pswd = rset.getString("password");
				iLevel = rset.getString("iLevel");
				lgName = rset.getString("loginName");
				map.put("id", id);
				map.put("name", name);
				map.put("password", pswd);
				map.put("loginName", lgName);
				map.put("iLevel", iLevel);
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String,String>> findUserById(String id) {
		List<Map<String,String>> list = new ArrayList<>();
		String sql = "select * from user where id='"+id+"'";
		String name = "";
		String pswd = "";
		String iLevel = "";
		String lgName = "";
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Map<String,String> map = new HashMap<>();
				id = rset.getString("id");
				name = rset.getString("name");
				pswd = rset.getString("password");
				iLevel = rset.getString("iLevel");
				lgName = rset.getString("loginName");
				map.put("id", id);
				map.put("name", name);
				map.put("password", pswd);
				map.put("loginName", lgName);
				map.put("iLevel", iLevel);
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateUser(String userId, String loginName, String name, String password, String iLevel) {
		int retInt = 0;
		String sql = "update user set loginName='"+loginName+"',password='"+password+"',name='"+name+"',iLevel='"+iLevel+"' where id='"+userId+"'";
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			int rset = stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			retInt = rset;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retInt;
	}

	@Override
	public int deleteUser(String[] ids) {
		int retInt = 0;
		try {
			Connection con = ConnectDB.conDatabase();
			PreparedStatement ps = null;
			for(String id : ids){
				String sql = "delete from user where id=" + id;
				ps = (PreparedStatement)con.prepareStatement(sql);
				retInt = ps.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retInt;
	}

	@Override
	public int checkUserExist(String loginName) {
		int ret = 0;
		String sql = "select * from user where loginName='"+loginName+"'";
		System.out.println("checkUserExist:"+sql);
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			if (rset.next()) {
				ret = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
