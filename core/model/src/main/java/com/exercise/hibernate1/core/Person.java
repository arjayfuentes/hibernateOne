package com.exercise.hibernate1.core;

import java.util.Date;

public class Person {

	private int id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public Date getbirthDate() {
		return birthDate;
	}

	public void setbirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isEmployed() {
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

	
}
