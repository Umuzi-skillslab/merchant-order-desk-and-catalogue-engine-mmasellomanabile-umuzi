package paynestsystem.app;

import paynestsystem.domain.*;
import paynestsystem.service.OrderService;

public class PaynestApplication {
    public static void main(String[] args) {
        //Products sample:
        Product prod1 = new Product(1,  "Headsets", 1000);
        Product prod2 = new Product(2, "Keyboard", 300);

        //Customer sample:
        Customer customer = new Customer(1, "Maxine Sibanda", "maxineS@umuzi.org");
        Customer customer2= new Customer(2, "Lucky Fish", "lucky.fish@gmail.com");

        //order sample:
        Order order = new Order(1,customer);

        // add items:

        order.addItem (prod1, 2);
        order.addItem (prod2, 1);

        //summary:
        order.printSummary ();
    }
}


