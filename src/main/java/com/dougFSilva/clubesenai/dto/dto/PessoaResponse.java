package com.dougFSilva.clubesenai.dto.dto;

import java.time.LocalDate;

import com.dougFSilva.clubesenai.model.pessoa.Endereco;
import com.dougFSilva.clubesenai.model.pessoa.Pessoa;
import com.dougFSilva.clubesenai.model.pessoa.StatusAcesso;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PessoaResponse {

	private Long id;
	private String matricula;
	private String nome;
	private String email;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	private Endereco endereco;
	private String tagAcesso;
	private boolean liberado;
	private StatusAcesso statusAcesso;

	public static PessoaResponse dePessoa(Pessoa pessoa) {
		return new PessoaResponse(
				pessoa.getId(),
				pessoa.getMatricula(), 
				pessoa.getNome(), 
				pessoa.getEmail(),
				pessoa.getDataNascimento(), 
				pessoa.getEndereco(), 
				pessoa.getTagAcesso(), 
				pessoa.isLiberado(),
				pessoa.getStatusAcesso());
	}
}
