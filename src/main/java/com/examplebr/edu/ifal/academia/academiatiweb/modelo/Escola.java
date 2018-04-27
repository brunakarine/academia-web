package com.examplebr.edu.ifal.academia.academiatiweb.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "escola")
public class Escola {
	
	@Id
	private Integer id;
	
	@OneToMany
	private List<Curso> cursos = new ArrayList<Curso>();
	
	@OneToMany
	private List<Professor> professores = new ArrayList<Professor>();
	
	@Column
	private String nome;
	
    public Escola(Integer id, String curso, String professor) {
	     super();
	     this.id = id;
    }

	public Escola() {
		super();
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
		
	}
	
}