package com.dougFSilva.clubesenai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dougFSilva.clubesenai.model.funcionario.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
