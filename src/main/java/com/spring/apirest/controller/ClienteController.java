package com.spring.apirest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.spring.apirest.error.ResourceNotFounderException;
import com.spring.apirest.model.Cliente;
import com.spring.apirest.repository.ClienteRepository;

@RestController
@RequestMapping(value = "v1/")
public class ClienteController {
	
	private final ClienteRepository clienteDAO;

	@Autowired
	public ClienteController(ClienteRepository repository) {
		this.clienteDAO = repository;
	}
	
	@GetMapping(path = "protected/clients")
	public ResponseEntity<?> getCLientes(Pageable pageable){
		return new ResponseEntity<>(clienteDAO.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping(path = "protected/clients/withErrors")
	public ResponseEntity<?> getCLietesIsNULL() {
		List<Cliente> clienteNameWithNNull = clienteDAO.findClienteByNomeIsNull();
		if(!(clienteNameWithNNull.size()>0)) throw new ResourceNotFounderException("Clientes not found");
		return new ResponseEntity<>(clienteNameWithNNull, HttpStatus.OK);
	}
	
	
	@GetMapping(path ="protected/clients/{id}")
	public ResponseEntity<?> getClienteById(@PathVariable("id") Long id){
		verifyIfClienteExist(id);
		Cliente cliente = clienteDAO.findClienteById(id);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@PostMapping(path = "admin/clients")
	public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente) {
		clienteDAO.save(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "admin/clients/{id}")
	public ResponseEntity<?> updateCliente(@PathVariable("id")Long id, @RequestBody Cliente cliente) {
		verifyIfClienteExist(id);
		Cliente clienteFounder = clienteDAO.findClienteById(id);
		clienteFounder.setNome(cliente.getNome());
		clienteFounder.setIdade(cliente.getIdade());
		clienteFounder.setCidade(cliente.getCidade());
		clienteDAO.save(clienteFounder);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(path ="admin/clients/{id}")
	public ResponseEntity<?> deleteClienteById(@PathVariable("id") Long id){
		verifyIfClienteExist(id);
		Cliente cliente = clienteDAO.findClienteById(id);
		clienteDAO.delete(cliente);
		return new ResponseEntity<>("Cliente removido com sucesso!", HttpStatus.OK);
	}
	
	@DeleteMapping(path = "protected/clients/withErrors")
	public ResponseEntity<Object> deleteCLietsWithErrors() {
		List<Cliente> findClienteByNomeIsNull = clienteDAO.findClienteByNomeIsNull();
		if(!(findClienteByNomeIsNull.size()>0)) throw new ResourceNotFounderException("Clientes not found");
		else{
			clienteDAO.deleteAll(findClienteByNomeIsNull);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	private void verifyIfClienteExist(Long id) {
		if(clienteDAO.findClienteById(id) == null) throw new ResourceNotFounderException("Cliente not found. id: " + id);
	}
}
