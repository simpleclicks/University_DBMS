/**
 * CourseService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.service;

public interface CourseService extends java.rmi.Remote {
    public java.lang.String getCourseById(java.lang.String courseId) throws java.rmi.RemoteException;
    public java.lang.String getEnrolledStudentForCourse(java.lang.String courseId) throws java.rmi.RemoteException;
    public java.lang.String getAllCourses() throws java.rmi.RemoteException;
    public java.lang.String addCourse(java.lang.String courseId, java.lang.String courseName, java.lang.String courseSection, java.lang.String location, java.lang.String day, java.lang.String timing) throws java.rmi.RemoteException;
    public java.lang.String deleteCourse(java.lang.String courseId) throws java.rmi.RemoteException;
    public java.lang.String findCourse(java.lang.String search) throws java.rmi.RemoteException;
    public java.lang.String updateCourse(java.lang.String courseId, java.lang.String courseSelection, java.lang.String courseName, java.lang.String courseLocation, java.lang.String days, java.lang.String timing) throws java.rmi.RemoteException;
    public java.lang.String searchCourse(java.lang.String attribute, java.lang.String keyword) throws java.rmi.RemoteException;
    public java.lang.String getAssignedInstructorForCourse(java.lang.String courseId) throws java.rmi.RemoteException;
}
