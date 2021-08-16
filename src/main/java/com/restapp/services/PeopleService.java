package com.restapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.restapp.entities.Person;

@Service
public class PeopleService {
	
   public List<Person> getPeople(){
	   List<Person> list=new ArrayList<Person>();
	   list.add(new Person(1,"Harry","Chennai"));
	   list.add(new Person(2,"Krishna","Indore"));
	   list.add(new Person(3,"Ram","Bangalore"));
	   list.add(new Person(4,"Mahesh","Mumbai"));
	   return list;
   }
}
