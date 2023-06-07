package com.api.aluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("id/{id}")
	public AlunoResponseDto buscarAluno(@PathVariable("id") Long id) {
		return service.buscarAluno(id);
		
	}
	
	@DeleteMapping("/id/{id}")
	public void excluir(@PathVariable("id") Long id) {
		service.excluir(id);
	}

}
