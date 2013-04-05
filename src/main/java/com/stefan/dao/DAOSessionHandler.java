package com.stefan.dao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	@Before("execution(* com.stefan.dao.impl.*.*(..))")
	public Session getSession(JoinPoint point){
		//Note we do NOT have to take care of closing the Session after opening it 
		//as this session is per thread basis, once the thread closes, hibernate 
		//will also close the session
		System.out.println("OPENING THE SESSION");
		System.out.println("POINT CLASS = " + point.getSignature().getName());
		return sessionFactory.openSession();
	}
	
	@AfterReturning("execution(* com.stefan.dao.impl.*.*(..))" )
	public void flushAndClearSession(){
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}
}
