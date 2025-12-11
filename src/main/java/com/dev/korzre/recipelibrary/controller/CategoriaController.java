package com.dev.korzre.recipelibrary.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.korzre.recipelibrary.dto.request.CategoriaRequest;
import com.dev.korzre.recipelibrary.dto.response.CategoriaResponse;
import com.dev.korzre.recipelibrary.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/recipe/categoria")
public class CategoriaController {

    CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }
    
    @PostMapping("")
    public ResponseEntity<CategoriaRequest> saveCategory(@Valid @RequestBody CategoriaRequest categoriaRequest){
       categoriaService.saveCategory(categoriaRequest);
       return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRequest);
    }
        
    @GetMapping("/lista")
    public ResponseEntity<List<CategoriaResponse>> getAllCategories(){
        return ResponseEntity.ok(categoriaService.getAllCategories());
    }
}
