package com.exercise.hibernate1;

import java.util.*;
import com.exercise.hibernate1.core.*;

public class Options{

	private Scanner read = new Scanner(System.in);
	private CheckInput check = new CheckInput();
	private PersonService personService = new PersonService();
	private Person person = new Person();
	private static int zipCodeLength=4;
	private static int landlineLength=6;
	private static int mobileLength=11;

	//option1
	public void optionAddPerson(){
		displayPersons();
    	Person person = addPersonInfo();   // add personal info : basic and address
    	List<Contacts> contacts = addContactsInfo();   //add contact details
    	personService.addPerson(person,contacts);
<<<<<<< HEAD
    	System.out.println("\n\t================ UPDATED LIST =================");
    	displayPersons();
=======

>>>>>>> 193a60d7045634bc314544cf97059193641f11fa
    	System.out.println("Person successfully added to database");
    }

    //option2
    public void optionDeletePerson(){
<<<<<<< HEAD
    	displayPersons();
    	long personId = checkIfPersonExist("ID number of the person you want to delete.");
    	personService.deletePerson(personId);
    	System.out.println("\n\t================ UPDATED LIST =================");
    	displayPersons();
=======
    	long personId = checkIfPersonExist("ID number of the person you want to delete.");
    	personService.deletePerson(personId);

>>>>>>> 193a60d7045634bc314544cf97059193641f11fa
    	System.out.println("Person successfully deleted from the database");
    }

    //option3
    public void optionUpdatePerson(){
<<<<<<< HEAD
    	displayPersons();
    	long personId = checkIfPersonExist("ID number of the person you want to update.");
    	boolean continueUpdate = true;
    	int updateInfo=0;
    	Person updatedPerson = personService.getPersonById(personId);
    	loop: while(continueUpdate==true){
    		System.out.println("\nChoose from the following:\n1-First Name\n2-Middle Name\n3-Last Name\n4-Suffix\n5-Title\n6-Date of Birth\n7-Currently Employed?\n8-GWA\n9-Date Hired\n10-Address\n11-All Information");
    		updateInfo = check.inputNumber(" corresponding number of the info you want to update.", 1, 11);
=======
    	long personId = checkIfPersonExist("ID number of the person you want to update.");
    	boolean continueUpdate = true;
    	int updateInfo=0;
    	Person person = personService.getPersonById(personId);
    	while(continueUpdate==true){
    		System.out.println("\nChoose from the following:\n1-First Name\n2-Middle Name\n3-Last Name\n4-Suffix\n5-Title\n6-Date of Birth\n7-Currently Employed?\n8-GWA\n9-Date Hired\n10-Address\n11-All Information");
    		updateInfo = check.inputNumber(" corresponding number of the info you want to update.", 1, 10);
>>>>>>> 193a60d7045634bc314544cf97059193641f11fa
	    	switch(updateInfo){
	    		case 1: 
	    			String firstName = check.inputString("first name");
	    			updatedPerson.setFirstName(firstName);
	    			break;
	    		case 2:
	    			String middleName = check.inputString("middle name");
	    			updatedPerson.setMiddleName(middleName);
	    			break;
	    		case 3:
	    			String lastName = check.inputString("last name");
	    			updatedPerson.setLastName(lastName);
	    			break;
	    		case 4:
	    			String suffix = check.inputString("suffix");
	    			updatedPerson.setSuffix(suffix);
	    			break;
	    		case 5:
					String title = check.inputString("title");	
					updatedPerson.setTitle(title);
					break;
				case 6:
					Date birthDate = check.inputDate("date of birth");
					updatedPerson.setBirthDate(birthDate);
					break;
				case 7:
					boolean employed = check.inputYesOrNo("Currently Employed?");
					updatedPerson.setEmployed(employed);
					break;
				case 8:
					float gwa = check.inputGwa();
					updatedPerson.setGwa(gwa);
					break;
				case 9:
					Date dateHired = check.inputDate("date hired");
					updatedPerson.setDateHired(dateHired);
					break;
				case 10:
					Address address = addAddressInfo();
					updatedPerson.setAddress(address);
					break;
				case 11:
					updatedPerson = (addPersonInfo());
					break loop;
				default:
					break;
			}
			continueUpdate = check.inputYesOrNo("Update another info to this person ? ");
		}
		personService.updatePerson(personId, updatedPerson);
	}

	//option4
	public void optionListPersonByGwa(){
		/* to follow
		order person using java
		lambda*/

		listPersonsOrder(persons);
	}

	//option5
	public void optionListPersonByDateHired(){
		String order = "date_hired";
		List<Person> persons = personService.listPersonOrder(order);
		listPersonsOrder(persons);
	}

	//option6
	public void optionListPersonByLastName(){
		String order = "last_name";
		List<Person> persons = personService.listPersonOrder(order);
		listPersonsOrder(persons);
	}

	//option7
	public void optionAddContact(){
		long personId = checkIfPersonExist("ID number of the person you want to add contacts.");
		displayContacts(personId);
		Contacts contacts = new Contacts();
		String contactType=null;
 		String contactValue=null;
 		boolean continueAddContacts= true;
 		while(continueAddContacts==true){
			int typeCon = check.inputNumber(" Contact Type: [1] Landline [2] Mobile [3] Email ", 1 , 3 );
			switch(typeCon){
				case 1:
					contactType = "Landline";
					contactValue = check.inputContactNumber("landline", 7); 
					break;
				case 2:
					contactType = "Mobile";
					contactValue = check.inputContactNumber("mobile", 11);
					break;
				case 3:
					contactType = "Email";
					contactValue = check.inputEmail();
					break;
				default:
					break;
			}
			personService.addContact(personId, contactType,contactValue);
			continueAddContacts = check.inputYesOrNo("Want to add another contact?");
		}	
		displayContacts(personId);
		System.out.println("Contact/s succesfully added");
	}

	//option8
	public void optionUpdateContact(){
		long personId = checkIfPersonExist("ID number of the person you want to update contacts.");
		displayContacts(personId);
		long contactId = checkIfContactExist("contactId to update", personId);
		String newContactType= null;
		String newContactValue=null;
		List<Contacts> updatedContacts = personService.getContactsById(personId);
		for(Contacts con : updatedContacts){
			if(con.getContactId()==contactId){
				newContactType = con.getContactType();
				break;
			}
		}
		switch(newContactType){
				case "Landline":
					newContactValue = check.inputContactNumber("landline", 7); 
					break;
				case "Mobile":
					newContactValue = check.inputContactNumber("mobile", 11);
					break;
				case "Email":
					newContactValue = check.inputEmail();
					break;
				default:
					break;
		}
		personService.updateContact(contactId, newContactValue);
		displayContacts(personId);
		System.out.println("Contact/s succesfully updated");
	}

	//option9
	public void optionDeleteContact(){
		long personId = checkIfPersonExist("ID number of the person you want to delete contacts.");
		List<Contacts> updatedContacts = personService.getContactsById(personId);
		displayContacts(personId);
		long contactId = checkIfContactExist("contactId to delete", personId);
		personService.deleteContact(contactId);
		displayContacts(personId);
		System.out.println("Contact/s succesfully deleted");
	}

	public void listPersonsOrder(List<Person> persons){
		for(Person person : persons){

		}

		
	}


	public void displayPersons(){
		List<Person> personList = personService.getAllPersons();
		System.out.println("\n  \tList Of Persons from the database: ");
		System.out.println("  \t------------------------------------------------");
		System.out.println("  \t"+"Person Id"+ "      " + "First Name" + "   " + "LastName");
		System.out.println("  \t------------------------------------------------");
		for(Person person : personList){
			System.out.println("  \t     "+person.getPersonId()+ "\t       " +person.getFirstName() + "\t     " + person.getLastName());
		}
		System.out.println("\t------------------------------------------------\n");
	}

	public void displayContacts(long personId){
		List<Contacts> contacts = personService.getContactsById(personId);
		System.out.println("\n  \tContacts of Person Id: "+personId+"\n");
		System.out.println("  \t------------------------------------------------");
		System.out.println("  \t"+"Contact Id"+ "     " + "Type" + "\t     " + "Value");
		System.out.println("  \t------------------------------------------------");
		for(Contacts con : contacts){
			System.out.println("  \t     "+con.getContactId()+ "\t       " +con.getContactType() + "\t     " + con.getContactValue());
		}
		System.out.println("\t------------------------------------------------\n");
	}

    public Person addPersonInfo(){
    	System.out.println("\n=============== BASIC INFO ==============");
		String firstName = check.inputString("first name");
		String middleName = check.inputString("middle name");
		String lastName = check.inputString("last name");
		String suffix = check.inputString("suffix");
		String title = check.inputString("title");
		Date birthDate = check.inputDate("date of birth");
		boolean employed = check.inputYesOrNo("Currently Employed?");
		float gwa = check.inputGwa();
		Date dateHired = check.inputDate("date hired");

		Address address = addAddressInfo();
		
    	Person person = new Person(firstName, middleName,lastName, suffix, title,
			birthDate,employed,gwa, dateHired, address);
    	return person;
    }

    public Address addAddressInfo(){
    	System.out.println("\n=============== ADDRESS ==================");
		int houseNo = check.inputNumber("house number");
		String street = check.inputString("street");
		String barangay = check.inputString("barangay");
		String city = check.inputString("city");
		int zipCode = check.inputNumber("zipCode", zipCodeLength);

		Address address = new Address(houseNo,street,barangay,city,zipCode);
		return address;
    }

    public List<Contacts> addContactsInfo(){
 		System.out.println("\n============== CONTACTS =================");
 		List<Contacts> contacts = new ArrayList<Contacts>();
 		String contactType=null;
 		String contactValue=null;
 		boolean continueAddContacts= true;

 		while(continueAddContacts==true){
			int typeCon = check.inputNumber(" Contact Type: [1] Landline [2] Mobile [3] Email ", 1 , 3 );
			switch(typeCon){
				case 1:
					contactType = "Landline";
					contactValue = check.inputContactNumber("landline", 7); 
					break;
				case 2:
					contactType = "Mobile";
					contactValue = check.inputContactNumber("mobile", 11);
					break;
				case 3:
					contactType = "Email";
					contactValue = check.inputEmail();
					break;
				default:
					break;
			}
			Contacts addCon = new Contacts(contactType,contactValue);
			contacts.add(addCon);
			continueAddContacts = check.inputYesOrNo("Want to add another contact?");
		}	
		return contacts;
	}

    public long checkIfPersonExist(String message){
    	long personId= 0;
    	do{
    		personId = check.inputIdNumber(message);
    		if(personService.checkPersonIfExist(personId)==false){
    			System.out.print("Id number not exist! ");
    		}
    	}while((personService.checkPersonIfExist(personId)) == false);
    	return personId;
    }

	public long checkIfContactExist(String message, long personId){
    	long contactId= 0;
    	do{
    		contactId = check.inputIdNumber(message);
    		if(personService.checkContactIfExist(personId, contactId)==false){
    			System.out.print("contactId for person with personId = "+personId+" does not exist. ");
    		}
    	}while((personService.checkContactIfExist(personId, contactId)) == false);
    	return contactId;
    }
}

