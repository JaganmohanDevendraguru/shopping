package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.Category;

public interface CategoryDao {

	public List<Category> findAll();

	public List<Category> findAllActive();

	public int save(Category c);

	public int update(Category c);

	public int delete(int id);

	public Category findById(int id);

	public List<Category> findLikeName(String name);
}
