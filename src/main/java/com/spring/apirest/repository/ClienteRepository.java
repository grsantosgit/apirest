package com.spring.apirest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring.apirest.model.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {

	public Cliente findClienteById(Long id);
	
	public List<Cliente> findClienteByNomeIsNull();

}
