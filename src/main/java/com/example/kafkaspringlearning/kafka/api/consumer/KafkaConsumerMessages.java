package com.example.kafkaspringlearning.kafka.api.consumer;

import com.example.kafkaspringlearning.kafka.api.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class KafkaConsumerMessages implements MessageAppender, MessageReader {
    private final List<Message> messages = new ArrayList<>();
    public KafkaConsumerMessages(){}

    @Override
    public void append(Message message) {
        messages.add(message);
    }

    @Override
    public Optional<Message> getOne() {
        if(messages.isEmpty()){
            return Optional.empty();
        }
        Message latest = messages.get(0) ;
        messages.remove(0);
        return Optional.of(latest);
    }

    @Override
    public List<Message> getAll() {
        return this.messages;
    }
}
