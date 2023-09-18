package com.kafka.sasl.scram;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ScramConsumer {
    //消费主题名
//    private final static String TOPIC = "CMACAACA";
    private final static String TOPIC = "COMMON";
    //消费的kafka集群地址
//    private final static String BOOTSTRAP_SERVERS = "172.18.244.75:19092,172.18.244.76:19092,172.18.244.77:19092";
    private final static String BOOTSTRAP_SERVERS = "172.20.58.93:39092";

    private static Consumer<Long, String> createConsumer() {
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVERS);
        //消费者组
        props.put(ConsumerConfig.GROUP_ID_CONFIG,
                "SCRAM-GROUP");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        //消费数据的偏移量
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put("security.protocol", "SASL_PLAINTEXT");
        props.put("sasl.mechanism", "SCRAM-SHA-256");
        props.put("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"admin\" password=\"datacanvas\";");

        // Create the consumer using props.
        final Consumer<Long, String> consumer = new KafkaConsumer<>(props);

        // Subscribe to the topic.
        consumer.subscribe(Collections.singletonList(TOPIC));
        return consumer;
    }

    static void runConsumer() throws InterruptedException {
        final Consumer<Long, String> consumer = createConsumer();
        try {
            while (true) {
                final ConsumerRecords<Long, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
                if (consumerRecords.count() > 0) {
                    consumerRecords.forEach(record -> {
                        System.out.printf("Consumer Record:(%s, %s, %d, %d)\n",
                                record.key(), record.value(),
                                record.partition(), record.offset());
                    });
                    consumer.commitAsync();
                }
            }
        }finally {
            consumer.close();
        }

    }

    public static void main(String[] args) throws Exception {
        runConsumer();
    }
}
