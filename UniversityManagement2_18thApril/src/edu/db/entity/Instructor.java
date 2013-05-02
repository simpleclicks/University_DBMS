package edu.db.entity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Instructor extends Person {

	private String department;
	private String  instructorEmpId;
	private String days;
	private String timing;
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
