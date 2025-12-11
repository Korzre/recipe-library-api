package com.dev.korzre.recipelibrary.dto.response;

import java.util.List;

public record ReceitaWithAvaliacaoResponse(
    String nome,
    String nomeCategoria,
    int tempoPreparo,
    String ingredientes,
    String instrucoes,
    List <AvaliacaoResponse> avaliacaoResponse
) {
} 