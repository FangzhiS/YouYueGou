package com.offcn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.domain.Cart;
import com.offcn.domain.CartItem;
import com.offcn.domain.Product;
import com.offcn.domain.User;
import com.offcn.service.ProductService;
import com.offcn.utils.BaseServlet;

public class CartServlet extends BaseServlet {
	public String add(HttpServletRequest request, HttpServletResponse response) {

		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "请登录");
			return "/jsp/login.jsp";
		}
		String pid = request.getParameter("pid");
		int count = Integer.parseInt(request.getParameter("count"));
		Cart cart = getCart(request);
		ProductService ps = new ProductService();
		try {
			Product product = ps.findBypid(pid);
			CartItem cartItem = new CartItem(product, count);
			cart.add2cart(cartItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/jsp/cart.jsp";
	}

	private Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		return cart;
	}

	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg", "请登录");
			return "";

		}
		String pid = request.getParameter("pid");
		Cart cart = getCart(request);
		cart.removeCartItem(pid);// 移除购物项

		return "/jsp/cart.jsp";

	}

	public String clearCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 判断用户是否登录
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {

			request.setAttribute("msg", "请登录");
			return "/jsp/login.jsp";

		}

		Cart cart = getCart(request);
		cart.clearCart();

		return "/jsp/cart.jsp";

	}
}
