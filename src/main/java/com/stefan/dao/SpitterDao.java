package com.stefan.dao;

import org.hibernate.Session;

import com.stefan.spitter.Spitter;

public interface SpitterDao {

	Session currentSession();
	
	void addSpitter(Spitter spitter);
	
	Spitter getSpitterById(long id);
	
	void saveSpitter(Spitter spitter);
	
}
