package com.patikadev.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnetor {

    private Connection connect ;
    public Connection connectDB(){
        try {
            this.connect = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.connect;
    }

    public static Connection getInstance(){
        DBConnetor db = new DBConnetor();
        return db.connectDB();
    }
}
