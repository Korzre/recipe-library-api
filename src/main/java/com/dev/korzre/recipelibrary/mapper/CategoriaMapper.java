package com.dev.korzre.recipelibrary.mapper;

import java.util.List;


import org.springframework.stereotype.Component;

import com.dev.korzre.recipelibrary.dto.request.CategoriaRequest;
import com.dev.korzre.recipelibrary.dto.response.CategoriaResponse;
import com.dev.korzre.recipelibrary.model.Categoria;

@Component
public class CategoriaMapper {
    
    public Categoria toCategoriaModel(CategoriaRequest dto){
        if(dto == null) return null;

        Categoria categoria = new Categoria();
        categoria.setNomeCategoria(dto.nomeCategoria());

        return categoria;
    }

    public CategoriaResponse toCategoriaResponseDTO(Categoria categoriaModel){
        if (categoriaModel == null) return null;

        return new CategoriaResponse(
            categoriaModel.getNomeCategoria()
        );
    }

     public List<CategoriaResponse> toListCategoriaResponseDTO(List<Categoria> categoriaModel){
        if(categoriaModel == null) return null;

        return categoriaModel.stream()
                            .map(this::toCategoriaResponseDTO)
                            .toList();
    }

   
}
