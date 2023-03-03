package com.example.kafkaspringlearning.kafka.api;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaProperties {
    private Map<String, Object> configProps = new HashMap<>();
    @Value("cluster.playground.cdkt.io:9092")
    private String bootStrapAddress;

    private void setConfigProps(){
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapAddress);
        configProps.put("security.protocol","SASL_SSL");
        configProps.put("sasl.jaas.config",
                "org.apache.kafka.common.security.plain.PlainLoginModule required username=" +
                        "\"5OVOs8xrMFBRvuYfVGya6z\" password=" +
                        "\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2F1dGguY2" +
                        "9uZHVrdG9yLmlvIiwic291cmNlQXBwbGljYXRpb24iOiJhZG1pbiIsInVzZXJNYWlsIjp" +
                        "udWxsLCJwYXlsb2FkIjp7InZhbGlkRm9yVXNlcm5hbWUiOiI1T1ZPczh4ck1GQlJ2dVlmVkd5" +
                        "YTZ6Iiwib3JnYW5pemF0aW9uSWQiOjY5ODQ4LCJ1c2VySWQiOjgwNzU5LCJmb3JFeHBpcmF0a" +
                        "W9uQ2hlY2siOiI1ZTdiZjhkNS0wODFlLTQ1YTItYWI2Ni1iMmYzYzJhMzgzODkifX0.3nvixqR" +
                        "s08lXAJKYqkZVmZLkqAqhW3Ac_0ccIhWUanU\";");
        configProps.put("sasl.mechanism","PLAIN");
    }

    public Map<String, Object> getProducerProperties(){
        setConfigProps();
        configProps.put("key.serializer", StringSerializer.class.getName());
        configProps.put("value.serializer", StringSerializer.class.getName());
        return configProps;
    }

    public Map<String, Object> getConsumerProperties(){
        setConfigProps();
        configProps.put("key.deserializer", StringDeserializer.class.getName());
        configProps.put("value.deserializer", StringDeserializer.class.getName());
        return configProps;
    }
}
