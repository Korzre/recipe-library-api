package com.dev.korzre.recipelibrary.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dev.korzre.recipelibrary.dto.response.AvaliacaoResponse;
import com.dev.korzre.recipelibrary.model.Avaliacao;

@Component
public class AvaliacaoMapper {

    public AvaliacaoResponse avaliacaoResponseDTO (Avaliacao avaliacaoModel){
        if (avaliacaoModel == null ) return null;
        return new AvaliacaoResponse(
            avaliacaoModel.getReviewerName(),
            avaliacaoModel.getScore(),
            avaliacaoModel.getComentario(),
            avaliacaoModel.getDate()
        );
    }

    public List<AvaliacaoResponse> toListAllEvaluations(List<Avaliacao> avaliacaoM){
        if (avaliacaoM == null) return null;

        return avaliacaoM.stream()
                         .map(this::avaliacaoResponseDTO)
                         .toList();
         
    }
}
