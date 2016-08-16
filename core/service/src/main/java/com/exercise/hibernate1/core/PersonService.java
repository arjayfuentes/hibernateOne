package com.exercise.hibernate1.core;

import java.util.List;
import java.util.ArrayList;

public class PersonService {

	private PersonDao personDao = new PersonDao();
	private ContactsDao contactsDao = new ContactsDao();
	
	//option1
	public void addPerson(Person person, List<Contacts> contacts){
		person.setContacts(contacts);
		personDao.addPersonDatabase(person);
	}

	//option2
	public void deletePerson(long personId){
		personDao.deletePersonFromDatabase(personId);
	}

	//option3
	public void updatePerson(long personId, Person updatedPerson){
		personDao.updatePersonToDatabase(personId, updatedPerson);
	}

	//option4 GWA
	public List<Person> getPersonsGwa(){
		List <Person> persons = personDao.getAllPersonsFromDatabase();
		persons.sort((Person o1, Person o2)-> (int) ((o1.getGwa()*1000) - (o2.getGwa()*1000)));  //sort using lambda
		return persons;
	}

	//option 4 date hired and last name
	public List<Person> getPersons(String order){
		List<Person> persons = new ArrayList<>();
		if (order.equals("last_name")){
			persons = personDao.getPersonsFromDatabase("last_name");
		} else if (order.equals("date_hired")){
			persons = personDao.getPersonsFromDatabase("date_hired");
		} else {
			persons = personDao.getPersonsFromDatabase("personId");
		}
		return persons;
	}

	//option5
	public void addContact(long personId, String contactType, String contactValue){
		Contacts addCon = new Contacts(contactType,contactValue);
		contactsDao.addPersonContactDatabase(personId,addCon);
	}

	//option6
	public void updateContact(long contactId, String newContactValue){
		contactsDao.updatePersonContactDatabase(contactId, newContactValue);
	}

	//option7
	public void deleteContact(long contactId){
		contactsDao.deletePersonContactDatabase(contactId);
	}

	//validation if person exist
	public boolean checkPersonIfExist(long personId){
		if(personDao.getPersonById(personId)== null){
			return false;
		}
		else{
			return true;
		}
	}

	//validation if contactId exist for a specific person
	public boolean checkContactIfExist(long personId, long contactId){
		List<Contacts> contacts = contactsDao.getPersonContactsById(personId);
		boolean contactExist = false;
		loop: for(Contacts con : contacts){
			if(con.getContactId()==contactId){
				contactExist=true;
				break loop;
			}
		}
		return contactExist;
	}

	/*--------------------------------------------  fetching data -------------------------------------------------*/

	//getPerson's information
	public Person getPersonById(long personId) {
		return personDao.getPersonById(personId);
	}

	//get Person's Address
	public Address getPersonAddressById(long personId){
		return personDao.getPersonAddressById(personId);
	}

	//get Person's Contacts
	public List<Contacts> getPersonContactsById(long personId){
		return contactsDao.getPersonContactsById(personId);
	}



}
