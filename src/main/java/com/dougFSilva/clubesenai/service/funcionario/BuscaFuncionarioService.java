package com.dougFSilva.clubesenai.service.funcionario;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dougFSilva.clubesenai.dto.dto.FuncionarioResponse;
import com.dougFSilva.clubesenai.model.funcionario.Cargo;
import com.dougFSilva.clubesenai.repository.FuncionarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BuscaFuncionarioService {

	private final FuncionarioRepository repository;
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public FuncionarioResponse buscarPeloId(Long id) {
		return FuncionarioResponse.deFuncionario(repository.findByIdOrElseThrow(id));
	}
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public List<FuncionarioResponse> buscarPeloNome(String nome) {
		return repository.findByNomeContainingOrderByNomeAsc(nome).stream().map(FuncionarioResponse::new).toList();
	}
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public List<FuncionarioResponse> buscarPeloCargo(Cargo cargo) {
		return repository.findByCargo(cargo).stream().map(FuncionarioResponse::new).toList();
	}
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public List<FuncionarioResponse> buscarTodos() {
		return repository.findAll().stream().map(FuncionarioResponse::new).toList();
	}
	
}
