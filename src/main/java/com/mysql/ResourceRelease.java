package com.mysql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ResourceRelease {

    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "1qaz2wsx";

        String csvFilePath = "/Users/dongwei/Documents/tmp/data.csv";

        int batchSize = 20;

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);

            String sql = "INSERT INTO review (course_name, student_name, timestamp) VALUES (?, ?, ?)";


            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); // skip header line
            statement  = connection.prepareStatement(sql);
            while ((lineText = lineReader.readLine()) != null) {

                String[] data = lineText.split(",");
                String courseName = data[0];
                String studentName = data[1];
                String timestamp = data[2];

                statement.setString(1, courseName);
                statement.setString(2, studentName);

                Timestamp sqlTimestamp = Timestamp.valueOf(timestamp);
                statement.setTimestamp(3, sqlTimestamp);

                statement.execute();
                connection.commit();
                connection.rollback();
                statement.close();
                statement  = connection.prepareStatement(sql);

            }

            lineReader.close();


        } catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            if(connection!=null){
                connection.close();
            }
        }

    }
}
