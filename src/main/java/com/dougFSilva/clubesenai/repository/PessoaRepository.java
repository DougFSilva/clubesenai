package com.dougFSilva.clubesenai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougFSilva.clubesenai.model.pessoa.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	boolean existsByMatricula(String matricula);

	boolean existsByEmail(String email);

	boolean existsByTagAcesso(String tagAcesso);
}
