package com.dvp6.grupo1.auth.controller;

import java.sql.SQLException;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.dvp6.grupo1.auth.model.AuthEntity;
import com.dvp6.grupo1.auth.model.AuthRepository;
import com.dvp6.grupo1.auth.security.JwtGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @Autowired
  private AuthRepository authRepository;

  @GetMapping("/getToken")
  public String getToken() throws JWTCreationException, SQLException {
    return JwtGenerator.getJWT();
  }

  @PostMapping("/addUser")
  public void addUser(@RequestBody AuthEntity authEntity) {
      authRepository.save(authEntity);
  }

  @GetMapping("/getUsers")
  public Iterable<AuthEntity> getUsers() {
      return authRepository.findAll();
  }

}
