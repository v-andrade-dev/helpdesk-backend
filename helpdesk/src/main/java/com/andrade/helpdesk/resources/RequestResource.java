package com.andrade.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping
	public ResponseEntity<List<RequestDTO>> findAll(){
		List<Request> list = service.findAll();
		List<RequestDTO> listDTO = list.stream().map(obj -> new RequestDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<RequestDTO> create(@Valid @RequestBody RequestDTO objDTO){
		Request obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<RequestDTO> update(@PathVariable Integer id, @Valid @RequestBody RequestDTO objDTO){
		Request newObj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new RequestDTO(newObj));
	}
}