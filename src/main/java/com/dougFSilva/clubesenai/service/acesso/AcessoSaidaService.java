package com.dougFSilva.clubesenai.service.acesso;

import java.time.LocalDateTime;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.dougFSilva.clubesenai.dto.dto.PessoaResponse;
import com.dougFSilva.clubesenai.exception.AcessoNaoAutorizadoException;
import com.dougFSilva.clubesenai.model.acesso.Acesso;
import com.dougFSilva.clubesenai.model.pessoa.Pessoa;
import com.dougFSilva.clubesenai.model.pessoa.StatusAcesso;
import com.dougFSilva.clubesenai.repository.PessoaRepository;
import com.dougFSilva.clubesenai.repository.AcessoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AcessoSaidaService {

	private final AcessoRepository repository;
	private final PessoaRepository pessoaRepository;
	private final SimpMessagingTemplate websocket;
	
	@Transactional
	public void acessar(String tag) {
		Pessoa pessoa = pessoaRepository.findByTagAcesso(tag).orElseThrow(() -> 
			new AcessoNaoAutorizadoException(String.format("Pessoa com tag %s não encontrada", tag)));
		validaTentativaDeAcesso(pessoa);
		Acesso registro = new Acesso(null, pessoa, LocalDateTime.now());
		repository.save(registro);
		pessoa.setStatusAcesso(StatusAcesso.FORA_DO_CLUBE);
		pessoaRepository.save(pessoa);
		websocket.convertAndSend("/topic/acesso", PessoaResponse.dePessoa(pessoa));

	}
	
	private void validaTentativaDeAcesso(Pessoa pessoa) {
		if (pessoa.getStatusAcesso() == StatusAcesso.FORA_DO_CLUBE) {
			throw new AcessoNaoAutorizadoException(
					String.format("Pessoa %s já está fora do clube", pessoa.getNome()));
		}
	}	
}
