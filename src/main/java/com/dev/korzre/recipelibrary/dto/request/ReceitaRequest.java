package com.dev.korzre.recipelibrary.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReceitaRequest(

    @NotBlank(message = "Não pode estar em branco!")
    String nome,

    @NotBlank(message = "Não pode estar em branco!")
    String nomeCategoria,

    @NotNull(message = "O tempo de preparo é obrigatório!")
    @Min(value = 1)
    Integer tempoPreparo,

    @NotBlank(message = "Não pode estar em branco!")
    String ingredientes,

    @NotBlank(message = "Não pode estar em branco!")
    String instrucoes 

) {
    
}
