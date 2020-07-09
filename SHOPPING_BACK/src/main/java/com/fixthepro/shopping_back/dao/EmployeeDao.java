package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();

	public List<Employee> findAllActive();

	public boolean save(Employee c);

	public boolean update(Employee c);

	public boolean delete(int id);

	public Employee findById(int id);

	public List<Employee> findLikeName(String name);
}
