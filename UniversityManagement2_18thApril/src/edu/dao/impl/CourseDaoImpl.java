package edu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import edu.dao.ConnectionPool;
import edu.dao.IDao;
import edu.db.entity.Course;


public class CourseDaoImpl implements IDao {
	Connection conn = null;
	Statement stmt2 = null;
	java.sql.PreparedStatement stmt = null;
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
			//stmt = conn.createStatement();

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
					stmt2 = conn.createStatement();
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
			/*String query = "Insert into course (courseId,courseName,location,section) values"
					+ " ('"
					//+ courseId+"-"+courseSection
					+ courseId
					+ "', '"
					+ courseName
					+ "', '"
					+ location
					+ "', '"
					+courseSection
					+ "')";*/
			String query = "Insert into course (courseId,courseName,location,section) values (?, ?, ?, ?)";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, courseId);
			stmt.setString(2, courseName);
			stmt.setString(3, location);
			stmt.setString(4, courseSection);
			
			//rowcount = stmt.executeUpdate(query);
			rowcount = stmt.executeUpdate();
			/*query = "Insert into coursetiming (courseId,day,time,section) values"
					+ " ('"
					+ c.getCourseId()
					+ "', '"
					+ c.getDays()
					+ "', '"
					+ c.getTimings()
					+ "', '"
					+c.getCourseSection()	
					+ "')";*/
			query = "Insert into coursetiming (courseId,day,time,section) values (?,?,?,?)";
			stmt = conn.prepareStatement(query);
			stmt.setString(1,  c.getCourseId());
			stmt.setString(2,  c.getDays());
			stmt.setString(3, c.getTimings());
			stmt.setString(4, c.getCourseSection());
			
			//rowcount = stmt.executeUpdate(query);
			rowcount = stmt.executeUpdate();
			if (rowcount > 0) {
				result = "true";
				System.out.println("Course inserted successful");
			} else {
				result = "false:The data could not be inserted in the databse";
			}
		}catch(MySQLIntegrityConstraintViolationException e)
		{
			result = "false:Duplicate entries cannot be inserted";
		}
		catch (SQLException e) {
			e.printStackTrace();
			result = "false:The data could not be inserted in the databse";
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
			//String query = "Delete from course where courseId =" + "'"
			//		+ courseId + "'";
			String query = "Delete from course where courseId =?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, courseId);
			
			//rowcount = stmt.executeUpdate(query);
			rowcount = stmt.executeUpdate();
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
	public String findAll() {
		// TODO Auto-generated method stub
	
		String result="";
		boolean success = false;
		try {
			//String query = "Select * from 	course";
			String query= "Select * from 	course INNER JOIN coursetiming ON course.courseId = coursetiming.courseId AND course.section = coursetiming.section";
			stmt = conn.prepareStatement(query);
			//rs = stmt.executeQuery(query);
			rs = stmt.executeQuery();
			while(rs.next())
			{	success = true;
				System.out.println(rs.getString("courseId")+ " "+rs.getString("courseName")+ " "+ rs.getString("location")+ " "+ rs.getString("section")+" "+ rs.getString("day")+ " "+ rs.getString("time"));
				result += rs.getString("courseId")+ "/"+rs.getString("courseName")+ rs.getString("section")+ "/"+ rs.getString("location")+ rs.getString("day")+ rs.getString("time");
				result += "!";

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "false:SQL exception occurred";
		}	
		
		// return connection instance to the pool
		if(isPoolingUsed)	
			ConnectionPool.returnConnectionInstanceToPool();
		//return rs.toString();
		if(success)
			return result;
		else
			return "false:No Records found";
	}

	public String getEnrolledStudentForCourse(String courseId, String section)
	{
		boolean success = false;
		String result="";
		try {
				//String query = "Select * from 	person INNER JOIN  student ON person.personId = student.personId  INNER JOIN courseStudentMap  ON  student.studentId = courseStudentMap.studentId" +
				//		" AND (courseStudentMap.courseId= '"+courseId+"' and courseStudentMap.section = '"+section+"')";
				String query = "Select * from 	person INNER JOIN  student ON person.personId = student.personId  INNER JOIN courseStudentMap  ON  student.studentId = courseStudentMap.studentId" +
						" AND (courseStudentMap.courseId= ? and courseStudentMap.section = ?)";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, courseId);
				stmt.setString(2, section);
				
				//rs = stmt.executeQuery(query);
				rs = stmt.executeQuery();
				while(rs.next())
				{	success = true;
					System.out.println(rs.getString("studentId")+ " "+ rs.getString("firstName")+rs.getString("lastname")+rs.getString("address")+ " "+ rs.getString("city")+ " "+ rs.getString("state")
							+rs.getString("zipCode")+rs.getString("courseId"));
					result += rs.getString("studentId")+ "/"+rs.getString("firstName")+ "/"+ rs.getString("lastname")+ "/"+ rs.getString("address")+ "/"+ rs.getString("city")+ "/"+ rs.getString("state")+ "/"+ rs.getString("zipCode");
					result += "!";
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "false: SQL Exception occured";
		}
		
		// return connection instance to the pool
		if(isPoolingUsed)	
			ConnectionPool.returnConnectionInstanceToPool();
		
		if(success)
			return result;
		else
			return "false: No Records Found";
	}
	
	public String getAssignedInstructorForCourse(String courseId, String section)
	{
		boolean success = false;
		String result="";
		try {
				//String query = "Select * from 	person INNER JOIN  instructor ON person.personId = instructor.personId  INNER JOIN courseInstructorMap  ON  instructor.instructorId = courseInstructorMap.instructorId" +
				//		" AND (courseInstructorMap.courseId= '"+courseId+"'and courseInstructorMap.section = '"+section+"')";
					String query = "Select * from 	person INNER JOIN  instructor ON person.personId = instructor.personId  INNER JOIN courseInstructorMap  ON  instructor.instructorId = courseInstructorMap.instructorId" +
						" AND (courseInstructorMap.courseId= ? and courseInstructorMap.section = ?)";
					stmt = conn.prepareStatement(query);
					stmt.setString(1, courseId);
					stmt.setString(2, section);
					
				//rs = stmt.executeQuery(query);
					rs = stmt.executeQuery();
				while(rs.next())
				{	success = true;
					System.out.println(rs.getString("instructorId")+ " "+ rs.getString("firstName")+rs.getString("lastname")+rs.getString("address")+ " "+ rs.getString("city")+ " "+ rs.getString("state")
							+rs.getString("zipCode")+" "+ rs.getString("department")+ rs.getString("courseId"));
					result += rs.getString("instructorId")+ "/"+rs.getString("firstName")+ "/"+ rs.getString("lastname")+ "/"+ rs.getString("address")+ "/"+ rs.getString("city")+ "/"+ rs.getString("state")+ "/"+ rs.getString("zipCode")
							+ "/"+rs.getString("department");
					result += "!";
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "false: SQL Exception occured";
		}
		
		// return connection instance to the pool
		if(isPoolingUsed)	
			ConnectionPool.returnConnectionInstanceToPool();
		
		if(success)
			return result;
		else
			return "false:No Records found";
	}

	
	@Override
	public String findById(Object object) {

		Course c = (Course) object ;
		String courseId = c.getCourseId();
		System.out.println(courseId);
		String result = "";
		int count = 0;
		boolean success = false;
		
		try {
			
			System.out.println("Inside findById func"); 
			//String query = "Select * from 	course INNER JOIN coursetiming ON (course.courseId = coursetiming.courseId AND course.section = coursetiming.section)  AND coursetiming.courseId = '"+ courseId + "'";
			String query = "Select * from 	course INNER JOIN coursetiming ON (course.courseId = coursetiming.courseId AND course.section = coursetiming.section)  AND coursetiming.courseId = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, courseId);
			//rs = stmt.executeQuery(query);
			rs = stmt.executeQuery();
			System.out.println("Result set" + rs);
			while(rs.next())
			{ 	success = true;
				count ++ ;
				System.out.println(rs.getString("courseId")+ rs.getString("courseName")+ rs.getString("location")+ rs.getString("section")+ rs.getString("day")+ rs.getString("time")  );
				//rs.toString();
				result +=(rs.getString("courseName")+ "/"+ rs.getString("location")+ "/"+rs.getString("courseId") + "/"+rs.getString("section") + "/"+rs.getString("day") + "/"+rs.getString("time") );
				result += "!";
				
			}
			System.out.println(count);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Printing result set " + rs.toString()); 
		
		if(success)
			return result;
		else
			return "false:No Records found";
	}
	

	@Override
	public String update(Object object) {
		int res = 0;
		Course c = (Course)object;
		try {
			//String query = "Update course set courseName = '"+c.getCourseName()+"', location = '"+c.getLocation()+"' where courseId='" + c.getCourseId()+"' and section ='"+ c.getCourseSection()+"'";
			String query = "Update course set courseName = ?, location = ? where courseId=? and section =?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, c.getCourseName());
			stmt.setString(2, c.getLocation());
			stmt.setString(3, c.getCourseId());
			stmt.setString(4, c.getCourseSection());
			
			//res = stmt.executeUpdate(query);
			res = stmt.executeUpdate();
			//query = "Update coursetiming set day = '"+c.getDays()+"', time = '"+c.getTimings()+"' where courseId='" + c.getCourseId()+"' and section ='"+ c.getCourseSection()+"'";
			query = "Update coursetiming set day = ?, time = ? where courseId=? and section =?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, c.getDays());
			stmt.setString(2, c.getTimings());
			stmt.setString(3, c.getCourseId());
			stmt.setString(4, c.getCourseSection());
			
			//res = stmt.executeUpdate(query);
			res = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(res == 1)
			return String.valueOf(res);
		else
			return "false: Data not Updated";
	}

	@Override
	public String search(String columnName, String keyword) {
		String result = "";
		try {
			String query = "SELECT c.courseId,c.courseName, c.location,ct.day,ct.time FROM course AS c LEFT JOIN coursetiming AS ct ON ct.courseId = c.courseId where " + columnName +" LIKE "+"'%"+keyword+"%'";
			rs = stmt2.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString("courseId") + " "
						+ rs.getString("courseName") + " "
						+ rs.getString("location") + " " 
						+ rs.getString("day") + " "
						+ rs.getString("time"));

				result += rs.getString("courseId") + "/"
						+ rs.getString("courseName") + "/"
						+ rs.getString("location") + "/"
						+ rs.getString("day") + "/"
						+ rs.getString("time");
				result += "!";

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();
		// return rs.toString();
		return result;
	}

	
}
