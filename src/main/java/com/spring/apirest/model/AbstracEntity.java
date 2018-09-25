package com.spring.apirest.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstracEntity implements Serializable{

	/**
	 * guilherme rosa dos santos
	 * telefone contato 11 996129147
	 * linkedin: https://www.linkedin.com/in/guilhermerosa/
	 */
	private static final long serialVersionUID = -1407994882796885319L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
