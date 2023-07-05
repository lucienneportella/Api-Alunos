package com.api.aluno.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/id/{id}")
	public List<InfracaoResponse> listarPorData(@PathVariable("id")  Long id) {
		return service.listarPorAluno(id);
		
	}
}
