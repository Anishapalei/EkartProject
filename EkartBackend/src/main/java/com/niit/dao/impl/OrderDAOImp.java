package com.niit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.OrderDAO;
import com.niit.model.Category;
import com.niit.model.OrderDetail;
@Repository(value="orderDAO")
@Transactional
public class OrderDAOImp implements OrderDAO {

	@Autowired
	SessionFactory sessionFactory;
//	 public OrderDAOImp(SessionFactory sessionFactory)
//	    {
//	    	this.sessionFactory=sessionFactory;
//	    }

		public boolean insertOrderDetail(OrderDetail orderDetail) 
		{
			try
			{
				sessionFactory.getCurrentSession().save(orderDetail);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		@Override
		public List<OrderDetail>retrieveOrderDetail(String username) 
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from OrderDetail where username=:username ");
			query.setParameter("username", username);
			List<OrderDetail> listOrderDetail=query.list();
			session.close();
			return listOrderDetail;
		}

		@Override
		public OrderDetail getOrderDetail(int orderId) {
			Session session=sessionFactory.openSession();
			OrderDetail order=session.get(OrderDetail.class, orderId);
			session.close();
			
			return order;
		}

	

	
}
