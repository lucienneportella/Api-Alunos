package com.api.aluno.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.aluno.model.Aluno;
import com.api.aluno.model.Infracao;

public interface InfracaoRepository extends JpaRepository<Infracao, Long> {
	
	List<Infracao>  findByAluno(Aluno aluno);

}
