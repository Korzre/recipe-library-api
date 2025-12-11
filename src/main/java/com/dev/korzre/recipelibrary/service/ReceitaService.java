package com.dev.korzre.recipelibrary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.korzre.recipelibrary.dto.request.ReceitaRequest;
import com.dev.korzre.recipelibrary.dto.response.ReceitaResponse;
import com.dev.korzre.recipelibrary.exception.ReceitaException;
import com.dev.korzre.recipelibrary.mapper.ReceitaMapper;
import com.dev.korzre.recipelibrary.model.Receita;
import com.dev.korzre.recipelibrary.repository.CategoriaRepository;
import com.dev.korzre.recipelibrary.repository.ReceitaRepository;

@Service
public class ReceitaService {
    CategoriaRepository categoriaRepository;
    ReceitaRepository receitaRepository;
    ReceitaMapper receitaMapper;

    public ReceitaService(CategoriaRepository categoriaRepository,
                          ReceitaRepository receitaRepository,
                          ReceitaMapper receitaMapper

    ){
        this.categoriaRepository = categoriaRepository;
        this.receitaMapper = receitaMapper;
        this.receitaRepository = receitaRepository;
    }

    public void saveRecipe(ReceitaRequest receitaRequest){
        Receita receita = new Receita();
        receita=receitaMapper.toReceitaModel(receitaRequest);

        if (receitaRepository.existsByNome(receitaRequest.nome()) == false) {
            if(categoriaRepository.existsByNomeCategoria(receitaRequest.nomeCategoria())){
                receitaRepository.save(receita);
            }else{
                throw new ReceitaException("Essa categoria não existe!");
            }
        }else{
            throw new ReceitaException("Essa receita já existe!");
        }
        
    }

    public List<ReceitaResponse> listAllRecipes(){
        List <Receita> receitas = receitaRepository.findAll();
        return receitaMapper.toReceitaResponseList(receitas);
    }
}
