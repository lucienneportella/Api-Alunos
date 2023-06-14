package com.api.aluno.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "aluno")
@Getter
@Setter
@ToString
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100, nullable = false)
	private String nome;
	
	private int idade;
	private String turma;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "responsavel_id")
	private Responsavel responsavel;
	
	@OneToMany(mappedBy = "aluno")
	private List<Infracao> infracao;

}
