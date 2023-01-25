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
		
		Technician tec1 = new Technician(null, "Carlos Eduardo", "146.230.615-23", "dudu@mail.com", "123");
		tec1.addProfile(Profile.ADMIN);
		
		Technician tec2 = new Technician(null, "Vinicius Andrade", "845.785.933-12", "andrade@mail.com", "123");
		tec2.addProfile(Profile.ADMIN);
		
		Client client1 = new Client(null, "Daniel Ribeiro", "320.492.895-02", "daniel@mail.com", "123");
		Client client2 = new Client(null, "Carol Souza", "633.281.507-81", "carol@mail.com", "123");

	
		Request req1 = new Request(null, Priority.MEDIUM, Status.PROGRESS, "Chamado 01", "Primeiro chamado", tec1, client1);
		
		Request req2 = new Request(null, Priority.MEDIUM, Status.PROGRESS, "Chamado 01", "Primeiro chamado", tec2, client2);

		
		technicianRepository.saveAll(Arrays.asList(tec1, tec2));
		clientRepository.saveAll(Arrays.asList(client1, client2));
		requestRepository.saveAll(Arrays.asList(req1,req2));
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> d55a6c077fccf3268de2af11398a65aa02332c33
