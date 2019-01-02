package com.offcn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.offcn.domain.Category;
import com.offcn.service.CategoryService;
import com.offcn.utils.BaseServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryServlet extends BaseServlet {

	public String findCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html;charset=utf-8");
		 //调用Service层
		 CategoryService cs = new CategoryService();
		 try {
			List<Category>  list =  cs.findCategory();
			//json串的转换
			ObjectMapper om = new ObjectMapper();
			String str = om.writeValueAsString(list);
			response.getWriter().print(str);
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		return null;

	}

}
