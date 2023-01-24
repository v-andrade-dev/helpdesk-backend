package com.andrade.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.andrade.helpdesk.domain.Request;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

public class RequestDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate open_date = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate close_date;
	@NotNull(message = "O campo Prioridade é obrigatório")
	private Integer priority;
	@NotNull(message = "O campo Staus é obrigatório")
	private Integer status;
	@NotNull(message = "O campo Título é obrigatório")
	private String title;
	@NotNull(message = "O campo Observações é obrigatório")
	private String note;
	@NotNull(message = "O campo Técnico é obrigatório")
	private Integer technician;
	@NotNull(message = "O campo Cliente é obrigatório")
	private Integer client;
	private String tecName;
	private String clientName;
	
	public RequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestDTO(Request obj) {
		super();
		this.id = obj.getId();
		this.open_date = obj.getOpen_date();
		this.close_date = obj.getClose_date();
		this.priority = obj.getPriority().getCode();
		this.status = obj.getStatus().getCode();
		this.title = obj.getTitle();
		this.note = obj.getNote();
		this.technician = obj.getTechnician().getId();
		this.client = obj.getClient().getId();
		this.tecName = obj.getTechnician().getName();
		this.clientName = obj.getClient().getName();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getOpen_date() {
		return open_date;
	}
	public void setOpen_date(LocalDate open_date) {
		this.open_date = open_date;
	}
	public LocalDate getClose_date() {
		return close_date;
	}
	public void setClose_date(LocalDate close_date) {
		this.close_date = close_date;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
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
	public Integer getTechnician() {
		return technician;
	}
	public void setTechnician(Integer technician) {
		this.technician = technician;
	}
	public Integer getClient() {
		return client;
	}
	public void setClient(Integer client) {
		this.client = client;
	}
	public String getTecName() {
		return tecName;
	}
	public void setTecName(String tecName) {
		this.tecName = tecName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	
}
