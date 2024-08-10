package com.rakesh.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
	
	
	public List<Category> list() {
		String selectActiveCategory = "FROM Category Where active = :active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
