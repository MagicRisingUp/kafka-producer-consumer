package org.magiccode.kafka.integration;

import org.magiccode.kafka.producer.KafkaProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class KafkaIntegrationTest {

    @Autowired
    private KafkaProducerService producerService;

    @Autowired
    private KafkaTestConsumer testConsumer;

    @Test
    void whenSendMessage_thenMessageReceived() {
        String message = "Test message";

        producerService.sendMessage(message);

        await().atMost(5, TimeUnit.SECONDS)
                .until(() -> testConsumer.getReceivedMessages().contains(message));
    }
}