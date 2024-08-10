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
		categoryDAO = (CategoryDAO) context.getBean(CategoryDAO.class);
		System.out.println("init done");
	}
	
//	@Test
//	public void testAddCategory() {
//		category = new Category();
//		
//		category.setName("Computers");
//		category.setDescription("This is Category for Computers");
//		category.setImageUrl("img_4.png");
//		
//		assertEquals("SuccessFully Added Category",true,categoryDAO.add(category));
//	}
	
//	@Test
//	public void testgetCategory() {
//		category= categoryDAO.get(1);
//		assertEquals("SuccessFully get Category","Mobile",category.getName());
//	}
	
//	@Test
//	public void testUpdateCategory() {
//		category= categoryDAO.get(2);
//		category.setName("Television");
//		assertEquals("SuccessFully update Category",true,categoryDAO.update(category));
//	}
	
//	@Test
//	public void testDeleteCategory() {
//		category= categoryDAO.get(3);
//		assertEquals("SuccessFully get Category",true,categoryDAO.delete(category));
//	}
	
	@Test
	public void testDeleteCategory() {
		assertEquals("SuccessFully getAll Category",3,categoryDAO.list().size());
	}
}
