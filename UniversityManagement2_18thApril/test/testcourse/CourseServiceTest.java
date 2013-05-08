package testcourse;

import static org.junit.Assert.*;


import java.util.Random;
import org.junit.Test;

import edu.service.CourseService;

public class CourseServiceTest {

	
//	@Test
//	public void testAddCourse() {
//	                  
////	     	for (int i=1; i<=100; i++) 
////	     	{	
//	     	Random r = new Random();
//			int a = r.nextInt(999);
//			int b = r.nextInt(10000);
//			int c = r.nextInt(10000);
//
//			String str0 = "CMPE " + a;
//			String str1 = "Software Engineering " + b;
//			String str2 = "01";
//			String str3 = "ENGR Building Room Number  " + c;
//			String str4 = "Monday";
//			String str5 = "06:00 PM";
//			
//			CourseService cs = new CourseService();
//			assertEquals(true, Boolean.parseBoolean(cs.addCourse(str0, str1, str2, str3, str4, str5)));
////	     	}		
//	}
//
//	@Test
//	public void testAddCourse_null() {
//	                  
//			
//			CourseService cs = new CourseService();
//			assertEquals(true, Boolean.parseBoolean(cs.addCourse(null,null,null,null,null,null)));
//	}
//	@Test
//	public void testAddCourse_radom_null() {		
//			CourseService cs = new CourseService();
//			assertEquals(true, Boolean.parseBoolean(cs.addCourse(null,"Software Engineering","01",null,"Mon",null)));
//	     	}
//	
//	
//@Test	
//	public void testDeleteCourse() {                  
//			String str = "CMPE 221";
//			CourseService cs = new CourseService();
//			assertEquals(true, Boolean.parseBoolean(cs.deleteCourse(str)));
//	}
//	
//	@Test	
//	public void testDeleteCourse_null() {          
//			CourseService cs = new CourseService();
//			assertEquals(true, Boolean.parseBoolean(cs.deleteCourse(null)));
//	}
//
//	@Test	
//	public void testDeleteCourse_wrongdata() {          
//			CourseService cs = new CourseService();
//			assertEquals(true, Boolean.parseBoolean(cs.deleteCourse("CMPE 158")));
//	}
//	
//	
//	
//	@Test
//	public void testFindCourse() {
//      String result;
//        String str = "CMPE 231";
//	    CourseService cs = new CourseService();
//        String output =	cs.getCourseById(str);
//        if (output == ("false:No Records found")){result = "false";}
//  		else {result = "true";}
//    	assertEquals(true, Boolean.parseBoolean((result)));
//}
//	@Test
//	public void testFindCourse_null() {
//      String result;
//        String str = null;
//	    CourseService cs = new CourseService();
//        String output =	cs.getCourseById(str);
//        if (output == ("false:No Records found")){result = "false";}
//  		else {result = "true";}
//    	assertEquals(true, Boolean.parseBoolean((result)));
//}
//	@Test
//	public void testFindCourse_wrongdata() {
//      String result;
//        String str = "569851";
//	    CourseService cs = new CourseService();
//        String output =	cs.getCourseById(str);
//        if (output == ("false:No Records found")){result = "false";}
//  		else {result = "true";}
//    	assertEquals(true, Boolean.parseBoolean((result)));
//}
//	
//	
//  @Test	
//	public void testFindAll() {
//        
//	  String result;	
//	  CourseService cs = new CourseService();
//			assertEquals(true, Boolean.parseBoolean(cs.getAllCourses()));
//			
//			
//			String output = cs.getAllCourses();
//			if (output == ("false:No Records found")){result = "false";}
//			else {result = "true";}
//			assertEquals(true, Boolean.parseBoolean((result)));
//			
//	}
//	
//	
//	
//	@Test
//	public void testgetEnrolledStudentForCourse() {
//		String result;
//        String str = "CMPE 636";
//        String str1 = "01";
//			CourseService cs = new CourseService();
//			String output = cs.getEnrolledStudentForCourse(str, str1);
//			if (output == ("false: No Records Found")){result = "false";}
//		else {result = "true";}
//		assertEquals(true, Boolean.parseBoolean((result)));
//	}
//	
//	@Test
//	public void testgetEnrolledStudentForCourse_null() {
//		
//		String result;
//			CourseService cs = new CourseService();
//			String output = cs.getEnrolledStudentForCourse(null,null);
//			if (output == ("false: No Records Found")){result = "false";}
//			else {result = "true";}
//			assertEquals(true, Boolean.parseBoolean((result)));
//	}
//	
//	@Test
//	public void testgetEnrolledStudentForCourse_section_null() {
//		
//		String result;
//      
//			CourseService cs = new CourseService();
//			String output = cs.getEnrolledStudentForCourse("CMPE 176",null);
//			
//			if (output == ("false: No Records Found")){result = "false";}
//			else {result = "true";}
//			assertEquals(true, Boolean.parseBoolean((result)));
//	}
//	
//	@Test
//	public void testgetEnrolledStudentForCourse_ID_null() {
//		
//		String result;
//      
//			CourseService cs = new CourseService();
//			String output = cs.getEnrolledStudentForCourse(null,"01");
//			
//			if (output == ("false: No Records Found")){result = "false";}
//			else {result = "true";}
//			assertEquals(true, Boolean.parseBoolean((result)));
//	}
//	
//	
//	
//    @Test
//    public void testgetAssignedInstructorForCourse() {
//		
//		String result;
//			
//        String str = "CMPE 449";
//        String str1 = "01";
//      
//			CourseService cs = new CourseService();
//			String output = cs.getAssignedInstructorForCourse(str, str1);
//			
//			if (output == ("false:No Records found")){result = "false";}
//	
//		else {result = "true";}
//	
//		assertEquals(true, Boolean.parseBoolean((result)));
//	}
//
//	 @Test
//	    public void testgetAssignedInstructorForCourse_null() {
//			
//			String result;
//				CourseService cs = new CourseService();
//				String output = cs.getAssignedInstructorForCourse(null, null);
//				
//				if (output == ("false:No Records found")){result = "false";}
//				else {result = "true";}
//			assertEquals(true, Boolean.parseBoolean((result)));
//		}
//
//	 
//	 
//	 	 @Test
//	    public void testgetAssignedInstructorForCourse_section_null() {
//			
//			String result;
//				CourseService cs = new CourseService();
//				String output = cs.getAssignedInstructorForCourse("CMPE 176", null);
//				
//				if (output == ("false:No Records found")){result = "false";}
//				else {result = "true";}
//			assertEquals(true, Boolean.parseBoolean((result)));
//		}
//	
//	 @Test
//	    public void testgetAssignedInstructorForCourse_ID_null() {
//			
//			String result;
//				CourseService cs = new CourseService();
//				String output = cs.getAssignedInstructorForCourse(null, "01");
//				
//				if (output == ("false:No Records found")){result = "false";}
//				else {result = "true";}
//			assertEquals(true, Boolean.parseBoolean((result)));
//		}
//	 @Test
//	    public void testgetAssignedInstructorForCourse_wrongdata() {
//			
//			String result;
//				CourseService cs = new CourseService();
//				String output = cs.getAssignedInstructorForCourse("CMPE 765", "58");
//				
//				if (output == ("false:No Records found")){result = "false";}
//				else {result = "true";}
//			assertEquals(true, Boolean.parseBoolean((result)));
//		}
//	
//	
//	
//	@Test
//	public void testCourseUpdate() {
//		String result;
//		        String str0 = "CMPE 478";
//				String str1 = "01";
//				String str2 = "Operating System";
//				String str3 = "556 room";
//				String str4 = "Mon - Wed";
//				String str5 = "08:00 - 09:00";
//				
//		CourseService cs = new CourseService();
//		String output = cs.updateCourse(str0, str1, str2, str3, str4, str5);
//		
//		if (output == ("false: Data not Updated")){result = "false";}
//	
//		else {result = "true";}	
//		assertEquals(true, Boolean.parseBoolean((result)));	
//	}
//	
//	@Test
//	public void testCourseUpdate_null() {
//		String result;
//		        String str0 = null;
//				String str1 = "01";
//				String str2 = "Operating System";
//				String str3 = "556 room";
//				String str4 = "Mon - Wed";
//				String str5 = "08:00 - 09:00";
//				
//		CourseService cs = new CourseService();
//		String output = cs.updateCourse(str0, str1, str2, str3, str4, str5);
//		
//		if (output == ("false: Data not Updated")){result = "false";}
//	
//		else {result = "true";}	
//		assertEquals(true, Boolean.parseBoolean((result)));	
//	}
//	
//	@Test
//	public void testCourseUpdate_wrongdata() {
//		String result;
//		        String str0 = "35659";
//				String str1 = "01";
//				String str2 = "Operating System";
//				String str3 = "556 room";
//				String str4 = "Mon - Wed";
//				String str5 = "08:00 - 09:00";
//				
//		CourseService cs = new CourseService();
//		String output = cs.updateCourse(str0, str1, str2, str3, str4, str5);
//		
//		if (output == ("false: Data not Updated")){result = "false";}
//	
//		else {result = "true";}	
//		assertEquals(true, Boolean.parseBoolean((result)));	
//	}
//	
//	
//	@Test
//	public void testCourseSearch() {
//		String result;				
//		CourseService cs = new CourseService();
//		String output = cs.searchCourse("Course ID", "CMPE 423");
//		
//		if (output == ("false: Data not Updated")){result = "false";}
//	
//		else {result = "true";}	
//		assertEquals(true, Boolean.parseBoolean((result)));	
//	}		
}
