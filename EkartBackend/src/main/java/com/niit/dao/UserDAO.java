package com.niit.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.niit.model.UserDetail;
@Repository("userDAO")
@Transactional
public interface UserDAO {
	public boolean registerUser(UserDetail user);
	public boolean modifyUser(UserDetail user);
	public UserDetail getUser(String username);

}
