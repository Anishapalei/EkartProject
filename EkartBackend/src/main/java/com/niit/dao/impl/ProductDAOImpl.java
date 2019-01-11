package com.niit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Product> listProducts() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listProducts=query.list();//see the import of "Query" set to hibernate.query
		session.close();
		return listProducts;
	}

	@Override
	public Product getProduct(int productId) {
		
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class,productId);
		session.close();
		return product;
	}

	@Override
	public List<Product> listCategoryWiseProducts(int categoryId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where categoryId=:categoryId");
		query.setParameter("categoryId", categoryId);
		List<Product> listProducts=query.list();//see the import of "Query" set to hibernate.query
		session.close();
		return listProducts;
	}
	
}
