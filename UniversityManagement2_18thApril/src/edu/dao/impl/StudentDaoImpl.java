package edu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import edu.dao.ConnectionPool;
import edu.dao.IDao;
import edu.db.entity.Person;
import edu.db.entity.Student;

// Student working fine.....just add prepared statements.

public class StudentDaoImpl implements IDao {

	Connection conn = null;
	static ResultSet rs;
	Statement stmt2 = null;
	java.sql.PreparedStatement stmt = null;
	boolean isPoolingUsed = false;

	public StudentDaoImpl() {
		getConnectionFromPool();
	}

	private void getSingleConnection() {
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

	private void getConnectionFromPool() {

		try {

			conn = ConnectionPool.getConnectionInstanceFromPool();
			System.out.println(conn);
			if (conn != null) {
				stmt2 = conn.createStatement();
				isPoolingUsed = true;
				if (!conn.isClosed())
					System.out.println("Successfully connectiod");
			} else {
				System.out.println("Connection Pool Threshold");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String add(Object object) {

		Student student = (Student) object;
		String studentId = student.getStudentId();
		int personId = student.getPersonId();

		String result = "";
		int rowcount;

		try {
			//String query = "Insert into student (studentId,personId) values"
			//		+ " ('" + studentId + "', '" + personId + "')";
			String query = "Insert into student (studentId,personId) values"
					+ " ( ?, ? )";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, studentId);
			stmt.setInt(2, personId);
			//rowcount = stmt.executeUpdate(query);
			rowcount = stmt.executeUpdate();
			if (rowcount > 0) {
				result = "true";
				System.out.println("Student inserted successful");
			} else {
				result = "false:The data could not be inserted in the databse";
			}
		}
		catch(MySQLIntegrityConstraintViolationException e)
		{
			result = "false:Duplicate entries cannot be inserted";
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();
		return result;

	}

	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		Student student = (Student) object;
		String studentId = student.getStudentId();

		PersonDaoImpl pdao = new PersonDaoImpl();
		Person p = new Person();
		p.setPersonId(getPersonIdForStudent(studentId));
		System.out.println(p.getPersonId());
		System.out.println("Student Deleted Successfully");

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();

		return pdao.delete(p);

	}

	@Override
	public String findById(Object object) {
		// TODO Auto-generated method stub

		Student student = (Student) object;
		String studentId = student.getStudentId();
		boolean found = false;
		String result = "";

		try {
			//String query = "Select * from 	person  where personId = (Select personId from student where studentId ='"+ studentId + "')";
			String query = "Select * from 	person  where personId = (Select personId from student where studentId = ?)";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, studentId);
			
			//rs = stmt.executeQuery(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				found = true;
				System.out.println("name:" + rs.getString("firstName") + " "
						+ rs.getString("lastName"));
				result += studentId + "/"
						+ rs.getString("firstName") + "/"
						+ rs.getString("lastName") + "/"
						+ rs.getString("address") + "/" + rs.getString("city")
						+ "/" + rs.getString("state") + "/"
						+ rs.getString("zipCode");

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "false:SQL Exception occured";
		}

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();
		if (found)
			// return rs.toString();
			return result;
		else
			return "false:Not Found";
	}

	public int getPersonIdForStudent(String studentId) {

		int personId = 0;
		ResultSet rs;

		try {
			//String query = "Select personId from Student where studentID ="
			//		+ "'" + studentId + "'";
			String query = "Select personId from Student where studentID = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, studentId);
			
			//rs = stmt.executeQuery(query);
			rs = stmt.executeQuery();

			while (rs.next()) {
				personId = rs.getInt(1);
				System.out.println(personId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();

		return personId;
	}

	@Override
	public String find(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findAll() {
		// TODO Auto-generated method stub

		boolean success = false;
		String result = "";
		try {
			String query = "Select * from 	person INNER JOIN student  ON  person.personId = student.personId";
			stmt = conn.prepareStatement(query);
			//rs = stmt.executeQuery(query);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				success = true;
				System.out.println(rs.getString("studentId") + " "
						+ rs.getString("firstName") + " "
						+ rs.getString("lastName") + " "
						+ rs.getString("address") + " " + rs.getString("city")
						+ " " + rs.getString("state") + " "
						+ rs.getString("zipCode"));
				result += rs.getString("studentId") + "/"
						+ rs.getString("firstName") + "/"
						+ rs.getString("lastName") + "/"
						+ rs.getString("address") + "/" + rs.getString("city")
						+ "/" + rs.getString("state") + "/"
						+ rs.getString("zipCode");
				result += "!";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return "false: SQL Exception occured";
		}

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();

		// return rs.toString();
		if(success)
			return result;
		else
			return "false:No Records found";
	}

	public String enrollStudent(String courseId, String section, String studentId) {
		String result = "";
		int rowcount;

		try {
		/*	String query = "Insert into courseStudentMap values" + " ("
					+ "(select courseId from course where courseId ='"
					+ courseId +  "' and section = '"+ section+"')" + ","
					+"(select section from course where courseId ='"
					+ courseId +  "' and section = '"+ section+"')" + ","
					+ "(select studentId from student where studentId ='"
					+ studentId + "'))"; */
			
			String query = "Insert into courseStudentMap values" + " ("
					+ "(select courseId from course where courseId ="
					+ "?  and section = ?)" + ","
					+"(select section from course where courseId ="
					+ "? and section = ?)" + ","
					+ "(select studentId from student where studentId ="
					+ "? ))";
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, courseId);
			stmt.setString(2, section);
			stmt.setString(3, courseId);
			stmt.setString(4, section);
			stmt.setString(5, studentId);
			//rowcount = stmt.executeUpdate(query);
			rowcount = stmt.executeUpdate();
			if (rowcount > 0) {
				result = "true";
				System.out.println("Student enrolled successful");
			} else {
				result = "false:The data could not be inserted in the databse";
			}
		} 
		catch(MySQLIntegrityConstraintViolationException e)
		{
			result = "false:Duplicate entries cannot be inserted";
		}
		catch (SQLException e) {
			result = "false:The data could not be inserted in the databse due to SQL exception";
			e.printStackTrace();
		}

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();

		return result;
	}

	public String unEnrollStudent(String studentId, String courseId, String section) {
		String result = "";
		int rowcount;

		try {
		/*	String query = "Delete from courseStudentMap where studentId ='"
			 + studentId + "' and courseId ='"+courseId+"' and section = '"+section+"'";*/
			
			String query = "Delete from courseStudentMap where studentId = ? and courseId = ? and section = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, studentId);
			stmt.setString(2, courseId);
			stmt.setString(3, section);
			
			//rowcount = stmt.executeUpdate(query);
			rowcount = stmt.executeUpdate();
			if (rowcount > 0) {
				result = "true";
				System.out.println("student unenrolled successful");
			} else {
				result = "false:The data could not be deleted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();
		return result;
	}

	public String getEnrolledCoursesForStudent(String studentId) {
		
		String result="";
		boolean success = false;
		try {
		
		/*	String query = "Select * from 	course INNER JOIN courseStudentMap  ON  (course.courseId = courseStudentMap.courseId and course.section = courseStudentMap.section)"
					+ " INNER JOIN coursetiming ON  (courseStudentMap.courseId = coursetiming.courseId and coursetiming.section = courseStudentMap.section) AND courseStudentMap.studentId= '" + studentId + "'"; */
			String query = "Select * from 	course INNER JOIN courseStudentMap  ON  (course.courseId = courseStudentMap.courseId and course.section = courseStudentMap.section)"
					+ " INNER JOIN coursetiming ON  (courseStudentMap.courseId = coursetiming.courseId and coursetiming.section = courseStudentMap.section) AND courseStudentMap.studentId= ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, studentId);
			
			//rs = stmt.executeQuery(query);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				success = true;
				System.out.println(rs.getString("studentId") + " "
						+ rs.getString("courseId") + " "
						+ rs.getString("courseName") + " "
						+ rs.getString("location"));
				result += rs.getString("studentId") + "/"
						+ rs.getString("courseId") + "/"
						+ rs.getString("courseName") + "/"
						+ rs.getString("location") + "/" + rs.getString("section")
						+ "/" + rs.getString("day")+ "/" + rs.getString("time");
				result += "!";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();
		if(success)
			return result;
		else
			return "false:No Records found";
	}

	@Override
	public String update(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String search(String columnName, String keyword) {
		String result = "";
		boolean success = false;
		try {
			String query = "Select * from person as p inner JOIN student as s ON  p.personId = s.personId where "+columnName+" LIKE '%"+keyword+"%'";
		
			rs = stmt2.executeQuery(query);

			while (rs.next()) {
				success = true;
				System.out.println(rs.getString("studentId") + " "
						+ rs.getString("firstName") + " "
						+ rs.getString("lastName") + " "
						+ rs.getString("address") + " " + rs.getString("city")
						+ " " + rs.getString("state") + " "
						+ rs.getString("zipCode"));
				
				result += rs.getString("studentId") + "/"
						+ rs.getString("firstName") + "/"
						+ rs.getString("lastName") + "/"
						+ rs.getString("address") + "/" + rs.getString("city")
						+ "/" + rs.getString("state") + "/"
						+ rs.getString("zipCode");
				result += "!";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			 return "false: SQL Exception occurred";
		}
		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();

		// return rs.toString();
		if(success)
			return result;
		else
			return "false: No Records Found";
	}

	public String login(String id,String password){
		String result = "";
		String query = "Select personId from student where studentId='" + id +"'";
		try {
			rs = stmt2.executeQuery(query);
			if(!rs.first()){
				result = "Please enter a valid student id.";
			}
			else
			{
				query = "Select password from person where personId='" + rs.getString("personId")+"'";
				ResultSet rs1 = stmt2.executeQuery(query);
				while(rs1.next()){
					if(password.equals(rs1.getString("password"))){
						result = "Login successful!";
					}
					else
						result = "Login failed!";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
