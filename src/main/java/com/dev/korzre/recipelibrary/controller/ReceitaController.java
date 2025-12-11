package com.dev.korzre.recipelibrary.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.korzre.recipelibrary.dto.request.ReceitaRequest;
import com.dev.korzre.recipelibrary.dto.response.ReceitaResponse;
import com.dev.korzre.recipelibrary.service.ReceitaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/recipe")
public class ReceitaController {
    
    ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService){
        this.receitaService = receitaService;
    }

    @PostMapping("")
    public ResponseEntity<ReceitaRequest> saveRecipe(@Valid @RequestBody ReceitaRequest receitaRequest){
        receitaService.saveRecipe(receitaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(receitaRequest);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ReceitaResponse>> listAllRecipes(){
        return ResponseEntity.ok(receitaService.listAllRecipes());
    }
    
}
