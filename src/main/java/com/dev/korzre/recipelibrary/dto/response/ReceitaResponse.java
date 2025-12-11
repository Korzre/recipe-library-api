package com.dev.korzre.recipelibrary.dto.response;


public record ReceitaResponse(
    String id,
    String nome,
    String nomeCategoria,
    int tempoPreparo,
    String ingredientes,
    String instrucoes

) {
    
}
