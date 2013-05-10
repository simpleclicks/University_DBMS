/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package Connections;

public interface Service extends java.rmi.Remote {
    public java.lang.String displayCourseInfo() throws java.rmi.RemoteException;
    public java.lang.String displayPersonInfo() throws java.rmi.RemoteException;
    public java.lang.String listInstructors() throws java.rmi.RemoteException;
    public java.lang.String unEnrollStudent(java.lang.String studentId) throws java.rmi.RemoteException;
    public java.lang.String deleteStudent(java.lang.String studentId) throws java.rmi.RemoteException;
    public java.lang.String addInstructor(java.lang.String instructorId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, int zipCode, java.lang.String courseList, java.lang.String department, java.lang.String meetingTime) throws java.rmi.RemoteException;
    public java.lang.String deleteInstructor(java.lang.String instructorId) throws java.rmi.RemoteException;
    public java.lang.String enrollStudent(java.lang.String studentId, java.lang.String courseId) throws java.rmi.RemoteException;
    public java.lang.String unAssignInstructor(java.lang.String instructorId) throws java.rmi.RemoteException;
    public java.lang.String assignInstructor(java.lang.String courseId, java.lang.String instructorId) throws java.rmi.RemoteException;
    public java.lang.String deleteCourse(java.lang.String courseId) throws java.rmi.RemoteException;
    public java.lang.String listStudents() throws java.rmi.RemoteException;
    public java.lang.String listCourse() throws java.rmi.RemoteException;
    public java.lang.String findPreson() throws java.rmi.RemoteException;
    public java.lang.String findCourse() throws java.rmi.RemoteException;
    public java.lang.String addCourse(java.lang.String courseId, java.lang.String courseName, java.lang.String courseSection, java.lang.String location) throws java.rmi.RemoteException;
    public java.lang.String addStudent(java.lang.String studentId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, int zipCode, java.lang.String courseList) throws java.rmi.RemoteException;
    public java.lang.String addPerson(java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, int zipCode, java.lang.String courseList) throws java.rmi.RemoteException;
}
