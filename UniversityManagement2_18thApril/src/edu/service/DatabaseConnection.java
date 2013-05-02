/*
package Connections;

import java.sql.*;
import java.text.DateFormat;

public class DatabaseConnection {

	Connection conn = null;
	static ResultSet rs;
	Statement stmt = null;
	
	DatabaseConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/univesitydb","root","root");
			stmt = conn.createStatement();
			
			if(!conn.isClosed())
				System.out.println("Successfully connectiod");
		}catch(SQLException e)
		{
				e.printStackTrace();
		}
		catch(InstantiationException e)
		{
				e.printStackTrace();
		}
		catch(IllegalAccessException e)
		{
				e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
				e.printStackTrace();
		}
		
	}
	
	// Insert Student
	public String addStudent(String studentId, String firstname, String lastname, String address, String city, String state, int zipCode, String courseList)
	{
		String result = "";
		int rowcount;
		
		try
		{
			String query =  "Insert into student (studentId,firstName,lastName,address,city,state,zipCode,associatedCourses) values" +
					" ('"+ studentId+ "', '"+ firstname+ "', '"+lastname+ "', '"+address+ "', '"+city+ "', '"+state+ "', '"+zipCode+ "', '"+courseList+"')" ;
			rowcount = stmt.executeUpdate(query);
			if(rowcount > 0)
			{
				result = "true";
				System.out.println("Student inserted successful");
			}
			else
			{
				result = "false:The data could not be inserted in the databse";
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	//Delete selected student
	
	public String deleteStudent(String studentId)
	{
		String result = "";
		int rowcount;
		
		try
		{
			String query =  "Delete from student where studentId =" +
					"'"+ studentId+ "'" ;
			rowcount = stmt.executeUpdate(query);
			if(rowcount > 0)
			{
				result = "true";
				System.out.println("Student Deleted successful");
			}
			else
			{
				result = "false:The data could not be deleted in the databse";
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	// Insert Instructor
	public String addInstructor(String instructorId, String firstname, String lastname, String address, String city, String state, int zipCode, String courseList
			,String department)
	{
		String result = "";
		int rowcount;
		
		try
		{
			String query =  "Insert into instructor (instructorId,firstName,lastName,address,city,state,zipCode,associatedCourses,department) values" +
					" ('"+ instructorId+ "', '"+ firstname+ "', '"+lastname+ "', '"+address+ "', '"+city+ "', '"+state+ "', '"+zipCode+ "', '"+courseList+ "', '"+
					department+"')" ;
			rowcount = stmt.executeUpdate(query);
			if(rowcount > 0)
			{
				result = "true";
				System.out.println("Instructor added successful");
			}
			else
			{
				result = "false:The data could not be inserted in the databse";
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	//Delete selected instructor
	
		public String deleteInstructor(String instructorId)
		{
			String result = "";
			int rowcount;
			
			try
			{
				String query =  "Delete from instructor where instructorId =" +
						"'"+ instructorId+ "'" ;
				rowcount = stmt.executeUpdate(query);
				if(rowcount > 0)
				{
					result = "true";
					System.out.println("instructor Deleted successful");
				}
				else
				{
					result = "false:The data could not be deleted in the databse";
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			return result;
		}
		
	
	// Insert Course
	public String addCourse(String courseName, String courseSection, String location)
	{
		String result = "";
		int rowcount;
		
		try
		{
			String query =  "Insert into course (courseName,courseSection,location) values" +
					" ('"+ courseName+ "', '"+ courseSection+ "', '"+location+"')" ;
			rowcount = stmt.executeUpdate(query);
			if(rowcount > 0)
			{
				result = "true";
				System.out.println("Course inserted successful");
			}
			else
			{
				result = "false:The data could not be inserted in the databse";
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return result;
	}
	
	//Delete selected course
	
			public String deleteCourse(String courseName)
			{
				String result = "";
				int rowcount;
				
				try
				{
					String query =  "Delete from course where courseName =" +
							"'"+ courseName+ "'" ;
					rowcount = stmt.executeUpdate(query);
					if(rowcount > 0)
					{
						result = "true";
						System.out.println("course Deleted successful");
					}
					else
					{
						result = "false:The data could not be deleted in the databse";
					}
				}catch(SQLException e)
				{
					e.printStackTrace();
				}
				
				return result;
			}
			
}
*/

package edu.service;

//package Connections;

import java.sql.*;
import java.text.DateFormat;

public class DatabaseConnection {

	Connection conn = null;
	static ResultSet rs;
	Statement stmt = null;

	public DatabaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/univesitydb", "root", "root");
			stmt = conn.createStatement();

			if (!conn.isClosed())
				System.out.println("Successfully connectiod");
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

	// Insert Student
	public String addStudent(String studentId, int personId) {
		String result = "";
		int rowcount;

		try {
			String query = "Insert into student (studentId,personId) values"
					+ " ('" + studentId + "', '" + personId + "')";
			rowcount = stmt.executeUpdate(query);
			if (rowcount > 0) {
				result = "true";
				System.out.println("Student inserted successful");
			} else {
				result = "false:The data could not be inserted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// Delete selected student

	public String deleteStudent(String studentId) {
		
		return deletePerson(getPersonIdForStudent(studentId));
		
		/*
		String result = "";
		int rowcount;

		try {
			String query = "Delete from student where studentId =" + "'"
					+ studentId + "'";
			rowcount = stmt.executeUpdate(query);
			if (rowcount > 0) {
				result = "true";
				System.out.println("Student Deleted successful");
			} else {
				result = "false:The data could not be deleted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
		*/
		
	}

	// Insert Person
	public String addPerson(String firstName, String lastName, String address,
			String city, String state, int zipCode) {
		String result = "";
		int rowcount=0;

		try {
			String query = "Insert into person (firstName,lastName,address,city,state,zipCode) values"
					+ " ('"
					+ firstName
					+ "', '"
					+ lastName
					+ "', '"
					+ address
					+ "', '"
					+ city
					+ "', '"
					+ state
					+ "', '"
					+ zipCode
					 + "')";
			rowcount = stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
			System.out.println(rowcount);
			if (rowcount > 0) {
				result = "true";
				System.out.println("Student inserted successful");
				System.out.println("row Count"+rowcount);
			} else {
				result = "false:The data could not be inserted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ""+rowcount;
	}

	// Delete selected student

	public String deletePerson(int personId) {
		String result = "";
		int rowcount;

		try {
			String query = "Delete from person where personId =" + "'"
					+ personId + "'";
			rowcount = stmt.executeUpdate(query);
			if (rowcount > 0) {
				result = "true";
				System.out.println("Person Deleted successful");
			} else {
				result = "false:The data could not be deleted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int getPersonIdForStudent(String studentId)
	{
		
		int personId = 0;
		ResultSet rs;

		try {
			String query = "Select personId from Student where studentID =" + "'"
					+ studentId + "'";
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
	// Insert Instructor
	public String addInstructor(String instructorId, String department, int personId) 
	{
		String result = "";
		int rowcount;

		try {
			String query = "Insert into instructor (instructorId,department,personId) values"
					+ " ('"
					+ instructorId
					+ "', '"
					+ department
					+ "', '"
				    + personId + "')";
			rowcount = stmt.executeUpdate(query);
			if (rowcount > 0) {
				result = "true";
				System.out.println("Instructor added successful");
			} else {
				result = "false:The data could not be inserted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// Delete selected instructor

	public String deleteInstructor(String instructorId) {
		String result = "";
		int rowcount;

		try {
			String query = "Delete from instructor where instructorId =" + "'"
					+ instructorId + "'";
			rowcount = stmt.executeUpdate(query);
			if (rowcount > 0) {
				result = "true";
				System.out.println("instructor Deleted successful");
			} else {
				result = "false:The data could not be deleted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// Insert Course
	public String addCourse(String courseId, String courseName, String courseSection,
			 String location) {
		String result = "";
		int rowcount;

		try {
			String query = "Insert into course (courseId,courseName,courseSection,location) values"
					+ " ('"
					+ courseId
					+ "', '"
					+ courseName
					+ "', '"
					+ courseSection
					+ "', '"
					+ location
					+ "')";
			rowcount = stmt.executeUpdate(query);
			if (rowcount > 0) {
				result = "true";
				System.out.println("Course inserted successful");
			} else {
				result = "false:The data could not be inserted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// Delete selected course

	public String deleteCourse(String courseId) {
		String result = "";
		int rowcount;

		try {
			String query = "Delete from course where courseId =" + "'"
					+ courseId + "'";
			rowcount = stmt.executeUpdate(query);
			if (rowcount > 0) {
				result = "true";
				System.out.println("course Deleted successful");
			} else {
				result = "false:The data could not be deleted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// Enroll Student
	public String enrollStudent(String courseId, String studentId)
	{
		String result = "";
		int rowcount;

		try {
			String query = "Insert into courseStudentMap values"
					+ " ("
					+ "(select courseId from course where courseId ='" +courseId+"')"
					+ ","
					+ "(select studentId from student where studentId ='" +studentId+"')"
					+ ",DEFAULT"
					+ ")";
			rowcount = stmt.executeUpdate(query);
			if (rowcount > 0) {
				result = "true";
				System.out.println("Student enrolled successful");
			} else {
				result = "false:The data could not be inserted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// Unenroll Student

	public String unEnrollStudent(String studentId) {
		String result = "";
		int rowcount;

		try {
			String query = "Delete from courseStudentMap where studentId =" + "'"
					+ studentId + "'";
			rowcount = stmt.executeUpdate(query);
			if (rowcount > 0) {
				result = "true";
				System.out.println("student unrolled successful");
			} else {
				result = "false:The data could not be deleted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// Assign Instructor
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

	// UnAssign Instructor

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

}