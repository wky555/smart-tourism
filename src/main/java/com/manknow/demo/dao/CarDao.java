package com.manknow.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.manknow.demo.BeanA;

import po.CarHistory;
import util.HibernateUtil;


@Repository
public class CarDao {	
	@Autowired
	private SessionFactory sessionFactory;
	public BeanA a;

	
	public BeanA getA() {
		return a;
	}
	public void setA(BeanA a) {
		this.a = a;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void addCarHistory() {
		
		
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        CarHistory car = new CarHistory();
        car.setId((long) 5);
        car.setName("wky");
        session.saveOrUpdate(car);
        
       

        session.getTransaction().commit();
	}
	/**
	 * 采用@Autowired按类型注入SessionFactory, 当有多个SesionFactory的时候在
	 */
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
