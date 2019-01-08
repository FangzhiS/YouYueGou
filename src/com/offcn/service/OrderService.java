package com.offcn.service;

import java.util.List;

import com.offcn.dao.OrderDao;
import com.offcn.domain.Order;
import com.offcn.domain.OrderItem;

public class OrderService {

	public void addOrder(Order order) throws Exception {
		OrderDao oder = new OrderDao();
		oder.addOrder(order);  //添加订单
		for(OrderItem orderItem : order.getList()) {
			
			oder.addOrderItem(orderItem); // 添加订单项
		}
		
	}

	public List<Order> findAllOrder(String uid) throws Exception {
		OrderDao  oder =  new OrderDao(); 
		return oder.findAllOrder(uid);
	}

	public Order findByoid(String oid) throws Exception {
		OrderDao  oder =  new OrderDao(); 
		return oder.findByoid(oid);
	}

}
