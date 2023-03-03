package com.example.kafkaspringlearning.kafka.api.consumer;

import com.example.kafkaspringlearning.kafka.api.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KafkaConsumerService {
    private final MessageReader messages;

    public KafkaConsumerService(MessageReader messages){
        this.messages = messages;
    }
    public List<Message> retrieveAllMessages(){
        return messages.getAll();
    }

    public List<Message> retrieveLatestMessage(){
       Optional<Message> optionalMessage = messages.getOne();
       List<Message> list = new ArrayList<>();
       optionalMessage.ifPresent(list::add);
       return list;
    }
}
