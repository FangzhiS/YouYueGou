package com.offcn.service;

import java.util.List;

import com.offcn.dao.ProductDao;
import com.offcn.domain.PageBean;
import com.offcn.domain.Product;

public class ProductService {

	public List<Product> fnews() throws Exception {
		ProductDao pd = new ProductDao();
		return pd.fnews();
	}

	public List<Product> fhots() throws Exception {
		ProductDao pd = new ProductDao();
		return pd.fhots();
	}

	public Product findBypid(String pid) throws Exception {
		ProductDao pd = new ProductDao();
		return pd.findBypid(pid);
	}

	public PageBean findBycid(String cid,int pageNumber) throws Exception {
		ProductDao pd = new ProductDao();
		PageBean pb = new PageBean();
		//设置当前页数
		 pb.setPageNumber(pageNumber);
		//每页显示的条数
		  int  pageSize = 12;
		pb.setPageSize(pageSize);
		//总条数
		int totalCount = pd.findCount(cid);
		pb.setTotalCount(totalCount);
		//总页数
		int totalPage = 0;
		if(totalCount%pageSize==0) {
			
			totalPage = totalCount/pageSize ;
		}else {
			
			totalPage = totalCount/pageSize+1;
		}
		pb.setTotalPage(totalPage);
		
		int startIndex = (pageNumber-1)*pageSize;
		List<Product>  list = pd.findBycid(cid,startIndex,pageSize);
		pb.setList(list);
		return pb ;
	}

}
