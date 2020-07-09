package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.Order;

public interface OrderDao {

	public List<Order> findAll();

	public List<Order> findAllActive();

	public boolean save(Order c);

	public boolean update(Order c);

	public boolean delete(int id);

	public Order findById(int id);

	public List<Order> findLikeName(String name);
}
