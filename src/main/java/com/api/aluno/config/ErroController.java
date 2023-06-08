package com.api.aluno.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.aluno.dto.ErroDto;
import com.api.aluno.exception.ErroDeNegocioExcpion;

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

}
