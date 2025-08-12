package com.dougFSilva.clubesenai.service.funcionario;

import org.springframework.stereotype.Service;

import com.dougFSilva.clubesenai.model.funcionario.Funcionario;
import com.dougFSilva.clubesenai.repository.FuncionarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeletaFuncionarioService {

	private final FuncionarioRepository repository;
	
	public void deletar(Long id) {
		Funcionario funcionario = repository.findByIdOrElseThrow(id);
		repository.delete(funcionario);
	}
}
