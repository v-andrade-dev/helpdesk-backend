package com.andrade.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrade.helpdesk.domain.Request;
import com.andrade.helpdesk.repositories.RequestRepository;
import com.andrade.helpdesk.services.exceptions.ObjNotFoundException;

@Service
public class RequestService {

	@Autowired
	private RequestRepository repository;
	
	public Request findById(Integer id) {
		Optional<Request> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException("Objeto não encontrado! Id: " + id));
	}
}
