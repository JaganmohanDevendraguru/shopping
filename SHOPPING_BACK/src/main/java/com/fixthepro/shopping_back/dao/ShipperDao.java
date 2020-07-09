package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.Shipper;

public interface ShipperDao {

	public List<Shipper> findAll();
	public List<Shipper> findAllActive();
	public boolean save(Shipper c);
	public boolean update(Shipper c);
	public boolean delete(int id);
	public Shipper findById(int id);
	public List<Shipper> findLikeName(String name);
}
