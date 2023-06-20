package com.api.aluno.dto;

import java.time.LocalDate;

import com.api.aluno.model.EnumInfracao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InfracaoResponse {
	
	
	private EnumInfracao tipoInfracao;
	private String descricao;
	private LocalDate data = LocalDate.now();
	private AlunoResponseDto aluno;

}
