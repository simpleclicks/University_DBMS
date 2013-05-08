package edu.service;

import javax.jws.WebService;

import edu.dao.IDao;
import edu.dao.impl.InstructorDaoImpl;
import edu.dao.impl.PersonDaoImpl;
import edu.db.entity.Person;

@WebService
public class PersonService {
	
	public String addPerson(String firstname, String lastname, String address,
		String city, String state, String zipCode, String password) {
		Person person = new Person();
		person.setFirstName(firstname);
		person.setLastName(lastname);
		person.setAddress(address);
		person.setCity(city);
		person.setState(state);
		person.setZipCode(zipCode);
		person.setPassword(password);

		IDao dao = new PersonDaoImpl();
		return dao.add(person);

	}

	public String deletePerson(String personId ) {
		Person person = new Person();
		person.setPersonId(Integer.parseInt(personId));
		IDao dao = new PersonDaoImpl();		
		return dao.delete(person);
	}
	
	public String getAllPerson( )
	{
		
		IDao dao = new PersonDaoImpl();
		return dao.findAll();
	}
	
	public String updatePerson(String personId, String firstname, String lastname, String address, String city, String state, String zip){
		Person i = new Person();
		i.setPersonId(Integer.parseInt(personId));
		i.setFirstName(firstname);
		i.setLastName(lastname);
		i.setAddress(address);
		i.setCity(city);
		i.setState(state);
		i.setZipCode(zip);
		PersonDaoImpl pimpl = new PersonDaoImpl();
		return pimpl.update(i);
	}
}
