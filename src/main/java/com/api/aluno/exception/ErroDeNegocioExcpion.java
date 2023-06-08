package com.api.aluno.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ErroDeNegocioExcpion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private final HttpStatus htpStatus;
	private final String msgErro;
	
	public ErroDeNegocioExcpion(TabelaDeErros tabela) {
		this.htpStatus = tabela.getHttpStatus();
		this.msgErro = tabela.getMensagem();
	}

}
