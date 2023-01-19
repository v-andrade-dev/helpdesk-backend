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
import com.andrade.helpdesk.repositories.ClientRepository;
import com.andrade.helpdesk.repositories.RequestRepository;
import com.andrade.helpdesk.repositories.TechnicianRepository;

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
		
		Technician tec2 = new Technician(null, "Vinicius Andrade", "789.987.258-25", "andrade@mail.com", "123");
		tec2.addProfile(Profile.ADMIN);
		
		Technician tec3 = new Technician(null, "Valdir", "760457775-95", "valdir2@mail.com", "123");
		tec3.addProfile(Profile.ADMIN);
		
		Client client1 = new Client(null, "Linus Torvalds", "705117440-13", "torvalds@mail.com", "123");
	
		Request req1 = new Request(null, Priority.MEDIUM, Status.PROGRESS, "Chamado 01", "Primeiro chamado", tec1, client1);
		
		technicianRepository.saveAll(Arrays.asList(tec1, tec3));
		clientRepository.saveAll(Arrays.asList(client1));
		requestRepository.saveAll(Arrays.asList(req1));
	}
}
