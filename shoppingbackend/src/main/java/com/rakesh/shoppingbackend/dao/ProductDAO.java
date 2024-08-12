package com.rakesh.shoppingbackend.dao;

import java.util.List;

import com.rakesh.shoppingbackend.dto.Product;

public interface ProductDAO {
	public boolean add(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	public List<Product> list();
	public Product get(int productId);
	
	//Business method
	public List<Product> listActiveProducts();
	public List<Product> listActiveProductsByCategory(int categoryId);
	public List<Product> getLatestActiveProducts(int count);
}
