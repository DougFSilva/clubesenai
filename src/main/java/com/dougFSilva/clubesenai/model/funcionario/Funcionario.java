package com.dougFSilva.clubesenai.model.funcionario;

import com.dougFSilva.clubesenai.model.pessoa.Pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_funcionarios")
@Getter
@Setter
@ToString
public class Funcionario extends Pessoa{
	
	@Column(nullable = false)
	private Cargo cargo;
}
