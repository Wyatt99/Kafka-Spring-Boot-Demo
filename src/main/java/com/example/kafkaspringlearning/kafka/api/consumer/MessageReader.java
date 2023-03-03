package com.example.kafkaspringlearning.kafka.api.consumer;

import com.example.kafkaspringlearning.kafka.api.Message;

import java.util.List;
import java.util.Optional;

public interface MessageReader {
    Optional<Message> getOne();
    List<Message> getAll();
}
