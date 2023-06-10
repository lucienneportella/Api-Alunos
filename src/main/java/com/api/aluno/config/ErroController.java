package com.api.aluno.config;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.aluno.dto.ErroDto;
import com.api.aluno.exception.ErroDeNegocioExcpion;
import com.api.aluno.exception.TabelaDeErros;

@RestControllerAdvice
public class ErroController {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(ErroDeNegocioExcpion.class)
	@ResponseBody
	public ResponseEntity<ErroDto> handle(ErroDeNegocioExcpion e) {
		ErroDto erroDto = new ErroDto();
		erroDto.setErro(e.getMsgErro());
		
		return ResponseEntity.status(e.getHtpStatus()).body(erroDto);
	}
	
	//validação dos campos
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public ResponseEntity<ErroDto> handle(BindException exception) {
		List<String> validacoes = new ArrayList<>();
		
		for (FieldError error : exception.getBindingResult().getFieldErrors()) {
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			validacoes.add(error.getField() + ": " + mensagem);
			
		}
		
		TabelaDeErros tabela = TabelaDeErros.ERRO_DE_VALIDACAO;
		ErroDto erroDto = new ErroDto();
		erroDto.setErro(tabela.getMensagem());
		erroDto.setValidacao(validacoes);
		
		return ResponseEntity.status(tabela.getHttpStatus()).body(erroDto);
	}

}
