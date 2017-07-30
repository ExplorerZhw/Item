package com.items.bean;

import java.io.Serializable;

public class Item implements Serializable{
	private String iName = "";
	private String iNumber = "";
	private String iSpec = "";
	private String iCount = "";
	private String iType = "";
	private String iInstoreTime = "";
	private String iAbateTime = "";
	private String iLocation = "";
	private String iLevel = "";
	private String factory = "";
	private String other = "";
	
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
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public String getiNumber() {
		return iNumber;
	}
	public void setiNumber(String iNumber) {
		this.iNumber = iNumber;
	}
	public String getiSpec() {
		return iSpec;
	}
	public void setiSpec(String iSpec) {
		this.iSpec = iSpec;
	}
	public String getiCount() {
		return iCount;
	}
	public void setiCount(String iCount) {
		this.iCount = iCount;
	}
	public String getiType() {
		return iType;
	}
	public void setiType(String iType) {
		this.iType = iType;
	}
	public String getiInstoreTime() {
		return iInstoreTime;
	}
	public void setiInstoreTime(String iInstoreTime) {
		this.iInstoreTime = iInstoreTime;
	}
	public String getiAbateTime() {
		return iAbateTime;
	}
	public void setiAbateTime(String iAbateTime) {
		this.iAbateTime = iAbateTime;
	}
	public String getiLocation() {
		return iLocation;
	}
	public void setiLocation(String iLocation) {
		this.iLocation = iLocation;
	}
	public String getiJurisdition() {
		return iLevel;
	}
	public void setiJurisdition(String iLevel) {
		this.iLevel = iLevel;
	}
			
	@Override
	public String toString() {
		return "Item [iName=" + iName + ", iNumber=" + iNumber + ", iSpec=" + iSpec + ", iCount=" + iCount + ", iType="
				+ iType + ", iInstoreTime=" + iInstoreTime + ", iAbateTime=" + iAbateTime + ", iLocation=" + iLocation
				+ ", iLevel=" + iLevel + ", factory=" + factory + ", other=" + other + "]";
	}
}
