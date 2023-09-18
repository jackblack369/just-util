package com.kafka.sasl.plain;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class KafkaProducerExample {
    public static void main(String[] args) {
        String bootstrapServers = "172.20.58.93:9092,172.20.58.95:9092";
        String topic = "COMMON";

        Properties producerProps = new Properties();
        producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
//        producerProps.put("security.protocol", "SASL_PLAINTEXT");
//        producerProps.put("sasl.mechanism", "PLAIN");
//        producerProps.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"admin\" password=\"datacanvas\";");

        Producer<String, String> producer = new KafkaProducer<>(producerProps);

        for (int i = 0; i < 10; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, "key-" + i, "Hello, Kafka! Message " + i);
            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception == null) {
                        System.out.println("Message sent successfully. Topic: " +
                                metadata.topic() + ", Partition: " +
                                metadata.partition() + ", Offset: " +
                                metadata.offset());
                    } else {
                        System.err.println("Error sending message: " + exception.getMessage());
                    }
                }
            });
        }

        producer.close();
    }
}
