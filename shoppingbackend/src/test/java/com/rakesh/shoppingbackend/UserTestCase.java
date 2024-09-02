//package com.rakesh.shoppingbackend;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.rakesh.shoppingbackend.dao.UserDAO;
//import com.rakesh.shoppingbackend.dto.Address;
//import com.rakesh.shoppingbackend.dto.Cart;
//import com.rakesh.shoppingbackend.dto.User;
//
//
//public class UserTestCase {
//
//	
//private static AnnotationConfigApplicationContext context;
//	
//
//	private static UserDAO userDAO;
//	
//	private User  user = null;
//	private Cart cart = null;
//	private Address address = null;
//	
//	@BeforeClass
//	public static void init() {
//		context = new AnnotationConfigApplicationContext();
//		context.scan("com.rakesh.shoppingbackend");
//		context.refresh();
//		userDAO = (UserDAO) context.getBean("userDAO");
//		System.out.println("init done");
//	}
//	
//	
//	@Test
//	public void testAdd() {
//		user = new User() ;
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234512345");
//		user.setRole("CUSTOMER");
//		user.setPassword("12345");
//		
//		
//		address = new Address();
//		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//		address.setAddressLineTwo("Near Kaabil Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		
//		cart = new Cart();
//		
//		// linked the address with the user
//		address.setUser(user);
//		
//		// linked the cart with the user
//		cart.setUser(user);
//		// link the user with the cart
//		//user.setCar(cart.getId());
//		
//		// add the user
//		assertEquals("Failed to add the user!", true, userDAO.addUser(user));	
//		// add the address
//		assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));
//
//				
//		// add the shipping address
//		address = new Address();
//		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
//		address.setAddressLineTwo("Near Kudrat Store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setUser(user);
//		assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
//
//	}
//}