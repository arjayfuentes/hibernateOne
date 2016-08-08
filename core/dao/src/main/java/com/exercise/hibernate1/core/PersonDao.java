package com.exercise.hibernate1.core;

import org.hibernate.*;
import org.hibernate.cfg.*;
import com.exercise.hibernate1.core.Person;

public class PersonDao {

	
	public void addPersonToDatabase(Person person){	
		Transaction transaction = null;
		Session session = FactoryBuilder.getSessionFactory().openSession();
		try{
			transaction = session.beginTransaction();
			session.save(person);
			session.getTransaction().commit();
		}catch(RuntimeException e){
			if(transaction != null){
				transaction.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	
		
	

}
