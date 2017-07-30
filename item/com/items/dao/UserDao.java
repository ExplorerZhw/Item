package com.items.dao;

import com.items.entity.User;


public interface UserDao {
	public User findByName(String name);
}
