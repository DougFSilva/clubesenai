package com.dougFSilva.clubesenai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougFSilva.clubesenai.exception.ObjetoNaoEncontradoException;
import com.dougFSilva.clubesenai.model.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	default Usuario findByIdOrElseThrow(Long id) {
		return findById(id).orElseThrow(() -> 
			new ObjetoNaoEncontradoException("Usuario com id " + id + " não encontrado!"));
	}
	
	Optional<Usuario> findByUsername(String username);
	
}
