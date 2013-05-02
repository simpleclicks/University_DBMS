package edu.dao;

public interface IDao {

	public String add(Object object);
	
	public String delete(Object object);
	
	public String findById(String id);
	
	public String update(Object object);
	
	public String find(Object object);
	
	public String findAll();
}

