package com.spring.apirest.entities;

import javax.persistence.Entity;

import com.spring.apirest.model.AbstracEntity;

@Entity
public class ClientEntity extends AbstracEntity {

	/**
	 * guilherme rosa dos santos
	 * telefone contato 11 996129147
	 * linkedin: https://www.linkedin.com/in/guilhermerosa/
	 */
	private static final long serialVersionUID = -3011629406937954484L;

	 
	private String nome;
	
	private Integer idade;
	
	private String cidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	

}
