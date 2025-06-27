package com.dougFSilva.clubesenai.service.funcionario;

import com.dougFSilva.clubesenai.dto.form.CadastraFuncionarioForm;
import com.dougFSilva.clubesenai.model.funcionario.Funcionario;
import com.dougFSilva.clubesenai.model.pessoa.Endereco;
import com.dougFSilva.clubesenai.model.usuario.CodificadorDeSenha;
import com.dougFSilva.clubesenai.model.usuario.Perfil;
import com.dougFSilva.clubesenai.model.usuario.Usuario;
import com.dougFSilva.clubesenai.repository.FuncionarioRepository;
import com.dougFSilva.clubesenai.service.pessoa.ValidaPessoa;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastraFuncionario {
	
	private final FuncionarioRepository repository;
	private final ValidaPessoa validaPessoa;
	private final CodificadorDeSenha codificador;
	
	public Long cadastrar(CadastraFuncionarioForm form) {
		validaPessoa.validarUnicaMatricula(form.matricula());
		validaPessoa.validarUnicoEmail(form.email());
		Endereco endereco = new Endereco(null, form.pais(), form.estado(), form.cidade(), form.rua(), form.numero());
		String password = codificador.codificar(form.password());
		Usuario usuario = new Usuario(null, form.email(), password, new Perfil(form.perfil()));
		Funcionario funcionario = Funcionario.builder()
			.id(null)
			.matricula(form.matricula())
			.usuario(usuario)
			.nome(form.nome())
			.email(form.email())
			.dataNascimento(form.dataNascimento())
			.endereco(endereco)
			.tagAcesso(null)
			.liberado(false)
			.build();
		return repository.save(funcionario).getId();
	}
	
}
