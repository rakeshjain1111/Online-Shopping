package com.rakesh.shoppingbackend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rakesh.shoppingbackend.config.HibernateConfig;
import com.rakesh.shoppingbackend.dao.CategoryDAO;
import com.rakesh.shoppingbackend.dto.Category;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
    	context.register(HibernateConfig.class);
    	context.refresh();
    	CategoryDAO categoryDAO=(CategoryDAO) context.getBean(CategoryDAO.class);
    	Category category = new Category();
		
		category.setName("Mobile");
		category.setDescription("i-phone");
		category.setImageUrl("CAT_2.png");
		
		categoryDAO.add(category);
    }
    
}
