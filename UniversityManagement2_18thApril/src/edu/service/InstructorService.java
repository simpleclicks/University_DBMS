package edu.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebService;

import edu.dao.IDao;
import edu.dao.impl.InstructorDaoImpl;
import edu.dao.impl.PersonDaoImpl;
import edu.dao.impl.StudentDaoImpl;
import edu.db.entity.*;
import edu.service.PersonService;

@WebService
public class InstructorService {
	public String addInstructor(String instructorId,String firstname, String lastname, String address,
			String city, String state, int zipCode, 
			String department, String days, String timings )
			
	{
		
		String result = getInstructorById(instructorId);
		
		if ( result.equals("false:Not Found"))
		{
			PersonService ph = new PersonService();
			int personId = Integer.parseInt(ph.addPerson(firstname,lastname, address, city, state, zipCode)); 
			Instructor I = new Instructor();
			I.setInstructorEmpId(instructorId);
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
	
	public String deleteInstructor(String instructorId)
	{
		Instructor I = new Instructor();
		I.setInstructorEmpId(instructorId);
		IDao dao = new InstructorDaoImpl();
		return dao.delete(I);
	}

	public String getInstructorById(String instructorId )
	{
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
	
	public String assignInstructor(String courseId, String instructorId) {
		InstructorDaoImpl Idao = new InstructorDaoImpl();
		return Idao.assignInstructor(courseId, instructorId);
	}

	public String unAssignInstructor(String instructorId) {
		InstructorDaoImpl Idao = new InstructorDaoImpl();
		return Idao.unAssignInstructor(instructorId);
	}
	
	public String getEnrolledCoursesForInstructor(String instructorId)
	{
		InstructorDaoImpl Idao = new InstructorDaoImpl();
		return Idao.getEnrolledCoursesForInstructor(instructorId);
	}

	public String updateInstructor(String instructorEmpId, String firstname,
			String lastname, String address, String city, String state,
			int zip, String department, String days, String timings) {
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
}
