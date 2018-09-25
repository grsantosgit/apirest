package com.spring.apirest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Apirestuser")
public class APIRestUser extends AbstracEntity {

	/**
	 * guilherme rosa dos santos telefone contato 11 996129147 linkedin:
	 * https://www.linkedin.com/in/guilhermerosa/
	 */
	private static final long serialVersionUID = -9050258640377002588L;

	@NotEmpty
	@Column(unique = true)
	private String username;

	@NotEmpty
	@JsonIgnore
	private String password;
	@NotEmpty
	private String name;
	@NotEmpty
	private boolean admin;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}
