package com.stefan.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {
	
	@Autowired
	protected SessionFactory sessionFactory;

	protected Session currentSession() {
		System.out.println("ABSTRACT DAO IS BEING HIT");
		return sessionFactory.getCurrentSession();
	}
}
