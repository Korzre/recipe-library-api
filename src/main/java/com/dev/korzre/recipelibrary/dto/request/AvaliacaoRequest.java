package com.dev.korzre.recipelibrary.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AvaliacaoRequest(

    @NotBlank(message = "Não pode estar em branco!")
    String reviewerName,

    @NotNull(message = "Score é obrigatóro!")
    @Max(value = 5, message = "O máximo só pode ser 5")
    @Min(value = 1, message = "O mínimo só pode ser 1")
    Integer score,

    @NotBlank(message = "Não pode estar em branco!")
    String comentario

) {
    
}
