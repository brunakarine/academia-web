package com.examplebr.edu.ifal.academia.academiatiweb.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Table(name = "disciplina")
public class Disciplina {
	
	@Id
	private String id;
	
	private String nome;
	
	@OneToMany
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	@OneToMany
	private List<Assunto> assuntos = new ArrayList<Assunto>();
	
	@ManyToMany
	private List<Professor> professores;

	public Disciplina() {
		super();
	}

	public Disciplina(String id, String nome, List<Aluno> alunos, List<Professor> professores, List<Assunto> assuntos) {
		super();
		this.id = id;
		this.nome = nome;
		this.alunos = alunos;
		this.professores = professores;
		this.assuntos = assuntos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}


	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	
	
	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public String toString() {
		return "Disciplina[Id=" + id + ", aluno=" + alunos + ", assunto="+ assuntos + ", professores=" + professores.toString() +"]";
	}

	public List<Assunto> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(List<Assunto> assuntos) {
		this.assuntos = assuntos;
	}

}
