package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.Product;

public interface ProductDao {

	public List<Product> findAll();

	public List<Product> findAllActive();

	public boolean save(Product c);

	public boolean update(Product c);

	public boolean delete(int id);

	public Product findById(int id);

	public List<Product> findLikeName(String name);
}
