package com.items.service;

public interface ApplyService {
	public int addApply(String iType, String iName,String iSpec, int aCount,String applyPerson, String factory,String other);
	public String searchNameByType(String iType);
	public String searchSpecByName(String iType,String iName);
	public String searchFactoryBySpec(String iType,String iName, String iSpec);
	public String findItemByKey(String key);
	public int passCheck(String[] ids, String user);
	public int RejectCheck(String[] ids, String user);
}
