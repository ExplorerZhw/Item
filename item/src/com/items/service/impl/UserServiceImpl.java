package com.items.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.items.bean.User;
import com.items.dao.UserDao;
import com.items.service.UserService;

import net.sf.json.JSONArray;

@Service
public class UserServiceImpl implements UserService{
//	private UserDaoImpl userDao = new UserDaoImpl();
	@Autowired
	private UserDao userDao;
	@Override
	public Map<String , String> login(String username, String password) {
		Map<String , String> retMap = new HashMap<String , String>();
		String msg = "error";//服务错误
		User user = new User();
		try {
			user = userDao.findByName(username);
			if (user != null) {
				if (user.getPassword().equals(password)) {
					msg = "success";
				} else {
					// 密码错误
					msg = "error2";
				}
			} else {
				// 用户名不存在
				msg = "error1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		retMap.put("msg", msg);
		retMap.put("name", user.getName());
		retMap.put("loginName", user.getLoginName());
		return retMap;
	}

	@Override
	public String findAll() {
		List<Map<String,String>> list = userDao.findAll();
		JSONArray jsonarray = JSONArray.fromObject(list);
		return jsonarray.toString();
	}

	@Override
	public int addUser(String loginName, String name, String password, String iLevel) {
		int retInt = 0;
		retInt = userDao.addUser(loginName,name,password,iLevel);
		return retInt;
	}

	@Override
	public String findUserByKey(String key) {
		List<Map<String,String>> list = userDao.findUserByKey(key);
		JSONArray jsonarray = JSONArray.fromObject(list);
		return jsonarray.toString();
	}

	@Override
	public String findUserById(String id) {
		List<Map<String,String>> list = userDao.findUserById(id);
		JSONArray jsonarray = JSONArray.fromObject(list);
		return jsonarray.toString();
	}

	@Override
	public int updateUser(String userId, String loginName, String name, String password, String iLevel) {
		int retInt = 0;
		retInt = userDao.updateUser(userId, loginName,name,password,iLevel);
		return retInt;
	}

	@Override
	public int deleteUser(String[] ids) {
		int retInt = 0;
		retInt = userDao.deleteUser(ids);
		return retInt;
	}

	@Override
	public int checkUserExist(String loginName) {
		int retInt = 0;
		retInt = userDao.checkUserExist(loginName);
		return retInt;
	}
}
