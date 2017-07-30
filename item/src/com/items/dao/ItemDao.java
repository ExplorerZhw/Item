package com.items.dao;

import java.util.List;
import java.util.Map;

public interface ItemDao {
	public int addItem(String iName,String iNumber,String iSpec,String iCount, String iType,String iInstoreTime, String iAbateTime, String iLocation, String iLevel,String factory,String other);
	public int updateItem(String itemId, String iName,String iNumber,String iSpec,String iCount, String iType,String iInstoreTime, String iAbateTime, String iLocation, String iLevel,String factory,String other);
	public List<Map<String,String>> findAll();
	public List<Map<String,String>> findItemByKey(String key);
	public List<Map<String,String>> findItemById(String id);
	public int deleteItem(String[] ids);
}
