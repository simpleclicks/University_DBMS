package edu.service;

import javax.jws.WebService;

import edu.dao.IDao;
import edu.dao.impl.InstructorDaoImpl;
import edu.dao.impl.PersonDaoImpl;
import edu.db.entity.Instructor;
import edu.db.entity.Person;

@WebService
public class PersonService {
	
	
	public String addPerson(String firstname, String lastname, String address,
			String city, String state, int zipCode) {
		Person person = new Person();
		person.setFirstName(firstname);
		person.setLastName(lastname);
		person.setAddress(address);
		person.setCity(city);
		person.setState(state);
		person.setZipCode(zipCode);

		IDao dao = new PersonDaoImpl();
		return dao.add(person);

		 //return db.addPerson(firstname, lastname, address, city, state,
		 //zipCode);
	}

	private String deletePerson(String personId ) {
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
	
	public String updatePerson(String instructorEmpId, String firstname, String lastname, String address, String city, String state, int zip){
		String result = null;
		Person i = new Person();
		i.setFirstName(firstname);
		i.setLastName(lastname);
		i.setAddress(address);
		i.setCity(city);
		i.setState(state);
		i.setZipCode(zip);
		PersonDaoImpl pimpl = new PersonDaoImpl();
		pimpl.update(i);
		return result;
	}
}
