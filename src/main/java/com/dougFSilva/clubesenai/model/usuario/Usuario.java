package com.dougFSilva.clubesenai.model.usuario;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dougFSilva.clubesenai.model.pessoa.Pessoa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_usuarios")
@NoArgsConstructor
@Data
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne 
	@JoinColumn(name = "pessoa_id", unique = true, nullable = false)
	private Pessoa pessoa;
	
	@Column(nullable = false)
	private String password;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "perfil_id", nullable = false)
	private Perfil perfil;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    return this.perfil != null ? Collections.singletonList(this.perfil) : Collections.emptyList();
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.pessoa.getEmail();
	}
}
