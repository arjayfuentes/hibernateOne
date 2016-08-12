package com.exercise.hibernate1.core;

import java.util.List;
import java.util.ArrayList;

public class PersonService {

	private PersonDao personDao = new PersonDao();

	//option1
	public void addPerson(Person person, List<Contacts>contacts){									
		personDao.addPersonToDatabase(person, contacts);
	}

	//option2
	public void deletePerson(long personId){														
		personDao.deletePersonFromDatabase(personId);
	}

	//option3
	public void updatePerson(long personId, Person updatedPerson){									
		personDao.updatePersonToDatabase(personId, updatedPerson);
	}

	//option7
	public void addContact(long personId, String contactType, String contactValue){					
		Contacts addCon = new Contacts(contactType,contactValue);
		personDao.addPersonContactDatabase(personId,addCon);
	}

	//option8
	public void updateContact(long contactId, String newContactValue){
		personDao.updatePersonContactDatabase(contactId, newContactValue);
	}

	//option9
	public void deleteContact(long contactId){														
		personDao.deletePersonContactDatabase(contactId);
	}

	//option 5 and 6
	public List<Person> listPersonsOrder(String order){
		return personDao.listPersonsOrder(order);
	}

	//to display all person
	public List<Person> getAllPersons(){
		return personDao.getAllPersonsFromDatabase();
	}

	//validation if person exist
	public boolean checkPersonIfExist(long personId){
		if(personDao.getPersonFromDatabase(personId)== null){
			return false;
		}
		else{
			return true;
		}
	}

	//validation if contactId exist for a specific person	
	public boolean checkContactIfExist(long personId, long contactId){
		List<Contacts> contacts = personDao.getContactsPerson(personId);
		boolean contactExist = false;
		loop: for(Contacts con : contacts){
			if(con.getContactId()==contactId){
				contactExist=true;
				break loop;
			}
		}
		return contactExist;
		
	}		

	//use in option3 in updating person info
	public Person getPersonById(long personId) {
		return personDao.getPersonFromDatabase(personId);
	}

	//display person's contacts
	public List<Contacts> getContactsById(long personId){
		return personDao.getContactsPerson(personId);
	}
	
	

}
