package edu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.dao.ConnectionPool;
import edu.dao.IDao;
import edu.db.entity.Person;
import edu.db.entity.Student;

public class StudentDaoImpl implements IDao {

	Connection conn = null;
	static ResultSet rs;
	Statement stmt = null;
	boolean isPoolingUsed = false;

	public StudentDaoImpl() {
		getConnectionFromPool();
	}

	private void getSingleConnection() {
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

	private void getConnectionFromPool() {

		try {

			conn = ConnectionPool.getConnectionInstanceFromPool();
			System.out.println(conn);
			if (conn != null) {
				stmt = conn.createStatement();
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
			String query = "Select * from 	person  where personId = (Select personId from student where studentId ="
					+ "'" + studentId + "')";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				found = true;
				System.out.println("name:" + rs.getString("firstName") + " "
						+ rs.getString("lastName"));
				result += rs.getString("studentId") + "/"
						+ rs.getString("firstName") + "/"
						+ rs.getString("lastName") + "/"
						+ rs.getString("address") + "/" + rs.getString("city")
						+ "/" + rs.getString("state") + "/"
						+ rs.getString("zipCode");

			}

		} catch (SQLException e) {
			e.printStackTrace();
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
			String query = "Select personId from Student where studentID ="
					+ "'" + studentId + "'";
			rs = stmt.executeQuery(query);

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

		String result = "";
		try {
			String query = "Select * from 	person INNER JOIN student  ON  person.personId = student.personId";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
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
		}

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();

		// return rs.toString();
		return result;
	}

	public String enrollStudent(String courseId, String studentId) {
		String result = "";
		int rowcount;

		try {
			String query = "Insert into courseStudentMap values" + " ("
					+ "(select courseId from course where courseId ='"
					+ courseId + "')" + ","
					+ "(select studentId from student where studentId ='"
					+ studentId + "')" + ",DEFAULT" + ")";
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

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();

		return result;
	}

	public String unEnrollStudent(String studentId) {
		String result = "";
		int rowcount;

		try {
			String query = "Delete from courseStudentMap where studentId ="
					+ "'" + studentId + "'";
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

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();
		return result;
	}

	public String getEnrolledCoursesForStudent(String studentId) {

		try {
			String query = "Select * from 	course INNER JOIN courseStudentMap  ON  course.courseId = courseStudentMap.courseId"
					+ " AND courseStudentMap.studentId= '" + studentId + "'";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString("studentId") + " "
						+ rs.getString("courseId") + " "
						+ rs.getString("courseName") + " "
						+ rs.getString("location"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();
		return rs.toString();
	}

	@Override
	public String update(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String search(String columnName, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
