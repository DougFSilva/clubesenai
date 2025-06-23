package com.dougFSilva.clubesenai.model;

public interface CodificadorDeSenha {

	String codificar(String senha);
	
	boolean comparar(String senha, String senhaCodificada);
}
