package com.stefan.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stefan.dao.AbstractDao;
import com.stefan.dao.SpittleDao;
import com.stefan.spittle.Spittle;

@Repository
public class HibernateSpittleDao extends AbstractDao implements SpittleDao{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateSpittleDao (SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public HibernateSpittleDao(){}
	
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
		return currentSession().createCriteria(Spittle.class).list();
	}
	
	public void deleteSpittle(Spittle spittle){
		currentSession().delete(spittle);
	}
	
}
