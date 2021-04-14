/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 13/04/2021
*/

package com.dvp6.grupo1.auth.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
  Classe repositório do Spring Data JPA.
*/
@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Long> {

}
