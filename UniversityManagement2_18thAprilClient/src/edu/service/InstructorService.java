/**
 * InstructorService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.service;

public interface InstructorService extends java.rmi.Remote {
    public java.lang.String addInstructor(java.lang.String instructorId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipCode, java.lang.String department, java.lang.String days, java.lang.String timings, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String getInstructorById(java.lang.String instructorId) throws java.rmi.RemoteException;
    public java.lang.String deleteInstructor(java.lang.String instructorId) throws java.rmi.RemoteException;
    public java.lang.String getAllInstructor() throws java.rmi.RemoteException;
    public java.lang.String assignInstructor(java.lang.String courseId, java.lang.String section, java.lang.String instructorId) throws java.rmi.RemoteException;
    public java.lang.String unAssignInstructor(java.lang.String instructorId, java.lang.String courseId, java.lang.String section) throws java.rmi.RemoteException;
    public java.lang.String updateInstructor(java.lang.String instructorEmpId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zip, java.lang.String department, java.lang.String days, java.lang.String timings) throws java.rmi.RemoteException;
    public java.lang.String searchInstructor(java.lang.String attribute, java.lang.String keyword) throws java.rmi.RemoteException;
    public java.lang.String getAssignedCoursesForInstructor(java.lang.String instructorId) throws java.rmi.RemoteException;
}
