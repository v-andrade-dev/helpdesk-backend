package com.andrade.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.andrade.helpdesk.domain.enums.Priority;
import com.andrade.helpdesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Request implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação para o banco gerar o id
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate Open_date = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate close_date;
	
	private Priority priority;
	private Status status;
	private String title;
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "technician_id") //Anotação de relação muitos para um
	private Technician technician;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	public Request() {
		super();
	}

	public Request(Integer id, Priority priority, Status status, String title, String note, Technician technician,
			Client client) {
		super();
		this.id = id;
		this.priority = priority;
		this.status = status;
		this.title = title;
		this.note = note;
		this.technician = technician;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getOpen_date() {
		return Open_date;
	}

	public void setOpen_date(LocalDate open_date) {
		Open_date = open_date;
	}

	public LocalDate getClose_date() {
		return close_date;
	}

	public void setClose_date(LocalDate close_date) {
		this.close_date = close_date;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
