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

	public void updateAddressToDatabase(long personId, Address newAddress){
    Session session = factory.openSession();
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
      Person person =(Person)session.get(Person.class, personId);
      Address address = person.getAddress();
      person.setAddress(newAddress);
      session.update(person);
      tx.commit();
    }catch (HibernateException e) {
      if (tx!=null) tx.rollback();
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

  public void addContactToDatabase(long personId,Contacts addCon){
    Session session = factory.openSession();
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
      Person person =(Person)session.get(Person.class, personId);
      person.getContacts().add(addCon);
      session.update(person);
      tx.commit();
    }catch (HibernateException e) {
      if (tx!=null) tx.rollback();
      e.printStackTrace();
    }finally {
      session.close();
    }
  }

  public List<Contacts> getContactsFromDatabase(long personId){
    Session session = factory.openSession();
    List<Contacts> contacts= null;
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
      Person person =(Person)session.get(Person.class, personId);
      contacts=person.getContacts();
      tx.commit();
    }catch (HibernateException e) {
      if (tx!=null) tx.rollback();
      e.printStackTrace();
    }finally {
      session.close();
    }
    return contacts;
  }

  /*
  public void updateContactsInDatabase(long personId, List<Contacts> contacts){
  	Session session = factory.openSession();
    Person person = null;
      try{
        session.beginTransaction();
        person = (Person) session.get(Person.class, personId);
        person.setContacts(contacts);
        session.saveOrUpdate(person);
        session.getTransaction().commit();
      }catch (HibernateException e) {
        e.printStackTrace(); 
      }finally {
        session.close();
      }
    }


*/



}
