package com.dougFSilva.clubesenai.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dougFSilva.clubesenai.model.usuario.CodificadorDeSenha;

@Service
public class CodigicadorBcrypt implements CodificadorDeSenha {

	private final PasswordEncoder passwordEncoder;

	public CodigicadorBcrypt() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public String codificar(String senha) {
		return passwordEncoder.encode(senha);
	}

	@Override
	public boolean comparar(String senha, String senhaCodificada) {
		return passwordEncoder.matches(senha, senhaCodificada);
	}

}
