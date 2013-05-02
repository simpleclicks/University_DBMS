/**
 * InstructorServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.service;

public interface InstructorServiceService extends javax.xml.rpc.Service {
    public java.lang.String getInstructorServiceAddress();

    public edu.service.InstructorService getInstructorService() throws javax.xml.rpc.ServiceException;

    public edu.service.InstructorService getInstructorService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
