package com.api.aluno.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.api.aluno.dto.ResponsavelRequestDto;
import com.api.aluno.dto.ResponsavelResponse;
import com.api.aluno.service.ResponsavelService;

@RestController
@RequestMapping("responsavel")
@Validated
public class ResponsavelController {
	
	@Autowired
	private ResponsavelService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponsavelResponse criar (@Valid @RequestBody ResponsavelRequestDto responsavelDto) {
		return service.criar(responsavelDto);
		
	}

}
