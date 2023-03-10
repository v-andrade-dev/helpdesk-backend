package com.andrade.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.andrade.helpdesk.domain.dtos.ClientDTO;
import com.andrade.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client extends Person{
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore //impede serialização
	@OneToMany(mappedBy = "client") // Anotação de relação um para muitos
	private List<Request> requests = new ArrayList<>();

	public Client() {
		super();
		addProfile(Profile.CLIENT);
	}
	
	public Client(Integer id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
		addProfile(Profile.CLIENT);
	}

	public Client(ClientDTO obj) { // Construtor do padrão DTO
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
