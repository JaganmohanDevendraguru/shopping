package com.fixthepro.shopping_back.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fixthepro.shopping_back.dao.CategoryDao;
import com.fixthepro.shopping_back.dto.Category;
import com.fixthepro.shopping_back.mapper.CategoryRowMapper;

/*
 * Implementation of its DAO class
 * Uses jdbc template in this implementation.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

	/*
	 * Injecting JDBC template
	 */
	@Autowired
	private JdbcTemplate jdbc;

	/*
	 * Get all without any active status checking
	 * 
	 * @return list of items
	 */
	@Override
	public List<Category> findAll() {
		StringBuilder select = new StringBuilder("select c.* from category c");
		return jdbc.query(select.toString(), new CategoryRowMapper());
	}

	/*
	 * Get all items with checking of active status
	 * 
	 * @return list of items
	 */
	@Override
	public List<Category> findAllActive() {
		String active = "select c.* from category c where c.discontinued=0";
		return jdbc.query(active, new CategoryRowMapper());
	}

	/*
	 * Insert a new item to the DB
	 * 
	 * @return integer value of updated row
	 */
	@Override
	public int save(Category c) {
		String insert = "INSERT INTO category (category_id, category_name, description, picture_path, discontinued) VALUES (?,?,?,?,?)";
		return jdbc.update(insert, c.getCategoryId(), c.getCategoryName(), c.getDescription(), c.getPicturePath(),
				c.isDiscontinued());
	}

	/*
	 * Update the item. It updates all fields in the table
	 * 
	 * @return integer based on the affected row count
	 */
	@Override
	public int update(Category c) {
		String update = "update category set category_id=?, category_name=?, description=?, picture_path=?, discontinued=?";
		return jdbc.update(update, c.getCategoryId(), c.getCategoryName(), c.getDescription(), c.getPicturePath(),
				c.isDiscontinued());
	}

	/*
	 * Though it says delete, rather deleting it, updating the status and deactive
	 * it So, it is like update
	 * 
	 * @return integer
	 */
	@Override
	public int delete(int id) {
		String delete = "update category set discontinued=? where category_id=?";
		return jdbc.update(delete, id);
	}

	/*
	 * Get one item by the primary key mostly the ID
	 * 
	 * @return the single item
	 */
	@Override
	public Category findById(int id) {
		String findOne = "select c.* from category c where c.category_id=?";
		return jdbc.queryForObject(findOne, new CategoryRowMapper(), id);
	}

	/*
	 * Search and get all items by the name matching
	 * 
	 * @return list of items
	 */
	@Override
	public List<Category> findLikeName(String name) {
		String like = "select c.* from category c where c.category_name like ?";
		return jdbc.query(like, new CategoryRowMapper(), "%" + name + "%");
	}

}
