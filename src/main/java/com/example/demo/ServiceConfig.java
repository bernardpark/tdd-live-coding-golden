package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
	
	@Bean
	public PhonebookService phonebookService() {
		return new PhonebookService();
	}

}
