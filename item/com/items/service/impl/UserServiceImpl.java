package com.items.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.items.dao.UserDao;
import com.items.entity.User;
import com.items.service.UserService;
import com.items.util.Result;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	@Override
	public Map<String, String> CheckLogin(String username, String password) {
		Map<String, String> retMap = new HashMap<>();
		String msg = "error";//服务错误
		try {
			User user = userDao.findByName(username);
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
		result.setMsg(msg);
		return result;
	}
}
