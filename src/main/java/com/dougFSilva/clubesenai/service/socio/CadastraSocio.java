package com.dougFSilva.clubesenai.service.socio;

import com.dougFSilva.clubesenai.dto.form.CadastraSocioForm;
import com.dougFSilva.clubesenai.model.pessoa.Endereco;
import com.dougFSilva.clubesenai.model.socio.Socio;
import com.dougFSilva.clubesenai.repository.SocioRepository;
import com.dougFSilva.clubesenai.service.pessoa.ValidaPessoa;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CadastraSocio {

	private final SocioRepository repository;
	private final ValidaPessoa validaPessoa;
	
	public Long cadastrar(CadastraSocioForm form) {
		validaPessoa.validarUnicaMatricula(form.matricula());
		validaPessoa.validarUnicoEmail(form.email());
		Endereco endereco = new Endereco(null, form.pais(), form.estado(), form.cidade(), form.rua(), form.numero());
		Socio socio = Socio.builder()
			.id(null)
			.matricula(form.matricula())
			.nome(form.nome())
			.email(form.email())
			.dataNascimento(form.dataNascimento())
			.endereco(endereco)
			.tagAcesso(null)
			.liberado(true)
			.build();
		return repository.save(socio).getId();
	}
}
