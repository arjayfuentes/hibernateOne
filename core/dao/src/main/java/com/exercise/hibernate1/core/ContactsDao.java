package com.exercise.hibernate1.core;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;
import com.exercise.hibernate1.core.*;

public class ContactsDao {

        //option 5
	public void addPersonContactDatabase(long personId,Contacts addCon){
		Session session = FactoryBuilder.getSessionFactory().openSession();
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

  	//option 6
	public void updatePersonContactDatabase(long contactId, String newContactValue){
		Session session = FactoryBuilder.getSessionFactory().openSession();
		Transaction tx = null;
		try{
		  tx = session.beginTransaction();
		  Contacts contacts = (Contacts)session.get(Contacts.class, contactId);
		  contacts.setContactValue(newContactValue);
		  session.update(contacts);
		  tx.commit();
	    }catch (HibernateException e) {
		  if (tx!=null) tx.rollback();
		  e.printStackTrace();
		}finally {
		  session.close();
		}
	}

        //option 7
	public void deletePersonContactDatabase(long contactId){
		Session session = FactoryBuilder.getSessionFactory().openSession();
		Transaction tx = null;
		try{
		  tx = session.beginTransaction();
		  Contacts contacts = (Contacts)session.get(Contacts.class, contactId);
		  session.delete(contacts);
		  tx.commit();
		}catch (HibernateException e) {
		  if (tx!=null) tx.rollback();
		  e.printStackTrace();
		}finally {
		  session.close();
		}
	}

  /*--------------------------------- fetching data --------------------------------------*/

  	//use to display person contacts
	public List<Contacts> getPersonContactsById(long personId){
		List<Contacts> contacts = new ArrayList<>();
		Session session = FactoryBuilder.getSessionFactory().openSession();
		Transaction tx = null;
		try{
		  tx = session.beginTransaction();
		  String hql = "from Contacts where personid = :id";
		  Query query = session.createQuery(hql);
		  query.setParameter("id",personId);
		  contacts = query.list();
		  tx.commit();
		}catch (HibernateException e) {
		  if (tx!=null) tx.rollback();
		  e.printStackTrace();
		}finally {
		  session.close();
		}
		return contacts;
	}

}
