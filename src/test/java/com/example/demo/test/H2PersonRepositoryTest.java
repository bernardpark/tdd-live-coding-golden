package com.example.demo.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.DemoApplication;
import com.example.demo.Person;
import com.example.demo.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class H2PersonRepositoryTest {
     
    @Autowired
    private PersonRepository personRepository;
    
   @Test
   public void testFindByName_1() {
   	// Given
   	String givenName = "bernard";
   	String givenNumber = "1111111111";
   	
       Person person = new Person();
       person.setName(givenName);
       person.setNumber(givenNumber);
       personRepository.save(person);
       
       // When
       List<Person> foundPersons = personRepository.findPersonByName(givenName);
       
       // Then
       assertThat(foundPersons.size() == 1);
       
       Person foundPerson = foundPersons.get(0);
       assertEquals(person, foundPerson);
   }
   
  @Test
  public void testFindByName_2() {
  	// Given
  	String givenName = "john";
  	String givenNumber = "2222222222";
  	
      Person person = new Person();
      person.setName(givenName);
      person.setNumber(givenNumber);
      personRepository.save(person);
      
      // When
      List<Person> foundPersons = personRepository.findPersonByName(givenName);
      
      // Then
      assertThat(foundPersons.size() == 1);
      
      Person foundPerson = foundPersons.get(0);
      assertEquals(person, foundPerson);
  }
}