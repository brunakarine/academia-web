package com.examplebr.edu.ifal.academia.academiatiweb.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	@Column(length = 80, name = "endereco_aluno", nullable = false)
	private String nome;
		
	@Column(name = "numero", nullable = false)
	private int numero;
	
	@Column(length = 50, name = "bairro", nullable = false)
	private String bairro;
	
	@Column(length = 2, name = "estado", nullable = false)
	private String estado;
	
	@Column(length = 30, name = "cidade", nullable = false)
	private String cidade;
	
	@Column(length = 10, name = "cep", nullable = false)
	private String cep;
	
	public Endereco(String nome, int numero, String bairro, String estado,String cidade, String cep) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.bairro = bairro;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
	}
	
	public Endereco() {
		super();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	}