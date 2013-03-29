package com.stefan.spitter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stefan.dao.SpittleDao;
import com.stefan.spittle.Spittle;

public class SpitterService {

	@Autowired
	SpittleDao spittleDao;
	
	public List<Spittle> getRecentSpittles(int defaultSpittlesPerPage) {
		return spittleDao.getSpittles(defaultSpittlesPerPage);
	}

}
