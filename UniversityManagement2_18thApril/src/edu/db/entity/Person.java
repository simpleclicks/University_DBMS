package edu.db.entity;
import java.util.ArrayList;


public class Person {
	
	private int personId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private ArrayList<String> associatedCourses = new ArrayList<String>();
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String  zipCode) {
		this.zipCode = zipCode;
	}
	public ArrayList<String> getAssociatedCouStringses() {
		return associatedCourses;
	}
	public void setAssociatedCourses(ArrayList<String> associatedCourses) {
		this.associatedCourses = associatedCourses;
	}

	
}
