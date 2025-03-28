package org.magiccode.kafka.unit.producer;

import org.magiccode.kafka.producer.KafkaProducerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class KafkaProducerServiceUnitTest {

    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;

    @InjectMocks
    private KafkaProducerService kafkaProducerService;

    private static final String TOPIC = "messages.topic";
    private static final String MESSAGE = "Test message";

    @BeforeEach
    void setUp() {
        kafkaProducerService = new KafkaProducerService(kafkaTemplate, TOPIC);
    }

    @Test
    void whenSendMessage_thenInvokeKafkaTemplateSend() {
        // When
        kafkaProducerService.sendMessage(MESSAGE);

        // Then
        verify(kafkaTemplate, times(1)).send(eq(TOPIC), eq(MESSAGE));
    }
}