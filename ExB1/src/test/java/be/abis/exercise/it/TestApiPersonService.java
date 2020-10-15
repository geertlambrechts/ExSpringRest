package be.abis.exercise.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApiPersonService {
	@Autowired
	PersonService personService;

	@Test
	public void contextLoads() {
	}
	

	@Test
	public void firstNamePeter() {
		Person person = personService.findPerson(5);
		assertEquals("Peter",person.getFirstName());
	}

	
	@Test
	public void testGetAllPersons() {
		List<Person> persons = personService.getAllPersons();
		boolean peterFound = false;
		for (Person p : persons) {
			if (p.getFirstName().equals("Peter")) {		
				peterFound = true;
			}
		}
		assertTrue(peterFound);
	}

}
