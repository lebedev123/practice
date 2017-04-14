package JDBC;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class test {
    private static final String username = "root";
    private static final String password = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Ошибка регистрации");
        }
        try (Connection connection = DriverManager.getConnection(URL, username, password);
             Statement statement = connection.createStatement()) {
            statement.execute("use company");
            ResultSet s = statement.executeQuery("select * from products");
        }catch (SQLException ex){
            System.out.println("Ошибка запроса");
        }

    }
}
