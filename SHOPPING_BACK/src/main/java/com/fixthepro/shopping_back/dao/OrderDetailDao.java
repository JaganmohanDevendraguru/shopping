package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.OrderDetail;

public interface OrderDetailDao {

	public List<OrderDetail> findAll();

	public List<OrderDetail> findAllActive();

	public boolean save(OrderDetail c);

	public boolean update(OrderDetail c);

	public boolean delete(int id);

	public OrderDetail findById(int id);

	public List<OrderDetail> findLikeName(String name);
}
