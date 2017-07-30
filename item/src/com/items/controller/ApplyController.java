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

import com.items.service.ApplyService;

@Controller
public class ApplyController {
	@Autowired
	private ApplyService applyService;
	
	@ResponseBody
	@RequestMapping("/addapply.do")
	public ModelAndView  addApplyController(@RequestParam("iName") String iName, @RequestParam("iSpec") String iSpec,
			@RequestParam("aCount") String aCount, @RequestParam("iType") String iType, @RequestParam("factory") String factory, 
			@RequestParam("other") String other, @RequestParam("applyPerson") String applyPerson) throws IOException {
		int count = Integer.parseInt(aCount);
		int retInt = applyService.addApply(iType, iName,iSpec, count,applyPerson,factory,other);
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
	@RequestMapping("/searchNameByType.do")
	public void searchNameByTypeController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String iType = request.getParameter("iType");
		String retMsg = applyService.searchNameByType(iType);
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(retMsg);
	}
	
	@ResponseBody
	@RequestMapping("/searchSpecByName.do")
	public void searchSpecByNameController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String iType = request.getParameter("iType");
		String iName = request.getParameter("iName");
		String retMsg = applyService.searchSpecByName(iType,iName);
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(retMsg);
	}
	
	@ResponseBody
	@RequestMapping("/searchFactoryBySpec.do")
	public void searchFactoryBySpecController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String iType = request.getParameter("iType");
		String iName = request.getParameter("iName");
		String iSpec = request.getParameter("iSpec");
		String retMsg = applyService.searchFactoryBySpec(iType,iName,iSpec);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(retMsg);
	}
	
	/**
	 * @author zhanghaiwei
	 * @Description 根据关键字搜索申请单，关键字范围：单据状态，物品名称
	 * @param request
	 * @param response
	 * @throws IOException
	 * @return void
	 */
	
	@ResponseBody
	@RequestMapping("/searchapply.do")
	public void searchApplyController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String keyType = request.getParameter("keytype");
		String keyValue = request.getParameter("keyvalue");
		String retMsg = applyService.findApplyByKey(keyType, keyValue);
		retMsg = retMsg.replace("new", "\u65b0\u5efa").replace("pass", "\u6279\u51c6").replace("reject", "\u62d2\u7edd");
		System.out.println(retMsg);
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(retMsg);
	}
	
	@ResponseBody
	@RequestMapping("/passCheck.do")
	public void  passCheck(HttpServletRequest request) throws IOException {
		String ids = request.getParameter("ids");
		String user = request.getParameter("user");
		String[] userIds = null;
		if(ids.contains("-")){
			userIds = ids.split("-");
		}else{
			userIds = new String[1];
			userIds[0] = ids;
		}
		int retInt = applyService.passCheck(userIds, user);
		System.out.println("retInt="+retInt);
	}
	
	@ResponseBody
	@RequestMapping("/RejectCheck.do")
	public void  RejectCheck(HttpServletRequest request) throws IOException {
		String ids = request.getParameter("ids");
		String user = request.getParameter("user");
		String[] userIds = null;
		if(ids.contains("-")){
			userIds = ids.split("-");
		}else{
			userIds = new String[1];
			userIds[0] = ids;
		}
		int retInt = applyService.RejectCheck(userIds, user);
		System.out.println("retInt="+retInt);
	}
}
