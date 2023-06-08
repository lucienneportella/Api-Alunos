package com.api.aluno.service;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.aluno.dto.AlunoRequestDto;
import com.api.aluno.dto.AlunoResponseDto;
import com.api.aluno.exception.ErroDeNegocioExcpion;
import com.api.aluno.exception.TabelaDeErros;
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
		
		if(!op.isPresent()) {
			throw new ErroDeNegocioExcpion(TabelaDeErros.RESPONSAVEL_NAO_ENCONTRADO);
		}
	
		Responsavel responsavel = op.get();
		alunoBanco.setResponsavel(responsavel);
		alunoRepository.save(alunoBanco);
		
		return mapper.map(alunoBanco, AlunoResponseDto.class);
		
	}
	
	public AlunoResponseDto buscarAluno(Long id) {
		
		Optional<Aluno> op = alunoRepository.findById(id);
		
		if(!op.isPresent()) {
			throw new ErroDeNegocioExcpion(TabelaDeErros.ALUNO_NAO_ENCONTRADO);
		}
		
		Aluno alunoBanco = op.get();
		alunoRepository.save(alunoBanco);
		
		return mapper.map(alunoBanco, AlunoResponseDto.class);
		
	}
	
	public void excluir(Long id) {
		
		 Optional<Aluno> op = alunoRepository.findById(id);
		 
		 if(!op.isPresent()) {
			 throw new ErroDeNegocioExcpion(TabelaDeErros.ALUNO_NAO_ENCONTRADO);
		 }
		alunoRepository.deleteById(id);

		
	}
	
	

}
