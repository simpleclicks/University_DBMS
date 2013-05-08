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
  
  public java.lang.String addStudent(java.lang.String studentId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipCode, java.lang.String password) throws java.rmi.RemoteException{
    if (studentService == null)
      _initStudentServiceProxy();
    return studentService.addStudent(studentId, firstname, lastname, address, city, state, zipCode, password);
  }
  
  public java.lang.String searchStudent(java.lang.String attribute, java.lang.String keyword) throws java.rmi.RemoteException{
    if (studentService == null)
      _initStudentServiceProxy();
    return studentService.searchStudent(attribute, keyword);
  }
  
  public java.lang.String updateStudent(java.lang.String studentId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zip) throws java.rmi.RemoteException{
    if (studentService == null)
      _initStudentServiceProxy();
    return studentService.updateStudent(studentId, firstname, lastname, address, city, state, zip);
  }
  
  public java.lang.String getEnrolledCoursesForStudent(java.lang.String studentId) throws java.rmi.RemoteException{
    if (studentService == null)
      _initStudentServiceProxy();
    return studentService.getEnrolledCoursesForStudent(studentId);
  }
  
  public java.lang.String unEnrollStudent(java.lang.String studentId, java.lang.String courseId, java.lang.String section) throws java.rmi.RemoteException{
    if (studentService == null)
      _initStudentServiceProxy();
    return studentService.unEnrollStudent(studentId, courseId, section);
  }
  
  public java.lang.String enrollStudent(java.lang.String courseId, java.lang.String section, java.lang.String studentId) throws java.rmi.RemoteException{
    if (studentService == null)
      _initStudentServiceProxy();
    return studentService.enrollStudent(courseId, section, studentId);
  }
  
  public java.lang.String getAllStudent() throws java.rmi.RemoteException{
    if (studentService == null)
      _initStudentServiceProxy();
    return studentService.getAllStudent();
  }
  
  public java.lang.String deleteStudent(java.lang.String studentId) throws java.rmi.RemoteException{
    if (studentService == null)
      _initStudentServiceProxy();
    return studentService.deleteStudent(studentId);
  }
  
  public java.lang.String getStudentById(java.lang.String studentId) throws java.rmi.RemoteException{
    if (studentService == null)
      _initStudentServiceProxy();
    return studentService.getStudentById(studentId);
  }
  
  
}