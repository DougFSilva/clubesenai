package com.dougFSilva.clubesenai.service.usuario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dougFSilva.clubesenai.model.usuario.CodificadorDeSenha;
import com.dougFSilva.clubesenai.model.usuario.Perfil;
import com.dougFSilva.clubesenai.model.usuario.TipoPerfil;
import com.dougFSilva.clubesenai.model.usuario.Usuario;
import com.dougFSilva.clubesenai.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CriaUsuarioSistema {
	
	@Value("${user.sistema.senha}")
	private String senha;

	private final UsuarioRepository repository;
	private final CodificadorDeSenha codificadorDeSenha;
	
	public void criar() {
		String username = "admin@admin.com";
		if (!repository.existsByUsername(username)) {
			Usuario usuario = new Usuario(
					null, 
					codificadorDeSenha.codificar(senha), 
					senha,
					new Perfil(TipoPerfil.ADMIN));
			repository.save(usuario);
		}
	}
}
