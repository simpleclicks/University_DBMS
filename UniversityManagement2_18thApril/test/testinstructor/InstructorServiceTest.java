package testinstructor;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import edu.service.InstructorService;

public class InstructorServiceTest {

//	@Test
//	public void testAddInstructor() {
//	
////		for (int i=0; i<=10000; i++) 
////	     	{
//          Random r = new Random();
//			int a = r.nextInt(1000000000);
//			
//			String str0 = "I" + a; //studentId
//	//		String str0 = "I17671096";
//			String str1 = "Dan";
//			String str2 = "Harkey";
//			String str3 = "B, South Street";
//			String str4 = "Santa Clara";
//			String str5 = "CA";
//			String str6 = "95051";
//			String str7 = "Computer Engineering";
//			String str8 = "Mon-Wed";
//			String str9 = "3:00PM to 04:30PM";
//			String str10 = "abcd";
//			
//			InstructorService is = new InstructorService();
//			assertEquals(true, Boolean.parseBoolean(is.addInstructor(str0, str1, str2,
//					str3, str4, str5,
//					str6, str7, str8, str9, str10)));
//}
//	
//	@Test
//	public void testAddInstructor_null() {
//		
//			InstructorService is = new InstructorService();
//			assertEquals(true, Boolean.parseBoolean(is.addInstructor(null,null,null,null,null,null,null,null,null,null, null)));
//	}	
//	
//	@Test
//	public void testAddInstructor_null_id() {
//		
//			InstructorService is = new InstructorService();
//			assertEquals(true, Boolean.parseBoolean(is.addInstructor(null,"Dan","James","a, north","Sunnyvale","CA","95268","Engr","Mon-Wed","Hours","abcd")));
//	}	
//
//	
//	@Test
//	public void testDeleteInstructor() {
//
//		String str = "I135681347";
//		InstructorService is = new InstructorService();
//		assertEquals(true, Boolean.parseBoolean(is.deleteInstructor(str)));
//		}
//
//	@Test
//	public void testDeleteInstructor_null() {
//		InstructorService is = new InstructorService();
//		assertEquals(true, Boolean.parseBoolean(is.deleteInstructor(null)));
//		}
//	@Test
//	public void testDeleteInstructor_wrongdata() {
//		InstructorService is = new InstructorService();
//		assertEquals(true, Boolean.parseBoolean(is.deleteInstructor("I123")));
//		}
//
//	
//	@Test
//	public void testGetInstructorById() {
//		String result;
//		String str = "I274158534";
//		InstructorService is = new InstructorService();
//	String output = is.getInstructorById(str);
//		
//	if (output == ("false:Not Found")){result = "false";}
//	
//	else {result = "true";}
//	
//	assertEquals(true, Boolean.parseBoolean((result)));
//
//	}
//	
//	@Test
//	public void testGetInstructorById_null() {
//		String result;
//	InstructorService is = new InstructorService();
//	String output = is.getInstructorById(null);	
//	if (output == ("false:Not Found")){result = "false";}
//	else {result = "true";}
//	assertEquals(true, Boolean.parseBoolean((result)));
//	}
//
//	@Test
//	public void testGetInstructorById_wrongdata() {
//		String result;
//	InstructorService is = new InstructorService();
//	String output = is.getInstructorById("658974");	
//	if (output == ("false:Not Found")){result = "false";}
//	else {result = "true";}
//	assertEquals(true, Boolean.parseBoolean((result)));
//	}
//	
//	
//	
//	
//	@Test
//	public void testGetAllInstructor() {
//	String result;
//	InstructorService is = new InstructorService();
//	String output = is.getAllInstructor();
//	if (output == ("false:No Records found")){result = "false";}
//	else {result = "true";}
//	assertEquals(true, Boolean.parseBoolean((result)));
//	}
//
//	
//	@Test
//	public void testAssignInstructor(){
//		InstructorService is = new InstructorService();
//		assertEquals(true, Boolean.parseBoolean(is.assignInstructor("CMPE 746", "01", "I405936604")));
//	}
//	
//
//	@Test
//	public void testAssignInstructor_null() {
//		InstructorService is = new InstructorService();
//		assertEquals(true, Boolean.parseBoolean(is.assignInstructor(null, null, null)));
//	}
//	
//	@Test
//	public void testAssignInstructor_nullexcid() {
//		InstructorService is = new InstructorService();
//		assertEquals(true, Boolean.parseBoolean(is.assignInstructor("CMPE 223", null, null)));
//	}
//	
//	@Test
//	public void testAssignInstructor_nullexsect() {
//		InstructorService is = new InstructorService();
//		assertEquals(true, Boolean.parseBoolean(is.assignInstructor(null, "01", null)));
//	}
//	
//	@Test
//	public void testAssignInstructor_nulliid() {
//		InstructorService is = new InstructorService();
//		assertEquals(true, Boolean.parseBoolean(is.assignInstructor(null, null, "I374651987")));
//	}
//
//	@Test
//	public void testAssignInstructor_wrongdata() {
//		InstructorService is = new InstructorService();
//		assertEquals(true, Boolean.parseBoolean(is.assignInstructor("cmpe 443", "58", "I422203663")));
//	}
//
//	
//	
//	
//	
//	
//	@Test
//	public void testUnAssignInstructor() {
//	String str0 = "I405936604";
//	String str1 = "CMPE 420";
//	String str2 = "01";
//	InstructorService is = new InstructorService();
//	assertEquals(true, Boolean.parseBoolean(is.unAssignInstructor(str0, str1, str2)));	
//	}
//	
//	@Test
//	public void testUnAssignInstructor_null() {
//	InstructorService is = new InstructorService();
//	assertEquals(true, Boolean.parseBoolean(is.unAssignInstructor(null, null, null)));	
//	}
//	@Test
//	public void testUnAssignInstructor_nullexiid() {
//	InstructorService is = new InstructorService();
//	assertEquals(true, Boolean.parseBoolean(is.unAssignInstructor("I158964258", null, null)));	
//	}
//	@Test
//	public void testUnAssignInstructor_nullexsect() {
//	InstructorService is = new InstructorService();
//	assertEquals(true, Boolean.parseBoolean(is.unAssignInstructor(null, null, "01")));	
//	}
//	@Test
//	public void testUnAssignInstructor_nullexcid() {
//	InstructorService is = new InstructorService();
//	assertEquals(true, Boolean.parseBoolean(is.unAssignInstructor(null, "CMPE 231", null)));	
//	}
//	@Test
//	public void testUnAssignInstructor_wrongdata() {
//	InstructorService is = new InstructorService();
//	assertEquals(true, Boolean.parseBoolean(is.unAssignInstructor("I158964258", "CMPE 251", "65")));	
//	}
//	
//
//	@Test
//	public void testGetAssignedCoursesForInstructor() {
//	String result;
//	String str1 = "I405936604";	
//	InstructorService is = new InstructorService();
//	String output = is.getAssignedCoursesForInstructor(str1);
//	if (output == ("false: No Records found")){result = "false";}
//	else {result = "true";}
//	assertEquals(true, Boolean.parseBoolean((result)));
//	}
//	
//	@Test
//	public void testGetAssignedCoursesForInstructor_null() {
//	String result;
//	InstructorService is = new InstructorService();
//	String output = is.getAssignedCoursesForInstructor(null);
//	if (output == ("false: No Records found")){result = "false";}
//	else {result = "true";}
//	assertEquals(true, Boolean.parseBoolean((result)));
//	}
//	@Test
//	public void testGetAssignedCoursesForInstructor_wrongdata() {
//	String result;
//	InstructorService is = new InstructorService();
//	String output = is.getAssignedCoursesForInstructor("547852");
//	if (output == ("false: No Records found")){result = "false";}
//	else {result = "true";}
//	assertEquals(true, Boolean.parseBoolean((result)));
//	}
//	
//	
//	@Test
//	public void testupdateInstructor() {
//		String result;
//		        String str0 = "I812196609";
//				String str1 = "Peter";
//				String str2 = "Mills";
//				String str3 = "ABC, Corby park";
//				String str4 = "San Carlos";
//				String str5 = "MA";
//				String str6 = "95059";
//				String str7 = "Civil Engineering";
//				String str8 = "TUE-Wed";
//				String str9 = "7:00PM to 09:30PM";
//		InstructorService is = new InstructorService();
//		String output = is.updateInstructor(str0, str1, str2, str3, str4, str5, str6, str7, str8, str9);
//		
//		if (output == ("false: Data not Updated")){result = "false";}
//	
//		else {result = "true";}	
//		assertEquals(true, Boolean.parseBoolean((result)));	
//	}
//	
//	@Test
//	public void testupdateInstructor_iidnull() {
//		String result;
//		InstructorService is = new InstructorService();
//		String output = is.updateInstructor(null, "Jamie", "Huagenton", "See road, Corby park", 
//				"San Antonio", "CA", "95543", "Chemical Engineering", "TUE-fri", "7:00PM to 09:30PM");
//		if (output == ("false: Data not Updated")){result = "false";}
//	
//		else {result = "true";}	
//		assertEquals(true, Boolean.parseBoolean((result)));	
//	}
//	
//	@Test
//	public void testupdateInstructor_Wrongdata() {
//		String result;
//		InstructorService is = new InstructorService();
//		String output = is.updateInstructor("I845985896", "Jamie", "Huagenton", "See road, Corby park", 
//				"San Antonio", "CA", "95543", "Chemical Engineering", "TUE-fri", "7:00PM to 09:30PM");
//		if (output == ("false: Data not Updated")){result = "false";}
//	
//		else {result = "true";}	
//		assertEquals(true, Boolean.parseBoolean((result)));	
//	}
//
//	
//	@Test	
//	public void testSearchInstructor(){			
//		InstructorService is = new InstructorService();
//		String result;				
//		String output = is.searchInstructor("Instructor Id", "I135681347");
//		
//		if (output == ("false: No Records found")){result = "false";}
//	
//		else {result = "true";}	
//		assertEquals(true, Boolean.parseBoolean((result)));	
//	}	

}
