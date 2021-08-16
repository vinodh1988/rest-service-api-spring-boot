package com.restapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapp.entities.Person;

public interface PeopleRepository extends JpaRepository<Person, Long> {

}
