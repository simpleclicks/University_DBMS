/**
 * PersonServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.service;

public interface PersonServiceService extends javax.xml.rpc.Service {
    public java.lang.String getPersonServiceAddress();

    public edu.service.PersonService getPersonService() throws javax.xml.rpc.ServiceException;

    public edu.service.PersonService getPersonService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
