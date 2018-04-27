package com.examplebr.edu.ifal.academia.academiatiweb.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "curso")
public class Curso {
	
	
	@javax.persistence.Id
	private String Id;
	
	@Column
	private String nome;
	
	@OneToMany
	private List<Disciplina> disciplina = new ArrayList<>();
	
	@Column
	private Aluno aluno;

	
	public Curso(String Id, String nome, Aluno aluno) {
		super();
		this.Id = Id;
		this.nome = nome;
		this.aluno = aluno;
			
	}
	
	public Curso() {
		super();
	}

	@Override
	public String toString() {
		return "Curso [Id=" + Id + ", nome=" + nome + ", disciplina=" + disciplina + ", aluno=" + aluno + "]";
	}


	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}




	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public List<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}

}
