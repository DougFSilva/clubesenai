package com.dougFSilva.clubesenai.service.socio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dougFSilva.clubesenai.dto.dto.SocioResponse;
import com.dougFSilva.clubesenai.repository.SocioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BuscaSocioService {

	private final SocioRepository repository;
	
	public SocioResponse buscarPeloId(Long id) {
		return SocioResponse.deSocio(repository.findByIdOrElseThrow(id));
	}
	
	public List<SocioResponse> buscarPeloNome(String nome) {
		return repository.findByNomeContainingOrderByNomeAsc(nome).stream().map(SocioResponse::new).toList();
	} 
	
	public List<SocioResponse> buscarTodos() {
		return repository.findAll().stream().map(SocioResponse::new).toList();
	}
}
