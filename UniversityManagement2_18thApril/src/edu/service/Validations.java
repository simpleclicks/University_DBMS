package edu.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

	public String checkForPerson() {
		return "valid";
	}

	public boolean isStateValid(String state) {
		System.out.println(state);

		String[] stateArray = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE",
				"DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY",
				"LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE",
				"NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR",
				"PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA",
				"WV", "WI", "WY" };
		for (int i = 0; i < stateArray.length; i++) {
			if (state.equals(stateArray[i])) {
				return true;
			}
		}

		return false;
	}
	public boolean isValidZipCode(String zipcode){
		try{
			int num=Integer.parseInt(zipcode);
		}catch(NumberFormatException ex){
			return false;
		}
		return true;
		
	}

	public boolean isAllFieldsFilled(String instructorId, String firstname,
			String lastname, String address, String city, String state,
			String zipCode, String department, String days, String timings) {

		System.out.println("Validation.java");
		System.out.println(instructorId);
		System.out.println(firstname);
		System.out.println(lastname);
		if (instructorId == null

		|| firstname == null || lastname == null || address == null
				|| city == null || state == null || state == null
				|| zipCode == null || department == null || days == null
				|| timings == null) {

			System.out.println("No field is filled");
			return false;

		} else {

			return true;
		}

	}

	public String isValidInstructorID(String instructorId) {
		if (instructorId == null) {
			return "Please Enter Instructor ID";
		} else if (!instructorId.startsWith("I")) {
			return "Please enter valid Instructor Id";
		} else if (instructorId.length() < 10) {
			return "Please enter valid instructor Id";
		} else {
			return "True";
		}
	}
	public String isValidStudentID(String studentId) {
		if (studentId == null) {
			return "Please Enter Student ID";
		} else if (!studentId.startsWith("S")) {
			return "Please enter valid Student Id";
		} else if (studentId.length() < 10) {
			return "Please enter valid Student Id";
		} else {
			return "True";
		}
	}

	public String isValidCourseID(String courseId) {
		if (courseId == null) {
			return "Please enter course Id";
		} else if (!courseId.startsWith("CMPE ")) {
			return "Please enter Valid course Id";
		} else {
			return "True";
		}
	}

	public boolean isAllFields_filled(String courseId, String courseName,
			String courseSection, String location, String day, String timing) {

		if (courseId == null || courseName == null || courseSection == null
				|| location == null || day == null || timing == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean isAllFields_filled_students(String studentId,
			String firstname, String lastname, String address, String city,
			String state, String zipCode) {
		if (studentId == null || firstname == null || lastname == null
				|| address == null || city == null || state == null
				|| zipCode == null) {
			return false;
		} else {
			return true;
		}

	}
	
	// public boolean isNotSpecialCharacter(String FirstName){
	//
	// if(FirstName.contains("!"))
	// return true;
	// }
	
	public boolean hasSpecialCharacter(String str){
		Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(str);
		boolean b = m.find();

		if (b)
			return true;
		else
			return false;
	}
}
