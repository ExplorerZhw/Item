package com.items.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.items.dao.ApplyDao;
import com.items.service.ApplyService;

import net.sf.json.JSONArray;

@Service
public class ApplyServiceImpl implements ApplyService{

	@Autowired
	private ApplyDao applyDao;

	@Override
	public int addApply(String iType, String iName, String iSpec, int aCount,String applyPerson, String factory, String other) {
		int ret = applyDao.addApply(iType, iName, iSpec, aCount,applyPerson, factory, other);
		return ret;
	}

	@Override
	public String searchNameByType(String iType) {
		List<Map<String,String>> names = applyDao.searchNameByType(iType);
		if(names != null){
			JSONArray jsonarray = JSONArray.fromObject(names);
			return jsonarray.toString();
		}
		return null;
	}

	@Override
	public String searchSpecByName(String iType, String iName) {
		List<Map<String,String>> specs = applyDao.searchSpecByName(iType, iName);
		if(specs != null){
			JSONArray jsonarray = JSONArray.fromObject(specs);
			return jsonarray.toString();
		}
		return null;
	}

	@Override
	public String searchFactoryBySpec(String iType, String iName, String iSpec) {
		List<Map<String,String>> factorys = applyDao.searchFactoryBySpec(iType, iName, iSpec);
		if(factorys != null){
			JSONArray jsonarray = JSONArray.fromObject(factorys);
			return jsonarray.toString();
		}
		return null;
	}

	@Override
	public String findItemByKey(String key) {
		List<Map<String,String>> factorys = applyDao.findItemByKey(key);
		if(factorys != null){
			JSONArray jsonarray = JSONArray.fromObject(factorys);
			return jsonarray.toString();
		}
		return null;
	}

	@Override
	public int passCheck(String[] ids, String user) {
		int retInt = 0;
		retInt = applyDao.passCheck(ids, user);
		return retInt;
	}
	
	@Override
	public int RejectCheck(String[] ids, String user) {
		int retInt = 0;
		retInt = applyDao.RejectCheck(ids, user);
		return retInt;
	}
}
