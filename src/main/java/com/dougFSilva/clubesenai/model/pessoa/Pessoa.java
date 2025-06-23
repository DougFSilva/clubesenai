package com.dougFSilva.clubesenai.model.pessoa;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Data
public abstract class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String matricula;
	
	@Column(nullable = false)
	private String nome;
	
	@Email(message = "Email inválido")
	private String email;
	
	private LocalDate dataNascimento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	private String tagAcesso;
	
	private boolean liberado;
	
}
