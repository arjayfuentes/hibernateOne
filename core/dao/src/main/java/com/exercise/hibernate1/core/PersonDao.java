package com.exercise.hibernate1.core;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;
import com.exercise.hibernate1.core.*;

public class PersonDao {

	private static SessionFactory factory = HibernatePersistence.buildSessionFactory();

  //option1
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
	
  //option2
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

  //option3
  public void updatePersonToDatabase(long personId, Person updatedPerson){
    Session session = factory.openSession();
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
      Person person =(Person)session.get(Person.class, personId);
      person.setFirstName(updatedPerson.getFirstName());
      person.setMiddleName(updatedPerson.getMiddleName());
      person.setLastName(updatedPerson.getLastName());
      person.setSuffix(updatedPerson.getSuffix());
      person.setTitle(updatedPerson.getTitle());
      person.setBirthDate(updatedPerson.getBirthDate());
      person.setEmployed(updatedPerson.getEmployed());
      person.setGwa(updatedPerson.getGwa());
      person.setDateHired(updatedPerson.getDateHired());
      person.setAddress(updatedPerson.getAddress());
      session.update(person);
      tx.commit();
    }catch (HibernateException e) {
      if (tx!=null) tx.rollback();
      e.printStackTrace();
    }finally {
      session.close();
    }
  }

  //option7
  public void addPersonContactDatabase(long personId,Contacts addCon){
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

  //option8
  public void updatePersonContactDatabase(long contactId, String newContactValue){
    Session session = factory.openSession();
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
      Contacts contacts = (Contacts)session.get(Contacts.class, contactId);
      contacts.setContactValue(newContactValue);
      session.update(contacts);
      tx.commit();
    }catch(RuntimeException e){
      e.printStackTrace();
    }finally{
      session.close();
    }
  }

  //option9
  public void deletePersonContactDatabase(long contactId){
    Session session = factory.openSession();
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
      Contacts contacts = (Contacts)session.get(Contacts.class, contactId);
      session.delete(contacts);
      tx.commit();
    }catch(RuntimeException e){
      e.printStackTrace();
    }finally{
      session.close();
    }
  }

  public void listPersonsByOrder(String order){




  }

  //get all persons
  public List<Person> getAllPersonsFromDatabase(){
    Session session = factory.openSession();
    Transaction tx = null;
    List<Person> persons = new ArrayList<>(); 
    try{
      tx = session.beginTransaction();
      persons = session.createQuery("from Person").list();
      tx.commit();
    }catch (RuntimeException e) {
      e.printStackTrace();
    }finally {
      session.close();
    }
    return persons;
  }

  //use to display person contacts
  public List<Contacts> getContactsPerson(long personId){
    List<Contacts> contacts = new ArrayList<>();
    Session session = factory.openSession();
    Transaction tx = null;
    try{
      tx = session.beginTransaction();
      String hql = "from Contacts where personid = :id";
      Query query = session.createQuery(hql);
      query.setParameter("id",personId);
      contacts = query.list();
      tx.commit();
    }catch(RuntimeException e){
      e.printStackTrace();
    }finally{
      session.close();
    }
    return contacts;
  }

  //use to check if person exist and updating person's info
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
  

}
