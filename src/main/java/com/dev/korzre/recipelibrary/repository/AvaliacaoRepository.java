package com.dev.korzre.recipelibrary.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.korzre.recipelibrary.model.Avaliacao;

@Repository
public interface AvaliacaoRepository extends MongoRepository <Avaliacao, String> {
    List<Avaliacao> findAllByIdReceita(String idReceita);
}
