package com.dougFSilva.clubesenai.dto.dto;

import com.dougFSilva.clubesenai.model.usuario.TipoPerfil;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioResponse {

	private Long id;
	private String username;
	private String password;
	private TipoPerfil perfil;

}
