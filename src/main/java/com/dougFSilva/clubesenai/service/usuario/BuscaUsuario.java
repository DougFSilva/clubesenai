package com.dougFSilva.clubesenai.service.usuario;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dougFSilva.clubesenai.dto.dto.UsuarioResponse;
import com.dougFSilva.clubesenai.exception.ObjetoNaoEncontradoException;
import com.dougFSilva.clubesenai.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscaUsuario implements UserDetailsService{

	private final UsuarioRepository repository;
	
	public UsuarioResponse buscarPeloId(Long id) {
		return new UsuarioResponse(repository.findByIdOrElseThrow(id));
	}
	
	public List<UsuarioResponse> buscarTodos() {
		return repository.findAll().stream().map(UsuarioResponse::new).toList();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByUsername(username).orElseThrow(() -> 
			new ObjetoNaoEncontradoException("Usuário com username " + username + " não encontrado!"));
	}
}
