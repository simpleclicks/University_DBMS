/**
 * StudentService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.service;

public interface StudentService extends java.rmi.Remote {
    public java.lang.String addStudent(java.lang.String studentId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipCode, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String searchStudent(java.lang.String attribute, java.lang.String keyword) throws java.rmi.RemoteException;
    public java.lang.String updateStudent(java.lang.String studentId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zip) throws java.rmi.RemoteException;
    public java.lang.String getEnrolledCoursesForStudent(java.lang.String studentId) throws java.rmi.RemoteException;
    public java.lang.String unEnrollStudent(java.lang.String studentId, java.lang.String courseId, java.lang.String section) throws java.rmi.RemoteException;
    public java.lang.String enrollStudent(java.lang.String courseId, java.lang.String section, java.lang.String studentId) throws java.rmi.RemoteException;
    public java.lang.String getAllStudent() throws java.rmi.RemoteException;
    public java.lang.String deleteStudent(java.lang.String studentId) throws java.rmi.RemoteException;
    public java.lang.String getStudentById(java.lang.String studentId) throws java.rmi.RemoteException;
}
