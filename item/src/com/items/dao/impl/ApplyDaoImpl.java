package com.items.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.items.dao.ApplyDao;
import com.items.util.ConnectDB;
import com.mysql.jdbc.PreparedStatement;

@Repository
public class ApplyDaoImpl implements ApplyDao {
	private static String ID = "";
	private static String iType = "";
	private static String iName = "";
	private static String iSpec = "";
	private static String aCount = "";
	private static String aOutTime = "";
	private static String checkPerson = "";
	private static String applyPerson = "";
	private static String aState = "";
	private static String factory = "";
	private static String other = "";
	@Override
	public int addApply( String iType, String iName,String iSpec, int aCount,String applyPerson,String factory,String other) {
		int retInt = 0;
		SimpleDateFormat formatter; 
		Date date = new Date();
		formatter = new SimpleDateFormat ("yyyy-MM-dd"); 
		String aOutTime = formatter.format(date); 
		String sql = "insert into apply (iType, iName, iSpec, aCount, aOutTime, applyPerson, aState, factory, other) "
				+ "values('"+iType+"','"+iName+"','"+iSpec+"','"+aCount+"','"+aOutTime+"','"+applyPerson+"','新建','"+factory+"','"+other+"')";
		System.out.println("addApply:"+sql);
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			int rset = stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			retInt = rset;
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retInt;
	}
	@Override
	public List<Map<String,String>> searchNameByType(String iType) {
		List<Map<String,String>> list = new ArrayList<>();
		String sql = "select iName from item where iType='"+iType+"'";
		System.out.println("searchNameByType:"+sql);
		String name = "";
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Map<String,String> map = new HashMap<>();
				name = rset.getString("iName");
				map.put("name", name);
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Map<String, String>> searchSpecByName(String iType, String iName) {
		List<Map<String,String>> list = new ArrayList<>();
		String sql = "select iSpec from item where iType='"+iType+"' && iName='"+iName+"'";
		System.out.println("searchSpecByName:"+sql);
		String spec = "";
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Map<String,String> map = new HashMap<>();
				spec = rset.getString("iSpec");
				map.put("spec", spec);
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Map<String, String>> searchFactoryBySpec(String iType, String iName, String iSpec) {
		List<Map<String,String>> list = new ArrayList<>();
		String sql = "select factory from item where iType='"+iType+"' && iName='"+iName+"' && iSpec='"+iSpec+"'";
		System.out.println("searchFactoryBySpec:"+sql);
		String factory = "";
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Map<String,String> map = new HashMap<>();
				factory = rset.getString("factory");
				map.put("factory", factory);
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Map<String, String>> findApplyByKey(String keyType, String keyValue) {
		List<Map<String,String>> list = new ArrayList<>();
		String sql = "select * from apply where "+keyType+"='"+keyValue+"'";
		System.out.println(sql);
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Map<String,String> map = new HashMap<>();
				ID = rset.getString("id");
				iType = rset.getString("iType");
				iName = rset.getString("iName");
				iSpec = rset.getString("iSpec");
				aCount = rset.getString("aCount");
				aOutTime = rset.getString("aOutTime");
				checkPerson = rset.getString("checkPerson");
				applyPerson = rset.getString("applyPerson");
				aState = rset.getString("aState");
				map.put("id", ID);
				map.put("iType", iType);
				map.put("iName", iName);
				map.put("iSpec", iSpec);
				map.put("aCount", aCount);
				map.put("aOutTime", aOutTime);
				map.put("checkPerson", checkPerson);
				map.put("applyPerson", applyPerson);
				map.put("aState", aState);
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int passCheck(String[] ids, String user) {
		int retInt = 0;
		String sqlSelectItem = "";
		String sqlSelectApply = "";
		String sqlUpdate = "";
		try {
			Connection con = ConnectDB.conDatabase();
			PreparedStatement ps = null;
			for(String id : ids){
				//对比数量
				sqlSelectItem = "select item ";
				//更新状态
				sqlUpdate = "update apply set aState='pass' checkPerson='"+user+"' where id='"+id+"'";
				ps = (PreparedStatement)con.prepareStatement(sqlUpdate);
				retInt = ps.executeUpdate(sqlUpdate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retInt;
	}
	@Override
	public int RejectCheck(String[] ids, String user) {
		int retInt = 0;
		try {
			Connection con = ConnectDB.conDatabase();
			PreparedStatement ps = null;
			for(String id : ids){
				String sql = "update apply set aState='reject' where id='"+id+"'";
				ps = (PreparedStatement)con.prepareStatement(sql);
				retInt = ps.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retInt;
	}
}
