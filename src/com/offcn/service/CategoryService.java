package com.offcn.service;

import java.util.List;

import com.offcn.dao.CategoryDao;
import com.offcn.domain.Category;

public class CategoryService {

	public List<Category> findCategory() throws Exception {
		CategoryDao cd= new CategoryDao();
		return cd.findCategory();
	}

}
