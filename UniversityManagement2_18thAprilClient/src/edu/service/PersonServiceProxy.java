package edu.service;

public class PersonServiceProxy implements edu.service.PersonService {
  private String _endpoint = null;
  private edu.service.PersonService personService = null;
  
  public PersonServiceProxy() {
    _initPersonServiceProxy();
  }
  
  public PersonServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initPersonServiceProxy();
  }
  
  private void _initPersonServiceProxy() {
    try {
      personService = (new edu.service.PersonServiceServiceLocator()).getPersonService();
      if (personService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)personService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)personService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (personService != null)
      ((javax.xml.rpc.Stub)personService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.service.PersonService getPersonService() {
    if (personService == null)
      _initPersonServiceProxy();
    return personService;
  }
  
  public java.lang.String updatePerson(java.lang.String personId, java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zip) throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    return personService.updatePerson(personId, firstname, lastname, address, city, state, zip);
  }
  
  public java.lang.String deletePerson(java.lang.String personId) throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    return personService.deletePerson(personId);
  }
  
  public java.lang.String getAllPerson() throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    return personService.getAllPerson();
  }
  
  public java.lang.String addPerson(java.lang.String firstname, java.lang.String lastname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipCode, java.lang.String password) throws java.rmi.RemoteException{
    if (personService == null)
      _initPersonServiceProxy();
    return personService.addPerson(firstname, lastname, address, city, state, zipCode, password);
  }
  
  
}