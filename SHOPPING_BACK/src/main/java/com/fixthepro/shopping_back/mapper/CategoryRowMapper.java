package com.fixthepro.shopping_back.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fixthepro.shopping_back.dto.Category;

public class CategoryRowMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category = new Category();
		category.setCategoryId(rs.getInt(1));
		category.setCategoryName(rs.getString(2));
		category.setDescription(rs.getString(3));
		category.setPicturePath(rs.getString(4));
		category.setDiscontinued(rs.getBoolean(5));
		return category;
	}

}
