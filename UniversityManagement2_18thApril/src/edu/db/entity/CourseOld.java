package edu.db.entity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class CourseOld {

	private String courseName;
	private String courseSelection;
	private String location;
	private DateFormat meetingTimes = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseSelection() {
		return courseSelection;
	}
	public void setCourseSelection(String courseSelection) {
		this.courseSelection = courseSelection;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public DateFormat getMeetingTimes() {
		return meetingTimes;
	}
	public void setMeetingTimes(DateFormat meetingTimes) {
		this.meetingTimes = meetingTimes;
	}
	
}
