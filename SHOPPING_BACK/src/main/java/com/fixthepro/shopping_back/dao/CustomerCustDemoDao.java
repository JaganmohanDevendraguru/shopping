package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.CustomerCustDemo;

public interface CustomerCustDemoDao {

	public List<CustomerCustDemo> findAll();

	public List<CustomerCustDemo> findAllActive();

	public boolean save(CustomerCustDemo c);

	public boolean update(CustomerCustDemo c);

	public boolean delete(int id);

	public CustomerCustDemo findById(int id);

	public List<CustomerCustDemo> findLikeName(String name);
}
