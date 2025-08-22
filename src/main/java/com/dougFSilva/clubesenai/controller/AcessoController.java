package com.dougFSilva.clubesenai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dougFSilva.clubesenai.service.acesso.AcessoEntradaService;
import com.dougFSilva.clubesenai.service.acesso.AcessoSaidaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/acesso")
@RequiredArgsConstructor
public class AcessoController {

	private final AcessoEntradaService acessoEntradaService;
	private final AcessoSaidaService acessoSaidaService;
	
	@PostMapping("/entrada/{pessoaId}")
	public ResponseEntity<Void> entrarNoClube(@PathVariable Long pessoaId) {
		acessoEntradaService.acessar(pessoaId);
		return ResponseEntity.ok().body(null);
	}
	
	@PostMapping("/saida/{pessoaId}")
	public ResponseEntity<Void> sairrDoClube(@PathVariable Long pessoaId) {
		acessoSaidaService.acessar(pessoaId);
		return ResponseEntity.ok().body(null);
	}
	
}
