package com.dougFSilva.clubesenai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougFSilva.clubesenai.exception.ObjetoNaoEncontradoException;
import com.dougFSilva.clubesenai.model.socio.Socio;

public interface SocioRepository extends JpaRepository<Socio, Long> {

	default Socio findByIdOrElseThrow(Long id) {
		return findById(id).orElseThrow(() -> 
			new ObjetoNaoEncontradoException("Sócio com id " + id + " não encontrado!"));
	}
	
	List<Socio>findByNomeContainingOrderByNomeAsc(String nome);
}
