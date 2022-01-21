package com.jdbc;

import java.sql.*;

public class CatchExceptionByMysql {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?useSSL=false";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String DRIVER = "org.postgresql.Driver";
    private static Connection conn;

    private static final String sqlQuery = "INSERT INTO public.tbl (id, name, surname, age) VALUES (?,?,?,?)";


    public static void main(String[] args) {

        int[] affectedRecords = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ts_data?useSSL=false","root","123456");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO person (id, name, surname, age) VALUES (?,?,?,?)");

            ps.setInt(1, 6);
            ps.setString(2, "Name1");
            ps.setString(3, "Surname1");
            ps.setInt(4, 1);
            ps.addBatch();

            ps.setInt(1, 5);
            ps.setString(2, "Name2");
            ps.setString(3, "Surname1");
            ps.setInt(4, 1);
            ps.addBatch();

            ps.setInt(1, 7);
            ps.setString(2, "Name3");
            ps.setString(3, "Surname3");
            ps.setInt(4, 1);
            ps.addBatch();


            affectedRecords = ps.executeBatch();


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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ClassNotFoundException");
        }

        for(int a : affectedRecords){
            System.out.println("affectRecord :"+ a);
        }


    }
}
