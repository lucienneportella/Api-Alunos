package com.api.aluno.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.api.aluno.dto.AlunoRequestDto;
import com.api.aluno.dto.AlunoResponseDto;
import com.api.aluno.service.AlunoService;

@RestController
@RequestMapping("alunos")
@Validated
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AlunoResponseDto criar(@Valid @RequestBody AlunoRequestDto alunoRequest) {
		
		return service.criar(alunoRequest);
		
	}

	
	@GetMapping("nome/{nome}")
	public List<AlunoResponseDto> buscarPorNome(@PathVariable("nome") String nome) {
		return service.buscarPorNome(nome);
	}
	
	@DeleteMapping("/id/{id}")
	public void excluir(@PathVariable("id") Long id) {
		service.excluir(id);
	}

}
