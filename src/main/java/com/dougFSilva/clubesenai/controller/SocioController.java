package com.dougFSilva.clubesenai.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dougFSilva.clubesenai.dto.dto.SocioResponse;
import com.dougFSilva.clubesenai.dto.form.CadastraSocioForm;
import com.dougFSilva.clubesenai.dto.form.EditaSocioForm;
import com.dougFSilva.clubesenai.service.socio.BuscaSocioService;
import com.dougFSilva.clubesenai.service.socio.CadastraSocioService;
import com.dougFSilva.clubesenai.service.socio.DeletaSocioService;
import com.dougFSilva.clubesenai.service.socio.EditaSocioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class SocioController {

	private final CadastraSocioService cadastraSocioService;
	private final DeletaSocioService deletaSocioService;
	private final EditaSocioService editaSocioService;
	private final BuscaSocioService buscaSocioService;
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@Valid @RequestBody CadastraSocioForm form) {
		Long id = cadastraSocioService.cadastrar(form);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		deletaSocioService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SocioResponse> editar(@PathVariable Long id, @Valid @RequestBody EditaSocioForm form) {
		SocioResponse socio = editaSocioService.editar(id, form);
		return ResponseEntity.ok().body(socio);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SocioResponse> buscarPeloId(@PathVariable Long id) {
		SocioResponse socio = buscaSocioService.buscarPeloId(id);
		return ResponseEntity.ok().body(socio);
	}
	
	@GetMapping("/nome/{id}")
	public ResponseEntity<List<SocioResponse>> buscarPeloNome(@PathVariable String nome) {
		List<SocioResponse> socios = buscaSocioService.buscarPeloNome(nome);
		return ResponseEntity.ok().body(socios);
	}
	
	@GetMapping
	public ResponseEntity<List<SocioResponse>> buscarTodos() {
		List<SocioResponse> socios = buscaSocioService.buscarTodos();
		return ResponseEntity.ok().body(socios);
	}
}
