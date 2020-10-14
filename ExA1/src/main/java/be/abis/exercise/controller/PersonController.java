package be.abis.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	PersonService personService;
	
	@GetMapping("persons/{id}")
	public Person findPerson(@PathVariable("id") int personId) {
		Person p = personService.findPerson(personId);
		return p;
	}
	
	
	@GetMapping("")
	public List<Person> findAllPersons() {
		return personService.getAllPersons();
	}

}
