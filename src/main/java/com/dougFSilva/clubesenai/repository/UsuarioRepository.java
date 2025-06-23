package com.dougFSilva.clubesenai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougFSilva.clubesenai.model.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
