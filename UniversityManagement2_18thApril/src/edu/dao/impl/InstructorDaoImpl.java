package edu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import edu.dao.ConnectionPool;
import edu.dao.IDao;
import edu.db.entity.Instructor;
import edu.db.entity.Person;
import edu.db.entity.Student;

public class InstructorDaoImpl implements IDao {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	boolean isPoolingUsed = false;

	public InstructorDaoImpl() {
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

		Instructor I = (Instructor) object;
		String instructorId = I.getInstructorEmpId();
		String department = I.getDepartment();
		// DateFormat officeHrs = I.getOfficeHours();
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
			query = "Insert into instructortiming (instructorId, day, time) values ('"
					+ instructorId
					+ "','"
					+ I.getDays()
					+ "','"
					+ I.getTiming() + "')";
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

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();

		return result;

		// TODO Auto-generated method stub
	}

	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub

		Instructor I = (Instructor) object;
		String instructorId = I.getInstructorEmpId();

		PersonDaoImpl pdao = new PersonDaoImpl();
		Person p = new Person();

		p.setPersonId(getPersonIdForInstructor(instructorId));
		System.out.println("Instructor Deleted Successfully");

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();

		return pdao.delete(p);

	}

	public int getPersonIdForInstructor(String instructorId) {

		int personId = 0;
		ResultSet rs;

		try {
			String query = "Select personId from instructor where instructorId ="
					+ "'" + instructorId + "'";
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
	public String findById(Object object) {
		// TODO Auto-generated method stub

		Instructor I = (Instructor) object;
		String instructorId = I.getInstructorEmpId();
		boolean found = false;
		String result = "";

		try {
			String query = "Select * from 	person  where personId = (Select personId from instructor where instructorId ="
					+ "'" + instructorId + "')";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				found = true;
				System.out.println("name:" + rs.getString("firstName") + " "
						+ rs.getString("lastName"));
				result = (rs.getString("firstName") + "/"
						+ rs.getString("lastName") + "/"
						+ rs.getString("address") + "/" + rs.getString("city")
						+ "/" + rs.getString("state") + "/"
						+ rs.getString("zipCode") + "/");

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
			String query = "SELECT p.firstName,p.lastName,p.address,p.city,p.state,p.zipCode,i.instructorId,i.department,it.day,it.time FROM person AS p left JOIN instructor AS i ON p.personId = i.personId left JOIN instructortiming  AS  it ON i.instructorId = it.instructorId";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString("instructorId") + " "
						+ rs.getString("firstName") + " "
						+ rs.getString("lastName") + " "
						+ rs.getString("address") + " " + rs.getString("city")
						+ " " + rs.getString("state") + " "
						+ rs.getString("zipCode") + " "
						+ rs.getString("department") + " "
						+ rs.getString("day") + " " + rs.getString("time"));
				result += rs.getString("instructorId") + "/"
						+ rs.getString("firstName") + "/"
						+ rs.getString("lastName") + "/"
						+ rs.getString("address") + "/" + rs.getString("city")
						+ "/" + rs.getString("state") + "/"
						+ rs.getString("zipCode") + "/"
						+ rs.getString("department") + "/"
						+ rs.getString("day") + "/" + rs.getString("time");
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

	public String getEnrolledCoursesForInstructor(String instructorId) {

		try {
			String query = "Select * from 	course INNER JOIN courseInstructorMap  ON  course.courseId = courseInstructorMap.courseId"
					+ " AND courseInstructorMap.instructorId= '"
					+ instructorId
					+ "'";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString("instructorId") + " "
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

	public String assignInstructor(String courseId, String instructorId) {
		String result = "";
		int rowcount;

		try {
			String query = "Insert into courseInstructorMap (courseId,instructorId) values"
					+ " ("
					+ "(select courseId from course where courseId ='"
					+ courseId
					+ "')"
					+ ", "
					+ "(select instructorId from instructor where instructorId ='"
					+ instructorId + "')" + ")";
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

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();
		return result;
	}

	public String unAssignInstructor(String instructorId) {
		String result = "";
		int rowcount;

		try {
			String query = "Delete from courseInstructorMap where instructorId ="
					+ "'" + instructorId + "'";
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

		// return connection instance to the pool
		if (isPoolingUsed)
			ConnectionPool.returnConnectionInstanceToPool();
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
			String query = "Update instructor set department = '"
					+ i.getDepartment() + "' where instructorId="
					+ i.getInstructorEmpId();
			res = stmt.executeUpdate(query);
			query = "Update instructortiming set day = '" + i.getDays()
					+ "', time = '" + i.getTiming() + "' where instructorId="
					+ i.getInstructorEmpId();
			res = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return String.valueOf(res);
	}

	@Override
	public String search(String columnName, String keyword) {
		String result = "";

		try {
			String query = "SELECT p.firstName,p.lastName,p.address,p.city,p.state,p.zipCode,i.instructorId,i.department,it.day,it.time FROM person AS p left JOIN instructor AS i ON p.personId = i.personId left JOIN instructortiming AS it ON i.instructorId = it.instructorId where "
					+ columnName + " LIKE " + "'%" +keyword+"%'";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString("instructorId") + " "
						+ rs.getString("firstName") + " "
						+ rs.getString("lastName") + " "
						+ rs.getString("address") + " " + rs.getString("city")
						+ " " + rs.getString("state") + " "
						+ rs.getString("zipCode") + " "
						+ rs.getString("department") + " "
						+ rs.getString("day") + " " + rs.getString("time"));
				result += rs.getString("instructorId") + "/"
						+ rs.getString("firstName") + "/"
						+ rs.getString("lastName") + "/"
						+ rs.getString("address") + "/" + rs.getString("city")
						+ "/" + rs.getString("state") + "/"
						+ rs.getString("zipCode") + "/"
						+ rs.getString("department") + "/"
						+ rs.getString("day") + "/" + rs.getString("time");
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
