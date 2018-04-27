package com.examplebr.edu.ifal.academia.academiatiweb.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor extends Pessoa{

	@Column(length = 8, name =" matricula_professor", nullable = false)
	private String matricula;
	
	@Column()
	@Enumerated(EnumType.STRING)
	private Tipo_professor tipo_professor = Tipo_professor.efetivo;
	
	public Professor(String id, String matricula, String nome, Tipo_professor tipo_professor) {
		super();
		super.setId(id);
		this.matricula = matricula;
		this.setNome(nome);
		this.tipo_professor = tipo_professor;
	}
	
	public Professor(String id, String matricula, String nome) {
		super();
		super.setId(id);
		this.matricula = matricula;
		this.setNome(nome);
		this.tipo_professor = Tipo_professor.efetivo;
	}
	
	
	public Professor() {
		super();
		
	}
	
	@Override
	public String toString() {
		return "Professor [Id=" + super.getId() + ", matricula=" + matricula + ", nome=" + this.getNome() + "]";
	}
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Tipo_professor getTipo_professor() {
		return tipo_professor;
	}

	public void setTipo_professor(Tipo_professor tipo_professor) {
		this.tipo_professor = tipo_professor;
	}
}
