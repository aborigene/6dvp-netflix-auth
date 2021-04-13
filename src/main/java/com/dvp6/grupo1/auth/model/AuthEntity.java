/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 13/04/2021
*/

package com.dvp6.grupo1.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dvp6.grupo1.auth.security.BCryptPassword;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/*
  Classe responsável por criar uma entidade vinculada com o banco de dados.
*/
@Entity
@Table(name = "auth")
public class AuthEntity {

    /*
      Vinculando a variaveis as colunas do banco de dados.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @JsonDeserialize(using = BCryptPassword.class)
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "enabled")
    private Boolean enabled;

    /*
      Método construtor da classe.
    */
    public AuthEntity() {
    }

    public AuthEntity(String username, String password, String role, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    /*
      Métodos Getters e Setters.
    */
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}