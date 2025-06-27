package com.dougFSilva.clubesenai.service.socio;

import com.dougFSilva.clubesenai.dto.form.EditaSocioForm;
import com.dougFSilva.clubesenai.model.socio.Socio;
import com.dougFSilva.clubesenai.repository.SocioRepository;
import com.dougFSilva.clubesenai.service.pessoa.ValidaPessoa;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditaSocio {

	private final SocioRepository repository;
	private final ValidaPessoa validaPessoa;
	
	public Long editar(Long id, EditaSocioForm form) {
		Socio socio = repository.findByIdOrElseThrow(id);
		if (form.matricula() != socio.getMatricula()) {
			validaPessoa.validarUnicaMatricula(form.matricula());
			socio.setMatricula(form.matricula());
		}
		socio.setNome(form.nome());
		if (form.email() != socio.getEmail()) {
			validaPessoa.validarUnicoEmail(form.email());
			socio.setEmail(form.email());
		}
		socio.setDataNascimento(form.dataNascimento());
		socio.setDataAssociacao(form.dataAssociacao());
		socio.getEndereco().setPais(form.pais());
		socio.getEndereco().setEstado(form.estado());
		socio.getEndereco().setCidade(form.cidade());
		socio.getEndereco().setRua(form.rua());
		socio.getEndereco().setNumero(form.numero());
		return repository.save(socio).getId();
	}
}
