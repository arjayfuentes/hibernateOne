package com.exercise.hibernate1;

import java.util.Date;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import com.exercise.hibernate1.core.*;


public class Options{

	private Scanner read = new Scanner(System.in);
	private CheckInput check = new CheckInput();
	private PersonService personService = new PersonService();
	private Person person = new Person();
	private static int zipCodeLength=4;
	private static int landlineLength=6;
	private static int mobileLength=11;


    public void createPerson(){
    	System.out.println("\n============= BASIC INFO ============");

		String firstName = check.inputString("first name");
		String middleName = check.inputString("middle name");
		String lastName = check.inputString("last name");
		String suffix = check.inputString("suffix");
		String title = check.inputString("title");
		Date birthDate = check.inputDate("date of birth");
		boolean employed = check.inputEmployed();
		float gwa = check.inputGwa();
		Date dateHired = check.inputDate("date Hired");
		
		System.out.println("\n============== ADDRESS ===============");
		int houseNo = check.inputNumber("house number");
		String street = check.inputString("street");
		String barangay = check.inputString("barangay");
		String city = check.inputString("city");
		int zipCode = check.inputNumber("zipCode", zipCodeLength);

		Address address = new Address(houseNo,street,barangay,city,zipCode);

    	Person person = new Person(firstName, middleName,lastName, suffix, title,
			birthDate, employed,gwa, dateHired, address);

    	personService.addPerson(person);
    	System.out.println("Person created and added to database. ");
    }

 



}
