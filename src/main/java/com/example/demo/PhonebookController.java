package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhonebookController {
	
	@Autowired
	private PhonebookService phonebookService;
	
	@GetMapping(path="/phonebook/{name}")
	public String getNumber(@PathVariable String name) {
		return phonebookService.getNumberByName(name);
	}

	public void setPhonebookService(PhonebookService phonebookService) {
		this.phonebookService = phonebookService;
	}

}
