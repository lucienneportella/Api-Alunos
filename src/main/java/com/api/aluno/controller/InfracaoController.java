package com.api.aluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.aluno.dto.InfracaoRequest;
import com.api.aluno.dto.InfracaoResponse;
import com.api.aluno.service.InfracaoService;

@RestController
@RequestMapping("infracao")
public class InfracaoController {
	
	@Autowired
	private InfracaoService service;
	
	
	@PostMapping
	public InfracaoResponse criar(@RequestBody InfracaoRequest infracaoRequest) {
		return service.criar(infracaoRequest);
	}
}
