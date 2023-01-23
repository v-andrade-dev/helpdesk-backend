package com.andrade.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrade.helpdesk.domain.Request;
import com.andrade.helpdesk.domain.dtos.RequestDTO;
import com.andrade.helpdesk.services.RequestService;

@RestController
@RequestMapping(value = "/request")
public class RequestResource {

	@Autowired
	private RequestService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RequestDTO> findById(@PathVariable Integer id){
		Request obj = service.findById(id);
		return ResponseEntity.ok().body(new RequestDTO(obj));
	}
}
