package com.offcn.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.offcn.domain.Product;
import com.offcn.utils.DataSourceUtils;

public class ProductDao {

	public List<Product> fnews() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		String sql = "select * from product where pflag = ? order by pdate desc limit ? ";
		return qr.query(sql, new BeanListHandler<Product>(Product.class), 0,9);
	}

	public List<Product> fhots() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		String sql = "select * from product where pflag = ? and is_hot = ? limit ?";
		return qr.query(sql, new BeanListHandler<Product>(Product.class), 0,1,9);
	}

	public Product findBypid(String pid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		String sql = "select * from product where pid = ?" ;
		return qr.query(sql, new BeanHandler<Product>(Product.class), pid);
	}

	public List<Product> findBycid(String cid,int startIndex,int pageSize) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		String sql = "select * from product where cid = ? limit ? , ?";
		return qr.query(sql, new BeanListHandler<Product>(Product.class), cid,startIndex,pageSize);
	}

	 //某一类商品的总条数
	public int findCount(String cid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		Long nubers =  (Long) qr.query("select count(*)  from product where cid = ?", new ScalarHandler(), cid);
		return nubers.intValue();
	}

}
