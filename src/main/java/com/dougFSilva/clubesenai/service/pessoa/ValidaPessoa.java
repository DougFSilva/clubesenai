package com.dougFSilva.clubesenai.service.pessoa;

import com.dougFSilva.clubesenai.exception.ErroDeOperacaoComPessoaException;
import com.dougFSilva.clubesenai.repository.FuncionarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ValidaPessoa {
	
	private final FuncionarioRepository repository;

	public void validarUnicaMatricula(String matricula) {
		if (repository.existsByMatricula(matricula)) {
			throw new ErroDeOperacaoComPessoaException(
					"Matrícula " + matricula + " já cadastrada");
		};
	}
	
	public void validarUnicoEmail(String email) {
		if (repository.existsByEmail(email)) {
			throw new ErroDeOperacaoComPessoaException(
					"Email " + email + " já cadastrado");
		}; 
	}
	
	public void validarUnicaTag(String tag) {
		if (tag != null && repository.existsByEmail(tag)) {
			throw new ErroDeOperacaoComPessoaException(
					"Tag " + tag + " já cadastrada");
		}; 
	}
}
