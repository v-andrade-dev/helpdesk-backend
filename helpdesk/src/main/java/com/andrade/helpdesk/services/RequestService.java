package com.andrade.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrade.helpdesk.domain.Client;
import com.andrade.helpdesk.domain.Request;
import com.andrade.helpdesk.domain.Technician;
import com.andrade.helpdesk.domain.dtos.RequestDTO;
import com.andrade.helpdesk.domain.enums.Priority;
import com.andrade.helpdesk.domain.enums.Status;
import com.andrade.helpdesk.repositories.RequestRepository;
import com.andrade.helpdesk.services.exceptions.ObjNotFoundException;

import jakarta.validation.Valid;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repository;
	@Autowired
	private TechnicianService techService;
	@Autowired
	private ClientService clientService;
	
	public Request findById(Integer id) {
		Optional<Request> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException("Objeto não encontrado! Id: " + id));
	}
	
	public List<Request> findAll(){
		return repository.findAll();
	}

	public Request create(@Valid RequestDTO objDTO) {
		return repository.save(newRequest(objDTO));
	}
	

	public Request update(Integer id, @Valid RequestDTO objDTO) {
		objDTO.setId(id);
		Request oldObj = findById(id);
		oldObj = newRequest(objDTO);
		return repository.save(oldObj);
	}
	
	private Request newRequest(RequestDTO obj) {
		Technician tech = techService.findById(obj.getTechnician());
		Client client = clientService.findById(obj.getClient());
		Request request = new Request();
		
		if(obj.getId() != null) {
			request.setId(obj.getId());
		}
		
		if(obj.getStatus().equals(2)) {
			request.setClose_date(LocalDate.now());
		}
		
		request.setClient(client);
		request.setTechnician(tech);
		request.setPriority(Priority.toEnum(obj.getPriority()));
		request.setStatus(Status.toEnum(obj.getStatus()));
		request.setTitle(obj.getTitle());
		request.setNote(obj.getNote());
		
		return request;
	}

}
