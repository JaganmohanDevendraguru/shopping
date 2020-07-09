package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.Cart;

public interface CartDao {

	public List<Cart> findAll();

	public List<Cart> findAllActive();

	public boolean save(Cart c);

	public boolean update(Cart c);

	public boolean delete(int id);

	public Cart findById(int id);

	public List<Cart> findLikeName(String name);

}
