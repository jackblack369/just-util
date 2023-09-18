package com.kafka.sasl.plaintext;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.DeleteTopicsOptions;
import org.apache.kafka.clients.admin.DeleteTopicsResult;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class DeleteKafkaTopic {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Kafka broker address
        String bootstrapServers = "172.20.58.93:9092,172.20.58.95:9092";

        // Kafka Admin Client properties
        Properties adminProps = new Properties();
        adminProps.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        try (AdminClient adminClient = AdminClient.create(adminProps)) {
            // Specify the topic to delete
            String topicToDelete = "test3";

            // Create a set of topics to delete
            DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(Collections.singletonList(topicToDelete), new DeleteTopicsOptions());

            // Wait for the deletion to complete
            deleteTopicsResult.all().get();
            System.out.println("Topic " + topicToDelete + " deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

