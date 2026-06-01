import java.util.*;
//3. Order lifecycle:

public class Order {
    private int id;
    private Customer customer;
    private List<OrderItem> items;

    public Order(int id, Customer customer){
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public int getId (){
        return id;
    }
    public Customer getCustomer () {
        return customer;
    }

    public void addItem(Product product, int quantity){
        if (quantity <= 0) {
            System.out.println("Please add an item");
            return;
        }
        items.add(new OrderItem(product, quantity));
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.calcTotal();
        }
        return total;
    }

//print summary:

    public void printSummary() {
        System.out.println("Order Summary:");
        System.out.println("Customer: " + customer.getName());

        for (OrderItem item : items) {
            String name = item.getProduct().getName();
            int qty = item.getQuantity();
            double subtotal = item.calcTotal();

            System.out.println(name + " x" + qty + " = R" + subtotal);
        }

        System.out.println("Your total is: R" + calculateTotal());
    }
}


//Order summary method:

 public void printSummary() {
    System.out.println("Order Summary:");
    System.out.println("Customer: " + customer.getName());

    
    for (OrderItem item : items) {
        String name = item.getProduct().getName();
        int qty = item.getQuantity();
        double subtotal = item.calcTotal();

        System.out.println(name + " x" + qty + " = R" + subtotal);
 }

 System.out.println(" Your total is: R" + calculateTotal());
}
