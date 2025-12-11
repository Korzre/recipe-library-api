package com.dev.korzre.recipelibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import io.github.cdimascio.dotenv.Dotenv;

@EnableMongoAuditing
@SpringBootApplication
public class RecipelibraryApplication {

	public static void main(String[] args) {	
		try {
			Dotenv dotenv = Dotenv.load();
			dotenv.entries().forEach(entry->System.setProperty(entry.getKey(), entry.getValue()));
		} catch (Exception e) {
			System.out.println("Variáveis .env não encontradas!");
		}			
		SpringApplication.run(RecipelibraryApplication.class, args);
	}

}
