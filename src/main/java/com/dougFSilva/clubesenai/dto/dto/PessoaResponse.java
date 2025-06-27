package com.dougFSilva.clubesenai.dto.dto;

import java.time.LocalDate;

import com.dougFSilva.clubesenai.model.pessoa.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class PessoaResponse {
	
	private Long id;
	private String matricula;
	private String nome;
	private String email;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	private Endereco endereco;
	private String tagAcesso;
	private boolean liberado;
}
