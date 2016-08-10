package com.exercise.hibernate1.core;

public class Contacts{

	private long contactId;
	private String contactType;
	private String contactValue;
	
	public Contacts(){}
	
	public Contacts(String contactType, String contactValue){
		this.contactType = contactType;
		this.contactValue = contactValue;
	}
	
	public long getContactId(){
		return contactId;
	}
	
	public void setContactId(long contactId){
		this.contactId = contactId;
	}
	
	public String getContactType(){
		return contactType;
	}
	
	public void setContactType(String contactType){
		this.contactType = contactType;
	}
	
	public String getContactValue(){
		return contactValue;
	}
	
	public void setContactValue(String contactValue){
		this.contactValue = contactValue;
	}
}