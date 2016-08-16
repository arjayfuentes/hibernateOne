package com.exercise.hibernate1.core;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Person {

	private long personId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String suffix;
	private String title;
	private Date birthDate;
	private boolean employed;
	private float gwa;
	private Date dateHired;
	private Address address;
	private List<Contacts> contacts= new ArrayList<Contacts>();

	public Person(){}

	public Person(String firstName, String middleName,String lastName, String suffix, String title,
		   Date birthDate,boolean employed,float gwa, Date dateHired, Address address){

		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
		this.suffix=suffix;
		this.title=title;
		this.birthDate=birthDate;
		this.employed=employed;
		this.gwa=gwa;
		this.dateHired=dateHired;
		this.address=address;

	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean getEmployed() {
		return employed;
	}

	public void setEmployed(boolean employed) {
		this.employed = employed;
	}

	public float getGwa() {
		return gwa;
	}

	public void setGwa(float gwa) {
		this.gwa = gwa;
	}

	public Date getDateHired() {
		return dateHired;
	}

	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Contacts> getContacts(){
		return contacts;
	}

	public void setContacts(List<Contacts> contacts){
		this.contacts = contacts;
	}


}
