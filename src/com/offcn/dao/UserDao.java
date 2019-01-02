package com.offcn.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.offcn.domain.User;
import com.offcn.utils.DataSourceUtils;

public class UserDao {

	public void register(User user) throws Exception {
		
		QueryRunner qr  =  new QueryRunner(DataSourceUtils.getDatasource());
		qr.update("insert into user values(?,?,?)", user.getUid(),user.getUsername(),user.getPassword());
		
	}

	public User login(User u) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		return qr.query("select * from  user where username=? and password = ?",new BeanHandler<User>(User.class), u.getUsername(),u.getPassword());
	}

	public Long checkUsername(String username) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDatasource());
		String sql = "select count(*) from user where username=?";
		Long query = (Long) qr.query(sql, new ScalarHandler(),username);
		return query;
	}

}
