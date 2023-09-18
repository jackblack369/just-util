package com.kafka.sasl.plain;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerExample {
    //消费主题名
    private final static String TOPIC = "demo";
    //消费的kafka集群地址
    //平台测试环境kafka地址
    private final static String BOOTSTRAP_SERVERS = "172.18.244.236:29092,172.18.244.237:29092,172.18.244.238:29092";
    //平台生产环境kafka地址
//    private final static String BOOTSTRAP_SERVERS = "192.1.4.173:29092,192.1.4.174:29092,192.1.4.175:29092,192.1.4.176:29092,192.1.4.177:29092,192.1.4.178:29092";

    //消费者组
    private final static String GROUP_NAME = "GROUP-BIGDATA";
    private final static String USERNAME = "qlbuser01";
    private final static String PASSWORD = "!QAZ2wsx";
    private final static String OFFSET = "earliest";

    private static Consumer<Long, String> createConsumer() {
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVERS);
        //消费者组
        props.put(ConsumerConfig.GROUP_ID_CONFIG,
                GROUP_NAME);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        //消费数据的偏移量
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, OFFSET);
        props.put("security.protocol", "SASL_PLAINTEXT");
        props.put("sasl.mechanism", "PLAIN");
        props.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"" + USERNAME +"\" password=\"" + PASSWORD + "\";");

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
