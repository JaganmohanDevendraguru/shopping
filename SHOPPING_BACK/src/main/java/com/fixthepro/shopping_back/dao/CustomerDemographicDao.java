package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.CustomerDemographic;

public interface CustomerDemographicDao {

	public List<CustomerDemographic> findAll();

	public List<CustomerDemographic> findAllActive();

	public boolean save(CustomerDemographic c);

	public boolean update(CustomerDemographic c);

	public boolean delete(int id);

	public CustomerDemographic findById(int id);

	public List<CustomerDemographic> findLikeName(String name);
}
