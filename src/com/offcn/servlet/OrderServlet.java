package com.offcn.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.domain.Cart;
import com.offcn.domain.CartItem;
import com.offcn.domain.Order;
import com.offcn.domain.OrderItem;
import com.offcn.domain.User;
import com.offcn.service.OrderService;
import com.offcn.utils.BaseServlet;
import com.offcn.utils.UUIDUtils;

public class OrderServlet extends BaseServlet {
	public String addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
	      //判断用户是否登录
			User  user = (User) request.getSession().getAttribute("user");
			if(user==null) {
				
				request.setAttribute("msg", "请登录");
				return "/jsp/login.jsp" ;
				
			} 
			
			//导入数据 数据从购物车中导入到订单中
			Cart cart  = (Cart) request.getSession().getAttribute("cart");
			
			Order  order = new Order();
			order.setOid(UUIDUtils.getUuuids());
			order.setOrdertime(new Date());
			
			order.setTotal(cart.getTotalCount());
			order.setState(0);
			order.setUser(user);
			//封装订单项和 购物x项
			for(CartItem citem : cart.getItem()) {
				
				OrderItem otem  = new OrderItem();
				otem.setItemid(UUIDUtils.getUuuids());
				otem.setCount(citem.getCount());
				otem.setSubtotal(citem.getSubprice());
				otem.setProduct(citem.getProduct());
				otem.setOrder(order);
				order.getList().add(otem);
			}
			
			//调用Service层 
			OrderService orderService = new OrderService();
			try {
				orderService.addOrder(order);
				cart.clearCart();//清空购物车 
				request.setAttribute("order", order);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	
			
			return "/jsp/order_info.jsp";

}
public String findAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//判断用户是否登录
	User  user = (User) request.getSession().getAttribute("user");
	if(user==null) {
		
		request.setAttribute("msg", "请登录");
		return "/jsp/login.jsp" ;
		
	} 
	
	//查询用户所有的订单信息
	//调用Service层
	OrderService  osService = new OrderService();
	try {
		List<Order>  list  =  osService.findAllOrder(user.getUid());
		request.setAttribute("list", list);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	return "/jsp/order_list.jsp";
	
}
public String findByoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//判断用户是否登录
	User  user = (User) request.getSession().getAttribute("user");
	if(user==null) {
		
		request.setAttribute("msg", "请登录");
		return "/jsp/login.jsp" ;
		
	} 
	
	//查询用户所有的订单信息
	//调用Service层
	String oid = request.getParameter("oid");
	OrderService  osService = new OrderService();
	try {
		Order order = osService.findByoid(oid);
		request.setAttribute("order", order);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	return "/jsp/order_info.jsp";
	
}

}
