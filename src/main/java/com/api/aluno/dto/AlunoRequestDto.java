package com.api.aluno.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlunoRequestDto {
	
	private String nome;
	private int idade;
	private String turma;
	private Long id_responsavel;

}
