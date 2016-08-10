package com.exercise.hibernate1.core;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;
import com.exercise.hibernate1.core.*;

public class PersonDao {

	private static SessionFactory factory = HibernatePersistence.buildSessionFactory();

	public void addPersonToDatabase(Person person, List<Contacts> contacts){	
		Session session = factory.openSession();
		try{
        	session.beginTransaction();
			person.setContacts(contacts);
         	Long personId = (Long) session.save(person);
         	session.getTransaction().commit();
      	}catch (HibernateException e) {
			e.printStackTrace(); 
      	}finally {
        	session.close();
      	}
    }
	
	public void deletePersonFromDatabase(long personId){	
		Session session = factory.openSession();
		try{
        	session.beginTransaction();
			Person person = (Person) session.get(Person.class, personId);

			session.delete(person);          
         	session.getTransaction().commit();
      	}catch (HibernateException e) {
			e.printStackTrace(); 
      	}finally {
        	session.close();
      	}
	}

	public Person getPersonFromDatabase(long personId){	
		Session session = factory.openSession();
		Person person= null;
		try{
        	session.beginTransaction();
        	person = (Person) session.get(Person.class, personId);
         	session.getTransaction().commit();
      	}catch (HibernateException e) {
			e.printStackTrace(); 
      	}finally {
        	session.close();
      	}
      	return person;
	}


	public void updatePersonToDatabase(Person person){	
		Session session = factory.openSession();
		try{
        	session.beginTransaction();
        	session.update(person);
         	session.getTransaction().commit();
      	}catch (HibernateException e) {
			e.printStackTrace(); 
      	}finally {
        	session.close();
      	}
	}

  public Address getAddressFromDatabase(long personId){ 
    Session session = factory.openSession();
    Person person= null;
    Address address= null;
    try{
          session.beginTransaction();
          person = (Person) session.get(Person.class, personId);
          address = person.getAddress();
          session.getTransaction().commit();
        }catch (HibernateException e) {
      e.printStackTrace(); 
        }finally {
          session.close();
        }
        return address;
  }

  public void updateAddressToDatabase(Address address, Person person){  
    Session session = factory.openSession();
    try{
          session.beginTransaction();
          person.setAddress(address);
          session.update(address);
          session.getTransaction().commit();
        }catch (HibernateException e) {
      e.printStackTrace(); 
        }finally {
          session.close();
        }
  }

	

}
