package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class PhonebookService {

	@Autowired
	private PersonRepository personRepository;

	public String getNumberByName(String name) {
		List<Person> persons = personRepository.findPersonByName(name);
		if (persons.size() > 0) {
			return transformHumanReadable(persons.get(0).getNumber());
		}
		else {
			return "";
		}
	}
	
	public String transformHumanReadable(String number) {
		return "("
				+ number.substring(0, 3)
				+ ") "
				+ number.substring(3,6)
				+ "-"
				+ number.substring(6);
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
}
