package com.api.aluno.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "alunos")
@Getter
@Setter
@ToString
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int idade;
	private String turma;
	@ManyToOne
	@JoinColumn(name = "id_responsavel")
	private Responsavel responsavel;
	
	@OneToMany(mappedBy = "alunos")
	private List<Infracao> infracao;

}
