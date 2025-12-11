package com.dev.korzre.recipelibrary.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dev.korzre.recipelibrary.dto.request.ReceitaRequest;
import com.dev.korzre.recipelibrary.dto.response.ReceitaResponse;
import com.dev.korzre.recipelibrary.model.Receita;

@Component
public class ReceitaMapper {
    
    public Receita toReceitaModel(ReceitaRequest dto){
        if (dto == null) return null;

        Receita receita = new Receita();
        receita.setNome(dto.nome());
        receita.setNomeCategoria(dto.nomeCategoria());
        receita.setTempoPreparo(dto.tempoPreparo());
        receita.setInstrucoes(dto.instrucoes());
        receita.setIngredientes(dto.ingredientes());

        return receita;
    }

    public ReceitaResponse toReceitaResponseDTO(Receita receita){
        if (receita == null) return null;

        return new ReceitaResponse(
            receita.getId(),
            receita.getNome(), 
            receita.getNomeCategoria(), 
            receita.getTempoPreparo(), 
            receita.getIngredientes(), 
            receita.getInstrucoes());
    }

    public List<ReceitaResponse> toReceitaResponseList(List<Receita> receitas){
        if (receitas == null) return null;

        return receitas.stream()
                .map(this::toReceitaResponseDTO)
                .toList();
    }
    
}
