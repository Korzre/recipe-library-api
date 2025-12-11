package com.dev.korzre.recipelibrary.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequest(
    @NotBlank(message = "Não pode estar em branco!")
    String nomeCategoria
) {
    
}
