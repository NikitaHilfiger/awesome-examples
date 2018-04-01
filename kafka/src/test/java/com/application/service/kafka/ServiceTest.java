package com.application.service.kafka;

import com.application.config.kafka.Topic;
import com.application.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@NoArgsConstructor
public class ServiceTest {

    @ClassRule
    public static KafkaEmbedded kafkaEmbedded = new KafkaEmbedded(1, true);

    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    private Logger LOGGER = LoggerFactory.getLogger(ServiceTest.class);

    @Before
    public void setUp() throws Exception {
        // wait until the partitions are assigned
        for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry.getListenerContainers()) {
            ContainerTestUtils.waitForAssignment(
                    messageListenerContainer,
                    kafkaEmbedded.getPartitionsPerTopic());
        }
    }

    @Test
    public void sendJson() throws InterruptedException {
        try {
            kafkaService.push(
                    Topic.HELLO_WORLD,
                    objectMapper.writeValueAsString(getTestUser()).getBytes()
            );
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(
                    e.getMessage()
            );
        }
    }

    private User getTestUser() {
        return new User(
                "Alex",
                "Bomber",
                123L);
    }
}