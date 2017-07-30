package com.items.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.items.util.ReadHtmlTemplate;

@Controller
public class LoadHtmlController {
	
	@ResponseBody
	@RequestMapping("/addApplyHtml.do")
	public void addApplyController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String html = ReadHtmlTemplate.ADD_APPLY_HTML;
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(html);
	}
	
	@ResponseBody
	@RequestMapping("/addItemHtml.do")
	public void addItemController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String html = ReadHtmlTemplate.ADD_ITEM_HTML;
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(html);
	}
	
	@ResponseBody
	@RequestMapping("/addUserHtml.do")
	public void addUserController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String html = ReadHtmlTemplate.ADD_USER_HTML;
		System.out.println(html);
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(html);
	}
	
	@ResponseBody
	@RequestMapping("/searchApplyHtml.do")
	public void searchApplyController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String html = ReadHtmlTemplate.SEARCH_APPLY_HTML;
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(html);
	}
	
	@ResponseBody
	@RequestMapping("/searchItemHtml.do")
	public void searchItemController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String html = ReadHtmlTemplate.SEARCH_ITEM_HTML;
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(html);
	}
	
	@ResponseBody
	@RequestMapping("/searchUserHtml.do")
	public void searchUserController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String html = ReadHtmlTemplate.SEARCH_USER_HTML;
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(html);
	}
	
	@ResponseBody
	@RequestMapping("/updateItemHtml.do")
	public void updateItemController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String html = ReadHtmlTemplate.UPDATE_ITEM_HTML;
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(html);
	}
	
	@ResponseBody
	@RequestMapping("/updateUserHtml.do")
	public void updateUserController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String html = ReadHtmlTemplate.UPDATE_USER_HTML;
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(html);
	}
}
