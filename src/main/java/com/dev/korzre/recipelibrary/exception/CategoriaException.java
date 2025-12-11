package com.dev.korzre.recipelibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoriaException extends RuntimeException{
    public CategoriaException(String message){
        super(message);
    }
}
