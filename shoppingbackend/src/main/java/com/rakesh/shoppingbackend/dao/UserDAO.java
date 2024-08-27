package com.rakesh.shoppingbackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakesh.shoppingbackend.dto.Address;
import com.rakesh.shoppingbackend.dto.Cart;
import com.rakesh.shoppingbackend.dto.User;



public interface UserDAO {
  
	boolean addUser(User user);
	boolean addAddress(Address address);
	boolean updateCart(Cart cart);
	public User getByEmail(String email);
	
	public Address getBillingAddress(User user);
	public List<Address> listShippingAddresses(User user);
}
