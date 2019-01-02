package com.offcn.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;

import com.offcn.domain.User;
import com.offcn.service.UserService;
import com.offcn.utils.BaseServlet;
import com.offcn.utils.UUIDUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.beanutils.BeanUtils;

public class UserServlet extends BaseServlet {

	public String registerUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //System.out.println("zhuce.........");
		return "/jsp/register.jsp";

	}
	public String quit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		//return "/jsp/index.jsp";
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		return null;
	}
	public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//接收参数
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, map);
			user.setUid(UUIDUtils.getUuuids());
			//调用Service层
			UserService  us = new UserService();
			us.regist(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/jsp/login.jsp";
		
	}
public String checkUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String username = request.getParameter("username");
	
	UserService service = new UserService();
	boolean isExist = service.checkUsername(username);
	
	String json = "{\"isExist\":"+isExist+"}";
	
	response.getWriter().write(json);
		
		return "/jsp/login.jsp";
		
	}
	public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      //接收参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 封装
		 User u  = new User();
		 u.setUsername(username);
		 u.setPassword(password);
		 
		 //调用Service
		 UserService  us = new UserService();
		 try {
			User  user = us.login(u);
			if(user==null) {
				request.setAttribute("msg", "用户名或密码错误");
				return "/jsp/login.jsp" ;
			}else {
				
				HttpSession session = request.getSession();//创建session对象
				session.setAttribute("user", user); 
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 return null;
		
	}

}
