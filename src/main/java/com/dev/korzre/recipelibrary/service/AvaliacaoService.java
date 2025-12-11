package com.dev.korzre.recipelibrary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.korzre.recipelibrary.dto.request.AvaliacaoRequest;
import com.dev.korzre.recipelibrary.dto.response.AvaliacaoResponse;
import com.dev.korzre.recipelibrary.dto.response.ReceitaWithAvaliacaoResponse;
import com.dev.korzre.recipelibrary.exception.ReceitaException;
import com.dev.korzre.recipelibrary.mapper.AvaliacaoMapper;
import com.dev.korzre.recipelibrary.model.Avaliacao;
import com.dev.korzre.recipelibrary.model.Receita;
import com.dev.korzre.recipelibrary.repository.AvaliacaoRepository;
import com.dev.korzre.recipelibrary.repository.ReceitaRepository;


@Service
public class AvaliacaoService {
    
    ReceitaRepository receitaRepository;
    AvaliacaoRepository avaliacaoRepository;
    AvaliacaoMapper avaliacaoMapper;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository,
                            ReceitaRepository receitaRepository,
                            AvaliacaoMapper avaliacaoMapper
    ){
        this.avaliacaoRepository = avaliacaoRepository;
        this.receitaRepository = receitaRepository;
        this.avaliacaoMapper = avaliacaoMapper;
    }

    public void saveEvaluation(String idRecipe, AvaliacaoRequest avaliacaoRequest){
        receitaRepository.findById(idRecipe).orElseThrow(()-> new ReceitaException("Não achou a receita!"));
        
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setIdReceita(idRecipe);
        avaliacao.setComentario(avaliacaoRequest.comentario());
        avaliacao.setScore(avaliacaoRequest.score());
        avaliacao.setReviewerName(avaliacaoRequest.reviewerName());

        avaliacaoRepository.save(avaliacao);
        
    }

    public List <AvaliacaoResponse> listAllEvaluations(){
        List <Avaliacao> avaliacao = avaliacaoRepository.findAll();
        return avaliacaoMapper.toListAllEvaluations(avaliacao);
    }

    public ReceitaWithAvaliacaoResponse getAllRecipesWithEvaluations(String idRceita){
        Receita receitas = receitaRepository.findById(idRceita).orElseThrow(()->new ReceitaException("Essa receita não existe!"));
        List<Avaliacao> avalist = avaliacaoRepository.findAllByIdReceita(idRceita);

        return new ReceitaWithAvaliacaoResponse(receitas.getNome(),
                                                receitas.getNomeCategoria(),
                                                receitas.getTempoPreparo(), 
                                                receitas.getIngredientes(),
                                                receitas.getInstrucoes(), 
                                                avaliacaoMapper.toListAllEvaluations(avalist));
    }
    

    
}
