package com.examplebr.edu.ifal.academia.academiatiweb.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

public class Nota {
	
	private Integer id;
	
	@OneToMany
	private Aluno aluno;
	
	@ManyToMany
	private Disciplina disciplina;
	
	private double valor;
	
	@ElementCollection
	private List<Double> notas = new ArrayList<>();

	public Nota() {
		super();
	}
	
	public Nota(Integer id, Aluno aluno, Disciplina disciplina, double valor) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	 @ElementCollection
		@CollectionTable(name = "nota_alunos")
		@Column(name = "valor_notas", length = 4, nullable = false)
		public List<Double> getNots() {
		return notas;
		}
		public void setNotas(List<Double> notas) {
		this.notas = notas;
 }
}		
