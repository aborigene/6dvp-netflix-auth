/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 13/04/2021
*/

package com.dvp6.grupo1.auth.controller;

import com.dvp6.grupo1.auth.model.AuthEntity;
import com.dvp6.grupo1.auth.model.AuthRepository;
import com.dvp6.grupo1.auth.security.JwtGenerator;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
  Classe responsável por expor as APIs.
*/
@RestController
public class AuthController {

  /*
   * Instancia a classe do repositório do JPA.
   */
  @Autowired
  private AuthRepository authRepository;

  /*
   * Criando a rota /login com o verbo GET. Responsável por receber o usuário e
   * senha e retornar um token jwt para o usuário.
   */
  @GetMapping("/login")
  public String login() throws SQLException {
    return JwtGenerator.getJwtToken();
  }

  /*
   * Criando a rota /addUser com o verbo POST. Recebe um Json com os dados e cria
   * um novo usuário no sistema.
   */
  @PostMapping("/addUser")
  public ResponseEntity<String> addUser(@RequestBody AuthEntity authEntity) {
    try {
      authRepository.save(authEntity);
      return new ResponseEntity<>("Usuário adicionado com sucesso!", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Erro: por favor valide se o usuário já existe.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /*
   * Criando a rota /getUser com o verbo GET Retorna a lista com todos os
   * usuários.
   */
  @GetMapping("/getUsers")
  public Iterable<AuthEntity> getUsers() {
    return authRepository.findAll();
  }

}