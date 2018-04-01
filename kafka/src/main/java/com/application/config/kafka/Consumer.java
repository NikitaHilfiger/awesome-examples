package com.application.config.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;

/*
Обязательно требуется для аннотации @KafkaListener в методах прослушивания топиков
*/
@EnableKafka
@Configuration
public class Consumer {

    @Value("${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.application.name}")
    private String appName;

    /*
      Создание объекта и его настройка, для дальнейшего использования в методах прослушивания топиков
    */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, byte[]> kafkaListenerContainerFactory() {
        return new ConcurrentKafkaListenerContainerFactory<String, byte[]>() {{
            setConsumerFactory(
                    new DefaultKafkaConsumerFactory<>(
                            new HashMap<String, Object>() {{
                                put(ConsumerConfig.GROUP_ID_CONFIG, appName);
                                put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
                                put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
                                put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
                            }}
                    )
            );
        }};
    }
}
