package com.fixthepro.shopping_back.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fixthepro.shopping_back.dao.CategoryDao;
import com.fixthepro.shopping_back.dto.Category;
import com.fixthepro.shopping_back.mapper.CategoryRowMapper;

@Repository
public class CategoryDaoImpl implements CategoryDao{
	
	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public List<Category> findAll() {
		StringBuilder select = new StringBuilder("select c.* from category c");
		return jdbc.query(select.toString(), new CategoryRowMapper());
	}

	@Override
	public List<Category> findAllActive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Category c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Category c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findLikeName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
