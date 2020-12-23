package com.spring.apirest.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.apirest.entities.ClientEntity;
import com.spring.apirest.error.ResourceNotFounderException;
import com.spring.apirest.repository.ClientRepository;
import com.spring.apirest.service.ClientService;

public class ClientServiceImpl implements ClientService{
	
	private ClientRepository repository;

	@Override
	public Page<ClientEntity> getClients(Pageable pageable) {
		Page<ClientEntity> clientList = repository.findAll(pageable);
		if(clientList != null || clientList.getSize() > 0) {
			return clientList;
		}else {
			throw new ResourceNotFounderException("Clientes not found");
		}
	}

	@Override
	public List<ClientEntity> findClienteByNomeIsNull() {
		List<ClientEntity> clientsNameByNull = repository.findClienteByNomeIsNull();
		if(!(clientsNameByNull.size() > 0)) {
			throw new ResourceNotFounderException("Clientes not found");
		}else {
			return clientsNameByNull;
		}
	}

	@Override
	public ClientEntity findClientById(Long id) {
		ClientEntity client = repository.findClienteById(id);
		if(client == null) {
			throw new ResourceNotFounderException("Cliente not found. id: " + id);
		}
		return client;
	}

	@Override
	public void saveClient(ClientEntity cliente) {
		repository.save(cliente);
	}

	@Override
	public ClientEntity update(Long id, ClientEntity cliente) {
		ClientEntity clienteFounder = repository.findClienteById(id);
		clienteFounder.setNome(cliente.getNome());
		clienteFounder.setIdade(cliente.getIdade());
		clienteFounder.setCidade(cliente.getCidade());
		return repository.save(clienteFounder);		
	}

	@Override
	public void delete(Long id) {
		ClientEntity cliente = repository.findClienteById(id);
		
		if(cliente != null) {
			repository.delete(cliente);
		}else {
			throw new ResourceNotFounderException("Cliente not found. id: " + id);
		}
	}

	@Override
	public void deleteALL() {
		List<ClientEntity> clientsWithNameNull = repository.findClienteByNomeIsNull();

		if(clientsWithNameNull != null && clientsWithNameNull.size() > 0) {
			repository.deleteAll(clientsWithNameNull);
		}else {
			throw new ResourceNotFounderException("Clientes not found");
		}
		
	}
	
}
