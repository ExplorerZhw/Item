package com.items.dao;

import java.util.List;
import java.util.Map;

import com.items.bean.User;


public interface UserDao {
	public User findByName(String name);
	public int addUser(String loginName, String name, String password, String iLevel);
	public int updateUser(String userId, String loginName, String name, String password, String iLevel);
	public List<Map<String,String>> findAll();
	public List<Map<String,String>> findUserByKey(String key);
	public List<Map<String,String>> findUserById(String id);
	public int deleteUser(String[] ids);
	public int checkUserExist(String loginName);
}
