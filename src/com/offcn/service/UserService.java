package com.offcn.service;

import java.sql.SQLException;

import com.offcn.dao.UserDao;
import com.offcn.domain.User;

public class UserService {

	public void regist(User user) throws Exception {
		UserDao  ud = new UserDao();
		ud.register(user);
		
	}

	public User login(User u) throws Exception {
		UserDao ud = new UserDao();
		return ud.login(u);
	}

	public boolean checkUsername(String username) {
		UserDao dao = new UserDao();
		Long isExist=0L;
		try {
			isExist = dao.checkUsername(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isExist>0?true:false;
	}

}
