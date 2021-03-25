package com.dvp6.grupo1.auth.controller;

import java.sql.SQLException;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.dvp6.grupo1.auth.security.JwtGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthController {


  @GetMapping("/")
  public String token() throws JWTCreationException, SQLException {
    return JwtGenerator.getJWT();
  }

}
