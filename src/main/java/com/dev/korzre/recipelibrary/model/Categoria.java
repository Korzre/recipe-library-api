package com.dev.korzre.recipelibrary.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "categoria")
public class Categoria {
    @Id
    private String idCategoria;
    private String nomeCategoria;
}
