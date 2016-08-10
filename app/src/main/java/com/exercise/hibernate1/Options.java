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

	public void optionAddPerson(){
    	Person person = addPersonInfo();   // add personal info
    	List<Contacts> contacts = addContactsInfo();   //add contact details
    	personService.addPerson(person,contacts);
    	System.out.println("Person successfully added to database");
    }

    public void optionDeletePerson(){
    	long personId = check.inputIdNumber(" ID number of the person you want to delete.");
    	personService.deletePerson(personId);
    	System.out.println("Person successfully deleted from the database");
    }

    public void optionUpdatePerson(){
    	long personId = check.inputIdNumber("ID number of the person you want to update.");
    	boolean continueUpdate = true;
    	Person person = personService.getPersonById(personId);
    	while(continueUpdate==true){
    		System.out.println("1-First Name\n2-Middle Name\n3-Last Name\n4-Suffix\n5-Title\n6-Date of Birth\n7-Currently Employed?\n8-GWA\n9-Date Hired\n10-Address");
    		int updateInfo = check.inputNumber(" corresponding number of the info you want to update.", 1, 10);
	    	switch(updateInfo){
	    		case 1: 
	    			String firstName = check.inputString("first name");
	    			person.setFirstName(firstName);
	    			break;
	    		case 2:
	    			String middleName = check.inputString("middle name");
	    			person.setMiddleName(middleName);
	    			break;
	    		case 3:
	    			String lastName = check.inputString("last name");
	    			person.setLastName(lastName);
	    			break;
	    		case 4:
	    			String suffix = check.inputString("suffix");
	    			person.setSuffix(suffix);
	    			break;
	    		case 5:
					String title = check.inputString("title");	
					person.setTitle(title);
					break;
				case 6:
					Date birthDate = check.inputDate("date of birth");
					person.setBirthDate(birthDate);
					break;
				case 7:
					boolean employed = check.inputYesOrNo("Currently Employed?");
					person.setEmployed(employed);
					break;
				case 8:
					float gwa = check.inputGwa();
					person.setGwa(gwa);
					break;
				case 9:
					Date dateHired = check.inputDate("date hired");
					person.setDateHired(dateHired);
					break;
				case 10:
					updateAddressInfo(person);
					break;
				default:
					break;
			}
			continueUpdate = check.inputYesOrNo("Update another info from this person ? ");
		}

		personService.updatePerson(person);

	}
			
	public void updateAddressInfo(Person person){
		int houseNo = check.inputNumber("house number");
		String street = check.inputString("street");
		String barangay = check.inputString("barangay");
		String city = check.inputString("city");
		int zipCode = check.inputNumber("zipCode", zipCodeLength);

		Address updatedAddress = new Address(houseNo,street,barangay,city,zipCode);

		personService.updateAddress(updatedAddress, person);
	}

    public Person addPersonInfo(){
    	System.out.println("\n============= BASIC INFO ============");
		String firstName = check.inputString("first name");
		String middleName = check.inputString("middle name");
		String lastName = check.inputString("last name");
		String suffix = check.inputString("suffix");
		String title = check.inputString("title");
		Date birthDate = check.inputDate("date of birth");
		boolean employed = check.inputYesOrNo("Currently Employed?");
		float gwa = check.inputGwa();
		Date dateHired = check.inputDate("date hired");
		
		System.out.println("\n============== ADDRESS ===============");
		int houseNo = check.inputNumber("house number");
		String street = check.inputString("street");
		String barangay = check.inputString("barangay");
		String city = check.inputString("city");
		int zipCode = check.inputNumber("zipCode", zipCodeLength);

		Address address = new Address(houseNo,street,barangay,city,zipCode);

    	Person person = new Person(firstName, middleName,lastName, suffix, title,
			birthDate,employed,gwa, dateHired, address);

    	return person;
    }

 	public List<Contacts> addContactsInfo(){
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

}
