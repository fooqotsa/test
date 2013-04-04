package com.stefan.dao;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class DAOSessionHandler {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public DAOSessionHandler(){
	}
	
	public DAOSessionHandler(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Pointcut("execution(* com.stefan.dao.AbstractDao.*())")
	public void currentSession(){		
	}
	
	@Before("currentSession()")
	public Session getSession(){
		System.out.println("OPENING THE SESSION");
		if (sessionFactory.isClosed()){
			sessionFactory.openSession();
		}		
		return sessionFactory.getCurrentSession();
	}
	
	
	public void closeSession(){
		System.out.println("CLOSING THE SESSION");
		sessionFactory.close();
	}
	
}
