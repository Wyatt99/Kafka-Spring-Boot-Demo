package com.example.kafkaspringlearning.kafka.api.consumer;

import com.example.kafkaspringlearning.kafka.api.Message;

public interface MessageAppender {
    void append(Message message);

}
