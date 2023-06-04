package com.api.aluno.service;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.aluno.dto.AlunoRequestDto;
import com.api.aluno.dto.AlunoResponseDto;
import com.api.aluno.model.Aluno;
import com.api.aluno.model.Responsavel;
import com.api.aluno.repository.AlunoRepository;
import com.api.aluno.repository.ResponsavelRepository;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ResponsavelRepository responsavelRepository;
	
	@Autowired
	private ModelMapper mapper;
	

	
	public AlunoResponseDto criar(AlunoRequestDto alunoRequest) {
		
		Aluno aluno = mapper.map(alunoRequest, Aluno.class);
		Aluno alunoBanco = aluno;
		
		log.info("RESPONSÁVEL: {}", alunoRequest.getId_responsavel());
		Optional<Responsavel> op = responsavelRepository.findById(alunoRequest.getId_responsavel());
		

		Responsavel responsavel = op.get();
		
		
		alunoBanco.setResponsavel(responsavel);
		alunoRepository.save(alunoBanco);
		
		return mapper.map(alunoBanco, AlunoResponseDto.class);
		
	}
	
	
	

}
