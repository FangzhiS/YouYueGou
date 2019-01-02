package com.offcn.domain;

public class CartItem {//购物项
	
	private Product product;  //商品
	private int count=0;   //数量
    private Double subprice ;

	public CartItem() {
		
	}
	public CartItem(Product product, int count) {

		this.product = product;
		this.count = count;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Double getSubprice() {
		return product.getShop_price()*count;   //算出小计
	}
	
    
}
