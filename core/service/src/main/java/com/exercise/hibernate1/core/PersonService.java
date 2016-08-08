package com.exercise.hibernate1.core;


public class PersonService {

	private PersonDao personDao = new PersonDao();

	public void addPerson(Person person){
		personDao.addPersonToDatabase(person);
	}


}
