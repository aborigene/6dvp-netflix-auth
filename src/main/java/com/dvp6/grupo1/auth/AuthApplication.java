/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 13/04/2021
*/

package com.dvp6.grupo1.auth;

import com.dvp6.grupo1.auth.model.AuthEntity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/*
  Classe Main do projeto.
*/
@SpringBootApplication
@ComponentScan(basePackages = "com.dvp6.grupo1.auth.*")
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Bean
	public AuthEntity authEntity() {
		return new AuthEntity();
	}

}
