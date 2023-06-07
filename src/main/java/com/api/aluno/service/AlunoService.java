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
		
		Optional<Responsavel> op = responsavelRepository.findById(alunoRequest.getId_responsavel());
		

		Responsavel responsavel = op.get();
		
		
		alunoBanco.setResponsavel(responsavel);
		alunoRepository.save(alunoBanco);
		
		return mapper.map(alunoBanco, AlunoResponseDto.class);
		
	}
	
	public AlunoResponseDto pegarUmAluno(Long id) {
		
		Optional<Aluno> op = alunoRepository.findById(id);
		Aluno alunoBanco = op.get();
		
		alunoRepository.save(alunoBanco);
		
		return mapper.map(alunoBanco, AlunoResponseDto.class);
		
	}
	
	public void excluir(Long id) {
		alunoRepository.deleteById(id);
		
	}
	
	

}
