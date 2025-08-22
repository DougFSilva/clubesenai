package com.dougFSilva.clubesenai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dougFSilva.clubesenai.config.TokenService;
import com.dougFSilva.clubesenai.dto.dto.TokenResponse;
import com.dougFSilva.clubesenai.dto.form.LoginForm;
import com.dougFSilva.clubesenai.exception.ErroDeAutenticacaoDeUsuarioException;
import com.dougFSilva.clubesenai.model.usuario.Usuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticação", description = "Endpoints para autenticação de usuário")
public class AutenticacaoController {

	private final AuthenticationManager authenticationManager;
	private final TokenService tokenService;
	
	@PostMapping
    @Operation(
    		summary = "Autenticar usuário", 
    		description = "Autentica o usuário e retorna um token JWT para acesso às demais funcionalidades da API."
    )
	public ResponseEntity<TokenResponse> autenticar(@Valid @RequestBody LoginForm form){
		try {
			UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(form.email(), form.senha());
			Authentication authentication = authenticationManager.authenticate(login);
			Usuario usuario = (Usuario) authentication.getPrincipal();
			String token = tokenService.gerarToken(usuario);
			TokenResponse tokenResponse = new TokenResponse(token, "Bearer ");
			return ResponseEntity.ok().body(tokenResponse);
		} catch (AuthenticationException e) {
			throw new ErroDeAutenticacaoDeUsuarioException("Usuário ou senha inválidos", e);
		}	
	}
}
