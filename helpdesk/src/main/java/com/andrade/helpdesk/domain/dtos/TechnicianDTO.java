package com.andrade.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

<<<<<<< HEAD
import javax.validation.constraints.NotNull;

=======
>>>>>>> d55a6c077fccf3268de2af11398a65aa02332c33
import com.andrade.helpdesk.domain.Technician;
import com.andrade.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;

<<<<<<< HEAD
=======
import jakarta.validation.constraints.NotNull;

>>>>>>> d55a6c077fccf3268de2af11398a65aa02332c33
public class TechnicianDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	protected Integer id;
	@NotNull(message = "Nome não pode ser vazio")
	protected String name;
	@NotNull(message = "CPF não pode ser vazio")
	protected String cpf;
	@NotNull(message = "E-mail não pode ser vazio")
	protected String email;
	@NotNull(message = "Senha não pode ser vazio")
	protected String password;
	protected Set<Integer> profiles = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy") 
	protected LocalDate creation_date = LocalDate.now();

	public TechnicianDTO() {
		super();
		addProfile(Profile.TECHNICIAN);

		
	}

	public TechnicianDTO(Technician obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.profiles = obj.getProfiles().stream().map(x -> x.getCode()).collect(Collectors.toSet());
		this.creation_date = obj.getCreation_date();
		addProfile(Profile.TECHNICIAN);

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Profile> getProfiles() {
		return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
	}

	public void addProfile(Profile profile) {
		this.profiles.add(profile.getCode());
	}

	public LocalDate getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(LocalDate creation_date) {
		this.creation_date = creation_date;
	}
	
	
<<<<<<< HEAD
}
=======
}
>>>>>>> d55a6c077fccf3268de2af11398a65aa02332c33
