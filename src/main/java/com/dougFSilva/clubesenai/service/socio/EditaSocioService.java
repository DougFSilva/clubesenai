package com.dougFSilva.clubesenai.service.socio;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dougFSilva.clubesenai.dto.dto.SocioResponse;
import com.dougFSilva.clubesenai.dto.form.EditaSocioForm;
import com.dougFSilva.clubesenai.model.socio.Socio;
import com.dougFSilva.clubesenai.repository.SocioRepository;
import com.dougFSilva.clubesenai.service.pessoa.ValidaPessoaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditaSocioService {

	private final SocioRepository repository;
	private final ValidaPessoaService validaPessoa;
	
	@Transactional
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public SocioResponse editar(Long id, EditaSocioForm form) {
		Socio socio = repository.findByIdOrElseThrow(id);
		if (!form.matricula().equals(socio.getMatricula())) {
			validaPessoa.validarUnicaMatricula(form.matricula());
			socio.setMatricula(form.matricula());
		}
		socio.setNome(form.nome());
		if (!form.email().equals(socio.getEmail())) {
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
		return SocioResponse.deSocio(repository.save(socio));
	}
}
