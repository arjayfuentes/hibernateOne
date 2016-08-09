package com.exercise.hibernate1.core;

public class Address{

	private int id;
	private int houseNo;
	private String street;
	private String barangay;
	private String city;
	private int zipCode;

	public Address(){}

	public Address(int houseNo, String street, String barangay, String city, int zipCode) {
		this.houseNo = houseNo;
		this.street = street;
		this.barangay = barangay;
		this.city = city;
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHouseNo(){
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBarangay() {
		return barangay;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}
