package com.dougFSilva.clubesenai.model.funcionario;

import com.dougFSilva.clubesenai.model.pessoa.Pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tb_funcionarios")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public class Funcionario extends Pessoa{
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Cargo cargo;

}
