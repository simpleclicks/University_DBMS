/**
 * PersonService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.service;

public interface PersonService extends java.rmi.Remote {
    public java.lang.String updatePerson(java.lang.String personId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zip) throws java.rmi.RemoteException;
    public java.lang.String deletePerson(java.lang.String personId) throws java.rmi.RemoteException;
    public java.lang.String getAllPerson() throws java.rmi.RemoteException;
    public java.lang.String addPerson(java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipCode, java.lang.String password) throws java.rmi.RemoteException;
}
