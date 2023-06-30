package com.api.aluno.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlterarAlunoDto {
	
	private String turma;
	private String email_responsavel;

}
