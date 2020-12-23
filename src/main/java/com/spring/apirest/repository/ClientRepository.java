package com.spring.apirest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring.apirest.entities.ClientEntity;

public interface ClientRepository extends PagingAndSortingRepository<ClientEntity, Long> {

	public ClientEntity findClienteById(Long id);
	
	public List<ClientEntity> findClienteByNomeIsNull();

}
