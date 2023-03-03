package com.example.kafkaspringlearning.kafka.api.consumer;

import com.example.kafkaspringlearning.kafka.api.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaConsumerController {
    private KafkaConsumerService kafkaConsumerService;
    public KafkaConsumerController(KafkaConsumerService kafkaConsumerService){
        this.kafkaConsumerService = kafkaConsumerService;
    }

    @GetMapping("/messages/all")
    public List<Message> retrieveAllMessages(){
        return kafkaConsumerService.retrieveAllMessages();
    }

    @GetMapping("/messages/latest")
    public List<Message> retrieveLatestMessage(){
        return kafkaConsumerService.retrieveLatestMessage();
    }
}
