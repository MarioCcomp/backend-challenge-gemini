package com.backend.gemini.desafio_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DesafioBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioBackendApplication.class, args);
	}

}
