package com.api.aluno.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AlunoRequestDto {
	
	@NotEmpty(message = "nome é obrigatório")
	@Size(min = 2, max = 50, message = "nome deve estar entre 2 e 200 caracteres")
	private String nome;
	@Min(value = 12, message = "o valor minímo é 12")
	@Max(value = 18, message = "o valor máximo é 18")
	private int idade;
	private String turma;
	@Min(value = 1, message = "o id nao pode ser menor que 1")
	private Long id_responsavel;

}
