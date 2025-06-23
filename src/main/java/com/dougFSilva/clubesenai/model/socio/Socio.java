package com.dougFSilva.clubesenai.model.socio;

import java.time.LocalDate;

import com.dougFSilva.clubesenai.model.pessoa.Pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_socios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Socio extends Pessoa {

	private LocalDate dataAssociacao; 
}
