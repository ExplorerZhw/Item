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

import com.items.dao.ItemDao;
import com.items.util.ConnectDB;
import com.mysql.jdbc.PreparedStatement;

@Repository
public class ItemDaoImpl implements ItemDao {
	private static String ID = "";
	private static String iName = "";
	private static String iNumber = "";
	private static String iSpec = "";
	private static String iCount = "";
	private static String iType = "";
	private static String iInstoreTime = "";
	private static String iAbateTime = "";
	private static String iLocation = "";
	private static String iLevel = "";
	private static String factory = "";
	private static String other = "";
	@Override
	public int addItem(String iName, String iNumber, String iSpec, String iCount, String iType, String iInstoreTime,
			String iAbateTime, String iLocation, String iLevel,String factory,String other) {
		int retInt = 0;
		String sql = "insert into item (iName, iNumber, iSpec, iCount, iType, iInstoreTime,iAbateTime, iLocation, iJurisdiction,factory,other) "
				+ "values('"+iName+"','"+iNumber+"','"+iSpec+"','"+iCount+"','"+iType+"','"+iInstoreTime+"','"+iAbateTime+"','"+iLocation+"','"+iLevel+"','"+factory+"','"+other+"')";
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
	public int updateItem(String itemId ,String iName, String iNumber, String iSpec, String iCount, String iType, String iInstoreTime,
			String iAbateTime, String iLocation, String iLevel,String factory,String other) {
		int retInt = 0;
		String sql = "update item set iName='"+iName
				+"',iNumber='"+iNumber 
				+"',iSpec='"+iSpec
				+"',iCount='"+iCount
				+"',iType='"+iType
				+"',iInstoreTime='"+iInstoreTime
				+"',iAbateTime='"+iAbateTime
				+"',iLocation='"+iLocation
				+"',iLevel='"+iLevel
				+"',factory='"+factory
				+"',other='"+other
				+"' where id='"+itemId+"'";
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
	public  List<Map<String,String>> findAll() {
		List<Map<String,String>> list = new ArrayList<>();
		String sql = "select * from item where 1=1";
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Map<String,String> map = new HashMap<>();
				ID = rset.getString("id");
				iName = rset.getString("iName");
				iNumber = rset.getString("iNumber");
				iSpec = rset.getString("iSpec");
				iCount = rset.getString("iCount");
				iType = rset.getString("iType");
				iInstoreTime = rset.getString("iInstoreTime");
				iAbateTime = rset.getString("iAbateTime");
				iLocation = rset.getString("iLocation");
				iLevel = rset.getString("iLevel");
				factory = rset.getString("factory");
				other = rset.getString("other");
				map.put("id", ID);
				map.put("iName", iName);
				map.put("iNumber", iNumber);
				map.put("iSpec", iSpec);
				map.put("iCount", iCount);
				map.put("iType", iType);
				map.put("iInstoreTime", iInstoreTime);
				map.put("iAbateTime", iAbateTime);
				map.put("iLocation", iLocation);
				map.put("iLevel", iLevel);
				map.put("factory", factory);
				map.put("other", other);
				list.add(map);
			}
			con.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String,String>> findItemByKey(String key) {
		List<Map<String,String>> list = new ArrayList<>();
		String sql = "select * from item where iName like '%"+key+"%' or "
		+"iNumber like '%"+key+"%' or "
		+"iType like '%"+key+"%' or "
		+"iLevel like '%"+key+"%'";
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Map<String,String> map = new HashMap<>();
				ID = rset.getString("id");
				iName = rset.getString("iName");
				iNumber = rset.getString("iNumber");
				iSpec = rset.getString("iSpec");
				iCount = rset.getString("iCount");
				iType = rset.getString("iType");
				iInstoreTime = rset.getString("iInstoreTime");
				iAbateTime = rset.getString("iAbateTime");
				iLocation = rset.getString("iLocation");
				iLevel = rset.getString("iLevel");
				factory = rset.getString("factory");
				other = rset.getString("other");
				map.put("id", ID);
				map.put("iName", iName);
				map.put("iNumber", iNumber);
				map.put("iSpec", iSpec);
				map.put("iCount", iCount);
				map.put("iType", iType);
				map.put("iInstoreTime", iInstoreTime);
				map.put("iAbateTime", iAbateTime);
				map.put("iLocation", iLocation);
				map.put("iLevel", iLevel);
				map.put("factory", factory);
				map.put("other", other);
				list.add(map);
			}
			con.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Map<String,String>> findItemById(String id) {
		List<Map<String,String>> list = new ArrayList<>();
		String sql = "select * from item where id='"+id+"'";
		try {
			Connection con = ConnectDB.conDatabase();
			Statement stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while (rset.next()) {
				Map<String,String> map = new HashMap<>();
				ID = rset.getString("id");
				iName = rset.getString("iName");
				iNumber = rset.getString("iNumber");
				iSpec = rset.getString("iSpec");
				iCount = rset.getString("iCount");
				iType = rset.getString("iType");
				iInstoreTime = rset.getString("iInstoreTime");
				iAbateTime = rset.getString("iAbateTime");
				iLocation = rset.getString("iLocation");
				iLevel = rset.getString("iLevel");
				factory = rset.getString("factory");
				other = rset.getString("other");
				map.put("id", ID);
				map.put("iName", iName);
				map.put("iNumber", iNumber);
				map.put("iSpec", iSpec);
				map.put("iCount", iCount);
				map.put("iType", iType);
				map.put("iInstoreTime", iInstoreTime);
				map.put("iAbateTime", iAbateTime);
				map.put("iLocation", iLocation);
				map.put("iLevel", iLevel);
				map.put("factory", factory);
				map.put("other", other);
				list.add(map);
			}
			con.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteItem(String[] ids) {
		int retInt = 0;
		try {
			Connection con = ConnectDB.conDatabase();
			PreparedStatement ps = null;
			for(String id : ids){
				String sql = "delete from item where id=" + id;
				ps = (PreparedStatement)con.prepareStatement(sql);
				retInt = ps.executeUpdate(sql);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retInt;
	}

}
