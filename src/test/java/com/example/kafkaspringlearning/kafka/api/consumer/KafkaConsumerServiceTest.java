package com.example.kafkaspringlearning.kafka.api.consumer;

import com.example.kafkaspringlearning.kafka.api.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class KafkaConsumerServiceTest {
    @Mock
    private KafkaConsumerMessages messagesMock;
    @InjectMocks
    private KafkaConsumerService service;

    @Test
    void retrieveAllMessages_NotEmptyTest(){
        when(messagesMock.retrieveAllMessages()).thenReturn(
                Arrays.stream(new Message[]{new Message("test"),
                                new Message("test2")})
                        .toList());
        assertEquals(2,service.retrieveAllMessages().size());
    }

    @Test
    void retrieveAllMessages_EmptyTest(){
        when(messagesMock.retrieveAllMessages()).thenReturn(
                Arrays.stream(new Message[]{}).toList());
        assertEquals(0,service.retrieveAllMessages().size());
    }

    @Test
    void retrieveLatestMessages_EmptyTest(){
        when(messagesMock.retrieveLatestMessage()).thenReturn(
                Arrays.stream(new Message[]{})
                        .toList());
        assertEquals(0,service.retrieveLatestMessage().size());
    }

    @Test
    void retrieveLatestMessages_NotEmptyTest(){
        when(messagesMock.retrieveLatestMessage()).thenReturn(
                Arrays.stream(new Message[]{new Message("test")})
                        .toList());
        assertEquals(1,service.retrieveLatestMessage().size());
    }
}
