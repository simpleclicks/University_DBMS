package edu.service;

import java.util.HashMap;
import java.util.Map;

import edu.dao.IDao;
import edu.dao.impl.CourseDaoImpl;
import edu.dao.impl.InstructorDaoImpl;
import edu.db.entity.Course;

public class CourseService {
	
	static Map<String, String> attrToColumn = new HashMap<String, String>() {
		{
			put("Course ID", "c.courseId");
			put("Course Name", "c.courseName");
			put("Course Location", "c.location");
			put("Course Days", "ct.day");
			put("Course Timing", "ct.time");
		}
	};
	
	public String addCourse(String courseId, String courseName, String courseSection, String location, String day, String timing)
	{
		
		Course c = new Course();
		c.setCourseId(courseId);
		c.setCourseName(courseName);
		c.setCourseSection(courseSection);
		c.setLocation(location);		
		c.setDays(day);
		c.setTimings(timing);
		IDao dao = new CourseDaoImpl();
		return dao.add(c);

	}
	
	
	public String deleteCourse(String courseId)
	{
		Course c = new Course();
		c.setCourseId(courseId);		
		IDao dao = new CourseDaoImpl();
		return dao.delete(c);
		
	}
	
	
	public String findCourse(String search)
	{			
		Course c = new Course();
		c.setSearch(search);		
		IDao dao = new CourseDaoImpl();
		return dao.find(c);
	}
	
	public String getAllCourses( )
	{
		IDao dao = new CourseDaoImpl();
		return dao.findAll();
	}
	
	public String getEnrolledStudentForCourse(String courseId, String section)
	{
		CourseDaoImpl cdao = new CourseDaoImpl();
		return cdao.getEnrolledStudentForCourse(courseId, section);
	}
	
	public String getAssignedInstructorForCourse(String courseId, String section)
	{
		CourseDaoImpl cdao = new CourseDaoImpl();
		return cdao.getAssignedInstructorForCourse(courseId, section);
	}

	public String getCourseById(String courseId) {
		Course course = new Course();
		course.setCourseId(courseId);
		IDao dao = new CourseDaoImpl();
		return dao.findById(course);
	}

	public String updateCourse(String courseId, String courseSection,
			String courseName, String courseLocation, String days, String timing) {
		//String result = null;
		IDao dao = new CourseDaoImpl();
		Course c = new Course();
		c.setCourseId(courseId);
		c.setCourseSection(courseSection);
		c.setCourseName(courseName);
		c.setLocation(courseLocation);
		c.setDays(days);
		c.setTimings(timing);
		return dao.update(c);
	}

	public String searchCourse(String attribute, String keyword) {
		//String result = null;
		IDao dao = new CourseDaoImpl();
		String columnName = attrToColumn.get(attribute);
		
		if (columnName == null || columnName == "") {
			return "False:attribute name " + attribute + " is invalid.";
		}
		
		return dao.search(columnName, keyword);
	}

}
