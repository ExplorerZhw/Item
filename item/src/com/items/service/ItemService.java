package com.items.service;

public interface ItemService {
	public int addItem(String iName,String iNumber,String iSpec,String iCount, String iType,String iInstoreTime, String iAbateTime, String iLocation, String iLevel,String factory,String other);
	public int updateItem(String itemId, String iName,String iNumber,String iSpec,String iCount, String iType,String iInstoreTime, String iAbateTime, String iLocation, String iLevel,String factory,String other);
	public String findAll();
	public String findItemByKey(String key);
	public String findItemById(String id);
	public int deleteItem(String[] ids);
}
