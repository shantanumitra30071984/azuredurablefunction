package com.durable.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
                System.getenv("DB_URL"),
                System.getenv("DB_USER"),
                System.getenv("DB_PASSWORD")
        );
    }
}
