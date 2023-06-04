package com.api.aluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.aluno.dto.AlunoRequestDto;
import com.api.aluno.dto.AlunoResponseDto;
import com.api.aluno.service.AlunoService;

@RestController
@RequestMapping("alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	

	
	
	@PostMapping
	public AlunoResponseDto criar(@RequestBody AlunoRequestDto alunoRequest) {
		
		return service.criar(alunoRequest);
		
	}

}
