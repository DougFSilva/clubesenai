package com.dougFSilva.clubesenai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougFSilva.clubesenai.exception.ObjetoNaoEncontradoException;
import com.dougFSilva.clubesenai.model.pessoa.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	default Pessoa findByIdOrElseThrow(Long id) {
		return findById(id).orElseThrow(() -> 
			new ObjetoNaoEncontradoException("Pessoa com id " + id + " não encontrada!"));
	}
	
	Optional<Pessoa> findByTagAcesso(String tag);

	boolean existsByMatricula(String matricula);

	boolean existsByEmail(String email);

	boolean existsByTagAcesso(String tagAcesso);
}
