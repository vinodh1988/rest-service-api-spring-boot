package com.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.util.RecordAlreadyExists;
import com.restapp.entities.Person;
import com.restapp.services.PeopleService;

@RestController
@RequestMapping("/api")
public class PeopleAPI {
@Autowired
	  PeopleService people;

@GetMapping("/people")
   public List<Person> getPeople(){
	   return people.getPeople();
   }

@GetMapping("/db/people")
public List<Person> getPeople2(){
	   return people.getPeople2();
}

@PostMapping("/db/people")
public ResponseEntity<Person> addPeople(@RequestBody Person person) {
	try {
		people.addPeople(person);
		return new ResponseEntity<Person>(person,HttpStatus.CREATED);
	}
	catch(RecordAlreadyExists e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}
