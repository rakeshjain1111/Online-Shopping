package com.shop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.shoppingbackend.dao.CartLineDAO;
import com.rakesh.shoppingbackend.dto.Cart;
import com.rakesh.shoppingbackend.dto.CartLine;
import com.rakesh.shoppingbackend.dto.Product;
import com.shop.model.UserModel;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	private Cart getCart() {
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}
	
	public List<CartLine> getCartLines(){
		return cartLineDAO.list(this.getCart().getId());
	}

	public String updateCartLine(int cartLineId, int count) {
		
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		}else {
			Product product = cartLine.getProduct();
			
			double oldTotal =cartLine.getTotal();
			if(product.getQuantity() <= count) {
				count = product.getQuantity();
			}
			cartLine.setProductCount(count);
			cartLine.setTotal(product.getUnitPrice() * count);
			cartLineDAO.update(cartLine);
			Cart cart =this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal +cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			return "result = updated";
		}
	}
	
	
}
