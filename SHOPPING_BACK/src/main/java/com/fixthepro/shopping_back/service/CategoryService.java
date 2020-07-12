package com.fixthepro.shopping_back.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fixthepro.shopping_back.dto.Category;

public interface CategoryService {
	public List<Category> getListOfCategories();

	public List<Category> getListOfActiveCategories();

	public boolean updateCategory(Category c);

	public boolean insertCategory(Category c, MultipartFile file);

	public boolean deleteCategory(int id);

	public List<Category> searchByName(String q);

	Category getCategoryById(int id);
}
