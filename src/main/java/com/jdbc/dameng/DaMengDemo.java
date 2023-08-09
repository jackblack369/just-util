package com.jdbc.dameng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaMengDemo {
    public static void main(String[] args) {
        // Database credentials
        String hostname = "172.18.244.239";
        int port = 5236; // Default DB2 port number
        String schemaName = "dds_test";
        String username = "datacanvas";
        String password = "rtdspQLB2022";

        // JDBC connection variables
        Connection connection = null;

        try {
            // Register the DB2 driver
            Class.forName("dm.jdbc.driver.DmDriver");

            // Create the JDBC URL for the DB2 database
            String url = "jdbc:dm://" + hostname + ":" + port +"/" + schemaName;

            // Create the connection using DriverManager
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("select * from test");
            statement.execute();

            // Check if the connection is successful
            if (connection != null) {
                System.out.println("Connected to the dm database!");
                // You can perform database operations here
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find the dm driver class: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the dm database: " + e.getMessage());
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("An error occurred while closing the DB2 connection: " + e.getMessage());
                }
            }
        }
    }
}

