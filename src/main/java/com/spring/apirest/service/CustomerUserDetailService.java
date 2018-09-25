package com.spring.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.spring.apirest.model.APIRestUser;
import com.spring.apirest.repository.APIRestUserRepository;

@Component
public class CustomerUserDetailService implements UserDetailsService {
	
	private final APIRestUserRepository apiRestUserRepository;
	
	@Autowired
	public CustomerUserDetailService(APIRestUserRepository apiRestUserRepository) {
		this.apiRestUserRepository = apiRestUserRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		APIRestUser user = Optional.ofNullable(this.apiRestUserRepository.findAPIRestUserByUsername(username))
				.orElseThrow(() -> new UsernameNotFoundException("User not Found"));
		
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
		return new User(user.getUsername(), user.getPassword(), user.isAdmin() ? authorityListAdmin : authorityListUser);
		
	}

}
