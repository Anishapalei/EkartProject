package com.niit.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.model.UserDetail;

@Repository(value="userDao")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionfactory;
		
		public void setSessionfactory(SessionFactory sessionfactory)
		{
			this.sessionfactory = sessionfactory;
		}
		
		
		


		@Override
		public boolean registerUser(UserDetail user) {
			try
			{
			sessionfactory.getCurrentSession().save(user);
			return true;
			}
			catch(Exception e)
			{
			return false;	
			}
		}


		@Override
		public boolean modifyUser(UserDetail user) {
			try
			{
			sessionfactory.getCurrentSession().update(user);
			return true;
			}
			catch(Exception e)
			{
			return false;	
			}
		}





		


		@Override
		public UserDetail getUser(String username) {
			Session session=sessionfactory.openSession();
			UserDetail user=(UserDetail)session.get(UserDetail.class,username);
			session.close();
			return user;
		}
	}
