package com.api.aluno.dto;

import java.util.List;

import com.api.aluno.model.Aluno;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponsavelResponse {
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private Aluno aluno_id;

}
