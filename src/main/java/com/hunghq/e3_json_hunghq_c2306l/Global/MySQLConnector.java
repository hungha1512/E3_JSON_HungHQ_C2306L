package com.hunghq.e3_json_hunghq_c2306l.Global;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {
    private static final String host = "jdbc:mysql://localhost:3306/shop";
    private static final String user = "root";
    private static final String password = "Hungha15123@";
    private static Connection connection;

    public MySQLConnector(Connection connection) {
        MySQLConnector.connection = connection;
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(host, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
