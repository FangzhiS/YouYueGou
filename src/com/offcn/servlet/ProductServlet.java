package com.offcn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.domain.PageBean;
import com.offcn.domain.Product;
import com.offcn.service.ProductService;
import com.offcn.utils.BaseServlet;

public class ProductServlet extends BaseServlet{
	public String findBypid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收pid
		String pid = request.getParameter("pid");
		//调用Service层
		ProductService ps = new ProductService();
		try {
			Product  product  =  ps.findBypid(pid);
			request.setAttribute("pro", product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/jsp/product_info.jsp";

	}
	public String findBycid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		String cid = request.getParameter("cid");
		//pageNumber
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		//Service层
		ProductService ps = new ProductService();
		try {
			PageBean pb =  ps.findBycid(cid,pageNumber);
			request.setAttribute("pb", pb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/product_list.jsp";
		
	}
}
