package com.dougFSilva.clubesenai.service.funcionario;

import com.dougFSilva.clubesenai.model.funcionario.Funcionario;
import com.dougFSilva.clubesenai.repository.FuncionarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeletaFuncionario {

	private final FuncionarioRepository repository;
	
	public void deletar(Long id) {
		Funcionario funcionario = repository.findByIdOrElseThrow(id);
		repository.delete(funcionario);
	}
}
