package com.dougFSilva.clubesenai.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dougFSilva.clubesenai.exception.ErroDeAutenticacaoDeUsuarioException;
import com.dougFSilva.clubesenai.model.usuario.Usuario;
import com.dougFSilva.clubesenai.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutenticacaoService implements UserDetailsService  {

	private final UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
		return usuario.orElseThrow(() -> new ErroDeAutenticacaoDeUsuarioException(
				"Usuario com username % " + username + " não encontrado"));
	}
}
