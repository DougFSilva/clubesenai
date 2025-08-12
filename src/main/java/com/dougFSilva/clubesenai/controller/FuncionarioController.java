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

import com.dougFSilva.clubesenai.dto.dto.FuncionarioResponse;
import com.dougFSilva.clubesenai.dto.form.CadastraFuncionarioForm;
import com.dougFSilva.clubesenai.dto.form.EditaFuncionarioForm;
import com.dougFSilva.clubesenai.model.funcionario.Cargo;
import com.dougFSilva.clubesenai.service.funcionario.BuscaFuncionarioService;
import com.dougFSilva.clubesenai.service.funcionario.CadastraFuncionarioService;
import com.dougFSilva.clubesenai.service.funcionario.DeletaFuncionarioService;
import com.dougFSilva.clubesenai.service.funcionario.EditaFuncionarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

	private final CadastraFuncionarioService cadastraFuncionarioService;
	private final DeletaFuncionarioService deletaFuncionarioService;
	private final EditaFuncionarioService editaFuncionarioService;
	private final BuscaFuncionarioService buscaFuncionarioService;
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@Valid @RequestBody CadastraFuncionarioForm form) {
		Long id = cadastraFuncionarioService.cadastrar(form);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		deletaFuncionarioService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FuncionarioResponse> editar(@PathVariable Long id, @Valid @RequestBody EditaFuncionarioForm form) {
		FuncionarioResponse funcionario = editaFuncionarioService.editar(id, form);
		return ResponseEntity.ok().body(funcionario);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioResponse> buscarPeloId(@PathVariable Long id) {
		FuncionarioResponse funcionario = buscaFuncionarioService.buscarPeloId(id);
		return ResponseEntity.ok().body(funcionario);
	}
	
	@GetMapping("/nome/{id}")
	public ResponseEntity<List<FuncionarioResponse>> buscarPeloNome(@PathVariable String nome) {
		List<FuncionarioResponse> funcionarios = buscaFuncionarioService.buscarPeloNome(nome);
		return ResponseEntity.ok().body(funcionarios);
	}
	
	@GetMapping("/cargo/{cargo}")
	public ResponseEntity<List<FuncionarioResponse>> buscarPeloCargo(@PathVariable Cargo cargo) {
		List<FuncionarioResponse> funcionarios = buscaFuncionarioService.buscarPeloCargo(cargo);
		return ResponseEntity.ok().body(funcionarios);
	}
	
	@GetMapping
	public ResponseEntity<List<FuncionarioResponse>> buscarTodos() {
		List<FuncionarioResponse> funcionarios = buscaFuncionarioService.buscarTodos();
		return ResponseEntity.ok().body(funcionarios);
	}
}
