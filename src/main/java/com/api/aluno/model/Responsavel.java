package com.api.aluno.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "responsavel")
@Getter
@Setter
@ToString

public class Responsavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String telefone;
	@OneToMany(mappedBy = "responsavel")
	private List<Aluno> alunos;

}
