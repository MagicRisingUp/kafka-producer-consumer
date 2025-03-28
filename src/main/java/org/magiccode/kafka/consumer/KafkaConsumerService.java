package org.magiccode.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "${app.topics.message-topic}")
    public void consumeMessage(String message, Acknowledgment acknowledgment) {
        log.info("Consumed message: {}", message);
        // Process the message here
        acknowledgment.acknowledge();
    }
}