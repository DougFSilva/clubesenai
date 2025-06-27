package com.dougFSilva.clubesenai.service.funcionario;

import java.util.List;

import com.dougFSilva.clubesenai.dto.dto.FuncionarioResponse;
import com.dougFSilva.clubesenai.repository.FuncionarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscaFuncionario {

	private final FuncionarioRepository repository;
	
	public FuncionarioResponse buscarPeloId(Long id) {
		return FuncionarioResponse.deFuncionario(repository.findByIdOrElseThrow(id));
	}
	
	public List<FuncionarioResponse> buscarPeloNome(String nome) {
		return repository.findByNomeContaining(nome).stream().map(FuncionarioResponse::new).toList();
	}
	
	public List<FuncionarioResponse> buscarTodos() {
		return repository.findAll().stream().map(FuncionarioResponse::new).toList();
	}
	
}
