package com.stefan.dao;

import com.stefan.spitter.Spitter;

public interface SpitterDao {
	
	void addSpitter(Spitter spitter);
	
	Spitter getSpitterById(long id);
	
	void saveSpitter(Spitter spitter);
	
	Spitter getSpitter(String username);
}
