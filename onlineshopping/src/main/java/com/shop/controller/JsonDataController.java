package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakesh.shoppingbackend.dao.ProductDAO;
import com.rakesh.shoppingbackend.dto.Product;

@RestController
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;
	 
	@GetMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		//System.out.print(productDAO.listActiveProducts());		
		return productDAO.listActiveProducts();
	}
	
	@GetMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin(){
		//System.out.print(productDAO.listActiveProducts());		
		return productDAO.list();
	}
	
	@GetMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable("id") int id){
		System.out.println(id);
		return productDAO.listActiveProductsByCategory(id);
	}
}
