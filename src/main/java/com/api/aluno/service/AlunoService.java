package com.api.aluno.service;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.aluno.dto.AlterarAlunoDto;
import com.api.aluno.dto.AlunoRequestDto;
import com.api.aluno.dto.AlunoResponseDto;
import com.api.aluno.exception.ErroDeNegocioExcpion;
import com.api.aluno.exception.TabelaDeErros;
import com.api.aluno.model.Aluno;
import com.api.aluno.repository.AlunoRepository;


@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private ModelMapper mapper;
	
	//nao posso excluir ou alterar um aluno que já possui um relacionamento com a tabela infração

	
	public AlunoResponseDto criar(AlunoRequestDto alunoRequest) {
		
		Aluno aluno = mapper.map(alunoRequest, Aluno.class);
		Aluno alunoBanco = aluno;
		alunoRepository.save(alunoBanco);
		return mapper.map(alunoBanco, AlunoResponseDto.class);
		
	}
	

	public AlunoResponseDto altualizarDados(Long id, AlterarAlunoDto alunoDto) {
		Optional<Aluno> optional = alunoRepository.findById(id);
		
		if(!optional.isPresent()) {
			//lança excessao
		}
		
		Aluno aluno = optional.get();
		Aluno alunoAlterar =  mapper.map(alunoDto, Aluno.class);
		
		aluno.setTurma(alunoAlterar.getTurma());
		aluno.setEmail_responsavel(alunoAlterar.getEmail_responsavel());
		
		alunoRepository.save(aluno);
		
		return mapper.map(aluno, AlunoResponseDto.class);
	}
	
	public List<AlunoResponseDto> buscarPorNome(String nome) {
		List<Aluno> alunos = alunoRepository.findByNome(nome);
		List<AlunoResponseDto> alunoResponse = mapper.map(alunos, new TypeToken<List<AlunoResponseDto>>(){}.getType());
		return alunoResponse;
		
		
	}
	
	public void excluir(Long id) {
		
		 Optional<Aluno> op = alunoRepository.findById(id);
		 
		 if(!op.isPresent()) {
			 throw new ErroDeNegocioExcpion(TabelaDeErros.ALUNO_NAO_ENCONTRADO);
		 }
		alunoRepository.deleteById(id);

		
	}
	
	

}
