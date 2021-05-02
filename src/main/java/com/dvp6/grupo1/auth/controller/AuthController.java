/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 13/04/2021
*/

package com.dvp6.grupo1.auth.controller;

import com.dvp6.grupo1.auth.security.JwtGenerator;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
  Classe responsável por expor as APIs.
*/
@RestController
public class AuthController {

  /*
   * Criando a rota / com o verbo GET.
   */
  @GetMapping("/")
  public ResponseEntity<String> home() {
    return new ResponseEntity<>("Ok!", HttpStatus.OK);
  }

  /*
   * Criando a rota /login com o verbo GET. Responsável por receber o usuário e
   * senha e retornar um token jwt para o usuário.
   */
  @GetMapping("/login")
  public String login() throws SQLException {
    return JwtGenerator.getJwtToken();
  }
}