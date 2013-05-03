package edu.service;

import javax.jws.WebService;

import edu.dao.IDao;
import edu.dao.impl.PersonDaoImpl;
import edu.dao.impl.StudentDaoImpl;
import edu.db.entity.Person;
import edu.db.entity.Student;
import edu.service.PersonService;

@WebService
public class StudentService {
	
	
	public String addStudent(String studentId, String firstname,
			String lastname, String address, String city, String state,
			int zipCode) {
		
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
	
	public String enrollStudent(String courseId, String studentId )
	{
		StudentDaoImpl sdao = new StudentDaoImpl();
		return sdao.enrollStudent(courseId, studentId);
	}
	
	public String unEnrollStudent(String studentId )
	{
		StudentDaoImpl sdao = new StudentDaoImpl();
		return sdao.unEnrollStudent( studentId);
	}
	
	public String getEnrolledCoursesForStudent(String studentId)
	{
		StudentDaoImpl sdao = new StudentDaoImpl();
		return sdao.getEnrolledCoursesForStudent( studentId);
	}
	
	public String updateStudent(String studentId, String firstname, String lastname, String address, String city, String state, int zip){
		String result = null;
		Person s = new Person();
		s.setFirstName(firstname);
		s.setLastName(lastname);
		s.setAddress(address);
		s.setCity(city);
		s.setState(state);
		s.setZipCode(zip);
		PersonDaoImpl pDao = new PersonDaoImpl();
		StudentDaoImpl sDao = new StudentDaoImpl();
		int personId = sDao.getPersonIdForStudent(studentId);
		s.setPersonId(personId);
		result = pDao.update(s);
		return result;
	}
}
