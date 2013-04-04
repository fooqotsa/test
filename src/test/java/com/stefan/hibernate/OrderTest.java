package com.stefan.hibernate;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.stefan.ApplicationContextProvider;
import com.stefan.dao.OrderDAO;
import com.stefan.order.Order;

@Configuration
public class OrderTest {
	
	/*@Autowired
	OrderDAO orderDao;
	
	@Test
	public void testOrderCreation(){
		
		Order order = new Order();
		order.setOrderId(1);
		order.setOrderDate(new Date());
		order.setCustomerName("Richa");
		order.setOrderType("Small");
		orderDao.saveOrder(order);
		
	}*/
}
