package com.andrade.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.andrade.helpdesk.domain.dtos.TechnicianDTO;
import com.andrade.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Technician extends Person{
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore // resposta apenas com info do tecnico
	@OneToMany(mappedBy = "technician") // Anotação de relação um para muitos
	private List<Request> requests = new ArrayList<>();

	public Technician() {
		super();
		addProfile(Profile.TECHNICIAN);
	}

	public Technician(Integer id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
		addProfile(Profile.TECHNICIAN);

	}
	
	public Technician(TechnicianDTO obj) { // Construtor do padrão DTO
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.profiles = obj.getProfiles().stream().map(x -> x.getCode()).collect(Collectors.toSet());
		this.creation_date = obj.getCreation_date();
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}


}
