package com.dev.korzre.recipelibrary.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.korzre.recipelibrary.dto.request.AvaliacaoRequest;
import com.dev.korzre.recipelibrary.dto.response.AvaliacaoResponse;
import com.dev.korzre.recipelibrary.service.AvaliacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/recipe")
public class AvaliacaoController {

    AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService){
        this.avaliacaoService = avaliacaoService;
    }
    
    @PostMapping("evaluation/{idReceita}")
    public ResponseEntity<AvaliacaoRequest> saveEvaluation(@Valid @RequestBody AvaliacaoRequest avaliacaoRequest, @PathVariable String idReceita){
       avaliacaoService.saveEvaluation(idReceita, avaliacaoRequest);
       return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoRequest);
    }

    @GetMapping("evaluations")
    public ResponseEntity<List<AvaliacaoResponse>> getAllEvaluations(){
        return ResponseEntity.ok(avaliacaoService.listAllEvaluations());
    }

    @GetMapping("evaluations/{idReceita}")
    public ResponseEntity<?> getRecipesWithEvaluations(@Valid @PathVariable String idReceita){
        return ResponseEntity.ok(avaliacaoService.getAllRecipesWithEvaluations(idReceita));
    }
    

}
