package com.stefan.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stefan.dao.AbstractDao;
import com.stefan.dao.SpitterDao;
import com.stefan.spitter.Spitter;
import com.stefan.spittle.Spittle;

@Repository
public class HibernateSpitterDao extends AbstractDao implements SpitterDao{

	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateSpitterDao (SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public HibernateSpitterDao(){}

	public void addSpitter(Spitter spitter) {
		currentSession().save(spitter);
	}

	public Spitter getSpitterById(long id) {
		return (Spitter) currentSession().get(Spitter.class, id);
	}

	public void saveSpitter(Spitter spitter) {
		currentSession().update(spitter);
	}

	public Spitter getSpitter(String username) {
		return (Spitter) currentSession().createCriteria(Spitter.class)
				.add(Restrictions.eq("name", username)).uniqueResult();
	}
	

}
