package com.items.bean;

import java.io.Serializable;

public class User implements Serializable{
	private String loginName = "";//登陆名
	private String password = "";//登陆密码
	private String name = "";//显示名
	private String iLevel = "";//权限
	
	public String getiLevel() {
		return iLevel;
	}
	public void setiLevel(String iLevel) {
		this.iLevel = iLevel;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [loginName=" + loginName + ", password=" + password + ", name=" + name + ", iLevel="
				+ iLevel + "]";
	}
	
}
