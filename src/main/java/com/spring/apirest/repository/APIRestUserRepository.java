package com.spring.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring.apirest.model.APIRestUser;

public interface APIRestUserRepository extends PagingAndSortingRepository<APIRestUser, Long> {
	
	APIRestUser findAPIRestUserByUsername(String name);

}
