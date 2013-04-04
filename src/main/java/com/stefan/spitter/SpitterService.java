package com.stefan.spitter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stefan.dao.impl.HibernateSpitterDao;
import com.stefan.dao.impl.HibernateSpittleDao;
import com.stefan.spittle.Spittle;

public class SpitterService {

	@Autowired
	HibernateSpittleDao spittleDao;
	@Autowired
	HibernateSpitterDao spitterDao;
	
	public List<Spittle> getRecentSpittles(int defaultSpittlesPerPage) {
		return spittleDao.getSpittles(defaultSpittlesPerPage);
	}

	public Spitter getSpitter(String username) {
		return spitterDao.getSpitter(username);
	}

	public List<Spittle> getSpittlesForSpitter(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveSpitter(Spitter spitter) {
		spitterDao.saveSpitter(spitter);
	}

	public Spittle getSpittleById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveSpittle(Spittle spittle) {
		// TODO Auto-generated method stub
		
	}

	public void deleteSpittle(long id) {
		Spittle spittle = spittleDao.getSpittleById(id);
		spittleDao.deleteSpittle(spittle);	
	}

}
