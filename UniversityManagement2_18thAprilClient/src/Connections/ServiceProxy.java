package Connections;

public class ServiceProxy implements Connections.Service {
  private String _endpoint = null;
  private Connections.Service service = null;
  
  public ServiceProxy() {
    _initServiceProxy();
  }
  
  public ServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceProxy();
  }
  
  private void _initServiceProxy() {
    try {
      service = (new Connections.ServiceServiceLocator()).getService();
      if (service != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service != null)
      ((javax.xml.rpc.Stub)service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public Connections.Service getService() {
    if (service == null)
      _initServiceProxy();
    return service;
  }
  
  public java.lang.String displayCourseInfo() throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.displayCourseInfo();
  }
  
  public java.lang.String displayPersonInfo() throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.displayPersonInfo();
  }
  
  public java.lang.String listInstructors() throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.listInstructors();
  }
  
  public java.lang.String unEnrollStudent(java.lang.String studentId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.unEnrollStudent(studentId);
  }
  
  public java.lang.String deleteStudent(java.lang.String studentId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.deleteStudent(studentId);
  }
  
  public java.lang.String addInstructor(java.lang.String instructorId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, int zipCode, java.lang.String courseList, java.lang.String department, java.lang.String meetingTime) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.addInstructor(instructorId, firstname, lastname, address, city, state, zipCode, courseList, department, meetingTime);
  }
  
  public java.lang.String deleteInstructor(java.lang.String instructorId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.deleteInstructor(instructorId);
  }
  
  public java.lang.String enrollStudent(java.lang.String studentId, java.lang.String courseId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.enrollStudent(studentId, courseId);
  }
  
  public java.lang.String unAssignInstructor(java.lang.String instructorId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.unAssignInstructor(instructorId);
  }
  
  public java.lang.String assignInstructor(java.lang.String courseId, java.lang.String instructorId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.assignInstructor(courseId, instructorId);
  }
  
  public java.lang.String deleteCourse(java.lang.String courseId) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.deleteCourse(courseId);
  }
  
  public java.lang.String listStudents() throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.listStudents();
  }
  
  public java.lang.String listCourse() throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.listCourse();
  }
  
  public java.lang.String findPreson() throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.findPreson();
  }
  
  public java.lang.String findCourse() throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.findCourse();
  }
  
  public java.lang.String addCourse(java.lang.String courseId, java.lang.String courseName, java.lang.String courseSection, java.lang.String location) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.addCourse(courseId, courseName, courseSection, location);
  }
  
  public java.lang.String addStudent(java.lang.String studentId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, int zipCode, java.lang.String courseList) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.addStudent(studentId, firstname, lastname, address, city, state, zipCode, courseList);
  }
  
  public java.lang.String addPerson(java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, int zipCode, java.lang.String courseList) throws java.rmi.RemoteException{
    if (service == null)
      _initServiceProxy();
    return service.addPerson(firstname, lastname, address, city, state, zipCode, courseList);
  }
  
  
}