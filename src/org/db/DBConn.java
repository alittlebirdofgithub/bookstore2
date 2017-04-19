package org.db;

import java.sql.*;

/**
 * Created by 18673 on 2017/4/18 0018.
 */
public class DBConn {
    public static Connection conn;
    public static Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book",
                    "admin", "admin");
            System.out.println("连接成功！");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void CloseConn() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        Connection conn = getConn();
    }*/
}
