package com.examplebr.edu.ifal.academia.academiatiweb.modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;

@MappedSuperclass
public class Pessoa {
		
	@Id
	@GeneratedValue
	private String Id;
	private String nome;
	
	
	public Pessoa(String id, String nome) {
		super();
		this.Id = id;
		this.nome = nome;
	}
	public Pessoa() {
		super();
	}
	public String getId() {
		return Id;
	}
	
	public void setId(String id) {
		this.Id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 52;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
}
