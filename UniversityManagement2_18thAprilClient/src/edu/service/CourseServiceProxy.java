package edu.service;

public class CourseServiceProxy implements edu.service.CourseService {
  private String _endpoint = null;
  private edu.service.CourseService courseService = null;
  
  public CourseServiceProxy() {
    _initCourseServiceProxy();
  }
  
  public CourseServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCourseServiceProxy();
  }
  
  private void _initCourseServiceProxy() {
    try {
      courseService = (new edu.service.CourseServiceServiceLocator()).getCourseService();
      if (courseService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)courseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)courseService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (courseService != null)
      ((javax.xml.rpc.Stub)courseService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.service.CourseService getCourseService() {
    if (courseService == null)
      _initCourseServiceProxy();
    return courseService;
  }
  
  public java.lang.String getCourseById(java.lang.String courseId) throws java.rmi.RemoteException{
    if (courseService == null)
      _initCourseServiceProxy();
    return courseService.getCourseById(courseId);
  }
  
  public java.lang.String getEnrolledStudentForCourse(java.lang.String courseId, java.lang.String section) throws java.rmi.RemoteException{
    if (courseService == null)
      _initCourseServiceProxy();
    return courseService.getEnrolledStudentForCourse(courseId, section);
  }
  
  public java.lang.String getAllCourses() throws java.rmi.RemoteException{
    if (courseService == null)
      _initCourseServiceProxy();
    return courseService.getAllCourses();
  }
  
  public java.lang.String getAssignedInstructorForCourse(java.lang.String courseId, java.lang.String section) throws java.rmi.RemoteException{
    if (courseService == null)
      _initCourseServiceProxy();
    return courseService.getAssignedInstructorForCourse(courseId, section);
  }
  
  public java.lang.String searchCourse(java.lang.String attribute, java.lang.String keyword) throws java.rmi.RemoteException{
    if (courseService == null)
      _initCourseServiceProxy();
    return courseService.searchCourse(attribute, keyword);
  }
  
  public java.lang.String updateCourse(java.lang.String courseId, java.lang.String courseSection, java.lang.String courseName, java.lang.String courseLocation, java.lang.String days, java.lang.String timing) throws java.rmi.RemoteException{
    if (courseService == null)
      _initCourseServiceProxy();
    return courseService.updateCourse(courseId, courseSection, courseName, courseLocation, days, timing);
  }
  
  public java.lang.String deleteCourse(java.lang.String courseId) throws java.rmi.RemoteException{
    if (courseService == null)
      _initCourseServiceProxy();
    return courseService.deleteCourse(courseId);
  }
  
  public java.lang.String findCourse(java.lang.String search) throws java.rmi.RemoteException{
    if (courseService == null)
      _initCourseServiceProxy();
    return courseService.findCourse(search);
  }
  
  public java.lang.String addCourse(java.lang.String courseId, java.lang.String courseName, java.lang.String courseSection, java.lang.String location, java.lang.String day, java.lang.String timing) throws java.rmi.RemoteException{
    if (courseService == null)
      _initCourseServiceProxy();
    return courseService.addCourse(courseId, courseName, courseSection, location, day, timing);
  }
  
  
}