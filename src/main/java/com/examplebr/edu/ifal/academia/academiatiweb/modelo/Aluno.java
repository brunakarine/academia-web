package com.examplebr.edu.ifal.academia.academiatiweb.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno extends Pessoa{
	
	
	@Column(unique = true, name = "matricula_aluno", nullable = false)
	private String matricula;
	
	@ManyToMany
	private Set<Disciplina> disciplinas = new HashSet<>();
	
	@Embedded
	private Endereco endereco;
	
	@ElementCollection
	@CollectionTable(name = "telefone_aluno",
	joinColumns = @JoinColumn(name = "id_aluno"))
	@Column(length = 12 , name = "numero_aluno", nullable = false)
	private java.util.List<String> telefones = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_aluno")
	private TIPO_ALUNO tipoAluno = TIPO_ALUNO.BOLSISTA_ASSISTENCIA;
	
	public Aluno(String id, String matricula, String nome, Set<Disciplina> disciplinas, Endereco endereco,List<String>telefones){
		
		super.setId(id);
		this.matricula = matricula;
		this.setNome(nome);
		this.disciplinas = disciplinas;
		this.endereco = endereco;
		this.telefones = telefones;
	}
	

	public Aluno() {
		super();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public TIPO_ALUNO getTipoAluno() {
		return tipoAluno;
	}

	public void setTipoAluno(TIPO_ALUNO tipoAluno) {
		this.tipoAluno = tipoAluno;
	}
	public java.util.List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(java.util.List<String> telefones) {
		this.telefones = telefones;
	}

}
