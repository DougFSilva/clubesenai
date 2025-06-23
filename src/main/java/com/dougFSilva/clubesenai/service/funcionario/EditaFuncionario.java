package com.dougFSilva.clubesenai.service.funcionario;

import com.dougFSilva.clubesenai.dto.form.FuncionarioForm;
import com.dougFSilva.clubesenai.model.usuario.Perfil;
import com.dougFSilva.clubesenai.model.usuario.Usuario;
import com.dougFSilva.clubesenai.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditaFuncionario {

	private final UsuarioRepository usuarioRepository;
	
	public Long editar(Long id, FuncionarioForm form) {
		Usuario usuario = usuarioRepository.findByIdOrElseThrow(id);
		usuario.setPerfil(new Perfil(form.perfil()));
		usuario.getPessoa().setMatricula(form.matricula());
		usuario.getPessoa().setNome(form.nome());
		usuario.getPessoa().setEmail(form.email());
		usuario.getPessoa().setDataNascimento(form.dataNascimento());
		usuario.getPessoa().getEndereco().setPais(form.pais());
		usuario.getPessoa().getEndereco().setEstado(form.estado());
		usuario.getPessoa().getEndereco().setCidade(form.cidade());
		usuario.getPessoa().getEndereco().setRua(form.rua());
		usuario.getPessoa().getEndereco().setNumero(form.numero());
		return usuarioRepository.save(usuario).getId();
	}
}
