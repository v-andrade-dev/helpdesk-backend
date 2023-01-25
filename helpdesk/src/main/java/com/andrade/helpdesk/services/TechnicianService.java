package com.andrade.helpdesk.services;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> d55a6c077fccf3268de2af11398a65aa02332c33
import org.springframework.stereotype.Service;

import com.andrade.helpdesk.domain.Person;
import com.andrade.helpdesk.domain.Technician;
import com.andrade.helpdesk.domain.dtos.TechnicianDTO;
import com.andrade.helpdesk.repositories.PersonRepository;
import com.andrade.helpdesk.repositories.TechnicianRepository;
<<<<<<< HEAD
import com.andrade.helpdesk.services.exceptions.ObjNotFoundException;

=======
import com.andrade.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.andrade.helpdesk.services.exceptions.ObjNotFoundException;

import jakarta.validation.Valid;

>>>>>>> d55a6c077fccf3268de2af11398a65aa02332c33
@Service
public class TechnicianService {
	
	@Autowired
	private TechnicianRepository repository;
	@Autowired
	private PersonRepository personRepository;
	
	public Technician findById(Integer id) {
		Optional<Technician> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjNotFoundException("Objeto não encontrado! Id: "+ id));
	}

	public List<Technician> findAll() {
		return repository.findAll();
	}

	public Technician create(TechnicianDTO objDTO) {
		objDTO.setId(null);
		uniqueDataValidation(objDTO);
		Technician newObj = new Technician(objDTO);
		return repository.save(newObj);
	}
	
	public Technician update(Integer id, @Valid TechnicianDTO objDTO) {
		objDTO.setId(id);
		Technician oldObj = findById(id);
		uniqueDataValidation(objDTO);
		oldObj = new Technician(objDTO);
		return repository.save(oldObj);
		
	}
	
	public void delete(Integer id) {
		Technician obj = findById(id);
		if(obj.getRequests().size() > 0) {
			throw new DataIntegrityViolationException("Técnico possui chamados cadastrados e não pose ser deletado!");
		}
		
		repository.deleteById(id);
	}

	private void uniqueDataValidation(TechnicianDTO objDTO) {
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
