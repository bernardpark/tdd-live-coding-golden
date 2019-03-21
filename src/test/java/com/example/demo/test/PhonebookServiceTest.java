package com.example.demo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.Person;
import com.example.demo.PhonebookService;
import com.example.demo.stub.StubPersonRepository;

public class PhonebookServiceTest {

	private PhonebookService phonebookService;
	private StubPersonRepository stubPersonRepository;

	@Before
	public void setup() {
		phonebookService = new PhonebookService();
		stubPersonRepository = new StubPersonRepository();
		
		phonebookService.setPersonRepository(stubPersonRepository);
	}

	@Test
	public void testGetNumberByName_1() {
		// Given
		String givenName = "bernard";
		String givenNumber = "1111111111";
		Person person = new Person();
		person.setName(givenName);
		person.setNumber(givenNumber);
		
		stubPersonRepository.setReturnPerson(person);
		
		// When
		String returnedNumber = phonebookService.getNumberByName(givenName);
		String expectedNumber = "(111) 111-1111";
		
		// Then
		assertEquals(expectedNumber,returnedNumber);
	}

	@Test
	public void testGetNumberByName_2() {
		// Given
		String givenName = "john";
		String givenNumber = "2222222222";
		Person person = new Person();
		person.setName(givenName);
		person.setNumber(givenNumber);
		
		stubPersonRepository.setReturnPerson(person);
		
		// When
		String returnedNumber = phonebookService.getNumberByName(givenName);
		String expectedNumber = "(222) 222-2222";
		
		// Then
		assertEquals(expectedNumber,returnedNumber);
	}

}
