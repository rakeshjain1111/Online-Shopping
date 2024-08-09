package com.rakesh.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakesh.shoppingbackend.config.HibernateConfig;
import com.rakesh.shoppingbackend.dao.CategoryDAO;
import com.rakesh.shoppingbackend.dto.Category;

public class CategoryTestCase {
     
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private  Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.rakesh.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		System.out.println("init done");
	}
	
	@Test
	public void testAddCategory() {
		category = new Category();
		
		category.setName("Mobile");
		category.setDescription("i-phone");
		category.setImageUrl("CAT_2.png");
		
		assertEquals("SuccessFully Added Category",true,categoryDAO.add(category));
	}
}
