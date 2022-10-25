package com.likelion.dao;

import java.sql.Connection;
import java.util.Map;
import java.sql.DriverManager;
import java.sql.SQLException;
public class AWSConnectionMaker implements ConnectionMaker {


    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(dbHost, dbUser, dbPassword);



        return c;

    }
}
