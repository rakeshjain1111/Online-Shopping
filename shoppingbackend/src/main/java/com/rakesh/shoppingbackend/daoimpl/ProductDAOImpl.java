package com.rakesh.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakesh.shoppingbackend.dao.ProductDAO;
import com.rakesh.shoppingbackend.dto.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Product get(int productId) {
		try {
		return	sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> list() {
		try {
			return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		try {
			String selectActiveProducts = "FROM Product Where isActive = :active";
			return sessionFactory.getCurrentSession()
									.createQuery(selectActiveProducts,Product.class)
										.setParameter("active", true)
											.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		try {
			String selectActiveProducts = "FROM Product Where isActive = :active AND categoryId = :categoryId";
			return sessionFactory.getCurrentSession()
					.createQuery(selectActiveProducts,Product.class)
						.setParameter("active", true)
							.setParameter("categoryId", categoryId)
								.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		try {
			String selectActiveProducts = "FROM Product Where isActive = :active ORDER BY id";
			return sessionFactory.getCurrentSession()
					.createQuery(selectActiveProducts,Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
								.setMaxResults(count)
									.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	

}
