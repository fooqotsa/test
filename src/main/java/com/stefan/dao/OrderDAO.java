package com.stefan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stefan.order.Order;

@Repository
public class OrderDAO {	
	private SessionFactory sessionFactory;
	
	@Autowired
	public OrderDAO(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void addOrder(Order order){
		currentSession().save(order);
	}
	
	public Order getOrderById(long id){
		return (Order) currentSession().get(Order.class, id);
	}
	
	public void saveOrder(Order order){
		currentSession().update(order);
	}
	
}
