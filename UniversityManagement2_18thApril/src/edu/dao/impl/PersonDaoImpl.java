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


public class PersonDaoImpl implements IDao {

	Connection conn = null;
	static ResultSet rs;
	Statement stmt2 = null;
	java.sql.PreparedStatement stmt = null;
	boolean isPoolingUsed = true;
	
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
			//stmt2 = conn.createStatement();

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
	public String add(Object object) 
	{
		// TODO Auto-generated method stub
		
		Person p = (Person) object ;
		String firstName = p.getFirstName();
		String lastName = p.getLastName();
		String address = p.getAddress();
		String city = p.getCity();
		String state = p.getState();
		String zipCode = p.getZipCode();
		String password = p.getPassword();
		
		String result = "";
		int personId=0;
		boolean success = false;

		try {
		
				String query = 
					 "Insert into person (firstName,lastName,address,city,state,zipCode,password) values (?,?,?,?,?,?,?)"; 
					    
					 stmt = conn.prepareStatement(query);
					stmt.setString(1, firstName);
					stmt.setString(2, lastName);
					stmt.setString(3, address);
					stmt.setString(4, city);
					stmt.setString(5, state);
					stmt.setString(6, zipCode);
					stmt.setString(7, password);
							 
					stmt.executeUpdate();
					rs = stmt.getGeneratedKeys();
		
					if (rs.next()) {
						success = true;
						personId = rs.getInt(1);
						System.out.println("Person inserted successful");
						System.out.println("personId: "+personId);
					} else {
						result = "false:The data could not be inserted in the databse";
			}
		}
		catch(MySQLIntegrityConstraintViolationException e)
		{
			result = "false:Duplicate entries cannot be inserted";
		}
		catch (SQLException e) {
			result = "false:The data could not be inserted in the databse due to some SQLexception";
			e.printStackTrace();
		}
		
		
		// return connection instance to the pool
				if(isPoolingUsed)	
					ConnectionPool.returnConnectionInstanceToPool();
		if(success)		
			return ""+personId;
		else
			return result;
		
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
			String query = "Delete from person where personId =?";
			 stmt = conn.prepareStatement(query);
			 stmt.setInt(1, personId);
			rowcount = stmt.executeUpdate();
			if (rowcount > 0) {
				result = "true";
				System.out.println("Person Deleted successful");
			} else {
				result = "false:Record not found";
			}
		} catch (SQLException e) {
			result = "false:Operation not completed beacause of SQL Exception";
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
		boolean success = false;
		String result="";
		// TODO Auto-generated method stub
		try {
			String query = "Select * from 	person";
			
			//rs = stmt.executeQuery(query);
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			 
			while(rs.next())
			{	success = true;
				System.out.println(rs.getString("firstName")+ " "+ rs.getString("lastName")+ " "+ rs.getString("address")+ " "+ rs.getString("city") + " "+ rs.getString("state") + 
						" "+ rs.getString("zipCode"));
				result += rs.getString("firstName")+ "/"+ rs.getString("lastName")+ "/"+ 
						rs.getString("address")+ "/"+ rs.getString("city") + "/"+ rs.getString("state") + 
					"/"+ rs.getString("zipCode");
				result += "!";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		// return connection instance to the pool
				if(isPoolingUsed)	
					ConnectionPool.returnConnectionInstanceToPool();
		
				if(success)
					//return rs.toString();
					return result;
				else
					return "false: No records found";
	}



	@Override
	public String update(Object object) {
		Person updateMe = (Person) object;
		int res = 0;
		try {
			String query = "Update person set firstName=  ? , lastName= ?, address=?, city= ?, state=?, zipCode=? where personId=?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, updateMe.getFirstName());
			stmt.setString(2, updateMe.getLastName() );
			stmt.setString(3, updateMe.getAddress());
			stmt.setString(4, updateMe.getCity());
			stmt.setString(5, updateMe.getState());
			stmt.setString(6,  updateMe.getZipCode());
			stmt.setInt(7, updateMe.getPersonId());
			
			res = stmt.executeUpdate();
			System.out.println(String.valueOf(res));
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
		// TODO Auto-generated method stub
		return null;
	}
	
}
