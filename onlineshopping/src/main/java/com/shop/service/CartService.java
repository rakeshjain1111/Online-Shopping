package com.shop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.shoppingbackend.dao.CartLineDAO;
import com.rakesh.shoppingbackend.dao.ProductDAO;
import com.rakesh.shoppingbackend.dto.Cart;
import com.rakesh.shoppingbackend.dto.CartLine;
import com.rakesh.shoppingbackend.dto.Product;
import com.shop.model.UserModel;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;
	
	private Cart getCart() {
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}
	
	public List<CartLine> getCartLines(){
		return cartLineDAO.list(this.getCart().getId());
	}

	public String manageCartLine(int cartLineId, int count) {
		
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		}else {
			
			
			Product product = cartLine.getProduct();
			double oldTotal =cartLine.getTotal();
			
			//checking if the product is available
			if(product.getQuantity() <= count) {
				return "result = unavailable";
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

	public String deleteCartLine(int cartLineId) {
		
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		}else {
			//update the cart
			Cart cart =this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());;
			cart.setCartLine(cart.getCartLine() - 1);
			cartLineDAO.updateCart(cart);
			
			//remove the cart Line
			
			cartLineDAO.delete(cartLine);
			return "result=deleted";
		}
	}

	public String addCartLine(int productId) {
		
		String response = null;
		Cart cart = this.getCart();
		
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		
		if(cartLine == null) {
			//add a new CartLine
			
			cartLine = new CartLine();
			Product product = productDAO.get(productId);
			
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
			cartLineDAO.add(cartLine);
			
			cart.setCartLine(cart.getCartLine() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			response = "result = added";
		}
		else {
			//check if cartLine has reached the maximum count
			
			if(cartLine.getProductCount() < 3) {
				response =this.manageCartLine(cartLine.getId(), cartLine.getProductCount() + 1);
			}else {
				response = "result = maximum";
			}
			
		}
		
		
		
	return response;
	}

	
	
}
