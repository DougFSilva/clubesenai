package com.dougFSilva.clubesenai.exception;

public class AcessoNaoAutorizadoException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AcessoNaoAutorizadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public AcessoNaoAutorizadoException(String message) {
		super(message);
	}
	
}