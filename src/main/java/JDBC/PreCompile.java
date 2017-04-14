package JDBC;

import java.sql.*;

public class PreCompile {
    private static final String username = "root";
    private static final String password = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public static void main(String[] args) throws SQLException {
        DBProcessor processor = new DBProcessor();
        Connection connection = processor.getConnection(URL,username,password);
        String query = "select * from company.products where product_id=?";
        PreparedStatement prepare = connection.prepareStatement(query);
        prepare.setInt(1,2);
        ResultSet set = prepare.executeQuery();
        while(set.next()){
            System.out.println("ID = " + set.getInt("product_id") + " name = " + set.getString("product_name"));
        }
    }}
