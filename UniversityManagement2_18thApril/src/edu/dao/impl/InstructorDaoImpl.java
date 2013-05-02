package edu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import edu.dao.IDao;
import edu.db.entity.Instructor;
import edu.db.entity.Person;
import edu.db.entity.Student;

public class InstructorDaoImpl implements IDao {
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public InstructorDaoImpl(){
			
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/univesitydb", "root", "root");
			stmt = conn.createStatement();

			if (!conn.isClosed())
				System.out.println("Successfully connected");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String add(Object object) {
		
		Instructor I = (Instructor) object;
		String instructorId = I.getInstructorEmpId();
		String department = I.getDepartment();
	//	DateFormat officeHrs = I.getOfficeHours();
		int personId = I.getPersonId();
		
		String result = "";
		int rowcount = 0;
		int second = 0;

		try {
			String query = "Insert into instructor (instructorId,department,personId) values"
					+ " ('"
					+ instructorId
					+ "', '"
					+ department
					+ "', '"
				    + personId + "')";
			rowcount = stmt.executeUpdate(query);
			query = "Insert into instructortiming (instructorId, day, time) values ('"+instructorId+"','"+I.getDays()+"','"+I.getTiming()+"')";
			second = stmt.executeUpdate(query);
			if (rowcount > 0) {
				result = "true";
				System.out.println("Instructor added successful");
			} else {
				result = "false:The data could not be inserted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("exception");
			e.printStackTrace();
		}

		return result;
		
		// TODO Auto-generated method stub
	}

	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		
		Instructor I = (Instructor) object;
		String  instructorId = I.getInstructorEmpId();
		
		PersonDaoImpl pdao = new PersonDaoImpl();
		Person p = new Person();
		
		p.setPersonId(getPersonIdForInstructor(instructorId));
		System.out.println("Instructor Deleted Successfully");
		return pdao.delete(p);		
		
	}

	
	public int getPersonIdForInstructor(String instructorId)
	{
		
		int personId = 0;
		ResultSet rs;

		try {
			String query = "Select personId from instructor where instructorId =" + "'"
					+ instructorId + "'";
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				personId =	rs.getInt(1);
				System.out.println(personId);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personId;
	}

	@Override
	public String findById(String instructorId) {
		// TODO Auto-generated method stub
		
		String result = null;
		
		try {
			System.out.println("Inside findById func"); 
			String query = "Select * from 	person  where personId = (Select personId from instructor where instructorId =" + "'"
					+ instructorId + "')";
			rs = stmt.executeQuery(query);
			System.out.println("Result set" + rs);
			while(rs.next())
			{
			//	System.out.println("name:"+ rs.getString("firstName")+ " "+ rs.getString("lastName") );
				System.out.println(rs.getString("firstName")+ " "+ rs.getString("lastName")+ " "+ rs.getString("address")+ " "+ rs.getString("city") + " "+ rs.getString("state") + 
						" "+ rs.getString("zipCode")+" ");
				result =(rs.getString("firstName")+ "/"+ rs.getString("lastName")+ "/"+ rs.getString("address")+ "/"+ rs.getString("city") + "/"+ rs.getString("state") + 
						"/"+ rs.getString("zipCode")+"/");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Printing result set " + rs.toString()); 
		return result;
	}

	@Override
	public String find(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findAll() {
		// TODO Auto-generated method stub
		
		try {
			String query = "Select * from 	person INNER JOIN instructor  ON  person.personId = instructor.personId";
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println(rs.getString("instructorId")+ " "+rs.getString("firstName")+ " "+ rs.getString("lastName")+ " "+ rs.getString("address")+ " "+ rs.getString("city") + " "+ rs.getString("state") + 
						" "+ rs.getString("zipCode")+" "+ rs.getString("department"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return rs.toString();
		
	}

	public String getEnrolledCoursesForInstructor(String instructorId)
	{

		try {
				String query = "Select * from 	course INNER JOIN courseInstructorMap  ON  course.courseId = courseInstructorMap.courseId" +
						" AND courseInstructorMap.instructorId= '"+instructorId+"'";
				rs = stmt.executeQuery(query);
			
				while(rs.next())
				{
					System.out.println(rs.getString("instructorId")+ " "+rs.getString("courseId")+ " "+ rs.getString("courseName")+ " "+ rs.getString("location"));
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs.toString();
	}
	
	public String assignInstructor(String courseId,
			String instructorId) {
		String result = "";
		int rowcount;

		try {
			String query = "Insert into courseInstructorMap (courseId,instructorId) values"
					+ " ("
					+ "(select courseId from course where courseId ='" +courseId+"')"
					+ ", "
					+ "(select instructorId from instructor where instructorId ='" +instructorId+"')"
					+ ")";
			rowcount = stmt.executeUpdate(query);
			if (rowcount > 0) {
				result = "true";
				System.out.println("Instructor assigned successful");
			} else {
				result = "false:The data could not be inserted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public String unAssignInstructor(String instructorId) {
		String result = "";
		int rowcount;

		try {
			String query = "Delete from courseInstructorMap where instructorId =" + "'"
					+ instructorId + "'";
			rowcount = stmt.executeUpdate(query);
			if (rowcount > 0) {
				result = "true";
				System.out.println("Instructor unassigned successful");
			} else {
				result = "false:The data could not be deleted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String update(Object object) {
		Instructor i = (Instructor) object;
		int res = 0;
		PersonDaoImpl pimpl = new PersonDaoImpl();
		Person p = new Person();
		p.setAddress(i.getAddress());
		p.setCity(i.getCity());
		p.setFirstName(i.getFirstName());
		p.setLastName(i.getLastName());
		p.setState(i.getState());
		p.setZipCode(i.getZipCode());
		p.setPersonId(i.getPersonId());
		pimpl.update(p);
		try {
			String query = "Update instructor set department = '"+i.getDepartment()+"' where instructorId=" + i.getInstructorEmpId();
			res = stmt.executeUpdate(query);
			query = "Update instructortiming set day = '"+i.getDays()+"', time = '"+i.getTiming()+"' where instructorId=" + i.getInstructorEmpId();
			res = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return String.valueOf(res);
	}
	
	
}
