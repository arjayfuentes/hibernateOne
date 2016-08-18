package com.exercise.hibernate1.core;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class FactoryBuilder {

	    private static final SessionFactory sessionFactory = buildSessionFactory();

	    private static SessionFactory buildSessionFactory() {
	        try {
	            return new Configuration().configure("/com/exercise/hibernate1/infra/hibernate.cfg.xml").buildSessionFactory();
	        } catch (Throwable ex) {
	            System.err.println("SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
}
