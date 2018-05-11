package com.examplebr.edu.ifal.academia.academiatiweb.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import java.io.Serializable;


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
	
	@OneToMany
	private List<Aluno> alunos = new ArrayList<Aluno>();
	

	public Curso(Integer id, String nome, List<Disciplina> disciplinas) {
		super();
		this.id = id;
		this.nome = nome;
		this.disciplina = disciplinas;
		this.alunos = alunos;
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunos == null)? 0 : alunos.hashCode());
		result = prime * result + ((disciplina == null) ? 0:disciplina.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null)? 0 : nome.hashCode());
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
		Curso other = (Curso) obj;
		if (alunos == null) {
			if (other.alunos != null)
				return false;
		} else if (!alunos.equals(other.alunos))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
