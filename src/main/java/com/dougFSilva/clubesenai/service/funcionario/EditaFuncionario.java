package com.dougFSilva.clubesenai.service.funcionario;

import com.dougFSilva.clubesenai.dto.form.EditaFuncionarioForm;
import com.dougFSilva.clubesenai.model.funcionario.Funcionario;
import com.dougFSilva.clubesenai.model.usuario.Perfil;
import com.dougFSilva.clubesenai.repository.FuncionarioRepository;
import com.dougFSilva.clubesenai.service.pessoa.ValidaPessoa;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditaFuncionario {

	private final FuncionarioRepository repository;
	private final ValidaPessoa validaPessoa;
	
	public Long editar(Long id, EditaFuncionarioForm form) {
		Funcionario funcionario = repository.findByIdOrElseThrow(id);
		if (form.matricula() != funcionario.getMatricula()) {
			validaPessoa.validarUnicaMatricula(form.matricula());
			funcionario.setMatricula(form.matricula());
		}
		funcionario.setNome(form.nome());
		if (form.email() != funcionario.getEmail()) {
			validaPessoa.validarUnicoEmail(form.email());
			funcionario.setEmail(form.email());
			funcionario.getUsuario().setUsername(form.email());
		}
		funcionario.setDataNascimento(form.dataNascimento());
		funcionario.getUsuario().setPerfil(new Perfil(form.perfil()));
		funcionario.setCargo(form.cargo());
		funcionario.getEndereco().setPais(form.pais());
		funcionario.getEndereco().setEstado(form.estado());
		funcionario.getEndereco().setCidade(form.cidade());
		funcionario.getEndereco().setRua(form.rua());
		funcionario.getEndereco().setNumero(form.numero());
		return repository.save(funcionario).getId();
	}
}
