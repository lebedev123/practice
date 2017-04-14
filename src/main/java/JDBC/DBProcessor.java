package JDBC;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBProcessor {
    private Connection connection;
    public DBProcessor() throws SQLException {
        DriverManager.registerDriver(new FabricMySQLDriver());
    }
    public Connection getConnection(String URL, String username, String password) throws SQLException {
        if(connection!=null){
            return connection;
        }
        connection = DriverManager.getConnection(URL,username,password);
        return connection;
    }

}
