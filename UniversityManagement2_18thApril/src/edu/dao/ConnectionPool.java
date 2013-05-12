package edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class ConnectionPool {

	public static int poolSize = 5;
	public static  int connectionUsed=0;
	public static LinkedList<Connection> conn = new LinkedList<Connection>();

	private static ConnectionPool instance = null;
	
	// Make this a singleton instance
	protected ConnectionPool()
	{
		try {
			// make a connection pool
			
			for(int i=0;i<poolSize;i++)
			{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn.add(DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/univesitydb", "root", "root"));
			}
			
			//stmt = conn.createStatement();

			//if (!conn.isClosed())
			//	System.out.println("Successfully connectiod");
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
	
	public static Connection getConnectionInstanceFromPool()
	{
			
		if(instance == null)
		{
			instance = new ConnectionPool();
		}
			Connection lconn= null;
		
			if(connectionUsed < poolSize)
			{
				lconn = conn.get(connectionUsed);
				connectionUsed++;
				System.out.println("Connection used: "+ connectionUsed);
			}
			return lconn;
	}

	public static void  returnConnectionInstanceToPool()
	{
		if(connectionUsed > 0){
			try {
				conn.get(connectionUsed).close();
				connectionUsed--;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
