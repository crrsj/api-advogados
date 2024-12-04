package br.com.advocacia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "API - Sistema para advogados.",
			version = "1.0",
			description = "Documentando uma API para um sistema de suporte para advogados.",
			contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
	)
public class ApiAdvocaciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAdvocaciaApplication.class, args);
	}

}
