package com.dougFSilva.clubesenai.service.pessoa;

import org.springframework.stereotype.Service;

import com.dougFSilva.clubesenai.exception.ErroDeOperacaoComPessoaException;
import com.dougFSilva.clubesenai.repository.PessoaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ValidaPessoaService {
	
	private final PessoaRepository repository;

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
