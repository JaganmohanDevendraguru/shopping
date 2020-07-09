package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.Supplier;

public interface SupplierDao {

	public List<Supplier> findAll();
	public List<Supplier> findAllActive();
	public boolean save(Supplier c);
	public boolean update(Supplier c);
	public boolean delete(int id);
	public Supplier findById(int id);
	public List<Supplier> findLikeName(String name);
}
