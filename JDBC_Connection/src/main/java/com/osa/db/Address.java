package com.osa.db;

public class Address {
	private String id;
	private String street;
	private String city;
	private String zip;

	public Address(String id, String street, String city, String zip) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.zip = zip;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
}
