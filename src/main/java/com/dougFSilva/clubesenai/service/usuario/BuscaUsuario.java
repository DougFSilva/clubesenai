package com.dougFSilva.clubesenai.service.usuario;

import java.util.List;

import com.dougFSilva.clubesenai.dto.dto.UsuarioResponse;
import com.dougFSilva.clubesenai.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscaUsuario {

	private final UsuarioRepository repository;
	
	public UsuarioResponse buscarPeloId(Long id) {
		return new UsuarioResponse(repository.findByIdOrElseThrow(id));
	}
	
	public List<UsuarioResponse> buscarPeloNomeContem(String nome) {
		return repository.findByPessoa_nomeContaining(nome).stream().map(UsuarioResponse::new).toList();
	}
	
	public List<UsuarioResponse> buscarTodos() {
		return repository.findAll().stream().map(UsuarioResponse::new).toList();
	}
}
