package com.exercise.hibernate1.core;

import java.util.List;
import java.util.ArrayList;

public class PersonService {

	private PersonDao personDao = new PersonDao();

	public void addPerson(Person person, List<Contacts>contacts){
		personDao.addPersonToDatabase(person, contacts);
	}

	public void deletePerson(long personId){
		personDao.deletePersonFromDatabase(personId);
	}

	public void updatePerson(Person person){
		personDao.updatePersonToDatabase(person);
	}

	public void updateAddress(long personId, Address address){
		personDao.updateAddressToDatabase(personId, address);
	}

	public Person getPersonById(long personId) {
		return personDao.getPersonFromDatabase(personId);
	}

	public Address getAddressById(long personId) {
		return personDao.getAddressFromDatabase(personId);
	}

	public boolean checkPersonIfExist(long personId){
		if(personDao.getPersonFromDatabase(personId)== null){
			return false;
		}
		else{
			return true;
		}
	}

	public void addContact(long personId, String contactType, String contactValue){
		Contacts addCon = new Contacts(contactType,contactValue);
		personDao.addContactToDatabase(personId,addCon);

	}

	public List<Contacts> getContacts(long personId){
		List<Contacts> contacts = new ArrayList<Contacts>();
		contacts= personDao.getContactsFromDatabase(personId);
		return contacts;
	}

	public void updateContact(){

	}


}
