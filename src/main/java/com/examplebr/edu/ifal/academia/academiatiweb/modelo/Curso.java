package com.examplebr.edu.ifal.academia.academiatiweb.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "curso")
public class Curso {
	
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nome;
	
	@OneToMany
	private List<Disciplina> disciplina = new ArrayList<>();
	

	public Curso(Integer id, String nome, List<Disciplina> disciplinas) {
		super();
		this.id = id;
		this.nome = nome;
		this.disciplina = disciplinas;
	}
	
	public Curso() {
		super();
	}


	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", disciplina=" + disciplina +  "]";
	}


	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}

}
