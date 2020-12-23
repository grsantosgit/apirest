package com.spring.apirest.service.impl;

import java.lang.annotation.Repeatable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.apirest.error.ResourceNotFounderException;
import com.spring.apirest.model.Cliente;
import com.spring.apirest.repository.ClienteRepository;
import com.spring.apirest.service.ClienteService;

public class ClientServiceImpl implements ClienteService{
	
	private ClienteRepository repository;

	@Override
	public Page<Cliente> getClients(Pageable pageable) {
		Page<Cliente> clientList = repository.findAll(pageable);
		if(clientList != null || clientList.getSize() > 0) {
			return clientList;
		}else {
			throw new ResourceNotFounderException("Clientes not found");
		}
	}

	@Override
	public List<Cliente> findClienteByNomeIsNull() {
		List<Cliente> clientsNameByNull = repository.findClienteByNomeIsNull();
		if(!(clientsNameByNull.size() > 0)) {
			throw new ResourceNotFounderException("Clientes not found");
		}else {
			return clientsNameByNull;
		}
	}

	@Override
	public Cliente findClientById(Long id) {
		Cliente client = repository.findClienteById(id);
		if(client == null) {
			throw new ResourceNotFounderException("Cliente not found. id: " + id);
		}
		return client;
	}

	@Override
	public void saveClient(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	public Cliente update(Long id, Cliente cliente) {
		Cliente clienteFounder = repository.findClienteById(id);
		clienteFounder.setNome(cliente.getNome());
		clienteFounder.setIdade(cliente.getIdade());
		clienteFounder.setCidade(cliente.getCidade());
		return repository.save(clienteFounder);		
	}

	@Override
	public void delete(Long id) {
		Cliente cliente = repository.findClienteById(id);
		
		if(cliente != null) {
			repository.delete(cliente);
		}else {
			throw new ResourceNotFounderException("Cliente not found. id: " + id);
		}
	}

	@Override
	public void deleteALL() {
		List<Cliente> clientsWithNameNull = repository.findClienteByNomeIsNull();

		if(clientsWithNameNull != null && clientsWithNameNull.size() > 0) {
			repository.deleteAll(clientsWithNameNull);
		}else {
			throw new ResourceNotFounderException("Clientes not found");
		}
		
	}
	
}
