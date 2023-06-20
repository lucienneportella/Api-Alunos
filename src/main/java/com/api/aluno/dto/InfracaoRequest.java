package com.api.aluno.dto;

import com.api.aluno.model.EnumInfracao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InfracaoRequest {
	
	private EnumInfracao tipoInfracao;
	private String descricao;
	private Long idAluno;

}
