package com.jdbc;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CatchExceptionExample {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?useSSL=false";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        String sqlQuery = "INSERT INTO public.tbl (id, name, surname, age) VALUES (?,?,?,?)";

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sqlQuery);

//            for(int i=100;i>2;i--){
            for(int i=3;i<10;i++){
                ps.setInt(1, i);
                ps.setString(2, "Name1");
                ps.setString(3, "Surname1");
                ps.setInt(4, 1);
                ps.addBatch();
            }

            ps.setInt(1, 3);
            ps.setString(2, "Name1");
            ps.setString(3, "Surname1");
            ps.setInt(4, 1);
            ps.addBatch();

            int[] affectedRecords = ps.executeBatch();
            for(int a:affectedRecords) {
                System.out.println(a);
            }

        } catch (BatchUpdateException ex) {
//            ex.printStackTrace();
            int[] updateCount = ex.getUpdateCounts();

            int count = 1;
            for (int i : updateCount) {
                if  (i == Statement.EXECUTE_FAILED) {
                    System.out.println("Error on request " + count +": Execute failed");
                } else {
                    System.out.println("Request " + count +": OK");
                }
                count++;

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
