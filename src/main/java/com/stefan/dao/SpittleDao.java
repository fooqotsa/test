package com.stefan.dao;

import java.util.List;

import org.hibernate.Session;
import com.stefan.spittle.Spittle;

public interface SpittleDao {
	
	void addSpittle(Spittle spittle);
	
	Spittle getSpittleById(long id);
	
	void saveSpittle(Spittle spittle);
	
	List<Spittle> getSpittles(int noOfSpittles);
	
	void deleteSpittle(Spittle spittle);
}
