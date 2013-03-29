package com.stefan.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stefan.dao.SpitterDao;
import com.stefan.spitter.Spitter;

@Repository
public class HibernateSpitterDao implements SpitterDao{

	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateSpitterDao (SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addSpitter(Spitter spitter) {
		currentSession().save(spitter);
	}

	public Spitter getSpitterById(long id) {
		return (Spitter) currentSession().get(Spitter.class, id);
	}

	public void saveSpitter(Spitter spitter) {
		currentSession().update(spitter);
	}

}
