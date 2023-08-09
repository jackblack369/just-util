package com.jdbc.db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchMerge {
    public static void main(String[] args) {
        String url = "jdbc:db2://172.20.7.50:50000/testdb"; // 替换为您的数据库连接 URL
        String username = "db2inst1"; // 替换为您的数据库用户名
        String password = "123456"; // 替换为您的数据库密码

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            connection.setAutoCommit(false); // 关闭自动提交事务

            String sql = "MERGE INTO YourTable AS T "
                    + "USING (VALUES (?, ?)) AS S (col1, col2) "
                    + "ON T.primary_key_column = S.col1 "
                    + "WHEN MATCHED THEN "
                    + "UPDATE SET T.column_to_update = S.col2 "
                    + "WHEN NOT MATCHED THEN "
                    + "INSERT (col1, col2) VALUES (S.col1, S.col2)";

            String mergeSQL = "MERGE INTO TEST.T_SINK AS target\n" +
                    "USING (VALUES (?,?,?)) AS source(C1, C2,C3)\n" +
                    "    ON target.C1 = source.C1\n" +
                    "WHEN MATCHED THEN\n" +
                    "    UPDATE SET target.C2 = source.C2, target.C3 = source.C3\n" +
                    "WHEN NOT MATCHED THEN\n" +
                    "    INSERT (C1, C2, C3) VALUES (source.C1, source.C2, source.C3)";

            PreparedStatement statement = connection.prepareStatement(mergeSQL);

            // 使用批处理将多个数据行插入到表中
            statement.setString(1, "1"); // 替换为您要插入的数据
            statement.setString(2, "a"); // 替换为您要插入的数据
            statement.setString(3, "me"); // 替换为您要插入的数据
            statement.addBatch();

            statement.setString(1, "1");
            statement.setString(2, "b");
            statement.setString(3, "you");
            statement.addBatch();
            statement.setString(1, "3");
            statement.setString(2, "c");
            statement.setString(3, "you");
            statement.addBatch();
            statement.setString(1, "3");
            statement.setString(2, "d");
            statement.setString(3, "you");
            statement.addBatch();
            statement.setString(1, "5");
            statement.setString(2, "e");
            statement.setString(3, "you");
            statement.addBatch();
            statement.setString(1, "5");
            statement.setString(2, "f");
            statement.setString(3, "you");
            statement.addBatch();

            int[] batchResult = statement.executeBatch();
            connection.commit(); // 提交事务

            System.out.println("批处理操作成功执行：" + batchResult.length + " 行受影响");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

