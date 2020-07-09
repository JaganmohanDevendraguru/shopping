package com.fixthepro.shopping_back.dao;

import java.util.List;

import com.fixthepro.shopping_back.dto.Address;

public interface AddressDao {

	public List<Address> findAll();

	public List<Address> findAllActive();

	public boolean save(Address c);

	public boolean update(Address c);

	public boolean delete(int id);

	public Address findById(int id);

	public List<Address> findLikeName(String name);
}
