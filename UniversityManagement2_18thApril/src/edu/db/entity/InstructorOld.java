package edu.db.entity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class InstructorOld extends Person {

	private String department;
	private long instructorEmpId;
	private DateFormat officeHours = new SimpleDateFormat("HH:mm");
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public long getInstructorEmpId() {
		return instructorEmpId;
	}
	public void setInstructorEmpId(long instructorEmpId) {
		this.instructorEmpId = instructorEmpId;
	}
	public DateFormat getOfficeHours() {
		return officeHours;
	}
	public void setOfficeHours(DateFormat officeHours) {
		this.officeHours = officeHours;
	}
	
	
}
