package edu.service;

import javax.jws.WebService;


import edu.dao.IDao;
import edu.dao.impl.PersonDaoImpl;
import edu.db.entity.Person;

@WebService
public class Service {

	DatabaseConnection db = new DatabaseConnection();

	public Service() {

	}

	public String addStudent(String studentId, String firstname,
			String lastname, String address, String city, String state,
			int zipCode, String courseList) {
		int personId = Integer.parseInt(addPerson(firstname, lastname, address,
				city, state, zipCode, courseList));
		return db.addStudent(studentId, personId);
	}

	public String deleteStudent(String studentId) {
		return db.deleteStudent(studentId);
	}

	public String addInstructor(String instructorId, String firstname,
			String lastname, String address, String city, String state,
			int zipCode, String courseList, String department,
			String meetingTime) {
		/*
		 * SimpleDateFormat parse = new
		 * SimpleDateFormat("dd. MMM yyyy hh:mm:ss"); SimpleDateFormat formatter
		 * = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); java.util.Date
		 * parsedMeetingTime = parse.parse(meetingTime);
		 */
		int personId = Integer.parseInt(addPerson(firstname, lastname, address,
				city, state, zipCode, courseList));
		return db.addInstructor(instructorId, department, personId);
	}

	public String deleteInstructor(String instructorId) {
		return db.deleteInstructor(instructorId);
	}

	public String addCourse(String courseId, String courseName,
			String courseSection, String location) {
		return db.addCourse(courseId, courseName, courseSection, location);
	}

	public String deleteCourse(String courseId) {
		return db.deleteCourse(courseId);
	}

	public String addPerson(String firstname, String lastname, String address,
			String city, String state, int zipCode, String courseList) {
		Person p = new Person();
		p.setFirstName(firstname);
		p.setLastName(lastname);
		p.setAddress(address);
		p.setCity(city);
		p.setState(state);
		p.setZipCode(zipCode);

		IDao dao = new PersonDaoImpl();
		return dao.add(p);

		// return db.addPerson(firstname, lastname, address, city,state,zipCode,
		// courseList);
	}

	private String deletePerson(int personId) {
		return db.deletePerson(personId);
	}

	public String assignInstructor(String courseId, String instructorId) {
		return db.assignInstructor(courseId, instructorId);
	}

	public String unAssignInstructor(String instructorId) {
		return db.unAssignInstructor(instructorId);
	}

	public String enrollStudent(String studentId, String courseId) {
		return db.enrollStudent(courseId, studentId);
	}

	public String unEnrollStudent(String studentId) {
		return db.unEnrollStudent(studentId);
	}

	public String listStudents() {
		return "";
	}

	public String listInstructors() {
		return "";
	}

	public String listCourse() {
		return "";
	}

	public String findPreson() {
		return "";
	}

	public String findCourse() {
		return "";
	}

	public String displayPersonInfo() {
		return "";
	}

	public String displayCourseInfo() {
		return "";
	}
}
