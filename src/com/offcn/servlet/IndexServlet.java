package com.offcn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import com.offcn.domain.Category;
import com.offcn.domain.Product;
import com.offcn.service.ProductService;
import com.offcn.utils.BaseServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends BaseServlet {

	/*public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "/jsp/index.jsp";

	}*/
public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	     //查询热门商品 最新商品
	    //service层
	    ProductService  ps = new ProductService();
	    try {
			List<Product>  fns  =   ps.fnews();
			List<Product>  fhs  =  ps.fhots();
			
			request.setAttribute("fns", fns);  //最新
			request.setAttribute("fhs", fhs);  //最热门
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		return "/jsp/index.jsp";

	}

}
