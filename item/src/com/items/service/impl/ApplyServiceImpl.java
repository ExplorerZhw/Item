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
	public String findApplyByKey(String keyType, String keyValue) {
//		String sql = "select * from apply where iType='"+key+"' || iName='"+key+"' || iSpec='"+key+"' || checkPerson='"+key+"' || applyPerson='"+key+"' || aState='"+key+"'";		
		if(keyValue.equals("\u65b0\u5efa")) {//新建
			keyValue = "new";
		}else if(keyValue.equals("\u6279\u51c6")) {//批准
			keyValue = "pass";
		}else if(keyValue.equals("\u62d2\u7edd")) {//拒绝
			keyValue = "reject";
		}
		List<Map<String,String>> factorys = applyDao.findApplyByKey(keyType, keyValue);
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
