package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.Region;

public interface RegionDao {
	public List<Region> findAll();

	public List<Region> findAllActive();

	public boolean save(Region c);

	public boolean update(Region c);

	public boolean delete(int id);

	public Region findById(int id);

	public List<Region> findLikeName(String name);

}
