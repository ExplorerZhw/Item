package com.items.service;

import org.springframework.stereotype.Service;

import com.items.util.Result;

@Service
public interface UserService {
	public Map<String, String> CheckLogin(String username, String password);
}
