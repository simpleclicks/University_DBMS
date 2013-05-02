package edu.service;

public class StudentServiceProxy implements edu.service.StudentService {
  private String _endpoint = null;
  private edu.service.StudentService studentService = null;
  
  public StudentServiceProxy() {
    _initStudentServiceProxy();
  }
  
  public StudentServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initStudentServiceProxy();
  }
  
  private void _initStudentServiceProxy() {
    try {
      studentService = (new edu.service.StudentServiceServiceLocator()).getStudentService();
      if (studentService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)studentService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)studentService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (studentService != null)
      ((javax.xml.rpc.Stub)studentService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.service.StudentService getStudentService() {
    if (studentService == null)
      _initStudentServiceProxy();
    return studentService;
  }
  
  public java.lang.String addStudent(java.lang.String studentId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, int zipCode, java.lang.String courseList) throws java.rmi.RemoteException{
    if (studentService == null)
      _initStudentServiceProxy();
    return studentService.addStudent(studentId, firstname, lastname, address, city, state, zipCode, courseList);
  }
  
  
}