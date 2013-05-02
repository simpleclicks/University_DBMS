/**
 * InstructorServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.service;

public class InstructorServiceServiceLocator extends org.apache.axis.client.Service implements edu.service.InstructorServiceService {

    public InstructorServiceServiceLocator() {
    }


    public InstructorServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public InstructorServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for InstructorService
    private java.lang.String InstructorService_address = "http://localhost:8080/UniversityManagement2/services/InstructorService";

    public java.lang.String getInstructorServiceAddress() {
        return InstructorService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String InstructorServiceWSDDServiceName = "InstructorService";

    public java.lang.String getInstructorServiceWSDDServiceName() {
        return InstructorServiceWSDDServiceName;
    }

    public void setInstructorServiceWSDDServiceName(java.lang.String name) {
        InstructorServiceWSDDServiceName = name;
    }

    public edu.service.InstructorService getInstructorService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(InstructorService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getInstructorService(endpoint);
    }

    public edu.service.InstructorService getInstructorService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.service.InstructorServiceSoapBindingStub _stub = new edu.service.InstructorServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getInstructorServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setInstructorServiceEndpointAddress(java.lang.String address) {
        InstructorService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.service.InstructorService.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.service.InstructorServiceSoapBindingStub _stub = new edu.service.InstructorServiceSoapBindingStub(new java.net.URL(InstructorService_address), this);
                _stub.setPortName(getInstructorServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("InstructorService".equals(inputPortName)) {
            return getInstructorService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.edu", "InstructorServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.edu", "InstructorService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("InstructorService".equals(portName)) {
            setInstructorServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
