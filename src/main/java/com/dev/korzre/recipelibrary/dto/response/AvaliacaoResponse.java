package com.dev.korzre.recipelibrary.dto.response;

import java.time.Instant;

public record AvaliacaoResponse(
    String reviewerName,
    int score,
    String comentario,
    Instant date
) {
    
}
