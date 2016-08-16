package com.exercise.hibernate1.core;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class FactoryBuilder {

	private static SessionFactory sessionFactory;

	public static SessionFactory buildSessionFactory() {
    	try{
			return new Configuration().configure("/com/exercise/hibernate1/infra/hibernate.cfg.xml").buildSessionFactory();
		}catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
