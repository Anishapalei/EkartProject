package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.niit.model.OrderDetail;

public interface OrderDAO {


	public boolean insertOrderDetail(OrderDetail orderDetail);
	public List<OrderDetail> retrieveOrderDetail(String username) ;
	public OrderDetail getOrderDetail(int orderId);
}

