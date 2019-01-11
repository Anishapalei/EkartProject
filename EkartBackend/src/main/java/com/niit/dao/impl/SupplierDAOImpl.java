package com.niit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;




@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl  implements SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean add(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean delete(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		
		}
		catch(Exception e)
		{
		
		
		return false;	
	 }
	}

	public boolean update(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Supplier> listSuppliers() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> listSuppliers=query.list();//see the import of "Query" set to hibernate.query
		session.close();
		return listSuppliers;
	}

	public Supplier getSupplier(int supplierId) {
		Session session=sessionFactory.openSession();
		Supplier supplier=session.get(Supplier.class,supplierId);
		session.close();
		return supplier;
	}

}
