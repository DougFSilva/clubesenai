package com.dougFSilva.clubesenai.service.socio;

import com.dougFSilva.clubesenai.model.socio.Socio;
import com.dougFSilva.clubesenai.repository.SocioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeletaSocio {

	private final SocioRepository repository;
	
	public void deletar(Long id) {
		Socio socio = repository.findByIdOrElseThrow(id);
		repository.delete(socio);
	}
	
}
