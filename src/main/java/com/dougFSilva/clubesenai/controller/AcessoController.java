package com.dougFSilva.clubesenai.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dougFSilva.clubesenai.dto.form.CadastraTagForm;
import com.dougFSilva.clubesenai.service.acesso.AcessoEntradaService;
import com.dougFSilva.clubesenai.service.acesso.AcessoSaidaService;
import com.dougFSilva.clubesenai.service.acesso.CadastraTagService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/acessos")
@RequiredArgsConstructor
@Tag(name = "Acessos", description = "Endpoints para gerenciamento do acesso de pessoas no clube")
public class AcessoController {

	private final AcessoEntradaService acessoEntradaService;
	private final AcessoSaidaService acessoSaidaService;
	private final CadastraTagService cadastraTagService;
	
	@PostMapping("/entrada/{tag}")
	@Operation(summary = "Entrar no clube", description = "Permite e registra a entrada de uma pessoa no clube")
	public ResponseEntity<Void> entrarNoClube(@PathVariable String tag) {
		acessoEntradaService.acessar(tag);
		return ResponseEntity.ok().body(null);
	}
	
	@PostMapping("/saida/{tag}")
	@Operation(summary = "Entrar no clube", description = "Permite e registra a entrada de uma pessoa no clube")
	public ResponseEntity<Void> sairrDoClube(@PathVariable String tag) {
		acessoSaidaService.acessar(tag);
		return ResponseEntity.ok().body(null);
	}
	
	@PatchMapping("/cadastrar-tag")
	@Operation(summary = "Cadastrar tag", description = "Cadastra uma nova tag para a pessoa")
	public ResponseEntity<Void> cadastrarTag(@Valid @RequestBody CadastraTagForm form){
		cadastraTagService.cadastrar(form);
		return ResponseEntity.ok().build();
	}
	
}
