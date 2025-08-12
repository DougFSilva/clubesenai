package com.dougFSilva.clubesenai.service.socio;

import org.springframework.stereotype.Service;

import com.dougFSilva.clubesenai.model.socio.Socio;
import com.dougFSilva.clubesenai.repository.SocioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeletaSocioService {

	private final SocioRepository repository;
	
	public void deletar(Long id) {
		Socio socio = repository.findByIdOrElseThrow(id);
		repository.delete(socio);
	}
	
}
