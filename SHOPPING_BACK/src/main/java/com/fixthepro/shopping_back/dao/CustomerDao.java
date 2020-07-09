package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.Customer;

public interface CustomerDao {
	public List<Customer> findAll();

	public List<Customer> findAllActive();

	public boolean save(Customer c);

	public boolean update(Customer c);

	public boolean delete(int id);

	public Customer findById(int id);

	public List<Customer> findLikeName(String name);
}
