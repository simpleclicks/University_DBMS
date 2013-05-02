package edu.service;

import edu.dao.IDao;
import edu.dao.impl.CourseDaoImpl;
import edu.dao.impl.InstructorDaoImpl;
import edu.dao.impl.PersonDaoImpl;
import edu.dao.impl.StudentDaoImpl;
import edu.db.entity.Course;
import edu.db.entity.Person;
import edu.db.entity.Student;

public class CourseService {
	public String addCourse(String courseId, String courseName,
			String courseSelection, String location, String day, String timing) {

		Course c = new Course();
		c.setCourseId(courseId + "-" + courseSelection);
		c.setCourseName(courseName);
		c.setLocation(location);
		c.setDays(day);
		c.setTimings(timing);
		IDao dao = new CourseDaoImpl();
		return dao.add(c);

	}

	public String deleteCourse(String courseId) {
		Course c = new Course();
		c.setCourseId(courseId);
		IDao dao = new CourseDaoImpl();
		return dao.delete(c);

	}

	public String findCourse(String search) {
		Course c = new Course();
		c.setSearch(search);
		IDao dao = new CourseDaoImpl();
		return dao.find(c);
	}

	public String getAllCourses() {
		IDao dao = new CourseDaoImpl();
		return dao.findAll();
	}

	public String getEnrolledStudentForCourse(String courseId) {
		CourseDaoImpl cdao = new CourseDaoImpl();
		return cdao.getEnrolledStudentForCourse(courseId);
	}

	public String getAssignedInstructorForCourse(String courseId) {
		CourseDaoImpl cdao = new CourseDaoImpl();
		return cdao.getAssignedInstructorForCourse(courseId);
	}

	public String getCourseById(String courseId) {
		Course course = new Course();
		course.setCourseId(courseId);
		IDao dao = new CourseDaoImpl();
		return dao.findById(courseId);
	}

	public String updateCourse(String courseId, String courseSelection,
			String courseName, String courseLocation, String days, String timing) {
		String result = null;
		IDao dao = new CourseDaoImpl();
		Course c = new Course();
		c.setCourseId(courseId + "-" + courseSelection);
		c.setCourseName(courseName);
		c.setLocation(courseLocation);
		c.setDays(days);
		c.setTimings(timing);
		dao.update(c);
		return result;
	}
}
