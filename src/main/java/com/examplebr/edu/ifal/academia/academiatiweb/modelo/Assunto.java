package com.examplebr.edu.ifal.academia.academiatiweb.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "assunto")
public class Assunto {
	
	@Id
	@GeneratedValue
	private Integer Id;
	
	private String nome;

	
	public Assunto(Integer id, String nome) {
		super();
		Id = id;
		this.nome = nome;
	}

	
	public Assunto() {
		super();
	}
	public Assunto(String nome) {
		this.nome = nome;
	}


	@Override
	public String toString() {
		return "Assunto [Id=" + Id + ", nome=" + nome + "]";
	}

	public void setId(Integer id) {
		Id = id;
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
		Assunto other = (Assunto) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	
	
	
}
