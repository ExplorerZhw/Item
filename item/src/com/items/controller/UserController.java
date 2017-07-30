package com.items.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.items.service.UserService;

@Controller
public class UserController {

	// private UserServiceImpl userService = new UserServiceImpl();
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("/login.do")
	public ModelAndView  loginController(@RequestParam("username") String username, @RequestParam("password") String password) {
		Map<String, String> map = userService.login(username, password);
		ModelAndView mv = new ModelAndView();
		String retMsg = map.get("msg");
		if(retMsg.contains("success")){
			mv.setViewName("main");
			mv.addObject("name",map.get("name"));
			mv.addObject("loginName",map.get("loginName"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE");
			mv.addObject("mydate",sdf.format(new Date()));
		}else{
			mv.setViewName("login");
			if(retMsg.equals("error1")){
				retMsg = "用户名不存在";
			}else if(retMsg.equals("error1")){
				retMsg = "密码错误";
			}else{
				retMsg = "服务错误，请联系管理员";
			}
		}
		if(retMsg.contains("success")){
			retMsg = "";
		}
		mv.addObject("msg",retMsg);
		return mv;
	}

	@ResponseBody
	@RequestMapping("/adduser.do")
	public ModelAndView  addUserController(@RequestParam("loginName") String loginName, @RequestParam("name") String name,
			@RequestParam("password") String password, @RequestParam("iLevel") String iLevel) throws IOException {
		int retInt = userService.addUser(loginName, name, password, iLevel);
		String retMsg = "";
		ModelAndView mv = new ModelAndView();
		if(retInt > 0){
			retMsg = "添加用户成功";
		}else{
			retMsg = "添加用户失败";
		}
		mv.setViewName("main");
		mv.addObject("msg",retMsg);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/searchuser.do")
	public void searchUserController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String key = request.getParameter("searchStr");
		String retMsg = userService.findUserByKey(key);
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(retMsg);
	}
	
	@ResponseBody
	@RequestMapping("/searchuserbyid.do")
	public void searchUserByIdController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String retMsg = userService.findUserById(id);
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(retMsg);
        response.getWriter().print(retMsg);
	}
	
	@ResponseBody
	@RequestMapping("/updateuser.do")
	public ModelAndView  updateUserController(@RequestParam("userid") String userId,@RequestParam("loginName") String loginName, @RequestParam("name") String name,
			@RequestParam("password") String password, @RequestParam("iLevel") String iLevel) throws IOException {
		int retInt = userService.updateUser(userId, loginName, name, password, iLevel);
		String retMsg = "";
		ModelAndView mv = new ModelAndView();
		if(retInt > 0){
			retMsg = "更新用户信息成功";
		}else{
			retMsg = "更新用户信息失败";
		}
		mv.setViewName("main");
		mv.addObject("msg",retMsg);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/deleteuser.do")
	public ModelAndView  deleteUserController(HttpServletRequest request) throws IOException {
		String ids = request.getParameter("ids");
		System.out.println("ids="+ids);
		String[] userIds = null;
		if(ids.contains("-")){
			userIds = ids.split("-");
		}else{
			userIds = new String[1];
			userIds[0] = ids;
		}
		int retInt = userService.deleteUser(userIds);
		System.out.println("retInt="+retInt);
		String retMsg = "";
		ModelAndView mv = new ModelAndView();
		if(retInt > 0){
			retMsg = "更新用户信息成功";
		}else{
			retMsg = "更新用户信息失败";
		}
		mv.setViewName("main");
		mv.addObject("msg",retMsg);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/checkUserExist.do")
	public void checkUserExistController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String loginName = request.getParameter("loginName");
		System.out.println("checkUserExist.do"+loginName);
		int retInt = userService.checkUserExist(loginName);
		String retMsg = "";
		if(retInt == 1) {
			retMsg = "ok";
		}
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(retMsg);
	}
}
