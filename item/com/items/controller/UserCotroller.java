package com.items.controller;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.items.service.UserService;
import com.items.util.Result;

@Controller
//@RequestMapping("/item")
public class UserCotroller {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public ModelAndView UserCotroller(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpServletRequest request) {
		String retMsg = "";
		Map result = userService.CheckLogin(username, password);
		retMsg = result.getMsg();
		ModelMap params = new ModelMap();
		params.addAttribute("retValue", result);
		ModelAndView modelAndView = null;
		if (retMsg.contains("success")) {
			modelAndView = new ModelAndView("success", params);
		} else {
			modelAndView = new ModelAndView("error", params);
		}
		return modelAndView;
	}
}
