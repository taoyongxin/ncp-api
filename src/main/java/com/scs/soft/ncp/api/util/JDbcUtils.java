package com.scs.soft.ncp.api.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDbcUtils {
    private  Connection connection;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
