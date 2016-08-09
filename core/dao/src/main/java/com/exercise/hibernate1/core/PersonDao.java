package com.exercise.hibernate1.core;

import org.hibernate.*;
import org.hibernate.cfg.*;
import com.exercise.hibernate1.core.Person;

public class PersonDao {


	public void addPersonToDatabase(Person person){	
		Session session = HibernatePersistence.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(person);
		session.getTransaction().commit();
        session.close();        
        HibernatePersistence.shutdown();

	}

	

}
