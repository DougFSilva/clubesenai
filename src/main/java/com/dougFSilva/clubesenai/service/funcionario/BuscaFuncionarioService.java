package com.dougFSilva.clubesenai.service.funcionario;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dougFSilva.clubesenai.dto.dto.FuncionarioResponse;
import com.dougFSilva.clubesenai.model.funcionario.Cargo;
import com.dougFSilva.clubesenai.repository.FuncionarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BuscaFuncionarioService {

	private final FuncionarioRepository repository;
	
	public FuncionarioResponse buscarPeloId(Long id) {
		return FuncionarioResponse.deFuncionario(repository.findByIdOrElseThrow(id));
	}
	
	public List<FuncionarioResponse> buscarPeloNome(String nome) {
		return repository.findByNomeContaining(nome).stream().map(FuncionarioResponse::new).toList();
	}
	
	public List<FuncionarioResponse> buscarPeloCargo(Cargo cargo) {
		return repository.findByCargo(cargo).stream().map(FuncionarioResponse::new).toList();
	}
	
	public List<FuncionarioResponse> buscarTodos() {
		return repository.findAll().stream().map(FuncionarioResponse::new).toList();
	}
	
}
