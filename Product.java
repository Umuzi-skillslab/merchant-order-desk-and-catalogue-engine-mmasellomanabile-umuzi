//Product catalogue
//1.Product class

import java.util.List;

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

//2.Customer class- using the same process I used above:

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

//3. Order lifecycle:

class Order {
    private int id;
    private Customer customer;
    private List<OrderItem> items; //copied from instructions 

    //trying to acheive this step by using the constructor from Products
    public Order(int id, Customer customer){  //Not sure how to add the order item list
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>();
    }


    //created addItem as per instructions:

    /*Started here- too many errors: 

    public void addItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct () {
        return product;
    }
    
    */

    public void addItem(Product product, int quantity){
        items.add(new OrderItem(product,quantity));
    }

    public String calculateTotal() {

        int total = 0; 
        
        for (OrderItem item : items) {
        total += item.calcTotal();
    }

     
}

//4. orderItem class: 

class OrderItem {
    private Product product;
    private int quantity;

    
    public Product getProduct() {
    return product;
    }

    public int getQuantity() {
    return quantity;
    }


    public double calcTotal() {
        return product.getPrice()*quantity;
    }
}

