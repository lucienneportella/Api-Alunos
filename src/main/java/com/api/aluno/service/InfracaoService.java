package com.api.aluno.service;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.aluno.dto.InfracaoRequest;
import com.api.aluno.dto.InfracaoResponse;
import com.api.aluno.model.Aluno;
import com.api.aluno.model.Infracao;
import com.api.aluno.repository.AlunoRepository;
import com.api.aluno.repository.InfracaoRepository;

@Service
public class InfracaoService {
	
	@Autowired
	private InfracaoRepository repository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	 public InfracaoResponse criar(InfracaoRequest infracaoRequest) {
		 Infracao infracao = mapper.map(infracaoRequest, Infracao.class);
		 
		
		 
		 Optional<Aluno> optional = alunoRepository.findById(infracaoRequest.getIdAluno());
		 
		 if (!optional.isPresent()) {
			 //
		 }
		 
		 Aluno alunoBanco = optional.get();
		 
		 infracao.setAluno(alunoBanco);
		 
		 //Infracao infracaoBanco = infracao;
		 
		 repository.save(infracao);
		 
		 return mapper.map(infracao, InfracaoResponse.class);
		 
	 }

}
