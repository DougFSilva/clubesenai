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
		super(
				funcionario.getId(), 
				funcionario.getMatricula(), 
				funcionario.getNome(), 
				funcionario.getEmail(), 
				funcionario.getDataNascimento(), 
				funcionario.getEndereco(), 
				funcionario.getTagAcesso(), 
				funcionario.isLiberado()
				);
		this.cargo = funcionario.getCargo();
	}
	
	public static FuncionarioResponse deFuncionario(Funcionario funcionario) {
		return new FuncionarioResponse(funcionario);
	}
	
}
