//Product catalogue
//Product class
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

//Customer class- using the same process I used above:

class Customer {
    private int id;
    private String name;
    private String email;

   public Customer (int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId () {
        return id;
    }
    public String getName () {
        return name;
    }

    public String getEmail () {
        return email;
    }

}
