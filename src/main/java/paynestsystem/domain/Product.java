package paynestsystem.domain;
//Product catalogue
//1.Product class

public class Product {
    private int id;
    private String name;
    private double price;

    //here is my constructor:

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //getter stuff:

    public int getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public double getPrice () {
        return price;
    }
}

