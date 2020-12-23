package com.spring.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.apirest.entities.ClientEntity;
import com.spring.apirest.service.ClientService;

@RestController
@RequestMapping(value = "v2/")
public class ClienteController {

	@Autowired
	private ClientService service;

	@GetMapping(path = "protected/clients")
	public ResponseEntity<Page<ClientEntity>> getClients(Pageable pageable) {
		return ResponseEntity.ok().body(service.getClients(pageable));
	}

	@GetMapping(path = "protected/clients/withErrors")
	public ResponseEntity<List<ClientEntity>> getCLietesIsNULL() {
		return ResponseEntity.ok( service.findClienteByNomeIsNull());
	}

	@GetMapping(path = "protected/clients/{id}")
	public ResponseEntity<?> getClienteById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.findClientById(id));
	}

	@PostMapping(path = "admin/clients")
	public ResponseEntity<?> saveCliente(@RequestBody ClientEntity cliente) {
		service.saveClient(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}

	@PutMapping(path = "admin/clients/{id}")
	public ResponseEntity<?> updateCliente(@PathVariable("id") Long id, @RequestBody ClientEntity cliente) {
		return ResponseEntity.ok(service.update(id, cliente));
	}

	@DeleteMapping(path = "admin/clients/{id}")
	public ResponseEntity<?> deleteClienteById(@PathVariable("id") Long id) {
		service.delete(id);
		return new ResponseEntity<>("Cliente removido com sucesso!", HttpStatus.OK);
	}

	@DeleteMapping(path = "protected/clients/withErrors")
	public ResponseEntity<Object> deleteCLietsWithErrors() {
		service.deleteALL();
		return ResponseEntity.ok().build();
	}

}
