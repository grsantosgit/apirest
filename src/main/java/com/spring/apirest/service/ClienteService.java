package com.spring.apirest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.apirest.model.Cliente;

public interface ClienteService {

	public Page<Cliente> getClients(Pageable pageable);

	public List<Cliente> findClienteByNomeIsNull();

	public Cliente findClientById(Long id);

	public void saveClient(Cliente cliente);

	public Cliente update(Long id, Cliente cliente);

	public void delete(Long id);

	public void deleteALL();

}
