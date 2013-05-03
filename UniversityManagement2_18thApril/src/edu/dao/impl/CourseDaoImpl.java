package edu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.dao.ConnectionPool;
import edu.dao.IDao;
import edu.db.entity.Course;


public class CourseDaoImpl implements IDao {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	boolean isPoolingUsed = false;
	public CourseDaoImpl(){
		getConnectionFromPool();
	}

	private void getSingleConnection()
	{
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
	
	private void getConnectionFromPool()
	{
			
		try {
			
				conn = ConnectionPool.getConnectionInstanceFromPool();
				System.out.println(conn);
				if(conn != null)
				{
					stmt = conn.createStatement();
					isPoolingUsed = true;
					if (!conn.isClosed())
						System.out.println("Successfully connectiod");
				}
				else
				{
					System.out.println("Connection Pool Threshold");
				}
			} catch (SQLException e) 
			{
			e.printStackTrace();
			}
	}
	
	@Override
	public String add(Object object) {

		Course c = (Course) object ;
		
		String courseId = c.getCourseId();
		String courseName = c.getCourseName();
		String courseSection = c.getCourseSection();
		String location = c.getLocation();
		
		String result = "";
		int rowcount;

		try {
			String query = "Insert into course (courseId,courseName,location) values"
					+ " ('"
					+ courseId+"-"+courseSection
					+ "', '"
					+ courseName
					+ "', '"
					+ location
					+ "')";
			rowcount = stmt.executeUpdate(query);
			query = "Insert into coursetiming (courseId,day,time) values"
					+ " ('"
					+ c.getCourseId()
					+ "', '"
					+ c.getDays()
					+ "', '"
					+ c.getTimings()
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
		
		// return connection instance to the pool
		if(isPoolingUsed)	
			ConnectionPool.returnConnectionInstanceToPool();
		return result;
	}

	@Override
	public String delete(Object object) {
		
		Course c = (Course) object ;
		
		String courseId = c.getCourseId();
		
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
				result = "false:Record not found";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// return connection instance to the pool
		if(isPoolingUsed)	
			ConnectionPool.returnConnectionInstanceToPool();
		return result;
	}
	


	@Override
	public String find(Object object) {
		
		Course c = (Course) object ;
		
		String search = c.getSearch();
		
		String result = "";
		ResultSet rs = null;
		Boolean option = true;
		System.out.println("1");

if (option==true) //this one if we search by ID
		
		{
			try {
				
				System.out.println("2");
			
				String query1 = "Select * from course where courseId =" + "'"
					+ search + "'";
				System.out.println("3");
			rs = stmt.executeQuery(query1);
			System.out.println("4");
			while (rs.next()) {
				System.out.println("5");
                System.out.println("Course Id" + rs.getString("courseId") + "Course Name" + rs.getString("courseName"));
                result = rs.getString("courseId")+ "/"+rs.getString("courseName")+ "/"+ rs.getString("location");
			}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			}
			
			


else if (option==false) //this one is if we search by name 
		
		{
				
			try {
				String query2 = "Select * from course where courseName =" + "'"
						+ search + "'";
				
				rs = stmt.executeQuery(query2);
		
				while (rs.next()) {
	                 
	                System.out.println("Course Id" + rs.getString("courseId") + "Course Name" + rs.getString("courseName"));
	                result = rs.getString("courseId")+ "/"+rs.getString("courseName")+ "/"+ rs.getString("location");

				}
			
		}
			//Add some code if the results do not come up in any one of the above searches.
			
			catch (SQLException e) {
			//e.printStackTrace();
			  System.out.println(e);

		}
		
	}
	// return connection instance to the pool
	if(isPoolingUsed)	
	ConnectionPool.returnConnectionInstanceToPool();
		
	return result;

}

	@Override
	public String findById(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findAll() {
		// TODO Auto-generated method stub
	
		String result="";
		try {
			String query = "Select * from 	course";
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println(rs.getString("courseId")+ " "+rs.getString("courseName")+ " "+ rs.getString("location"));
				result += rs.getString("courseId")+ "/"+rs.getString("courseName")+ "/"+ rs.getString("location");
				result += "!";

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		// return connection instance to the pool
		if(isPoolingUsed)	
			ConnectionPool.returnConnectionInstanceToPool();
		//return rs.toString();
		return result;
	}

	public String getEnrolledStudentForCourse(String courseId)
	{

		try {
				String query = "Select * from 	person INNER JOIN  student ON person.personId = student.personId  INNER JOIN courseStudentMap  ON  student.studentId = courseStudentMap.studentId" +
						" AND courseStudentMap.courseId= '"+courseId+"'";
				rs = stmt.executeQuery(query);
			
				while(rs.next())
				{
					System.out.println(rs.getString("studentId")+ " "+ rs.getString("firstName")+rs.getString("lastname")+rs.getString("address")+ " "+ rs.getString("city")+ " "+ rs.getString("state")
							+rs.getString("zipCode")+rs.getString("courseId"));
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// return connection instance to the pool
		if(isPoolingUsed)	
			ConnectionPool.returnConnectionInstanceToPool();
		return rs.toString();
	}
	
	public String getAssignedInstructorForCourse(String courseId)
	{

		try {
				String query = "Select * from 	person INNER JOIN  instructor ON person.personId = instructor.personId  INNER JOIN courseInstructorMap  ON  instructor.instructorId = courseInstructorMap.instructorId" +
						" AND courseInstructorMap.courseId= '"+courseId+"'";
				rs = stmt.executeQuery(query);
			
				while(rs.next())
				{
					System.out.println(rs.getString("instructorId")+ " "+ rs.getString("firstName")+rs.getString("lastname")+rs.getString("address")+ " "+ rs.getString("city")+ " "+ rs.getString("state")
							+rs.getString("zipCode")+" "+ rs.getString("department")+ rs.getString("courseId"));
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// return connection instance to the pool
		if(isPoolingUsed)	
			ConnectionPool.returnConnectionInstanceToPool();
		
		return rs.toString();
	}

	/*
	@Override
	public String findById(String id) {
String result = null;
		
		try {
			System.out.println("Inside findById func"); 
			String query = "Select * from 	course  where courseId = "+ id + ")";
			rs = stmt.executeQuery(query);
			System.out.println("Result set" + rs);
			while(rs.next())
			{
			//	System.out.println("name:"+ rs.getString("firstName")+ " "+ rs.getString("lastName") );
				rs.toString();
				result =(rs.getString("courseName")+ "/"+ rs.getString("location")+ "/"+rs.getString("courseId") + "/");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Printing result set " + rs.toString()); 
		return result;
	}
	*/

	@Override
	public String update(Object object) {
		int res = 0;
		Course c = (Course)object;
		try {
			String query = "Update course set courseName = '"+c.getCourseName()+"', location = '"+c.getLocation()+"' where courseId='" + c.getCourseId()+"'";
			res = stmt.executeUpdate(query);
			query = "Update coursetiming set day = '"+c.getDays()+"', time = '"+c.getTimings()+"' where courseId='" + c.getCourseId()+"'";
			res = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return String.valueOf(res);
	}
	
}
