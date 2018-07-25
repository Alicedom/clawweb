package claw.web.queue;

import java.sql.*;

public class StoredProcedureExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/wordpress?useSSL=false";
        String username = "root";
        String password = "123456aA";
        String sql = "{call s(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(sql);) {
//
//            // IN author BIGINT
            stmt.setInt(1, 1);
//
            //  IN DATE DATETIME,
            stmt.setDate(2, null);

            //  IN title MEDIUMTEXT,
            stmt.setString(3, "title");
            //   IN sapo MEDIUMTEXT,
            stmt.setString(4, "4");
//            IN content LONGTEXT,

            stmt.setString(5, "content");
//                    IN STATUS VARCHAR (20),
            stmt.setString(6, "publish");
//                    IN NAME VARCHAR (200),
            stmt.setString(7, "url-name");
//                    IN parent BIGINT,
            stmt.setInt(8, 0);
//            IN TYPE VARCHAR (20),
            stmt.setString(9, "post");
//                    IN origin VARCHAR (300),
            stmt.setString(10, "10");
//                    IN origin_link VARCHAR (1000),
            stmt.setString(11, "11");
//                    IN origin_author VARCHAR (200),
            stmt.setString(12, "12");
//                    IN stocks_code VARCHAR (200),
            stmt.setString(13, "13");
//                    IN event_stream VARCHAR (300),
            stmt.setString(14, "14");
//                    IN picture_link VARCHAR (1000),
            stmt.setString(15, "15");
//                    IN categoryexp TEXT,
            stmt.setString(16, "16");
//            IN categorylist TEXT,
            stmt.setString(17, "17");
//                    OUT news_id BIGINT,
            stmt.setInt(18, 15);
            stmt.registerOutParameter(18, Types.BIGINT);
//            IN news_date VARCHAR (200)
            stmt.setString(19, "19");

            stmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
