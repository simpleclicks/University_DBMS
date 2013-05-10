/**
 * ValidationsService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.service;

public interface ValidationsService extends javax.xml.rpc.Service {
    public java.lang.String getValidationsAddress();

    public edu.service.Validations getValidations() throws javax.xml.rpc.ServiceException;

    public edu.service.Validations getValidations(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
