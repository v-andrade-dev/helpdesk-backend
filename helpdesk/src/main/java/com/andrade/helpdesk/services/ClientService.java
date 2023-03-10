package com.andrade.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.andrade.helpdesk.domain.Client;
import com.andrade.helpdesk.domain.Person;
import com.andrade.helpdesk.domain.dtos.ClientDTO;
import com.andrade.helpdesk.repositories.ClientRepository;
import com.andrade.helpdesk.repositories.PersonRepository;
import com.andrade.helpdesk.services.exceptions.ObjNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Client findById(Integer id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjNotFoundException("Objeto não encontrado! Id: "+ id));
	}

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Client create(ClientDTO objDTO) {
		objDTO.setId(null);
		uniqueDataValidation(objDTO);
		Client newObj = new Client(objDTO);
		return repository.save(newObj);
	}
	
	public Client update(Integer id, @Valid ClientDTO objDTO) {
		objDTO.setId(id);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		Client oldObj = findById(id);
		uniqueDataValidation(objDTO);
		oldObj = new Client(objDTO);
		return repository.save(oldObj);
		
	}
	
	public void delete(Integer id) {
		Client obj = findById(id);
		if(obj.getRequests().size() > 0) {
			throw new DataIntegrityViolationException("Cliente possui chamados cadastrados e não pose ser deletado!");
		}
		
		repository.deleteById(id);
	}

	private void uniqueDataValidation(ClientDTO objDTO) {
		Optional<Person> obj = personRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado!");
		}
		
		obj = personRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado!");
		}
	}


}