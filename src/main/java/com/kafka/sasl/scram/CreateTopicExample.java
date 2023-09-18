package com.kafka.sasl.scram;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Collections;
import java.util.Properties;

public class CreateTopicExample {
    public static void main(String[] args) {
        // Kafka broker address
        String bootstrapServers = "172.20.58.93:9092";

        // Kafka Admin Client properties
        Properties adminProps = new Properties();
        adminProps.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        try (AdminClient adminClient = AdminClient.create(adminProps)) {
            // Define the topic and its properties
            NewTopic newTopic = new NewTopic("COMMON", -1, (short) -1);

            // Create the topic
            CreateTopicsResult result = adminClient.createTopics(Collections.singletonList(newTopic));
//            System.out.println(result.values());
            System.out.println("Topic created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

