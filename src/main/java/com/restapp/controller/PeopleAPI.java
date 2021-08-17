package com.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.util.RecordAlreadyExists;
import com.rest.util.RecordNotExists;
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


@GetMapping("/db/people/{start}/{end}")
public List<Person> getPeople2(@PathVariable Integer start,@PathVariable Integer end){
	   return people.getRange(start, end);
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

@PatchMapping("/db/people")
@PutMapping("/db/people")
public ResponseEntity<Person> updatePeople(@RequestBody Person person) {
	try {
		people.updatePeople(person);
		return new ResponseEntity<Person>(person,HttpStatus.CREATED);
	}
	catch(RecordNotExists e) {
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@DeleteMapping("/db/people/{sno}")
public ResponseEntity<String> deletePeople(@PathVariable Integer sno){
	try {
		people.deletePeople(sno);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.CREATED);
	}
	catch(RecordNotExists e) {
		
		return new ResponseEntity<>("No Such Record Exists",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}
