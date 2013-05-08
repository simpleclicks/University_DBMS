package teststudent;

import static org.junit.Assert.*;

import java.util.Random;
import org.junit.Test;

import edu.service.InstructorService;
import edu.service.PersonService;
import edu.service.StudentService;

public class StudentServiceTest {

//	@Test
//	public void testAddStudent() {
//		
////		for (int i=0; i<=10000; i++) 
////     	{
//     Random r = new Random();
//	 int a = r.nextInt(1000000000);
//	 String str0 = "I" + a; //studentId
// 		
//		//String str0 = "S256987699";
//		
//		StudentService ss = new StudentService();
//			assertEquals(true, Boolean.parseBoolean(ss.addStudent(str0, "Sam", "Gill",
//					"C, West street", "SJC", "TX",
//					"58965", "asdf")));
//			}
//
////	}



//	@Test
//	public void testAddStudent_idnull() {
//		
//			StudentService ss = new StudentService();
//			assertEquals(true, Boolean.parseBoolean(ss.addStudent(null, "JAY", "Seth",
//					"C, West street", "SJC", "TX",
//					"58965", "asdf")));
//	     	}
//	@Test
//	public void testAddStudent_null() {
//		
//			StudentService ss = new StudentService();
//			assertEquals(true, Boolean.parseBoolean(ss.addStudent(null, null, null, null, null, null, null, null)));
//	     	}
		

//	@Test
//	public void testDeleteStudent() {		
//		String str = "S256987698";
//		StudentService ss = new StudentService();
//		assertEquals(true, Boolean.parseBoolean(ss.deleteStudent(str)));		
//	}
//	
//	@Test
//	public void testDeleteStudent_null() {
//		StudentService ss = new StudentService();
//		assertEquals(true, Boolean.parseBoolean(ss.deleteStudent(null)));		
//	}
//	@Test
//	public void testDeleteStudent_null() {
//		StudentService ss = new StudentService();
//		assertEquals(true, Boolean.parseBoolean(ss.deleteStudent("69854")));		
//	}

//	@Test
//	public void testGetStudentById() {
//		String result;
//		String str = "S664148290";
//		StudentService ss = new StudentService();
//		String output = ss.getStudentById(str);
//		
//		if (output == ("false:Not Found")){result = "false";}	
//     	else {result = "true";}
//		
//    	assertEquals(true, Boolean.parseBoolean((result)));	
//
//	}
	
//	@Test
//	public void testGetStudentById_null() {
//		String result;
//		StudentService ss = new StudentService();
//		String output = ss.getStudentById(null);
//		if (output == ("false:Not Found")){result = "false";}	
//     	else {result = "true";}
//    	assertEquals(true, Boolean.parseBoolean((result)));
//	}
//	@Test
//	public void testGetStudentById_wrongdata() {
//		String result;
//		StudentService ss = new StudentService();
//		String output = ss.getStudentById("56985");
//		if (output == ("false:Not Found")){result = "false";}	
//     	else {result = "true";}
//    	assertEquals(true, Boolean.parseBoolean((result)));
//	}
	
	
	
	
//	@Test
//	public void testGetAllStudent() {
//	String result;
//	StudentService ss = new StudentService();
//
//	String output = ss.getAllStudent();
//
//	if (output == ("false:No Records found")){result = "false";}
//	
//	else {result = "true";}
//	
//	assertEquals(true, Boolean.parseBoolean((result)));
//	}

	
	
//	@Test
//	public void testAssignStudent() {
//		String str = "CMPE 636";
//        String str1 = "01";
//		String str2 = "S421491553";
//		StudentService ss = new StudentService();
//		assertEquals(true, Boolean.parseBoolean(ss.enrollStudent(str, str1, str2)));
//	}
//	@Test
//	public void testAssignStudent_null() {
//		StudentService ss = new StudentService();
//		assertEquals(true, Boolean.parseBoolean(ss.enrollStudent(null, null, null)));
//	}
//	@Test
//	public void testAssignStudent_nullexcid() {
//		StudentService ss = new StudentService();
//		assertEquals(true, Boolean.parseBoolean(ss.enrollStudent("CMPE 134", null, null)));
//	}
//	@Test
//	public void testAssignStudent_nullexdect() {
//		StudentService ss = new StudentService();
//		assertEquals(true, Boolean.parseBoolean(ss.enrollStudent(null, "50", null)));
//	}
//	@Test
//	public void testAssignStudent_nullexsid() {
//		StudentService ss = new StudentService();
//		assertEquals(true, Boolean.parseBoolean(ss.enrollStudent(null, null, "S56984562")));
//	}
//	@Test
//	public void testAssignStudent_wrongdata() {
//		StudentService ss = new StudentService();
//		assertEquals(true, Boolean.parseBoolean(ss.enrollStudent("2345", "68", "S56984562")));
//	}
	
	
	
	
	
//	@Test
//	public void testUnAssignStudent() {
//	
//	  String str = "S421491553";
//      String str1 = "CMPE 636";
//      String str2 = "01";
//	
//	StudentService ss = new StudentService();
//	assertEquals(true, Boolean.parseBoolean(ss.unEnrollStudent(str, str1, str2)));	
//	}
	
	
//	@Test
//	public void testUnAssignStudent_null() {
//	StudentService ss = new StudentService();
//	assertEquals(true, Boolean.parseBoolean(ss.unEnrollStudent(null,null,null)));	
//	}
	
	
//	@Test
//	public void testUnAssignStudent_nullexsid() {
//	StudentService ss = new StudentService();
//	assertEquals(true, Boolean.parseBoolean(ss.unEnrollStudent("S5698547",null,null)));	
//	}
//	@Test
//	public void testUnAssignStudent_nullexcid() {
//	StudentService ss = new StudentService();
//	assertEquals(true, Boolean.parseBoolean(ss.unEnrollStudent(null,"CMPE 172",null)));	
//	}
//	@Test
//	public void testUnAssignStudent_nullexsect() {
//	StudentService ss = new StudentService();
//	assertEquals(true, Boolean.parseBoolean(ss.unEnrollStudent(null,null,"01")));	
//	}
//	@Test
//	public void testUnAssignStudent_wrongdata() {
//	StudentService ss = new StudentService();
//	assertEquals(true, Boolean.parseBoolean(ss.unEnrollStudent("569841256", "CMPE 5444444444", "34")));	
//	}


	
	
	
//	@Test
//	public void testGetEnrolledCoursesForStudent() {
//	    String result;
//		String str1 = "S664148290";
//		StudentService ss = new StudentService();
//	String output = ss.getEnrolledCoursesForStudent(str1);
//	if (output == ("false:No Records found")){result = "false";}
//	
//	else {result = "true";}
//	
//	assertEquals(true, Boolean.parseBoolean((result)));	
//	}
	
//	@Test
//	public void testGetEnrolledCoursesForStudent_null() {
//	    String result;
//		StudentService ss = new StudentService();
//	String output = ss.getEnrolledCoursesForStudent(null);
//	if (output == ("false:No Records found")){result = "false";}
//	else {result = "true";}
//	assertEquals(true, Boolean.parseBoolean((result)));
//	}
//	@Test
//	public void testGetEnrolledCoursesForStudentwrongdata() {
//	    String result;
//		StudentService ss = new StudentService();
//	String output = ss.getEnrolledCoursesForStudent("23654189");
//	if (output == ("false:No Records found")){result = "false";}
//	else {result = "true";}
//	assertEquals(true, Boolean.parseBoolean((result)));
//	}

	
//	@Test
//	public void updateStudent() {
//		String result;
//		        String str0 = "S664148290";
//				String str1 = "Rushi";
//				String str2 = "Trivedi";
//				String str3 = "GHU, Corby park";
//				String str4 = "San Carlos";
//				String str5 = "CA";
//				String str6 = "95059";
//
//		StudentService ss = new StudentService();
//		String output = ss.updateStudent(str0, str1, str2, str3, str4, str5, str6);
//		
//		if (output == ("false: Data not Updated")){result = "false";}
//	
//		else {result = "true";}	
//		assertEquals(true, Boolean.parseBoolean((result)));	
//	}
	
//	@Test
//	public void updateStudent_null() {
//		String result;
//		        String str0 = null;
//				String str1 = "Rushi";
//				String str2 = "Trivedi";
//				String str3 = "GHU, Corby park";
//				String str4 = "San Carlos";
//				String str5 = "CA";
//				String str6 = "95059";
//
//		StudentService ss = new StudentService();
//		String output = ss.updateStudent(str0, str1, str2, str3, str4, str5, str6);
//		
//		if (output == ("false: Data not Updated")){result = "false";}
//	
//		else {result = "true";}	
//		assertEquals(true, Boolean.parseBoolean((result)));	
//	}

//	@Test
//	public void updateStudent_wrongdata() {
//		String result;
//		        String str0 = "5698214";
//				String str1 = "Rushi";
//				String str2 = "Trivedi";
//				String str3 = "GHU, Corby park";
//				String str4 = "San Carlos";
//				String str5 = "CA";
//				String str6 = "95059";
//
//		StudentService ss = new StudentService();
//		String output = ss.updateStudent(str0, str1, str2, str3, str4, str5, str6);
//		
//		if (output == ("false: Data not Updated")){result = "false";}
//	
//		else {result = "true";}	
//		assertEquals(true, Boolean.parseBoolean((result)));	
//	}

	
//	@Test	
//	public void testSearchStudent(){			
//		StudentService ss = new StudentService();
//		String result;				
//		String output = ss.searchStudent("Student Id", "S664148290");
//		
//		if (output == ("false: No Records found")){result = "false";}
//	
//		else {result = "true";}	
//		assertEquals(true, Boolean.parseBoolean((result)));	
//	}	

}
