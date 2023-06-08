package com.api.aluno.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TabelaDeErros {
	
	ERRO_DE_VALIDACAO(HttpStatus.BAD_REQUEST, "Dados de requisição inválidos"),
	ALUNO_NAO_ENCONTRADO(HttpStatus.NOT_FOUND, "aluno não encontrado"),
	RESPONSAVEL_NAO_ENCONTRADO(HttpStatus.NOT_FOUND, "responsavl nao encontrado");
	
	
	
	private final HttpStatus httpStatus;
	private final String mensagem;
	

}
