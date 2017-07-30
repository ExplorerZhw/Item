package com.items.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.items.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@ResponseBody
	@RequestMapping("/additem.do")
	public ModelAndView  addUserController(@RequestParam("iName") String iName, @RequestParam("iNumber") String iNumber,
			@RequestParam("iSpec") String iSpec, @RequestParam("iCount") String iCount, @RequestParam("iType") String iType, 
			@RequestParam("iInstoreTime_y") String iInstoreTime_y, @RequestParam("iInstoreTime_m") String iInstoreTime_m, 
			@RequestParam("iInstoreTime_d") String iInstoreTime_d, @RequestParam("iAbateTime_y") String iAbateTime_y, 
			@RequestParam("iAbateTime_m") String iAbateTime_m, @RequestParam("iAbateTime_d") String iAbateTime_d, 
			@RequestParam("iLocation") String iLocation, 	@RequestParam("iLevel") String iLevel ,
			@RequestParam("factory") String factory, @RequestParam("other") String other) throws IOException {
		String iInstoreTime = iInstoreTime_y + "-" + iInstoreTime_m + "-" + iInstoreTime_d;
		String iAbateTime = iAbateTime_y + "-" + iAbateTime_m + "-" + iAbateTime_d;
		int retInt = itemService.addItem(iName, iNumber, iSpec, iCount, iType, iInstoreTime, iAbateTime, iLocation, iLevel, factory, other);
		String retMsg = "";
		ModelAndView mv = new ModelAndView();
		if(retInt > 0){
			retMsg = "添加物品信息成功";
		}else{
			retMsg = "添加物品信息失败";
		}
		mv.setViewName("main");
		mv.addObject("msg",retMsg);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/searchitem.do")
	public void searchUserController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String key = request.getParameter("searchStr");
		String retMsg = itemService.findItemByKey(key);
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(retMsg);
	}
	
	@ResponseBody
	@RequestMapping("/searchitembyid.do")
	public void searchUserByIdController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String retMsg = itemService.findItemById(id);
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(retMsg);
        response.getWriter().print(retMsg);
	}
	
	@ResponseBody
	@RequestMapping("/updateitem.do")
	public ModelAndView  updateUserController(@RequestParam("itemId") String itemId, @RequestParam("iName") String iName, @RequestParam("iNumber") String iNumber,
			@RequestParam("iSpec") String iSpec, @RequestParam("iCount") String iCount, @RequestParam("iType") String iType, 
			@RequestParam("iInstoreTime_y") String iInstoreTime_y, @RequestParam("iInstoreTime_m") String iInstoreTime_m, 
			@RequestParam("iInstoreTime_d") String iInstoreTime_d, @RequestParam("iAbateTime_y") String iAbateTime_y, 
			@RequestParam("iAbateTime_m") String iAbateTime_m, @RequestParam("iAbateTime_d") String iAbateTime_d, 
			@RequestParam("iLocation") String iLocation, 	@RequestParam("iLevel") String iLevel ,
			@RequestParam("factory") String factory, @RequestParam("other") String other) throws IOException {
		String iInstoreTime = iInstoreTime_y + "-" + iInstoreTime_m + "-" + iInstoreTime_d;
		String iAbateTime = iAbateTime_y + "-" + iAbateTime_m + "-" + iAbateTime_d;
		int retInt = itemService.updateItem(itemId, iName, iNumber, iSpec, iCount, iType, iInstoreTime, iAbateTime, iLocation, iLevel, factory, other);
		String retMsg = "";
		ModelAndView mv = new ModelAndView();
		if(retInt > 0){
			retMsg = "更新物品信息成功";
		}else{
			retMsg = "更新物品信息失败";
		}
		mv.setViewName("main");
		mv.addObject("msg",retMsg);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/deleteitem.do")
	public ModelAndView  deleteUserController(HttpServletRequest request) throws IOException {
		String ids = request.getParameter("ids");
		System.out.println("ids="+ids);
		String[] itemIds = null;
		if(ids.contains("-")){
			itemIds = ids.split("-");
		}else{
			itemIds = new String[1];
			itemIds[0] = ids;
		}
		int retInt = itemService.deleteItem(itemIds);
		System.out.println("retInt="+retInt);
		String retMsg = "";
		ModelAndView mv = new ModelAndView();
		if(retInt > 0){
			retMsg = "删除用户信息成功";
		}else{
			retMsg = "删除用户信息失败";
		}
		mv.setViewName("main");
		mv.addObject("msg",retMsg);
		return mv;
	}
}
