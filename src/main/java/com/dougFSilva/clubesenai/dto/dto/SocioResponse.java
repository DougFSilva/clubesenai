package com.dougFSilva.clubesenai.dto.dto;

import java.time.LocalDate;

import com.dougFSilva.clubesenai.model.socio.Socio;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SocioResponse extends PessoaResponse{

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAssociacao; 

	public SocioResponse(Socio socio) {
		this.dataAssociacao = socio.getDataAssociacao();
	}
}
