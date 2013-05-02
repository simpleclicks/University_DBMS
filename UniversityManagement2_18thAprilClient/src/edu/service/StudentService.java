/**
 * StudentService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.service;

public interface StudentService extends java.rmi.Remote {
    public java.lang.String addStudent(java.lang.String studentId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, int zipCode, java.lang.String courseList) throws java.rmi.RemoteException;
}
