package com.rakesh.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rakesh.shoppingbackend.dao.CategoryDAO;
import com.rakesh.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
 
    private static List<Category> cats = new ArrayList<Category>();	
	static {
		Category category =new Category();
		category.setId(101);
		category.setName("TV");
		category.setDescription("This is TV");
		category.setImageUrl("img");
		
		cats.add(category);
		
		category =new Category();
		category.setId(102);
		category.setName("REmote");
		category.setDescription("This is Remote");
		category.setImageUrl("img2");
		
		cats.add(category);
		
		category =new Category();
		category.setId(103);
		category.setName("Redio");
		category.setDescription("This is Redio");
		category.setImageUrl("img3");
		
		cats.add(category);
	}
	
	public List<Category> list() {
		return cats;
	}

}