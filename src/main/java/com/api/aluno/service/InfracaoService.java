package com.api.aluno.service;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.aluno.dto.InfracaoRequest;
import com.api.aluno.dto.InfracaoResponse;
import com.api.aluno.model.Aluno;
import com.api.aluno.model.Infracao;
import com.api.aluno.repository.AlunoRepository;
import com.api.aluno.repository.InfracaoRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
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
			 //aluno nao encontrado
			 log.info("CAIU AQ");
		 }
		 
		 Aluno alunoBanco = optional.get();
		 infracao.setAluno(alunoBanco);
		 
		 repository.save(infracao);
		 return mapper.map(infracao, InfracaoResponse.class);
		 
	 }
	 
	 //BUSCAR INFRAÇÃO POR ALUNO
	 public List<InfracaoResponse> listarPorAluno(Long id) {
		 Optional<Aluno> optional = alunoRepository.findById(id);
		 if (!optional.isPresent()) {
			 //aluno não encontrado
		 }
		 
		 Aluno alunoBusca = optional.get();
		 List<Infracao> listaInfracao = repository.findByAluno(alunoBusca);
		 List<InfracaoResponse> infracaoDto = mapper.map(listaInfracao, new TypeToken<List<InfracaoResponse>>(){}.getType());
		 return infracaoDto;
		 
		 
	 }

}
