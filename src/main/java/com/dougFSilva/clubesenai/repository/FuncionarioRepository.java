package com.dougFSilva.clubesenai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougFSilva.clubesenai.exception.ObjetoNaoEncontradoException;
import com.dougFSilva.clubesenai.model.funcionario.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	default Funcionario findByIdOrElseThrow(Long id) {
		return findById(id).orElseThrow(() -> 
			new ObjetoNaoEncontradoException("Funcionário com id " + id + " não encontrado!"));
	}
	
	List<Funcionario> findByNomeContaining(String nome);
	
	boolean existsByMatricula(String matricula);
	
	boolean existsByEmail(String email);
	
	boolean existsByTagAcesso(String tagAcesso);
}
