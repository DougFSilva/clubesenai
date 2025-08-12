package com.dougFSilva.clubesenai.dto.dto;

import java.time.LocalDate;

import com.dougFSilva.clubesenai.model.socio.Socio;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SocioResponse extends PessoaResponse {

	private LocalDate dataAssociacao;

	public SocioResponse(Socio socio) {
		super(
				socio.getId(), 
				socio.getMatricula(), 
				socio.getNome(), 
				socio.getEmail(), 
				socio.getDataNascimento(), 
				socio.getEndereco(), 
				socio.getTagAcesso(), 
				socio.isLiberado()
				);
		this.dataAssociacao = socio.getDataAssociacao();
	}
	
	public static SocioResponse deSocio(Socio socio) {
		return new SocioResponse(socio);
	}
	
}
