package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String username = "root";
    private static final String password = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public static void main(String[] args) throws SQLException {
        DBProcessor processor = new DBProcessor();
        Connection connection = processor.getConnection(URL,username,password);
        String query = "select * from company.product";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while(resultSet.next()){
            int id;
            String name;
            double price;
            int shopID;
            id = resultSet.getInt("product_id");
            name = resultSet.getString("description");
            price = resultSet.getDouble("price");
            shopID = resultSet.getInt("shop_id");
            Product product = new Product(id,name,price,shopID);
            System.out.println(product.toString());
        }
        statement.close();
        connection.close();

    }
}
