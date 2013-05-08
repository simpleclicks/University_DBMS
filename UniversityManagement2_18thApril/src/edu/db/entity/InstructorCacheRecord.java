package edu.db.entity;

public class InstructorCacheRecord {

	private String department;
	private String  instructorEmpId;
	private String days;
	private String timing;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	private int personId;
	public String getDepartment() {
		return department;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getInstructorEmpId() {
		return instructorEmpId;
	}
	public void setInstructorEmpId(String instructorEmpId) {
		this.instructorEmpId = instructorEmpId;
	}
}
