package org.magiccode.kafka.integration;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KafkaTestConsumer {

    private final List<String> receivedMessages = new ArrayList<>();

    @KafkaListener(topics = "${app.topics.message-topic}")
    public void receiveMessage(String message) {
        receivedMessages.add(message);
    }

    public List<String> getReceivedMessages() {
        return receivedMessages;
    }

    public void clear() {
        receivedMessages.clear();
    }
}