package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.Category;

public interface CategoryDao {

	public List<Category> findAll();

	public List<Category> findAllActive();

	public boolean save(Category c);

	public boolean update(Category c);

	public boolean delete(int id);

	public Category findById(int id);

	public List<Category> findLikeName(String name);
}
