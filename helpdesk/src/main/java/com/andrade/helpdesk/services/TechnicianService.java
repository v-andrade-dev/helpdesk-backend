package com.andrade.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrade.helpdesk.domain.Technician;
import com.andrade.helpdesk.domain.dtos.TechnicianDTO;
import com.andrade.helpdesk.repositories.TechnicianRepository;
import com.andrade.helpdesk.services.exceptions.ObjNotFoundException;

@Service
public class TechnicianService {
	
	@Autowired
	private TechnicianRepository repository;
	
	public Technician findById(Integer id) {
		Optional<Technician> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjNotFoundException("Objeto não encontrado! Id: "+ id));
	}

	public List<Technician> findAll() {
		return repository.findAll();
	}

	public Technician create(TechnicianDTO objDTO) {
		objDTO.setId(null);
		Technician newObj = new Technician(objDTO);
		return repository.save(newObj);
	}
}
