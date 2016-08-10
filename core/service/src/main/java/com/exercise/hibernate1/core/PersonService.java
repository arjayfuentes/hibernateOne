package com.exercise.hibernate1.core;

import java.util.List;

public class PersonService {

	private PersonDao personDao = new PersonDao();

	public void addPerson(Person person, List<Contacts>contacts){
		personDao.addPersonToDatabase(person, contacts);
	}

	public void deletePerson(long personId){
		personDao.deletePersonFromDatabase(personId);
	}

	public Person getPersonById(long personId) {
		return personDao.getPersonFromDatabase(personId);
	}

	public void updatePerson(Person person){
		personDao.updatePersonToDatabase(person);
	}

	public Address getAddressById(long personId) {
		return personDao.getAddressFromDatabase(personId);
	}

	public void updateAddress(Address address, Person person){
		personDao.updateAddressToDatabase(address, person);
	}



}
