package com.items.service;

import java.util.Map;

public interface UserService {
	public Map<String , String> login(String username,String password);
	public int addUser(String loginName,String name,String password,String iLevel);
	public int updateUser(String userId,String loginName,String name,String password,String iLevel);
	public String findAll();
	public String findUserByKey(String key);
	public String findUserById(String id);
	public int deleteUser(String[] ids);
	public int checkUserExist(String loginName);
}
