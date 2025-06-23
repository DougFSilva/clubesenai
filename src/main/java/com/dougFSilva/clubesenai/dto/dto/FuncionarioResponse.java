package com.dougFSilva.clubesenai.dto.dto;

import com.dougFSilva.clubesenai.model.funcionario.Cargo;
import com.dougFSilva.clubesenai.model.funcionario.Funcionario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FuncionarioResponse extends PessoaResponse {

	private Cargo cargo;
	
	public FuncionarioResponse(Funcionario funcionario) {
		this.cargo = funcionario.getCargo();
	}
	
}
