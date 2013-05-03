package edu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.dao.ConnectionPool;
import edu.dao.IDao;
import edu.db.entity.Person;


public class PersonDaoImpl implements IDao {

	Connection conn = null;
	static ResultSet rs;
	Statement stmt = null;
	//java.sql.PreparedStatement stmt = null;
	boolean isPoolingUsed = false;
	
	public PersonDaoImpl()
	{
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
	
	/*
	@Override
	public String add(Object object) 
	{
		// TODO Auto-generated method stub
		
		Person p = (Person) object ;
		String firstName = p.getFirstName();
		String lastName = p.getLastName();
		String address = p.getAddress();
		String city = p.getCity();
		String state = p.getState();
		int zipCode = p.getZipCode();
		
		String result = "";
		int personId=0;

		try {
		
				String query = 
					 "Insert into person (firstName,lastName,address,city,state,zipCode) values (?,?,?,?,?,?)"; 
					    
					 stmt = conn.prepareStatement(query);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, city);
			stmt.setString(4, address);
			stmt.setString(5, state);
			stmt.setInt(6, zipCode);
					 
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				personId = rs.getInt(1);
				System.out.println("Person inserted successful");
				System.out.println("personId: "+personId);
			} else {
				result = "false:The data could not be inserted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// return connection instance to the pool
				if(isPoolingUsed)	
					ConnectionPool.returnConnectionInstanceToPool();
				
		return ""+personId;
		
		
	}
*/

	
	@Override
	public String add(Object object) 
	{
		// TODO Auto-generated method stub
		
		Person p = (Person) object ;
		String firstName = p.getFirstName();
		String lastName = p.getLastName();
		String address = p.getAddress();
		String city = p.getCity();
		String state = p.getState();
		int zipCode = p.getZipCode();
		System.out.println(firstName);
		String result = "";
		int personId=0;

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
					+  "')";
			
			stmt.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
			System.out.println("Here");
			rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				personId = rs.getInt(1);
				System.out.println("Person inserted successful");
				System.out.println("personId: "+personId);
			} else {
				result = "false:The data could not be inserted in the databse";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// return connection instance to the pool
				if(isPoolingUsed)	
					ConnectionPool.returnConnectionInstanceToPool();
				
		return ""+personId;
		
		
	}
	
	@Override
	public String delete(Object object) 
	{
		// TODO Auto-generated method stub
		Person p = (Person) object ;
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
				result = "false:Record not found";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return connection instance to the pool
				if(isPoolingUsed)	
					ConnectionPool.returnConnectionInstanceToPool();
		return result;
		
		//return db.deletePerson(personId);
	}

	@Override
	public String findById(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String find(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findAll()
	{
		// TODO Auto-generated method stub
		try {
			String query = "Select * from 	person";
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println(rs.getString("firstName")+ " "+ rs.getString("lastName")+ " "+ rs.getString("address")+ " "+ rs.getString("city") + " "+ rs.getString("state") + 
						" "+ rs.getString("zipCode"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		// return connection instance to the pool
				if(isPoolingUsed)	
					ConnectionPool.returnConnectionInstanceToPool();
		return rs.toString();
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

	@Override
	public String search(String columnName, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
