package com.andrade.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrade.helpdesk.domain.Client;
import com.andrade.helpdesk.domain.Request;
import com.andrade.helpdesk.domain.Technician;
import com.andrade.helpdesk.domain.enums.Priority;
import com.andrade.helpdesk.domain.enums.Profile;
import com.andrade.helpdesk.domain.enums.Status;
import com.andrade.helpdesk.domain.repositories.ClientRepository;
import com.andrade.helpdesk.domain.repositories.RequestRepository;
import com.andrade.helpdesk.domain.repositories.TechnicianRepository;

@Service
public class DBService {

	@Autowired
	private TechnicianRepository technicianRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private RequestRepository requestRepository;
	
	public void DBInstance() {
		
		Technician tec1 = new Technician(null, "Valdir cezar", "76045777093", "valdir@mail.com", "123");
		tec1.addProfile(Profile.ADMIN);
		
		Client client1 = new Client(null, "Linus Torvalds", "705117440-13", "torvalds@mail.com", "123");
	
		Request req1 = new Request(null, Priority.MEDIUM, Status.PROGRESS, "Chamado 01", "Primeiro chamado", tec1, client1);
		
		technicianRepository.saveAll(Arrays.asList(tec1));
		clientRepository.saveAll(Arrays.asList(client1));
		requestRepository.saveAll(Arrays.asList(req1));
	}
}
