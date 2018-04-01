package com.application.config.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;

@Configuration
public class Producer {

    /*
      Присвоение переменной значения указанной ${property}
      В данном случа
    */
    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    /*
      Создание объекта и его настройка, для дальнейшего использования в методах отправки сообщений
    */
    @Bean
    public KafkaTemplate<String, byte[]> kafkaTemplateFactory() {
        return new KafkaTemplate<String, byte[]>(
                new DefaultKafkaProducerFactory<String, byte[]>(
                        new HashMap<String, Object>() {{
                            put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
                            put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
                            put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);

                        }}
                )
        );
    }
}
