package com.offcn.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

public class Cart {//购物车
	
	private  Double totalCount = 0.0;  //总金额
	private Map<String,CartItem>  map = new HashMap<String,CartItem>();  //购物项存在
	
	
	
	//添加购物车的功能
	public  void  add2cart(CartItem cartItem) {
		String pid = cartItem.getProduct().getPid(); //获得当前购物的商品的id
		//假如这个商品我们之前没有购买过
		if(!map.containsKey(pid)) {//之前没有加入购物车
			
			map.put(pid, cartItem);
			
		}else {//之前买过这个商品 
			
			 //获得之前商品在购物车中的数量
			int oldcount = map.get(pid).getCount();
			int newcount = oldcount+cartItem.getCount();
			
			CartItem cartItem2 = map.get(pid);
			cartItem2.setCount(newcount);  //更新为最新的数量
		}
		
		totalCount = totalCount+cartItem.getSubprice();
		
	}
	
	
	//移除购物项，通过商品的id移除购物项
	public  void  removeCartItem(String pid) {
		
		CartItem cartItem = map.remove(pid);
		
		totalCount= totalCount-cartItem.getSubprice();
		
	}
	
	//清除购物项
	public  void  clearCart() {
		
		map.clear();
		totalCount=0.0;
		
	
		
	}
	
	//cart.item 等到一个 购物项的集合 
	public   Collection<CartItem>  getItem(){
		
		Collection<CartItem> values = map.values();
		return values;
	}
	
	
	public Double getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Double totalCount) {
		this.totalCount = totalCount;
	}
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	
	

}
