package be.abis.exercise.model;

import java.util.ArrayList;
import java.util.List;

public class PersonsList {
	private List<Person> persons;
	
	public PersonsList() {
		persons = new ArrayList<>();
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
}
