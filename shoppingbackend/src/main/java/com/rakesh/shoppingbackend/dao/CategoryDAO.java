package com.rakesh.shoppingbackend.dao;

import java.util.List;

import com.rakesh.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	public boolean add(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);
	public List<Category> list();
	public Category get(int id); 
	
}
