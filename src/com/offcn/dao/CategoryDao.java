package com.offcn.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.offcn.domain.Category;
import com.offcn.utils.DataSourceUtils;

public class CategoryDao {

	public List<Category> findCategory() throws Exception {
		// 数据库的核心对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		String sql = "select * from category";
		return qr.query(sql, new BeanListHandler<Category>(Category.class));
	}

}
