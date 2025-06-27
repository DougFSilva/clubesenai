package com.dougFSilva.clubesenai.dto.form;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record EditaSocioForm(
		
		@NotBlank(message = "O campo matrícula deve ser preenchido")
		String matricula,
		
		@NotBlank(message = "O campo nome deve ser preenchido")
		String nome,
		
		@NotBlank(message = "O campo email deve ser preenchido")
		@Email(message = "O email deve ser válido")
		String email,
		
		@Past(message = "A data de nascimento não pode ser futura")
		LocalDate dataNascimento,
		
		@NotBlank(message = "O campo país deve ser preenchido")
		String pais,
		
		@NotBlank(message = "O campo estado deve ser preenchido")
		String estado,
		
		@NotBlank(message = "O campo cidade deve ser preenchido")
		String cidade,
		
		@NotBlank(message = "O campo rua deve ser preenchido")
		String rua,
		
		@NotBlank(message = "O campo numero deve ser preenchido")
		String numero,
		
		@NotNull(message = "O campo data de associação deve ser preenchido")
		LocalDate dataAssociacao
		
		) {

}
