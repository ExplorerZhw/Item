package com.items.bean;

import java.io.Serializable;

public class Apply implements Serializable{
	private String ID = "";
	private String iType = "";
	private String iName = "";
	private String iSpec = "";
	private String aCount = "";
	private String aOutTime = "";
	private String checkPerson = "";
	private String applyPerson = "";
	private String aState = "";
	private String factory = "";
	private String other = "";
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getiType() {
		return iType;
	}
	public void setiType(String iType) {
		this.iType = iType;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public String getiSpec() {
		return iSpec;
	}
	public void setiSpec(String iSpec) {
		this.iSpec = iSpec;
	}
	public String getaCount() {
		return aCount;
	}
	public void setaCount(String aCount) {
		this.aCount = aCount;
	}
	public String getaOutTime() {
		return aOutTime;
	}
	public void setaOutTime(String aOutTime) {
		this.aOutTime = aOutTime;
	}
	public String getCheckPerson() {
		return checkPerson;
	}
	public void setCheckPerson(String checkPerson) {
		this.checkPerson = checkPerson;
	}
	public String getApplyPerson() {
		return applyPerson;
	}
	public void setApplyPerson(String applyPerson) {
		this.applyPerson = applyPerson;
	}
	public String getaState() {
		return aState;
	}
	public void setaState(String aState) {
		this.aState = aState;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	@Override
	public String toString() {
		return "Apply [ID=" + ID + ", iType=" + iType + ", iName=" + iName + ", iSpec=" + iSpec + ", aCount=" + aCount
				+ ", aOutTime=" + aOutTime + ", checkPerson=" + checkPerson + ", applyPerson=" + applyPerson
				+ ", aState=" + aState + ", factory=" + factory + ", other=" + other + "]";
	}
	
	
}
