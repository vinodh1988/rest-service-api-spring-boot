package com.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
