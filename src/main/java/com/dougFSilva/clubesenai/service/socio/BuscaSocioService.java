package com.dougFSilva.clubesenai.service.socio;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dougFSilva.clubesenai.dto.dto.SocioResponse;
import com.dougFSilva.clubesenai.repository.SocioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BuscaSocioService {

	private final SocioRepository repository;
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public SocioResponse buscarPeloId(Long id) {
		return SocioResponse.deSocio(repository.findByIdOrElseThrow(id));
	}
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public List<SocioResponse> buscarPeloNome(String nome) {
		return repository.findByNomeContainingIgnoreCaseOrderByNomeAsc(nome).stream().map(SocioResponse::new).toList();
	} 
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public List<SocioResponse> buscarTodos() {
		return repository.findAll().stream().map(SocioResponse::new).toList();
	}
}
