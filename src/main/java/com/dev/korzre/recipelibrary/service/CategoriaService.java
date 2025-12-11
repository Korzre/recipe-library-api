package com.dev.korzre.recipelibrary.service;

import org.springframework.stereotype.Service;

import com.dev.korzre.recipelibrary.dto.request.CategoriaRequest;
import com.dev.korzre.recipelibrary.mapper.CategoriaMapper;
import com.dev.korzre.recipelibrary.model.Categoria;
import com.dev.korzre.recipelibrary.repository.CategoriaRepository;
import java.util.List;
import com.dev.korzre.recipelibrary.dto.response.CategoriaResponse;

@Service
public class CategoriaService {
    
    CategoriaRepository categoriaRepository;
    CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper){
        this.categoriaRepository =  categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public void saveCategory(CategoriaRequest categoriaRequest){
        Categoria categoria = new Categoria();
        categoria = categoriaMapper.toCategoriaModel(categoriaRequest);
        if(categoriaRepository.existsByNomeCategoria(categoriaRequest.nomeCategoria()) == false){
            categoriaRepository.save(categoria);
        }

    }


    public List<CategoriaResponse> getAllCategories(){
        List <Categoria> categoria = categoriaRepository.findAll();
        return categoriaMapper.toListCategoriaResponseDTO(categoria);
    }
}
