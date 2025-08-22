package com.dougFSilva.clubesenai.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.dougFSilva.clubesenai.dto.dto.ErroResponse;
import com.dougFSilva.clubesenai.exception.AcessoNaoAutorizadoException;
import com.dougFSilva.clubesenai.exception.ErroDeAutenticacaoDeUsuarioException;
import com.dougFSilva.clubesenai.exception.ErroDeOperacaoComFuncionarioException;
import com.dougFSilva.clubesenai.exception.ErroDeOperacaoComPessoaException;
import com.dougFSilva.clubesenai.exception.ObjetoNaoEncontradoException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(ErroDeOperacaoComPessoaException.class)
	public ResponseEntity<ErroResponse> erroDeOperacaoComPessoaException(ErroDeOperacaoComPessoaException e, 
			HttpServletRequest request) {
		ErroResponse erro = new ErroResponse(
				LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), 
				e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(ErroDeOperacaoComFuncionarioException.class)
	public ResponseEntity<ErroResponse> erroDeOperacaoComFuncionarioException(ErroDeOperacaoComFuncionarioException e, 
			HttpServletRequest request) {
		ErroResponse erro = new ErroResponse(
				LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), 
				e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<ErroResponse> objetoNaoEncontradoException(
			ObjetoNaoEncontradoException e,
			HttpServletRequest request) {
		ErroResponse erro = new ErroResponse(
				LocalDateTime.now(), 
				HttpStatus.NOT_FOUND.value(), 
				e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(ErroDeAutenticacaoDeUsuarioException.class)
	public ResponseEntity<ErroResponse> erroDeAutenticacaoDeUsuarioException(
			ErroDeAutenticacaoDeUsuarioException e,
			HttpServletRequest request) {
		ErroResponse erro = new ErroResponse(
				LocalDateTime.now(), 
				HttpStatus.UNAUTHORIZED.value(), 
				e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(erro);
	}
	
	@ExceptionHandler(AcessoNaoAutorizadoException.class)
	public ResponseEntity<ErroResponse> acessoNaoAutorizadoException(
			AcessoNaoAutorizadoException e,
			HttpServletRequest request) {
		ErroResponse erro = new ErroResponse(
				LocalDateTime.now(), 
				HttpStatus.UNAUTHORIZED.value(), 
				e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(erro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroResponse> methodArgumentNotValidException(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		 StringBuilder erros = new StringBuilder();

		    e.getBindingResult().getAllErrors().forEach(error -> {
		        String msg = error.getDefaultMessage();
		        erros.append(msg).append(" ");
		    });
		ErroResponse erro = new ErroResponse(
				LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), 
				erros.toString(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErroResponse> illegalArgumentException(IllegalArgumentException e,
			HttpServletRequest request) {
		ErroResponse erro = new ErroResponse(
				LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), 
				e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErroResponse> methodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException e,
			HttpServletRequest request) {
		ErroResponse erro = new ErroResponse(
				LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), 
				e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ErroResponse> badCredentialsException(BadCredentialsException e,
			HttpServletRequest request) {
		ErroResponse erro = new ErroResponse(
				LocalDateTime.now(), 
				HttpStatus.UNAUTHORIZED.value(), 
				e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(erro);
	}
	
	@ExceptionHandler(AuthorizationDeniedException.class)
	public ResponseEntity<ErroResponse> authorizationDeniedException(AuthorizationDeniedException e,
			HttpServletRequest request) {
		ErroResponse erro = new ErroResponse(
				LocalDateTime.now(), 
				HttpStatus.FORBIDDEN.value(), 
				"Acesso negado, você não tem permissão para realizar essa operação",
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(erro);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErroResponse> exception(Exception e,
			HttpServletRequest request) {
		ErroResponse erro = new ErroResponse(
				LocalDateTime.now(), 
				HttpStatus.INTERNAL_SERVER_ERROR.value(), 
				"Erro inesperado: " + e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
	}
	
}
