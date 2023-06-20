package com.api.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.aluno.model.Infracao;

public interface InfracaoRepository extends JpaRepository<Infracao, Long> {

}
