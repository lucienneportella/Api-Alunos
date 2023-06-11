package com.api.aluno.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.aluno.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	Optional<Aluno> findByNome(String nome);

}
