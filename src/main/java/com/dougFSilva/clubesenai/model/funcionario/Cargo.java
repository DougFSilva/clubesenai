package com.dougFSilva.clubesenai.model.funcionario;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Cargo {

	RECEPCIONISTA("Recepcionista"),
	SEGURANCA("Segurança"),
	GERENTE("Gerente");
	
	private String descricao;
	
	Cargo(String descricao) {
		this.descricao = descricao;
	}
}
