package com.dev.korzre.recipelibrary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.korzre.recipelibrary.model.Categoria;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String>{
    boolean existsByNomeCategoria(String nomeCategoria);
}
