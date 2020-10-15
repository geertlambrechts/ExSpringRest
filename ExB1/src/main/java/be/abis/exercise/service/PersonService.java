package be.abis.exercise.service;

import java.util.List;

import org.springframework.stereotype.Service;

import be.abis.exercise.model.Login;
import be.abis.exercise.model.Password;
import be.abis.exercise.model.Person;

public interface PersonService {
	public Person findPerson(int id);

	List<Person> getAllPersons();

	Person login(Login login);
	
}
