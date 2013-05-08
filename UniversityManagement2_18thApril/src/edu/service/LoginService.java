package edu.service;

import javax.jws.WebService;

import edu.dao.IDao;
import edu.dao.impl.InstructorDaoImpl;
import edu.dao.impl.StudentDaoImpl;

@WebService
public class LoginService {
	IDao iDao = null;
	
	public String login(String id, String password){
		String result = null;
		
		if(id == null || password == null){
			System.out.println("Please enter ID and Password");
			result = "false";
			
		} 	
		
		
		else if(id.startsWith("I")){
			iDao = new InstructorDaoImpl();
			result = ((InstructorDaoImpl) iDao).login(id,password);
		}
		else if(id.startsWith("S")){
			iDao = new StudentDaoImpl();
			result = ((StudentDaoImpl) iDao).login(id,password);
		}
		else if (id.equals("admin") && password.equals("admin")){
			result = "Login successful!";
		} else {
			result = "Please enter a valid ID";
		}
		return result;
	}
}
