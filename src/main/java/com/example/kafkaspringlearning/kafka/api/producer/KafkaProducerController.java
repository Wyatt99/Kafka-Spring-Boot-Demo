package com.example.kafkaspringlearning.kafka.api.producer;

import com.example.kafkaspringlearning.kafka.api.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {
    private KafkaProducerService kafkaProducerService;
    public KafkaProducerController(KafkaProducerService kafkaProducerService){
        this.kafkaProducerService = kafkaProducerService;
    }
    @PostMapping("/messages")
    public ResponseEntity<Object> sendMessage(@RequestBody Message message){
        return kafkaProducerService.sendMessage(message);
    }
}
