package com.rakesh.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakesh.shoppingbackend.dao.ProductDAO;
import com.rakesh.shoppingbackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private  Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.rakesh.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean(ProductDAO.class);
	}
//	
//	@Test
//	public void TestAddProduct() {
//		product = new Product();
//		product.setBrand("LG");
//		product.setName("LG TV");
//		product.setDescription("Samsung LED TV 53cm");
//		product.setPurchases(0);
//		product.setUnitPrice(14000);
//		product.setCategoryId(1);
//		product.setSupplierId(2);
//		product.setQuantity(100);
//		product.setViews(0);
//		assertEquals("Add PRoduct Successfully", true,productDAO.add(product));
//	}
//	
//	@Test
//	public void TestUpdateProduct() {
//		product = productDAO.get(8);
//		product.setDescription("LG LED TV 54 cm ");
//		assertEquals("update PRoduct Successfully", true,productDAO.update(product));
//	}
	
//	@Test
//	public void TestDeleteProduct() {
//		product = productDAO.get(9);
//		assertEquals("delete PRoduct Successfully", true,productDAO.delete(product));
//	}

	
//	@Test
//	public void TestListProduct() {
//		assertEquals("get All PRoduct Successfully", 3,productDAO.list().size());
//	}
//	
//	@Test
//	public void TestListActiveProduct() {
//		assertEquals("get active PRoduct Successfully", 2,productDAO.listActiveProducts().size());
//	}
	

//	@Test
//	public void TestListActiveProductByCategory() {
//		assertEquals("get active PRoduct by Category Id Successfully", 1,productDAO.listActiveProductsByCategory(2).size());
//	}
	

	@Test
	public void TestLatestActiveProducts() {
		assertEquals("get latest PRoduct Successfully", 2,productDAO.getLatestActiveProducts(2).size());
	}
	
}
