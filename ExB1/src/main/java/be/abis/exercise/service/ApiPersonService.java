package be.abis.exercise.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import be.abis.exercise.model.Login;
import be.abis.exercise.model.Password;
import be.abis.exercise.model.Person;
import be.abis.exercise.model.PersonsList;

@Service
public class ApiPersonService implements PersonService {

	String baseURL = "http://localhost:8084/exercise/test/api/persons";
	
	@Autowired
	RestTemplate rt;
	
	@Override
	public Person findPerson(int id) {
		Person p = rt.getForObject(baseURL+"/"+id,  Person.class);
		return p;
	}

	@Override
	public List<Person> getAllPersons() {
		ResponseEntity<Person[]> response = rt.getForEntity(baseURL, Person[].class);
		Person[] persons =  response.getBody();
		return Arrays.asList(persons);
	}	
	
	@Override
	public Person login(Login login) {
		System.out.println("in login ApiPersonService login=" + login.getEmail() + " "+ login.getPassword());
		Person p = rt.postForObject(baseURL+"/login",login,Person.class);
		System.out.println("after api-call p=" + p);
		return p;
	}

}
