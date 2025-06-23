package com.dougFSilva.clubesenai.service;

import com.dougFSilva.clubesenai.dto.dto.FuncionarioForm;
import com.dougFSilva.clubesenai.model.funcionario.Funcionario;
import com.dougFSilva.clubesenai.model.pessoa.Endereco;
import com.dougFSilva.clubesenai.model.usuario.Perfil;
import com.dougFSilva.clubesenai.model.usuario.Usuario;
import com.dougFSilva.clubesenai.repository.FuncionarioRepository;
import com.dougFSilva.clubesenai.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastrarFuncionario {
	
	private final FuncionarioRepository funcionarioRepository;
	private final UsuarioRepository usuarioRepository;
	
	public Long cadastrar(FuncionarioForm form) {
		Endereco endereco = new Endereco(null, form.pais(), form.estado(), form.cidade(), form.rua(), form.numero());
		Funcionario funcionario = Funcionario.builder()
			.id(null)
			.matricula(form.matricula())
			.nome(form.nome())
			.email(form.email())
			.dataNascimento(form.dataNascimento())
			.endereco(endereco)
			.tagAcesso(null)
			.liberado(true)
			.build();
		Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
		Usuario usuario = new Usuario(null, funcionarioSalvo, form.password(), new Perfil(form.perfil()));
		usuarioRepository.save(usuario);
		return funcionarioSalvo.getId();
	}
	
}
