package edu.service;

public class ValidationsProxy implements edu.service.Validations {
  private String _endpoint = null;
  private edu.service.Validations validations = null;
  
  public ValidationsProxy() {
    _initValidationsProxy();
  }
  
  public ValidationsProxy(String endpoint) {
    _endpoint = endpoint;
    _initValidationsProxy();
  }
  
  private void _initValidationsProxy() {
    try {
      validations = (new edu.service.ValidationsServiceLocator()).getValidations();
      if (validations != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)validations)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)validations)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (validations != null)
      ((javax.xml.rpc.Stub)validations)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.service.Validations getValidations() {
    if (validations == null)
      _initValidationsProxy();
    return validations;
  }
  
  public boolean isStateValid(java.lang.String state) throws java.rmi.RemoteException{
    if (validations == null)
      _initValidationsProxy();
    return validations.isStateValid(state);
  }
  
  public java.lang.String isValidInstructorID(java.lang.String instructorId) throws java.rmi.RemoteException{
    if (validations == null)
      _initValidationsProxy();
    return validations.isValidInstructorID(instructorId);
  }
  
  public boolean isValidZipCode(java.lang.String zipcode) throws java.rmi.RemoteException{
    if (validations == null)
      _initValidationsProxy();
    return validations.isValidZipCode(zipcode);
  }
  
  public java.lang.String isValidStudentID(java.lang.String studentId) throws java.rmi.RemoteException{
    if (validations == null)
      _initValidationsProxy();
    return validations.isValidStudentID(studentId);
  }
  
  public boolean isAllFields_filled_students(java.lang.String studentId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipCode) throws java.rmi.RemoteException{
    if (validations == null)
      _initValidationsProxy();
    return validations.isAllFields_filled_students(studentId, firstname, lastname, address, city, state, zipCode);
  }
  
  public java.lang.String checkForPerson() throws java.rmi.RemoteException{
    if (validations == null)
      _initValidationsProxy();
    return validations.checkForPerson();
  }
  
  public boolean isAllFieldsFilled(java.lang.String instructorId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipCode, java.lang.String department, java.lang.String days, java.lang.String timings) throws java.rmi.RemoteException{
    if (validations == null)
      _initValidationsProxy();
    return validations.isAllFieldsFilled(instructorId, firstname, lastname, address, city, state, zipCode, department, days, timings);
  }
  
  public boolean hasSpecialCharacter(java.lang.String str) throws java.rmi.RemoteException{
    if (validations == null)
      _initValidationsProxy();
    return validations.hasSpecialCharacter(str);
  }
  
  public java.lang.String isValidCourseID(java.lang.String courseId) throws java.rmi.RemoteException{
    if (validations == null)
      _initValidationsProxy();
    return validations.isValidCourseID(courseId);
  }
  
  public boolean isAllFields_filled(java.lang.String courseId, java.lang.String courseName, java.lang.String courseSection, java.lang.String location, java.lang.String day, java.lang.String timing) throws java.rmi.RemoteException{
    if (validations == null)
      _initValidationsProxy();
    return validations.isAllFields_filled(courseId, courseName, courseSection, location, day, timing);
  }
  
  
}