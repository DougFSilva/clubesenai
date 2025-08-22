package com.dougFSilva.clubesenai.service.acesso;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dougFSilva.clubesenai.dto.form.CadastraTagForm;
import com.dougFSilva.clubesenai.exception.ErroDeOperacaoComPessoaException;
import com.dougFSilva.clubesenai.model.pessoa.Pessoa;
import com.dougFSilva.clubesenai.repository.PessoaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastraTagService {

	private final PessoaRepository repository;
	
	@Transactional
	@PreAuthorize("hasAnyRole('ADMIN', 'FUNCIONARIO')")
	public void cadastrar(CadastraTagForm form) {
		validaTagUnica(form.tag());
		Pessoa pessoa = repository.findByIdOrElseThrow(form.pessoaId());
		pessoa.setTagAcesso(form.tag());
		repository.save(pessoa);
	}
	
	private void validaTagUnica(String tag) {
		if(repository.existsByTagAcesso(tag)) {
			throw new ErroDeOperacaoComPessoaException(String.format("Tag de acesso %s já cadastrada", tag));
		}
	}
}
