package com.rakesh.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakesh.shoppingbackend.dao.CategoryDAO;
import com.rakesh.shoppingbackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
    private static List<Category> cats = new ArrayList<Category>();	
	static {
		Category category =new Category();
		category.setId(101);
		category.setName("TV");
		category.setDescription("This is TV");
		category.setImageUrl("img");
		
		cats.add(category);
		
		category =new Category();
		category.setId(102);
		category.setName("REmote");
		category.setDescription("This is Remote");
		category.setImageUrl("img2");
		
		cats.add(category);
		
		category =new Category();
		category.setId(103);
		category.setName("Redio");
		category.setDescription("This is Redio");
		category.setImageUrl("img3");
		
		cats.add(category);
	}
	
	public List<Category> list() {
		return cats;
	}

	@Override
	public Category get(int id) {
		for(Category category: cats) {
			if(category.getId()==id) {
				return category;
			}
		}
		return null;
	}

	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

}
