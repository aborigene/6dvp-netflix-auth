/*
  Autor: Guilherme Rubio
  e-mail: guilherme.rubio@outlook.com.br
  Data: 14/04/2021
*/

package com.dvp6.grupo1.auth.broker;

import com.dvp6.grupo1.auth.model.AuthEntity;
import com.dvp6.grupo1.auth.model.AuthRepository;
import com.dvp6.grupo1.auth.security.BCryptPassword;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
  Classe responsável por consumir as filas no RabbitMQ.
*/
@Component
public class AuthBrokerConsumer {

  @Autowired
  private AuthRepository authRepository;

  @Autowired
  private AuthEntity authEntity;

  /*
   * Método para ler a fila e salvas os dados no banco.
   */
  @RabbitListener(queues = AuthBrokerConfig.QUEUE)
  public void consumer(Message message) throws JsonMappingException, JsonProcessingException {
    try {
      ObjectMapper mapper = new ObjectMapper();
      authEntity = mapper.readValue(new String(message.getBody()), AuthEntity.class);
      authEntity.setPassword(BCryptPassword.encrypt("123"));
      authEntity.setRole("ROLE_USER");
      authEntity.setEnabled(true);
      authRepository.save(authEntity);
    } catch (Exception e) {
      System.out.println("erro: " + e);
    }
  }
}
