package edu.service;

public class InstructorServiceProxy implements edu.service.InstructorService {
  private String _endpoint = null;
  private edu.service.InstructorService instructorService = null;
  
  public InstructorServiceProxy() {
    _initInstructorServiceProxy();
  }
  
  public InstructorServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initInstructorServiceProxy();
  }
  
  private void _initInstructorServiceProxy() {
    try {
      instructorService = (new edu.service.InstructorServiceServiceLocator()).getInstructorService();
      if (instructorService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)instructorService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)instructorService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (instructorService != null)
      ((javax.xml.rpc.Stub)instructorService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.service.InstructorService getInstructorService() {
    if (instructorService == null)
      _initInstructorServiceProxy();
    return instructorService;
  }
  
  public java.lang.String updateInstructor(java.lang.String instructorEmpId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, int zip, java.lang.String department, java.lang.String days, java.lang.String timings) throws java.rmi.RemoteException{
    if (instructorService == null)
      _initInstructorServiceProxy();
    return instructorService.updateInstructor(instructorEmpId, firstname, lastname, address, city, state, zip, department, days, timings);
  }
  
  public java.lang.String unAssignInstructor(java.lang.String instructorId) throws java.rmi.RemoteException{
    if (instructorService == null)
      _initInstructorServiceProxy();
    return instructorService.unAssignInstructor(instructorId);
  }
  
  public java.lang.String assignInstructor(java.lang.String courseId, java.lang.String instructorId) throws java.rmi.RemoteException{
    if (instructorService == null)
      _initInstructorServiceProxy();
    return instructorService.assignInstructor(courseId, instructorId);
  }
  
  public java.lang.String getAllInstructor() throws java.rmi.RemoteException{
    if (instructorService == null)
      _initInstructorServiceProxy();
    return instructorService.getAllInstructor();
  }
  
  public java.lang.String getInstructorById(java.lang.String instructorId) throws java.rmi.RemoteException{
    if (instructorService == null)
      _initInstructorServiceProxy();
    return instructorService.getInstructorById(instructorId);
  }
  
  public java.lang.String deleteInstructor(java.lang.String instructorId) throws java.rmi.RemoteException{
    if (instructorService == null)
      _initInstructorServiceProxy();
    return instructorService.deleteInstructor(instructorId);
  }
  
  public java.lang.String addInstructor(java.lang.String instructorId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, int zipCode, java.lang.String department, java.lang.String days, java.lang.String timings) throws java.rmi.RemoteException{
    if (instructorService == null)
      _initInstructorServiceProxy();
    return instructorService.addInstructor(instructorId, firstname, lastname, address, city, state, zipCode, department, days, timings);
  }
  
  public java.lang.String getEnrolledCoursesForInstructor(java.lang.String instructorId) throws java.rmi.RemoteException{
    if (instructorService == null)
      _initInstructorServiceProxy();
    return instructorService.getEnrolledCoursesForInstructor(instructorId);
  }
  
  
}