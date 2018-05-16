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
	
	@OneToMany
	private List<Aluno> alunos = new ArrayList<Aluno>();
	

	public Curso(String nome) {
		super();	
		this.nome = nome;
	}
	
	public Curso() {
		super();
	}


	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", disciplina=" + disciplina +  "]";
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
	
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id ==  null ) ?  0  : id . hashCode ());;
		result = prime * result + ((nome == null)? 0 : nome.hashCode());
		result = prime * result + ((disciplina == null) ? 0:disciplina.hashCode());
		result = prime * result + ((alunos == null)? 0 : alunos.hashCode());
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
		if (id ==  null ) {
			if (other . id !=  null)
				return  false ;
		} else  if ( ! id . equals (other.id))
			return  false ;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
				if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			    return false;
			if (alunos == null) {
				if (other.alunos != null)
					return false;
			} else if (!alunos.equals(other.alunos))
				return false;					
		return true;
	}

}
