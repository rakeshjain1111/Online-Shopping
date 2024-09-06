package com.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rakesh.shoppingbackend.dao.UserDAO;
import com.rakesh.shoppingbackend.dto.User;
import com.shop.model.UserModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;
	@Autowired
	private UserDAO userDAO;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		if(session.getAttribute("userModel")==null){
			
			//add the user model
			Authentication authontication = SecurityContextHolder.getContext().getAuthentication();		
			User user =userDAO.getByEmail(authontication.getName());
			
			if(user!=null){
				UserModel userModel =new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName()+" "+user.getLastName());
				
				if(userModel.getRole().equals("USER")) {
					userModel.setCart(user.getCart());
				}
				
				session.setAttribute("userModel", userModel);
				return userModel;
				
			}
		}
		
		return (UserModel) session.getAttribute("userModel");
	}
}
