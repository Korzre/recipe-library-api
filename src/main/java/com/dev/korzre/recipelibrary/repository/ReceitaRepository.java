package com.dev.korzre.recipelibrary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.korzre.recipelibrary.model.Receita;

@Repository
public interface ReceitaRepository extends MongoRepository<Receita, String> {
    boolean existsByNome(String nome);
}
