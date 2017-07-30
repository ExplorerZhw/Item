package com.items.dao;

import java.util.List;
import java.util.Map;

public interface ApplyDao {
	public int addApply(String iType, String iName,String iSpec, int aCount,String applyPerson,String factory,String other);
	public List<Map<String,String>> searchNameByType(String iType);
	public List<Map<String,String>> searchSpecByName(String iType, String iName);
	public List<Map<String,String>> searchFactoryBySpec(String iType, String iName, String iSpec);
	public List<Map<String,String>> findApplyByKey(String keyType, String keyValue);
	public int passCheck(String[] ids, String user);
	public int RejectCheck(String[] ids, String user);
}
