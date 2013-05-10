/**
 * Validations.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.service;

public interface Validations extends java.rmi.Remote {
    public boolean isStateValid(java.lang.String state) throws java.rmi.RemoteException;
    public java.lang.String isValidInstructorID(java.lang.String instructorId) throws java.rmi.RemoteException;
    public boolean isValidZipCode(java.lang.String zipcode) throws java.rmi.RemoteException;
    public java.lang.String isValidStudentID(java.lang.String studentId) throws java.rmi.RemoteException;
    public boolean isAllFields_filled_students(java.lang.String studentId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipCode) throws java.rmi.RemoteException;
    public java.lang.String checkForPerson() throws java.rmi.RemoteException;
    public boolean isAllFieldsFilled(java.lang.String instructorId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipCode, java.lang.String department, java.lang.String days, java.lang.String timings) throws java.rmi.RemoteException;
    public boolean hasSpecialCharacter(java.lang.String str) throws java.rmi.RemoteException;
    public java.lang.String isValidCourseID(java.lang.String courseId) throws java.rmi.RemoteException;
    public boolean isAllFields_filled(java.lang.String courseId, java.lang.String courseName, java.lang.String courseSection, java.lang.String location, java.lang.String day, java.lang.String timing) throws java.rmi.RemoteException;
}
