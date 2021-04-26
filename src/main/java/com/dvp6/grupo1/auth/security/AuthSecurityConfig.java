/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 13/04/2021
*/

package com.dvp6.grupo1.auth.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
  Classe responsável pela configuração do Spring Security.
*/
@Configuration
@EnableWebSecurity
public class AuthSecurityConfig extends WebSecurityConfigurerAdapter {

  /*
   * Instanciando o data source para consultar o usuário e senha do banco de
   * dados.
   */
  @Autowired
  private DataSource dataSource;

  /*
   * Método responsável por validar o usuário e senha.
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()).dataSource(dataSource)
        .usersByUsernameQuery("SELECT username, password, enabled from `auth-db`.auth where username =?")
        .authoritiesByUsernameQuery("SELECT username, role FROM `auth-db`.auth WHERE username =?");

  }

  /*
   * Método responsável por deixar a documentação anomina.
   */
  @Override
  public void configure(WebSecurity http) throws Exception {
    http.ignoring().antMatchers("/swagger-auth");
  }

  /*
   * Método responsável filtar as permissões para as rotas.
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().httpBasic();
    http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/getUsers").permitAll()
        .antMatchers("/addUser").hasAuthority("ROLE_ADMIN").anyRequest().authenticated();

  }
}
