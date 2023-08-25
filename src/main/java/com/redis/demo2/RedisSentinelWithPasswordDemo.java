package com.redis.demo2;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.codec.StringCodec;

public class RedisSentinelWithPasswordDemo {

    public static void main(String[] args) {
        // Sentinel hosts and ports
        String[] sentinelHosts = {"172.20.7.90", "172.20.7.97", "172.20.7.98"};
        int sentinelPort = 26379;

        // Redis master name
        String masterName = "redis-master";

        // Redis password
        String password = "Redis6379"; // Replace with your actual password

        // Create a Redis Sentinel URI
        RedisURI.Builder sentinelUriBuilder = RedisURI.Builder.sentinel(sentinelHosts[0], sentinelPort, masterName);
        for (int i = 1; i < sentinelHosts.length; i++) {
            sentinelUriBuilder.withSentinel(sentinelHosts[i], sentinelPort);
        }
        RedisURI sentinelUri = sentinelUriBuilder.withPassword(password).build();

        // Create a Redis connection
        RedisClient client = RedisClient.create(sentinelUri);
        StatefulRedisConnection<String, String> connection = client.connect(StringCodec.UTF8);

        // Perform some Redis operations
        RedisCommands<String, String> syncCommands = connection.sync();
        syncCommands.set("key", "value");
        System.out.println(syncCommands.get("key"));

        // Close the connection
        connection.close();
        client.shutdown();
    }
}
