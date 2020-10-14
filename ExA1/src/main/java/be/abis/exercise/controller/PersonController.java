package be.abis.exercise.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RestController
@RequestMapping("persons")
public class PersonController {
	@Autowired
	PersonService personService;
	
	@GetMapping("{id}")
	public Person findPerson(@PathVariable("id") int personId) {
		Person p = personService.findPerson(personId);
		return p;
	}
	
	
	@GetMapping("")
	public List<Person> findAllPersons() {
		return personService.getAllPersons();
	}
	
	
	@PostMapping("")
	public void addPersons(@RequestBody Person person) {
		try {
			personService.addPerson(person);
		}
		catch (IOException e) {
			System.out.println("Error when adding : " + person.getPersonId() + " error:" + e.getMessage());
			
		}
	}
	
	
	@DeleteMapping("{id}")
	public void deletePersons(@PathVariable("id") int personId) {
		try {
			personService.deletePerson(personId);;
		}
		catch (PersonCanNotBeDeletedException e) {
			System.out.println("Error when deleting : " + personId + " error:" + e.getMessage());
		}
	}
	
	
	@PostMapping("login")
	public Person login(@RequestBody Person person) {
		Person newPerson = personService.findPerson(person.getEmailAddress(), person.getPassword());
		return newPerson;
	}
	

}
