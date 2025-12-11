package com.dev.korzre.recipelibrary.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "receitas")
public class Receita {
    @Id
    private String id;
    private String nome;
    private String nomeCategoria;
    private int tempoPreparo;
    private String ingredientes;
    private String instrucoes;
}
