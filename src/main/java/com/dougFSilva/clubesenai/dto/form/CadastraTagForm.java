package com.dougFSilva.clubesenai.dto.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastraTagForm(
		
		@NotNull(message = "O campo id da pessoa deve ser preenchido")
		Long pessoaId,
		
		@NotBlank(message = "O campo tag deve ser preenchido")
		String tag
		
		) {

}
