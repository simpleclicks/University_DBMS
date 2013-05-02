package edu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.dao.IDao;
import edu.db.entity.Person;

public class PersonDaoImpl implements IDao {

	Connection conn = null;
	static ResultSet rs;
	Statement stmt = null;

	public PersonDaoImpl() {
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

	@Override
	public String add(Object object) {
		// TODO Auto-generated method stub

		Person p = (Person) object;
		String firstName = p.getFirstName();
		String lastName = p.getLastName();
		String address = p.getAddress();
		String city = p.getCity();
		String state = p.getState();
		int zipCode = p.getZipCode();

		String result = "";
		int personId = 0;

		try {
			String query = "Insert into person (firstName,lastName,address,city,state,zipCode) values"
					+ " ('"
					+ firstName
					+ "', '"
					+ lastName
					+ "', '"
					+ address
					+ "', '" + city + "', '" + state + "', '" + zipCode + "')";
			stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				personId = rs.getInt(1);
				System.out.println("Person inserted successful");
				System.out.println("personId: " + personId);
			} else {
				result = "false:The data could not be inserted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "" + personId;

	}

	@Override
	public String delete(Object object) {
		// TODO Auto-generated method stub
		Person p = (Person) object;
		int personId = p.getPersonId();

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

		return "true";

		// return db.deletePerson(personId);
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
			String query = "Select * from 	person";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString("firstName") + " "
						+ rs.getString("lastName") + " "
						+ rs.getString("address") + " " + rs.getString("city")
						+ " " + rs.getString("state") + " "
						+ rs.getString("zipCode"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs.toString();
	}

	@Override
	public String findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Object object) {
		Person updateMe = (Person) object;
		int res = 0;
		try {
			String query = "Update person set firstName= '"
					+ updateMe.getFirstName() + "', lastName='"
					+ updateMe.getLastName() + "', address='"
					+ updateMe.getAddress() + "', city='"
					+ updateMe.getCity() + "', state='"
					+ updateMe.getState() + "', zipCode="
					+ updateMe.getZipCode() + " where personId="
					+ updateMe.getPersonId();
			res = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return String.valueOf(res);
	}

}
