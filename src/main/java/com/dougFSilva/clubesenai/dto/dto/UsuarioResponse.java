package com.dougFSilva.clubesenai.dto.dto;

import com.dougFSilva.clubesenai.model.funcionario.Funcionario;
import com.dougFSilva.clubesenai.model.pessoa.Pessoa;
import com.dougFSilva.clubesenai.model.socio.Socio;
import com.dougFSilva.clubesenai.model.usuario.Perfil;
import com.dougFSilva.clubesenai.model.usuario.Usuario;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioResponse {

	private Long id;
	
	private PessoaResponse pessoa;
	
	private String perfil;
	
	public UsuarioResponse(Usuario usuario) {
		this.id = usuario.getId();
		this.perfil = usuario.getPerfil().getTipo().getNome();
		Pessoa pessoaEntidade = usuario.getPessoa();
		if (pessoaEntidade instanceof Funcionario) {
			this.pessoa = new FuncionarioResponse((Funcionario) pessoaEntidade);
		}
		else if (pessoaEntidade instanceof Socio) {
			this.pessoa = new SocioResponse((Socio) pessoaEntidade);
		}
	}
}
