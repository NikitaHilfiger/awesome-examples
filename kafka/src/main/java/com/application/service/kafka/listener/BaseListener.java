package com.application.service.kafka.listener;

import com.application.config.kafka.Topic;
import com.application.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/*
В текущем проекте, это требуется для возможности использования в тестах
*/
@Component
public class BaseListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseListener.class);
    private final ObjectMapper objectMapper;

    @Autowired
    public BaseListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /*
      Для использование данной аннотации, предварительно, необходимо добавить
      в конфигурацию spring аннотацию @EnableKafka
    */
    @KafkaListener(topics = Topic.HELLO_WORLD)
    public void createUser(byte[] payload) throws IOException {
        LOGGER.debug("received payload='{}'", payload);
        User user = objectMapper.readValue(
                payload,
                new TypeReference<User>() {
                }
        );
        LOGGER.debug("handled payload {}", user);
    }

/*  @SuppressWarnings("unchecked")
  @BaseListener(topics = "SOME TOPIC")
  public void handle(byte[] payload) throws IOException {
    Map<String, Object> data = objectMapper.readValue(
        payload,
        Map.class
    );

    String name = (String) data.get("firstName");
    Map<String, Object> user = (Map<String, Object>) data.get("user");
  }*/
}
