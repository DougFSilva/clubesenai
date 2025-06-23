package com.dougFSilva.clubesenai.model.usuario;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_perfis")
@NoArgsConstructor
@Data
public class Perfil implements GrantedAuthority{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoPerfil tipo;
	
	public Perfil(TipoPerfil tipo) {
		this.tipo = tipo;
	}

	@Override
	public String getAuthority() {
		return tipo.getDescricao();
	}
}
