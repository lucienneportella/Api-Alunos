package com.api.aluno.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlunoResponseDto {
	
	private Long id;
	private String nome;
	private int idade;
	private String turma;
	
	private ResponsavelResponse responsavel;

}
