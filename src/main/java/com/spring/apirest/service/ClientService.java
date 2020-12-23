package com.spring.apirest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.apirest.entities.ClientEntity;

public interface ClientService {

	public Page<ClientEntity> getClients(Pageable pageable);

	public List<ClientEntity> findClienteByNomeIsNull();

	public ClientEntity findClientById(Long id);

	public void saveClient(ClientEntity cliente);

	public ClientEntity update(Long id, ClientEntity cliente);

	public void delete(Long id);

	public void deleteALL();

}
