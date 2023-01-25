package com.andrade.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

<<<<<<< HEAD
import javax.validation.Valid;

=======
>>>>>>> d55a6c077fccf3268de2af11398a65aa02332c33
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andrade.helpdesk.domain.Client;
import com.andrade.helpdesk.domain.dtos.ClientDTO;
import com.andrade.helpdesk.services.ClientService;

<<<<<<< HEAD
=======
import jakarta.validation.Valid;

>>>>>>> d55a6c077fccf3268de2af11398a65aa02332c33
@RestController
@RequestMapping(value = "/client")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Integer id){
		Client obj = service.findById(id);
		return ResponseEntity.ok().body(new ClientDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll(){
		List<Client> list = service.findAll();
		List<ClientDTO> listDTO = list.stream().map(obj -> new ClientDTO(obj)).
				collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO objDTO){
		Client newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Integer id, @Valid @RequestBody ClientDTO objDTO){
		Client obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new ClientDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}