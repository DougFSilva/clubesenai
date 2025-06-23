package com.dougFSilva.clubesenai.dto.dto;

import java.time.LocalDate;

import com.dougFSilva.clubesenai.model.funcionario.Cargo;
import com.dougFSilva.clubesenai.model.usuario.TipoPerfil;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FuncionarioForm(
		
		@NotBlank(message = "O campo matrícula deve ser preenchido")
		String matricula,
		
		@NotBlank(message = "O campo nome deve ser preenchido")
		String nome,
		
		@NotBlank(message = "O campo email deve ser preenchido")
		String email,
		
		LocalDate dataNascimento,
		
		@NotBlank(message = "O campo senha deve ser preenchido")
		String password,
		
		@NotNull(message = "O campo perfil deve ser preenchido")
		TipoPerfil perfil,
		
		@NotBlank(message = "O campo cargo deve ser preenchido")
		Cargo cargo,
		
		@NotBlank(message = "O campo país deve ser preenchido")
		String pais,
		
		@NotBlank(message = "O campo estado deve ser preenchido")
		String estado,
		
		@NotBlank(message = "O campo cidade deve ser preenchido")
		String cidade,
		
		@NotBlank(message = "O campo rua deve ser preenchido")
		String rua,
		
		@NotBlank(message = "O campo numero deve ser preenchido")
		String numero
		
		) {

}
