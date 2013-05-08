package edu.service;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import edu.dao.IDao;
import edu.dao.impl.PersonDaoImpl;
import edu.dao.impl.StudentDaoImpl;
import edu.db.entity.Person;
import edu.db.entity.Student;
import edu.service.PersonService;

@WebService
public class StudentService {

	Validations validations = new Validations();
	static Map<String, String> attrToColumn = new HashMap<String, String>() {
		{
			put("First Name", "firstName");
			put("Last Name", "lastName");
			put("Address", "address");
			put("City", "city");
			put("State", "state");
			put("Zip Code", "zipCode");
			put("Student Id", "studentId");
			put("Password", "password");
		}
	};
	
	public String addStudent(String studentId, String firstname,
			String lastname, String address, String city, String state,
			String zipCode, String password) {
if (!validations.isAllFields_filled_students(studentId, firstname,
				lastname, address, city, state, zipCode)) {
			return "Please add all fields";
		}
		if(validations.hasSpecialCharacter(firstname)){
			return "No special characters allowed in First Name";
		}
		
		if (!validations.isValidZipCode(zipCode)) {
			return "Please Enter valid Zip Code";
		}
		String validate = validations.isValidStudentID(studentId);
		if (!validate.equals("True")) {
			return validate;
		}

		String result = getStudentById(studentId);
		if ( result.equals("false:Not Found"))
		{ 
			PersonService ph = new PersonService();
			int personId = Integer.parseInt(ph.addPerson(firstname, lastname, address,
					city, state, zipCode, password));
			System.out.println("Person inserted");
			Student student=new Student();
			student.setStudentId(studentId);
			student.setFirstName(firstname);
			student.setLastName(lastname);
			student.setAddress(address);
			student.setCity(city);
			student.setState(state);
			student.setZipCode(zipCode);
			
			student.setPersonId(personId);
			
			IDao dao = new StudentDaoImpl();
			return dao.add(student);
		}
		else
		{
			 System.out.println("found");
			return "false:Duplicate Entry";
		}

	}

	
	public String deleteStudent(String studentId) {
		String validate = validations.isValidStudentID(studentId);
		if (!validate.equals("True")) {
			return validate;
		}

		Student student = new Student();
		student.setStudentId(studentId);
		IDao dao = new StudentDaoImpl();
		return dao.delete(student);
		
	}

	public String getStudentById(String studentId) {

		String validate = validations.isValidStudentID(studentId);
		if (!validate.equals("True")) {
			return validate;
		}

		Student student = new Student();
		student.setStudentId(studentId);
		IDao dao = new StudentDaoImpl();
		return dao.findById(student);
	}
	
	public String getAllStudent( )
	{
		
		IDao dao = new StudentDaoImpl();
		return dao.findAll();
	}
	
	public String enrollStudent(String courseId, String section, 
	String studentId ){
	
				StudentDaoImpl sdao = new StudentDaoImpl();
		return sdao.enrollStudent(courseId, section, studentId);
	}

	public String unEnrollStudent(String studentId, String courseId,
			String section) {
		StudentDaoImpl sdao = new StudentDaoImpl();
		return sdao.unEnrollStudent( studentId,  courseId,  section);
	}

	public String getEnrolledCoursesForStudent(String studentId) {
		String validate = validations.isValidStudentID(studentId);
		if (!validate.equals("True")) {
			return validate;
		}
		StudentDaoImpl sdao = new StudentDaoImpl();
		return sdao.getEnrolledCoursesForStudent( studentId);
	}
	
	public String updateStudent(String studentId, String firstname, String lastname, String address, String city, String state, String zip){
if (!validations.isAllFields_filled_students(studentId, firstname,
				lastname, address, city, state, zip)) {
			return "Please add all fields";
		}
		if(validations.hasSpecialCharacter(firstname)){
			return "No special characters allowed in First Name";
		}
		
		
		if (!validations.isValidZipCode(zip)) {
			return "Please Enter valid Zip Code";
		}
		String validate = validations.isValidStudentID(studentId);
		if (!validate.equals("True")) {
			return validate;
		}
        Student s = new Student();
        s.setStudentId(studentId);
		s.setFirstName(firstname);
		s.setLastName(lastname);
		s.setAddress(address);
		s.setCity(city);
		s.setState(state);
		s.setZipCode(zip);
		StudentDaoImpl sDao = new StudentDaoImpl();
		int personId = sDao.getPersonIdForStudent(studentId);
		s.setPersonId(personId);
		return sDao.update(s);
		
	}
	
	public String searchStudent(String attribute, String keyword) {
		// String result = null;
		if (attribute == null || keyword == null) {
			return "Please enter valid values";
		}
		IDao dao = new StudentDaoImpl();
		String columnName = attrToColumn.get(attribute);
		
		if (columnName == null || columnName == "") {
			return "False:attribute name " + attribute + " is invalid.";
		}
		
		return dao.search(columnName, keyword);
	}
}
