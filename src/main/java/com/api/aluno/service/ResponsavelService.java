package com.api.aluno.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.aluno.dto.ResponsavelRequestDto;
import com.api.aluno.dto.ResponsavelResponse;
import com.api.aluno.model.Responsavel;
import com.api.aluno.repository.ResponsavelRepository;

@Service
public class ResponsavelService {
	
	@Autowired
	private ResponsavelRepository responsavelRepository;
	@Autowired
	private ModelMapper mapper;
	
	
	public ResponsavelResponse criar(ResponsavelRequestDto responsavelDto) {
		Responsavel responsavel = mapper.map(responsavelDto, Responsavel.class);
		responsavelRepository.save(responsavel);
		return mapper.map(responsavel, ResponsavelResponse.class);
		
		
	}
	
	

}
