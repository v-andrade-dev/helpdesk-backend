package com.andrade.helpdesk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrade.helpdesk.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
<<<<<<< HEAD

	Optional<Person> findByCpf(String cpf);
	Optional<Person> findByEmail(String email);
=======
	
	Optional<Person> findByCpf(String cpf);
	Optional<Person> findByEmail(String email);

>>>>>>> d55a6c077fccf3268de2af11398a65aa02332c33
}
