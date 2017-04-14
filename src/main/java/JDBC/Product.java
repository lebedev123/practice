package JDBC;

public class Product {
    private int id;
    private String name;
    private double price;
    private int shopID;

    public Product() {

    }

    public Product(int id, String name, double price, int shopID) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.shopID = shopID;
    }

    public String toString() {
        return "Productid = " + id + "\t" + " name= " + name + "\t" + price + " usd " + "\t" + " in shop "+shopID;
    }

}
