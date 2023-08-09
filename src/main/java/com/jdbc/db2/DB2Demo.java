package com.jdbc.db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB2Demo {
    public static void main(String[] args) {
        // Database credentials
        String hostname = "172.20.7.50";
        int port = 50000; // Default DB2 port number
        String dbName = "testdb";
        String username = "db2inst1";
        String password = "123456";

        // JDBC connection variables
        Connection connection = null;

        try {
            // Register the DB2 driver
            Class.forName("com.ibm.db2.jcc.DB2Driver");

            // Create the JDBC URL for the DB2 database
            String url = "jdbc:db2://" + hostname + ":" + port + "/" + dbName;

            // Create the connection using DriverManager
            connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("select * from TEST.T_SINK");
            statement.execute();

            // Check if the connection is successful
            if (connection != null) {
                System.out.println("Connected to the DB2 database!");
                // You can perform database operations here
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find the DB2 driver class: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the DB2 database: " + e.getMessage());
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

