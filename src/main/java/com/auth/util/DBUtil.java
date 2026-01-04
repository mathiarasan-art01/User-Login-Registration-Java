package com.auth.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/userdb",
                "root",
                "root"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
