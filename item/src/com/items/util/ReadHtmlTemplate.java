package com.items.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadHtmlTemplate {
	private static String path = ReadHtmlTemplate.class.getResource("/").getPath();
	public static String ADD_APPLY_HTML = "";
	public static String ADD_ITEM_HTML = "";
	public static String ADD_USER_HTML = "";
	public static String SEARCH_APPLY_HTML = "";
	public static String SEARCH_ITEM_HTML = "";
	public static String SEARCH_USER_HTML = "";
	public static String UPDATE_ITEM_HTML = "";
	public static String UPDATE_USER_HTML = "";
	static {
		try {
			ADD_APPLY_HTML = readAddApplyHtml();
			ADD_ITEM_HTML = readAddItemHtml();
			ADD_USER_HTML = readAddUserHtml();
			SEARCH_APPLY_HTML = readSearchApplyHtml();
			SEARCH_ITEM_HTML = readSearchItemHtml();
			SEARCH_USER_HTML = readSearchUserHtml();
			UPDATE_ITEM_HTML = readUpdateItemHtml();
			UPDATE_USER_HTML = readUpdateUserHtml();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String readAddApplyHtml() {
		String html = "";
		String filePath = path + "HtmlTemplate/addapply.htm";
		try {
			String tempStr = "";
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));  
			while ((tempStr = br.readLine()) != null) {  
				html = html + tempStr; 
			}
			br.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}
	
	public static String readAddItemHtml() {
		String html = "";
		String filePath = path + "HtmlTemplate/additem.htm";
		try {
			String tempStr = "";
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));  
			while ((tempStr = br.readLine()) != null) {  
				html = html + tempStr; 
			}
			br.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}
	
	public static String readAddUserHtml() {
		String html = "";
		String filePath = path + "HtmlTemplate/adduser.htm";
		try {
			String tempStr = "";
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));  
			while ((tempStr = br.readLine()) != null) {  
				html = html + tempStr; 
			}
			br.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}
	
	public static String readSearchApplyHtml() {
		String html = "";
		String filePath = path + "HtmlTemplate/searchapply.htm";
		try {
			String tempStr = "";
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));  
			while ((tempStr = br.readLine()) != null) {  
				html = html + tempStr; 
			}
			br.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}
	
	public static String readSearchItemHtml() {
		String html = "";
		String filePath = path + "HtmlTemplate/searchitem.htm";
		try {
			String tempStr = "";
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));  
			while ((tempStr = br.readLine()) != null) {  
				html = html + tempStr; 
			}
			br.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}
	
	public static String readSearchUserHtml() {
		String html = "";
		String filePath = path + "HtmlTemplate/searchuser.htm";
		try {
			String tempStr = "";
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));  
			while ((tempStr = br.readLine()) != null) {  
				html = html + tempStr; 
			}
			br.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}
	
	public static String readUpdateItemHtml() {
		String html = "";
		String filePath = path + "HtmlTemplate/updateitem.htm";
		try {
			String tempStr = "";
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));  
			while ((tempStr = br.readLine()) != null) {  
				html = html + tempStr; 
			}
			br.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}
	
	public static String readUpdateUserHtml() {
		String html = "";
		String filePath = path + "HtmlTemplate/updateuser.htm";
		try {
			String tempStr = "";
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));  
			while ((tempStr = br.readLine()) != null) {  
				html = html + tempStr; 
			}
			br.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}
}
