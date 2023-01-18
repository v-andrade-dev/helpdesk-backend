package com.andrade.helpdesk.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrade.helpdesk.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
