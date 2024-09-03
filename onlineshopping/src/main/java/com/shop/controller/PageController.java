package com.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rakesh.shoppingbackend.dao.CategoryDAO;
import com.rakesh.shoppingbackend.dao.ProductDAO;
import com.rakesh.shoppingbackend.dto.Category;
import com.rakesh.shoppingbackend.dto.Product;
import com.shop.exception.ProductNotFoundException;
@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value= "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value= "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	 // /show/category/${category.id}/products
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView showCateogryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		Category category =null;
		category = categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView singleProduct(@PathVariable int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		if(product == null) throw new ProductNotFoundException();
		product.setViews(product.getViews()+1);
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct",true);
		return mv;
	}
	
	
	/* login */
	
	@RequestMapping(value= "/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("title","Login");
		return mv;
	}
}
