package com.andrade.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	public void DBInstance() {
		
		Technician tec1 = new Technician(null, "Admin", "14623061523", "admin@mail.com", encoder.encode(""));
		tec1.addProfile(Profile.ADMIN);
		
		Technician tecTest = new Technician(null, "Perfil Teste", "85867633730", "teste@mail.com", encoder.encode("123456"));
		
		Technician tec2 = new Technician(null, "Fabio Silva", "84578593312", "fabio@mail.com", encoder.encode("123456"));
		Technician tec3 = new Technician(null, "Caio Souza", "43660339768", "caio@mail.com", encoder.encode("123456"));

		
		Client client1 = new Client(null, "Daniel Ribeiro", "320.492.895-02", "daniel@mail.com", encoder.encode("123"));
		Client client2 = new Client(null, "Carol Souza", "633.281.507-81", "carol@mail.com", encoder.encode("123"));
		Client client3 = new Client(null, "Amanda Silva", "40096161213", "amanda@mail.com", encoder.encode("123"));
		Client client4 = new Client(null, "Fernando Carvalho", "68564220750", "fernando@mail.com", encoder.encode("123"));

		
		Request req1 = new Request(null, Priority.MEDIUM, Status.OPEN, "Chamado 01", "Primeiro chamado", tec2, client1);
		Request req2 = new Request(null, Priority.MEDIUM, Status.PROGRESS, "Chamado 02", "Segundo chamado", tec2, client2);
		Request req3 = new Request(null, Priority.HIGH, Status.PROGRESS, "Chamado 03", "Terceiro chamado", tec3, client3);
		Request req4 = new Request(null, Priority.LOW, Status.CLOSED, "Chamado 04", "Quarto chamado", tec3, client4);



		
		technicianRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tecTest));
		clientRepository.saveAll(Arrays.asList(client1, client2, client3, client4));
		requestRepository.saveAll(Arrays.asList(req1, req2, req3, req4));
	}
}
