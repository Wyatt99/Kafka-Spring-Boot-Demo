package com.example.kafkaspringlearning.kafka.api.consumer;

import com.example.kafkaspringlearning.kafka.api.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KafkaConsumerListener {
    private final MessageAppender messageAppender;

    public  KafkaConsumerListener(MessageAppender messageAppender){
        this.messageAppender = messageAppender;
    }
    @KafkaListener(topics ="demo-api",groupId = "one")
    private void consumeMessages(ConsumerRecord<String, String> record){
        System.out.println(record.key() + " " + record.value());
        Message add = new Message(record.key(),record.value());
        messageAppender.append(add);
    }

}
