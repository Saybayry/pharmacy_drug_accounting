package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
    public static Connection getConnection() throws SQLException, IOException {
        Properties props = ConfigLoader.loadConfig("config.txt");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String dburl = props.getProperty("dburl");
        return DriverManager.getConnection(dburl, user, password);
    }

}

