package com.example.kafkaspringlearning.kafka.api.producer;

import com.example.kafkaspringlearning.kafka.api.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class KafkaProducerService {
    private KafkaTemplate<String,String> producer;
    @Value("demo-api")
    private String topic;
    public KafkaProducerService(KafkaTemplate<String,String> producer){
        this.producer = producer;
    }
    public ResponseEntity<Object> sendMessage(Message message){
        producer.send(topic, message.getKey(), message.getValue());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).build();
    }
}
