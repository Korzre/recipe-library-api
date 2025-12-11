package com.dev.korzre.recipelibrary.model;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "avaliacao")
public class Avaliacao {
    @Id
    private String id;
    private String reviewerName;
    private int score;
    private String comentario;

    @CreatedDate
    private Instant date;

    private String idReceita;
}
