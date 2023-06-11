package com.api.aluno.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.aluno.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	List<Aluno> findByNome(String nome);

}
