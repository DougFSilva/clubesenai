package com.dougFSilva.clubesenai.model.socio;

import java.time.LocalDate;

import com.dougFSilva.clubesenai.model.pessoa.Pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tb_socios")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
@ToString
public class Socio extends Pessoa {

	@Column(nullable = false)
	@PastOrPresent(message = "A data de associação não deve ser futura")
	private LocalDate dataAssociacao; 
}
