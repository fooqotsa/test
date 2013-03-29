package com.stefan.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import com.stefan.dao.SpittleDao;
import com.stefan.spittle.Spittle;

public class HibernateSpittleDao implements SpittleDao{
	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateSpittleDao (SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public void addSpittle(Spittle spittle) {
		currentSession().save(spittle);
	}

	public Spittle getSpittleById(long id) {
		return (Spittle) currentSession().get(Spittle.class, id);
	}

	public void saveSpittle(Spittle spittle) {
		currentSession().update(spittle);
	}

	public List<Spittle> getSpittles(int noOfSpittles) {
		return currentSession().createCriteria(Spittle.class)
				.addOrder(Order.desc("spittle_id")).list();
	}

	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

}
