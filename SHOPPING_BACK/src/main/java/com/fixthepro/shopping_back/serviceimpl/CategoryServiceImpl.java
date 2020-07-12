package com.fixthepro.shopping_back.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fixthepro.shopping_back.dao.CategoryDao;
import com.fixthepro.shopping_back.dto.Category;
import com.fixthepro.shopping_back.service.CategoryService;
import com.fixthepro.shopping_back.util.FileUtil;

/*
 * Service class for Category. It is almost identical to repository
 * 
 * @author Jagan
 * 
 */
@Service
public class CategoryServiceImpl implements CategoryService{
	
	private Logger log = LoggerFactory.getLogger(CategoryService.class);

	@Autowired
	private CategoryDao categoryDao;
	@Override
	public List<Category> getListOfCategories() {
		return categoryDao.findAll();
	}
	
	@Override
	public List<Category> getListOfActiveCategories() {
		return categoryDao.findAllActive();
	}

	@Override
	public boolean updateCategory(Category c) {
		int result = categoryDao.update(c);
		if(result == 1)
			return true;
		return false;
	}

	@Override
	public boolean insertCategory(Category c, MultipartFile file) {
		//if image is attached
			log.info("file is there");
			//set the file name
			String newName = FileUtil.getFileName(file);
			log.info("new Name: " + newName);
			c.setPicturePath(newName);
			//saving data to DB
			int result = categoryDao.save(c);
			//if db is saved successfully
			if(result == 1) {
				FileUtil.uploadProcess(file, newName);
				return true;
			}
			//failed to save in DB, so return without image saving
			else {
				return false;
			}	
	}

	@Override
	public boolean deleteCategory(int id) {
		int result = categoryDao.delete(id);
		if(result == 1)
			return true;
		return false;
	}

	@Override
	public List<Category> searchByName(String q) {
		return categoryDao.findLikeName(q);
	}
	
	@Override
	public Category getCategoryById(int id) {
		return categoryDao.findById(id);
	}
}
