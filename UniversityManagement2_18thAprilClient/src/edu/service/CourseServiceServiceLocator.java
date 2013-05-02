/**
 * CourseServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.service;

public class CourseServiceServiceLocator extends org.apache.axis.client.Service implements edu.service.CourseServiceService {

    public CourseServiceServiceLocator() {
    }


    public CourseServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CourseServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CourseService
    private java.lang.String CourseService_address = "http://localhost:8080/UniversityManagement2/services/CourseService";

    public java.lang.String getCourseServiceAddress() {
        return CourseService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CourseServiceWSDDServiceName = "CourseService";

    public java.lang.String getCourseServiceWSDDServiceName() {
        return CourseServiceWSDDServiceName;
    }

    public void setCourseServiceWSDDServiceName(java.lang.String name) {
        CourseServiceWSDDServiceName = name;
    }

    public edu.service.CourseService getCourseService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CourseService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCourseService(endpoint);
    }

    public edu.service.CourseService getCourseService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.service.CourseServiceSoapBindingStub _stub = new edu.service.CourseServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCourseServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCourseServiceEndpointAddress(java.lang.String address) {
        CourseService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.service.CourseService.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.service.CourseServiceSoapBindingStub _stub = new edu.service.CourseServiceSoapBindingStub(new java.net.URL(CourseService_address), this);
                _stub.setPortName(getCourseServiceWSDDServiceName());
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
        if ("CourseService".equals(inputPortName)) {
            return getCourseService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.edu", "CourseServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.edu", "CourseService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CourseService".equals(portName)) {
            setCourseServiceEndpointAddress(address);
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
