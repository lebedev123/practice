package JDBC;

import java.sql.*;
import java.util.concurrent.Exchanger;
import java.util.logging.Logger;

public class Db {


    public static void main(String[] args) {
        Connection connection = null;
        String URL = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver connected");
            if(connection==null){
                connection = DriverManager.getConnection(URL,username,password);
            }
            System.out.println("Connection is okay");
            Statement st = connection.createStatement();
            st.execute("USE company");
            PreparedStatement statement = connection.prepareStatement(" SELECT * FROM product where product_id=?");
            statement.setInt(1, 1);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id;
                int price;
                int shopID;
                String name;
                id = resultSet.getInt("product_id");
                name = resultSet.getString("description");
                price = resultSet.getInt("price");
                shopID = resultSet.getInt("shop_id");
                System.out.println("product info : " + id + " " + name + " " + price + " " + shopID);
            }
        } catch (Exception ex) {
            Logger.getLogger("Error");
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }


}

