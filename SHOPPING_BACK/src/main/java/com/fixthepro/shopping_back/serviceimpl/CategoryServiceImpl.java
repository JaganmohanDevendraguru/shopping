package com.fixthepro.shopping_back.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fixthepro.shopping_back.dao.CategoryDao;
import com.fixthepro.shopping_back.dto.Category;
import com.fixthepro.shopping_back.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	@Override
	public List<Category> getListOfCategories() {
		return categoryDao.getCategories();
	}

}
