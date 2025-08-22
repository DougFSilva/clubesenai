package com.dougFSilva.clubesenai;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dougFSilva.clubesenai.service.usuario.CriaUsuarioSistema;

@SpringBootApplication
public class ClubesenaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClubesenaiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(CriaUsuarioSistema criaUsuarioAdminDefault) {
	    return args -> {
	      criaUsuarioAdminDefault.criar();
	    };
	}

}
