package com.application.service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaService.class);

    /*
      Для получения и использования kafkaTemplate необходимо предварительно задать Bean и настроить
      его в конфигурации spring (public KafkaTemplate<String, byte[]> kafkaTemplateFactory() в
      классе Producer)
    */
    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    @Autowired
    public KafkaService(final KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /*
      Отправка payload происходит в формате byte[],
      в данному случае нам необходимо перевести java.class к формату json (через jackson),
      а затем (через, тот же jackson) привести к формату byte[] (writeValueAsString(${Object}).getBytes())
      и передать методу, а получателю необходимо десериализовать его обратным путем.
      Необходимо вызывать ObjectMapper, для приведения к нужному типу, в том месте, где будем
      использовать метод push
    */
    public void push(final String topic, final byte[] payload) {
        LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);

        kafkaTemplate.send(
                topic,
                payload
        );
    }

/*  public void push(Object obj) {
    try {
      kafkaTemplate.send(
          "SOME TOPIC",
          objectMapper.writeValueAsBytes(
              obj
          )
      );
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }*/
}
