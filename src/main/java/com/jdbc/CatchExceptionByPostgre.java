package com.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

public class CatchExceptionByPostgre {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?useSSL=false";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String DRIVER = "org.postgresql.Driver";
    private static HikariDataSource dataSource;
    private static Connection conn;

    private static final String sqlQuery = "INSERT INTO public.tbl (id, name, surname, age) VALUES (?,?,?,?)";


    public static void main(String[] args) {

        int[] affectedRecords = null;
        try {

            HikariConfig config = new HikariConfig();
            config.setDriverClassName(DRIVER);
            config.setJdbcUrl(URL);
            config.setUsername(USER);
            config.setPassword(PASSWORD);

            dataSource = new HikariDataSource(config);
            conn = dataSource.getConnection();
//            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlQuery);


//            for(int i=3;i<100;i++){
//                ps.setInt(1, i);
//                ps.setString(2, "Name1");
//                ps.setString(3, "Surname1");
//                ps.setInt(4, 1);
//                ps.addBatch();
//            }

            ps.setInt(1, 6);
            ps.setString(2, "Name1");
            ps.setString(3, "Surname1");
            ps.setInt(4, 1);
            ps.addBatch();

            ps.setInt(1, 7);
            ps.setString(2, "Name2");
            ps.setString(3, "Surname1");
            ps.setInt(4, 1);
            ps.addBatch();

            ps.setInt(1, 8);
            ps.setString(2, "Name3");
            ps.setString(3, "Surname3");
            ps.setInt(4, 1);
            ps.addBatch();

            System.out.println("auto commit value:"+conn.getAutoCommit());

            affectedRecords = ps.executeBatch();
//            conn.commit();

            System.out.println("affectRecords count:"+ affectedRecords.length);


        } catch (BatchUpdateException ex) {
            int[] updateCount = ex.getUpdateCounts();

            int count = 1;
            for (int i : updateCount) {
                if  (i == Statement.EXECUTE_FAILED) {
                    System.out.println("Error on request " + count +": Execute failed, and value is "+i);
                } else {
                    System.out.println("request success adn value is :"+i);
                }
                count++;

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException");
        }

        for(int a : affectedRecords){
            System.out.println("affectRecord :"+ a);
        }


    }
}
