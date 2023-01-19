package com.andrade.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import com.andrade.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

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

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
	

}
