package com.jdbc;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class TestUpdateCount {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        //////////////////////////////////////////////////////////////////////////////////////
        // CHANGE THIS
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres?charSet=UTF-8";
        String dbUser = "postgres";
        String dbPassword = "postgres";
        //////////////////////////////////////////////////////////////////////////////////////

        try {
            Connection con = openConnection(dbUrl, dbUser, dbPassword);
            con.setAutoCommit(false);

            try {
                // Prepare Table
                Statement stmtDrop = con.createStatement();
                stmtDrop.execute("DROP TABLE IF EXISTS TESTTABLE ");
                con.commit();
                Statement stmtCreate = con.createStatement();
                stmtCreate.execute("CREATE TABLE TESTTABLE (id INTEGER PRIMARY KEY)");
                con.commit();
                Statement stmtData = con.createStatement();
                stmtData.execute("INSERT INTO TESTTABLE VALUES (5)");
                con.commit();

                // TestCase: Insert 10 statements via jdbc batch.
                // 5h statement should fail because of duplicate key error
                con = openConnection(dbUrl, dbUser, dbPassword);
                con.setAutoCommit(false);

                Statement stmt = con.createStatement();
                for (int i = 0; i < 10; i++) {
                    stmt.addBatch("INSERT INTO TESTTABLE VALUES('" + i + "')");
                }

                stmt.executeBatch();

                con.commit();
            } catch (java.sql.BatchUpdateException x) {
                final int[] updateCounts = x.getUpdateCounts();
                for (int i = 0; i < updateCounts.length; i++) {
                    System.err.println("updateCounts[" + i + "]=" + updateCounts[i]);
                }
                // First 5 statements are successfully, so update count should be 1
                for (int i = 0; i < 5; i++) {
                    if (updateCounts[i] != 1)
                        System.err.println("Wrong information returned by driver for update Count " + i);
                }

            }
        } catch (SQLException s) {

            s.printStackTrace();

            if (s.getNextException() != null) {
                s.getNextException().printStackTrace();

            }

        } catch (Exception s) {
            s.printStackTrace();

        }
    }


    private static Connection openConnection(String url, String user, String password)
            throws ClassNotFoundException, SQLException, IOException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Could not load driver!");
            throw e;
        }
        Properties props = new Properties();
        // Activate for logging
        // props.setProperty( "loglevel", "2" );
        // FileWriter fw = new FileWriter( "C:\\temp\\test12345.txt" );
        // DriverManager.setLogWriter( new PrintWriter( fw ) );

        props.setProperty("user", user);
        props.setProperty("password", password);
        return DriverManager.getConnection(url, props);

    }

}

