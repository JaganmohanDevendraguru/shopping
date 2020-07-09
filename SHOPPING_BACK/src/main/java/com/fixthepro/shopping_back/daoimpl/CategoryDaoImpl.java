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
	public List<Category> getCategories() {
		StringBuilder select = new StringBuilder("select c.* from category c");
		return jdbc.query(select.toString(), new CategoryRowMapper());
	}

}
