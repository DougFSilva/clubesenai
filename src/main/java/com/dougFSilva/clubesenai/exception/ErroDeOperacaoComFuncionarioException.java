package com.dougFSilva.clubesenai.exception;

public class ErroDeOperacaoComFuncionarioException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ErroDeOperacaoComFuncionarioException(String message, Throwable cause) {
		super(message, cause);
	}

	public ErroDeOperacaoComFuncionarioException(String message) {
		super(message);
	}
	
}