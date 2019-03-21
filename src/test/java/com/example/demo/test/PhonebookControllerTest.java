package com.example.demo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.Person;
import com.example.demo.PhonebookController;
import com.example.demo.PhonebookService;
import com.example.demo.stub.StubPersonRepository;

public class PhonebookControllerTest {
	
	private PhonebookController phonebookController;
	private PhonebookService phonebookService;
	private StubPersonRepository stubPersonRepository;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		phonebookController = new PhonebookController();
		phonebookService = new PhonebookService();
		stubPersonRepository = new StubPersonRepository();
		
		phonebookController.setPhonebookService(phonebookService);
		phonebookService.setPersonRepository(stubPersonRepository);
		
		mockMvc = MockMvcBuilders
				.standaloneSetup(phonebookController)
				.build();
	}
	
	@Test
	public void testGetNumber_1() throws Exception {
		// Given
		String givenName = "bernard";
		String givenNumber = "1111111111";
		Person person = new Person();
		person.setName(givenName);
		person.setNumber(givenNumber);
		
		stubPersonRepository.setReturnPerson(person);
		
		// When
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/phonebook/bernard"))
				.andReturn();
		String expectedNumber = "(111) 111-1111";
		
		// Then
		assertEquals(expectedNumber, mvcResult.getResponse().getContentAsString());
	}

}
