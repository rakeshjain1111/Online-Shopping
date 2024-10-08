package com.shop.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.rakesh.shoppingbackend.dao.UserDAO;
import com.rakesh.shoppingbackend.dto.Address;
import com.rakesh.shoppingbackend.dto.Cart;
import com.rakesh.shoppingbackend.dto.User;
import com.shop.model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
public String saveAll(RegisterModel model ) {
		
		String transitionValue = "success";
		
		User user=model.getUser();
		
		if(user.getRole().equals("USER"))
		{
			Cart cart=new Cart();
			cart.setUser(user);
			user.setCart(cart);	
		}
		//encode the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		//save the User
		userDAO.addUser(user);
		
		
		Address billing=model.getBilling();
		billing.setUserId(user.getId());
	    billing.setBilling(true);
	    
	    userDAO.addAddress(billing);
	    
	    return transitionValue;
	}
	

	

	public String validateUser(User user, MessageContext error) {
		
		String transitionValue = "success";
		
		//checking if password matches confirm password
		if(!(user.getPassword().equals(user.getConfirmPassword()))) {
			error.addMessage(new MessageBuilder().error()
					.source("confirmPassword")
					.defaultText("Password does not match the confirm Password")
					.build()
					);
			
			transitionValue = "failure";
		}
		
		//check uniqueness of email id
		
		if(userDAO.getByEmail(user.getEmail())!=null) {
			error.addMessage(new MessageBuilder().error()
					.source("email")
					.defaultText("email id is already exist!")
					.build()
					);
			transitionValue = "failure";
		}
		
		return transitionValue;
	}
	
	
	
	
	
	
}
