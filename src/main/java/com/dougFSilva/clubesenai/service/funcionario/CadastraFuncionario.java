package com.dougFSilva.clubesenai.service.funcionario;

import com.dougFSilva.clubesenai.dto.form.FuncionarioForm;
import com.dougFSilva.clubesenai.model.funcionario.Funcionario;
import com.dougFSilva.clubesenai.model.pessoa.Endereco;
import com.dougFSilva.clubesenai.model.usuario.CodificadorDeSenha;
import com.dougFSilva.clubesenai.model.usuario.Perfil;
import com.dougFSilva.clubesenai.model.usuario.Usuario;
import com.dougFSilva.clubesenai.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastraFuncionario {
	
	private final UsuarioRepository usuarioRepository;
	private final CodificadorDeSenha codificador;
	
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
		String password = codificador.codificar(form.password());
		Usuario usuario = new Usuario(null, funcionario, password, new Perfil(form.perfil()));
		usuarioRepository.save(usuario);
		return funcionario.getId();
	}
	
}
