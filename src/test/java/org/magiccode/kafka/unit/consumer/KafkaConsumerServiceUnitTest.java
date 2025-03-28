package org.magiccode.kafka.unit.consumer;


import org.junit.jupiter.api.extension.ExtendWith;
import org.magiccode.kafka.consumer.KafkaConsumerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.support.Acknowledgment;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class KafkaConsumerServiceUnitTest {

    @Mock
    private Acknowledgment acknowledgment;

    @InjectMocks
    private KafkaConsumerService kafkaConsumerService;

    private static final String MESSAGE = "Test message";

    @Test
    void whenConsumeMessage_thenAcknowledge() {
        // When
        kafkaConsumerService.consumeMessage(MESSAGE, acknowledgment);

        // Then
        verify(acknowledgment).acknowledge();
    }
}