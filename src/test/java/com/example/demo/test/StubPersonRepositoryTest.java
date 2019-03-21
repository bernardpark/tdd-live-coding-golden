package com.example.demo.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.Person;
import com.example.demo.stub.StubPersonRepository;

public class StubPersonRepositoryTest {

	private StubPersonRepository stubPersonRepository;

	@Before
	public void setup() {
		stubPersonRepository = new StubPersonRepository();
	}

	@Test
	public void testStubFindByName_1() {
		// Given
		String givenName = "bernard";
		String givenNumber = "1111111111";

		Person person = new Person();
		person.setName(givenName);
		person.setNumber(givenNumber);
		stubPersonRepository.setReturnPerson(person);

		// When
		List<Person> foundPersons = stubPersonRepository.findPersonByName(givenName);

		// Then
		assertThat(foundPersons.size() == 1);

		Person foundPerson = foundPersons.get(0);
		assertEquals(person, foundPerson);
	}

	@Test
	public void testStubFindByName_2() {
		// Given
		String givenName = "john";
		String givenNumber = "2222222222";

		Person person = new Person();
		person.setName(givenName);
		person.setNumber(givenNumber);
		stubPersonRepository.setReturnPerson(person);

		// When
		List<Person> foundPersons = stubPersonRepository.findPersonByName(givenName);

		// Then
		assertThat(foundPersons.size() == 1);

		Person foundPerson = foundPersons.get(0);
		assertEquals(person, foundPerson);
	}
}
