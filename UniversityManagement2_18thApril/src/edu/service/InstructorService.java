package edu.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;
import javax.jws.WebService;

import edu.dao.IDao;
import edu.dao.impl.InstructorDaoImpl;
import edu.dao.impl.PersonDaoImpl;
import edu.dao.impl.StudentDaoImpl;
import edu.db.entity.*;
import edu.service.PersonService;

@WebService
public class InstructorService {

	Validations validations = new Validations();

	static Map<String, String> attrToColumn = new HashMap<String, String>() {
		{
			put("First Name", "p.firstName");
			put("Last Name", "p.lastName");
			put("Address", "p.address");
			put("City", "p.city");
			put("State", "p.state");
			put("Zip Code", "p.zipCode");
			put("Instructor Id", "i.instructorId");
			put("Department", "i.department");
			put("Office Hours(Day)", "it.day");
			put("Office Hours(Timing)", "it.time");
			put("Password", "p.password");
		}
	};
	
	public String addInstructor(String instructorId,String firstname, String lastname, String address,
			String city, String state, String zipCode, 
			String department, String days, String timings,String password )
			
	{
		System.out.println("In Instructor service");
		if (!validations.isAllFieldsFilled(instructorId, firstname, lastname,
				address, city, state, zipCode, department, days, timings)) {
			System.out.println("No field is filled");
			return "Please Enter All fields";
		}
		if(validations.hasSpecialCharacter(firstname)){
			return "No special characters allowed in First Name";
		}
		
		String validate = validations.isValidInstructorID(instructorId);
		if (!validate.equals("True")) {
			return validate;
		}
		if (!validations.isStateValid(state)) {
			System.out.println(state);
			System.out.println("validation" + validations.isStateValid(state));
			return "Please enter the valid State";
		}

		if (!validations.isValidZipCode(zipCode)) {
			return "Please Enter valid Zip Code";
		}
		String result = getInstructorById(instructorId);
		
		if ( result.equals("false:Not Found"))
		{
			PersonService ph = new PersonService();
			int personId = Integer.parseInt(ph.addPerson(firstname,lastname, address, city, state, zipCode, password)); 
			Instructor I = new Instructor();
			I.setInstructorEmpId(instructorId);
			I.setFirstName(firstname);
			I.setLastName(lastname);
			I.setAddress(address);
			I.setCity(city);
			I.setState(state);
			I.setZipCode(zipCode);
			I.setDepartment(department);
			I.setDays(days);
			I.setTiming(timings);
			//I.setOfficeHours(meetingTime);
			I.setPersonId(personId);
			IDao dao = new InstructorDaoImpl();
			return dao.add(I);
		}
		else
		{
			return "false:Duplicate Entry";
		}
	}

	public String deleteInstructor(String instructorId) {
		String validate = validations.isValidInstructorID(instructorId);
		if (!validate.equals("True")) {
			return validate;
		}
		Instructor I = new Instructor();
		I.setInstructorEmpId(instructorId);
		IDao dao = new InstructorDaoImpl();
		return dao.delete(I);
	}

	public String getInstructorById(String instructorId) {
		String validate = validations.isValidInstructorID(instructorId);
		if (!validate.equals("True")) {
			return validate;
		}
		Instructor I = new Instructor();
		I.setInstructorEmpId(instructorId);
		IDao dao = new InstructorDaoImpl();
		return dao.findById(I );
	}
	
	public String getAllInstructor( )
		{
		
		IDao dao = new InstructorDaoImpl();
		return dao.findAll();
	}

	public String assignInstructor(String courseId, String section,
			String instructorId) {

		InstructorDaoImpl Idao = new InstructorDaoImpl();
		return Idao.assignInstructor(courseId, section, instructorId);
	}

	public String unAssignInstructor(String instructorId, String courseId,
			String section) {
		InstructorDaoImpl Idao = new InstructorDaoImpl();
		return Idao.unAssignInstructor(instructorId, courseId, section);
	}

	public String getAssignedCoursesForInstructor(String instructorId) {
		String validate = validations.isValidInstructorID(instructorId);
		if (!validate.equals("True")) {
			return validate;
		}
		InstructorDaoImpl Idao = new InstructorDaoImpl();
		return Idao.getAssignedCoursesForInstructor(instructorId);
	}

	public String updateInstructor(String instructorEmpId, String firstname,
			String lastname, String address, String city, String state,
			String zip, String department, String days, String timings) {
		if (!validations.isAllFieldsFilled(instructorEmpId, firstname, lastname,
				address, city, state, zip, department, days, timings)) {
			System.out.println("No field is filled");
			return "Please Enter All fields";
		}
		String validate = validations.isValidInstructorID(instructorEmpId);
		if (!validate.equals("True")) {
			return validate;
		}

		if(validations.hasSpecialCharacter(firstname)){
			return "No special characters allowed in First Name";
		}

		if (!validations.isStateValid(state)) {
			System.out.println(state);
			System.out.println("validation" + validations.isStateValid(state));
			return "Please enter the valid State";
		}

		if (!validations.isValidZipCode(zip)) {
			return "Please Enter valid Zip Code";
		}

		String result = null;
		Instructor i = new Instructor();
		i.setInstructorEmpId(instructorEmpId);
		i.setFirstName(firstname);
		i.setLastName(lastname);
		i.setAddress(address);
		i.setCity(city);
		i.setState(state);
		i.setZipCode(zip);
		i.setDays(days);
		i.setTiming(timings);
		i.setDepartment(department);
		InstructorDaoImpl Idao = new InstructorDaoImpl();
		int personId = Idao.getPersonIdForInstructor(instructorEmpId);
		i.setPersonId(personId);
		result = Idao.update(i);
		return result;
	}
	
	public String searchInstructor(String attribute, String keyword) {
		// String result = null;
		if (attribute == null || keyword == null) {
			return "Please Entre valid value";
		}
		IDao dao = new InstructorDaoImpl();
		String columnName = attrToColumn.get(attribute);
		
		if (columnName == null || columnName == "") {
			return "False:attribute name " + attribute + " is invalid.";
		}
		
		return dao.search(columnName, keyword);
	}

}
