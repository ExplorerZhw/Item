package com.items.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.items.dao.ItemDao;
import com.items.service.ItemService;

import net.sf.json.JSONArray;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDao itemDao;

	@Override
	public int addItem(String iName, String iNumber, String iSpec, String iCount, String iType, String iInstoreTime, String iAbateTime, String iLocation,
			String iLevel, String factory, String other) {
		int ret = 0;
		ret  = itemDao.addItem(iName, iNumber, iSpec, iCount, iType, iInstoreTime, iAbateTime, iLocation, iLevel, factory, other);
		return ret;
	}

	@Override
	public int updateItem(String itemId, String iName, String iNumber, String iSpec, String iCount, String iType, String iInstoreTime, String iAbateTime,
			String iLocation, String iLevel, String factory, String other) {
		int ret = 0;
		ret  = itemDao.updateItem(itemId, iName, iNumber, iSpec, iCount, iType, iInstoreTime, iAbateTime, iLocation, iLevel, factory, other);
		return ret;
	}

	@Override
	public String findAll() {
		List<Map<String,String>> list = itemDao.findAll();
		JSONArray jsonarray = JSONArray.fromObject(list);
		return jsonarray.toString();
	}

	@Override
	public String findItemByKey(String key) {
		List<Map<String,String>> list = itemDao.findItemByKey(key);
		JSONArray jsonarray = JSONArray.fromObject(list);
		System.out.println(jsonarray.toString());
		return jsonarray.toString();
	}

	@Override
	public String findItemById(String id) {
		List<Map<String,String>> list = itemDao.findItemById(id);
		JSONArray jsonarray = JSONArray.fromObject(list);
		return jsonarray.toString();
	}

	@Override
	public int deleteItem(String[] ids) {
		int ret = 0;
		ret  = itemDao.deleteItem(ids);
		return ret;
	}

}
