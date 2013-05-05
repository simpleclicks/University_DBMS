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
		
		String result = getStudentById(studentId);
		if ( result.equals("false:Not Found"))
		{ 
			PersonService ph = new PersonService();
			int personId = Integer.parseInt(ph.addPerson(firstname, lastname, address,
					city, state, zipCode));
			System.out.println("Person inserted");
			Student student=new Student();
			student.setStudentId(studentId);
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
		Student student=new Student();
		student.setStudentId(studentId);
		IDao dao = new StudentDaoImpl();
		return dao.delete(student);
		
	}
	
	public String getStudentById(String studentId )
	{
		Student student=new Student();
		student.setStudentId(studentId);
		IDao dao = new StudentDaoImpl();
		return dao.findById(student);
	}
	
	public String getAllStudent( )
	{
		
		IDao dao = new StudentDaoImpl();
		return dao.findAll();
	}
	
	public String enrollStudent(String courseId, String section, String studentId )
	{
		StudentDaoImpl sdao = new StudentDaoImpl();
		return sdao.enrollStudent(courseId, section, studentId);
	}
	
	public String unEnrollStudent(String studentId, String courseId, String section )
	{
		StudentDaoImpl sdao = new StudentDaoImpl();
		return sdao.unEnrollStudent( studentId,  courseId,  section);
	}
	
	public String getEnrolledCoursesForStudent(String studentId)
	{
		StudentDaoImpl sdao = new StudentDaoImpl();
		return sdao.getEnrolledCoursesForStudent( studentId);
	}
	
	public String updateStudent(String studentId, String firstname, String lastname, String address, String city, String state, String zip,String password){
		String result = null;
		Person s = new Person();
		s.setFirstName(firstname);
		s.setLastName(lastname);
		s.setAddress(address);
		s.setCity(city);
		s.setState(state);
		s.setZipCode(zip);
		s.setPassword(password);
		PersonDaoImpl pDao = new PersonDaoImpl();
		StudentDaoImpl sDao = new StudentDaoImpl();
		int personId = sDao.getPersonIdForStudent(studentId);
		s.setPersonId(personId);
		System.out.println("pers:" + personId);
		result = pDao.update(s);
		return result;
	}
	
	public String searchStudent(String attribute, String keyword) {
		//String result = null;
		IDao dao = new StudentDaoImpl();
		String columnName = attrToColumn.get(attribute);
		
		if (columnName == null || columnName == "") {
			return "False:attribute name " + attribute + " is invalid.";
		}
		
		return dao.search(columnName, keyword);
	}
}
